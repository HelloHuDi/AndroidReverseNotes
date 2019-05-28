package com.tencent.mm.plugin.appbrand.l;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

public final class k implements d {
    private SSLSocketFactory hkw;
    private final String ibJ;
    private int ibK;
    protected final ArrayList<e> ich = new ArrayList();
    private boolean ipd;

    public interface b {
        void K(int i, String str);

        void azg();

        void azh();

        void l(ByteBuffer byteBuffer);

        void zJ(String str);

        void zK(String str);
    }

    public interface c {
        boolean auB();

        boolean xj(String str);
    }

    public interface a {
        void d(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str);

        void e(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str);
    }

    static /* synthetic */ void g(e eVar) {
        AppMethodBeat.i(108235);
        e(eVar);
        AppMethodBeat.o(108235);
    }

    public k(a aVar) {
        AppMethodBeat.i(108223);
        SSLContext a = j.a(aVar);
        if (a != null) {
            this.hkw = a.getSocketFactory();
        }
        this.ibJ = aVar.ioo;
        this.ibK = aVar.iok;
        this.ipd = aVar.bQC;
        ab.i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", Boolean.valueOf(this.ipd));
        AppMethodBeat.o(108223);
    }

    /* JADX WARNING: Missing block: B:9:0x0046, code skipped:
            r8 = r17.optString("url");
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            r4 = new java.net.URI(r8);
     */
    /* JADX WARNING: Missing block: B:12:0x0054, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", r8, java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r17.optBoolean("tcpNoDelay", false)), r14);
            r18.put("User-Agent", r12.ibJ);
            r2 = com.tencent.mm.plugin.appbrand.l.j.G(r17);
     */
    /* JADX WARNING: Missing block: B:13:0x0090, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2) != false) goto L_0x00a9;
     */
    /* JADX WARNING: Missing block: B:14:0x0092, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", r2);
            r18.put("Sec-WebSocket-Protocol", r2);
     */
    /* JADX WARNING: Missing block: B:15:0x00a9, code skipped:
            r2 = com.tencent.mm.plugin.appbrand.l.j.a(r4);
     */
    /* JADX WARNING: Missing block: B:16:0x00b1, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Missing block: B:17:0x00b3, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", r2);
            r18.put("Origin", r2);
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r9 = r14;
            r10 = r19;
            r2 = new com.tencent.mm.plugin.appbrand.l.k.AnonymousClass1(r12, r4, new com.tencent.mm.plugin.appbrand.t.b.d(), r18, r16);
            r2.BT(r14);
            r2.setTcpNoDelay(r11);
     */
    /* JADX WARNING: Missing block: B:20:0x00e9, code skipped:
            if (com.tencent.mm.plugin.appbrand.s.r.t(r8, "ws://") == false) goto L_0x016e;
     */
    /* JADX WARNING: Missing block: B:21:0x00eb, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", r8);
            r2.a(new java.net.Socket(java.net.Proxy.NO_PROXY));
            r2.connect();
            c(r2);
            r3 = new java.util.Timer();
            r0 = r19;
            r4 = new com.tencent.mm.plugin.appbrand.l.k.AnonymousClass2(r12);
            r2.a(r3);
            r3.schedule(r4, (long) r16);
            com.tencent.matrix.trace.core.AppMethodBeat.o(108224);
     */
    /* JADX WARNING: Missing block: B:22:0x0127, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0128, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", r2, "Exception: url %s", r8);
            r19.zJ(r2.getMessage());
            com.tencent.matrix.trace.core.AppMethodBeat.o(108224);
     */
    /* JADX WARNING: Missing block: B:28:0x0151, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x0152, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", r2, "Exception: connect fail", new java.lang.Object[0]);
            r19.zK("url not well format");
            com.tencent.matrix.trace.core.AppMethodBeat.o(108224);
     */
    /* JADX WARNING: Missing block: B:32:0x0175, code skipped:
            if (com.tencent.mm.plugin.appbrand.s.r.t(r8, "wss://") == false) goto L_0x01de;
     */
    /* JADX WARNING: Missing block: B:33:0x0177, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", r8);
     */
    /* JADX WARNING: Missing block: B:34:0x0188, code skipped:
            if (r12.hkw == null) goto L_0x01d7;
     */
    /* JADX WARNING: Missing block: B:35:0x018a, code skipped:
            r3 = r12.hkw;
     */
    /* JADX WARNING: Missing block: B:36:0x018c, code skipped:
            r2.a(r3.createSocket());
     */
    /* JADX WARNING: Missing block: B:37:0x019a, code skipped:
            if (r13.equals("wx577c74fb940daaea") != false) goto L_0x01a5;
     */
    /* JADX WARNING: Missing block: B:39:0x01a3, code skipped:
            if (r13.equals("wx850d691fd02de8a1") == false) goto L_0x01b4;
     */
    /* JADX WARNING: Missing block: B:40:0x01a5, code skipped:
            r3 = (javax.net.ssl.SSLSocket) r2.getSocket();
            r4 = r3.getSupportedCipherSuites();
     */
    /* JADX WARNING: Missing block: B:41:0x01af, code skipped:
            if (r4 == null) goto L_0x01b4;
     */
    /* JADX WARNING: Missing block: B:42:0x01b1, code skipped:
            r3.setEnabledCipherSuites(r4);
     */
    /* JADX WARNING: Missing block: B:43:0x01b4, code skipped:
            r2.connect();
            c(r2);
            r3 = new java.util.Timer();
            r0 = r19;
            r4 = new com.tencent.mm.plugin.appbrand.l.k.AnonymousClass3(r12);
            r2.a(r3);
            r3.schedule(r4, (long) r16);
            com.tencent.matrix.trace.core.AppMethodBeat.o(108224);
     */
    /* JADX WARNING: Missing block: B:44:0x01d7, code skipped:
            r3 = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
     */
    /* JADX WARNING: Missing block: B:45:0x01de, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", r8);
            r19.zK("url not ws or wss");
     */
    /* JADX WARNING: Missing block: B:46:0x01f5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(108224);
     */
    /* JADX WARNING: Missing block: B:51:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:52:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, String str2, int i, int i2, JSONObject jSONObject, Map<String, String> map, com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a aVar) {
        AppMethodBeat.i(108224);
        synchronized (this.ich) {
            try {
                if (this.ich.size() >= this.ibK) {
                    aVar.zK("max connected");
                    ab.i("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", Integer.valueOf(this.ich.size()), Integer.valueOf(this.ibK));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108224);
            }
        }
    }

    private void c(e eVar) {
        AppMethodBeat.i(108225);
        synchronized (this.ich) {
            try {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(eVar.aBA())) {
                    this.ich.clear();
                }
                this.ich.add(eVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108225);
            }
        }
    }

    private synchronized void d(e eVar) {
        AppMethodBeat.i(108226);
        if (eVar == null) {
            AppMethodBeat.o(108226);
        } else {
            int i;
            synchronized (this.ich) {
                try {
                    i = this.ich;
                    i.remove(eVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108226);
                }
            }
            AppMethodBeat.o(i);
        }
    }

    public final void a(e eVar) {
        AppMethodBeat.i(108227);
        if (eVar != null) {
            try {
                ab.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                eVar.close();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e, "Exception: send error", new Object[0]);
                e(eVar);
            }
            d(eVar);
        }
        AppMethodBeat.o(108227);
    }

    public final void a(e eVar, int i, String str) {
        AppMethodBeat.i(108228);
        if (eVar != null) {
            try {
                ab.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                eVar.bk(str, i);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e, "Exception: send error", new Object[0]);
            }
            d(eVar);
        }
        AppMethodBeat.o(108228);
    }

    public final boolean b(e eVar) {
        AppMethodBeat.i(108229);
        if (eVar != null) {
            boolean isOpen = eVar.isOpen();
            AppMethodBeat.o(108229);
            return isOpen;
        }
        AppMethodBeat.o(108229);
        return false;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(108230);
        if (eVar != null) {
            eVar.BU(str);
        }
        AppMethodBeat.o(108230);
    }

    public final void a(e eVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(108231);
        eVar.p(byteBuffer);
        AppMethodBeat.o(108231);
    }

    public final void release() {
        AppMethodBeat.i(108232);
        a(BS(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(108232);
    }

    private static void e(e eVar) {
        AppMethodBeat.i(108233);
        if (eVar == null) {
            AppMethodBeat.o(108233);
            return;
        }
        Timer aGo = eVar.aGo();
        ab.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
        if (aGo != null) {
            aGo.cancel();
            eVar.a(null);
        }
        AppMethodBeat.o(108233);
    }

    public final e BS(String str) {
        e eVar;
        AppMethodBeat.i(108234);
        if (str == null) {
            AppMethodBeat.o(108234);
            return null;
        }
        synchronized (this.ich) {
            try {
                Iterator it = this.ich.iterator();
                while (it.hasNext()) {
                    eVar = (e) it.next();
                    if (str.equals(eVar.aBA())) {
                    }
                }
                AppMethodBeat.o(108234);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108234);
            }
        }
        return eVar;
    }
}
