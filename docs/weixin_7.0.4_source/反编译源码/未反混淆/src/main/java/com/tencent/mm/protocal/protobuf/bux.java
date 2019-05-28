package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bux extends btd {
    public int vOq;
    public mh wWq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124349);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wWq != null) {
                aVar.iy(2, this.wWq.computeSize());
                this.wWq.writeFields(aVar);
            }
            aVar.iz(3, this.vOq);
            AppMethodBeat.o(124349);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wWq != null) {
                ix += e.a.a.a.ix(2, this.wWq.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.vOq);
            AppMethodBeat.o(124349);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124349);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bux bux = (bux) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bux.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124349);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mh mhVar = new mh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mhVar.populateBuilderWithField(aVar4, mhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bux.wWq = mhVar;
                    }
                    AppMethodBeat.o(124349);
                    return 0;
                case 3:
                    bux.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124349);
                    return 0;
                default:
                    AppMethodBeat.o(124349);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124349);
            return -1;
        }
    }
}
