package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ia extends bsr {
    public int cME;
    public LinkedList<oj> fjr = new LinkedList();
    public cdc vBy;

    public ia() {
        AppMethodBeat.i(89011);
        AppMethodBeat.o(89011);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89012);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.fjr);
            if (this.vBy != null) {
                aVar.iy(3, this.vBy.computeSize());
                this.vBy.writeFields(aVar);
            }
            aVar.iz(4, this.cME);
            AppMethodBeat.o(89012);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.fjr);
            if (this.vBy != null) {
                ix += e.a.a.a.ix(3, this.vBy.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(4, this.cME);
            AppMethodBeat.o(89012);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89012);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ia iaVar = (ia) objArr[1];
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
                        iaVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89012);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oj ojVar = new oj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ojVar.populateBuilderWithField(aVar4, ojVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        iaVar.fjr.add(ojVar);
                    }
                    AppMethodBeat.o(89012);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdc cdc = new cdc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdc.populateBuilderWithField(aVar4, cdc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        iaVar.vBy = cdc;
                    }
                    AppMethodBeat.o(89012);
                    return 0;
                case 4:
                    iaVar.cME = aVar3.BTU.vd();
                    AppMethodBeat.o(89012);
                    return 0;
                default:
                    AppMethodBeat.o(89012);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89012);
            return -1;
        }
    }
}
