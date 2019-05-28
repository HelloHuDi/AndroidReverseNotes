package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aot extends btd {
    public LinkedList<bg> ncU = new LinkedList();
    public LinkedList<aro> ncz = new LinkedList();
    public int wsR;
    public LinkedList<bpe> wsS = new LinkedList();
    public int wsT;
    public int wsU;
    public int wsV;
    public arn wsW;

    public aot() {
        AppMethodBeat.i(80099);
        AppMethodBeat.o(80099);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80100);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80100);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wsR);
            aVar.e(3, 8, this.wsS);
            aVar.iz(4, this.wsT);
            aVar.iz(5, this.wsU);
            aVar.e(6, 8, this.ncU);
            aVar.iz(7, this.wsV);
            aVar.e(8, 8, this.ncz);
            if (this.wsW != null) {
                aVar.iy(9, this.wsW.computeSize());
                this.wsW.writeFields(aVar);
            }
            AppMethodBeat.o(80100);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + e.a.a.b.b.a.bs(2, this.wsR)) + e.a.a.a.c(3, 8, this.wsS)) + e.a.a.b.b.a.bs(4, this.wsT)) + e.a.a.b.b.a.bs(5, this.wsU)) + e.a.a.a.c(6, 8, this.ncU)) + e.a.a.b.b.a.bs(7, this.wsV)) + e.a.a.a.c(8, 8, this.ncz);
            if (this.wsW != null) {
                ix += e.a.a.a.ix(9, this.wsW.computeSize());
            }
            AppMethodBeat.o(80100);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsS.clear();
            this.ncU.clear();
            this.ncz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80100);
                throw bVar;
            }
            AppMethodBeat.o(80100);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aot aot = (aot) objArr[1];
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
                        aot.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80100);
                    return 0;
                case 2:
                    aot.wsR = aVar3.BTU.vd();
                    AppMethodBeat.o(80100);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpe bpe = new bpe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpe.populateBuilderWithField(aVar4, bpe, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aot.wsS.add(bpe);
                    }
                    AppMethodBeat.o(80100);
                    return 0;
                case 4:
                    aot.wsT = aVar3.BTU.vd();
                    AppMethodBeat.o(80100);
                    return 0;
                case 5:
                    aot.wsU = aVar3.BTU.vd();
                    AppMethodBeat.o(80100);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bg bgVar = new bg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgVar.populateBuilderWithField(aVar4, bgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aot.ncU.add(bgVar);
                    }
                    AppMethodBeat.o(80100);
                    return 0;
                case 7:
                    aot.wsV = aVar3.BTU.vd();
                    AppMethodBeat.o(80100);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aro aro = new aro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aro.populateBuilderWithField(aVar4, aro, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aot.ncz.add(aro);
                    }
                    AppMethodBeat.o(80100);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        arn arn = new arn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arn.populateBuilderWithField(aVar4, arn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aot.wsW = arn;
                    }
                    AppMethodBeat.o(80100);
                    return 0;
                default:
                    AppMethodBeat.o(80100);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80100);
            return -1;
        }
    }
}
