package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxq extends a {
    public LinkedList<Integer> xkP = new LinkedList();
    public cxp xsZ;
    public LinkedList<Integer> xta = new LinkedList();
    public int xtb;
    public int xtc;

    public cxq() {
        AppMethodBeat.i(115016);
        AppMethodBeat.o(115016);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115017);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xsZ != null) {
                aVar.iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(aVar);
            }
            aVar.e(2, 2, this.xta);
            aVar.e(3, 2, this.xkP);
            aVar.iz(4, this.xtb);
            aVar.iz(5, this.xtc);
            AppMethodBeat.o(115017);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = e.a.a.a.ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + e.a.a.a.c(2, 2, this.xta)) + e.a.a.a.c(3, 2, this.xkP)) + e.a.a.b.b.a.bs(4, this.xtb)) + e.a.a.b.b.a.bs(5, this.xtc);
            AppMethodBeat.o(115017);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xta.clear();
            this.xkP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115017);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxq cxq = (cxq) objArr[1];
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
                        cxq.xsZ = cxp;
                    }
                    AppMethodBeat.o(115017);
                    return 0;
                case 2:
                    cxq.xta.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(115017);
                    return 0;
                case 3:
                    cxq.xkP.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(115017);
                    return 0;
                case 4:
                    cxq.xtb = aVar3.BTU.vd();
                    AppMethodBeat.o(115017);
                    return 0;
                case 5:
                    cxq.xtc = aVar3.BTU.vd();
                    AppMethodBeat.o(115017);
                    return 0;
                default:
                    AppMethodBeat.o(115017);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115017);
            return -1;
        }
    }
}
