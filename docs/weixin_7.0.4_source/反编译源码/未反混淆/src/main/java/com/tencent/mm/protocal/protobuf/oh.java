package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class oh extends btd {
    public int vQe;
    public SKBuiltinBuffer_t vTO;
    public tc vTR;
    public int vTS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114433);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114433);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vTR != null) {
                aVar.iy(2, this.vTR.computeSize());
                this.vTR.writeFields(aVar);
            }
            if (this.vTO != null) {
                aVar.iy(3, this.vTO.computeSize());
                this.vTO.writeFields(aVar);
            }
            aVar.iz(4, this.vQe);
            aVar.iz(5, this.vTS);
            AppMethodBeat.o(114433);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vTR != null) {
                ix += e.a.a.a.ix(2, this.vTR.computeSize());
            }
            if (this.vTO != null) {
                ix += e.a.a.a.ix(3, this.vTO.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(4, this.vQe)) + e.a.a.b.b.a.bs(5, this.vTS);
            AppMethodBeat.o(114433);
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
                AppMethodBeat.o(114433);
                throw bVar;
            }
            AppMethodBeat.o(114433);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oh ohVar = (oh) objArr[1];
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
                        ohVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114433);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tc tcVar = new tc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tcVar.populateBuilderWithField(aVar4, tcVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ohVar.vTR = tcVar;
                    }
                    AppMethodBeat.o(114433);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ohVar.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(114433);
                    return 0;
                case 4:
                    ohVar.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(114433);
                    return 0;
                case 5:
                    ohVar.vTS = aVar3.BTU.vd();
                    AppMethodBeat.o(114433);
                    return 0;
                default:
                    AppMethodBeat.o(114433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114433);
            return -1;
        }
    }
}
