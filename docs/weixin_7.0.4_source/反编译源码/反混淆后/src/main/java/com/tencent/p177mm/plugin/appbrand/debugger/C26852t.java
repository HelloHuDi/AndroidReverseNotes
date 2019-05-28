package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.SharedPreferences;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.debugger.C38177u.C381798;
import com.tencent.p177mm.protocal.protobuf.cqm;
import com.tencent.p177mm.protocal.protobuf.cqs;
import com.tencent.p177mm.protocal.protobuf.cqt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.t */
public final class C26852t {
    private static String deviceID = null;
    public static C42411l hkA = null;
    private static Boolean hkB = null;

    /* renamed from: zP */
    public static C45537m m42769zP(String str) {
        AppMethodBeat.m2504i(101907);
        C4990ab.m7417i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", str);
        C45537m c45537m = new C45537m();
        if (!C5046bo.isNullOrNil(str)) {
            try {
                JSONObject lw = C41725h.m73457lw(str);
                c45537m.hjL = lw.optBoolean("open_remote", false);
                c45537m.ehq = lw.optString("room_id");
                c45537m.hjM = lw.optString("wxpkg_info");
                c45537m.hjN = lw.optString("qrcode_id");
                c45537m.hjO = lw.optInt("remote_network_type", 1);
                c45537m.bQs = lw.optBoolean("disable_url_check", true);
                c45537m.hjP = lw.optInt("remote_proxy_port", 9976);
                c45537m.hjQ = lw.optInt("remote_support_compress_algo");
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", e);
            }
        }
        AppMethodBeat.m2505o(101907);
        return c45537m;
    }

    /* renamed from: c */
    public static ByteBuffer m42765c(C1331a c1331a) {
        AppMethodBeat.m2504i(101908);
        ByteBuffer wrap;
        try {
            wrap = ByteBuffer.wrap(c1331a.toByteArray());
            AppMethodBeat.m2505o(101908);
            return wrap;
        } catch (IOException e) {
            C4990ab.m7420w("MicroMsg.RemoteDebugUtil", e.getMessage());
            wrap = ByteBuffer.allocate(0);
            AppMethodBeat.m2505o(101908);
            return wrap;
        }
    }

    /* renamed from: d */
    private static C1332b m42766d(C1331a c1331a) {
        AppMethodBeat.m2504i(101909);
        C1332b bI;
        try {
            bI = C1332b.m2847bI(c1331a.toByteArray());
            AppMethodBeat.m2505o(101909);
            return bI;
        } catch (IOException e) {
            C4990ab.m7420w("MicroMsg.RemoteDebugUtil", e.getMessage());
            bI = C1332b.m2847bI(new byte[0]);
            AppMethodBeat.m2505o(101909);
            return bI;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static C42416o m42761a(C1331a c1331a, C42411l c42411l, String str) {
        AppMethodBeat.m2504i(101910);
        cqt cqt = new cqt();
        try {
            byte[] toByteArray = c1331a.toByteArray();
            C42416o c42416o;
            if (toByteArray.length <= 256 || !C26852t.m42768nJ(c42411l.hjt.hjQ)) {
                cqt.wdt = C1332b.m2847bI(toByteArray);
                if (c42411l == null) {
                    Debug.waitForDebugger();
                    C4990ab.m7412e("MicroMsg.RemoteDebugUtil", "env = null ");
                }
                cqt.fQi = c42411l.hju.incrementAndGet();
                if (c42411l.hjw != 0) {
                    cqt.akv = 0;
                } else {
                    cqt.akv = (int) (System.currentTimeMillis() - c42411l.hjw);
                }
                c42411l.hjw = System.currentTimeMillis();
                cqt.category = str;
                C4990ab.m7411d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(cqt.fQi));
                c42416o = new C42416o();
                c42416o.hjf = System.currentTimeMillis();
                c42416o.hkb = cqt.wdt.f1226wR.length;
                c42416o.hka = cqt;
                AppMethodBeat.m2505o(101910);
                return c42416o;
            }
            cqt.wdt = C1332b.m2847bI(C1184r.compress(toByteArray));
            cqt.wWK = 1;
            C4990ab.m7419v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", Integer.valueOf(toByteArray.length), Integer.valueOf(r2.length));
            if (c42411l == null) {
            }
            cqt.fQi = c42411l.hju.incrementAndGet();
            if (c42411l.hjw != 0) {
            }
            c42411l.hjw = System.currentTimeMillis();
            cqt.category = str;
            C4990ab.m7411d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(cqt.fQi));
            c42416o = new C42416o();
            c42416o.hjf = System.currentTimeMillis();
            c42416o.hkb = cqt.wdt.f1226wR.length;
            c42416o.hka = cqt;
            AppMethodBeat.m2505o(101910);
            return c42416o;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", e);
        }
    }

    /* renamed from: a */
    public static cqs m42762a(int i, C1331a c1331a) {
        AppMethodBeat.m2504i(101911);
        cqs cqs = new cqs();
        cqs.f2979Cn = i;
        if (C5046bo.isNullOrNil(deviceID)) {
            deviceID = C5046bo.m7552gN(C4996ah.getContext());
        }
        cqs.eCq = deviceID + "-" + System.currentTimeMillis();
        cqs.wdt = C26852t.m42766d(c1331a);
        AppMethodBeat.m2505o(101911);
        return cqs;
    }

    /* renamed from: a */
    public static boolean m42764a(C42411l c42411l, cqs cqs, cqm cqm, C38177u c38177u, C42417p c42417p) {
        AppMethodBeat.m2504i(101912);
        if (cqs == null) {
            C4990ab.m7420w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
            AppMethodBeat.m2505o(101912);
            return false;
        }
        int i = cqs.f2979Cn;
        if (cqm == null) {
            C4990ab.m7421w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(101912);
            return false;
        }
        if (i == 1006) {
            if (-50011 == cqm.cyE) {
                c42411l.mo67929dJ(true);
            } else {
                boolean isBusy = c42411l.isBusy();
                c42411l.mo67929dJ(false);
                if (isBusy) {
                    c42417p.azk();
                }
            }
        }
        if (cqm.cyE == 0) {
            AppMethodBeat.m2505o(101912);
            return true;
        }
        C4990ab.m7417i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", Integer.valueOf(i), cqs.eCq, Integer.valueOf(cqm.cyE), cqm.cyF);
        C5004al.m7441d(new C381798(i, cqm));
        AppMethodBeat.m2505o(101912);
        return false;
    }

    /* renamed from: nJ */
    public static boolean m42768nJ(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: a */
    public static String m42763a(String str, C25697b c25697b) {
        AppMethodBeat.m2504i(101913);
        String a;
        if (c25697b.mo43493yd()) {
            a = C33082aw.m54068a((C6750i) c25697b, str + ".map");
            if (C5046bo.isNullOrNil(a)) {
                a = "";
                AppMethodBeat.m2505o(101913);
                return a;
            }
            try {
                String str2 = new String(Base64.encode(a.getBytes(), 2), ProtocolPackage.ServerEncoding);
                a = String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new Object[]{str2});
                AppMethodBeat.m2505o(101913);
                return a;
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7413e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", e.getMessage());
                a = "";
                AppMethodBeat.m2505o(101913);
                return a;
            }
        }
        a = "";
        AppMethodBeat.m2505o(101913);
        return a;
    }

    public static boolean azr() {
        AppMethodBeat.m2504i(101914);
        boolean booleanValue;
        if (hkB != null) {
            booleanValue = hkB.booleanValue();
            AppMethodBeat.m2505o(101914);
            return booleanValue;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences == null) {
            C4990ab.m7420w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
            AppMethodBeat.m2505o(101914);
            return true;
        }
        booleanValue = sharedPreferences.getBoolean("hard_code_open_game_preload", true);
        hkB = Boolean.valueOf(booleanValue);
        AppMethodBeat.m2505o(101914);
        return booleanValue;
    }

    /* renamed from: dL */
    public static void m42767dL(boolean z) {
        AppMethodBeat.m2504i(101915);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences == null) {
            C4990ab.m7420w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
            AppMethodBeat.m2505o(101915);
            return;
        }
        sharedPreferences.edit().putBoolean("hard_code_open_game_preload", z).commit();
        AppMethodBeat.m2505o(101915);
    }
}
