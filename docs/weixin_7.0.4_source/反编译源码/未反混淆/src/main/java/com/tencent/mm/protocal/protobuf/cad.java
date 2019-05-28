package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cad extends a {
    public int pdi;
    public String vRN;
    public LinkedList<blq> wZm = new LinkedList();
    public ze wZn;
    public LinkedList<bpz> wZo = new LinkedList();
    public int wZp;
    public cx wpB;

    public cad() {
        AppMethodBeat.i(56975);
        AppMethodBeat.o(56975);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56976);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.pdi);
            aVar.e(2, 8, this.wZm);
            if (this.wZn != null) {
                aVar.iy(3, this.wZn.computeSize());
                this.wZn.writeFields(aVar);
            }
            if (this.wpB != null) {
                aVar.iy(4, this.wpB.computeSize());
                this.wpB.writeFields(aVar);
            }
            aVar.e(5, 8, this.wZo);
            aVar.iz(6, this.wZp);
            if (this.vRN != null) {
                aVar.e(7, this.vRN);
            }
            AppMethodBeat.o(56976);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.pdi) + 0) + e.a.a.a.c(2, 8, this.wZm);
            if (this.wZn != null) {
                bs += e.a.a.a.ix(3, this.wZn.computeSize());
            }
            if (this.wpB != null) {
                bs += e.a.a.a.ix(4, this.wpB.computeSize());
            }
            bs = (bs + e.a.a.a.c(5, 8, this.wZo)) + e.a.a.b.b.a.bs(6, this.wZp);
            if (this.vRN != null) {
                bs += e.a.a.b.b.a.f(7, this.vRN);
            }
            AppMethodBeat.o(56976);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wZm.clear();
            this.wZo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56976);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cad cad = (cad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cad.pdi = aVar3.BTU.vd();
                    AppMethodBeat.o(56976);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blq blq = new blq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blq.populateBuilderWithField(aVar4, blq, a.getNextFieldNumber(aVar4))) {
                        }
                        cad.wZm.add(blq);
                    }
                    AppMethodBeat.o(56976);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ze zeVar = new ze();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zeVar.populateBuilderWithField(aVar4, zeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cad.wZn = zeVar;
                    }
                    AppMethodBeat.o(56976);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cx cxVar = new cx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxVar.populateBuilderWithField(aVar4, cxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cad.wpB = cxVar;
                    }
                    AppMethodBeat.o(56976);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpz bpz = new bpz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpz.populateBuilderWithField(aVar4, bpz, a.getNextFieldNumber(aVar4))) {
                        }
                        cad.wZo.add(bpz);
                    }
                    AppMethodBeat.o(56976);
                    return 0;
                case 6:
                    cad.wZp = aVar3.BTU.vd();
                    AppMethodBeat.o(56976);
                    return 0;
                case 7:
                    cad.vRN = aVar3.BTU.readString();
                    AppMethodBeat.o(56976);
                    return 0;
                default:
                    AppMethodBeat.o(56976);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56976);
            return -1;
        }
    }
}
