package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xo extends btd {
    public int fJT;
    public int ptD;
    public long ptF;
    public SKBuiltinBuffer_t ptz;
    public String vFF;
    public int vOq;
    public int wdn;
    public int wdp;
    public int wdq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116803);
        b bVar;
        int bs;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116803);
                throw bVar;
            } else if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(116803);
                throw bVar;
            } else {
                aVar.iz(1, this.ptD);
                aVar.iz(2, this.vOq);
                aVar.iz(3, this.wdn);
                aVar.iz(5, this.wdp);
                if (this.vFF != null) {
                    aVar.e(6, this.vFF);
                }
                if (this.ptz != null) {
                    aVar.iy(7, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                aVar.iz(8, this.fJT);
                if (this.BaseResponse != null) {
                    aVar.iy(9, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(10, this.wdq);
                aVar.ai(11, this.ptF);
                AppMethodBeat.o(116803);
                return 0;
            }
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.ptD) + 0) + e.a.a.b.b.a.bs(2, this.vOq)) + e.a.a.b.b.a.bs(3, this.wdn)) + e.a.a.b.b.a.bs(5, this.wdp);
            if (this.vFF != null) {
                bs += e.a.a.b.b.a.f(6, this.vFF);
            }
            if (this.ptz != null) {
                bs += e.a.a.a.ix(7, this.ptz.computeSize());
            }
            bs += e.a.a.b.b.a.bs(8, this.fJT);
            if (this.BaseResponse != null) {
                bs += e.a.a.a.ix(9, this.BaseResponse.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(10, this.wdq)) + e.a.a.b.b.a.o(11, this.ptF);
            AppMethodBeat.o(116803);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116803);
                throw bVar;
            } else if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(116803);
                throw bVar;
            } else {
                AppMethodBeat.o(116803);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xo xoVar = (xo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    xoVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(116803);
                    return 0;
                case 2:
                    xoVar.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(116803);
                    return 0;
                case 3:
                    xoVar.wdn = aVar3.BTU.vd();
                    AppMethodBeat.o(116803);
                    return 0;
                case 5:
                    xoVar.wdp = aVar3.BTU.vd();
                    AppMethodBeat.o(116803);
                    return 0;
                case 6:
                    xoVar.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(116803);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        xoVar.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116803);
                    return 0;
                case 8:
                    xoVar.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(116803);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        xoVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(116803);
                    return 0;
                case 10:
                    xoVar.wdq = aVar3.BTU.vd();
                    AppMethodBeat.o(116803);
                    return 0;
                case 11:
                    xoVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(116803);
                    return 0;
                default:
                    AppMethodBeat.o(116803);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116803);
            return -1;
        }
    }
}
