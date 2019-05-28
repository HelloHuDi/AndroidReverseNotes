package com.tencent.p177mm.plugin.walletlock.p1319c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C14373a;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40175b;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40176d;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30973j;

/* renamed from: com.tencent.mm.plugin.walletlock.c.g */
public enum C40171g {
    ;
    
    int mType;
    public String tWZ;
    public C30973j tXa;

    private C40171g(String str) {
        this.mType = -1;
    }

    static {
        AppMethodBeat.m2505o(51731);
    }

    /* renamed from: HG */
    public final void mo63507HG(int i) {
        AppMethodBeat.m2504i(51717);
        C4990ab.m7417i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", Integer.valueOf(this.mType), Integer.valueOf(i));
        this.mType = i;
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(i));
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(51717);
    }

    public final int cTV() {
        AppMethodBeat.m2504i(51718);
        if (this.mType == -1) {
            this.mType = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        }
        int i = this.mType;
        AppMethodBeat.m2505o(51718);
        return i;
    }

    public static boolean cTz() {
        AppMethodBeat.m2504i(51719);
        boolean cTz = C40175b.cTz();
        AppMethodBeat.m2505o(51719);
        return cTz;
    }

    /* renamed from: nx */
    public static void m68900nx(boolean z) {
        AppMethodBeat.m2504i(51720);
        C40175b.m68909nx(z);
        AppMethodBeat.m2505o(51720);
    }

    public static boolean cTn() {
        AppMethodBeat.m2504i(51721);
        C4990ab.m7417i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", Boolean.valueOf(C14373a.cTn()));
        AppMethodBeat.m2505o(51721);
        return C14373a.cTn();
    }

    public static void cTW() {
        AppMethodBeat.m2504i(51722);
        C14373a.m22587nu(true);
        AppMethodBeat.m2505o(51722);
    }

    public static boolean cTo() {
        AppMethodBeat.m2504i(51723);
        boolean cTo = C14373a.cTo();
        AppMethodBeat.m2505o(51723);
        return cTo;
    }

    public static void cTX() {
        AppMethodBeat.m2504i(51724);
        C14373a.m22588nv(true);
        AppMethodBeat.m2505o(51724);
    }

    /* renamed from: ny */
    public static void m68901ny(boolean z) {
        AppMethodBeat.m2504i(51725);
        C4990ab.m7416i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
        C40171g.m68902nz(z);
        C40175b.m68909nx(false);
        C14373a.m22588nv(false);
        if (z) {
            C14373a.cTm();
        }
        AppMethodBeat.m2505o(51725);
    }

    /* renamed from: nz */
    public static void m68902nz(boolean z) {
        AppMethodBeat.m2504i(51726);
        C14373a.m22587nu(false);
        if (z) {
            C14373a.cTm();
        }
        AppMethodBeat.m2505o(51726);
    }

    public final boolean cTk() {
        AppMethodBeat.m2504i(51727);
        boolean cTA;
        if (this.mType == 1) {
            cTA = C40175b.cTA();
            AppMethodBeat.m2505o(51727);
            return cTA;
        } else if (this.mType == 2) {
            C4990ab.m7417i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", Boolean.valueOf(C14373a.cTp()));
            cTA = C14373a.cTp();
            AppMethodBeat.m2505o(51727);
            return cTA;
        } else {
            AppMethodBeat.m2505o(51727);
            return false;
        }
    }

    public static void cTq() {
        AppMethodBeat.m2504i(51728);
        C40176d.cTq();
        C14373a.cTq();
        AppMethodBeat.m2505o(51728);
    }

    public static boolean cTY() {
        AppMethodBeat.m2504i(51729);
        if (C40171g.cTZ() && C4104m.cvU() && C40997a.m71097iP(C4996ah.getContext())) {
            AppMethodBeat.m2505o(51729);
            return true;
        }
        AppMethodBeat.m2505o(51729);
        return false;
    }

    public static boolean cTZ() {
        AppMethodBeat.m2504i(51730);
        if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("TouchLockFunction", 0) != 1) {
            AppMethodBeat.m2505o(51730);
            return true;
        }
        AppMethodBeat.m2505o(51730);
        return false;
    }
}
