package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abz extends a {
    public String cEh;
    public String id = "101";
    public boolean wjP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55700);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            aVar.aO(3, this.wjP);
            AppMethodBeat.o(55700);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                f = e.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += e.a.a.b.b.a.f(2, this.cEh);
            }
            int fv = f + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(55700);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55700);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abz abz = (abz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abz.id = aVar3.BTU.readString();
                    AppMethodBeat.o(55700);
                    return 0;
                case 2:
                    abz.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(55700);
                    return 0;
                case 3:
                    abz.wjP = aVar3.BTU.ehX();
                    AppMethodBeat.o(55700);
                    return 0;
                default:
                    AppMethodBeat.o(55700);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55700);
            return -1;
        }
    }
}
