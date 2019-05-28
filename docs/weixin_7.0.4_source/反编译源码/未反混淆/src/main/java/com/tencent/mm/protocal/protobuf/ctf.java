package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ctf extends a {
    public String jBF;
    public String vIk;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOz;
    public String xqm;
    public String xqn;
    public String xqo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55729);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIk != null) {
                aVar.e(1, this.vIk);
            }
            if (this.vOA != null) {
                aVar.e(2, this.vOA);
            }
            if (this.vOz != null) {
                aVar.e(3, this.vOz);
            }
            if (this.jBF != null) {
                aVar.e(4, this.jBF);
            }
            if (this.xqm != null) {
                aVar.e(5, this.xqm);
            }
            if (this.vOB != null) {
                aVar.e(6, this.vOB);
            }
            if (this.vOC != null) {
                aVar.e(7, this.vOC);
            }
            if (this.xqn != null) {
                aVar.e(8, this.xqn);
            }
            if (this.xqo != null) {
                aVar.e(9, this.xqo);
            }
            AppMethodBeat.o(55729);
            return 0;
        } else if (i == 1) {
            if (this.vIk != null) {
                f = e.a.a.b.b.a.f(1, this.vIk) + 0;
            } else {
                f = 0;
            }
            if (this.vOA != null) {
                f += e.a.a.b.b.a.f(2, this.vOA);
            }
            if (this.vOz != null) {
                f += e.a.a.b.b.a.f(3, this.vOz);
            }
            if (this.jBF != null) {
                f += e.a.a.b.b.a.f(4, this.jBF);
            }
            if (this.xqm != null) {
                f += e.a.a.b.b.a.f(5, this.xqm);
            }
            if (this.vOB != null) {
                f += e.a.a.b.b.a.f(6, this.vOB);
            }
            if (this.vOC != null) {
                f += e.a.a.b.b.a.f(7, this.vOC);
            }
            if (this.xqn != null) {
                f += e.a.a.b.b.a.f(8, this.xqn);
            }
            if (this.xqo != null) {
                f += e.a.a.b.b.a.f(9, this.xqo);
            }
            AppMethodBeat.o(55729);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55729);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctf ctf = (ctf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctf.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 2:
                    ctf.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 3:
                    ctf.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 4:
                    ctf.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 5:
                    ctf.xqm = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 6:
                    ctf.vOB = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 7:
                    ctf.vOC = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 8:
                    ctf.xqn = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                case 9:
                    ctf.xqo = aVar3.BTU.readString();
                    AppMethodBeat.o(55729);
                    return 0;
                default:
                    AppMethodBeat.o(55729);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55729);
            return -1;
        }
    }
}
