package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aiy extends btd {
    public long jBS;
    public long vEw;
    public int woR;
    public int woS;
    public int woT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51427);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(51427);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.ai(2, this.vEw);
            aVar.ai(3, this.jBS);
            aVar.iz(4, this.woR);
            aVar.iz(5, this.woS);
            aVar.iz(6, this.woT);
            AppMethodBeat.o(51427);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int o = ((((ix + e.a.a.b.b.a.o(2, this.vEw)) + e.a.a.b.b.a.o(3, this.jBS)) + e.a.a.b.b.a.bs(4, this.woR)) + e.a.a.b.b.a.bs(5, this.woS)) + e.a.a.b.b.a.bs(6, this.woT);
            AppMethodBeat.o(51427);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(51427);
                throw bVar;
            }
            AppMethodBeat.o(51427);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aiy aiy = (aiy) objArr[1];
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
                        aiy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(51427);
                    return 0;
                case 2:
                    aiy.vEw = aVar3.BTU.ve();
                    AppMethodBeat.o(51427);
                    return 0;
                case 3:
                    aiy.jBS = aVar3.BTU.ve();
                    AppMethodBeat.o(51427);
                    return 0;
                case 4:
                    aiy.woR = aVar3.BTU.vd();
                    AppMethodBeat.o(51427);
                    return 0;
                case 5:
                    aiy.woS = aVar3.BTU.vd();
                    AppMethodBeat.o(51427);
                    return 0;
                case 6:
                    aiy.woT = aVar3.BTU.vd();
                    AppMethodBeat.o(51427);
                    return 0;
                default:
                    AppMethodBeat.o(51427);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51427);
            return -1;
        }
    }
}
