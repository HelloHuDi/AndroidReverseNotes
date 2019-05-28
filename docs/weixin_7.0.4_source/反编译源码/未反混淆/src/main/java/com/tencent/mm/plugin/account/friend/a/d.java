package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;

public final class d extends e {
    public final bi a(cm cmVar, String str, String str2, String str3) {
        AppMethodBeat.i(108326);
        String a = aa.a(cmVar.vED);
        if (a == null || a.length() <= 0) {
            ab.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            AppMethodBeat.o(108326);
            return null;
        }
        a apC = a.apC(a);
        if (cmVar.nao == 66) {
            ((b) g.K(b.class)).vh(apC.xZo);
        }
        if (bo.nullAsNil(apC.svN).length() > 0) {
            h hVar = new h();
            hVar.username = apC.svN;
            hVar.dtR = 3;
            hVar.cB(true);
            hVar.frW = apC.xZk;
            hVar.frV = apC.xZl;
            hVar.bJt = -1;
            ab.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", apC.svN, hVar.ack(), hVar.acl());
            o.act().b(hVar);
        }
        bi a2 = super.a(cmVar, str, str2, str3);
        AppMethodBeat.o(108326);
        return a2;
    }
}
