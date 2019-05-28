package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buo extends btd {
    public String fhH;
    public String vGi;
    public LinkedList<bew> wIK = new LinkedList();
    public String wIL;
    public boolean wIM;
    public boolean wIN;
    public boolean wIO;
    public LinkedList<bet> wPQ = new LinkedList();
    public boolean wPR;
    public int wPS;
    public int wPT;
    public String wPU;
    public String wPV;
    public boolean wWf;

    public buo() {
        AppMethodBeat.i(10238);
        AppMethodBeat.o(10238);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10239);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10239);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(3, 8, this.wIK);
            if (this.fhH != null) {
                aVar.e(4, this.fhH);
            }
            if (this.wIL != null) {
                aVar.e(5, this.wIL);
            }
            if (this.vGi != null) {
                aVar.e(6, this.vGi);
            }
            aVar.aO(8, this.wIM);
            aVar.aO(9, this.wIN);
            aVar.aO(10, this.wIO);
            aVar.e(11, 8, this.wPQ);
            aVar.aO(12, this.wWf);
            aVar.aO(13, this.wPR);
            aVar.iz(14, this.wPS);
            aVar.iz(15, this.wPT);
            if (this.wPU != null) {
                aVar.e(16, this.wPU);
            }
            if (this.wPV != null) {
                aVar.e(17, this.wPV);
            }
            AppMethodBeat.o(10239);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(3, 8, this.wIK);
            if (this.fhH != null) {
                ix += e.a.a.b.b.a.f(4, this.fhH);
            }
            if (this.wIL != null) {
                ix += e.a.a.b.b.a.f(5, this.wIL);
            }
            if (this.vGi != null) {
                ix += e.a.a.b.b.a.f(6, this.vGi);
            }
            ix = (((((((ix + (e.a.a.b.b.a.fv(8) + 1)) + (e.a.a.b.b.a.fv(9) + 1)) + (e.a.a.b.b.a.fv(10) + 1)) + e.a.a.a.c(11, 8, this.wPQ)) + (e.a.a.b.b.a.fv(12) + 1)) + (e.a.a.b.b.a.fv(13) + 1)) + e.a.a.b.b.a.bs(14, this.wPS)) + e.a.a.b.b.a.bs(15, this.wPT);
            if (this.wPU != null) {
                ix += e.a.a.b.b.a.f(16, this.wPU);
            }
            if (this.wPV != null) {
                ix += e.a.a.b.b.a.f(17, this.wPV);
            }
            AppMethodBeat.o(10239);
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
                AppMethodBeat.o(10239);
                throw bVar;
            }
            AppMethodBeat.o(10239);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buo buo = (buo) objArr[1];
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
                        buo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10239);
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
                        buo.wIK.add(bew);
                    }
                    AppMethodBeat.o(10239);
                    return 0;
                case 4:
                    buo.fhH = aVar3.BTU.readString();
                    AppMethodBeat.o(10239);
                    return 0;
                case 5:
                    buo.wIL = aVar3.BTU.readString();
                    AppMethodBeat.o(10239);
                    return 0;
                case 6:
                    buo.vGi = aVar3.BTU.readString();
                    AppMethodBeat.o(10239);
                    return 0;
                case 8:
                    buo.wIM = aVar3.BTU.ehX();
                    AppMethodBeat.o(10239);
                    return 0;
                case 9:
                    buo.wIN = aVar3.BTU.ehX();
                    AppMethodBeat.o(10239);
                    return 0;
                case 10:
                    buo.wIO = aVar3.BTU.ehX();
                    AppMethodBeat.o(10239);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bet bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.populateBuilderWithField(aVar4, bet, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buo.wPQ.add(bet);
                    }
                    AppMethodBeat.o(10239);
                    return 0;
                case 12:
                    buo.wWf = aVar3.BTU.ehX();
                    AppMethodBeat.o(10239);
                    return 0;
                case 13:
                    buo.wPR = aVar3.BTU.ehX();
                    AppMethodBeat.o(10239);
                    return 0;
                case 14:
                    buo.wPS = aVar3.BTU.vd();
                    AppMethodBeat.o(10239);
                    return 0;
                case 15:
                    buo.wPT = aVar3.BTU.vd();
                    AppMethodBeat.o(10239);
                    return 0;
                case 16:
                    buo.wPU = aVar3.BTU.readString();
                    AppMethodBeat.o(10239);
                    return 0;
                case 17:
                    buo.wPV = aVar3.BTU.readString();
                    AppMethodBeat.o(10239);
                    return 0;
                default:
                    AppMethodBeat.o(10239);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10239);
            return -1;
        }
    }
}
