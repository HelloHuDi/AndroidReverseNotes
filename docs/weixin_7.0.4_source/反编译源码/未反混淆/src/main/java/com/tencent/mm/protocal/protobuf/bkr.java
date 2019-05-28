package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bkr extends a {
    public String guP;
    public String guW;
    public float vRp;
    public float vRq;
    public String wNK;
    public String wNL;
    public long wNM;
    public String wxQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124333);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wNK != null) {
                aVar.e(1, this.wNK);
            }
            if (this.guW != null) {
                aVar.e(2, this.guW);
            }
            if (this.guP != null) {
                aVar.e(3, this.guP);
            }
            if (this.wxQ != null) {
                aVar.e(4, this.wxQ);
            }
            aVar.r(5, this.vRq);
            aVar.r(6, this.vRp);
            if (this.wNL != null) {
                aVar.e(7, this.wNL);
            }
            aVar.ai(8, this.wNM);
            AppMethodBeat.o(124333);
            return 0;
        } else if (i == 1) {
            if (this.wNK != null) {
                f = e.a.a.b.b.a.f(1, this.wNK) + 0;
            } else {
                f = 0;
            }
            if (this.guW != null) {
                f += e.a.a.b.b.a.f(2, this.guW);
            }
            if (this.guP != null) {
                f += e.a.a.b.b.a.f(3, this.guP);
            }
            if (this.wxQ != null) {
                f += e.a.a.b.b.a.f(4, this.wxQ);
            }
            f = (f + (e.a.a.b.b.a.fv(5) + 4)) + (e.a.a.b.b.a.fv(6) + 4);
            if (this.wNL != null) {
                f += e.a.a.b.b.a.f(7, this.wNL);
            }
            int o = f + e.a.a.b.b.a.o(8, this.wNM);
            AppMethodBeat.o(124333);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124333);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkr bkr = (bkr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkr.wNK = aVar3.BTU.readString();
                    AppMethodBeat.o(124333);
                    return 0;
                case 2:
                    bkr.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(124333);
                    return 0;
                case 3:
                    bkr.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(124333);
                    return 0;
                case 4:
                    bkr.wxQ = aVar3.BTU.readString();
                    AppMethodBeat.o(124333);
                    return 0;
                case 5:
                    bkr.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(124333);
                    return 0;
                case 6:
                    bkr.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(124333);
                    return 0;
                case 7:
                    bkr.wNL = aVar3.BTU.readString();
                    AppMethodBeat.o(124333);
                    return 0;
                case 8:
                    bkr.wNM = aVar3.BTU.ve();
                    AppMethodBeat.o(124333);
                    return 0;
                default:
                    AppMethodBeat.o(124333);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124333);
            return -1;
        }
    }
}
