package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.util.Map;

public final class d implements a {
    public final void a(e.a aVar) {
        AppMethodBeat.i(35880);
        ab.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.kT(67);
        if (aVar == null || aVar.eAB == null) {
            ab.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(35880);
            return;
        }
        e eVar = new e();
        Object a = aa.a(aVar.eAB.vED);
        eVar.jvt = new StringBuffer();
        Map z = br.z(a, "sysmsg");
        eVar.level = 0;
        if (z == null) {
            ab.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", a);
            b.kT(68);
        } else {
            eVar.level = bo.ank((String) z.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            ab.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", Integer.valueOf(eVar.level));
            if (eVar.level == 0) {
                b.kT(69);
            } else if (eVar.level == 1) {
                b.kT(70);
            } else if (eVar.level == 2) {
                b.kT(71);
            } else if (eVar.level == 3) {
                b.kT(72);
            } else if (eVar.level == 4) {
                b.kT(73);
            }
        }
        ab.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + eVar.jvt.toString());
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_LEVELCTRL_STRING_SYNC, a);
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(35880);
    }
}
