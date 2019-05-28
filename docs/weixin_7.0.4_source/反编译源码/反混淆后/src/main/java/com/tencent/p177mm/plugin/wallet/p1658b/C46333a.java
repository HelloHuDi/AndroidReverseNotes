package com.tencent.p177mm.plugin.wallet.p1658b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.wallet.b.a */
public final class C46333a {
    /* renamed from: Hn */
    public static boolean m87050Hn(int i) {
        AppMethodBeat.m2504i(46462);
        C1720g.m3537RQ();
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
            AppMethodBeat.m2505o(46462);
            return false;
        }
        AppMethodBeat.m2505o(46462);
        return true;
    }

    public static boolean cOQ() {
        boolean z;
        AppMethodBeat.m2504i(46463);
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        C4990ab.m7416i("MicroMsg.WalletUtil", "mgr==null?" + (c30052l == null));
        if (c30052l != null) {
            C4990ab.m7416i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + c30052l.bxs());
        }
        C46332s.cNC();
        C22587ak cND = C46332s.cND();
        C29629ai cQo = cND.cQo();
        String str = "MicroMsg.WalletUtil";
        StringBuilder stringBuilder = new StringBuilder("config==null?");
        if (cQo == null) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7416i(str, stringBuilder.append(z).toString());
        if (cQo != null) {
            C4990ab.m7416i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + cQo.cPY());
        }
        C4990ab.m7416i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + cND.cQg());
        if (c30052l != null && c30052l.bxs() && cQo != null && cQo.cPY() && cND.cQg()) {
            AppMethodBeat.m2505o(46463);
            return true;
        }
        AppMethodBeat.m2505o(46463);
        return false;
    }

    public static boolean cOR() {
        AppMethodBeat.m2504i(46464);
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (c30052l == null) {
            C4990ab.m7420w("MicroMsg.WalletUtil", "no finger mgr!");
            AppMethodBeat.m2505o(46464);
            return false;
        }
        C46332s.cNC();
        C22587ak cND = C46332s.cND();
        C29629ai cQo = cND.cQo();
        C7060h.pYm.mo15419k(916, 0, 1);
        C4990ab.m7417i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", Boolean.valueOf(c30052l.bxA()), Boolean.valueOf(cQo.cPY()), Boolean.valueOf(cND.cQg()));
        if (c30052l.bxA() && cQo.cPY() && cND.cQg()) {
            AppMethodBeat.m2505o(46464);
            return true;
        }
        AppMethodBeat.m2505o(46464);
        return false;
    }
}
