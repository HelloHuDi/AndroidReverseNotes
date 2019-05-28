package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brk extends bsr {
    public int vZZ;
    public LinkedList<ks> wTG = new LinkedList();
    public int wTH;
    public int wTI;

    public brk() {
        AppMethodBeat.i(14742);
        AppMethodBeat.o(14742);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14743);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.wTG);
            aVar.iz(3, this.wTH);
            aVar.iz(4, this.wTI);
            aVar.iz(5, this.vZZ);
            AppMethodBeat.o(14743);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + e.a.a.a.c(2, 8, this.wTG)) + e.a.a.b.b.a.bs(3, this.wTH)) + e.a.a.b.b.a.bs(4, this.wTI)) + e.a.a.b.b.a.bs(5, this.vZZ);
            AppMethodBeat.o(14743);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wTG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14743);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brk brk = (brk) objArr[1];
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
                        brk.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(14743);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ks ksVar = new ks();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ksVar.populateBuilderWithField(aVar4, ksVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        brk.wTG.add(ksVar);
                    }
                    AppMethodBeat.o(14743);
                    return 0;
                case 3:
                    brk.wTH = aVar3.BTU.vd();
                    AppMethodBeat.o(14743);
                    return 0;
                case 4:
                    brk.wTI = aVar3.BTU.vd();
                    AppMethodBeat.o(14743);
                    return 0;
                case 5:
                    brk.vZZ = aVar3.BTU.vd();
                    AppMethodBeat.o(14743);
                    return 0;
                default:
                    AppMethodBeat.o(14743);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14743);
            return -1;
        }
    }
}
