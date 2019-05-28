package com.tencent.p177mm.plugin.walletlock.gesture.p1059a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.protocal.protobuf.bil;
import com.tencent.p177mm.protocal.protobuf.bim;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7580z;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.walletlock.gesture.a.d */
public final class C40176d {
    private static long tVb = -1;

    public static C14394g cTB() {
        AppMethodBeat.m2504i(51560);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        C14394g c14394g;
        if (Ry == null) {
            c14394g = new C14394g();
            AppMethodBeat.m2505o(51560);
            return c14394g;
        }
        Object obj = Ry.get(339969, null);
        if (obj == null) {
            c14394g = new C14394g();
            AppMethodBeat.m2505o(51560);
            return c14394g;
        }
        c14394g = new C14394g().mo26658bz(C46391e.stringToBytes((String) obj));
        AppMethodBeat.m2505o(51560);
        return c14394g;
    }

    /* renamed from: ac */
    public static void m68913ac(long j, long j2) {
        AppMethodBeat.m2504i(51561);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            C14394g c14394g = new C14394g();
            c14394g.tVD = j;
            c14394g.tVE = j2;
            Ry.set(339969, C46391e.m87264by(c14394g.toByteArray()));
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51561);
    }

    public static void cTC() {
        AppMethodBeat.m2504i(51562);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            Ry.set(339969, null);
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51562);
    }

    public static long cTr() {
        return tVb;
    }

    /* renamed from: lK */
    public static void m68915lK(long j) {
        tVb = j;
    }

    public static void cTq() {
        tVb = -1;
    }

    public static C14394g cTD() {
        AppMethodBeat.m2504i(51563);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        C14394g c14394g;
        if (Ry == null) {
            c14394g = new C14394g();
            AppMethodBeat.m2505o(51563);
            return c14394g;
        }
        Object obj = Ry.get(339971, null);
        if (obj == null) {
            c14394g = new C14394g();
            AppMethodBeat.m2505o(51563);
            return c14394g;
        }
        c14394g = new C14394g().mo26658bz(C46391e.stringToBytes((String) obj));
        AppMethodBeat.m2505o(51563);
        return c14394g;
    }

    /* renamed from: ad */
    public static void m68914ad(long j, long j2) {
        AppMethodBeat.m2504i(51564);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            C14394g c14394g = new C14394g();
            c14394g.tVD = j;
            c14394g.tVE = j2;
            Ry.set(339971, C46391e.m87264by(c14394g.toByteArray()));
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51564);
    }

    public static void cTE() {
        AppMethodBeat.m2504i(51565);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            Ry.set(339971, null);
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51565);
    }

    public static bil cTF() {
        AppMethodBeat.m2504i(51566);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry == null) {
            AppMethodBeat.m2505o(51566);
            return null;
        }
        String str = (String) Ry.get(339989, null);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51566);
            return null;
        }
        try {
            bil bil = (bil) new bil().parseFrom(Base64.decode(str, 2));
            AppMethodBeat.m2505o(51566);
            return bil;
        } catch (IllegalArgumentException e) {
            C4990ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(51566);
            return null;
        } catch (IOException e2) {
            C4990ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            AppMethodBeat.m2505o(51566);
            return null;
        }
    }

    /* renamed from: a */
    public static void m68911a(bil bil) {
        AppMethodBeat.m2504i(51567);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            try {
                Ry.set(339989, Base64.encodeToString(bil.toByteArray(), 2));
                Ry.dsb();
                C4990ab.m7419v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", Boolean.valueOf(C46391e.cTz()));
                AppMethodBeat.m2505o(51567);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(51567);
    }

    public static bim cTG() {
        AppMethodBeat.m2504i(51568);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry == null) {
            C4990ab.m7412e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
            AppMethodBeat.m2505o(51568);
            return null;
        }
        String str = (String) Ry.get(339990, null);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(51568);
            return null;
        }
        try {
            bim bim = (bim) new bim().parseFrom(Base64.decode(str, 2));
            AppMethodBeat.m2505o(51568);
            return bim;
        } catch (IllegalArgumentException e) {
            C4990ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(51568);
            return null;
        } catch (IOException e2) {
            C4990ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            AppMethodBeat.m2505o(51568);
            return null;
        }
    }

    /* renamed from: a */
    public static void m68912a(bim bim) {
        AppMethodBeat.m2504i(51569);
        if (bim != null) {
            C4990ab.m7417i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", Integer.valueOf(bim.wLR), Integer.valueOf(bim.wLT));
        }
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            try {
                Ry.set(339990, Base64.encodeToString(bim.toByteArray(), 2));
                Ry.dsb();
                AppMethodBeat.m2505o(51569);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(51569);
    }

    public static int cTH() {
        AppMethodBeat.m2504i(51570);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry == null) {
            AppMethodBeat.m2505o(51570);
            return -1;
        }
        Object obj = Ry.get(339972, null);
        if (obj == null) {
            AppMethodBeat.m2505o(51570);
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.m2505o(51570);
        return intValue;
    }

    /* renamed from: HD */
    public static void m68910HD(int i) {
        AppMethodBeat.m2504i(51571);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            Ry.set(339972, Integer.valueOf(i));
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51571);
    }

    public static void cTI() {
        AppMethodBeat.m2504i(51572);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry != null) {
            Ry.set(339972, null);
            Ry.dsb();
        }
        AppMethodBeat.m2505o(51572);
    }
}
