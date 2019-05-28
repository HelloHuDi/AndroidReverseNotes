package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anl extends btd {
    public long bHi;
    public int hbl;
    public LinkedList<bqj> wsk = new LinkedList();
    public LinkedList<bqd> wsl = new LinkedList();
    public int wsm;

    public anl() {
        AppMethodBeat.i(134431);
        AppMethodBeat.o(134431);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134432);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134432);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.hbl);
            aVar.e(3, 8, this.wsk);
            aVar.ai(4, this.bHi);
            aVar.e(5, 8, this.wsl);
            aVar.iz(6, this.wsm);
            AppMethodBeat.o(134432);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(2, this.hbl)) + e.a.a.a.c(3, 8, this.wsk)) + e.a.a.b.b.a.o(4, this.bHi)) + e.a.a.a.c(5, 8, this.wsl)) + e.a.a.b.b.a.bs(6, this.wsm);
            AppMethodBeat.o(134432);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsk.clear();
            this.wsl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134432);
                throw bVar;
            }
            AppMethodBeat.o(134432);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anl anl = (anl) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(134432);
                    return 0;
                case 2:
                    anl.hbl = aVar3.BTU.vd();
                    AppMethodBeat.o(134432);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqj bqj = new bqj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqj.populateBuilderWithField(aVar4, bqj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anl.wsk.add(bqj);
                    }
                    AppMethodBeat.o(134432);
                    return 0;
                case 4:
                    anl.bHi = aVar3.BTU.ve();
                    AppMethodBeat.o(134432);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.populateBuilderWithField(aVar4, bqd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anl.wsl.add(bqd);
                    }
                    AppMethodBeat.o(134432);
                    return 0;
                case 6:
                    anl.wsm = aVar3.BTU.vd();
                    AppMethodBeat.o(134432);
                    return 0;
                default:
                    AppMethodBeat.o(134432);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134432);
            return -1;
        }
    }
}
