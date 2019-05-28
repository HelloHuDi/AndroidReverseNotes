package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class gj extends a {
    public String guQ;
    public String jBB;
    public String jCH;
    public int mAk;
    public String vEn;
    public int vID;
    public String vIE;
    public String vIF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28323);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEn != null) {
                aVar.e(1, this.vEn);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.jBB != null) {
                aVar.e(3, this.jBB);
            }
            aVar.iz(4, this.vID);
            if (this.vIE != null) {
                aVar.e(5, this.vIE);
            }
            if (this.guQ != null) {
                aVar.e(6, this.guQ);
            }
            if (this.vIF != null) {
                aVar.e(7, this.vIF);
            }
            aVar.iz(8, this.mAk);
            AppMethodBeat.o(28323);
            return 0;
        } else if (i == 1) {
            if (this.vEn != null) {
                f = e.a.a.b.b.a.f(1, this.vEn) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(3, this.jBB);
            }
            f += e.a.a.b.b.a.bs(4, this.vID);
            if (this.vIE != null) {
                f += e.a.a.b.b.a.f(5, this.vIE);
            }
            if (this.guQ != null) {
                f += e.a.a.b.b.a.f(6, this.guQ);
            }
            if (this.vIF != null) {
                f += e.a.a.b.b.a.f(7, this.vIF);
            }
            int bs = f + e.a.a.b.b.a.bs(8, this.mAk);
            AppMethodBeat.o(28323);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28323);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gj gjVar = (gj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gjVar.vEn = aVar3.BTU.readString();
                    AppMethodBeat.o(28323);
                    return 0;
                case 2:
                    gjVar.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28323);
                    return 0;
                case 3:
                    gjVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28323);
                    return 0;
                case 4:
                    gjVar.vID = aVar3.BTU.vd();
                    AppMethodBeat.o(28323);
                    return 0;
                case 5:
                    gjVar.vIE = aVar3.BTU.readString();
                    AppMethodBeat.o(28323);
                    return 0;
                case 6:
                    gjVar.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28323);
                    return 0;
                case 7:
                    gjVar.vIF = aVar3.BTU.readString();
                    AppMethodBeat.o(28323);
                    return 0;
                case 8:
                    gjVar.mAk = aVar3.BTU.vd();
                    AppMethodBeat.o(28323);
                    return 0;
                default:
                    AppMethodBeat.o(28323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28323);
            return -1;
        }
    }
}
