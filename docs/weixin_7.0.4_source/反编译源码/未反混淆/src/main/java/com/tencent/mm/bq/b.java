package com.tencent.mm.bq;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    public static void run() {
        AppMethodBeat.i(28268);
        if (!aw.RK() || aw.QT()) {
            AppMethodBeat.o(28268);
            return;
        }
        long anT = bo.anT();
        aw.ZK();
        long a = bo.a((Long) c.Ry().get(331797, null), 0);
        if (10013 == ae.giz && ae.giA != 0) {
            a = 0;
        }
        if (a < anT) {
            aw.ZK();
            c.Ry().set(331797, Long.valueOf(432000 + anT));
            try {
                art art = new art();
                art.wvK = "";
                for (Account account : AccountManager.get(ah.getContext()).getAccountsByType("com.google")) {
                    if (!bo.isNullOrNil(art.wvK)) {
                        break;
                    }
                    ab.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", account.name);
                    art.wvK = account.name;
                }
                if (10013 == ae.giz && ae.giA != 0) {
                    art.wvK = "rssjbbk@gmail.com";
                }
                if (bo.isNullOrNil(art.wvK)) {
                    ab.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                    AppMethodBeat.o(28268);
                    return;
                }
                aw.ZK();
                c.XL().c(new a(57, art));
                AppMethodBeat.o(28268);
                return;
            } catch (Exception e) {
                ab.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", e.getMessage());
            }
        }
        AppMethodBeat.o(28268);
    }
}
