package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;

public class d extends a<Boolean, cxt> {
    public final /* synthetic */ Object b(final String str, String str2, Object obj) {
        AppMethodBeat.i(129463);
        cxt cxt = (cxt) obj;
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdGetContact", "invalid username & appId");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(129463);
            return bool;
        }
        final b dMj = f.dMj();
        dMj.dMi();
        final int i = cxt.xsZ.xsX;
        a aVar = a.gWl;
        a.z((long) i, 24);
        new k(str, str2).acy().j(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<cwy>>() {
            public final /* synthetic */ Object call(Object obj) {
                int i;
                int i2;
                AppMethodBeat.i(129462);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.AppBrand.Predownload.CmdGetContact", "getContact(%s) back, errType %d, errCode %d, errMsg %s", str, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                if (com.tencent.mm.plugin.appbrand.k.a.b(aVar)) {
                    boolean a = com.tencent.mm.plugin.appbrand.app.f.auO().a(str, ((cwy) aVar.fsy).vMS, ((cwy) aVar.fsy).vMT);
                    dMj.B(Boolean.TRUE);
                    a aVar2 = a.gWl;
                    i = i;
                    i2 = a ? 25 : 27;
                } else {
                    dMj.B(Boolean.FALSE);
                    a aVar3 = a.gWl;
                    i = i;
                    i2 = 26;
                }
                a.z((long) i, (long) i2);
                Void voidR = zXH;
                AppMethodBeat.o(129462);
                return voidR;
            }
        });
        Object obj2 = Boolean.TRUE;
        AppMethodBeat.o(129463);
        return obj2;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxt) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdGetContact";
    }
}
