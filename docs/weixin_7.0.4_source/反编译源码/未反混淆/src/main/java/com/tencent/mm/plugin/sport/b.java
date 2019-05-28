package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.plugin.sport.model.d;
import com.tencent.mm.plugin.sport.model.f;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.model.m;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Date;
import java.util.List;

public final class b implements com.tencent.mm.plugin.sport.a.b {
    public final void cvX() {
        AppMethodBeat.i(93616);
        if (((PluginSport) g.M(PluginSport.class)).getDeviceStepManager() != null) {
            ((PluginSport) g.M(PluginSport.class)).getDeviceStepManager().cwd();
        }
        AppMethodBeat.o(93616);
    }

    public final void b(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.i(93617);
        if (g.RK()) {
            g.Rg().a(new f(str, str2, i, i2, i3, str3, 1), 0);
        }
        AppMethodBeat.o(93617);
    }

    public final boolean eU(Context context) {
        AppMethodBeat.i(93618);
        boolean eU = n.eU(context);
        AppMethodBeat.o(93618);
        return eU;
    }

    public final boolean cvY() {
        AppMethodBeat.i(93619);
        boolean cvY = n.cvY();
        AppMethodBeat.o(93619);
        return cvY;
    }

    public final void d(final Activity activity, final String str) {
        AppMethodBeat.i(93621);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(93615);
                n.d(activity, str);
                AppMethodBeat.o(93615);
            }
        });
        AppMethodBeat.o(93621);
    }

    public final void cwa() {
        AppMethodBeat.i(93622);
        n.cwG();
        AppMethodBeat.o(93622);
    }

    public final List<e> V(long j, long j2) {
        AppMethodBeat.i(93623);
        l sportStepManager = ((PluginSport) g.M(PluginSport.class)).getSportStepManager();
        ab.i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", sportStepManager.rPL.format(new Date(j)), sportStepManager.rPL.format(new Date(j2)));
        ((PluginSport) g.M(PluginSport.class)).getSportStepStorage();
        List W = m.W(j, j2);
        AppMethodBeat.o(93623);
        return W;
    }

    public final e cwb() {
        AppMethodBeat.i(93624);
        ((PluginSport) g.M(PluginSport.class)).getSportStepManager();
        ((PluginSport) g.M(PluginSport.class)).getSportStepStorage();
        e cwb = m.cwb();
        AppMethodBeat.o(93624);
        return cwb;
    }

    public final void a(long j, long j2, c cVar) {
        AppMethodBeat.i(93625);
        ab.i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", r0.rPL.format(new Date(j)), ((PluginSport) g.M(PluginSport.class)).getSportStepManager().rPL.format(new Date(j2)));
        com.tencent.mm.ai.m dVar = new d(j, j2, cVar);
        g.Rg().a(1734, r0.fur);
        g.Rg().a(dVar, 0);
        AppMethodBeat.o(93625);
    }

    public final void cwc() {
        AppMethodBeat.i(93626);
        ((PluginSport) g.M(PluginSport.class)).getSportStepManager();
        ab.i("MicroMsg.Sport.SportStepManager", "clearAllSportStep");
        ((PluginSport) g.M(PluginSport.class)).getSportStepStorage();
        m.cwc();
        AppMethodBeat.o(93626);
    }

    public final void cvZ() {
        AppMethodBeat.i(93620);
        if (ah.bqo()) {
            ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().reset();
            com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93630);
                    try {
                        ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "clearConfig", null, null);
                        AppMethodBeat.o(93630);
                    } catch (Exception e) {
                        AppMethodBeat.o(93630);
                    }
                }
            }, "Sport.clearConfigToPush");
        }
        AppMethodBeat.o(93620);
    }
}
