package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bow extends bsr {
    public bqe wRt;
    public bqc wRu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134436);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wRt != null) {
                aVar.iy(2, this.wRt.computeSize());
                this.wRt.writeFields(aVar);
            }
            if (this.wRu != null) {
                aVar.iy(3, this.wRu.computeSize());
                this.wRu.writeFields(aVar);
            }
            AppMethodBeat.o(134436);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wRt != null) {
                ix += e.a.a.a.ix(2, this.wRt.computeSize());
            }
            if (this.wRu != null) {
                ix += e.a.a.a.ix(3, this.wRu.computeSize());
            }
            AppMethodBeat.o(134436);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134436);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bow bow = (bow) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        bow.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(134436);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqe bqe = new bqe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqe.populateBuilderWithField(aVar4, bqe, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bow.wRt = bqe;
                    }
                    AppMethodBeat.o(134436);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqc bqc = new bqc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqc.populateBuilderWithField(aVar4, bqc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bow.wRu = bqc;
                    }
                    AppMethodBeat.o(134436);
                    return 0;
                default:
                    AppMethodBeat.o(134436);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134436);
            return -1;
        }
    }
}
