package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cl extends a {
    public int nda;
    public String ndb;
    public String ndc;
    public boolean ndd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111649);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndc == null) {
                bVar = new b("Not all required fields were included: MediaURL");
                AppMethodBeat.o(111649);
                throw bVar;
            }
            aVar.iz(1, this.nda);
            if (this.ndb != null) {
                aVar.e(2, this.ndb);
            }
            if (this.ndc != null) {
                aVar.e(3, this.ndc);
            }
            aVar.aO(4, this.ndd);
            AppMethodBeat.o(111649);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.nda) + 0;
            if (this.ndb != null) {
                bs += e.a.a.b.b.a.f(2, this.ndb);
            }
            if (this.ndc != null) {
                bs += e.a.a.b.b.a.f(3, this.ndc);
            }
            bs += e.a.a.b.b.a.fv(4) + 1;
            AppMethodBeat.o(111649);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.ndc == null) {
                bVar = new b("Not all required fields were included: MediaURL");
                AppMethodBeat.o(111649);
                throw bVar;
            }
            AppMethodBeat.o(111649);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cl clVar = (cl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clVar.nda = aVar3.BTU.vd();
                    AppMethodBeat.o(111649);
                    return 0;
                case 2:
                    clVar.ndb = aVar3.BTU.readString();
                    AppMethodBeat.o(111649);
                    return 0;
                case 3:
                    clVar.ndc = aVar3.BTU.readString();
                    AppMethodBeat.o(111649);
                    return 0;
                case 4:
                    clVar.ndd = aVar3.BTU.ehX();
                    AppMethodBeat.o(111649);
                    return 0;
                default:
                    AppMethodBeat.o(111649);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111649);
            return -1;
        }
    }
}
