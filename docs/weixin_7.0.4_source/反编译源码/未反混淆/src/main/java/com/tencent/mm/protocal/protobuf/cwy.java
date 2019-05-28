package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cwy extends btd {
    public b vMS;
    public LinkedList<cwx> vMT = new LinkedList();

    public cwy() {
        AppMethodBeat.i(96335);
        AppMethodBeat.o(96335);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96336);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96336);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vMS != null) {
                aVar.c(2, this.vMS);
            }
            aVar.e(3, 8, this.vMT);
            AppMethodBeat.o(96336);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMS != null) {
                ix += e.a.a.b.b.a.b(2, this.vMS);
            }
            int c = ix + e.a.a.a.c(3, 8, this.vMT);
            AppMethodBeat.o(96336);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vMT.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96336);
                throw bVar;
            }
            AppMethodBeat.o(96336);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwy cwy = (cwy) objArr[1];
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
                        cwy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96336);
                    return 0;
                case 2:
                    cwy.vMS = aVar3.BTU.emu();
                    AppMethodBeat.o(96336);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwx cwx = new cwx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwx.populateBuilderWithField(aVar4, cwx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwy.vMT.add(cwx);
                    }
                    AppMethodBeat.o(96336);
                    return 0;
                default:
                    AppMethodBeat.o(96336);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96336);
            return -1;
        }
    }
}
