package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class buj extends a {
    public String Desc;
    public String iyZ;
    public String vOF;
    public int wWa;
    public String wze;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96284);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOF != null) {
                aVar.e(1, this.vOF);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            aVar.iz(3, this.wWa);
            if (this.iyZ != null) {
                aVar.e(4, this.iyZ);
            }
            if (this.wze != null) {
                aVar.e(5, this.wze);
            }
            AppMethodBeat.o(96284);
            return 0;
        } else if (i == 1) {
            if (this.vOF != null) {
                f = e.a.a.b.b.a.f(1, this.vOF) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(2, this.Desc);
            }
            f += e.a.a.b.b.a.bs(3, this.wWa);
            if (this.iyZ != null) {
                f += e.a.a.b.b.a.f(4, this.iyZ);
            }
            if (this.wze != null) {
                f += e.a.a.b.b.a.f(5, this.wze);
            }
            AppMethodBeat.o(96284);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96284);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buj buj = (buj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    buj.vOF = aVar3.BTU.readString();
                    AppMethodBeat.o(96284);
                    return 0;
                case 2:
                    buj.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(96284);
                    return 0;
                case 3:
                    buj.wWa = aVar3.BTU.vd();
                    AppMethodBeat.o(96284);
                    return 0;
                case 4:
                    buj.iyZ = aVar3.BTU.readString();
                    AppMethodBeat.o(96284);
                    return 0;
                case 5:
                    buj.wze = aVar3.BTU.readString();
                    AppMethodBeat.o(96284);
                    return 0;
                default:
                    AppMethodBeat.o(96284);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96284);
            return -1;
        }
    }
}
