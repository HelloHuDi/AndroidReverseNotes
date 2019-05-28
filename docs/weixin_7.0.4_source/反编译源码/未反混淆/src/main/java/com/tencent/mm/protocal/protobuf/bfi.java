package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfi extends btd {
    public int kdT;
    public String kdU;
    public String tgu;
    public azb wJa;
    public int wJb;
    public int wJc;
    public int wJd;
    public LinkedList<xg> wJe = new LinkedList();
    public LinkedList<bqr> wJf = new LinkedList();
    public LinkedList<hc> wJg = new LinkedList();

    public bfi() {
        AppMethodBeat.i(56869);
        AppMethodBeat.o(56869);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56870);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56870);
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
            aVar.iz(4, this.wJb);
            aVar.iz(5, this.wJc);
            aVar.iz(6, this.wJd);
            aVar.e(8, 8, this.wJe);
            if (this.wJa != null) {
                aVar.iy(9, this.wJa.computeSize());
                this.wJa.writeFields(aVar);
            }
            aVar.e(10, 8, this.wJf);
            aVar.e(11, 8, this.wJg);
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56870);
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
            ix = (((ix + e.a.a.b.b.a.bs(4, this.wJb)) + e.a.a.b.b.a.bs(5, this.wJc)) + e.a.a.b.b.a.bs(6, this.wJd)) + e.a.a.a.c(8, 8, this.wJe);
            if (this.wJa != null) {
                ix += e.a.a.a.ix(9, this.wJa.computeSize());
            }
            ix = (ix + e.a.a.a.c(10, 8, this.wJf)) + e.a.a.a.c(11, 8, this.wJg);
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56870);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wJe.clear();
            this.wJf.clear();
            this.wJg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56870);
                throw bVar;
            }
            AppMethodBeat.o(56870);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfi bfi = (bfi) objArr[1];
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
                        bfi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56870);
                    return 0;
                case 2:
                    bfi.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56870);
                    return 0;
                case 3:
                    bfi.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56870);
                    return 0;
                case 4:
                    bfi.wJb = aVar3.BTU.vd();
                    AppMethodBeat.o(56870);
                    return 0;
                case 5:
                    bfi.wJc = aVar3.BTU.vd();
                    AppMethodBeat.o(56870);
                    return 0;
                case 6:
                    bfi.wJd = aVar3.BTU.vd();
                    AppMethodBeat.o(56870);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xg xgVar = new xg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xgVar.populateBuilderWithField(aVar4, xgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfi.wJe.add(xgVar);
                    }
                    AppMethodBeat.o(56870);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azb azb = new azb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azb.populateBuilderWithField(aVar4, azb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfi.wJa = azb;
                    }
                    AppMethodBeat.o(56870);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqr bqr = new bqr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqr.populateBuilderWithField(aVar4, bqr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfi.wJf.add(bqr);
                    }
                    AppMethodBeat.o(56870);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hc hcVar = new hc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hcVar.populateBuilderWithField(aVar4, hcVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfi.wJg.add(hcVar);
                    }
                    AppMethodBeat.o(56870);
                    return 0;
                case 100:
                    bfi.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56870);
                    return 0;
                default:
                    AppMethodBeat.o(56870);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56870);
            return -1;
        }
    }
}
