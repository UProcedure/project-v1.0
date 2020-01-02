package com.weimin.ws.handler;

import com.weimin.util.ChannelUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author weimin
 * @ClassName NettyReadTimeoutHandler
 * @Description TODO
 * @date 2020/1/2 8:57
 */
@Slf4j
public class NettyReadTimeoutHandler extends ReadTimeoutHandler {


    public NettyReadTimeoutHandler(long timeout, TimeUnit unit) {
        super(timeout, unit);
    }

    @Override
    protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
        super.readTimedOut(ctx);
        ChannelUtils.remove(ctx.channel());
        log.info("[{}] 断开连接",ctx.channel().remoteAddress());
    }
}
