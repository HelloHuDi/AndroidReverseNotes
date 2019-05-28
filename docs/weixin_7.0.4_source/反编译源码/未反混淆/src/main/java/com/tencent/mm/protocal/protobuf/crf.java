package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crf extends a {
    public boolean xoO;
    public String xoP;
    public String xoQ;
    public int xoR;
    public int xoS;
    public int xoT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102416);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.xoO);
            if (this.xoP != null) {
                aVar.e(2, this.xoP);
            }
            if (this.xoQ != null) {
                aVar.e(3, this.xoQ);
            }
            aVar.iz(4, this.xoR);
            aVar.iz(5, this.xoS);
            aVar.iz(6, this.xoT);
            AppMethodBeat.o(102416);
            return 0;
        } else if (i == 1) {
            fv = (e.a.a.b.b.a.fv(1) + 1) + 0;
            if (this.xoP != null) {
                fv += e.a.a.b.b.a.f(2, this.xoP);
            }
            if (this.xoQ != null) {
                fv += e.a.a.b.b.a.f(3, this.xoQ);
            }
            fv = ((fv + e.a.a.b.b.a.bs(4, this.xoR)) + e.a.a.b.b.a.bs(5, this.xoS)) + e.a.a.b.b.a.bs(6, this.xoT);
            AppMethodBeat.o(102416);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102416);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crf crf = (crf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crf.xoO = aVar3.BTU.ehX();
                    AppMethodBeat.o(102416);
                    return 0;
                case 2:
                    crf.xoP = aVar3.BTU.readString();
                    AppMethodBeat.o(102416);
                    return 0;
                case 3:
                    crf.xoQ = aVar3.BTU.readString();
                    AppMethodBeat.o(102416);
                    return 0;
                case 4:
                    crf.xoR = aVar3.BTU.vd();
                    AppMethodBeat.o(102416);
                    return 0;
                case 5:
                    crf.xoS = aVar3.BTU.vd();
                    AppMethodBeat.o(102416);
                    return 0;
                case 6:
                    crf.xoT = aVar3.BTU.vd();
                    AppMethodBeat.o(102416);
                    return 0;
                default:
                    AppMethodBeat.o(102416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102416);
            return -1;
        }
    }
}
