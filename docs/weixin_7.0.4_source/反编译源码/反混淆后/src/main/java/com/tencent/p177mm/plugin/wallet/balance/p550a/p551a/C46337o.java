package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.wxpay.p1335a.C23225a;
import com.tencent.p177mm.protocal.protobuf.bla;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C40930y;
import com.tencent.p177mm.wallet_core.p649c.C44421a;
import java.io.IOException;
import junit.framework.Assert;
import org.apache.commons.p1431a.C41168a;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.o */
public final class C46337o extends C44421a<bla, C29530h> {
    public final /* synthetic */ btd bLr() {
        AppMethodBeat.m2504i(45245);
        bla cME = cME();
        AppMethodBeat.m2505o(45245);
        return cME;
    }

    /* renamed from: e */
    public final void mo56147e(C37441a<bla> c37441a) {
        AppMethodBeat.m2504i(45243);
        C4990ab.m7417i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType));
        if (((C29530h) this.fsz).scene == 2) {
            AppMethodBeat.m2505o(45243);
            return;
        }
        if (c37441a.errType == 0 && c37441a.errCode == 0 && ((bla) c37441a.fsy).kdT == 0) {
            try {
                ((C23225a) C1720g.m3530M(C23225a.class)).getWalletCacheStg().set(C5127a.USERINFO_LQT_PLAN_ADD_CACHE_STRING_SYNC, new String(((bla) c37441a.fsy).toByteArray(), C41168a.ISO_8859_1));
                AppMethodBeat.m2505o(45243);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(45243);
    }

    private bla cME() {
        AppMethodBeat.m2504i(45244);
        if (((C29530h) this.fsz).scene == 2) {
            AppMethodBeat.m2505o(45244);
            return null;
        }
        String str;
        C40930y walletCacheStg = ((C23225a) C1720g.m3530M(C23225a.class)).getWalletCacheStg();
        C5127a c5127a = C5127a.USERINFO_LQT_PLAN_ADD_CACHE_STRING_SYNC;
        String str2 = "";
        if (c5127a == null) {
            str = str2;
        } else {
            String name = c5127a.name();
            if (C5046bo.isNullOrNil(name)) {
                str = str2;
            } else {
                String[] split = name.split("_");
                str = split[split.length - 1];
                if (str.equals("SYNC")) {
                    str = split[split.length - 2];
                }
                name = name.substring(0, name.lastIndexOf(str) + str.length());
                Assert.assertNotNull("db is null", walletCacheStg.fni);
                String str3 = walletCacheStg.AfU.get(name);
                if (str3 == null || str3 == C40930y.xIt) {
                    str3 = str2;
                }
                if (C40930y.m70957a(str, str3, false)) {
                    str = str3;
                } else {
                    str = str2;
                }
            }
        }
        str = str;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45244);
            return null;
        }
        try {
            bla bla = (bla) new bla().parseFrom(str.getBytes(C41168a.ISO_8859_1));
            AppMethodBeat.m2505o(45244);
            return bla;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            AppMethodBeat.m2505o(45244);
            return null;
        }
    }
}
