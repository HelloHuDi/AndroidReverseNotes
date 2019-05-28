package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cdt extends btd {
    public SKBuiltinBuffer_t xdt;
    public int xdu;
    public LinkedList<cdr> xdv = new LinkedList();
    public int xdw;

    public cdt() {
        AppMethodBeat.i(56501);
        AppMethodBeat.o(56501);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56502);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56502);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.xdu);
            aVar.e(3, 8, this.xdv);
            aVar.iz(4, this.xdw);
            if (this.xdt != null) {
                aVar.iy(5, this.xdt.computeSize());
                this.xdt.writeFields(aVar);
            }
            AppMethodBeat.o(56502);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.xdu)) + e.a.a.a.c(3, 8, this.xdv)) + e.a.a.b.b.a.bs(4, this.xdw);
            if (this.xdt != null) {
                ix += e.a.a.a.ix(5, this.xdt.computeSize());
            }
            AppMethodBeat.o(56502);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56502);
                throw bVar;
            }
            AppMethodBeat.o(56502);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdt cdt = (cdt) objArr[1];
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
                        cdt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56502);
                    return 0;
                case 2:
                    cdt.xdu = aVar3.BTU.vd();
                    AppMethodBeat.o(56502);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdr cdr = new cdr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdr.populateBuilderWithField(aVar4, cdr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdt.xdv.add(cdr);
                    }
                    AppMethodBeat.o(56502);
                    return 0;
                case 4:
                    cdt.xdw = aVar3.BTU.vd();
                    AppMethodBeat.o(56502);
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
                        cdt.xdt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56502);
                    return 0;
                default:
                    AppMethodBeat.o(56502);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56502);
            return -1;
        }
    }
}
