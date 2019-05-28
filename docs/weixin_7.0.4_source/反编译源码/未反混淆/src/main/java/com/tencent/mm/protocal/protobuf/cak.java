package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cak extends btd {
    public cbt wSf;
    public SKBuiltinBuffer_t wZA;
    public cy wZB;
    public SKBuiltinBuffer_t wZw;
    public cai wZz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94560);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94560);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wZz != null) {
                aVar.iy(2, this.wZz.computeSize());
                this.wZz.writeFields(aVar);
            }
            if (this.wZw != null) {
                aVar.iy(3, this.wZw.computeSize());
                this.wZw.writeFields(aVar);
            }
            if (this.wSf != null) {
                aVar.iy(4, this.wSf.computeSize());
                this.wSf.writeFields(aVar);
            }
            if (this.wZA != null) {
                aVar.iy(5, this.wZA.computeSize());
                this.wZA.writeFields(aVar);
            }
            if (this.wZB != null) {
                aVar.iy(6, this.wZB.computeSize());
                this.wZB.writeFields(aVar);
            }
            AppMethodBeat.o(94560);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZz != null) {
                ix += e.a.a.a.ix(2, this.wZz.computeSize());
            }
            if (this.wZw != null) {
                ix += e.a.a.a.ix(3, this.wZw.computeSize());
            }
            if (this.wSf != null) {
                ix += e.a.a.a.ix(4, this.wSf.computeSize());
            }
            if (this.wZA != null) {
                ix += e.a.a.a.ix(5, this.wZA.computeSize());
            }
            if (this.wZB != null) {
                ix += e.a.a.a.ix(6, this.wZB.computeSize());
            }
            AppMethodBeat.o(94560);
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
                AppMethodBeat.o(94560);
                throw bVar;
            }
            AppMethodBeat.o(94560);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cak cak = (cak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        cak.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94560);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cai cai = new cai();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cai.populateBuilderWithField(aVar4, cai, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cak.wZz = cai;
                    }
                    AppMethodBeat.o(94560);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cak.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94560);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbt cbt = new cbt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbt.populateBuilderWithField(aVar4, cbt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cak.wSf = cbt;
                    }
                    AppMethodBeat.o(94560);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cak.wZA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94560);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cy cyVar = new cy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyVar.populateBuilderWithField(aVar4, cyVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cak.wZB = cyVar;
                    }
                    AppMethodBeat.o(94560);
                    return 0;
                default:
                    AppMethodBeat.o(94560);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94560);
            return -1;
        }
    }
}
