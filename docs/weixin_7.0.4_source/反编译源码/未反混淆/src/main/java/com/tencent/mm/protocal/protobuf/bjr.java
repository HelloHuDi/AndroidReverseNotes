package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjr extends btd {
    public int wMZ;
    public int wNa;
    public LinkedList<bkb> wNb = new LinkedList();

    public bjr() {
        AppMethodBeat.i(56906);
        AppMethodBeat.o(56906);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56907);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56907);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wMZ);
            aVar.iz(3, this.wNa);
            aVar.e(4, 8, this.wNb);
            AppMethodBeat.o(56907);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((ix + e.a.a.b.b.a.bs(2, this.wMZ)) + e.a.a.b.b.a.bs(3, this.wNa)) + e.a.a.a.c(4, 8, this.wNb);
            AppMethodBeat.o(56907);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wNb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56907);
                throw bVar;
            }
            AppMethodBeat.o(56907);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjr bjr = (bjr) objArr[1];
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
                        bjr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56907);
                    return 0;
                case 2:
                    bjr.wMZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56907);
                    return 0;
                case 3:
                    bjr.wNa = aVar3.BTU.vd();
                    AppMethodBeat.o(56907);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkb bkb = new bkb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkb.populateBuilderWithField(aVar4, bkb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjr.wNb.add(bkb);
                    }
                    AppMethodBeat.o(56907);
                    return 0;
                default:
                    AppMethodBeat.o(56907);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56907);
            return -1;
        }
    }
}
