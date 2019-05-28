package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class f implements at {
    private c mqs = new c<gf>() {
        {
            AppMethodBeat.i(20535);
            this.xxI = gf.class.getName().hashCode();
            AppMethodBeat.o(20535);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20536);
            gf gfVar = (gf) bVar;
            if (gfVar.cAC.cAD != null && (gfVar.cAC.cAD instanceof a) && gfVar.cAC.csX != null && (gfVar.cAC.csX instanceof Context)) {
                g gVar;
                g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(gfVar.cAC.cvv);
                if (iE != null || bo.isNullOrNil(gfVar.cAC.cAE)) {
                    gVar = iE;
                } else {
                    gVar = com.tencent.mm.plugin.fav.a.b.LF(gfVar.cAC.cAE);
                }
                a aVar = (a) gfVar.cAC.cAD;
                Context context = (Context) gfVar.cAC.csX;
                d.a(aVar, context, gVar);
                d.b(aVar, context, gVar);
            }
            gfVar.cAC.cvv = 0;
            gfVar.cAC.cAD = null;
            gfVar.cAC.csX = null;
            AppMethodBeat.o(20536);
            return false;
        }
    };

    public f() {
        AppMethodBeat.i(20537);
        AppMethodBeat.o(20537);
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(20538);
        ab.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", Boolean.valueOf(z));
        com.tencent.mm.sdk.b.a.xxA.b(this.mqs);
        com.tencent.mm.kernel.g.a(y.class, new c());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.fav.a.ab.class, new e());
        AppMethodBeat.o(20538);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(20539);
        com.tencent.mm.sdk.b.a.xxA.d(this.mqs);
        ((n) com.tencent.mm.kernel.g.M(n.class)).unregisterFTSUILogic(128);
        ((n) com.tencent.mm.kernel.g.M(n.class)).unregisterFTSUILogic(4192);
        AppMethodBeat.o(20539);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }
}
