package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rk extends btd {
    public int jCt;
    public int vYE;
    public int vYF;
    public int vYG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(50528);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50528);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.vYE);
            aVar.iz(4, this.vYF);
            aVar.iz(5, this.vYG);
            AppMethodBeat.o(50528);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.vYE)) + e.a.a.b.b.a.bs(4, this.vYF)) + e.a.a.b.b.a.bs(5, this.vYG);
            AppMethodBeat.o(50528);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50528);
                throw bVar;
            }
            AppMethodBeat.o(50528);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rk rkVar = (rk) objArr[1];
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
                        rkVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(50528);
                    return 0;
                case 2:
                    rkVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(50528);
                    return 0;
                case 3:
                    rkVar.vYE = aVar3.BTU.vd();
                    AppMethodBeat.o(50528);
                    return 0;
                case 4:
                    rkVar.vYF = aVar3.BTU.vd();
                    AppMethodBeat.o(50528);
                    return 0;
                case 5:
                    rkVar.vYG = aVar3.BTU.vd();
                    AppMethodBeat.o(50528);
                    return 0;
                default:
                    AppMethodBeat.o(50528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50528);
            return -1;
        }
    }
}
