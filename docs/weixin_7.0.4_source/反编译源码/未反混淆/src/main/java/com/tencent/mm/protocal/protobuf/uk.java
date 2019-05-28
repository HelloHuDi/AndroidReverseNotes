package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class uk extends btd {
    public String tuB;
    public int version;
    public LinkedList<nn> wbW = new LinkedList();
    public int wbX;
    public int wbY;

    public uk() {
        AppMethodBeat.i(28373);
        AppMethodBeat.o(28373);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28374);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28374);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.wbW);
            aVar.iz(3, this.version);
            aVar.iz(4, this.wbX);
            aVar.iz(5, this.wbY);
            if (this.tuB != null) {
                aVar.e(6, this.tuB);
            }
            AppMethodBeat.o(28374);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + e.a.a.a.c(2, 8, this.wbW)) + e.a.a.b.b.a.bs(3, this.version)) + e.a.a.b.b.a.bs(4, this.wbX)) + e.a.a.b.b.a.bs(5, this.wbY);
            if (this.tuB != null) {
                ix += e.a.a.b.b.a.f(6, this.tuB);
            }
            AppMethodBeat.o(28374);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28374);
                throw bVar;
            }
            AppMethodBeat.o(28374);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uk ukVar = (uk) objArr[1];
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
                        ukVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28374);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nn nnVar = new nn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nnVar.populateBuilderWithField(aVar4, nnVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ukVar.wbW.add(nnVar);
                    }
                    AppMethodBeat.o(28374);
                    return 0;
                case 3:
                    ukVar.version = aVar3.BTU.vd();
                    AppMethodBeat.o(28374);
                    return 0;
                case 4:
                    ukVar.wbX = aVar3.BTU.vd();
                    AppMethodBeat.o(28374);
                    return 0;
                case 5:
                    ukVar.wbY = aVar3.BTU.vd();
                    AppMethodBeat.o(28374);
                    return 0;
                case 6:
                    ukVar.tuB = aVar3.BTU.readString();
                    AppMethodBeat.o(28374);
                    return 0;
                default:
                    AppMethodBeat.o(28374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28374);
            return -1;
        }
    }
}
