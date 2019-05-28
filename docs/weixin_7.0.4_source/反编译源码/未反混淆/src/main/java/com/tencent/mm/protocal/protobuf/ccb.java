package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ccb extends btd {
    public int OpCode;
    public int jBv;
    public LinkedList<cbz> jBw = new LinkedList();
    public int qJO;
    public String xbu;

    public ccb() {
        AppMethodBeat.i(94609);
        AppMethodBeat.o(94609);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94610);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94610);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            if (this.xbu != null) {
                aVar.e(3, this.xbu);
            }
            aVar.iz(4, this.jBv);
            aVar.e(5, 8, this.jBw);
            aVar.iz(6, this.qJO);
            AppMethodBeat.o(94610);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.OpCode);
            if (this.xbu != null) {
                ix += e.a.a.b.b.a.f(3, this.xbu);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(4, this.jBv)) + e.a.a.a.c(5, 8, this.jBw)) + e.a.a.b.b.a.bs(6, this.qJO);
            AppMethodBeat.o(94610);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94610);
                throw bVar;
            }
            AppMethodBeat.o(94610);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccb ccb = (ccb) objArr[1];
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
                        ccb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94610);
                    return 0;
                case 2:
                    ccb.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(94610);
                    return 0;
                case 3:
                    ccb.xbu = aVar3.BTU.readString();
                    AppMethodBeat.o(94610);
                    return 0;
                case 4:
                    ccb.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(94610);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbz cbz = new cbz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbz.populateBuilderWithField(aVar4, cbz, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccb.jBw.add(cbz);
                    }
                    AppMethodBeat.o(94610);
                    return 0;
                case 6:
                    ccb.qJO = aVar3.BTU.vd();
                    AppMethodBeat.o(94610);
                    return 0;
                default:
                    AppMethodBeat.o(94610);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94610);
            return -1;
        }
    }
}
