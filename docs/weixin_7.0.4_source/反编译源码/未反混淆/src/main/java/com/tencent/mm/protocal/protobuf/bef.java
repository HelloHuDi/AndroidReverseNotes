package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bef extends btd {
    public int fJT;
    public String pZE;
    public String pZF;
    public b wHQ;
    public float wHU;
    public LinkedList<cit> wpm = new LinkedList();

    public bef() {
        AppMethodBeat.i(81503);
        AppMethodBeat.o(81503);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(81504);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(81504);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.fJT);
            aVar.e(3, 8, this.wpm);
            if (this.wHQ != null) {
                aVar.c(4, this.wHQ);
            }
            aVar.r(5, this.wHU);
            if (this.pZE != null) {
                aVar.e(6, this.pZE);
            }
            if (this.pZF != null) {
                aVar.e(7, this.pZF);
            }
            AppMethodBeat.o(81504);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.fJT)) + e.a.a.a.c(3, 8, this.wpm);
            if (this.wHQ != null) {
                ix += e.a.a.b.b.a.b(4, this.wHQ);
            }
            ix += e.a.a.b.b.a.fv(5) + 4;
            if (this.pZE != null) {
                ix += e.a.a.b.b.a.f(6, this.pZE);
            }
            if (this.pZF != null) {
                ix += e.a.a.b.b.a.f(7, this.pZF);
            }
            AppMethodBeat.o(81504);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(81504);
                throw bVar;
            }
            AppMethodBeat.o(81504);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bef bef = (bef) objArr[1];
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
                        bef.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(81504);
                    return 0;
                case 2:
                    bef.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(81504);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cit cit = new cit();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cit.populateBuilderWithField(aVar4, cit, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bef.wpm.add(cit);
                    }
                    AppMethodBeat.o(81504);
                    return 0;
                case 4:
                    bef.wHQ = aVar3.BTU.emu();
                    AppMethodBeat.o(81504);
                    return 0;
                case 5:
                    bef.wHU = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(81504);
                    return 0;
                case 6:
                    bef.pZE = aVar3.BTU.readString();
                    AppMethodBeat.o(81504);
                    return 0;
                case 7:
                    bef.pZF = aVar3.BTU.readString();
                    AppMethodBeat.o(81504);
                    return 0;
                default:
                    AppMethodBeat.o(81504);
                    return -1;
            }
        } else {
            AppMethodBeat.o(81504);
            return -1;
        }
    }
}
