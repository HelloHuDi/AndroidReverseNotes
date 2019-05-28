package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ha extends a {
    public String nuL;
    public String pbn;
    public String pck;
    public String vJF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56709);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJF != null) {
                aVar.e(1, this.vJF);
            }
            if (this.pbn != null) {
                aVar.e(2, this.pbn);
            }
            if (this.nuL != null) {
                aVar.e(3, this.nuL);
            }
            if (this.pck != null) {
                aVar.e(4, this.pck);
            }
            AppMethodBeat.o(56709);
            return 0;
        } else if (i == 1) {
            if (this.vJF != null) {
                f = e.a.a.b.b.a.f(1, this.vJF) + 0;
            } else {
                f = 0;
            }
            if (this.pbn != null) {
                f += e.a.a.b.b.a.f(2, this.pbn);
            }
            if (this.nuL != null) {
                f += e.a.a.b.b.a.f(3, this.nuL);
            }
            if (this.pck != null) {
                f += e.a.a.b.b.a.f(4, this.pck);
            }
            AppMethodBeat.o(56709);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56709);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ha haVar = (ha) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    haVar.vJF = aVar3.BTU.readString();
                    AppMethodBeat.o(56709);
                    return 0;
                case 2:
                    haVar.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(56709);
                    return 0;
                case 3:
                    haVar.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(56709);
                    return 0;
                case 4:
                    haVar.pck = aVar3.BTU.readString();
                    AppMethodBeat.o(56709);
                    return 0;
                default:
                    AppMethodBeat.o(56709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56709);
            return -1;
        }
    }
}
