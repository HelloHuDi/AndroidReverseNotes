package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpv extends bsr {
    public int wPb;
    public int wem;
    public long wen;
    public int xnN;
    public int xnO;
    public LinkedList<cpy> xnP = new LinkedList();
    public int xnQ;

    public cpv() {
        AppMethodBeat.i(5259);
        AppMethodBeat.o(5259);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5260);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.wPb);
            aVar.iz(5, this.xnN);
            aVar.iz(6, this.xnO);
            aVar.e(7, 8, this.xnP);
            aVar.iz(8, this.xnQ);
            AppMethodBeat.o(5260);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.wPb)) + e.a.a.b.b.a.bs(5, this.xnN)) + e.a.a.b.b.a.bs(6, this.xnO)) + e.a.a.a.c(7, 8, this.xnP)) + e.a.a.b.b.a.bs(8, this.xnQ);
            AppMethodBeat.o(5260);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xnP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5260);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpv cpv = (cpv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5260);
                    return 0;
                case 2:
                    cpv.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5260);
                    return 0;
                case 3:
                    cpv.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5260);
                    return 0;
                case 4:
                    cpv.wPb = aVar3.BTU.vd();
                    AppMethodBeat.o(5260);
                    return 0;
                case 5:
                    cpv.xnN = aVar3.BTU.vd();
                    AppMethodBeat.o(5260);
                    return 0;
                case 6:
                    cpv.xnO = aVar3.BTU.vd();
                    AppMethodBeat.o(5260);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpy cpy = new cpy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpy.populateBuilderWithField(aVar4, cpy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpv.xnP.add(cpy);
                    }
                    AppMethodBeat.o(5260);
                    return 0;
                case 8:
                    cpv.xnQ = aVar3.BTU.vd();
                    AppMethodBeat.o(5260);
                    return 0;
                default:
                    AppMethodBeat.o(5260);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5260);
            return -1;
        }
    }
}
