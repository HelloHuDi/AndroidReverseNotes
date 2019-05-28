package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cbv extends a {
    public float bEJ;
    public int rkk;
    public float xbk;
    public float xbl;
    public float xbm;
    public float xbn;
    public int xbo;
    public long xbp;
    public long xbq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94602);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.r(1, this.xbk);
            aVar.r(2, this.xbl);
            aVar.r(3, this.xbm);
            aVar.r(4, this.xbn);
            aVar.iz(5, this.xbo);
            aVar.ai(6, this.xbp);
            aVar.ai(7, this.xbq);
            aVar.r(8, this.bEJ);
            aVar.iz(9, this.rkk);
            AppMethodBeat.o(94602);
            return 0;
        } else if (i == 1) {
            fv = (((((((((e.a.a.b.b.a.fv(1) + 4) + 0) + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4)) + e.a.a.b.b.a.bs(5, this.xbo)) + e.a.a.b.b.a.o(6, this.xbp)) + e.a.a.b.b.a.o(7, this.xbq)) + (e.a.a.b.b.a.fv(8) + 4)) + e.a.a.b.b.a.bs(9, this.rkk);
            AppMethodBeat.o(94602);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94602);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbv cbv = (cbv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbv.xbk = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94602);
                    return 0;
                case 2:
                    cbv.xbl = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94602);
                    return 0;
                case 3:
                    cbv.xbm = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94602);
                    return 0;
                case 4:
                    cbv.xbn = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94602);
                    return 0;
                case 5:
                    cbv.xbo = aVar3.BTU.vd();
                    AppMethodBeat.o(94602);
                    return 0;
                case 6:
                    cbv.xbp = aVar3.BTU.ve();
                    AppMethodBeat.o(94602);
                    return 0;
                case 7:
                    cbv.xbq = aVar3.BTU.ve();
                    AppMethodBeat.o(94602);
                    return 0;
                case 8:
                    cbv.bEJ = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94602);
                    return 0;
                case 9:
                    cbv.rkk = aVar3.BTU.vd();
                    AppMethodBeat.o(94602);
                    return 0;
                default:
                    AppMethodBeat.o(94602);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94602);
            return -1;
        }
    }
}
