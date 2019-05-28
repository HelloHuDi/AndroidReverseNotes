package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bji extends btd {
    public int luT;
    public String luU;
    public bjj wME;
    public bix wMF;
    public LinkedList<biw> wMG = new LinkedList();
    public int wMH;

    public bji() {
        AppMethodBeat.i(56896);
        AppMethodBeat.o(56896);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56897);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56897);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.luT);
            if (this.luU != null) {
                aVar.e(3, this.luU);
            }
            if (this.wME != null) {
                aVar.iy(4, this.wME.computeSize());
                this.wME.writeFields(aVar);
            }
            if (this.wMF != null) {
                aVar.iy(5, this.wMF.computeSize());
                this.wMF.writeFields(aVar);
            }
            aVar.e(6, 8, this.wMG);
            aVar.iz(7, this.wMH);
            AppMethodBeat.o(56897);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.luT);
            if (this.luU != null) {
                ix += e.a.a.b.b.a.f(3, this.luU);
            }
            if (this.wME != null) {
                ix += e.a.a.a.ix(4, this.wME.computeSize());
            }
            if (this.wMF != null) {
                ix += e.a.a.a.ix(5, this.wMF.computeSize());
            }
            int c = (ix + e.a.a.a.c(6, 8, this.wMG)) + e.a.a.b.b.a.bs(7, this.wMH);
            AppMethodBeat.o(56897);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56897);
                throw bVar;
            }
            AppMethodBeat.o(56897);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bji bji = (bji) objArr[1];
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
                        bji.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56897);
                    return 0;
                case 2:
                    bji.luT = aVar3.BTU.vd();
                    AppMethodBeat.o(56897);
                    return 0;
                case 3:
                    bji.luU = aVar3.BTU.readString();
                    AppMethodBeat.o(56897);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bjj bjj = new bjj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bjj.populateBuilderWithField(aVar4, bjj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bji.wME = bjj;
                    }
                    AppMethodBeat.o(56897);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bix bix = new bix();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bix.populateBuilderWithField(aVar4, bix, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bji.wMF = bix;
                    }
                    AppMethodBeat.o(56897);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        biw biw = new biw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = biw.populateBuilderWithField(aVar4, biw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bji.wMG.add(biw);
                    }
                    AppMethodBeat.o(56897);
                    return 0;
                case 7:
                    bji.wMH = aVar3.BTU.vd();
                    AppMethodBeat.o(56897);
                    return 0;
                default:
                    AppMethodBeat.o(56897);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56897);
            return -1;
        }
    }
}
