package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cqd extends bsr {
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

    public cqd() {
        AppMethodBeat.i(5270);
        AppMethodBeat.o(5270);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5271);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.iz(3, this.xcr);
            aVar.iz(4, this.vZF);
            aVar.iz(5, this.xcs);
            aVar.iz(6, this.xct);
            aVar.iz(7, this.xcu);
            aVar.iz(8, this.xcv);
            aVar.f(9, 2, this.xcw);
            aVar.iz(10, this.xcx);
            aVar.iz(11, this.xcy);
            aVar.f(12, 2, this.xcz);
            aVar.iz(13, this.xcA);
            aVar.iz(14, this.xcB);
            AppMethodBeat.o(5271);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((((((((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.bs(3, this.xcr)) + e.a.a.b.b.a.bs(4, this.vZF)) + e.a.a.b.b.a.bs(5, this.xcs)) + e.a.a.b.b.a.bs(6, this.xct)) + e.a.a.b.b.a.bs(7, this.xcu)) + e.a.a.b.b.a.bs(8, this.xcv)) + e.a.a.a.d(9, 2, this.xcw)) + e.a.a.b.b.a.bs(10, this.xcx)) + e.a.a.b.b.a.bs(11, this.xcy)) + e.a.a.a.d(12, 2, this.xcz)) + e.a.a.b.b.a.bs(13, this.xcA)) + e.a.a.b.b.a.bs(14, this.xcB);
            AppMethodBeat.o(5271);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xcw.clear();
            this.xcz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5271);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqd cqd = (cqd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqd.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5271);
                    return 0;
                case 2:
                    cqd.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 3:
                    cqd.xcr = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 4:
                    cqd.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 5:
                    cqd.xcs = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 6:
                    cqd.xct = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 7:
                    cqd.xcu = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 8:
                    cqd.xcv = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 9:
                    cqd.xcw = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(5271);
                    return 0;
                case 10:
                    cqd.xcx = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 11:
                    cqd.xcy = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 12:
                    cqd.xcz = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(5271);
                    return 0;
                case 13:
                    cqd.xcA = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                case 14:
                    cqd.xcB = aVar3.BTU.vd();
                    AppMethodBeat.o(5271);
                    return 0;
                default:
                    AppMethodBeat.o(5271);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5271);
            return -1;
        }
    }
}
