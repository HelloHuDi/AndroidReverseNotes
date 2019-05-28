package com.tencent.p177mm.p1186bq;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.C35903art;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.bq.b */
public final class C25993b {
    public static void run() {
        AppMethodBeat.m2504i(28268);
        if (!C9638aw.m17179RK() || C9638aw.m17178QT()) {
            AppMethodBeat.m2505o(28268);
            return;
        }
        long anT = C5046bo.anT();
        C9638aw.m17190ZK();
        long a = C5046bo.m7514a((Long) C18628c.m29072Ry().get(331797, null), 0);
        if (10013 == C1947ae.giz && C1947ae.giA != 0) {
            a = 0;
        }
        if (a < anT) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(331797, Long.valueOf(432000 + anT));
            try {
                C35903art c35903art = new C35903art();
                c35903art.wvK = "";
                for (Account account : AccountManager.get(C4996ah.getContext()).getAccountsByType("com.google")) {
                    if (!C5046bo.isNullOrNil(c35903art.wvK)) {
                        break;
                    }
                    C4990ab.m7417i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", account.name);
                    c35903art.wvK = account.name;
                }
                if (10013 == C1947ae.giz && C1947ae.giA != 0) {
                    c35903art.wvK = "rssjbbk@gmail.com";
                }
                if (C5046bo.isNullOrNil(c35903art.wvK)) {
                    C4990ab.m7420w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                    AppMethodBeat.m2505o(28268);
                    return;
                }
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C3465a(57, c35903art));
                AppMethodBeat.m2505o(28268);
                return;
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(28268);
    }
}
