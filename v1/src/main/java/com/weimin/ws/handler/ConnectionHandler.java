package com.weimin.ws.handler;

import cn.hutool.json.JSONUtil;
import com.weimin.entity.Message;
import com.weimin.util.ChannelUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author weimin
 * @ClassName ConnectionHandler
 * @Description TODO
 * @date 2020/1/2 15:14
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class ConnectionHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    /**
     * TODO 处理连接请求，1 代表连接 0 代表心跳
     * @param channelHandlerContext
     * @param textWebSocketFrame
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) {
        try {
            Message message = JSONUtil.toBean(textWebSocketFrame.text(), Message.class);
            Channel channel = channelHandlerContext.channel();
            if (Message.ONE.equals(message.getTypeId())) {
                String userId = (String) message.getData();
                ChannelUtils.add(userId, channel);
                log.info("Netty: [{}] 连接--->地址[{}]", userId, channel.remoteAddress());
            }
        }catch (IllegalArgumentException e){
            log.error("Netty 消息转换异常");
            return;
        }catch (Exception e){
            log.error("Netty 连接异常[{}]",e.getMessage());
            return;
        }
    }
}
