package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xs extends btd {
    public int eCL;
    public b wdt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96219);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wdt != null) {
                aVar.c(2, this.wdt);
            }
            aVar.iz(3, this.eCL);
            AppMethodBeat.o(96219);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wdt != null) {
                ix += e.a.a.b.b.a.b(2, this.wdt);
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.eCL);
            AppMethodBeat.o(96219);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96219);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xs xsVar = (xs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        xsVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96219);
                    return 0;
                case 2:
                    xsVar.wdt = aVar3.BTU.emu();
                    AppMethodBeat.o(96219);
                    return 0;
                case 3:
                    xsVar.eCL = aVar3.BTU.vd();
                    AppMethodBeat.o(96219);
                    return 0;
                default:
                    AppMethodBeat.o(96219);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96219);
            return -1;
        }
    }
}
