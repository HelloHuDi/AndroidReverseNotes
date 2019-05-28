package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.protocal.protobuf.aoj;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44421a;
import java.io.IOException;
import org.apache.commons.p1431a.C41168a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.f */
public final class C46061f extends C44421a<aoj, C46059c> {
    private static C46061f nWA;

    public final /* synthetic */ btd bLr() {
        AppMethodBeat.m2504i(42277);
        aoj bLq = C46061f.bLq();
        AppMethodBeat.m2505o(42277);
        return bLq;
    }

    public static C46061f bLp() {
        AppMethodBeat.m2504i(42274);
        if (nWA == null) {
            nWA = new C46061f();
        }
        C46061f c46061f = nWA;
        AppMethodBeat.m2505o(42274);
        return c46061f;
    }

    /* renamed from: e */
    public final void mo56147e(C37441a<aoj> c37441a) {
        AppMethodBeat.m2504i(42275);
        C4990ab.m7417i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType));
        if (c37441a.errType == 0 && c37441a.errCode == 0 && ((aoj) c37441a.fsy).kCl == 0) {
            try {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_SNAPSHOT_STRING_SYNC, new String(((aoj) c37441a.fsy).toByteArray(), C41168a.ISO_8859_1));
                AppMethodBeat.m2505o(42275);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(42275);
    }

    private static aoj bLq() {
        AppMethodBeat.m2504i(42276);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_SNAPSHOT_STRING_SYNC, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(42276);
            return null;
        }
        try {
            aoj aoj = (aoj) new aoj().parseFrom(str.getBytes(C41168a.ISO_8859_1));
            AppMethodBeat.m2505o(42276);
            return aoj;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", e, "", new Object[0]);
            AppMethodBeat.m2505o(42276);
            return null;
        }
    }
}
