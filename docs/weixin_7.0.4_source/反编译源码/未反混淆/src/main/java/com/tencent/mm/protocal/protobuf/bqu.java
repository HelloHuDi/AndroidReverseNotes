package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqu extends btd {
    public int jBv;
    public String vKq;
    public int wBg;
    public LinkedList<cmj> wTh = new LinkedList();
    public cie wTi;

    public bqu() {
        AppMethodBeat.i(113790);
        AppMethodBeat.o(113790);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113791);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(113791);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.wTh);
            if (this.vKq != null) {
                aVar.e(4, this.vKq);
            }
            aVar.iz(5, this.wBg);
            if (this.wTi != null) {
                aVar.iy(6, this.wTi.computeSize());
                this.wTi.writeFields(aVar);
            }
            AppMethodBeat.o(113791);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.wTh);
            if (this.vKq != null) {
                ix += e.a.a.b.b.a.f(4, this.vKq);
            }
            ix += e.a.a.b.b.a.bs(5, this.wBg);
            if (this.wTi != null) {
                ix += e.a.a.a.ix(6, this.wTi.computeSize());
            }
            AppMethodBeat.o(113791);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wTh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(113791);
                throw bVar;
            }
            AppMethodBeat.o(113791);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqu bqu = (bqu) objArr[1];
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
                        bqu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(113791);
                    return 0;
                case 2:
                    bqu.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(113791);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmj cmj = new cmj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmj.populateBuilderWithField(aVar4, cmj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqu.wTh.add(cmj);
                    }
                    AppMethodBeat.o(113791);
                    return 0;
                case 4:
                    bqu.vKq = aVar3.BTU.readString();
                    AppMethodBeat.o(113791);
                    return 0;
                case 5:
                    bqu.wBg = aVar3.BTU.vd();
                    AppMethodBeat.o(113791);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cie cie = new cie();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cie.populateBuilderWithField(aVar4, cie, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqu.wTi = cie;
                    }
                    AppMethodBeat.o(113791);
                    return 0;
                default:
                    AppMethodBeat.o(113791);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113791);
            return -1;
        }
    }
}
