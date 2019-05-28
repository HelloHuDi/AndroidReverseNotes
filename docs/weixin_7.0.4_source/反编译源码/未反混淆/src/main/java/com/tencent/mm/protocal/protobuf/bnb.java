package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnb extends btd {
    public String csB;
    public String fhH;
    public LinkedList<bew> wIK = new LinkedList();
    public String wIL;
    public boolean wPP;
    public LinkedList<bet> wPQ = new LinkedList();
    public boolean wPR;
    public int wPS;
    public int wPT;
    public String wPU;
    public String wPV;

    public bnb() {
        AppMethodBeat.i(10232);
        AppMethodBeat.o(10232);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10233);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10233);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aO(2, this.wPP);
            aVar.e(3, 8, this.wIK);
            if (this.csB != null) {
                aVar.e(4, this.csB);
            }
            if (this.fhH != null) {
                aVar.e(5, this.fhH);
            }
            if (this.wIL != null) {
                aVar.e(6, this.wIL);
            }
            aVar.e(7, 8, this.wPQ);
            aVar.aO(8, this.wPR);
            aVar.iz(9, this.wPS);
            aVar.iz(10, this.wPT);
            if (this.wPU != null) {
                aVar.e(11, this.wPU);
            }
            if (this.wPV != null) {
                aVar.e(12, this.wPV);
            }
            AppMethodBeat.o(10233);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.a.c(3, 8, this.wIK);
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(4, this.csB);
            }
            if (this.fhH != null) {
                ix += e.a.a.b.b.a.f(5, this.fhH);
            }
            if (this.wIL != null) {
                ix += e.a.a.b.b.a.f(6, this.wIL);
            }
            ix = (((ix + e.a.a.a.c(7, 8, this.wPQ)) + (e.a.a.b.b.a.fv(8) + 1)) + e.a.a.b.b.a.bs(9, this.wPS)) + e.a.a.b.b.a.bs(10, this.wPT);
            if (this.wPU != null) {
                ix += e.a.a.b.b.a.f(11, this.wPU);
            }
            if (this.wPV != null) {
                ix += e.a.a.b.b.a.f(12, this.wPV);
            }
            AppMethodBeat.o(10233);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIK.clear();
            this.wPQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10233);
                throw bVar;
            }
            AppMethodBeat.o(10233);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnb bnb = (bnb) objArr[1];
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
                        bnb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10233);
                    return 0;
                case 2:
                    bnb.wPP = aVar3.BTU.ehX();
                    AppMethodBeat.o(10233);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bew bew = new bew();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bew.populateBuilderWithField(aVar4, bew, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnb.wIK.add(bew);
                    }
                    AppMethodBeat.o(10233);
                    return 0;
                case 4:
                    bnb.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(10233);
                    return 0;
                case 5:
                    bnb.fhH = aVar3.BTU.readString();
                    AppMethodBeat.o(10233);
                    return 0;
                case 6:
                    bnb.wIL = aVar3.BTU.readString();
                    AppMethodBeat.o(10233);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bet bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.populateBuilderWithField(aVar4, bet, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnb.wPQ.add(bet);
                    }
                    AppMethodBeat.o(10233);
                    return 0;
                case 8:
                    bnb.wPR = aVar3.BTU.ehX();
                    AppMethodBeat.o(10233);
                    return 0;
                case 9:
                    bnb.wPS = aVar3.BTU.vd();
                    AppMethodBeat.o(10233);
                    return 0;
                case 10:
                    bnb.wPT = aVar3.BTU.vd();
                    AppMethodBeat.o(10233);
                    return 0;
                case 11:
                    bnb.wPU = aVar3.BTU.readString();
                    AppMethodBeat.o(10233);
                    return 0;
                case 12:
                    bnb.wPV = aVar3.BTU.readString();
                    AppMethodBeat.o(10233);
                    return 0;
                default:
                    AppMethodBeat.o(10233);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10233);
            return -1;
        }
    }
}
