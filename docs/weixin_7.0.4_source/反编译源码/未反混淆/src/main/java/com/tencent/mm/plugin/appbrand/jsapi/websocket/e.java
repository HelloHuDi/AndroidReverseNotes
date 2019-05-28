package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.t.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Timer;

public interface e {
    public static final String hvr = null;

    public interface a {
        void BB(String str);

        void K(int i, String str);

        void a(com.tencent.mm.plugin.appbrand.t.e.a aVar);

        void b(h hVar);

        void l(ByteBuffer byteBuffer);

        void zJ(String str);
    }

    void BT(String str);

    void BU(String str);

    void a(a aVar);

    void a(Socket socket);

    void a(Timer timer);

    String aBA();

    Timer aGo();

    void bk(String str, int i);

    void close();

    void connect();

    Socket getSocket();

    boolean isOpen();

    void p(ByteBuffer byteBuffer);

    void setTcpNoDelay(boolean z);
}
