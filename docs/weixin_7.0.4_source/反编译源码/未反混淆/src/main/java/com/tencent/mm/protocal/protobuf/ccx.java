package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ccx extends a {
    public int vZF;
    public int wem;
    public int xcA;
    public int xcB;
    public int xcr;
    public int xcs;
    public int xct;
    public int xcu;
    public int xcv;
    public LinkedList<Integer> xcw = new LinkedList();
    public int xcx;
    public int xcy;
    public LinkedList<Integer> xcz = new LinkedList();

    public ccx() {
        AppMethodBeat.i(5221);
        AppMethodBeat.o(5221);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5222);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wem);
            aVar.iz(2, this.xcr);
            aVar.iz(3, this.vZF);
            aVar.iz(4, this.xcs);
            aVar.iz(5, this.xct);
            aVar.iz(6, this.xcu);
            aVar.iz(7, this.xcv);
            aVar.e(8, 2, this.xcw);
            aVar.iz(9, this.xcx);
            aVar.iz(10, this.xcy);
            aVar.e(11, 2, this.xcz);
            aVar.iz(12, this.xcA);
            aVar.iz(13, this.xcB);
            AppMethodBeat.o(5222);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((e.a.a.b.b.a.bs(1, this.wem) + 0) + e.a.a.b.b.a.bs(2, this.xcr)) + e.a.a.b.b.a.bs(3, this.vZF)) + e.a.a.b.b.a.bs(4, this.xcs)) + e.a.a.b.b.a.bs(5, this.xct)) + e.a.a.b.b.a.bs(6, this.xcu)) + e.a.a.b.b.a.bs(7, this.xcv)) + e.a.a.a.c(8, 2, this.xcw)) + e.a.a.b.b.a.bs(9, this.xcx)) + e.a.a.b.b.a.bs(10, this.xcy)) + e.a.a.a.c(11, 2, this.xcz)) + e.a.a.b.b.a.bs(12, this.xcA)) + e.a.a.b.b.a.bs(13, this.xcB);
            AppMethodBeat.o(5222);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xcw.clear();
            this.xcz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5222);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccx ccx = (ccx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccx.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 2:
                    ccx.xcr = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 3:
                    ccx.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 4:
                    ccx.xcs = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 5:
                    ccx.xct = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 6:
                    ccx.xcu = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 7:
                    ccx.xcv = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 8:
                    ccx.xcw.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(5222);
                    return 0;
                case 9:
                    ccx.xcx = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 10:
                    ccx.xcy = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 11:
                    ccx.xcz.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(5222);
                    return 0;
                case 12:
                    ccx.xcA = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                case 13:
                    ccx.xcB = aVar3.BTU.vd();
                    AppMethodBeat.o(5222);
                    return 0;
                default:
                    AppMethodBeat.o(5222);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5222);
            return -1;
        }
    }
}
