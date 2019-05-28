package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;

public final class e {
    private static boolean E(String str, Map<String, String> map) {
        AppMethodBeat.i(79506);
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            AppMethodBeat.o(79506);
            return true;
        }
        AppMethodBeat.o(79506);
        return false;
    }

    static void k(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(79507);
        if (E(String.format("%s.%s", new Object[]{str, str2}), map)) {
            AppMethodBeat.o(79507);
            return;
        }
        int l = l(str, str2, map) | 0;
        int i = 0;
        while (true) {
            i++;
            if (E(String.format(Locale.US, "%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                break;
            }
            l |= l(str, str2, map);
        }
        i = b.aiZ(str2);
        if (b.KD(i)) {
            j.z(0, 32);
            if (l == 0) {
                j.z(0, 33);
                AppMethodBeat.o(79507);
                return;
            }
        } else if (b.KE(i)) {
            j.z(0, 35);
            if (l == 0) {
                j.z(0, 36);
                AppMethodBeat.o(79507);
                return;
            }
        } else if (b.KF(i)) {
            j.z(0, 38);
            if (l == 0) {
                j.z(0, 39);
            }
        }
        AppMethodBeat.o(79507);
    }

    private static boolean l(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(79508);
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int aiZ = b.aiZ(str2);
        if (E(format, map)) {
            AppMethodBeat.o(79508);
            return true;
        }
        boolean d = d(aiZ, format, map) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format(Locale.US, "%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (E(format2, map)) {
                AppMethodBeat.o(79508);
                return d;
            }
            d |= d(aiZ, format2, map);
        }
    }

    private static boolean d(int i, String str, Map<String, String> map) {
        AppMethodBeat.i(79509);
        boolean G;
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            AppMethodBeat.o(79509);
            return true;
        } else if (b.KF(i)) {
            G = G(str, map);
            AppMethodBeat.o(79509);
            return G;
        } else if (b.KD(i)) {
            G = F(str, map);
            AppMethodBeat.o(79509);
            return G;
        } else if (b.KE(i)) {
            G = c(str, map, true);
            AppMethodBeat.o(79509);
            return G;
        } else {
            AppMethodBeat.o(79509);
            return false;
        }
    }

    private static boolean F(String str, Map<String, String> map) {
        AppMethodBeat.i(79510);
        ab.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
        String str2 = (String) map.get(str + ".CDNUrl");
        int i = bo.getInt((String) map.get(str + ".subType"), -1);
        int i2 = bo.getInt((String) map.get(str + ".resType"), -1);
        String str3 = (String) map.get(str + ".md5");
        int i3 = bo.getInt((String) map.get(str + ".priority"), 0);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || -1 == i || -1 == i2 || i3 < 0) {
            AppMethodBeat.o(79510);
            return false;
        }
        int dij;
        bsw bsw = new bsw();
        bsw.wUV = new bsz();
        if (bo.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
            dij = a.dij();
        } else {
            dij = 0;
        }
        if (bo.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
            dij = a.KB(dij);
        }
        bsw.wOI = i;
        bsw.wVa = bo.getInt((String) map.get(str + ".networkType"), 2);
        bsw.vQW = bo.getInt((String) map.get(str + ".expireTime"), 1);
        bsw.wUV.Url = str2;
        bsw.wUV.wVf = bo.getInt((String) map.get(str + ".resVer"), 0);
        bsw.wUV.wdO = str3;
        bsw.wUV.wVi = (String) map.get(str + ".originalmd5");
        bsw.wUV.wVg = dij;
        bsw.wUV.wVh = null;
        bsw.wUV.wdt = null;
        bsw.wxG = i3;
        bsw.wpk = b.DoCache.bJt;
        bsw.wUX = bo.getInt((String) map.get(str + ".reportID"), 0);
        bsw.wUY = (String) map.get(str + ".sampleID");
        bsw.wUZ = bo.getInt((String) map.get(str + ".retryTime"), 3);
        bsw.wVb = bo.getInt((String) map.get(str + ".retryInterval"), 0);
        bsw.vek = 0;
        c.veg.b(i2, bsw, true);
        j.z((long) bsw.wUX, 34);
        AppMethodBeat.o(79510);
        return true;
    }

    private static boolean c(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.i(79511);
        ab.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
        int i = bo.getInt((String) map.get(str + ".resType"), -1);
        int i2 = bo.getInt((String) map.get(str + ".subType"), -1);
        if (-1 == i || -1 == i2) {
            AppMethodBeat.o(79511);
            return false;
        }
        bsw bsw = new bsw();
        bsw.wUW = new bsy();
        bsw.wOI = i2;
        bsw.wUW.wVe = (String) map.get(str + ".resKey");
        bsw.wUW.wVd = bo.getInt((String) map.get(str + ".resKeyVersion"), 0);
        bsw.wUY = (String) map.get(str + ".sampleID");
        bsw.wUX = bo.getInt((String) map.get(str + ".reportID"), 0);
        bsw.wpk = b.DoDecrypt.bJt;
        bsw.wUV = new bsz();
        bsw.wUV.wVi = (String) map.get(str + ".originalmd5");
        c.veg.a(i, bsw, true, false);
        j.z((long) bsw.wUX, 37);
        AppMethodBeat.o(79511);
        return true;
    }

    private static boolean G(String str, Map<String, String> map) {
        AppMethodBeat.i(79512);
        ab.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
        int i = bo.getInt((String) map.get(str + ".resType"), -1);
        int i2 = bo.getInt((String) map.get(str + ".subType"), -1);
        if (-1 == i || -1 == i2) {
            AppMethodBeat.o(79512);
            return false;
        }
        bsw bsw = new bsw();
        bsw.wOI = i2;
        bsw.wUV = new bsz();
        bsw.wUV.wVf = bo.getInt((String) map.get(str + ".resVer"), 0);
        bsw.wUY = (String) map.get(str + ".sampleID");
        bsw.wUX = bo.getInt((String) map.get(str + ".reportID"), 0);
        bsw.wpk = b.DoDelete.bJt;
        c.veg.a(i, bsw, true);
        j.z((long) bsw.wUX, 40);
        AppMethodBeat.o(79512);
        return true;
    }
}
