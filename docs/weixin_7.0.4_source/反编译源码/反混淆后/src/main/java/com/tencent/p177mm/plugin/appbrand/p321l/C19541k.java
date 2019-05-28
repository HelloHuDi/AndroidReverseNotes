package com.tencent.p177mm.plugin.appbrand.p321l;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d.C10563a;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C27135e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.l.k */
public final class C19541k implements C10562d {
    private SSLSocketFactory hkw;
    private final String ibJ;
    private int ibK;
    protected final ArrayList<C27135e> ich = new ArrayList();
    private boolean ipd;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.k$b */
    public interface C19543b {
        /* renamed from: K */
        void mo34734K(int i, String str);

        void azg();

        void azh();

        /* renamed from: l */
        void mo34737l(ByteBuffer byteBuffer);

        /* renamed from: zJ */
        void mo34738zJ(String str);

        /* renamed from: zK */
        void mo34739zK(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.k$c */
    public interface C19544c {
        boolean auB();

        /* renamed from: xj */
        boolean mo21412xj(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.k$a */
    public interface C19545a {
        /* renamed from: d */
        void mo34740d(C2241c c2241c, String str);

        /* renamed from: e */
        void mo34741e(C2241c c2241c, String str);
    }

    /* renamed from: g */
    static /* synthetic */ void m30290g(C27135e c27135e) {
        AppMethodBeat.m2504i(108235);
        C19541k.m30289e(c27135e);
        AppMethodBeat.m2505o(108235);
    }

    public C19541k(C38414a c38414a) {
        AppMethodBeat.m2504i(108223);
        SSLContext a = C19538j.m30268a(c38414a);
        if (a != null) {
            this.hkw = a.getSocketFactory();
        }
        this.ibJ = c38414a.ioo;
        this.ibK = c38414a.iok;
        this.ipd = c38414a.bQC;
        C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", Boolean.valueOf(this.ipd));
        AppMethodBeat.m2505o(108223);
    }

    /* JADX WARNING: Missing block: B:9:0x0046, code skipped:
            r8 = r17.optString("url");
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            r4 = new java.net.URI(r8);
     */
    /* JADX WARNING: Missing block: B:12:0x0054, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", r8, java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r17.optBoolean("tcpNoDelay", false)), r14);
            r18.put("User-Agent", r12.ibJ);
            r2 = com.tencent.p177mm.plugin.appbrand.p321l.C19538j.m30264G(r17);
     */
    /* JADX WARNING: Missing block: B:13:0x0090, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2) != false) goto L_0x00a9;
     */
    /* JADX WARNING: Missing block: B:14:0x0092, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", r2);
            r18.put("Sec-WebSocket-Protocol", r2);
     */
    /* JADX WARNING: Missing block: B:15:0x00a9, code skipped:
            r2 = com.tencent.p177mm.plugin.appbrand.p321l.C19538j.m30266a(r4);
     */
    /* JADX WARNING: Missing block: B:16:0x00b1, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Missing block: B:17:0x00b3, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", r2);
            r18.put("Origin", r2);
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r9 = r14;
            r10 = r19;
            r2 = new com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C195421(r12, r4, new com.tencent.p177mm.plugin.appbrand.p332t.p334b.C6787d(), r18, r16);
            r2.mo44800BT(r14);
            r2.setTcpNoDelay(r11);
     */
    /* JADX WARNING: Missing block: B:20:0x00e9, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.p329s.C19721r.m30533t(r8, "ws://") == false) goto L_0x016e;
     */
    /* JADX WARNING: Missing block: B:21:0x00eb, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", r8);
            r2.mo44802a(new java.net.Socket(java.net.Proxy.NO_PROXY));
            r2.connect();
            m30287c(r2);
            r3 = new java.util.Timer();
            r0 = r19;
            r4 = new com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C105712(r12);
            r2.mo44803a(r3);
            r3.schedule(r4, (long) r16);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108224);
     */
    /* JADX WARNING: Missing block: B:22:0x0127, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0128, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", r2, "Exception: url %s", r8);
            r19.mo22069zJ(r2.getMessage());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108224);
     */
    /* JADX WARNING: Missing block: B:28:0x0151, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x0152, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", r2, "Exception: connect fail", new java.lang.Object[0]);
            r19.mo22070zK("url not well format");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108224);
     */
    /* JADX WARNING: Missing block: B:32:0x0175, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.p329s.C19721r.m30533t(r8, "wss://") == false) goto L_0x01de;
     */
    /* JADX WARNING: Missing block: B:33:0x0177, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", r8);
     */
    /* JADX WARNING: Missing block: B:34:0x0188, code skipped:
            if (r12.hkw == null) goto L_0x01d7;
     */
    /* JADX WARNING: Missing block: B:35:0x018a, code skipped:
            r3 = r12.hkw;
     */
    /* JADX WARNING: Missing block: B:36:0x018c, code skipped:
            r2.mo44802a(r3.createSocket());
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
            m30287c(r2);
            r3 = new java.util.Timer();
            r0 = r19;
            r4 = new com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C105723(r12);
            r2.mo44803a(r3);
            r3.schedule(r4, (long) r16);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108224);
     */
    /* JADX WARNING: Missing block: B:44:0x01d7, code skipped:
            r3 = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
     */
    /* JADX WARNING: Missing block: B:45:0x01de, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", r8);
            r19.mo22070zK("url not ws or wss");
     */
    /* JADX WARNING: Missing block: B:46:0x01f5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108224);
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
    /* renamed from: a */
    public final void mo22061a(String str, String str2, int i, int i2, JSONObject jSONObject, Map<String, String> map, C10563a c10563a) {
        AppMethodBeat.m2504i(108224);
        synchronized (this.ich) {
            try {
                if (this.ich.size() >= this.ibK) {
                    c10563a.mo22070zK("max connected");
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", Integer.valueOf(this.ich.size()), Integer.valueOf(this.ibK));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108224);
            }
        }
    }

    /* renamed from: c */
    private void m30287c(C27135e c27135e) {
        AppMethodBeat.m2504i(108225);
        synchronized (this.ich) {
            try {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(c27135e.aBA())) {
                    this.ich.clear();
                }
                this.ich.add(c27135e);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108225);
            }
        }
    }

    /* renamed from: d */
    private synchronized void m30288d(C27135e c27135e) {
        AppMethodBeat.m2504i(108226);
        if (c27135e == null) {
            AppMethodBeat.m2505o(108226);
        } else {
            int i;
            synchronized (this.ich) {
                try {
                    i = this.ich;
                    i.remove(c27135e);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108226);
                }
            }
            AppMethodBeat.m2505o(i);
        }
    }

    /* renamed from: a */
    public final void mo22057a(C27135e c27135e) {
        AppMethodBeat.m2504i(108227);
        if (c27135e != null) {
            try {
                C4990ab.m7416i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                c27135e.close();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e, "Exception: send error", new Object[0]);
                C19541k.m30289e(c27135e);
            }
            m30288d(c27135e);
        }
        AppMethodBeat.m2505o(108227);
    }

    /* renamed from: a */
    public final void mo22058a(C27135e c27135e, int i, String str) {
        AppMethodBeat.m2504i(108228);
        if (c27135e != null) {
            try {
                C4990ab.m7416i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                c27135e.mo44806bk(str, i);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e, "Exception: send error", new Object[0]);
            }
            m30288d(c27135e);
        }
        AppMethodBeat.m2505o(108228);
    }

    /* renamed from: b */
    public final boolean mo22062b(C27135e c27135e) {
        AppMethodBeat.m2504i(108229);
        if (c27135e != null) {
            boolean isOpen = c27135e.isOpen();
            AppMethodBeat.m2505o(108229);
            return isOpen;
        }
        AppMethodBeat.m2505o(108229);
        return false;
    }

    /* renamed from: a */
    public final void mo22059a(C27135e c27135e, String str) {
        AppMethodBeat.m2504i(108230);
        if (c27135e != null) {
            c27135e.mo44801BU(str);
        }
        AppMethodBeat.m2505o(108230);
    }

    /* renamed from: a */
    public final void mo22060a(C27135e c27135e, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(108231);
        c27135e.mo44811p(byteBuffer);
        AppMethodBeat.m2505o(108231);
    }

    public final void release() {
        AppMethodBeat.m2504i(108232);
        mo22057a(mo22056BS(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.m2505o(108232);
    }

    /* renamed from: e */
    private static void m30289e(C27135e c27135e) {
        AppMethodBeat.m2504i(108233);
        if (c27135e == null) {
            AppMethodBeat.m2505o(108233);
            return;
        }
        Timer aGo = c27135e.aGo();
        C4990ab.m7416i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
        if (aGo != null) {
            aGo.cancel();
            c27135e.mo44803a(null);
        }
        AppMethodBeat.m2505o(108233);
    }

    /* renamed from: BS */
    public final C27135e mo22056BS(String str) {
        C27135e c27135e;
        AppMethodBeat.m2504i(108234);
        if (str == null) {
            AppMethodBeat.m2505o(108234);
            return null;
        }
        synchronized (this.ich) {
            try {
                Iterator it = this.ich.iterator();
                while (it.hasNext()) {
                    c27135e = (C27135e) it.next();
                    if (str.equals(c27135e.aBA())) {
                    }
                }
                AppMethodBeat.m2505o(108234);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108234);
            }
        }
        return c27135e;
    }
}
