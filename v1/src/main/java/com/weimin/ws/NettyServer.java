package com.weimin.ws;

import com.weimin.ws.handler.NettyReadTimeoutHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author weimin
 * @ClassName NettyServer
 * @Description TODO
 * @date 2019/12/31 12:29
 */
@Component
@Slf4j
public class NettyServer implements CommandLineRunner {

    /**TODO 定义主线程组,处理连接请求*/
    private EventLoopGroup bossGroup;
    /**TODO 定义从线程组,处理具体任务，具体的IO操作*/
    private EventLoopGroup workerGroup;
    /**TODO 定义netty服务启动类对象*/
    private ServerBootstrap serverBootstrap;


    /**
     * TODO 启动netty服务器
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        bossGroup= new NioEventLoopGroup();
        workerGroup=new NioEventLoopGroup();
        serverBootstrap= new ServerBootstrap();
        this.serverBootstrap.group(bossGroup, workerGroup)
                //5.设置NIO的双向通道
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new HttpServerCodec());
                        pipeline.addLast(new ChunkedWriteHandler());
                        pipeline.addLast(new HttpObjectAggregator(1024 * 32));
                        pipeline.addLast(new WebSocketServerProtocolHandler("/websocket"));
                        pipeline.addLast(new NettyReadTimeoutHandler(10, TimeUnit.MINUTES));
                    }
                });
        this.serverBootstrap.bind(8888).sync();
        log.info("Netty start port 8888");
    }
}
