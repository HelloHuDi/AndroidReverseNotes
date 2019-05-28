package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahw extends btd {
    public int kdT;
    public String kdU;
    public chl woi;
    public bab woj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48853);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48853);
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
            if (this.woi != null) {
                aVar.iy(4, this.woi.computeSize());
                this.woi.writeFields(aVar);
            }
            if (this.woj != null) {
                aVar.iy(5, this.woj.computeSize());
                this.woj.writeFields(aVar);
            }
            AppMethodBeat.o(48853);
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
            if (this.woi != null) {
                ix += e.a.a.a.ix(4, this.woi.computeSize());
            }
            if (this.woj != null) {
                ix += e.a.a.a.ix(5, this.woj.computeSize());
            }
            AppMethodBeat.o(48853);
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
                AppMethodBeat.o(48853);
                throw bVar;
            }
            AppMethodBeat.o(48853);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahw ahw = (ahw) objArr[1];
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
                        ahw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48853);
                    return 0;
                case 2:
                    ahw.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48853);
                    return 0;
                case 3:
                    ahw.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48853);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(aVar4, chl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ahw.woi = chl;
                    }
                    AppMethodBeat.o(48853);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bab bab = new bab();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bab.populateBuilderWithField(aVar4, bab, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ahw.woj = bab;
                    }
                    AppMethodBeat.o(48853);
                    return 0;
                default:
                    AppMethodBeat.o(48853);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48853);
            return -1;
        }
    }
}
