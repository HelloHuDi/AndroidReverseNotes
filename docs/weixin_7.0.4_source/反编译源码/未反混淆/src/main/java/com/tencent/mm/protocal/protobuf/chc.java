package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class chc extends btd {
    public LinkedList<chd> xfW = new LinkedList();
    public int xfX;
    public int xfY;
    public int xfZ;

    public chc() {
        AppMethodBeat.i(11817);
        AppMethodBeat.o(11817);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11818);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(11818);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.xfW);
            aVar.iz(3, this.xfX);
            aVar.iz(4, this.xfY);
            aVar.iz(5, this.xfZ);
            AppMethodBeat.o(11818);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + e.a.a.a.c(2, 8, this.xfW)) + e.a.a.b.b.a.bs(3, this.xfX)) + e.a.a.b.b.a.bs(4, this.xfY)) + e.a.a.b.b.a.bs(5, this.xfZ);
            AppMethodBeat.o(11818);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(11818);
                throw bVar;
            }
            AppMethodBeat.o(11818);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chc chc = (chc) objArr[1];
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
                        chc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(11818);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chd chd = new chd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chd.populateBuilderWithField(aVar4, chd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        chc.xfW.add(chd);
                    }
                    AppMethodBeat.o(11818);
                    return 0;
                case 3:
                    chc.xfX = aVar3.BTU.vd();
                    AppMethodBeat.o(11818);
                    return 0;
                case 4:
                    chc.xfY = aVar3.BTU.vd();
                    AppMethodBeat.o(11818);
                    return 0;
                case 5:
                    chc.xfZ = aVar3.BTU.vd();
                    AppMethodBeat.o(11818);
                    return 0;
                default:
                    AppMethodBeat.o(11818);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11818);
            return -1;
        }
    }
}
