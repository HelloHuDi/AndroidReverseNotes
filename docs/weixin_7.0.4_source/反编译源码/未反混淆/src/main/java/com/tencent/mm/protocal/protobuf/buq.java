package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buq extends btd {
    public String vKK;
    public bbv vKL;
    public asq vLi;
    public asr vLj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28623);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28623);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vLi != null) {
                aVar.iy(2, this.vLi.computeSize());
                this.vLi.writeFields(aVar);
            }
            if (this.vLj != null) {
                aVar.iy(3, this.vLj.computeSize());
                this.vLj.writeFields(aVar);
            }
            if (this.vKK != null) {
                aVar.e(4, this.vKK);
            }
            if (this.vKL != null) {
                aVar.iy(5, this.vKL.computeSize());
                this.vKL.writeFields(aVar);
            }
            AppMethodBeat.o(28623);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLi != null) {
                ix += e.a.a.a.ix(2, this.vLi.computeSize());
            }
            if (this.vLj != null) {
                ix += e.a.a.a.ix(3, this.vLj.computeSize());
            }
            if (this.vKK != null) {
                ix += e.a.a.b.b.a.f(4, this.vKK);
            }
            if (this.vKL != null) {
                ix += e.a.a.a.ix(5, this.vKL.computeSize());
            }
            AppMethodBeat.o(28623);
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
                AppMethodBeat.o(28623);
                throw bVar;
            }
            AppMethodBeat.o(28623);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buq buq = (buq) objArr[1];
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
                        buq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28623);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asq.populateBuilderWithField(aVar4, asq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buq.vLi = asq;
                    }
                    AppMethodBeat.o(28623);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asr asr = new asr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asr.populateBuilderWithField(aVar4, asr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buq.vLj = asr;
                    }
                    AppMethodBeat.o(28623);
                    return 0;
                case 4:
                    buq.vKK = aVar3.BTU.readString();
                    AppMethodBeat.o(28623);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbv bbv = new bbv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbv.populateBuilderWithField(aVar4, bbv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buq.vKL = bbv;
                    }
                    AppMethodBeat.o(28623);
                    return 0;
                default:
                    AppMethodBeat.o(28623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28623);
            return -1;
        }
    }
}
