package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsf extends bsr {
    public long bHi;
    public LinkedList<zd> wUh = new LinkedList();
    public int wUi;
    public int wUj;
    public LinkedList<sp> wUk = new LinkedList();
    public int wUl;
    public sq wsi;

    public bsf() {
        AppMethodBeat.i(134443);
        AppMethodBeat.o(134443);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134444);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(2, this.bHi);
            aVar.e(3, 8, this.wUh);
            aVar.iz(5, this.wUi);
            aVar.iz(6, this.wUj);
            if (this.wsi != null) {
                aVar.iy(7, this.wsi.computeSize());
                this.wsi.writeFields(aVar);
            }
            aVar.e(8, 8, this.wUk);
            aVar.iz(9, this.wUl);
            AppMethodBeat.o(134444);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + e.a.a.b.b.a.o(2, this.bHi)) + e.a.a.a.c(3, 8, this.wUh)) + e.a.a.b.b.a.bs(5, this.wUi)) + e.a.a.b.b.a.bs(6, this.wUj);
            if (this.wsi != null) {
                ix += e.a.a.a.ix(7, this.wsi.computeSize());
            }
            int c = (ix + e.a.a.a.c(8, 8, this.wUk)) + e.a.a.b.b.a.bs(9, this.wUl);
            AppMethodBeat.o(134444);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wUh.clear();
            this.wUk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134444);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsf bsf = (bsf) objArr[1];
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
                        bsf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(134444);
                    return 0;
                case 2:
                    bsf.bHi = aVar3.BTU.ve();
                    AppMethodBeat.o(134444);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        zd zdVar = new zd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zdVar.populateBuilderWithField(aVar4, zdVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsf.wUh.add(zdVar);
                    }
                    AppMethodBeat.o(134444);
                    return 0;
                case 5:
                    bsf.wUi = aVar3.BTU.vd();
                    AppMethodBeat.o(134444);
                    return 0;
                case 6:
                    bsf.wUj = aVar3.BTU.vd();
                    AppMethodBeat.o(134444);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sq sqVar = new sq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sqVar.populateBuilderWithField(aVar4, sqVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsf.wsi = sqVar;
                    }
                    AppMethodBeat.o(134444);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sp spVar = new sp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = spVar.populateBuilderWithField(aVar4, spVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsf.wUk.add(spVar);
                    }
                    AppMethodBeat.o(134444);
                    return 0;
                case 9:
                    bsf.wUl = aVar3.BTU.vd();
                    AppMethodBeat.o(134444);
                    return 0;
                default:
                    AppMethodBeat.o(134444);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134444);
            return -1;
        }
    }
}
