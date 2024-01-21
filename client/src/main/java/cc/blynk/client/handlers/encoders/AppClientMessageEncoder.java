package cc.blynk.client.handlers.encoders;

import cc.blynk.server.core.protocol.model.messages.MessageBase;
import cc.blynk.server.core.protocol.model.messages.ResponseMessage;
import cc.blynk.server.core.stats.GlobalStats;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class AppClientMessageEncoder extends MessageToByteEncoder<MessageBase> {

    private final GlobalStats stats;

    public AppClientMessageEncoder(GlobalStats stats) {
        this.stats = stats;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageBase msg, ByteBuf out) throws Exception {
        out.writeByte(msg.command);
        out.writeShort(msg.id);

        if (msg instanceof ResponseMessage) {
            out.writeShort(((ResponseMessage) msg).code);
        } else {
            stats.mark(msg.command);

            byte[] body = msg.getBytes();
            out.writeInt(body.length);
            if (body.length > 0) {
                out.writeBytes(body);
            }
        }
    }

}
