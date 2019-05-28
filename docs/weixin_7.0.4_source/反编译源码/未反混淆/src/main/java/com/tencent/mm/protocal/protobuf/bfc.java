package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfc extends bsr {
    public int vZZ;
    public int wIX;
    public LinkedList<bfe> wIY = new LinkedList();
    public LinkedList<bfb> wIZ = new LinkedList();

    public bfc() {
        AppMethodBeat.i(14734);
        AppMethodBeat.o(14734);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14735);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wIX);
            aVar.iz(3, this.vZZ);
            aVar.e(4, 8, this.wIY);
            aVar.e(5, 8, this.wIZ);
            AppMethodBeat.o(14735);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.wIX)) + e.a.a.b.b.a.bs(3, this.vZZ)) + e.a.a.a.c(4, 8, this.wIY)) + e.a.a.a.c(5, 8, this.wIZ);
            AppMethodBeat.o(14735);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIY.clear();
            this.wIZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14735);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfc bfc = (bfc) objArr[1];
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
                        bfc.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(14735);
                    return 0;
                case 2:
                    bfc.wIX = aVar3.BTU.vd();
                    AppMethodBeat.o(14735);
                    return 0;
                case 3:
                    bfc.vZZ = aVar3.BTU.vd();
                    AppMethodBeat.o(14735);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bfe bfe = new bfe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfe.populateBuilderWithField(aVar4, bfe, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfc.wIY.add(bfe);
                    }
                    AppMethodBeat.o(14735);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bfb bfb = new bfb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfb.populateBuilderWithField(aVar4, bfb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfc.wIZ.add(bfb);
                    }
                    AppMethodBeat.o(14735);
                    return 0;
                default:
                    AppMethodBeat.o(14735);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14735);
            return -1;
        }
    }
}
