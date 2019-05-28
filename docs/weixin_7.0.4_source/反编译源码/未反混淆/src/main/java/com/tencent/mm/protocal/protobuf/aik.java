package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aik extends btd {
    public int jBv;
    public LinkedList<yh> jBw = new LinkedList();
    public int wov;
    public String wow;
    public int wox;

    public aik() {
        AppMethodBeat.i(62556);
        AppMethodBeat.o(62556);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62557);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62557);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.jBw);
            aVar.iz(4, this.wov);
            if (this.wow != null) {
                aVar.e(5, this.wow);
            }
            aVar.iz(6, this.wox);
            AppMethodBeat.o(62557);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.jBw)) + e.a.a.b.b.a.bs(4, this.wov);
            if (this.wow != null) {
                ix += e.a.a.b.b.a.f(5, this.wow);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.wox);
            AppMethodBeat.o(62557);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62557);
                throw bVar;
            }
            AppMethodBeat.o(62557);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aik aik = (aik) objArr[1];
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
                        aik.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62557);
                    return 0;
                case 2:
                    aik.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(62557);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        yh yhVar = new yh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = yhVar.populateBuilderWithField(aVar4, yhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aik.jBw.add(yhVar);
                    }
                    AppMethodBeat.o(62557);
                    return 0;
                case 4:
                    aik.wov = aVar3.BTU.vd();
                    AppMethodBeat.o(62557);
                    return 0;
                case 5:
                    aik.wow = aVar3.BTU.readString();
                    AppMethodBeat.o(62557);
                    return 0;
                case 6:
                    aik.wox = aVar3.BTU.vd();
                    AppMethodBeat.o(62557);
                    return 0;
                default:
                    AppMethodBeat.o(62557);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62557);
            return -1;
        }
    }
}
