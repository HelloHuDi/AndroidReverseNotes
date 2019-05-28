package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.e;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a rNo;
    public final a rNp;
    public final b rNq;

    public class a implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40539);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            a aVar = b.this.rNo;
            String str = (String) eVar.get(0);
            ((Boolean) eVar.get(1)).booleanValue();
            aVar.f(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            Void voidR = zXH;
            AppMethodBeat.o(40539);
            return voidR;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40540);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            a aVar = b.this.rNo;
            String str = (String) eVar.get(0);
            ((Boolean) eVar.get(1)).booleanValue();
            aVar.g(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            Void voidR = zXH;
            AppMethodBeat.o(40540);
            return voidR;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public b() {
        this(new a());
        AppMethodBeat.i(40541);
        AppMethodBeat.o(40541);
    }

    private b(a aVar) {
        AppMethodBeat.i(40542);
        this.rNp = new a();
        this.rNq = new b();
        this.rNo = aVar;
        AppMethodBeat.o(40542);
    }

    public final a cvE() {
        return this.rNo;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.rNo;
    }
}
