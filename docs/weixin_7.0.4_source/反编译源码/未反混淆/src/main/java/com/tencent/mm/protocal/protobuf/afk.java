package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afk extends btd {
    public long wmO;
    public b wmP;
    public bdv wmQ;
    public jv wmR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(846);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(846);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.ai(2, this.wmO);
            if (this.wmP != null) {
                aVar.c(3, this.wmP);
            }
            if (this.wmQ != null) {
                aVar.iy(4, this.wmQ.computeSize());
                this.wmQ.writeFields(aVar);
            }
            if (this.wmR != null) {
                aVar.iy(5, this.wmR.computeSize());
                this.wmR.writeFields(aVar);
            }
            AppMethodBeat.o(846);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.o(2, this.wmO);
            if (this.wmP != null) {
                ix += e.a.a.b.b.a.b(3, this.wmP);
            }
            if (this.wmQ != null) {
                ix += e.a.a.a.ix(4, this.wmQ.computeSize());
            }
            if (this.wmR != null) {
                ix += e.a.a.a.ix(5, this.wmR.computeSize());
            }
            AppMethodBeat.o(846);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(846);
                throw bVar;
            }
            AppMethodBeat.o(846);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afk afk = (afk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        afk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(846);
                    return 0;
                case 2:
                    afk.wmO = aVar3.BTU.ve();
                    AppMethodBeat.o(846);
                    return 0;
                case 3:
                    afk.wmP = aVar3.BTU.emu();
                    AppMethodBeat.o(846);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdv bdv = new bdv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdv.populateBuilderWithField(aVar4, bdv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afk.wmQ = bdv;
                    }
                    AppMethodBeat.o(846);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        jv jvVar = new jv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jvVar.populateBuilderWithField(aVar4, jvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afk.wmR = jvVar;
                    }
                    AppMethodBeat.o(846);
                    return 0;
                default:
                    AppMethodBeat.o(846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(846);
            return -1;
        }
    }
}
