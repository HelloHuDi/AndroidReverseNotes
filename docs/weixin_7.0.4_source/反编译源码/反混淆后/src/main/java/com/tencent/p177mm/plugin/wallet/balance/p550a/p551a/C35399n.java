package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.protocal.protobuf.bkl;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44421a;
import java.io.IOException;
import org.apache.commons.p1431a.C41168a;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.n */
public final class C35399n extends C44421a<bkl, C14106g> {
    public final /* synthetic */ btd bLr() {
        AppMethodBeat.m2504i(45242);
        bkl cMD = C35399n.cMD();
        AppMethodBeat.m2505o(45242);
        return cMD;
    }

    /* renamed from: e */
    public final void mo56147e(C37441a<bkl> c37441a) {
        AppMethodBeat.m2504i(45240);
        C4990ab.m7417i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType));
        if (c37441a.errType == 0 && c37441a.errCode == 0 && ((bkl) c37441a.fsy).kdT == 0) {
            try {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_PLAN_INDEX_CACHE_STRING_SYNC, new String(((bkl) c37441a.fsy).toByteArray(), C41168a.ISO_8859_1));
                AppMethodBeat.m2505o(45240);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(45240);
    }

    private static bkl cMD() {
        AppMethodBeat.m2504i(45241);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LQT_PLAN_INDEX_CACHE_STRING_SYNC, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(45241);
            return null;
        }
        try {
            bkl bkl = (bkl) new bkl().parseFrom(str.getBytes(C41168a.ISO_8859_1));
            AppMethodBeat.m2505o(45241);
            return bkl;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            AppMethodBeat.m2505o(45241);
            return null;
        }
    }
}
