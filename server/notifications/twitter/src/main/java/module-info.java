/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 29.09.17.
 */
module cc.blynk.server.notifications.twitter {
    requires async.http.client;
    requires cc.blynk.utils;
    requires io.netty.codec.http;
    requires io.netty.transport;
    requires org.slf4j;

    exports cc.blynk.server.notifications.twitter;
}