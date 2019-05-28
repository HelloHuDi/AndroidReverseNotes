package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ceu extends btd {
    public LinkedList<Integer> xaN = new LinkedList();
    public int xeu;

    public ceu() {
        AppMethodBeat.i(56539);
        AppMethodBeat.o(56539);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56540);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56540);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.xeu);
            aVar.f(3, 2, this.xaN);
            AppMethodBeat.o(56540);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + e.a.a.b.b.a.bs(2, this.xeu)) + e.a.a.a.d(3, 2, this.xaN);
            AppMethodBeat.o(56540);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xaN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56540);
                throw bVar;
            }
            AppMethodBeat.o(56540);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ceu ceu = (ceu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ceu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56540);
                    return 0;
                case 2:
                    ceu.xeu = aVar3.BTU.vd();
                    AppMethodBeat.o(56540);
                    return 0;
                case 3:
                    ceu.xaN = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(56540);
                    return 0;
                default:
                    AppMethodBeat.o(56540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56540);
            return -1;
        }
    }
}
