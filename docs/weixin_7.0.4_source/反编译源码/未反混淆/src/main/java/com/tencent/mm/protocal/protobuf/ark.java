package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ark extends btd {
    public int status;
    public cwg vXT;
    public LinkedList<cwq> wvv = new LinkedList();
    public LinkedList<cwq> wvw = new LinkedList();

    public ark() {
        AppMethodBeat.i(96247);
        AppMethodBeat.o(96247);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96248);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96248);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vXT != null) {
                aVar.iy(2, this.vXT.computeSize());
                this.vXT.writeFields(aVar);
            }
            aVar.e(3, 8, this.wvv);
            aVar.e(4, 8, this.wvw);
            aVar.iz(5, this.status);
            AppMethodBeat.o(96248);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vXT != null) {
                ix += e.a.a.a.ix(2, this.vXT.computeSize());
            }
            int c = ((ix + e.a.a.a.c(3, 8, this.wvv)) + e.a.a.a.c(4, 8, this.wvw)) + e.a.a.b.b.a.bs(5, this.status);
            AppMethodBeat.o(96248);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvv.clear();
            this.wvw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96248);
                throw bVar;
            }
            AppMethodBeat.o(96248);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ark ark = (ark) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cwq cwq;
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
                        ark.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96248);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(aVar4, cwg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ark.vXT = cwg;
                    }
                    AppMethodBeat.o(96248);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwq = new cwq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwq.populateBuilderWithField(aVar4, cwq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ark.wvv.add(cwq);
                    }
                    AppMethodBeat.o(96248);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwq = new cwq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwq.populateBuilderWithField(aVar4, cwq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ark.wvw.add(cwq);
                    }
                    AppMethodBeat.o(96248);
                    return 0;
                case 5:
                    ark.status = aVar3.BTU.vd();
                    AppMethodBeat.o(96248);
                    return 0;
                default:
                    AppMethodBeat.o(96248);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96248);
            return -1;
        }
    }
}
