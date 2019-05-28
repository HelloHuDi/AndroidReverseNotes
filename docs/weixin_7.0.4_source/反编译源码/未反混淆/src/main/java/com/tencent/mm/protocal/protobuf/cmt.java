package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cmt extends btd {
    public String wTo;
    public int wTp;
    public bdv wmQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(858);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(858);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wTo != null) {
                aVar.e(2, this.wTo);
            }
            if (this.wmQ != null) {
                aVar.iy(3, this.wmQ.computeSize());
                this.wmQ.writeFields(aVar);
            }
            aVar.iz(4, this.wTp);
            AppMethodBeat.o(858);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wTo != null) {
                ix += e.a.a.b.b.a.f(2, this.wTo);
            }
            if (this.wmQ != null) {
                ix += e.a.a.a.ix(3, this.wmQ.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(4, this.wTp);
            AppMethodBeat.o(858);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(858);
                throw bVar;
            }
            AppMethodBeat.o(858);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmt cmt = (cmt) objArr[1];
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
                        cmt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(858);
                    return 0;
                case 2:
                    cmt.wTo = aVar3.BTU.readString();
                    AppMethodBeat.o(858);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdv bdv = new bdv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdv.populateBuilderWithField(aVar4, bdv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cmt.wmQ = bdv;
                    }
                    AppMethodBeat.o(858);
                    return 0;
                case 4:
                    cmt.wTp = aVar3.BTU.vd();
                    AppMethodBeat.o(858);
                    return 0;
                default:
                    AppMethodBeat.o(858);
                    return -1;
            }
        } else {
            AppMethodBeat.o(858);
            return -1;
        }
    }
}
