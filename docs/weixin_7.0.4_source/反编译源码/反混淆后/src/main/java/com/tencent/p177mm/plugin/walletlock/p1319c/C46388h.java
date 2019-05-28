package com.tencent.p177mm.plugin.walletlock.p1319c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.walletlock.c.h */
public final class C46388h {
    private static long hbj = -1;

    /* renamed from: gm */
    public static void m87251gm(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(51732);
        switch (i2) {
            case 5:
                i3 = 5;
                break;
            case 10:
                i3 = 6;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 4;
                    break;
                }
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            C4990ab.m7417i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", Integer.valueOf(713), Integer.valueOf(i3), Long.valueOf(1));
            C7060h.pYm.mo8378a(713, (long) i3, 1, false);
        }
        AppMethodBeat.m2505o(51732);
    }

    /* renamed from: nA */
    public static void m87252nA(boolean z) {
        long j;
        AppMethodBeat.m2504i(51733);
        C4990ab.m7417i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", Boolean.valueOf(z));
        C7060h c7060h = C7060h.pYm;
        if (z) {
            j = 0;
        } else {
            j = 1;
        }
        c7060h.mo8378a(713, j, 1, false);
        AppMethodBeat.m2505o(51733);
    }

    public static void cUa() {
        AppMethodBeat.m2504i(51734);
        C4990ab.m7416i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
        C7060h.pYm.mo8378a(713, 2, 1, false);
        AppMethodBeat.m2505o(51734);
    }

    public static void cUb() {
        AppMethodBeat.m2504i(51735);
        C4990ab.m7416i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
        C7060h.pYm.mo8378a(713, 3, 1, false);
        AppMethodBeat.m2505o(51735);
    }

    public static void cUc() {
        AppMethodBeat.m2504i(51736);
        hbj = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", Long.valueOf(hbj));
        AppMethodBeat.m2505o(51736);
    }

    /* renamed from: am */
    public static void m87250am(int i, int i2, int i3) {
        AppMethodBeat.m2504i(51737);
        if (hbj == -1) {
            C4990ab.m7412e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
            AppMethodBeat.m2505o(51737);
        } else if (i == -1) {
            AppMethodBeat.m2505o(51737);
        } else {
            C4990ab.m7417i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", Long.valueOf(hbj), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            C7060h.pYm.mo8381e(14839, Long.valueOf(hbj), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.m2505o(51737);
        }
    }
}
