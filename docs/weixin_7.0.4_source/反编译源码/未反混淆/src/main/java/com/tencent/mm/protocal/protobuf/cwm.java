package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cwm extends btd {
    public cwg vXT;
    public LinkedList<cwu> xsh = new LinkedList();

    public cwm() {
        AppMethodBeat.i(114999);
        AppMethodBeat.o(114999);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115000);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.xsh);
            if (this.vXT != null) {
                aVar.iy(3, this.vXT.computeSize());
                this.vXT.writeFields(aVar);
            }
            AppMethodBeat.o(115000);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.xsh);
            if (this.vXT != null) {
                ix += e.a.a.a.ix(3, this.vXT.computeSize());
            }
            AppMethodBeat.o(115000);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115000);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwm cwm = (cwm) objArr[1];
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
                        cwm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(115000);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwu cwu = new cwu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwu.populateBuilderWithField(aVar4, cwu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwm.xsh.add(cwu);
                    }
                    AppMethodBeat.o(115000);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(aVar4, cwg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwm.vXT = cwg;
                    }
                    AppMethodBeat.o(115000);
                    return 0;
                default:
                    AppMethodBeat.o(115000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115000);
            return -1;
        }
    }
}
