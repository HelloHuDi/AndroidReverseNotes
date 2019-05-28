package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class is extends btd {
    public boolean vKO;
    public LinkedList<bxi> vKP = new LinkedList();

    public is() {
        AppMethodBeat.i(114953);
        AppMethodBeat.o(114953);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114954);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114954);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aO(2, this.vKO);
            aVar.e(3, 8, this.vKP);
            AppMethodBeat.o(114954);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int fv = (ix + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.a.c(3, 8, this.vKP);
            AppMethodBeat.o(114954);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114954);
                throw bVar;
            }
            AppMethodBeat.o(114954);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            is isVar = (is) objArr[1];
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
                        isVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114954);
                    return 0;
                case 2:
                    isVar.vKO = aVar3.BTU.ehX();
                    AppMethodBeat.o(114954);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxi bxi = new bxi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxi.populateBuilderWithField(aVar4, bxi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        isVar.vKP.add(bxi);
                    }
                    AppMethodBeat.o(114954);
                    return 0;
                default:
                    AppMethodBeat.o(114954);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114954);
            return -1;
        }
    }
}
