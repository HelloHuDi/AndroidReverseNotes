package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ze extends a {
    public String Name;
    public String PriceType;
    public int ndE;
    public int vQt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56778);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            aVar.iz(2, this.vQt);
            if (this.PriceType != null) {
                aVar.e(3, this.PriceType);
            }
            aVar.iz(4, this.ndE);
            AppMethodBeat.o(56778);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vQt);
            if (this.PriceType != null) {
                f += e.a.a.b.b.a.f(3, this.PriceType);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.ndE);
            AppMethodBeat.o(56778);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56778);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ze zeVar = (ze) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zeVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(56778);
                    return 0;
                case 2:
                    zeVar.vQt = aVar3.BTU.vd();
                    AppMethodBeat.o(56778);
                    return 0;
                case 3:
                    zeVar.PriceType = aVar3.BTU.readString();
                    AppMethodBeat.o(56778);
                    return 0;
                case 4:
                    zeVar.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(56778);
                    return 0;
                default:
                    AppMethodBeat.o(56778);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56778);
            return -1;
        }
    }
}
