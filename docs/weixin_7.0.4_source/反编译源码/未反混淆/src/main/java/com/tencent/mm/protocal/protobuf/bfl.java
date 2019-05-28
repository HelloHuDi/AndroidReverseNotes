package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bfl extends a {
    public int FileSize;
    public String fMd;
    public int vPb;
    public int vZF;
    public int wJn;
    public int wJo;
    public String wJp;
    public int wJq;
    public String wJr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28563);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fMd != null) {
                aVar.e(1, this.fMd);
            }
            aVar.iz(2, this.wJn);
            aVar.iz(3, this.wJo);
            aVar.iz(4, this.vPb);
            if (this.wJp != null) {
                aVar.e(5, this.wJp);
            }
            aVar.iz(6, this.FileSize);
            aVar.iz(7, this.wJq);
            aVar.iz(8, this.vZF);
            if (this.wJr != null) {
                aVar.e(9, this.wJr);
            }
            AppMethodBeat.o(28563);
            return 0;
        } else if (i == 1) {
            if (this.fMd != null) {
                f = e.a.a.b.b.a.f(1, this.fMd) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.b.b.a.bs(2, this.wJn)) + e.a.a.b.b.a.bs(3, this.wJo)) + e.a.a.b.b.a.bs(4, this.vPb);
            if (this.wJp != null) {
                f += e.a.a.b.b.a.f(5, this.wJp);
            }
            f = ((f + e.a.a.b.b.a.bs(6, this.FileSize)) + e.a.a.b.b.a.bs(7, this.wJq)) + e.a.a.b.b.a.bs(8, this.vZF);
            if (this.wJr != null) {
                f += e.a.a.b.b.a.f(9, this.wJr);
            }
            AppMethodBeat.o(28563);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28563);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfl bfl = (bfl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfl.fMd = aVar3.BTU.readString();
                    AppMethodBeat.o(28563);
                    return 0;
                case 2:
                    bfl.wJn = aVar3.BTU.vd();
                    AppMethodBeat.o(28563);
                    return 0;
                case 3:
                    bfl.wJo = aVar3.BTU.vd();
                    AppMethodBeat.o(28563);
                    return 0;
                case 4:
                    bfl.vPb = aVar3.BTU.vd();
                    AppMethodBeat.o(28563);
                    return 0;
                case 5:
                    bfl.wJp = aVar3.BTU.readString();
                    AppMethodBeat.o(28563);
                    return 0;
                case 6:
                    bfl.FileSize = aVar3.BTU.vd();
                    AppMethodBeat.o(28563);
                    return 0;
                case 7:
                    bfl.wJq = aVar3.BTU.vd();
                    AppMethodBeat.o(28563);
                    return 0;
                case 8:
                    bfl.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(28563);
                    return 0;
                case 9:
                    bfl.wJr = aVar3.BTU.readString();
                    AppMethodBeat.o(28563);
                    return 0;
                default:
                    AppMethodBeat.o(28563);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28563);
            return -1;
        }
    }
}
