package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akq extends btd {
    public int jBv;
    public LinkedList<azd> ndm = new LinkedList();
    public String wdO;

    public akq() {
        AppMethodBeat.i(73709);
        AppMethodBeat.o(73709);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73710);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73710);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.ndm);
            if (this.wdO != null) {
                aVar.e(4, this.wdO);
            }
            AppMethodBeat.o(73710);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.ndm);
            if (this.wdO != null) {
                ix += e.a.a.b.b.a.f(4, this.wdO);
            }
            AppMethodBeat.o(73710);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73710);
                throw bVar;
            }
            AppMethodBeat.o(73710);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akq akq = (akq) objArr[1];
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
                        akq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73710);
                    return 0;
                case 2:
                    akq.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(73710);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azd azd = new azd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azd.populateBuilderWithField(aVar4, azd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akq.ndm.add(azd);
                    }
                    AppMethodBeat.o(73710);
                    return 0;
                case 4:
                    akq.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(73710);
                    return 0;
                default:
                    AppMethodBeat.o(73710);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73710);
            return -1;
        }
    }
}
