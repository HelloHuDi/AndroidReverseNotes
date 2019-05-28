package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ar extends a {
    public String guS;
    public String jBB;
    public int jBT;
    public String jCH;
    public int vCf;
    public String vCg;
    public String vCh;
    public int vCi;
    public int vCj;
    public String vCk;
    public int vCl;
    public String vCm;
    public String vCn;
    public int vCo;
    public String vCp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58883);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            aVar.iz(3, this.vCf);
            if (this.vCg != null) {
                aVar.e(4, this.vCg);
            }
            if (this.vCh != null) {
                aVar.e(5, this.vCh);
            }
            if (this.guS != null) {
                aVar.e(6, this.guS);
            }
            aVar.iz(8, this.jBT);
            aVar.iz(9, this.vCi);
            aVar.iz(10, this.vCj);
            if (this.vCk != null) {
                aVar.e(11, this.vCk);
            }
            aVar.iz(12, this.vCl);
            if (this.vCm != null) {
                aVar.e(13, this.vCm);
            }
            if (this.vCn != null) {
                aVar.e(14, this.vCn);
            }
            aVar.iz(15, this.vCo);
            if (this.vCp != null) {
                aVar.e(16, this.vCp);
            }
            AppMethodBeat.o(58883);
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
            f += e.a.a.b.b.a.bs(3, this.vCf);
            if (this.vCg != null) {
                f += e.a.a.b.b.a.f(4, this.vCg);
            }
            if (this.vCh != null) {
                f += e.a.a.b.b.a.f(5, this.vCh);
            }
            if (this.guS != null) {
                f += e.a.a.b.b.a.f(6, this.guS);
            }
            f = ((f + e.a.a.b.b.a.bs(8, this.jBT)) + e.a.a.b.b.a.bs(9, this.vCi)) + e.a.a.b.b.a.bs(10, this.vCj);
            if (this.vCk != null) {
                f += e.a.a.b.b.a.f(11, this.vCk);
            }
            f += e.a.a.b.b.a.bs(12, this.vCl);
            if (this.vCm != null) {
                f += e.a.a.b.b.a.f(13, this.vCm);
            }
            if (this.vCn != null) {
                f += e.a.a.b.b.a.f(14, this.vCn);
            }
            f += e.a.a.b.b.a.bs(15, this.vCo);
            if (this.vCp != null) {
                f += e.a.a.b.b.a.f(16, this.vCp);
            }
            AppMethodBeat.o(58883);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58883);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ar arVar = (ar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 2:
                    arVar.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 3:
                    arVar.vCf = aVar3.BTU.vd();
                    AppMethodBeat.o(58883);
                    return 0;
                case 4:
                    arVar.vCg = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 5:
                    arVar.vCh = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 6:
                    arVar.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 8:
                    arVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(58883);
                    return 0;
                case 9:
                    arVar.vCi = aVar3.BTU.vd();
                    AppMethodBeat.o(58883);
                    return 0;
                case 10:
                    arVar.vCj = aVar3.BTU.vd();
                    AppMethodBeat.o(58883);
                    return 0;
                case 11:
                    arVar.vCk = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 12:
                    arVar.vCl = aVar3.BTU.vd();
                    AppMethodBeat.o(58883);
                    return 0;
                case 13:
                    arVar.vCm = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 14:
                    arVar.vCn = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                case 15:
                    arVar.vCo = aVar3.BTU.vd();
                    AppMethodBeat.o(58883);
                    return 0;
                case 16:
                    arVar.vCp = aVar3.BTU.readString();
                    AppMethodBeat.o(58883);
                    return 0;
                default:
                    AppMethodBeat.o(58883);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58883);
            return -1;
        }
    }
}
