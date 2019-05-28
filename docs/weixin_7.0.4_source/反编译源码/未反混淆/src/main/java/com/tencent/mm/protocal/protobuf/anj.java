package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anj extends btd {
    public cxd wpb;
    public int wsf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134429);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134429);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wpb != null) {
                aVar.iy(2, this.wpb.computeSize());
                this.wpb.writeFields(aVar);
            }
            aVar.iz(3, this.wsf);
            AppMethodBeat.o(134429);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wpb != null) {
                ix += e.a.a.a.ix(2, this.wpb.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.wsf);
            AppMethodBeat.o(134429);
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
                AppMethodBeat.o(134429);
                throw bVar;
            }
            AppMethodBeat.o(134429);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anj anj = (anj) objArr[1];
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
                        anj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(134429);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxd cxd = new cxd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxd.populateBuilderWithField(aVar4, cxd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anj.wpb = cxd;
                    }
                    AppMethodBeat.o(134429);
                    return 0;
                case 3:
                    anj.wsf = aVar3.BTU.vd();
                    AppMethodBeat.o(134429);
                    return 0;
                default:
                    AppMethodBeat.o(134429);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134429);
            return -1;
        }
    }
}
