package com.tencent.p177mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.sport.model.C22172n;
import com.tencent.p177mm.plugin.sport.model.C35161f;
import com.tencent.p177mm.plugin.sport.model.C43621d;
import com.tencent.p177mm.plugin.sport.model.C43624l;
import com.tencent.p177mm.plugin.sport.model.C46267a.C292623;
import com.tencent.p177mm.plugin.sport.model.C46268m;
import com.tencent.p177mm.plugin.sport.p1302a.C29259e;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.plugin.sport.p1302a.C46265c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sport.b */
public final class C46266b implements C39858b {
    public final void cvX() {
        AppMethodBeat.m2504i(93616);
        if (((PluginSport) C1720g.m3530M(PluginSport.class)).getDeviceStepManager() != null) {
            ((PluginSport) C1720g.m3530M(PluginSport.class)).getDeviceStepManager().cwd();
        }
        AppMethodBeat.m2505o(93616);
    }

    /* renamed from: b */
    public final void mo63049b(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.m2504i(93617);
        if (C1720g.m3531RK()) {
            C1720g.m3540Rg().mo14541a(new C35161f(str, str2, i, i2, i3, str3, 1), 0);
        }
        AppMethodBeat.m2505o(93617);
    }

    /* renamed from: eU */
    public final boolean mo63057eU(Context context) {
        AppMethodBeat.m2504i(93618);
        boolean eU = C22172n.m33799eU(context);
        AppMethodBeat.m2505o(93618);
        return eU;
    }

    public final boolean cvY() {
        AppMethodBeat.m2504i(93619);
        boolean cvY = C22172n.cvY();
        AppMethodBeat.m2505o(93619);
        return cvY;
    }

    /* renamed from: d */
    public final void mo63056d(final Activity activity, final String str) {
        AppMethodBeat.m2504i(93621);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(93615);
                C22172n.m33798d(activity, str);
                AppMethodBeat.m2505o(93615);
            }
        });
        AppMethodBeat.m2505o(93621);
    }

    public final void cwa() {
        AppMethodBeat.m2504i(93622);
        C22172n.cwG();
        AppMethodBeat.m2505o(93622);
    }

    /* renamed from: V */
    public final List<C29259e> mo63047V(long j, long j2) {
        AppMethodBeat.m2504i(93623);
        C43624l sportStepManager = ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepManager();
        C4990ab.m7417i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", sportStepManager.rPL.format(new Date(j)), sportStepManager.rPL.format(new Date(j2)));
        ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepStorage();
        List W = C46268m.m86665W(j, j2);
        AppMethodBeat.m2505o(93623);
        return W;
    }

    public final C29259e cwb() {
        AppMethodBeat.m2504i(93624);
        ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepManager();
        ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepStorage();
        C29259e cwb = C46268m.cwb();
        AppMethodBeat.m2505o(93624);
        return cwb;
    }

    /* renamed from: a */
    public final void mo63048a(long j, long j2, C46265c c46265c) {
        AppMethodBeat.m2504i(93625);
        C4990ab.m7417i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", r0.rPL.format(new Date(j)), ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepManager().rPL.format(new Date(j2)));
        C1207m c43621d = new C43621d(j, j2, c46265c);
        C1720g.m3540Rg().mo14539a(1734, r0.fur);
        C1720g.m3540Rg().mo14541a(c43621d, 0);
        AppMethodBeat.m2505o(93625);
    }

    public final void cwc() {
        AppMethodBeat.m2504i(93626);
        ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepManager();
        C4990ab.m7416i("MicroMsg.Sport.SportStepManager", "clearAllSportStep");
        ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepStorage();
        C46268m.cwc();
        AppMethodBeat.m2505o(93626);
    }

    public final void cvZ() {
        AppMethodBeat.m2504i(93620);
        if (C4996ah.bqo()) {
            ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().reset();
            C7305d.xDG.mo10151b(new C292623(), "Sport.clearConfigToPush");
        }
        AppMethodBeat.m2505o(93620);
    }
}
