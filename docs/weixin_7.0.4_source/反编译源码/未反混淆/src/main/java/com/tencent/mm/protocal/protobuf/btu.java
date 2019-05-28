package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class btu extends a {
    public String Name;
    public int pcX;
    public String vIk;
    public String wcI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123516);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.wcI != null) {
                aVar.e(2, this.wcI);
            }
            if (this.vIk != null) {
                aVar.e(3, this.vIk);
            }
            aVar.iz(4, this.pcX);
            AppMethodBeat.o(123516);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.wcI != null) {
                f += e.a.a.b.b.a.f(2, this.wcI);
            }
            if (this.vIk != null) {
                f += e.a.a.b.b.a.f(3, this.vIk);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.pcX);
            AppMethodBeat.o(123516);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(123516);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btu btu = (btu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btu.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(123516);
                    return 0;
                case 2:
                    btu.wcI = aVar3.BTU.readString();
                    AppMethodBeat.o(123516);
                    return 0;
                case 3:
                    btu.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(123516);
                    return 0;
                case 4:
                    btu.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(123516);
                    return 0;
                default:
                    AppMethodBeat.o(123516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123516);
            return -1;
        }
    }
}
