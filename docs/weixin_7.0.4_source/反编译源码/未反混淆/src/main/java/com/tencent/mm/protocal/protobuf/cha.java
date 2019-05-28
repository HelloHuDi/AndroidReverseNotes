package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cha extends btd {
    public LinkedList<eu> vGJ = new LinkedList();
    public int xfU = 180;

    public cha() {
        AppMethodBeat.i(11813);
        AppMethodBeat.o(11813);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11814);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(11814);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.vGJ);
            aVar.iz(3, this.xfU);
            AppMethodBeat.o(11814);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + e.a.a.a.c(2, 8, this.vGJ)) + e.a.a.b.b.a.bs(3, this.xfU);
            AppMethodBeat.o(11814);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vGJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(11814);
                throw bVar;
            }
            AppMethodBeat.o(11814);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cha cha = (cha) objArr[1];
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
                        cha.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(11814);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        eu euVar = new eu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = euVar.populateBuilderWithField(aVar4, euVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cha.vGJ.add(euVar);
                    }
                    AppMethodBeat.o(11814);
                    return 0;
                case 3:
                    cha.xfU = aVar3.BTU.vd();
                    AppMethodBeat.o(11814);
                    return 0;
                default:
                    AppMethodBeat.o(11814);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11814);
            return -1;
        }
    }
}
