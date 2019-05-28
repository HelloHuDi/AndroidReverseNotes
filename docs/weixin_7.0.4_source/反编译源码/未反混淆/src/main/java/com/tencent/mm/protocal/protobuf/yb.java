package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class yb extends btd {
    public boolean wdL;
    public String wdM;
    public String wdN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62526);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62526);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aO(2, this.wdL);
            if (this.wdM != null) {
                aVar.e(3, this.wdM);
            }
            if (this.wdN != null) {
                aVar.e(4, this.wdN);
            }
            AppMethodBeat.o(62526);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.fv(2) + 1;
            if (this.wdM != null) {
                ix += e.a.a.b.b.a.f(3, this.wdM);
            }
            if (this.wdN != null) {
                ix += e.a.a.b.b.a.f(4, this.wdN);
            }
            AppMethodBeat.o(62526);
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
                AppMethodBeat.o(62526);
                throw bVar;
            }
            AppMethodBeat.o(62526);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yb ybVar = (yb) objArr[1];
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
                        ybVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62526);
                    return 0;
                case 2:
                    ybVar.wdL = aVar3.BTU.ehX();
                    AppMethodBeat.o(62526);
                    return 0;
                case 3:
                    ybVar.wdM = aVar3.BTU.readString();
                    AppMethodBeat.o(62526);
                    return 0;
                case 4:
                    ybVar.wdN = aVar3.BTU.readString();
                    AppMethodBeat.o(62526);
                    return 0;
                default:
                    AppMethodBeat.o(62526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62526);
            return -1;
        }
    }
}
