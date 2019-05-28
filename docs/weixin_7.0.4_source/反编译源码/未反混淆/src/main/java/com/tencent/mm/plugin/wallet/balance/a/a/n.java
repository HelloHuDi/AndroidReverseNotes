package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.c.a;
import java.io.IOException;

public final class n extends a<bkl, g> {
    public final /* synthetic */ btd bLr() {
        AppMethodBeat.i(45242);
        bkl cMD = cMD();
        AppMethodBeat.o(45242);
        return cMD;
    }

    public final void e(com.tencent.mm.ai.a.a<bkl> aVar) {
        AppMethodBeat.i(45240);
        ab.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (aVar.errType == 0 && aVar.errCode == 0 && ((bkl) aVar.fsy).kdT == 0) {
            try {
                g.RP().Ry().set(ac.a.USERINFO_LQT_PLAN_INDEX_CACHE_STRING_SYNC, new String(((bkl) aVar.fsy).toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                AppMethodBeat.o(45240);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(45240);
    }

    private static bkl cMD() {
        AppMethodBeat.i(45241);
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_LQT_PLAN_INDEX_CACHE_STRING_SYNC, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45241);
            return null;
        }
        try {
            bkl bkl = (bkl) new bkl().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            AppMethodBeat.o(45241);
            return bkl;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            AppMethodBeat.o(45241);
            return null;
        }
    }
}
