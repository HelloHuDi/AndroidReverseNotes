package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aia extends btd {
    public SKBuiltinBuffer_t wok;
    public LinkedList<xx> woo = new LinkedList();
    public LinkedList<xz> wop = new LinkedList();

    public aia() {
        AppMethodBeat.i(62549);
        AppMethodBeat.o(62549);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62550);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62550);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.woo);
            if (this.wok != null) {
                aVar.iy(3, this.wok.computeSize());
                this.wok.writeFields(aVar);
            }
            aVar.e(4, 8, this.wop);
            AppMethodBeat.o(62550);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.woo);
            if (this.wok != null) {
                ix += e.a.a.a.ix(3, this.wok.computeSize());
            }
            int c = ix + e.a.a.a.c(4, 8, this.wop);
            AppMethodBeat.o(62550);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woo.clear();
            this.wop.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62550);
                throw bVar;
            }
            AppMethodBeat.o(62550);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aia aia = (aia) objArr[1];
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
                        aia.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62550);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xx xxVar = new xx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xxVar.populateBuilderWithField(aVar4, xxVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aia.woo.add(xxVar);
                    }
                    AppMethodBeat.o(62550);
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
                        aia.wok = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62550);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xz xzVar = new xz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xzVar.populateBuilderWithField(aVar4, xzVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aia.wop.add(xzVar);
                    }
                    AppMethodBeat.o(62550);
                    return 0;
                default:
                    AppMethodBeat.o(62550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62550);
            return -1;
        }
    }
}
