package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajk extends btd {
    public String jBB;
    public int ptw;
    public int ptx;
    public SKBuiltinBuffer_t ptz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80074);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80074);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(80074);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.jBB != null) {
                    aVar.e(2, this.jBB);
                }
                aVar.iz(3, this.ptw);
                aVar.iz(4, this.ptx);
                if (this.ptz != null) {
                    aVar.iy(5, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                AppMethodBeat.o(80074);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(2, this.jBB);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.ptw)) + e.a.a.b.b.a.bs(4, this.ptx);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(5, this.ptz.computeSize());
            }
            AppMethodBeat.o(80074);
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
                AppMethodBeat.o(80074);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(80074);
                throw bVar;
            } else {
                AppMethodBeat.o(80074);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajk ajk = (ajk) objArr[1];
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
                        ajk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80074);
                    return 0;
                case 2:
                    ajk.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(80074);
                    return 0;
                case 3:
                    ajk.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80074);
                    return 0;
                case 4:
                    ajk.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80074);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajk.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80074);
                    return 0;
                default:
                    AppMethodBeat.o(80074);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80074);
            return -1;
        }
    }
}
