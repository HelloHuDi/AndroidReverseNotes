package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

public final class a implements d {
    private final String ibJ;
    private int ibK;
    private com.tencent.mm.plugin.appbrand.l.a ibL;

    static /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(108097);
        e(eVar);
        AppMethodBeat.o(108097);
    }

    public a(com.tencent.mm.plugin.appbrand.l.a aVar) {
        this.ibJ = aVar.ioo;
        this.ibK = aVar.iok;
        this.ibL = aVar;
    }

    public final void release() {
        AppMethodBeat.i(108086);
        a(BS(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(108086);
    }

    /* JADX WARNING: Missing block: B:9:0x0046, code skipped:
            r11 = r17.optString("url");
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            r8 = new java.net.URI(r11);
     */
    /* JADX WARNING: Missing block: B:12:0x0054, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b", r11, java.lang.Integer.valueOf(r15), java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r17.optBoolean("tcpNoDelay", false)));
            r18.put("User-Agent", r12.ibJ);
            r2 = com.tencent.mm.plugin.appbrand.l.j.G(r17);
     */
    /* JADX WARNING: Missing block: B:13:0x0094, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2) != false) goto L_0x00ad;
     */
    /* JADX WARNING: Missing block: B:14:0x0096, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "protocols %s", r2);
            r18.put("Sec-WebSocket-Protocol", r2);
     */
    /* JADX WARNING: Missing block: B:15:0x00ad, code skipped:
            r2 = com.tencent.mm.plugin.appbrand.l.j.a(r8);
     */
    /* JADX WARNING: Missing block: B:16:0x00b5, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2) != false) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:17:0x00b7, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "Origin %s", r2);
            r18.put("Origin", r2);
     */
    /* JADX WARNING: Missing block: B:18:0x00ce, code skipped:
            r6 = false;
     */
    /* JADX WARNING: Missing block: B:19:0x00d6, code skipped:
            if (com.tencent.mm.plugin.appbrand.s.r.t(r11, "ws://") == false) goto L_0x00d9;
     */
    /* JADX WARNING: Missing block: B:20:0x00d8, code skipped:
            r6 = true;
     */
    /* JADX WARNING: Missing block: B:21:0x00d9, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, taskId=%s, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b, skipDimain = %b", r14, r11, java.lang.Integer.valueOf(r15), java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r5), java.lang.Boolean.valueOf(r6));
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.WssConfig(r16, r16, r5, r6, r15);
            r3 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.b(r13, r11, r8, r18, r2, new java.util.ArrayList(), r12.ibL);
            r6 = r14;
            r7 = r3;
            r8 = r19;
            r9 = r11;
            r3.a(new com.tencent.mm.plugin.appbrand.jsapi.websocket.a.AnonymousClass1(r12));
            r3.BT(r14);
     */
    /* JADX WARNING: Missing block: B:24:0x013b, code skipped:
            if (com.tencent.mm.plugin.appbrand.s.r.t(r11, "ws://") != false) goto L_0x0146;
     */
    /* JADX WARNING: Missing block: B:26:0x0144, code skipped:
            if (com.tencent.mm.plugin.appbrand.s.r.t(r11, "wss://") == false) goto L_0x01b0;
     */
    /* JADX WARNING: Missing block: B:27:0x0146, code skipped:
            r3.connect();
            c(r3);
            r2 = new java.util.Timer();
            r0 = r19;
            r4 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a.AnonymousClass2(r12);
            r3.a(r2);
            r2.schedule(r4, (long) r16);
            com.tencent.matrix.trace.core.AppMethodBeat.o(108087);
     */
    /* JADX WARNING: Missing block: B:28:0x0169, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x016a, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", r2, "Exception: url %s", r11);
            r19.zJ(r2.getMessage());
            com.tencent.matrix.trace.core.AppMethodBeat.o(108087);
     */
    /* JADX WARNING: Missing block: B:34:0x0193, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x0194, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", r2, "connect fail Exception", new java.lang.Object[0]);
            r19.zK("url not well format");
            com.tencent.matrix.trace.core.AppMethodBeat.o(108087);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AppBrandNetworkWcWssSocket", "url error: %s not ws:// or wss://", r11);
            r19.zK("url not ws or wss");
     */
    /* JADX WARNING: Missing block: B:38:0x01c7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(108087);
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
    public final void a(String str, String str2, int i, int i2, JSONObject jSONObject, Map<String, String> map, com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a aVar) {
        AppMethodBeat.i(108087);
        synchronized (ich) {
            try {
                if (ich.size() >= this.ibK) {
                    aVar.zK("max connected");
                    ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", Integer.valueOf(ich.size()), Integer.valueOf(this.ibK));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108087);
            }
        }
    }

    public final void a(e eVar) {
        AppMethodBeat.i(108088);
        if (eVar != null) {
            try {
                ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket");
                eVar.close();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", e, "send error Exception", new Object[0]);
                e(eVar);
            }
            d(eVar);
        }
        AppMethodBeat.o(108088);
    }

    public final void a(e eVar, int i, String str) {
        AppMethodBeat.i(108089);
        if (eVar != null) {
            try {
                ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket code:%d,reason:%s", Integer.valueOf(i), str);
                eVar.bk(str, i);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", e, "send error Exception", new Object[0]);
            }
            d(eVar);
        }
        AppMethodBeat.o(108089);
    }

    public final boolean b(e eVar) {
        AppMethodBeat.i(108090);
        if (eVar != null) {
            boolean isOpen = eVar.isOpen();
            AppMethodBeat.o(108090);
            return isOpen;
        }
        AppMethodBeat.o(108090);
        return false;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(108091);
        if (eVar != null) {
            eVar.BU(str);
        }
        AppMethodBeat.o(108091);
    }

    public final void a(e eVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(108092);
        if (eVar != null) {
            eVar.p(byteBuffer);
        }
        AppMethodBeat.o(108092);
    }

    public final e BS(String str) {
        e eVar;
        AppMethodBeat.i(108093);
        if (str == null) {
            AppMethodBeat.o(108093);
            return null;
        }
        synchronized (ich) {
            try {
                Iterator it = ich.iterator();
                while (it.hasNext()) {
                    eVar = (e) it.next();
                    if (str.equals(eVar.aBA())) {
                    }
                }
                AppMethodBeat.o(108093);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108093);
            }
        }
        return eVar;
    }

    private static void c(e eVar) {
        AppMethodBeat.i(108094);
        synchronized (ich) {
            try {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(eVar.aBA())) {
                    ich.clear();
                }
                ich.add(eVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108094);
            }
        }
    }

    private synchronized void d(e eVar) {
        AppMethodBeat.i(108095);
        if (eVar == null) {
            AppMethodBeat.o(108095);
        } else {
            int i;
            synchronized (ich) {
                try {
                    i = ich;
                    i.remove(eVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108095);
                }
            }
            AppMethodBeat.o(i);
        }
    }

    private static void e(e eVar) {
        AppMethodBeat.i(108096);
        if (eVar == null) {
            AppMethodBeat.o(108096);
            return;
        }
        Timer aGo = eVar.aGo();
        ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to stop connectTimer");
        if (aGo != null) {
            aGo.cancel();
            eVar.a(null);
        }
        AppMethodBeat.o(108096);
    }
}
