package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bkd extends a {
    public cgv vCN;
    public cgv vCO;
    public auj wNo;
    public LinkedList<ob> wNp = new LinkedList();
    public bdw wNq;

    public bkd() {
        AppMethodBeat.i(48922);
        AppMethodBeat.o(48922);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48923);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wNo != null) {
                aVar.iy(1, this.wNo.computeSize());
                this.wNo.writeFields(aVar);
            }
            if (this.vCN != null) {
                aVar.iy(2, this.vCN.computeSize());
                this.vCN.writeFields(aVar);
            }
            if (this.vCO != null) {
                aVar.iy(3, this.vCO.computeSize());
                this.vCO.writeFields(aVar);
            }
            aVar.e(4, 8, this.wNp);
            if (this.wNq != null) {
                aVar.iy(5, this.wNq.computeSize());
                this.wNq.writeFields(aVar);
            }
            AppMethodBeat.o(48923);
            return 0;
        } else if (i == 1) {
            if (this.wNo != null) {
                ix = e.a.a.a.ix(1, this.wNo.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vCN != null) {
                ix += e.a.a.a.ix(2, this.vCN.computeSize());
            }
            if (this.vCO != null) {
                ix += e.a.a.a.ix(3, this.vCO.computeSize());
            }
            ix += e.a.a.a.c(4, 8, this.wNp);
            if (this.wNq != null) {
                ix += e.a.a.a.ix(5, this.wNq.computeSize());
            }
            AppMethodBeat.o(48923);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wNp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48923);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkd bkd = (bkd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cgv cgv;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        bkd.wNo = auj;
                    }
                    AppMethodBeat.o(48923);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bkd.vCN = cgv;
                    }
                    AppMethodBeat.o(48923);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bkd.vCO = cgv;
                    }
                    AppMethodBeat.o(48923);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ob obVar = new ob();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = obVar.populateBuilderWithField(aVar4, obVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bkd.wNp.add(obVar);
                    }
                    AppMethodBeat.o(48923);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdw bdw = new bdw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdw.populateBuilderWithField(aVar4, bdw, a.getNextFieldNumber(aVar4))) {
                        }
                        bkd.wNq = bdw;
                    }
                    AppMethodBeat.o(48923);
                    return 0;
                default:
                    AppMethodBeat.o(48923);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48923);
            return -1;
        }
    }
}
