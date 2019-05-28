package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class i {
    public static void mn(String str) {
        AppMethodBeat.i(11228);
        Assert.assertTrue(!bo.isNullOrNil(str));
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.o(11228);
            return;
        }
        aoO.setType(aoO.field_type | 2048);
        t.u(aoO);
        if (((j) g.K(j.class)).XR().aoZ(str) == null && aoO.dsf()) {
            if (f.qZ(str)) {
                ak akVar;
                if (((j) g.K(j.class)).XR().aoZ("officialaccounts") == null) {
                    akVar = new ak("officialaccounts");
                    akVar.dsI();
                    ((j) g.K(j.class)).XR().d(akVar);
                }
                akVar = new ak(str);
                akVar.eD(System.currentTimeMillis());
                akVar.jj("officialaccounts");
                ((j) g.K(j.class)).XR().d(akVar);
            } else if (f.rb(str) && !f.kq(str)) {
                ak akVar2;
                d qX = f.qX(str);
                if (((j) g.K(j.class)).XR().aoZ(qX.field_enterpriseFather) == null) {
                    akVar2 = new ak(qX.field_enterpriseFather);
                    akVar2.dsI();
                    ((j) g.K(j.class)).XR().d(akVar2);
                }
                akVar2 = new ak(str);
                akVar2.eD(System.currentTimeMillis());
                akVar2.jj(qX.adX());
                ((j) g.K(j.class)).XR().d(akVar2);
            }
            ab.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(str)));
        }
        ((j) g.K(j.class)).XR().apf(str);
        AppMethodBeat.o(11228);
    }

    public static int a(final String str, final long j, final a aVar) {
        AppMethodBeat.i(11229);
        ab.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", Long.valueOf(j));
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11226);
                Cursor aP = ((o) g.K(o.class)).XP().aP(str, j);
                if (aP.moveToFirst()) {
                    while (!aP.isAfterLast() && (aVar == null || !aVar.JU())) {
                        bi biVar = new bi();
                        biVar.d(aP);
                        bf.m(biVar);
                        aP.moveToNext();
                    }
                }
                aP.close();
                ((o) g.K(o.class)).XP().aO(str, j);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(11225);
                        if (aVar != null) {
                            aVar.JV();
                        }
                        AppMethodBeat.o(11225);
                    }
                });
                AppMethodBeat.o(11226);
            }

            public final String toString() {
                AppMethodBeat.i(11227);
                String str = super.toString() + "|deleteMsgByTalker";
                AppMethodBeat.o(11227);
                return str;
            }
        });
        AppMethodBeat.o(11229);
        return 0;
    }
}
