package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class c implements b<b> {
    protected b glu;
    public final a glv;

    public class a implements e<v, f<String, Integer, String, String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40595);
            f fVar = (f) obj;
            b bVar = c.this.glu;
            m jVar = new j((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), (String) fVar.get(2), (String) fVar.get(3), ((Integer) fVar.get(4)).intValue());
            g.RQ();
            g.RO().eJo.a(jVar, 0);
            bVar.glt = com.tencent.mm.vending.g.f.dMo();
            AppMethodBeat.o(40595);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public c() {
        this(new b());
        AppMethodBeat.i(40596);
        AppMethodBeat.o(40596);
    }

    private c(b bVar) {
        AppMethodBeat.i(40597);
        this.glv = new a();
        this.glu = bVar;
        AppMethodBeat.o(40597);
    }

    public final b aof() {
        return this.glu;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glu;
    }
}
