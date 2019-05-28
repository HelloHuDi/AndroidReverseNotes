package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.soter.core.c.j;

public enum g {
    ;
    
    int mType;
    public String tWZ;
    public j tXa;

    private g(String str) {
        this.mType = -1;
    }

    static {
        AppMethodBeat.o(51731);
    }

    public final void HG(int i) {
        AppMethodBeat.i(51717);
        ab.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", Integer.valueOf(this.mType), Integer.valueOf(i));
        this.mType = i;
        com.tencent.mm.kernel.g.RP().Ry().set(a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(i));
        com.tencent.mm.kernel.g.RP().Ry().dsb();
        AppMethodBeat.o(51717);
    }

    public final int cTV() {
        AppMethodBeat.i(51718);
        if (this.mType == -1) {
            this.mType = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        }
        int i = this.mType;
        AppMethodBeat.o(51718);
        return i;
    }

    public static boolean cTz() {
        AppMethodBeat.i(51719);
        boolean cTz = b.cTz();
        AppMethodBeat.o(51719);
        return cTz;
    }

    public static void nx(boolean z) {
        AppMethodBeat.i(51720);
        b.nx(z);
        AppMethodBeat.o(51720);
    }

    public static boolean cTn() {
        AppMethodBeat.i(51721);
        ab.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTn()));
        AppMethodBeat.o(51721);
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTn();
    }

    public static void cTW() {
        AppMethodBeat.i(51722);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.nu(true);
        AppMethodBeat.o(51722);
    }

    public static boolean cTo() {
        AppMethodBeat.i(51723);
        boolean cTo = com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTo();
        AppMethodBeat.o(51723);
        return cTo;
    }

    public static void cTX() {
        AppMethodBeat.i(51724);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.nv(true);
        AppMethodBeat.o(51724);
    }

    public static void ny(boolean z) {
        AppMethodBeat.i(51725);
        ab.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
        nz(z);
        b.nx(false);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.nv(false);
        if (z) {
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTm();
        }
        AppMethodBeat.o(51725);
    }

    public static void nz(boolean z) {
        AppMethodBeat.i(51726);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.nu(false);
        if (z) {
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTm();
        }
        AppMethodBeat.o(51726);
    }

    public final boolean cTk() {
        AppMethodBeat.i(51727);
        boolean cTA;
        if (this.mType == 1) {
            cTA = b.cTA();
            AppMethodBeat.o(51727);
            return cTA;
        } else if (this.mType == 2) {
            ab.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTp()));
            cTA = com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTp();
            AppMethodBeat.o(51727);
            return cTA;
        } else {
            AppMethodBeat.o(51727);
            return false;
        }
    }

    public static void cTq() {
        AppMethodBeat.i(51728);
        d.cTq();
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTq();
        AppMethodBeat.o(51728);
    }

    public static boolean cTY() {
        AppMethodBeat.i(51729);
        if (cTZ() && m.cvU() && com.tencent.soter.core.a.iP(ah.getContext())) {
            AppMethodBeat.o(51729);
            return true;
        }
        AppMethodBeat.o(51729);
        return false;
    }

    public static boolean cTZ() {
        AppMethodBeat.i(51730);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("TouchLockFunction", 0) != 1) {
            AppMethodBeat.o(51730);
            return true;
        }
        AppMethodBeat.o(51730);
        return false;
    }
}
