package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxw extends a {
    public LinkedList<Integer> xkP = new LinkedList();
    public cxp xsZ;
    public String xto;
    public int xtp;
    public int xtq;

    public cxw() {
        AppMethodBeat.i(115023);
        AppMethodBeat.o(115023);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115024);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xsZ != null) {
                aVar.iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(aVar);
            }
            if (this.xto != null) {
                aVar.e(2, this.xto);
            }
            aVar.e(3, 2, this.xkP);
            aVar.iz(4, this.xtp);
            aVar.iz(5, this.xtq);
            AppMethodBeat.o(115024);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = e.a.a.a.ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xto != null) {
                ix += e.a.a.b.b.a.f(2, this.xto);
            }
            int c = ((ix + e.a.a.a.c(3, 2, this.xkP)) + e.a.a.b.b.a.bs(4, this.xtp)) + e.a.a.b.b.a.bs(5, this.xtq);
            AppMethodBeat.o(115024);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xkP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115024);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxw cxw = (cxw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxp cxp = new cxp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxp.populateBuilderWithField(aVar4, cxp, a.getNextFieldNumber(aVar4))) {
                        }
                        cxw.xsZ = cxp;
                    }
                    AppMethodBeat.o(115024);
                    return 0;
                case 2:
                    cxw.xto = aVar3.BTU.readString();
                    AppMethodBeat.o(115024);
                    return 0;
                case 3:
                    cxw.xkP.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(115024);
                    return 0;
                case 4:
                    cxw.xtp = aVar3.BTU.vd();
                    AppMethodBeat.o(115024);
                    return 0;
                case 5:
                    cxw.xtq = aVar3.BTU.vd();
                    AppMethodBeat.o(115024);
                    return 0;
                default:
                    AppMethodBeat.o(115024);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115024);
            return -1;
        }
    }
}
