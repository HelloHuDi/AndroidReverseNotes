package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.d */
public final class C43552d implements C1837a {
    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(35880);
        C4990ab.m7416i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        C21904b.m33474kT(67);
        if (c1197a == null || c1197a.eAB == null) {
            C4990ab.m7412e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(35880);
            return;
        }
        C43553e c43553e = new C43553e();
        Object a = C1946aa.m4148a(c1197a.eAB.vED);
        c43553e.jvt = new StringBuffer();
        Map z = C5049br.m7595z(a, "sysmsg");
        c43553e.level = 0;
        if (z == null) {
            C4990ab.m7417i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", a);
            C21904b.m33474kT(68);
        } else {
            c43553e.level = C5046bo.ank((String) z.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            C4990ab.m7417i("MicroMsg.NewYearSnsAmountLevel", "get level %d", Integer.valueOf(c43553e.level));
            if (c43553e.level == 0) {
                C21904b.m33474kT(69);
            } else if (c43553e.level == 1) {
                C21904b.m33474kT(70);
            } else if (c43553e.level == 2) {
                C21904b.m33474kT(71);
            } else if (c43553e.level == 3) {
                C21904b.m33474kT(72);
            } else if (c43553e.level == 4) {
                C21904b.m33474kT(73);
            }
        }
        C4990ab.m7416i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + c43553e.jvt.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_LEVELCTRL_STRING_SYNC, a);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(35880);
    }
}
