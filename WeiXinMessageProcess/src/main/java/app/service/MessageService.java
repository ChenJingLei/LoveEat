package app.service;

import app.models.WeiXinConfig;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutVoiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        WxMpMessageHandler handler = new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                WxMpXmlOutTextMessage message
                        = WxMpXmlOutMessage.TEXT().content("测试加密消息")
                        .fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName())
                        .build();
                return message;
            }
        };

        WxMpMessageHandler handler1 = new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                System.out.println(wxMpXmlMessage.getRecognition());
                WxMpXmlOutTextMessage message
                        = WxMpXmlOutMessage.TEXT().content(wxMpXmlMessage.getRecognition())
                        .fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName())
                        .build();
                return message;
            }
        };

        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        wxMpMessageRouter
                .rule()
                .async(false)
                .content("哈哈") // 拦截内容为“哈哈”的消息
                .handler(handler)
                .end()
                .rule()
                .async(false)
                .msgType(WxConsts.XML_MSG_VOICE)
                .handler(handler1)
                .end();
    }

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
