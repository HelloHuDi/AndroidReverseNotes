package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class rj extends a {
    public int Scene;
    public int jCt;
    public String nqc;
    public String vYA;
    public String vYB;
    public String vYC;
    public String vYD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(50527);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Scene);
            aVar.iz(2, this.jCt);
            if (this.vYA != null) {
                aVar.e(3, this.vYA);
            }
            if (this.vYB != null) {
                aVar.e(4, this.vYB);
            }
            if (this.nqc != null) {
                aVar.e(5, this.nqc);
            }
            if (this.vYC != null) {
                aVar.e(6, this.vYC);
            }
            if (this.vYD != null) {
                aVar.e(7, this.vYD);
            }
            AppMethodBeat.o(50527);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.Scene) + 0) + e.a.a.b.b.a.bs(2, this.jCt);
            if (this.vYA != null) {
                bs += e.a.a.b.b.a.f(3, this.vYA);
            }
            if (this.vYB != null) {
                bs += e.a.a.b.b.a.f(4, this.vYB);
            }
            if (this.nqc != null) {
                bs += e.a.a.b.b.a.f(5, this.nqc);
            }
            if (this.vYC != null) {
                bs += e.a.a.b.b.a.f(6, this.vYC);
            }
            if (this.vYD != null) {
                bs += e.a.a.b.b.a.f(7, this.vYD);
            }
            AppMethodBeat.o(50527);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(50527);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rj rjVar = (rj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rjVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(50527);
                    return 0;
                case 2:
                    rjVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(50527);
                    return 0;
                case 3:
                    rjVar.vYA = aVar3.BTU.readString();
                    AppMethodBeat.o(50527);
                    return 0;
                case 4:
                    rjVar.vYB = aVar3.BTU.readString();
                    AppMethodBeat.o(50527);
                    return 0;
                case 5:
                    rjVar.nqc = aVar3.BTU.readString();
                    AppMethodBeat.o(50527);
                    return 0;
                case 6:
                    rjVar.vYC = aVar3.BTU.readString();
                    AppMethodBeat.o(50527);
                    return 0;
                case 7:
                    rjVar.vYD = aVar3.BTU.readString();
                    AppMethodBeat.o(50527);
                    return 0;
                default:
                    AppMethodBeat.o(50527);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50527);
            return -1;
        }
    }
}
