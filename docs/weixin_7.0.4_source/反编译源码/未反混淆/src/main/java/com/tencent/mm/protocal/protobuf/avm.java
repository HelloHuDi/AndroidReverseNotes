package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avm extends btd {
    public String fKh;
    public String vLo;
    public String vYO;
    public String vYP;
    public String vYQ;
    public String vYR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10202);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10202);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.vYO != null) {
                aVar.e(3, this.vYO);
            }
            if (this.vLo != null) {
                aVar.e(4, this.vLo);
            }
            if (this.vYP != null) {
                aVar.e(5, this.vYP);
            }
            if (this.vYQ != null) {
                aVar.e(6, this.vYQ);
            }
            if (this.vYR != null) {
                aVar.e(7, this.vYR);
            }
            AppMethodBeat.o(10202);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.vYO != null) {
                ix += e.a.a.b.b.a.f(3, this.vYO);
            }
            if (this.vLo != null) {
                ix += e.a.a.b.b.a.f(4, this.vLo);
            }
            if (this.vYP != null) {
                ix += e.a.a.b.b.a.f(5, this.vYP);
            }
            if (this.vYQ != null) {
                ix += e.a.a.b.b.a.f(6, this.vYQ);
            }
            if (this.vYR != null) {
                ix += e.a.a.b.b.a.f(7, this.vYR);
            }
            AppMethodBeat.o(10202);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10202);
                throw bVar;
            }
            AppMethodBeat.o(10202);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avm avm = (avm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10202);
                    return 0;
                case 2:
                    avm.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(10202);
                    return 0;
                case 3:
                    avm.vYO = aVar3.BTU.readString();
                    AppMethodBeat.o(10202);
                    return 0;
                case 4:
                    avm.vLo = aVar3.BTU.readString();
                    AppMethodBeat.o(10202);
                    return 0;
                case 5:
                    avm.vYP = aVar3.BTU.readString();
                    AppMethodBeat.o(10202);
                    return 0;
                case 6:
                    avm.vYQ = aVar3.BTU.readString();
                    AppMethodBeat.o(10202);
                    return 0;
                case 7:
                    avm.vYR = aVar3.BTU.readString();
                    AppMethodBeat.o(10202);
                    return 0;
                default:
                    AppMethodBeat.o(10202);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10202);
            return -1;
        }
    }
}
