package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class auz extends btd {
    public int jBv;
    public LinkedList<Integer> wyZ = new LinkedList();

    public auz() {
        AppMethodBeat.i(73726);
        AppMethodBeat.o(73726);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73727);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73727);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.f(3, 2, this.wyZ);
            AppMethodBeat.o(73727);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.d(3, 2, this.wyZ);
            AppMethodBeat.o(73727);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wyZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73727);
                throw bVar;
            }
            AppMethodBeat.o(73727);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auz auz = (auz) objArr[1];
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
                        auz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73727);
                    return 0;
                case 2:
                    auz.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(73727);
                    return 0;
                case 3:
                    auz.wyZ = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(73727);
                    return 0;
                default:
                    AppMethodBeat.o(73727);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73727);
            return -1;
        }
    }
}
