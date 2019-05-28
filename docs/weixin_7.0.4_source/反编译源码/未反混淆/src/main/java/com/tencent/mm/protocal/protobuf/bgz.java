package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bgz extends btd {
    public SKBuiltinBuffer_t wKr;
    public tc wKs;
    public int wKt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80150);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80150);
                throw bVar;
            } else if (this.wKs == null) {
                bVar = new b("Not all required fields were included: cmd_list");
                AppMethodBeat.o(80150);
                throw bVar;
            } else if (this.wKr == null) {
                bVar = new b("Not all required fields were included: key_buf");
                AppMethodBeat.o(80150);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wKs != null) {
                    aVar.iy(2, this.wKs.computeSize());
                    this.wKs.writeFields(aVar);
                }
                aVar.iz(3, this.wKt);
                if (this.wKr != null) {
                    aVar.iy(4, this.wKr.computeSize());
                    this.wKr.writeFields(aVar);
                }
                AppMethodBeat.o(80150);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wKs != null) {
                ix += e.a.a.a.ix(2, this.wKs.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.wKt);
            if (this.wKr != null) {
                ix += e.a.a.a.ix(4, this.wKr.computeSize());
            }
            AppMethodBeat.o(80150);
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
                AppMethodBeat.o(80150);
                throw bVar;
            } else if (this.wKs == null) {
                bVar = new b("Not all required fields were included: cmd_list");
                AppMethodBeat.o(80150);
                throw bVar;
            } else if (this.wKr == null) {
                bVar = new b("Not all required fields were included: key_buf");
                AppMethodBeat.o(80150);
                throw bVar;
            } else {
                AppMethodBeat.o(80150);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgz bgz = (bgz) objArr[1];
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
                        bgz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80150);
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
                        bgz.wKs = tcVar;
                    }
                    AppMethodBeat.o(80150);
                    return 0;
                case 3:
                    bgz.wKt = aVar3.BTU.vd();
                    AppMethodBeat.o(80150);
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
                        bgz.wKr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80150);
                    return 0;
                default:
                    AppMethodBeat.o(80150);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80150);
            return -1;
        }
    }
}
