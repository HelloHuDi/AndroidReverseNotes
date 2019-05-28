package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class coi extends btd {
    public int wem;
    public long wen;
    public int xlL;
    public int xlS;
    public cpr xlT;
    public int xlU;
    public int xlV;
    public int xlW;
    public int xlX;
    public SKBuiltinBuffer_t xlY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5226);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5226);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.xlS);
            if (this.xlT != null) {
                aVar.iy(5, this.xlT.computeSize());
                this.xlT.writeFields(aVar);
            }
            aVar.iz(6, this.xlL);
            aVar.iz(7, this.xlU);
            aVar.iz(8, this.xlV);
            aVar.iz(9, this.xlW);
            aVar.iz(10, this.xlX);
            if (this.xlY != null) {
                aVar.iy(11, this.xlY.computeSize());
                this.xlY.writeFields(aVar);
            }
            AppMethodBeat.o(5226);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.xlS);
            if (this.xlT != null) {
                ix += e.a.a.a.ix(5, this.xlT.computeSize());
            }
            ix = ((((ix + e.a.a.b.b.a.bs(6, this.xlL)) + e.a.a.b.b.a.bs(7, this.xlU)) + e.a.a.b.b.a.bs(8, this.xlV)) + e.a.a.b.b.a.bs(9, this.xlW)) + e.a.a.b.b.a.bs(10, this.xlX);
            if (this.xlY != null) {
                ix += e.a.a.a.ix(11, this.xlY.computeSize());
            }
            AppMethodBeat.o(5226);
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
                AppMethodBeat.o(5226);
                throw bVar;
            }
            AppMethodBeat.o(5226);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            coi coi = (coi) objArr[1];
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
                        coi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5226);
                    return 0;
                case 2:
                    coi.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 3:
                    coi.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5226);
                    return 0;
                case 4:
                    coi.xlS = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpr cpr = new cpr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpr.populateBuilderWithField(aVar4, cpr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coi.xlT = cpr;
                    }
                    AppMethodBeat.o(5226);
                    return 0;
                case 6:
                    coi.xlL = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 7:
                    coi.xlU = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 8:
                    coi.xlV = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 9:
                    coi.xlW = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 10:
                    coi.xlX = aVar3.BTU.vd();
                    AppMethodBeat.o(5226);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coi.xlY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5226);
                    return 0;
                default:
                    AppMethodBeat.o(5226);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5226);
            return -1;
        }
    }
}
