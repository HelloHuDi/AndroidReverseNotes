package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aku extends btd {
    public int kKI;
    public int kdT;
    public String kdU;
    public int wqk;
    public bik wqr;
    public int wqs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89098);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89098);
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
            aVar.iz(4, this.kKI);
            aVar.iz(5, this.wqk);
            if (this.wqr != null) {
                aVar.iy(6, this.wqr.computeSize());
                this.wqr.writeFields(aVar);
            }
            aVar.iz(7, this.wqs);
            AppMethodBeat.o(89098);
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
            ix = (ix + e.a.a.b.b.a.bs(4, this.kKI)) + e.a.a.b.b.a.bs(5, this.wqk);
            if (this.wqr != null) {
                ix += e.a.a.a.ix(6, this.wqr.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.wqs);
            AppMethodBeat.o(89098);
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
                AppMethodBeat.o(89098);
                throw bVar;
            }
            AppMethodBeat.o(89098);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aku aku = (aku) objArr[1];
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
                        aku.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89098);
                    return 0;
                case 2:
                    aku.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(89098);
                    return 0;
                case 3:
                    aku.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(89098);
                    return 0;
                case 4:
                    aku.kKI = aVar3.BTU.vd();
                    AppMethodBeat.o(89098);
                    return 0;
                case 5:
                    aku.wqk = aVar3.BTU.vd();
                    AppMethodBeat.o(89098);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bik bik = new bik();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bik.populateBuilderWithField(aVar4, bik, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aku.wqr = bik;
                    }
                    AppMethodBeat.o(89098);
                    return 0;
                case 7:
                    aku.wqs = aVar3.BTU.vd();
                    AppMethodBeat.o(89098);
                    return 0;
                default:
                    AppMethodBeat.o(89098);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89098);
            return -1;
        }
    }
}
