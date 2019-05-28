package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahu extends btd {
    public int wod;
    public LinkedList<bbv> woe = new LinkedList();
    public LinkedList<Integer> wof = new LinkedList();
    public LinkedList<cnj> wog = new LinkedList();

    public ahu() {
        AppMethodBeat.i(28430);
        AppMethodBeat.o(28430);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28431);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28431);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wod);
            aVar.e(3, 8, this.woe);
            aVar.f(4, 2, this.wof);
            aVar.e(5, 8, this.wog);
            AppMethodBeat.o(28431);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.wod)) + e.a.a.a.c(3, 8, this.woe)) + e.a.a.a.d(4, 2, this.wof)) + e.a.a.a.c(5, 8, this.wog);
            AppMethodBeat.o(28431);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woe.clear();
            this.wof.clear();
            this.wog.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28431);
                throw bVar;
            }
            AppMethodBeat.o(28431);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahu ahu = (ahu) objArr[1];
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
                        ahu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28431);
                    return 0;
                case 2:
                    ahu.wod = aVar3.BTU.vd();
                    AppMethodBeat.o(28431);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbv bbv = new bbv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbv.populateBuilderWithField(aVar4, bbv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ahu.woe.add(bbv);
                    }
                    AppMethodBeat.o(28431);
                    return 0;
                case 4:
                    ahu.wof = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(28431);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnj cnj = new cnj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnj.populateBuilderWithField(aVar4, cnj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ahu.wog.add(cnj);
                    }
                    AppMethodBeat.o(28431);
                    return 0;
                default:
                    AppMethodBeat.o(28431);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28431);
            return -1;
        }
    }
}
