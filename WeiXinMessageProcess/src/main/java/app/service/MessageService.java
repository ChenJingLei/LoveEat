package app.service;


import app.models.*;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by cjl20 on 2016/1/2.
 */
@Service
public class MessageService {

    private WxMpInMemoryConfigStorage wxMpConfigStorage;
    private WxMpService wxMpService;
    private WxMpMessageRouter wxMpMessageRouter;

    @Autowired
    private WeiXinConfig weiXinConfig;

    @PostConstruct
    public void init() {
        System.out.println("init");
        wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(weiXinConfig.getAppid()); // 设置微信公众号的appid
        wxMpConfigStorage.setSecret(weiXinConfig.getAppsecret()); // 设置微信公众号的app corpSecret
        wxMpConfigStorage.setToken(weiXinConfig.getToken()); // 设置微信公众号的token
        wxMpConfigStorage.setAesKey(weiXinConfig.getEncodingaeskey()); // 设置微信公众号的EncodingAESKey

        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);




        WxMpMessageHandler voiceHandle = new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                WxMpXmlOutTextMessage message = null;
                if (wxMpXmlMessage.getRecognition().contains("菜单")) {
                    message = WxMpXmlOutMessage.TEXT().content("欢迎你关注本公众号！\n1、管理员认证\n2、经销商认证")
                            .fromUser(wxMpXmlMessage.getToUserName())
                            .toUser(wxMpXmlMessage.getFromUserName())
                            .build();
                }
                return message;
            }
        };

        WxMpMessageHandler subscribeHandler = new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                WxMpXmlOutTextMessage message
                        = WxMpXmlOutMessage.TEXT().content("欢迎你关注本公众号！\n1、管理员认证\n2、经销商认证")
                        .fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName())
                        .build();
                return message;
            }
        };

        WxMpMessageHandler restHandler = new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                WxMpXmlOutTextMessage message
                        = WxMpXmlOutMessage.TEXT().content("未支持的消息类型")
                        .fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName())
                        .build();
//                RestTemplate restTemplate = new RestTemplate();
//
//                ManageUser manageUser = new ManageUser("陈靖磊","13004165668");
//
//                UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8091/ManageUser/addManageUser", manageUser, UpdateUserStatus.class);
//                System.out.println(updateUserStatus.toString());

                return message;
            }
        };


        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        wxMpMessageRouter
                .rule()
                .async(false)
                .msgType(WxConsts.XML_MSG_EVENT)
                .event(WxConsts.EVT_SUBSCRIBE)
                .handler(subscribeHandler)
                .end()
                .rule()
                .async(false)
                .content("菜单")
                .handler(handler)
                .end()
                .rule()
                .async(false)
                .msgType(WxConsts.XML_MSG_VOICE)
                .handler(voiceHandle)
                .end()
                .rule()
                .async(false)
                .handler(restHandler)
                .end();

    }

    WxMpMessageHandler handler = new WxMpMessageHandler() {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {

            //识别用户身份
            RestTemplate restTemplate = new RestTemplate();

            ManageUser manageUser = new ManageUser("陈靖磊", "13004165668");

            UpdateUserStatus updateUserStatus = restTemplate.postForObject("http://localhost:8091/ManageUser/addManageUser", manageUser, UpdateUserStatus.class);
            System.out.println(updateUserStatus.toString());


            WxMpXmlOutTextMessage emessage
                    = WxMpXmlOutMessage.TEXT().content("1、增加经销商\n+2、增加管理员")
                    .fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName())
                    .build();
            return emessage;
        }
    };



    public WxMpInMemoryConfigStorage getWxMpConfigStorage() {
        return wxMpConfigStorage;
    }

    public WxMpService getWxMpService() {
        return wxMpService;
    }

    public WxMpMessageRouter getWxMpMessageRouter() {
        return wxMpMessageRouter;
    }

}
