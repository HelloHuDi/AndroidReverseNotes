package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buz extends btd {
    public String wWr;
    public SKBuiltinBuffer_t wok;
    public long won;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62580);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62580);
                throw bVar;
            } else if (this.wWr == null) {
                bVar = new b("Not all required fields were included: SearchResult");
                AppMethodBeat.o(62580);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wWr != null) {
                    aVar.e(2, this.wWr);
                }
                if (this.wok != null) {
                    aVar.iy(3, this.wok.computeSize());
                    this.wok.writeFields(aVar);
                }
                aVar.ai(4, this.won);
                AppMethodBeat.o(62580);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wWr != null) {
                ix += e.a.a.b.b.a.f(2, this.wWr);
            }
            if (this.wok != null) {
                ix += e.a.a.a.ix(3, this.wok.computeSize());
            }
            int o = ix + e.a.a.b.b.a.o(4, this.won);
            AppMethodBeat.o(62580);
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
                AppMethodBeat.o(62580);
                throw bVar;
            } else if (this.wWr == null) {
                bVar = new b("Not all required fields were included: SearchResult");
                AppMethodBeat.o(62580);
                throw bVar;
            } else {
                AppMethodBeat.o(62580);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buz buz = (buz) objArr[1];
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
                        buz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62580);
                    return 0;
                case 2:
                    buz.wWr = aVar3.BTU.readString();
                    AppMethodBeat.o(62580);
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
                        buz.wok = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62580);
                    return 0;
                case 4:
                    buz.won = aVar3.BTU.ve();
                    AppMethodBeat.o(62580);
                    return 0;
                default:
                    AppMethodBeat.o(62580);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62580);
            return -1;
        }
    }
}
