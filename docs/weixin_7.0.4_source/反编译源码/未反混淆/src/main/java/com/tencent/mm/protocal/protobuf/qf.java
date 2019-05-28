package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class qf extends a {
    public String jBB;
    public String jCH;
    public String vXl;
    public String vXm;
    public String vXn;
    public int vXo;
    public String vXp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60027);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.vXl != null) {
                aVar.e(3, this.vXl);
            }
            if (this.vXm != null) {
                aVar.e(4, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(5, this.vXn);
            }
            aVar.iz(6, this.vXo);
            if (this.vXp != null) {
                aVar.e(7, this.vXp);
            }
            AppMethodBeat.o(60027);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.vXl != null) {
                f += e.a.a.b.b.a.f(3, this.vXl);
            }
            if (this.vXm != null) {
                f += e.a.a.b.b.a.f(4, this.vXm);
            }
            if (this.vXn != null) {
                f += e.a.a.b.b.a.f(5, this.vXn);
            }
            f += e.a.a.b.b.a.bs(6, this.vXo);
            if (this.vXp != null) {
                f += e.a.a.b.b.a.f(7, this.vXp);
            }
            AppMethodBeat.o(60027);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60027);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qf qfVar = (qf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qfVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(60027);
                    return 0;
                case 2:
                    qfVar.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(60027);
                    return 0;
                case 3:
                    qfVar.vXl = aVar3.BTU.readString();
                    AppMethodBeat.o(60027);
                    return 0;
                case 4:
                    qfVar.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(60027);
                    return 0;
                case 5:
                    qfVar.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(60027);
                    return 0;
                case 6:
                    qfVar.vXo = aVar3.BTU.vd();
                    AppMethodBeat.o(60027);
                    return 0;
                case 7:
                    qfVar.vXp = aVar3.BTU.readString();
                    AppMethodBeat.o(60027);
                    return 0;
                default:
                    AppMethodBeat.o(60027);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60027);
            return -1;
        }
    }
}
