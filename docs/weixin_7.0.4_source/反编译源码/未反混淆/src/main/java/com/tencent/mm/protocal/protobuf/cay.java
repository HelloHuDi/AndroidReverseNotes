package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cay extends btd {
    public int jCt;
    public int ptw;
    public int ptx;
    public SKBuiltinBuffer_t vJd;
    public String xac;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94574);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94574);
                throw bVar;
            } else if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(94574);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.ptx);
                aVar.iz(3, this.ptw);
                if (this.vJd != null) {
                    aVar.iy(4, this.vJd.computeSize());
                    this.vJd.writeFields(aVar);
                }
                if (this.xac != null) {
                    aVar.e(5, this.xac);
                }
                aVar.iz(6, this.jCt);
                AppMethodBeat.o(94574);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.vJd != null) {
                ix += e.a.a.a.ix(4, this.vJd.computeSize());
            }
            if (this.xac != null) {
                ix += e.a.a.b.b.a.f(5, this.xac);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.jCt);
            AppMethodBeat.o(94574);
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
                AppMethodBeat.o(94574);
                throw bVar;
            } else if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(94574);
                throw bVar;
            } else {
                AppMethodBeat.o(94574);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cay cay = (cay) objArr[1];
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
                        cay.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94574);
                    return 0;
                case 2:
                    cay.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(94574);
                    return 0;
                case 3:
                    cay.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(94574);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cay.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94574);
                    return 0;
                case 5:
                    cay.xac = aVar3.BTU.readString();
                    AppMethodBeat.o(94574);
                    return 0;
                case 6:
                    cay.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94574);
                    return 0;
                default:
                    AppMethodBeat.o(94574);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94574);
            return -1;
        }
    }
}
