package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bbn extends a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public String guW;
    public String jBB;
    public int jCt;
    public String vXm;
    public String vXn;
    public int wGb;
    public int wGc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28551);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.guN);
            if (this.guP != null) {
                aVar.e(4, this.guP);
            }
            if (this.guO != null) {
                aVar.e(5, this.guO);
            }
            if (this.guQ != null) {
                aVar.e(6, this.guQ);
            }
            aVar.iz(7, this.wGb);
            aVar.iz(8, this.wGc);
            if (this.guW != null) {
                aVar.e(9, this.guW);
            }
            if (this.vXm != null) {
                aVar.e(10, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(11, this.vXn);
            }
            AppMethodBeat.o(28551);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.guN);
            if (this.guP != null) {
                f += e.a.a.b.b.a.f(4, this.guP);
            }
            if (this.guO != null) {
                f += e.a.a.b.b.a.f(5, this.guO);
            }
            if (this.guQ != null) {
                f += e.a.a.b.b.a.f(6, this.guQ);
            }
            f = (f + e.a.a.b.b.a.bs(7, this.wGb)) + e.a.a.b.b.a.bs(8, this.wGc);
            if (this.guW != null) {
                f += e.a.a.b.b.a.f(9, this.guW);
            }
            if (this.vXm != null) {
                f += e.a.a.b.b.a.f(10, this.vXm);
            }
            if (this.vXn != null) {
                f += e.a.a.b.b.a.f(11, this.vXn);
            }
            AppMethodBeat.o(28551);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28551);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbn bbn = (bbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbn.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                case 2:
                    bbn.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28551);
                    return 0;
                case 3:
                    bbn.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(28551);
                    return 0;
                case 4:
                    bbn.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                case 5:
                    bbn.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                case 6:
                    bbn.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                case 7:
                    bbn.wGb = aVar3.BTU.vd();
                    AppMethodBeat.o(28551);
                    return 0;
                case 8:
                    bbn.wGc = aVar3.BTU.vd();
                    AppMethodBeat.o(28551);
                    return 0;
                case 9:
                    bbn.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                case 10:
                    bbn.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                case 11:
                    bbn.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(28551);
                    return 0;
                default:
                    AppMethodBeat.o(28551);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28551);
            return -1;
        }
    }
}
