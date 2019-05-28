package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class do extends a {
    public String fKh;
    public int jCt;
    public int vFs;
    public String vFt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96190);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh != null) {
                aVar.e(1, this.fKh);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.vFs);
            if (this.vFt != null) {
                aVar.e(4, this.vFt);
            }
            AppMethodBeat.o(96190);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.vFs);
            if (this.vFt != null) {
                f += e.a.a.b.b.a.f(4, this.vFt);
            }
            AppMethodBeat.o(96190);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96190);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            do doVar = (do) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(96190);
                    return 0;
                case 2:
                    doVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(96190);
                    return 0;
                case 3:
                    doVar.vFs = aVar3.BTU.vd();
                    AppMethodBeat.o(96190);
                    return 0;
                case 4:
                    doVar.vFt = aVar3.BTU.readString();
                    AppMethodBeat.o(96190);
                    return 0;
                default:
                    AppMethodBeat.o(96190);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96190);
            return -1;
        }
    }
}
