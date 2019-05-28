package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsv extends btd {
    public String nYX;
    public String wKJ;
    public String wKw;
    public int wKy;
    public int wUT;
    public int wUU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56961);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56961);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.nYX != null) {
                aVar.e(2, this.nYX);
            }
            if (this.wKw != null) {
                aVar.e(3, this.wKw);
            }
            aVar.iz(4, this.wUT);
            aVar.iz(5, this.wUU);
            aVar.iz(6, this.wKy);
            if (this.wKJ != null) {
                aVar.e(7, this.wKJ);
            }
            AppMethodBeat.o(56961);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nYX != null) {
                ix += e.a.a.b.b.a.f(2, this.nYX);
            }
            if (this.wKw != null) {
                ix += e.a.a.b.b.a.f(3, this.wKw);
            }
            ix = ((ix + e.a.a.b.b.a.bs(4, this.wUT)) + e.a.a.b.b.a.bs(5, this.wUU)) + e.a.a.b.b.a.bs(6, this.wKy);
            if (this.wKJ != null) {
                ix += e.a.a.b.b.a.f(7, this.wKJ);
            }
            AppMethodBeat.o(56961);
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
                AppMethodBeat.o(56961);
                throw bVar;
            }
            AppMethodBeat.o(56961);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsv bsv = (bsv) objArr[1];
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
                        bsv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56961);
                    return 0;
                case 2:
                    bsv.nYX = aVar3.BTU.readString();
                    AppMethodBeat.o(56961);
                    return 0;
                case 3:
                    bsv.wKw = aVar3.BTU.readString();
                    AppMethodBeat.o(56961);
                    return 0;
                case 4:
                    bsv.wUT = aVar3.BTU.vd();
                    AppMethodBeat.o(56961);
                    return 0;
                case 5:
                    bsv.wUU = aVar3.BTU.vd();
                    AppMethodBeat.o(56961);
                    return 0;
                case 6:
                    bsv.wKy = aVar3.BTU.vd();
                    AppMethodBeat.o(56961);
                    return 0;
                case 7:
                    bsv.wKJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56961);
                    return 0;
                default:
                    AppMethodBeat.o(56961);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56961);
            return -1;
        }
    }
}
