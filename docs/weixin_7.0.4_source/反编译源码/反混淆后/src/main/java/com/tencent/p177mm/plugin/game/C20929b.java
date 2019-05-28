package com.tencent.p177mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.p850a.C9541b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26183ky;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.plugin.game.b */
public final class C20929b implements C43155a {
    private boolean mSP = false;
    private boolean mSQ = false;

    public final boolean bCS() {
        AppMethodBeat.m2504i(111124);
        try {
            boolean bDd = C45985a.bDd();
            AppMethodBeat.m2505o(111124);
            return bDd;
        } catch (Exception e) {
            AppMethodBeat.m2505o(111124);
            return true;
        }
    }

    /* renamed from: dV */
    public final void mo36279dV(Context context) {
        AppMethodBeat.m2504i(111132);
        C20993e.m32270dV(context);
        AppMethodBeat.m2505o(111132);
    }

    public final String bCT() {
        AppMethodBeat.m2504i(111133);
        String ef = C20993e.m32279ef(C4996ah.getContext());
        AppMethodBeat.m2505o(111133);
        return ef;
    }

    /* renamed from: hH */
    public final void mo36280hH(boolean z) {
        AppMethodBeat.m2504i(111134);
        if (!this.mSQ) {
            boolean z2;
            if (((C9541b) C1720g.m3528K(C9541b.class)).mo20808a(C11745a.game_luggage) && ((C9541b) C1720g.m3528K(C9541b.class)).mo20808a(C11745a.preload_game_webcore)) {
                C4990ab.m7416i("MicroMsg.GameDelegateImpl", "hit expt preload");
                C7060h.pYm.mo15419k(939, 4, 1);
                if (YearClass.get(C4996ah.getContext()) < 2014) {
                    C4990ab.m7416i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
                    C7060h.pYm.mo15419k(939, 5, 1);
                    z2 = false;
                } else {
                    if (System.currentTimeMillis() - C20993e.bEd() > 21600000) {
                        C4990ab.m7416i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
                        if (z) {
                            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                            C28229n bEm = C39215q.bEm();
                            if (bEm == null || System.currentTimeMillis() - (bEm.field_receiveTime * 1000) > 21600000) {
                                C4990ab.m7416i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
                                C7060h.pYm.mo15419k(939, 7, 1);
                                z2 = false;
                            }
                        } else {
                            C7060h.pYm.mo15419k(939, 6, 1);
                            z2 = false;
                        }
                    }
                    if (C5059g.dnY()) {
                        C4990ab.m7416i("MicroMsg.GameDelegateImpl", "isGPVersion");
                        C7060h.pYm.mo15419k(939, 8, 1);
                        z2 = false;
                    } else if (C5046bo.isNullOrNil(C46001c.bFG())) {
                        C7060h.pYm.mo15419k(939, 9, 1);
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            this.mSP = z2;
            this.mSQ = true;
        }
        if (this.mSP) {
            String bFG = C46001c.bFG();
            if (!C5046bo.isNullOrNil(bFG)) {
                C4990ab.m7416i("MicroMsg.GameDelegateImpl", "preload");
                C26183ky c26183ky = new C26183ky();
                c26183ky.cGQ.type = 3;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", bFG);
                c26183ky.cGQ.intent = intent;
                C4879a.xxA.mo10055m(c26183ky);
            }
        }
        AppMethodBeat.m2505o(111134);
    }

    /* renamed from: a */
    public final void mo36275a(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.m2504i(111125);
        C37860c.eBG.mo60579a(str, str2, i, i2, str3, i3);
        AppMethodBeat.m2505o(111125);
    }

    /* renamed from: a */
    public final void mo36274a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.m2504i(111126);
        C37860c.eBG.mo60576a(context, str, str2, str3, i, str4, i2);
        AppMethodBeat.m2505o(111126);
    }

    /* renamed from: a */
    public final void mo36276a(String str, String str2, int i, int i2, String str3, long j, String str4) {
        AppMethodBeat.m2504i(111127);
        C40439f bT = C46494g.m87739bT(str, true);
        if (bT != null) {
            C37860c.eBG.mo60580a(str, str2, i, i2, str3, j, bT.mo63847xy(), str4);
        }
        AppMethodBeat.m2505o(111127);
    }

    /* renamed from: W */
    public final void mo36272W(String str, int i, int i2) {
        AppMethodBeat.m2504i(111128);
        C37860c.eBG.mo60582i(str, i, i2);
        AppMethodBeat.m2505o(111128);
    }

    /* renamed from: m */
    public final void mo36282m(String str, String str2, String str3) {
        AppMethodBeat.m2504i(111129);
        C37860c.eBG.mo60584m(str, str2, str3);
        AppMethodBeat.m2505o(111129);
    }

    /* renamed from: j */
    public final void mo36281j(Context context, String str, String str2) {
        AppMethodBeat.m2504i(111130);
        C37860c.eBG.mo60583j(context, str, str2);
        AppMethodBeat.m2505o(111130);
    }

    /* renamed from: a */
    public final void mo36273a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(111131);
        C37860c.eBG.mo60575a(context, str, str2, str3, i, i2, i3, str4, 0, str5, str6);
        AppMethodBeat.m2505o(111131);
    }
}
