package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsm extends bsr {
    public int wUF;
    public LinkedList<bts> wUG = new LinkedList();
    public bts wUH;
    public bts wUI;

    public bsm() {
        AppMethodBeat.i(116804);
        AppMethodBeat.o(116804);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116805);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wUF);
            aVar.e(3, 8, this.wUG);
            if (this.wUH != null) {
                aVar.iy(4, this.wUH.computeSize());
                this.wUH.writeFields(aVar);
            }
            if (this.wUI != null) {
                aVar.iy(5, this.wUI.computeSize());
                this.wUI.writeFields(aVar);
            }
            AppMethodBeat.o(116805);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wUF)) + e.a.a.a.c(3, 8, this.wUG);
            if (this.wUH != null) {
                ix += e.a.a.a.ix(4, this.wUH.computeSize());
            }
            if (this.wUI != null) {
                ix += e.a.a.a.ix(5, this.wUI.computeSize());
            }
            AppMethodBeat.o(116805);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wUG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(116805);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsm bsm = (bsm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        bsm.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116805);
                    return 0;
                case 2:
                    bsm.wUF = aVar3.BTU.vd();
                    AppMethodBeat.o(116805);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsm.wUG.add(bts);
                    }
                    AppMethodBeat.o(116805);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsm.wUH = bts;
                    }
                    AppMethodBeat.o(116805);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsm.wUI = bts;
                    }
                    AppMethodBeat.o(116805);
                    return 0;
                default:
                    AppMethodBeat.o(116805);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116805);
            return -1;
        }
    }
}
