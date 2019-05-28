package com.tencent.mm.plugin.appbrand.debugger;

import android.content.SharedPreferences;
import android.os.Debug;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.r;
import com.tencent.mm.aa.h;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.debugger.u.AnonymousClass8;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class t {
    private static String deviceID = null;
    public static l hkA = null;
    private static Boolean hkB = null;

    public static m zP(String str) {
        AppMethodBeat.i(101907);
        ab.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", str);
        m mVar = new m();
        if (!bo.isNullOrNil(str)) {
            try {
                JSONObject lw = h.lw(str);
                mVar.hjL = lw.optBoolean("open_remote", false);
                mVar.ehq = lw.optString("room_id");
                mVar.hjM = lw.optString("wxpkg_info");
                mVar.hjN = lw.optString("qrcode_id");
                mVar.hjO = lw.optInt("remote_network_type", 1);
                mVar.bQs = lw.optBoolean("disable_url_check", true);
                mVar.hjP = lw.optInt("remote_proxy_port", 9976);
                mVar.hjQ = lw.optInt("remote_support_compress_algo");
            } catch (Exception e) {
                ab.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", e);
            }
        }
        AppMethodBeat.o(101907);
        return mVar;
    }

    public static ByteBuffer c(a aVar) {
        AppMethodBeat.i(101908);
        ByteBuffer wrap;
        try {
            wrap = ByteBuffer.wrap(aVar.toByteArray());
            AppMethodBeat.o(101908);
            return wrap;
        } catch (IOException e) {
            ab.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            wrap = ByteBuffer.allocate(0);
            AppMethodBeat.o(101908);
            return wrap;
        }
    }

    private static b d(a aVar) {
        AppMethodBeat.i(101909);
        b bI;
        try {
            bI = b.bI(aVar.toByteArray());
            AppMethodBeat.o(101909);
            return bI;
        } catch (IOException e) {
            ab.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            bI = b.bI(new byte[0]);
            AppMethodBeat.o(101909);
            return bI;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static o a(a aVar, l lVar, String str) {
        AppMethodBeat.i(101910);
        cqt cqt = new cqt();
        try {
            byte[] toByteArray = aVar.toByteArray();
            o oVar;
            if (toByteArray.length <= 256 || !nJ(lVar.hjt.hjQ)) {
                cqt.wdt = b.bI(toByteArray);
                if (lVar == null) {
                    Debug.waitForDebugger();
                    ab.e("MicroMsg.RemoteDebugUtil", "env = null ");
                }
                cqt.fQi = lVar.hju.incrementAndGet();
                if (lVar.hjw != 0) {
                    cqt.akv = 0;
                } else {
                    cqt.akv = (int) (System.currentTimeMillis() - lVar.hjw);
                }
                lVar.hjw = System.currentTimeMillis();
                cqt.category = str;
                ab.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(cqt.fQi));
                oVar = new o();
                oVar.hjf = System.currentTimeMillis();
                oVar.hkb = cqt.wdt.wR.length;
                oVar.hka = cqt;
                AppMethodBeat.o(101910);
                return oVar;
            }
            cqt.wdt = b.bI(r.compress(toByteArray));
            cqt.wWK = 1;
            ab.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", Integer.valueOf(toByteArray.length), Integer.valueOf(r2.length));
            if (lVar == null) {
            }
            cqt.fQi = lVar.hju.incrementAndGet();
            if (lVar.hjw != 0) {
            }
            lVar.hjw = System.currentTimeMillis();
            cqt.category = str;
            ab.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(cqt.fQi));
            oVar = new o();
            oVar.hjf = System.currentTimeMillis();
            oVar.hkb = cqt.wdt.wR.length;
            oVar.hka = cqt;
            AppMethodBeat.o(101910);
            return oVar;
        } catch (IOException e) {
            ab.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", e);
        }
    }

    public static cqs a(int i, a aVar) {
        AppMethodBeat.i(101911);
        cqs cqs = new cqs();
        cqs.Cn = i;
        if (bo.isNullOrNil(deviceID)) {
            deviceID = bo.gN(ah.getContext());
        }
        cqs.eCq = deviceID + "-" + System.currentTimeMillis();
        cqs.wdt = d(aVar);
        AppMethodBeat.o(101911);
        return cqs;
    }

    public static boolean a(l lVar, cqs cqs, cqm cqm, u uVar, p pVar) {
        AppMethodBeat.i(101912);
        if (cqs == null) {
            ab.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
            AppMethodBeat.o(101912);
            return false;
        }
        int i = cqs.Cn;
        if (cqm == null) {
            ab.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", Integer.valueOf(i));
            AppMethodBeat.o(101912);
            return false;
        }
        if (i == 1006) {
            if (-50011 == cqm.cyE) {
                lVar.dJ(true);
            } else {
                boolean isBusy = lVar.isBusy();
                lVar.dJ(false);
                if (isBusy) {
                    pVar.azk();
                }
            }
        }
        if (cqm.cyE == 0) {
            AppMethodBeat.o(101912);
            return true;
        }
        ab.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", Integer.valueOf(i), cqs.eCq, Integer.valueOf(cqm.cyE), cqm.cyF);
        al.d(new AnonymousClass8(i, cqm));
        AppMethodBeat.o(101912);
        return false;
    }

    public static boolean nJ(int i) {
        return (i & 1) != 0;
    }

    public static String a(String str, com.tencent.luggage.sdk.b.b bVar) {
        AppMethodBeat.i(101913);
        String a;
        if (bVar.yd()) {
            a = aw.a((i) bVar, str + ".map");
            if (bo.isNullOrNil(a)) {
                a = "";
                AppMethodBeat.o(101913);
                return a;
            }
            try {
                String str2 = new String(Base64.encode(a.getBytes(), 2), ProtocolPackage.ServerEncoding);
                a = String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new Object[]{str2});
                AppMethodBeat.o(101913);
                return a;
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", e.getMessage());
                a = "";
                AppMethodBeat.o(101913);
                return a;
            }
        }
        a = "";
        AppMethodBeat.o(101913);
        return a;
    }

    public static boolean azr() {
        AppMethodBeat.i(101914);
        boolean booleanValue;
        if (hkB != null) {
            booleanValue = hkB.booleanValue();
            AppMethodBeat.o(101914);
            return booleanValue;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences == null) {
            ab.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
            AppMethodBeat.o(101914);
            return true;
        }
        booleanValue = sharedPreferences.getBoolean("hard_code_open_game_preload", true);
        hkB = Boolean.valueOf(booleanValue);
        AppMethodBeat.o(101914);
        return booleanValue;
    }

    public static void dL(boolean z) {
        AppMethodBeat.i(101915);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences == null) {
            ab.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
            AppMethodBeat.o(101915);
            return;
        }
        sharedPreferences.edit().putBoolean("hard_code_open_game_preload", z).commit();
        AppMethodBeat.o(101915);
    }
}
