package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aio extends btd {
    public b woA;
    public b woy;
    public int woz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80072);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80072);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(3, this.woz);
            if (this.woA != null) {
                aVar.c(4, this.woA);
            }
            if (this.woy != null) {
                aVar.c(5, this.woy);
            }
            AppMethodBeat.o(80072);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(3, this.woz);
            if (this.woA != null) {
                ix += e.a.a.b.b.a.b(4, this.woA);
            }
            if (this.woy != null) {
                ix += e.a.a.b.b.a.b(5, this.woy);
            }
            AppMethodBeat.o(80072);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80072);
                throw bVar;
            }
            AppMethodBeat.o(80072);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aio aio = (aio) objArr[1];
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
                        aio.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80072);
                    return 0;
                case 3:
                    aio.woz = aVar3.BTU.vd();
                    AppMethodBeat.o(80072);
                    return 0;
                case 4:
                    aio.woA = aVar3.BTU.emu();
                    AppMethodBeat.o(80072);
                    return 0;
                case 5:
                    aio.woy = aVar3.BTU.emu();
                    AppMethodBeat.o(80072);
                    return 0;
                default:
                    AppMethodBeat.o(80072);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80072);
            return -1;
        }
    }
}
