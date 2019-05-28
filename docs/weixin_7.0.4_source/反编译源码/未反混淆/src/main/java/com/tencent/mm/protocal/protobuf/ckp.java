package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ckp extends btd {
    public String wGj;
    public int wnG;
    public int wnH;
    public int wnI;
    public int wnJ;
    public String wnK;
    public int wnL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5605);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5605);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wGj != null) {
                aVar.e(2, this.wGj);
            }
            if (this.wnK != null) {
                aVar.e(3, this.wnK);
            }
            aVar.iz(4, this.wnJ);
            aVar.iz(5, this.wnG);
            aVar.iz(6, this.wnH);
            aVar.iz(7, this.wnI);
            aVar.iz(8, this.wnL);
            AppMethodBeat.o(5605);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wGj != null) {
                ix += e.a.a.b.b.a.f(2, this.wGj);
            }
            if (this.wnK != null) {
                ix += e.a.a.b.b.a.f(3, this.wnK);
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(4, this.wnJ)) + e.a.a.b.b.a.bs(5, this.wnG)) + e.a.a.b.b.a.bs(6, this.wnH)) + e.a.a.b.b.a.bs(7, this.wnI)) + e.a.a.b.b.a.bs(8, this.wnL);
            AppMethodBeat.o(5605);
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
                AppMethodBeat.o(5605);
                throw bVar;
            }
            AppMethodBeat.o(5605);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckp ckp = (ckp) objArr[1];
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
                        ckp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5605);
                    return 0;
                case 2:
                    ckp.wGj = aVar3.BTU.readString();
                    AppMethodBeat.o(5605);
                    return 0;
                case 3:
                    ckp.wnK = aVar3.BTU.readString();
                    AppMethodBeat.o(5605);
                    return 0;
                case 4:
                    ckp.wnJ = aVar3.BTU.vd();
                    AppMethodBeat.o(5605);
                    return 0;
                case 5:
                    ckp.wnG = aVar3.BTU.vd();
                    AppMethodBeat.o(5605);
                    return 0;
                case 6:
                    ckp.wnH = aVar3.BTU.vd();
                    AppMethodBeat.o(5605);
                    return 0;
                case 7:
                    ckp.wnI = aVar3.BTU.vd();
                    AppMethodBeat.o(5605);
                    return 0;
                case 8:
                    ckp.wnL = aVar3.BTU.vd();
                    AppMethodBeat.o(5605);
                    return 0;
                default:
                    AppMethodBeat.o(5605);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5605);
            return -1;
        }
    }
}
