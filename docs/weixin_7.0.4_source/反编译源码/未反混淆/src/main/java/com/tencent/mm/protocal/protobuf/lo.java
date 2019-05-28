package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lo extends btd {
    public int kdT;
    public String kdU;
    public mr vPf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56717);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56717);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            if (this.vPf != null) {
                aVar.iy(4, this.vPf.computeSize());
                this.vPf.writeFields(aVar);
            }
            AppMethodBeat.o(56717);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            if (this.vPf != null) {
                ix += e.a.a.a.ix(4, this.vPf.computeSize());
            }
            AppMethodBeat.o(56717);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56717);
                throw bVar;
            }
            AppMethodBeat.o(56717);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lo loVar = (lo) objArr[1];
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
                        loVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56717);
                    return 0;
                case 2:
                    loVar.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56717);
                    return 0;
                case 3:
                    loVar.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56717);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mr mrVar = new mr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mrVar.populateBuilderWithField(aVar4, mrVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        loVar.vPf = mrVar;
                    }
                    AppMethodBeat.o(56717);
                    return 0;
                default:
                    AppMethodBeat.o(56717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56717);
            return -1;
        }
    }
}
