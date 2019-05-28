package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class l implements com.tencent.mm.vending.c.b<k> {
    protected k gma;
    public final a gmb;
    public final b gmc;

    public class a implements e<Boolean, c<Integer, Map<String, Object>>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40635);
            c cVar = (c) obj;
            l.this.gma.c(((Integer) cVar.get(0)).intValue(), (Map) cVar.get(1));
            AppMethodBeat.o(40635);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<d<Boolean, String, Long>, Map<String, Object>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40636);
            l.this.gma.r((Map) obj);
            AppMethodBeat.o(40636);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public l() {
        this(new k());
        AppMethodBeat.i(40637);
        AppMethodBeat.o(40637);
    }

    private l(k kVar) {
        AppMethodBeat.i(40638);
        this.gmb = new a();
        this.gmc = new b();
        this.gma = kVar;
        AppMethodBeat.o(40638);
    }

    public final k aop() {
        return this.gma;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gma;
    }
}
