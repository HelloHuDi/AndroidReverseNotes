package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.c.a.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a gmC;
    public final a gmD;

    public class a implements e<d<List, String, Boolean>, c<Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            com.tencent.mm.plugin.aa.a.a.c cVar;
            int i2 = 20;
            AppMethodBeat.i(40678);
            c cVar2 = (c) obj;
            a aVar = b.this.gmC;
            boolean booleanValue = ((Boolean) cVar2.get(0)).booleanValue();
            int intValue = ((Integer) cVar2.get(1)).intValue();
            if (!booleanValue || aVar.gmt <= 0) {
                i = 20;
            } else {
                i = aVar.gmt;
                aVar.gmt = 0;
                aVar.gmy = false;
            }
            if (aVar.gmz == intValue) {
                i2 = i;
            }
            aVar.gmz = intValue;
            ab.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", Integer.valueOf(aVar.gmt), Boolean.valueOf(booleanValue));
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            if (aVar.gmy) {
                cVar = new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.gmt, intValue, aVar.gmu, aVar.gmv, aVar.gmw, aVar.gmx);
            } else {
                cVar = new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.gmt, intValue);
            }
            cVar.acy().h(new AnonymousClass1(dMj));
            AppMethodBeat.o(40678);
            return null;
        }

        public final String HZ() {
            return "Vending.ANY";
        }

        public final com.tencent.mm.vending.g.c<d<List, String, Boolean>> g(boolean z, int i) {
            AppMethodBeat.i(40677);
            com.tencent.mm.vending.g.c c = f.D(Boolean.valueOf(z), Integer.valueOf(i)).c(this);
            AppMethodBeat.o(40677);
            return c;
        }
    }

    public b() {
        this(new a());
        AppMethodBeat.i(40679);
        AppMethodBeat.o(40679);
    }

    private b(a aVar) {
        AppMethodBeat.i(40680);
        this.gmD = new a();
        this.gmC = aVar;
        AppMethodBeat.o(40680);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gmC;
    }
}
