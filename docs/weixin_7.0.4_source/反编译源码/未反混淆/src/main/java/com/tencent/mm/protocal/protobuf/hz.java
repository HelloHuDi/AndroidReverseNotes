package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class hz extends btd {
    public LinkedList<ef> vKx = new LinkedList();
    public LinkedList<buh> vKy = new LinkedList();

    public hz() {
        AppMethodBeat.i(14709);
        AppMethodBeat.o(14709);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14710);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14710);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.vKx);
            aVar.e(3, 8, this.vKy);
            AppMethodBeat.o(14710);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + e.a.a.a.c(2, 8, this.vKx)) + e.a.a.a.c(3, 8, this.vKy);
            AppMethodBeat.o(14710);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKx.clear();
            this.vKy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14710);
                throw bVar;
            }
            AppMethodBeat.o(14710);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hz hzVar = (hz) objArr[1];
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
                        hzVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(14710);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ef efVar = new ef();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = efVar.populateBuilderWithField(aVar4, efVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hzVar.vKx.add(efVar);
                    }
                    AppMethodBeat.o(14710);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buh buh = new buh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buh.populateBuilderWithField(aVar4, buh, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hzVar.vKy.add(buh);
                    }
                    AppMethodBeat.o(14710);
                    return 0;
                default:
                    AppMethodBeat.o(14710);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14710);
            return -1;
        }
    }
}
