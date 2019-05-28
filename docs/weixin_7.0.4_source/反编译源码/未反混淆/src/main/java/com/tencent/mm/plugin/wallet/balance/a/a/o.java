package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.y;
import java.io.IOException;
import junit.framework.Assert;

public final class o extends a<bla, h> {
    public final /* synthetic */ btd bLr() {
        AppMethodBeat.i(45245);
        bla cME = cME();
        AppMethodBeat.o(45245);
        return cME;
    }

    public final void e(com.tencent.mm.ai.a.a<bla> aVar) {
        AppMethodBeat.i(45243);
        ab.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (((h) this.fsz).scene == 2) {
            AppMethodBeat.o(45243);
            return;
        }
        if (aVar.errType == 0 && aVar.errCode == 0 && ((bla) aVar.fsy).kdT == 0) {
            try {
                ((com.tencent.mm.plugin.wxpay.a.a) g.M(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ac.a.USERINFO_LQT_PLAN_ADD_CACHE_STRING_SYNC, new String(((bla) aVar.fsy).toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                AppMethodBeat.o(45243);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(45243);
    }

    private bla cME() {
        AppMethodBeat.i(45244);
        if (((h) this.fsz).scene == 2) {
            AppMethodBeat.o(45244);
            return null;
        }
        String str;
        y walletCacheStg = ((com.tencent.mm.plugin.wxpay.a.a) g.M(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg();
        ac.a aVar = ac.a.USERINFO_LQT_PLAN_ADD_CACHE_STRING_SYNC;
        String str2 = "";
        if (aVar == null) {
            str = str2;
        } else {
            String name = aVar.name();
            if (bo.isNullOrNil(name)) {
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
                if (str3 == null || str3 == y.xIt) {
                    str3 = str2;
                }
                if (y.a(str, str3, false)) {
                    str = str3;
                } else {
                    str = str2;
                }
            }
        }
        str = str;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(45244);
            return null;
        }
        try {
            bla bla = (bla) new bla().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            AppMethodBeat.o(45244);
            return bla;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e, "", new Object[0]);
            AppMethodBeat.o(45244);
            return null;
        }
    }
}
