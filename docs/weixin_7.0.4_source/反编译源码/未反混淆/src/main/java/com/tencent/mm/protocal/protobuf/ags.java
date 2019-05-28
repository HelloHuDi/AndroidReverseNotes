package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ags extends btd {
    public LinkedList<String> kaF = new LinkedList();
    public int kaH;
    public int kaI;
    public int kaJ;

    public ags() {
        AppMethodBeat.i(89085);
        AppMethodBeat.o(89085);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89086);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89086);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 1, this.kaF);
            aVar.iz(3, this.kaH);
            aVar.iz(4, this.kaI);
            aVar.iz(5, this.kaJ);
            AppMethodBeat.o(89086);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + e.a.a.a.c(2, 1, this.kaF)) + e.a.a.b.b.a.bs(3, this.kaH)) + e.a.a.b.b.a.bs(4, this.kaI)) + e.a.a.b.b.a.bs(5, this.kaJ);
            AppMethodBeat.o(89086);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kaF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89086);
                throw bVar;
            }
            AppMethodBeat.o(89086);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ags ags = (ags) objArr[1];
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
                        ags.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89086);
                    return 0;
                case 2:
                    ags.kaF.add(aVar3.BTU.readString());
                    AppMethodBeat.o(89086);
                    return 0;
                case 3:
                    ags.kaH = aVar3.BTU.vd();
                    AppMethodBeat.o(89086);
                    return 0;
                case 4:
                    ags.kaI = aVar3.BTU.vd();
                    AppMethodBeat.o(89086);
                    return 0;
                case 5:
                    ags.kaJ = aVar3.BTU.vd();
                    AppMethodBeat.o(89086);
                    return 0;
                default:
                    AppMethodBeat.o(89086);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89086);
            return -1;
        }
    }
}
