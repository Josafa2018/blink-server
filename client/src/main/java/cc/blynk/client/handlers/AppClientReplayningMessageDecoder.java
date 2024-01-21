package cc.blynk.client.handlers;

import cc.blynk.client.handlers.decoders.AppClientMessageDecoder;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

public class AppClientReplayningMessageDecoder extends AppClientMessageDecoder {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        throw new IOException("Server closed client connection.");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //server goes down
        if (cause instanceof IOException) {
            ctx.close();
            log.error("Client socket closed. Reason : {}", cause.getMessage());
            //todo find better way
            System.exit(0);
        }
    }
}
