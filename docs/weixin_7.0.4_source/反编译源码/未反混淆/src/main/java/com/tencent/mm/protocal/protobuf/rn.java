package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class rn extends a {
    public String cEh;
    public String pRD;
    public String pcw;
    public String title;
    public int vYN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48821);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            if (this.pcw != null) {
                aVar.e(3, this.pcw);
            }
            if (this.pRD != null) {
                aVar.e(4, this.pRD);
            }
            aVar.iz(5, this.vYN);
            AppMethodBeat.o(48821);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.pcw != null) {
                f += e.a.a.b.b.a.f(3, this.pcw);
            }
            if (this.pRD != null) {
                f += e.a.a.b.b.a.f(4, this.pRD);
            }
            int bs = f + e.a.a.b.b.a.bs(5, this.vYN);
            AppMethodBeat.o(48821);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48821);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rn rnVar = (rn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rnVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48821);
                    return 0;
                case 2:
                    rnVar.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(48821);
                    return 0;
                case 3:
                    rnVar.pcw = aVar3.BTU.readString();
                    AppMethodBeat.o(48821);
                    return 0;
                case 4:
                    rnVar.pRD = aVar3.BTU.readString();
                    AppMethodBeat.o(48821);
                    return 0;
                case 5:
                    rnVar.vYN = aVar3.BTU.vd();
                    AppMethodBeat.o(48821);
                    return 0;
                default:
                    AppMethodBeat.o(48821);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48821);
            return -1;
        }
    }
}
