package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.model.at;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class e implements at {
    private m osT = new m();
    private c osU = new c<ri>() {
        {
            AppMethodBeat.i(76427);
            this.xxI = ri.class.getName().hashCode();
            AppMethodBeat.o(76427);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(76428);
            ri riVar = (ri) bVar;
            riVar.cNo.result = d.tv(riVar.cNn.cNp);
            AppMethodBeat.o(76428);
            return true;
        }
    };
    private c osV = new c<rs>() {
        {
            AppMethodBeat.i(76429);
            this.xxI = rs.class.getName().hashCode();
            AppMethodBeat.o(76429);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(76430);
            rs rsVar = (rs) bVar;
            if (l.a(rsVar.cNH.cNp, d.afF().afH(), rsVar.cNH.cNJ, rsVar.cNH.cNL)) {
                rsVar.cNH.cNK.run();
                rsVar.cNI.result = l.b(rsVar.cNH.cNp, d.afF().afH(), rsVar.cNH.cNJ, rsVar.cNH.cNL);
            } else {
                rsVar.cNI.result = 1;
            }
            AppMethodBeat.o(76430);
            return false;
        }
    };

    public e() {
        AppMethodBeat.i(76431);
        AppMethodBeat.o(76431);
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(76432);
        o.alq().a(this.osT);
        a.xxA.b(this.osV);
        a.xxA.c(this.osU);
        AppMethodBeat.o(76432);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(76433);
        o.alq().b(this.osT);
        a.xxA.d(this.osV);
        j.owk.WY();
        a.xxA.d(this.osU);
        AppMethodBeat.o(76433);
    }
}
