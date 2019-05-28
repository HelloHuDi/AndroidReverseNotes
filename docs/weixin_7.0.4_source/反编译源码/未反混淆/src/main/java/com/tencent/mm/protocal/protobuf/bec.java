package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bec extends btd {
    public int vBm;
    public int vQe;
    public SKBuiltinBuffer_t wHH;
    public SKBuiltinBuffer_t wHI;
    public int wHJ;
    public int wHK;
    public LinkedList<tb> wHL = new LinkedList();

    public bec() {
        AppMethodBeat.i(58918);
        AppMethodBeat.o(58918);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58919);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(58919);
                throw bVar;
            } else if (this.wHH == null) {
                bVar = new b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.o(58919);
                throw bVar;
            } else if (this.wHI == null) {
                bVar = new b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.o(58919);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wHH != null) {
                    aVar.iy(2, this.wHH.computeSize());
                    this.wHH.writeFields(aVar);
                }
                if (this.wHI != null) {
                    aVar.iy(3, this.wHI.computeSize());
                    this.wHI.writeFields(aVar);
                }
                aVar.iz(4, this.vQe);
                aVar.iz(5, this.wHJ);
                aVar.iz(6, this.wHK);
                aVar.e(7, 8, this.wHL);
                aVar.iz(8, this.vBm);
                AppMethodBeat.o(58919);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wHH != null) {
                ix += e.a.a.a.ix(2, this.wHH.computeSize());
            }
            if (this.wHI != null) {
                ix += e.a.a.a.ix(3, this.wHI.computeSize());
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(4, this.vQe)) + e.a.a.b.b.a.bs(5, this.wHJ)) + e.a.a.b.b.a.bs(6, this.wHK)) + e.a.a.a.c(7, 8, this.wHL)) + e.a.a.b.b.a.bs(8, this.vBm);
            AppMethodBeat.o(58919);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wHL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(58919);
                throw bVar;
            } else if (this.wHH == null) {
                bVar = new b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.o(58919);
                throw bVar;
            } else if (this.wHI == null) {
                bVar = new b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.o(58919);
                throw bVar;
            } else {
                AppMethodBeat.o(58919);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bec bec = (bec) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        bec.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(58919);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bec.wHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58919);
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
                        bec.wHI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58919);
                    return 0;
                case 4:
                    bec.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(58919);
                    return 0;
                case 5:
                    bec.wHJ = aVar3.BTU.vd();
                    AppMethodBeat.o(58919);
                    return 0;
                case 6:
                    bec.wHK = aVar3.BTU.vd();
                    AppMethodBeat.o(58919);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tb tbVar = new tb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tbVar.populateBuilderWithField(aVar4, tbVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bec.wHL.add(tbVar);
                    }
                    AppMethodBeat.o(58919);
                    return 0;
                case 8:
                    bec.vBm = aVar3.BTU.vd();
                    AppMethodBeat.o(58919);
                    return 0;
                default:
                    AppMethodBeat.o(58919);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58919);
            return -1;
        }
    }
}
