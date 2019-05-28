package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aai extends btd {
    public String wfC;
    public boolean wfD = true;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(842);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(842);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wfC != null) {
                aVar.e(2, this.wfC);
            }
            aVar.aO(3, this.wfD);
            AppMethodBeat.o(842);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wfC != null) {
                ix += e.a.a.b.b.a.f(2, this.wfC);
            }
            int fv = ix + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(842);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(842);
                throw bVar;
            }
            AppMethodBeat.o(842);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aai aai = (aai) objArr[1];
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
                        aai.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(842);
                    return 0;
                case 2:
                    aai.wfC = aVar3.BTU.readString();
                    AppMethodBeat.o(842);
                    return 0;
                case 3:
                    aai.wfD = aVar3.BTU.ehX();
                    AppMethodBeat.o(842);
                    return 0;
                default:
                    AppMethodBeat.o(842);
                    return -1;
            }
        } else {
            AppMethodBeat.o(842);
            return -1;
        }
    }
}
