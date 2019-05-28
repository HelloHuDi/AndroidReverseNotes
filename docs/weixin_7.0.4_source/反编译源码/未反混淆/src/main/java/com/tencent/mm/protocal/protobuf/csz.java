package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class csz extends btd {
    public cta xqh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93814);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.xqh != null) {
                aVar.iy(2, this.xqh.computeSize());
                this.xqh.writeFields(aVar);
            }
            AppMethodBeat.o(93814);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xqh != null) {
                ix += e.a.a.a.ix(2, this.xqh.computeSize());
            }
            AppMethodBeat.o(93814);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(93814);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csz csz = (csz) objArr[1];
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
                        csz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(93814);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cta cta = new cta();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cta.populateBuilderWithField(aVar4, cta, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        csz.xqh = cta;
                    }
                    AppMethodBeat.o(93814);
                    return 0;
                default:
                    AppMethodBeat.o(93814);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93814);
            return -1;
        }
    }
}
