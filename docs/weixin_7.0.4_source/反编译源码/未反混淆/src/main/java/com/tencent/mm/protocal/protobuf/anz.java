package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anz extends btd {
    public boolean vKO;
    public LinkedList<bxi> vKP = new LinkedList();
    public boolean wsw;
    public LinkedList<bxi> wsx = new LinkedList();

    public anz() {
        AppMethodBeat.i(114968);
        AppMethodBeat.o(114968);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114969);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114969);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aO(2, this.vKO);
            aVar.e(3, 8, this.vKP);
            aVar.aO(4, this.wsw);
            aVar.e(5, 8, this.wsx);
            AppMethodBeat.o(114969);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int fv = (((ix + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.a.c(3, 8, this.vKP)) + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.a.c(5, 8, this.wsx);
            AppMethodBeat.o(114969);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKP.clear();
            this.wsx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114969);
                throw bVar;
            }
            AppMethodBeat.o(114969);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anz anz = (anz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bxi bxi;
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
                        anz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114969);
                    return 0;
                case 2:
                    anz.vKO = aVar3.BTU.ehX();
                    AppMethodBeat.o(114969);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxi = new bxi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxi.populateBuilderWithField(aVar4, bxi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anz.vKP.add(bxi);
                    }
                    AppMethodBeat.o(114969);
                    return 0;
                case 4:
                    anz.wsw = aVar3.BTU.ehX();
                    AppMethodBeat.o(114969);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxi = new bxi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxi.populateBuilderWithField(aVar4, bxi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anz.wsx.add(bxi);
                    }
                    AppMethodBeat.o(114969);
                    return 0;
                default:
                    AppMethodBeat.o(114969);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114969);
            return -1;
        }
    }
}
