package app.service;


import app.models.*;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSession;
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
                .handler(enterhandler)
                .end()
                .rule()
                .async(false)
                .content("菜单")
                .handler(enterhandler)
                .end()
                .rule()
                .async(false)
                .msgType(WxConsts.XML_MSG_TEXT)
                .handler(texthandeler)
                .end()
                .rule()
                .async(false)
                .msgType(WxConsts.XML_MSG_VOICE)
                .handler(restHandler)
                .end()
                .rule()
                .async(false)
                .handler(restHandler)
                .end();

    }

    WxMpMessageHandler texthandeler = new WxMpMessageHandler() {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
            WxMpXmlOutTextMessage tmessage
                    = WxMpXmlOutMessage.TEXT()
                    .fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName())
                    .build();
            try {
                WxSession session = wxSessionManager.getSession(wxMpXmlMessage.getFromUserName());
                if (session.getAttribute("status").equals("choice")) {
                    try {
                        int oper = Integer.valueOf(wxMpXmlMessage.getContent());
                        if (oper > 0 && oper < 8) {
                            if (session.getAttribute("Identification").equals(2)) {

                                switch (Integer.valueOf(wxMpXmlMessage.getContent())) {
                                    case 1:
                                        session.setAttribute("status", "choice1");
                                        tmessage.setContent("请输入分销商姓名和手机号，中间用逗号隔开");
                                        break;
                                    case 2:
                                        tmessage.setContent("2");
                                        break;
                                    case 3:
                                        tmessage.setContent("3");
                                        break;
                                    case 4:
                                        tmessage.setContent("4");
                                        break;
                                    case 5:
                                        tmessage.setContent("5");
                                        break;
                                    case 6:
                                        tmessage.setContent("6");
                                        break;
                                    case 7:
                                        tmessage.setContent("7");
                                        break;
                                    default:
                                        return menuhandle(wxMpXmlMessage, wxSessionManager);
                                }

                            } else if (session.getAttribute("Identification").equals(1)) {

                                switch (Integer.valueOf(wxMpXmlMessage.getContent())) {
                                    case 1:
                                        session.setAttribute("status", "choice1");
                                        tmessage.setContent("请输入查询商品名称");
                                        break;
                                    case 2:
                                        tmessage.setContent("2");
                                        break;
                                    default:
                                        return menuhandle(wxMpXmlMessage, wxSessionManager);
                                }
                            }else if (session.getAttribute("Identification").equals(0)) {
                                switch (Integer.valueOf(wxMpXmlMessage.getContent())) {
                                    case 1:
                                        session.setAttribute("status", "choice1");
                                        tmessage.setContent("请输入认证码");
                                        break;
                                    case 2:
                                        session.setAttribute("status", "choice2");
                                        tmessage.setContent("请输入认证码");
                                        break;
                                    default:
                                        return menuhandle(wxMpXmlMessage, wxSessionManager);
                                }
                            }
                        } else {
                            return menuhandle(wxMpXmlMessage, wxSessionManager);
                        }
                    } catch (NumberFormatException e) {
                        return menuhandle(wxMpXmlMessage, wxSessionManager);
                    }
                } else if (session.getAttribute("status").equals("choice1")) {
                    if (session.getAttribute("Identification").equals(2)) {
                        String[] contents = wxMpXmlMessage.getContent().split(",");



                    } else if (session.getAttribute("Identification").equals(1)) {

                    } else if (session.getAttribute("Identification").equals(0)) {

                    }
                } else {
                    return menuhandle(wxMpXmlMessage, wxSessionManager);
                }
            } catch (Exception e) {
                return menuhandle(wxMpXmlMessage, wxSessionManager);
            }
            return tmessage;
        }
    };

    WxMpMessageHandler enterhandler = new WxMpMessageHandler() {
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {

            return menuhandle(wxMpXmlMessage, wxSessionManager);
        }
    };

    public WxMpXmlOutMessage menuhandle(WxMpXmlMessage wxMpXmlMessage, WxSessionManager wxSessionManager) throws WxErrorException {

        //识别用户身份
        RestTemplate restTemplate = new RestTemplate();
        IdentifyUserStatus identifyUserStatus = restTemplate.getForObject("http://localhost:8091/User/IdentifyUser?OpenId=" + wxMpXmlMessage.getFromUserName(), IdentifyUserStatus.class);
        System.out.println(identifyUserStatus.toString());

        WxMpXmlOutTextMessage emessage
                = WxMpXmlOutMessage.TEXT()
                .fromUser(wxMpXmlMessage.getToUserName())
                .toUser(wxMpXmlMessage.getFromUserName())
                .build();
        if (identifyUserStatus.getMsgCode().equals("1")) {

            if (identifyUserStatus.getResult().getIdentification() == 1) {
                emessage.setContent("1、查询商品信息\n2、进货管理");
            } else if (identifyUserStatus.getResult().getIdentification() == 2) {
                emessage.setContent("1、增加分销商\n2、增加管理员\n3、货物入库\n4、仓库信息修改\n5、查询订单\n6、确认订单\n7、查询商品信息");
            }
        } else if (identifyUserStatus.getMsgCode().equals("0")) {
            emessage.setContent("欢迎你关注本公众号！\n" +
                    "1、管理员认证\n" +
                    "2、经销商认证");
        } else {
            emessage.setContent("未知错误请稍后重试！！！");
        }
        WxSession session = wxSessionManager.getSession(wxMpXmlMessage.getFromUserName());
        session.setAttribute("status", "choice");
        session.setAttribute("Identification", identifyUserStatus.getResult().getIdentification());
        System.out.println(session.getAttribute(wxMpXmlMessage.getFromUserName()));
        return emessage;
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
