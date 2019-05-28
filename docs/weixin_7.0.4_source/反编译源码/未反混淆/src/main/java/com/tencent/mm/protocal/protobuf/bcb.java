package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bcb extends bsr {
    public int Scene;
    public int vEp;
    public LinkedList<bcd> vKB = new LinkedList();
    public int wGE;
    public LinkedList<bca> wGF = new LinkedList();
    public int wGG;
    public String wGH;

    public bcb() {
        AppMethodBeat.i(51429);
        AppMethodBeat.o(51429);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51430);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vEp);
            aVar.iz(3, this.wGE);
            aVar.e(4, 8, this.wGF);
            aVar.iz(5, this.wGG);
            aVar.e(6, 8, this.vKB);
            if (this.wGH != null) {
                aVar.e(7, this.wGH);
            }
            aVar.iz(8, this.Scene);
            AppMethodBeat.o(51430);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.vEp)) + e.a.a.b.b.a.bs(3, this.wGE)) + e.a.a.a.c(4, 8, this.wGF)) + e.a.a.b.b.a.bs(5, this.wGG)) + e.a.a.a.c(6, 8, this.vKB);
            if (this.wGH != null) {
                ix += e.a.a.b.b.a.f(7, this.wGH);
            }
            int bs = ix + e.a.a.b.b.a.bs(8, this.Scene);
            AppMethodBeat.o(51430);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wGF.clear();
            this.vKB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51430);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcb bcb = (bcb) objArr[1];
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
                        bcb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(51430);
                    return 0;
                case 2:
                    bcb.vEp = aVar3.BTU.vd();
                    AppMethodBeat.o(51430);
                    return 0;
                case 3:
                    bcb.wGE = aVar3.BTU.vd();
                    AppMethodBeat.o(51430);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bca bca = new bca();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bca.populateBuilderWithField(aVar4, bca, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bcb.wGF.add(bca);
                    }
                    AppMethodBeat.o(51430);
                    return 0;
                case 5:
                    bcb.wGG = aVar3.BTU.vd();
                    AppMethodBeat.o(51430);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bcd bcd = new bcd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bcd.populateBuilderWithField(aVar4, bcd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bcb.vKB.add(bcd);
                    }
                    AppMethodBeat.o(51430);
                    return 0;
                case 7:
                    bcb.wGH = aVar3.BTU.readString();
                    AppMethodBeat.o(51430);
                    return 0;
                case 8:
                    bcb.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(51430);
                    return 0;
                default:
                    AppMethodBeat.o(51430);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51430);
            return -1;
        }
    }
}
