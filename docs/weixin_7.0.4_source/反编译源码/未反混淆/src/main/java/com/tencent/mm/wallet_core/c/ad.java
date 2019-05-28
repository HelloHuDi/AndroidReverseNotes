package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class ad {
    public static void o(int i, String str, int i2) {
        AppMethodBeat.i(49100);
        ab.v("Micromsg.WalletPayLinkReport", "kvStatStartPay scene %s reqKey %s errcode %s", Integer.valueOf(i), str, Integer.valueOf(i2));
        h.pYm.e(14997, Integer.valueOf(i), str, Integer.valueOf(i2));
        AppMethodBeat.o(49100);
    }

    public static void e(int i, String str, int i2, String str2) {
        AppMethodBeat.i(49101);
        ab.v("Micromsg.WalletPayLinkReport", "kvAction scene %s reqKey %s action %s info %s", Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        h.pYm.e(15001, Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        AppMethodBeat.o(49101);
    }
}
