package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C30039i.C23235b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C30039i.C30038a;
import com.tencent.p177mm.protocal.protobuf.bsw;
import com.tencent.p177mm.protocal.protobuf.bsy;
import com.tencent.p177mm.protocal.protobuf.bsz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.e */
public final class C44045e {
    /* renamed from: E */
    private static boolean m79164E(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(79506);
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            AppMethodBeat.m2505o(79506);
            return true;
        }
        AppMethodBeat.m2505o(79506);
        return false;
    }

    /* renamed from: k */
    static void m79169k(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(79507);
        if (C44045e.m79164E(String.format("%s.%s", new Object[]{str, str2}), map)) {
            AppMethodBeat.m2505o(79507);
            return;
        }
        int l = C44045e.m79170l(str, str2, map) | 0;
        int i = 0;
        while (true) {
            i++;
            if (C44045e.m79164E(String.format(Locale.US, "%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                break;
            }
            l |= C44045e.m79170l(str, str2, map);
        }
        i = C23235b.aiZ(str2);
        if (C23235b.m35631KD(i)) {
            C23236j.m35639z(0, 32);
            if (l == 0) {
                C23236j.m35639z(0, 33);
                AppMethodBeat.m2505o(79507);
                return;
            }
        } else if (C23235b.m35632KE(i)) {
            C23236j.m35639z(0, 35);
            if (l == 0) {
                C23236j.m35639z(0, 36);
                AppMethodBeat.m2505o(79507);
                return;
            }
        } else if (C23235b.m35633KF(i)) {
            C23236j.m35639z(0, 38);
            if (l == 0) {
                C23236j.m35639z(0, 39);
            }
        }
        AppMethodBeat.m2505o(79507);
    }

    /* renamed from: l */
    private static boolean m79170l(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(79508);
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int aiZ = C23235b.aiZ(str2);
        if (C44045e.m79164E(format, map)) {
            AppMethodBeat.m2505o(79508);
            return true;
        }
        boolean d = C44045e.m79168d(aiZ, format, map) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format(Locale.US, "%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (C44045e.m79164E(format2, map)) {
                AppMethodBeat.m2505o(79508);
                return d;
            }
            d |= C44045e.m79168d(aiZ, format2, map);
        }
    }

    /* renamed from: d */
    private static boolean m79168d(int i, String str, Map<String, String> map) {
        AppMethodBeat.m2504i(79509);
        boolean G;
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            AppMethodBeat.m2505o(79509);
            return true;
        } else if (C23235b.m35633KF(i)) {
            G = C44045e.m79166G(str, map);
            AppMethodBeat.m2505o(79509);
            return G;
        } else if (C23235b.m35631KD(i)) {
            G = C44045e.m79165F(str, map);
            AppMethodBeat.m2505o(79509);
            return G;
        } else if (C23235b.m35632KE(i)) {
            G = C44045e.m79167c(str, map, true);
            AppMethodBeat.m2505o(79509);
            return G;
        } else {
            AppMethodBeat.m2505o(79509);
            return false;
        }
    }

    /* renamed from: F */
    private static boolean m79165F(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(79510);
        C4990ab.m7410d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
        String str2 = (String) map.get(str + ".CDNUrl");
        int i = C5046bo.getInt((String) map.get(str + ".subType"), -1);
        int i2 = C5046bo.getInt((String) map.get(str + ".resType"), -1);
        String str3 = (String) map.get(str + ".md5");
        int i3 = C5046bo.getInt((String) map.get(str + ".priority"), 0);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || -1 == i || -1 == i2 || i3 < 0) {
            AppMethodBeat.m2505o(79510);
            return false;
        }
        int dij;
        bsw bsw = new bsw();
        bsw.wUV = new bsz();
        if (C5046bo.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
            dij = C30038a.dij();
        } else {
            dij = 0;
        }
        if (C5046bo.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
            dij = C30038a.m47547KB(dij);
        }
        bsw.wOI = i;
        bsw.wVa = C5046bo.getInt((String) map.get(str + ".networkType"), 2);
        bsw.vQW = C5046bo.getInt((String) map.get(str + ".expireTime"), 1);
        bsw.wUV.Url = str2;
        bsw.wUV.wVf = C5046bo.getInt((String) map.get(str + ".resVer"), 0);
        bsw.wUV.wdO = str3;
        bsw.wUV.wVi = (String) map.get(str + ".originalmd5");
        bsw.wUV.wVg = dij;
        bsw.wUV.wVh = null;
        bsw.wUV.wdt = null;
        bsw.wxG = i3;
        bsw.wpk = C23235b.DoCache.bJt;
        bsw.wUX = C5046bo.getInt((String) map.get(str + ".reportID"), 0);
        bsw.wUY = (String) map.get(str + ".sampleID");
        bsw.wUZ = C5046bo.getInt((String) map.get(str + ".retryTime"), 3);
        bsw.wVb = C5046bo.getInt((String) map.get(str + ".retryInterval"), 0);
        bsw.vek = 0;
        C14845c.veg.mo27148b(i2, bsw, true);
        C23236j.m35639z((long) bsw.wUX, 34);
        AppMethodBeat.m2505o(79510);
        return true;
    }

    /* renamed from: c */
    private static boolean m79167c(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.m2504i(79511);
        C4990ab.m7410d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
        int i = C5046bo.getInt((String) map.get(str + ".resType"), -1);
        int i2 = C5046bo.getInt((String) map.get(str + ".subType"), -1);
        if (-1 == i || -1 == i2) {
            AppMethodBeat.m2505o(79511);
            return false;
        }
        bsw bsw = new bsw();
        bsw.wUW = new bsy();
        bsw.wOI = i2;
        bsw.wUW.wVe = (String) map.get(str + ".resKey");
        bsw.wUW.wVd = C5046bo.getInt((String) map.get(str + ".resKeyVersion"), 0);
        bsw.wUY = (String) map.get(str + ".sampleID");
        bsw.wUX = C5046bo.getInt((String) map.get(str + ".reportID"), 0);
        bsw.wpk = C23235b.DoDecrypt.bJt;
        bsw.wUV = new bsz();
        bsw.wUV.wVi = (String) map.get(str + ".originalmd5");
        C14845c.veg.mo27146a(i, bsw, true, false);
        C23236j.m35639z((long) bsw.wUX, 37);
        AppMethodBeat.m2505o(79511);
        return true;
    }

    /* renamed from: G */
    private static boolean m79166G(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(79512);
        C4990ab.m7410d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
        int i = C5046bo.getInt((String) map.get(str + ".resType"), -1);
        int i2 = C5046bo.getInt((String) map.get(str + ".subType"), -1);
        if (-1 == i || -1 == i2) {
            AppMethodBeat.m2505o(79512);
            return false;
        }
        bsw bsw = new bsw();
        bsw.wOI = i2;
        bsw.wUV = new bsz();
        bsw.wUV.wVf = C5046bo.getInt((String) map.get(str + ".resVer"), 0);
        bsw.wUY = (String) map.get(str + ".sampleID");
        bsw.wUX = C5046bo.getInt((String) map.get(str + ".reportID"), 0);
        bsw.wpk = C23235b.DoDelete.bJt;
        C14845c.veg.mo27145a(i, bsw, true);
        C23236j.m35639z((long) bsw.wUX, 40);
        AppMethodBeat.m2505o(79512);
        return true;
    }
}
