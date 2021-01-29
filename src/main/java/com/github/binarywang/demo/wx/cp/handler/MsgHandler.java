package com.github.binarywang.demo.wx.cp.handler;

import com.github.binarywang.demo.wx.cp.builder.TextBuilder;
import com.github.binarywang.demo.wx.cp.utils.ApacheHttpTool;
import com.github.binarywang.demo.wx.cp.utils.JsonUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.message.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Override
    public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
                                    WxSessionManager sessionManager) {
        final String msgType = wxMessage.getMsgType();
        System.out.println("======wxMessage======" + JsonUtils.toJson(wxMessage));
        System.out.println("======context======" + JsonUtils.toJson(context));
        if (msgType == null) {
            // 如果msgType没有，就自己根据具体报文内容做处理
        }

        if (!msgType.equals(WxConsts.XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        try {
            String content = wxMessage.getContent();
            String[] dailySales = content.split(" ");
            String url = "http://127.0.0.1:8081/manager/dailySales/updateDailySales";
            Map<String, String> params = new HashMap<>();
            params.put("wxCard", wxMessage.getFromUserName());
            params.put("dailyProfit", dailySales[0]);
            params.put("dailyAmount", dailySales[1]);
            params.put("type", "1");
            ApacheHttpTool.httpPostWithForm(url, new HashMap<>(), params);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new TextBuilder().build("success", wxMessage, cpService);

    }

}
