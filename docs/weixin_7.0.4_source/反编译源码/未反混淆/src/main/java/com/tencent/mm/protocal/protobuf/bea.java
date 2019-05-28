package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bea extends btd {
    public LinkedList<bed> ndm = new LinkedList();
    public LinkedList<aco> vFk = new LinkedList();
    public int wHF;
    public int wHG;

    public bea() {
        AppMethodBeat.i(73742);
        AppMethodBeat.o(73742);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73743);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73743);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wHF);
            aVar.e(3, 8, this.ndm);
            aVar.iz(4, this.wHG);
            aVar.e(5, 8, this.vFk);
            AppMethodBeat.o(73743);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.wHF)) + e.a.a.a.c(3, 8, this.ndm)) + e.a.a.b.b.a.bs(4, this.wHG)) + e.a.a.a.c(5, 8, this.vFk);
            AppMethodBeat.o(73743);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndm.clear();
            this.vFk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73743);
                throw bVar;
            }
            AppMethodBeat.o(73743);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bea bea = (bea) objArr[1];
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
                        bea.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73743);
                    return 0;
                case 2:
                    bea.wHF = aVar3.BTU.vd();
                    AppMethodBeat.o(73743);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bed bed = new bed();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bed.populateBuilderWithField(aVar4, bed, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bea.ndm.add(bed);
                    }
                    AppMethodBeat.o(73743);
                    return 0;
                case 4:
                    bea.wHG = aVar3.BTU.vd();
                    AppMethodBeat.o(73743);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aco aco = new aco();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aco.populateBuilderWithField(aVar4, aco, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bea.vFk.add(aco);
                    }
                    AppMethodBeat.o(73743);
                    return 0;
                default:
                    AppMethodBeat.o(73743);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73743);
            return -1;
        }
    }
}
