package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anb extends btd {
    public int wrF;
    public SKBuiltinBuffer_t wrG;
    public String wrH;
    public String wrI;
    public String wrJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80096);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80096);
                throw bVar;
            } else if (this.wrG == null) {
                bVar = new b("Not all required fields were included: QRCode");
                AppMethodBeat.o(80096);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wrG != null) {
                    aVar.iy(2, this.wrG.computeSize());
                    this.wrG.writeFields(aVar);
                }
                aVar.iz(5, this.wrF);
                if (this.wrH != null) {
                    aVar.e(6, this.wrH);
                }
                if (this.wrI != null) {
                    aVar.e(7, this.wrI);
                }
                if (this.wrJ != null) {
                    aVar.e(8, this.wrJ);
                }
                AppMethodBeat.o(80096);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wrG != null) {
                ix += e.a.a.a.ix(2, this.wrG.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.wrF);
            if (this.wrH != null) {
                ix += e.a.a.b.b.a.f(6, this.wrH);
            }
            if (this.wrI != null) {
                ix += e.a.a.b.b.a.f(7, this.wrI);
            }
            if (this.wrJ != null) {
                ix += e.a.a.b.b.a.f(8, this.wrJ);
            }
            AppMethodBeat.o(80096);
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
                AppMethodBeat.o(80096);
                throw bVar;
            } else if (this.wrG == null) {
                bVar = new b("Not all required fields were included: QRCode");
                AppMethodBeat.o(80096);
                throw bVar;
            } else {
                AppMethodBeat.o(80096);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anb anb = (anb) objArr[1];
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
                        anb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80096);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anb.wrG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80096);
                    return 0;
                case 5:
                    anb.wrF = aVar3.BTU.vd();
                    AppMethodBeat.o(80096);
                    return 0;
                case 6:
                    anb.wrH = aVar3.BTU.readString();
                    AppMethodBeat.o(80096);
                    return 0;
                case 7:
                    anb.wrI = aVar3.BTU.readString();
                    AppMethodBeat.o(80096);
                    return 0;
                case 8:
                    anb.wrJ = aVar3.BTU.readString();
                    AppMethodBeat.o(80096);
                    return 0;
                default:
                    AppMethodBeat.o(80096);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80096);
            return -1;
        }
    }
}
