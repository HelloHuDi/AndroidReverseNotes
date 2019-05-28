package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {
    private static long hbj = -1;

    public static void gm(int i, int i2) {
        int i3;
        AppMethodBeat.i(51732);
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
            ab.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", Integer.valueOf(713), Integer.valueOf(i3), Long.valueOf(1));
            com.tencent.mm.plugin.report.service.h.pYm.a(713, (long) i3, 1, false);
        }
        AppMethodBeat.o(51732);
    }

    public static void nA(boolean z) {
        long j;
        AppMethodBeat.i(51733);
        ab.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", Boolean.valueOf(z));
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        if (z) {
            j = 0;
        } else {
            j = 1;
        }
        hVar.a(713, j, 1, false);
        AppMethodBeat.o(51733);
    }

    public static void cUa() {
        AppMethodBeat.i(51734);
        ab.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
        com.tencent.mm.plugin.report.service.h.pYm.a(713, 2, 1, false);
        AppMethodBeat.o(51734);
    }

    public static void cUb() {
        AppMethodBeat.i(51735);
        ab.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
        com.tencent.mm.plugin.report.service.h.pYm.a(713, 3, 1, false);
        AppMethodBeat.o(51735);
    }

    public static void cUc() {
        AppMethodBeat.i(51736);
        hbj = System.currentTimeMillis();
        ab.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", Long.valueOf(hbj));
        AppMethodBeat.o(51736);
    }

    public static void am(int i, int i2, int i3) {
        AppMethodBeat.i(51737);
        if (hbj == -1) {
            ab.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
            AppMethodBeat.o(51737);
        } else if (i == -1) {
            AppMethodBeat.o(51737);
        } else {
            ab.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", Long.valueOf(hbj), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.mm.plugin.report.service.h.pYm.e(14839, Long.valueOf(hbj), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(51737);
        }
    }
}
