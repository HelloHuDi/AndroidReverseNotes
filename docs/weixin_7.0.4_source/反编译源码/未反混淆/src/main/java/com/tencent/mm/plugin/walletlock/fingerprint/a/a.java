package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static long tVb = -1;

    private static JSONArray adn(String str) {
        AppMethodBeat.i(51451);
        if (str == null) {
            AppMethodBeat.o(51451);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            AppMethodBeat.o(51451);
            return jSONArray;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            AppMethodBeat.o(51451);
            return null;
        }
    }

    private static HashSet<String> G(JSONArray jSONArray) {
        AppMethodBeat.i(51452);
        if (jSONArray == null) {
            AppMethodBeat.o(51452);
            return null;
        }
        try {
            HashSet<String> hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getJSONObject(i).getString("fid"));
            }
            AppMethodBeat.o(51452);
            return hashSet;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            AppMethodBeat.o(51452);
            return null;
        }
    }

    private static String cTl() {
        AppMethodBeat.i(51453);
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, null);
        AppMethodBeat.o(51453);
        return str;
    }

    public static boolean ado(String str) {
        AppMethodBeat.i(51454);
        ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", str);
        try {
            JSONArray adn = adn(cTl());
            HashSet G = G(adn);
            if (adn == null) {
                ab.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
                adn = new JSONArray();
            }
            if (G == null) {
                ab.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
                G = new HashSet();
            }
            ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", adn.toString());
            if (!G.contains(str)) {
                ab.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", str, Boolean.FALSE);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fid", str);
                adn.put(jSONObject);
                ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", adn.toString());
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, adn.toString());
                g.RP().Ry().dsb();
                AppMethodBeat.o(51454);
                return true;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
        }
        AppMethodBeat.o(51454);
        return false;
    }

    public static boolean adp(String str) {
        AppMethodBeat.i(51455);
        ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", str, cTl());
        HashSet G = G(adn(r2));
        if (G == null || !G.contains(str)) {
            AppMethodBeat.o(51455);
            return false;
        }
        AppMethodBeat.o(51455);
        return true;
    }

    public static void cTm() {
        AppMethodBeat.i(51456);
        ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", bo.dpG());
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, null);
        g.RP().Ry().dsb();
        AppMethodBeat.o(51456);
    }

    public static boolean cTn() {
        AppMethodBeat.i(51457);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(51457);
        return booleanValue;
    }

    public static void nu(boolean z) {
        AppMethodBeat.i(51458);
        ab.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", Boolean.valueOf(z));
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.RP().Ry().dsb();
        AppMethodBeat.o(51458);
    }

    public static boolean cTo() {
        AppMethodBeat.i(51459);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FACEID_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(51459);
        return booleanValue;
    }

    public static void nv(boolean z) {
        AppMethodBeat.i(51460);
        ab.i("MicroMsg.FingerprintInfoStorage", "set user face id lock: %s", Boolean.valueOf(z));
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FACEID_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.RP().Ry().dsb();
        AppMethodBeat.o(51460);
    }

    public static void ac(long j, long j2) {
        AppMethodBeat.i(51462);
        z Ry = g.RP().Ry();
        if (Ry != null) {
            com.tencent.mm.plugin.walletlock.gesture.a.g gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            gVar.tVD = j;
            gVar.tVE = j2;
            Ry.set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, e.by(gVar.toByteArray()));
            Ry.dsb();
        }
        AppMethodBeat.o(51462);
    }

    public static void cTq() {
        tVb = -1;
    }

    public static long cTr() {
        return tVb;
    }

    public static void lK(long j) {
        tVb = j;
    }

    public static boolean cTp() {
        com.tencent.mm.plugin.walletlock.gesture.a.g gVar;
        AppMethodBeat.i(51461);
        z Ry = g.RP().Ry();
        if (Ry == null) {
            gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
            String str = (String) Ry.get(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, null);
            if (str == null) {
                gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            } else {
                gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g().bz(e.stringToBytes(str));
            }
        }
        if (gVar.tVD != -1) {
            e.a(gVar);
            if (gVar.tVE / 1000 < 30) {
                ac(gVar.tVD, gVar.tVE);
                AppMethodBeat.o(51461);
                return true;
            }
            Ry = g.RP().Ry();
            if (Ry != null) {
                Ry.set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, null);
                Ry.dsb();
            }
            AppMethodBeat.o(51461);
            return false;
        }
        AppMethodBeat.o(51461);
        return false;
    }
}
