package com.tencent.p177mm.plugin.appbrand.jsapi.websocket;

import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Timer;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.e */
public interface C27135e {
    public static final String hvr = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.e$a */
    public interface C27134a {
        /* renamed from: BB */
        void mo44794BB(String str);

        /* renamed from: K */
        void mo44795K(int i, String str);

        /* renamed from: a */
        void mo44796a(C38514a c38514a);

        /* renamed from: b */
        void mo44797b(C16696h c16696h);

        /* renamed from: l */
        void mo44798l(ByteBuffer byteBuffer);

        /* renamed from: zJ */
        void mo44799zJ(String str);
    }

    /* renamed from: BT */
    void mo44800BT(String str);

    /* renamed from: BU */
    void mo44801BU(String str);

    /* renamed from: a */
    void mo34732a(C27134a c27134a);

    /* renamed from: a */
    void mo44802a(Socket socket);

    /* renamed from: a */
    void mo44803a(Timer timer);

    String aBA();

    Timer aGo();

    /* renamed from: bk */
    void mo44806bk(String str, int i);

    void close();

    void connect();

    Socket getSocket();

    boolean isOpen();

    /* renamed from: p */
    void mo44811p(ByteBuffer byteBuffer);

    void setTcpNoDelay(boolean z);
}
