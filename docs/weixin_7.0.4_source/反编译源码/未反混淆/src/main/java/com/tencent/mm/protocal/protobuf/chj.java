package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class chj extends a {
    public String wld;
    public boolean xgg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14758);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wld != null) {
                aVar.e(1, this.wld);
            }
            aVar.aO(2, this.xgg);
            AppMethodBeat.o(14758);
            return 0;
        } else if (i == 1) {
            if (this.wld != null) {
                f = e.a.a.b.b.a.f(1, this.wld) + 0;
            } else {
                f = 0;
            }
            int fv = f + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(14758);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14758);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chj chj = (chj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chj.wld = aVar3.BTU.readString();
                    AppMethodBeat.o(14758);
                    return 0;
                case 2:
                    chj.xgg = aVar3.BTU.ehX();
                    AppMethodBeat.o(14758);
                    return 0;
                default:
                    AppMethodBeat.o(14758);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14758);
            return -1;
        }
    }
}
