package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bkl extends btd {
    public int kdT;
    public String kdU;
    public String wNA;
    public he wNB;
    public String wNC;
    public LinkedList<bkm> wNy = new LinkedList();
    public long wNz;

    public bkl() {
        AppMethodBeat.i(56919);
        AppMethodBeat.o(56919);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56920);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56920);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            aVar.e(4, 8, this.wNy);
            aVar.ai(5, this.wNz);
            if (this.wNA != null) {
                aVar.e(6, this.wNA);
            }
            if (this.wNB != null) {
                aVar.iy(7, this.wNB.computeSize());
                this.wNB.writeFields(aVar);
            }
            if (this.wNC != null) {
                aVar.e(8, this.wNC);
            }
            AppMethodBeat.o(56920);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            ix = (ix + e.a.a.a.c(4, 8, this.wNy)) + e.a.a.b.b.a.o(5, this.wNz);
            if (this.wNA != null) {
                ix += e.a.a.b.b.a.f(6, this.wNA);
            }
            if (this.wNB != null) {
                ix += e.a.a.a.ix(7, this.wNB.computeSize());
            }
            if (this.wNC != null) {
                ix += e.a.a.b.b.a.f(8, this.wNC);
            }
            AppMethodBeat.o(56920);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wNy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56920);
                throw bVar;
            }
            AppMethodBeat.o(56920);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkl bkl = (bkl) objArr[1];
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
                        bkl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56920);
                    return 0;
                case 2:
                    bkl.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56920);
                    return 0;
                case 3:
                    bkl.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56920);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkm bkm = new bkm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkm.populateBuilderWithField(aVar4, bkm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkl.wNy.add(bkm);
                    }
                    AppMethodBeat.o(56920);
                    return 0;
                case 5:
                    bkl.wNz = aVar3.BTU.ve();
                    AppMethodBeat.o(56920);
                    return 0;
                case 6:
                    bkl.wNA = aVar3.BTU.readString();
                    AppMethodBeat.o(56920);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        he heVar = new he();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = heVar.populateBuilderWithField(aVar4, heVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkl.wNB = heVar;
                    }
                    AppMethodBeat.o(56920);
                    return 0;
                case 8:
                    bkl.wNC = aVar3.BTU.readString();
                    AppMethodBeat.o(56920);
                    return 0;
                default:
                    AppMethodBeat.o(56920);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56920);
            return -1;
        }
    }
}
