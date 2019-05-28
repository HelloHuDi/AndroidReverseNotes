package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.c.a;
import java.io.IOException;

public final class f extends a<aoj, c> {
    private static f nWA;

    public final /* synthetic */ btd bLr() {
        AppMethodBeat.i(42277);
        aoj bLq = bLq();
        AppMethodBeat.o(42277);
        return bLq;
    }

    public static f bLp() {
        AppMethodBeat.i(42274);
        if (nWA == null) {
            nWA = new f();
        }
        f fVar = nWA;
        AppMethodBeat.o(42274);
        return fVar;
    }

    public final void e(com.tencent.mm.ai.a.a<aoj> aVar) {
        AppMethodBeat.i(42275);
        ab.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (aVar.errType == 0 && aVar.errCode == 0 && ((aoj) aVar.fsy).kCl == 0) {
            try {
                g.RP().Ry().set(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_SNAPSHOT_STRING_SYNC, new String(((aoj) aVar.fsy).toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                AppMethodBeat.o(42275);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(42275);
    }

    private static aoj bLq() {
        AppMethodBeat.i(42276);
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_SNAPSHOT_STRING_SYNC, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(42276);
            return null;
        }
        try {
            aoj aoj = (aoj) new aoj().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            AppMethodBeat.o(42276);
            return aoj;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", e, "", new Object[0]);
            AppMethodBeat.o(42276);
            return null;
        }
    }
}
