package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    Map<Integer, Object<?>> fMp = new ConcurrentHashMap();
    public c fMq = new c<tu>() {
        {
            AppMethodBeat.i(78475);
            this.xxI = tu.class.getName().hashCode();
            AppMethodBeat.o(78475);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(78476);
            l.this.fMp.get(Integer.valueOf(((tu) bVar).cPV.cvz));
            AppMethodBeat.o(78476);
            return false;
        }
    };
    public c fMr = new c<ci>() {
        {
            AppMethodBeat.i(78477);
            this.xxI = ci.class.getName().hashCode();
            AppMethodBeat.o(78477);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(78478);
            l.this.fMp.get(Integer.valueOf(((ci) bVar).cvy.cvz));
            AppMethodBeat.o(78478);
            return false;
        }
    };

    public l() {
        AppMethodBeat.i(78479);
        AppMethodBeat.o(78479);
    }
}
