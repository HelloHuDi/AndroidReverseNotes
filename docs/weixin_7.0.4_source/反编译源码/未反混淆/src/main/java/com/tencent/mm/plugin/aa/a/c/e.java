package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public class e implements com.tencent.mm.vending.c.b<d> {
    protected d gmI;
    public final b gmJ;
    public final c gmK;
    public final a gmL;

    public class c implements com.tencent.mm.vending.h.e<d<Boolean, String, Long>, Map<String, Object>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40689);
            Map map = (Map) obj;
            d dVar = e.this.gmI;
            map.put(k.glU, Integer.valueOf(dVar.zXe.getIntExtra("enter_scene", 1)));
            f.a(f.cU(map).c(dVar.gmG.gmc));
            AppMethodBeat.o(40689);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class a implements com.tencent.mm.vending.h.e<com.tencent.mm.plugin.aa.a.d, Void> {
        public final String HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40687);
            f.a(f.dMn().c(e.this.gmI.gmH.glF));
            AppMethodBeat.o(40687);
            return null;
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40688);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            d dVar = e.this.gmI;
            int intValue = ((Integer) cVar.get(0)).intValue();
            Map map = (Map) cVar.get(1);
            map.put(k.glU, Integer.valueOf(dVar.zXe.getIntExtra("enter_scene", 1)));
            f.a(f.D(Integer.valueOf(intValue), map).c(dVar.gmG.gmb));
            AppMethodBeat.o(40688);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public e() {
        this(new d());
        AppMethodBeat.i(40690);
        AppMethodBeat.o(40690);
    }

    private e(d dVar) {
        AppMethodBeat.i(40691);
        this.gmJ = new b();
        this.gmK = new c();
        this.gmL = new a();
        this.gmI = dVar;
        AppMethodBeat.o(40691);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gmI;
    }
}
