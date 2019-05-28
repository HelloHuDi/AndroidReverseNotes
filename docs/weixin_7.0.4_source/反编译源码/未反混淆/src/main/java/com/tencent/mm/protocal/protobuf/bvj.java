package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvj extends btd {
    public String vQg;
    public brd wWx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124358);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wWx != null) {
                aVar.iy(2, this.wWx.computeSize());
                this.wWx.writeFields(aVar);
            }
            if (this.vQg != null) {
                aVar.e(3, this.vQg);
            }
            AppMethodBeat.o(124358);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wWx != null) {
                ix += e.a.a.a.ix(2, this.wWx.computeSize());
            }
            if (this.vQg != null) {
                ix += e.a.a.b.b.a.f(3, this.vQg);
            }
            AppMethodBeat.o(124358);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124358);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvj bvj = (bvj) objArr[1];
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
                        bvj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124358);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brd brd = new brd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brd.populateBuilderWithField(aVar4, brd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bvj.wWx = brd;
                    }
                    AppMethodBeat.o(124358);
                    return 0;
                case 3:
                    bvj.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(124358);
                    return 0;
                default:
                    AppMethodBeat.o(124358);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124358);
            return -1;
        }
    }
}
