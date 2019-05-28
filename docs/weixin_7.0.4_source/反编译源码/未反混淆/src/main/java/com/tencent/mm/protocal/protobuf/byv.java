package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class byv extends bsr {
    public int cME;
    public LinkedList<byx> fjr = new LinkedList();
    public cdc vBy;
    public String wSq;
    public int wYd;
    public bzm wYe;
    public String wni;

    public byv() {
        AppMethodBeat.i(89137);
        AppMethodBeat.o(89137);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89138);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wYd);
            aVar.e(3, 8, this.fjr);
            if (this.wSq != null) {
                aVar.e(4, this.wSq);
            }
            if (this.wni != null) {
                aVar.e(5, this.wni);
            }
            if (this.wYe != null) {
                aVar.iy(6, this.wYe.computeSize());
                this.wYe.writeFields(aVar);
            }
            aVar.iz(7, this.cME);
            if (this.vBy != null) {
                aVar.iy(8, this.vBy.computeSize());
                this.vBy.writeFields(aVar);
            }
            AppMethodBeat.o(89138);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wYd)) + e.a.a.a.c(3, 8, this.fjr);
            if (this.wSq != null) {
                ix += e.a.a.b.b.a.f(4, this.wSq);
            }
            if (this.wni != null) {
                ix += e.a.a.b.b.a.f(5, this.wni);
            }
            if (this.wYe != null) {
                ix += e.a.a.a.ix(6, this.wYe.computeSize());
            }
            ix += e.a.a.b.b.a.bs(7, this.cME);
            if (this.vBy != null) {
                ix += e.a.a.a.ix(8, this.vBy.computeSize());
            }
            AppMethodBeat.o(89138);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89138);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byv byv = (byv) objArr[1];
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
                        byv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89138);
                    return 0;
                case 2:
                    byv.wYd = aVar3.BTU.vd();
                    AppMethodBeat.o(89138);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        byx byx = new byx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.populateBuilderWithField(aVar4, byx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byv.fjr.add(byx);
                    }
                    AppMethodBeat.o(89138);
                    return 0;
                case 4:
                    byv.wSq = aVar3.BTU.readString();
                    AppMethodBeat.o(89138);
                    return 0;
                case 5:
                    byv.wni = aVar3.BTU.readString();
                    AppMethodBeat.o(89138);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzm bzm = new bzm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzm.populateBuilderWithField(aVar4, bzm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byv.wYe = bzm;
                    }
                    AppMethodBeat.o(89138);
                    return 0;
                case 7:
                    byv.cME = aVar3.BTU.vd();
                    AppMethodBeat.o(89138);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdc cdc = new cdc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdc.populateBuilderWithField(aVar4, cdc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byv.vBy = cdc;
                    }
                    AppMethodBeat.o(89138);
                    return 0;
                default:
                    AppMethodBeat.o(89138);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89138);
            return -1;
        }
    }
}
