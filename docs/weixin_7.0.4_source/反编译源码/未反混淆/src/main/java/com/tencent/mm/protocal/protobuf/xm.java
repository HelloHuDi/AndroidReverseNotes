package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xm extends btd {
    public int ptD;
    public long ptF;
    public int ptw;
    public int ptx;
    public SKBuiltinBuffer_t ptz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(50999);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50999);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(50999);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.ptD);
                aVar.iz(3, this.ptw);
                aVar.iz(4, this.ptx);
                if (this.ptz != null) {
                    aVar.iy(5, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                aVar.ai(6, this.ptF);
                AppMethodBeat.o(50999);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.ptD)) + e.a.a.b.b.a.bs(3, this.ptw)) + e.a.a.b.b.a.bs(4, this.ptx);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(5, this.ptz.computeSize());
            }
            int o = ix + e.a.a.b.b.a.o(6, this.ptF);
            AppMethodBeat.o(50999);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50999);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(50999);
                throw bVar;
            } else {
                AppMethodBeat.o(50999);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xm xmVar = (xm) objArr[1];
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
                        xmVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(50999);
                    return 0;
                case 2:
                    xmVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(50999);
                    return 0;
                case 3:
                    xmVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(50999);
                    return 0;
                case 4:
                    xmVar.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(50999);
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
                        xmVar.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(50999);
                    return 0;
                case 6:
                    xmVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(50999);
                    return 0;
                default:
                    AppMethodBeat.o(50999);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50999);
            return -1;
        }
    }
}
