package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class g implements at {
    private static HashMap<Integer, d> gzk;
    private e gzj;
    private c gzl = new c<tt>() {
        {
            AppMethodBeat.i(69845);
            this.xxI = tt.class.getName().hashCode();
            AppMethodBeat.o(69845);
        }

        private static boolean a(tt ttVar) {
            AppMethodBeat.i(69846);
            f.n(ttVar.cPS.cPT, ttVar.cPS.cPU);
            AppMethodBeat.o(69846);
            return false;
        }
    };
    private c gzm = new c<hy>() {
        {
            AppMethodBeat.i(69848);
            this.xxI = hy.class.getName().hashCode();
            AppMethodBeat.o(69848);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(69849);
            hy hyVar = (hy) bVar;
            hyVar.cCT.cCU = f.cz(hyVar.cCS.context);
            AppMethodBeat.o(69849);
            return false;
        }
    };
    private c gzn = new c<hz>() {
        {
            AppMethodBeat.i(69850);
            this.xxI = hz.class.getName().hashCode();
            AppMethodBeat.o(69850);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(69851);
            ((hz) bVar).cCV.cCW = f.aqE();
            AppMethodBeat.o(69851);
            return false;
        }
    };

    public g() {
        AppMethodBeat.i(69852);
        AppMethodBeat.o(69852);
    }

    private static synchronized g aqF() {
        g gVar;
        synchronized (g.class) {
            AppMethodBeat.i(69853);
            gVar = (g) q.Y(g.class);
            AppMethodBeat.o(69853);
        }
        return gVar;
    }

    public static e aqG() {
        AppMethodBeat.i(69854);
        com.tencent.mm.kernel.g.RN().QU();
        if (aqF().gzj == null) {
            aqF().gzj = new e(com.tencent.mm.kernel.g.RP().eJN);
        }
        e eVar = aqF().gzj;
        AppMethodBeat.o(69854);
        return eVar;
    }

    static {
        AppMethodBeat.i(69857);
        HashMap hashMap = new HashMap();
        gzk = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        AppMethodBeat.o(69857);
    }

    public final HashMap<Integer, d> Jx() {
        return gzk;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(69855);
        a.xxA.c(this.gzl);
        a.xxA.c(this.gzm);
        a.xxA.c(this.gzn);
        AppMethodBeat.o(69855);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(69856);
        a.xxA.d(this.gzl);
        a.xxA.d(this.gzm);
        a.xxA.d(this.gzn);
        AppMethodBeat.o(69856);
    }
}
