package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class avf extends a {
    public int vIc;
    public String wzd;
    public String wze;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10197);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wzd != null) {
                aVar.e(1, this.wzd);
            }
            aVar.iz(2, this.vIc);
            if (this.wze != null) {
                aVar.e(3, this.wze);
            }
            AppMethodBeat.o(10197);
            return 0;
        } else if (i == 1) {
            if (this.wzd != null) {
                f = e.a.a.b.b.a.f(1, this.wzd) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vIc);
            if (this.wze != null) {
                f += e.a.a.b.b.a.f(3, this.wze);
            }
            AppMethodBeat.o(10197);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10197);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avf avf = (avf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avf.wzd = aVar3.BTU.readString();
                    AppMethodBeat.o(10197);
                    return 0;
                case 2:
                    avf.vIc = aVar3.BTU.vd();
                    AppMethodBeat.o(10197);
                    return 0;
                case 3:
                    avf.wze = aVar3.BTU.readString();
                    AppMethodBeat.o(10197);
                    return 0;
                default:
                    AppMethodBeat.o(10197);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10197);
            return -1;
        }
    }
}
