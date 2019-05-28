package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C14394g;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C46391e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.a */
public final class C14373a {
    private static long tVb = -1;

    private static JSONArray adn(String str) {
        AppMethodBeat.m2504i(51451);
        if (str == null) {
            AppMethodBeat.m2505o(51451);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            AppMethodBeat.m2505o(51451);
            return jSONArray;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            AppMethodBeat.m2505o(51451);
            return null;
        }
    }

    /* renamed from: G */
    private static HashSet<String> m22584G(JSONArray jSONArray) {
        AppMethodBeat.m2504i(51452);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(51452);
            return null;
        }
        try {
            HashSet<String> hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getJSONObject(i).getString("fid"));
            }
            AppMethodBeat.m2505o(51452);
            return hashSet;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            AppMethodBeat.m2505o(51452);
            return null;
        }
    }

    private static String cTl() {
        AppMethodBeat.m2504i(51453);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, null);
        AppMethodBeat.m2505o(51453);
        return str;
    }

    public static boolean ado(String str) {
        AppMethodBeat.m2504i(51454);
        C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", str);
        try {
            JSONArray adn = C14373a.adn(C14373a.cTl());
            HashSet G = C14373a.m22584G(adn);
            if (adn == null) {
                C4990ab.m7420w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
                adn = new JSONArray();
            }
            if (G == null) {
                C4990ab.m7420w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
                G = new HashSet();
            }
            C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", adn.toString());
            if (!G.contains(str)) {
                C4990ab.m7421w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", str, Boolean.FALSE);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fid", str);
                adn.put(jSONObject);
                C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", adn.toString());
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, adn.toString());
                C1720g.m3536RP().mo5239Ry().dsb();
                AppMethodBeat.m2505o(51454);
                return true;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(51454);
        return false;
    }

    public static boolean adp(String str) {
        AppMethodBeat.m2504i(51455);
        C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", str, C14373a.cTl());
        HashSet G = C14373a.m22584G(C14373a.adn(r2));
        if (G == null || !G.contains(str)) {
            AppMethodBeat.m2505o(51455);
            return false;
        }
        AppMethodBeat.m2505o(51455);
        return true;
    }

    public static void cTm() {
        AppMethodBeat.m2504i(51456);
        C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", C5046bo.dpG());
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, null);
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(51456);
    }

    public static boolean cTn() {
        AppMethodBeat.m2504i(51457);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(51457);
        return booleanValue;
    }

    /* renamed from: nu */
    public static void m22587nu(boolean z) {
        AppMethodBeat.m2504i(51458);
        C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(51458);
    }

    public static boolean cTo() {
        AppMethodBeat.m2504i(51459);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETLOCK_FACEID_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(51459);
        return booleanValue;
    }

    /* renamed from: nv */
    public static void m22588nv(boolean z) {
        AppMethodBeat.m2504i(51460);
        C4990ab.m7417i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_FACEID_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(51460);
    }

    /* renamed from: ac */
    public static void m22585ac(long j, long j2) {
        AppMethodBeat.m2504i(51462);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            C14394g c14394g = new C14394g();
            c14394g.tVD = j;
            c14394g.tVE = j2;
            Ry.set(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, C46391e.m87264by(c14394g.toByteArray()));
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51462);
    }

    public static void cTq() {
        tVb = -1;
    }

    public static long cTr() {
        return tVb;
    }

    /* renamed from: lK */
    public static void m22586lK(long j) {
        tVb = j;
    }

    public static boolean cTp() {
        C14394g c14394g;
        AppMethodBeat.m2504i(51461);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry == null) {
            c14394g = new C14394g();
        } else {
            String str = (String) Ry.get(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, null);
            if (str == null) {
                c14394g = new C14394g();
            } else {
                c14394g = new C14394g().mo26658bz(C46391e.stringToBytes(str));
            }
        }
        if (c14394g.tVD != -1) {
            C46391e.m87260a(c14394g);
            if (c14394g.tVE / 1000 < 30) {
                C14373a.m22585ac(c14394g.tVD, c14394g.tVE);
                AppMethodBeat.m2505o(51461);
                return true;
            }
            Ry = C1720g.m3536RP().mo5239Ry();
            if (Ry != null) {
                Ry.set(C5127a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, null);
                Ry.dsb();
            }
            AppMethodBeat.m2505o(51461);
            return false;
        }
        AppMethodBeat.m2505o(51461);
        return false;
    }
}
