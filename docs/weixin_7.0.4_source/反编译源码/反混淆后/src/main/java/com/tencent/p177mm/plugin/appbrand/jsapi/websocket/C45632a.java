package com.tencent.p177mm.plugin.appbrand.jsapi.websocket;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d.C10563a;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.a */
public final class C45632a implements C10562d {
    private final String ibJ;
    private int ibK;
    private C38414a ibL;

    /* renamed from: f */
    static /* synthetic */ void m84251f(C27135e c27135e) {
        AppMethodBeat.m2504i(108097);
        C45632a.m84250e(c27135e);
        AppMethodBeat.m2505o(108097);
    }

    public C45632a(C38414a c38414a) {
        this.ibJ = c38414a.ioo;
        this.ibK = c38414a.iok;
        this.ibL = c38414a;
    }

    public final void release() {
        AppMethodBeat.m2504i(108086);
        mo22057a(mo22056BS(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.m2505o(108086);
    }

    /* JADX WARNING: Missing block: B:9:0x0046, code skipped:
            r11 = r17.optString("url");
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            r8 = new java.net.URI(r11);
     */
    /* JADX WARNING: Missing block: B:12:0x0054, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b", r11, java.lang.Integer.valueOf(r15), java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r17.optBoolean("tcpNoDelay", false)));
            r18.put("User-Agent", r12.ibJ);
            r2 = com.tencent.p177mm.plugin.appbrand.p321l.C19538j.m30264G(r17);
     */
    /* JADX WARNING: Missing block: B:13:0x0094, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2) != false) goto L_0x00ad;
     */
    /* JADX WARNING: Missing block: B:14:0x0096, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWcWssSocket", "protocols %s", r2);
            r18.put("Sec-WebSocket-Protocol", r2);
     */
    /* JADX WARNING: Missing block: B:15:0x00ad, code skipped:
            r2 = com.tencent.p177mm.plugin.appbrand.p321l.C19538j.m30266a(r8);
     */
    /* JADX WARNING: Missing block: B:16:0x00b5, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2) != false) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:17:0x00b7, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWcWssSocket", "Origin %s", r2);
            r18.put("Origin", r2);
     */
    /* JADX WARNING: Missing block: B:18:0x00ce, code skipped:
            r6 = false;
     */
    /* JADX WARNING: Missing block: B:19:0x00d6, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.p329s.C19721r.m30533t(r11, "ws://") == false) goto L_0x00d9;
     */
    /* JADX WARNING: Missing block: B:20:0x00d8, code skipped:
            r6 = true;
     */
    /* JADX WARNING: Missing block: B:21:0x00d9, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, taskId=%s, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b, skipDimain = %b", r14, r11, java.lang.Integer.valueOf(r15), java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r5), java.lang.Boolean.valueOf(r6));
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r2 = new com.tencent.p177mm.plugin.appbrand.jsapi.websocket.WssConfig(r16, r16, r5, r6, r15);
            r3 = new com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C38403b(r13, r11, r8, r18, r2, new java.util.ArrayList(), r12.ibL);
            r6 = r14;
            r7 = r3;
            r8 = r19;
            r9 = r11;
            r3.mo34732a(new com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C45632a.C334181(r12));
            r3.mo44800BT(r14);
     */
    /* JADX WARNING: Missing block: B:24:0x013b, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.p329s.C19721r.m30533t(r11, "ws://") != false) goto L_0x0146;
     */
    /* JADX WARNING: Missing block: B:26:0x0144, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.p329s.C19721r.m30533t(r11, "wss://") == false) goto L_0x01b0;
     */
    /* JADX WARNING: Missing block: B:27:0x0146, code skipped:
            r3.connect();
            com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C45632a.m84248c(r3);
            r2 = new java.util.Timer();
            r0 = r19;
            r4 = new com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C45632a.C105612(r12);
            r3.mo44803a(r2);
            r2.schedule(r4, (long) r16);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108087);
     */
    /* JADX WARNING: Missing block: B:28:0x0169, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x016a, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", r2, "Exception: url %s", r11);
            r19.mo22069zJ(r2.getMessage());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108087);
     */
    /* JADX WARNING: Missing block: B:34:0x0193, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x0194, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", r2, "connect fail Exception", new java.lang.Object[0]);
            r19.mo22070zK("url not well format");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108087);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7421w("MicroMsg.AppBrandNetworkWcWssSocket", "url error: %s not ws:// or wss://", r11);
            r19.mo22070zK("url not ws or wss");
     */
    /* JADX WARNING: Missing block: B:38:0x01c7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108087);
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo22061a(String str, String str2, int i, int i2, JSONObject jSONObject, Map<String, String> map, C10563a c10563a) {
        AppMethodBeat.m2504i(108087);
        synchronized (ich) {
            try {
                if (ich.size() >= this.ibK) {
                    c10563a.mo22070zK("max connected");
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkWcWssSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", Integer.valueOf(ich.size()), Integer.valueOf(this.ibK));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108087);
            }
        }
    }

    /* renamed from: a */
    public final void mo22057a(C27135e c27135e) {
        AppMethodBeat.m2504i(108088);
        if (c27135e != null) {
            try {
                C4990ab.m7416i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket");
                c27135e.close();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", e, "send error Exception", new Object[0]);
                C45632a.m84250e(c27135e);
            }
            m84249d(c27135e);
        }
        AppMethodBeat.m2505o(108088);
    }

    /* renamed from: a */
    public final void mo22058a(C27135e c27135e, int i, String str) {
        AppMethodBeat.m2504i(108089);
        if (c27135e != null) {
            try {
                C4990ab.m7417i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket code:%d,reason:%s", Integer.valueOf(i), str);
                c27135e.mo44806bk(str, i);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", e, "send error Exception", new Object[0]);
            }
            m84249d(c27135e);
        }
        AppMethodBeat.m2505o(108089);
    }

    /* renamed from: b */
    public final boolean mo22062b(C27135e c27135e) {
        AppMethodBeat.m2504i(108090);
        if (c27135e != null) {
            boolean isOpen = c27135e.isOpen();
            AppMethodBeat.m2505o(108090);
            return isOpen;
        }
        AppMethodBeat.m2505o(108090);
        return false;
    }

    /* renamed from: a */
    public final void mo22059a(C27135e c27135e, String str) {
        AppMethodBeat.m2504i(108091);
        if (c27135e != null) {
            c27135e.mo44801BU(str);
        }
        AppMethodBeat.m2505o(108091);
    }

    /* renamed from: a */
    public final void mo22060a(C27135e c27135e, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(108092);
        if (c27135e != null) {
            c27135e.mo44811p(byteBuffer);
        }
        AppMethodBeat.m2505o(108092);
    }

    /* renamed from: BS */
    public final C27135e mo22056BS(String str) {
        C27135e c27135e;
        AppMethodBeat.m2504i(108093);
        if (str == null) {
            AppMethodBeat.m2505o(108093);
            return null;
        }
        synchronized (ich) {
            try {
                Iterator it = ich.iterator();
                while (it.hasNext()) {
                    c27135e = (C27135e) it.next();
                    if (str.equals(c27135e.aBA())) {
                    }
                }
                AppMethodBeat.m2505o(108093);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108093);
            }
        }
        return c27135e;
    }

    /* renamed from: c */
    private static void m84248c(C27135e c27135e) {
        AppMethodBeat.m2504i(108094);
        synchronized (ich) {
            try {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(c27135e.aBA())) {
                    ich.clear();
                }
                ich.add(c27135e);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108094);
            }
        }
    }

    /* renamed from: d */
    private synchronized void m84249d(C27135e c27135e) {
        AppMethodBeat.m2504i(108095);
        if (c27135e == null) {
            AppMethodBeat.m2505o(108095);
        } else {
            int i;
            synchronized (ich) {
                try {
                    i = ich;
                    i.remove(c27135e);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108095);
                }
            }
            AppMethodBeat.m2505o(i);
        }
    }

    /* renamed from: e */
    private static void m84250e(C27135e c27135e) {
        AppMethodBeat.m2504i(108096);
        if (c27135e == null) {
            AppMethodBeat.m2505o(108096);
            return;
        }
        Timer aGo = c27135e.aGo();
        C4990ab.m7416i("MicroMsg.AppBrandNetworkWcWssSocket", "try to stop connectTimer");
        if (aGo != null) {
            aGo.cancel();
            c27135e.mo44803a(null);
        }
        AppMethodBeat.m2505o(108096);
    }
}
