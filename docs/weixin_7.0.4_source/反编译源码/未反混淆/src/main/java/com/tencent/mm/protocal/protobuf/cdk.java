package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cdk extends btd {
    public int ptD;
    public long ptF;
    public int xdf;
    public LinkedList<qd> xdg = new LinkedList();

    public cdk() {
        AppMethodBeat.i(80193);
        AppMethodBeat.o(80193);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80194);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80194);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.ptD);
            aVar.ai(3, this.ptF);
            aVar.iz(4, this.xdf);
            aVar.e(5, 8, this.xdg);
            AppMethodBeat.o(80194);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.ptD)) + e.a.a.b.b.a.o(3, this.ptF)) + e.a.a.b.b.a.bs(4, this.xdf)) + e.a.a.a.c(5, 8, this.xdg);
            AppMethodBeat.o(80194);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80194);
                throw bVar;
            }
            AppMethodBeat.o(80194);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdk cdk = (cdk) objArr[1];
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
                        cdk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80194);
                    return 0;
                case 2:
                    cdk.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(80194);
                    return 0;
                case 3:
                    cdk.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(80194);
                    return 0;
                case 4:
                    cdk.xdf = aVar3.BTU.vd();
                    AppMethodBeat.o(80194);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        qd qdVar = new qd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qdVar.populateBuilderWithField(aVar4, qdVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdk.xdg.add(qdVar);
                    }
                    AppMethodBeat.o(80194);
                    return 0;
                default:
                    AppMethodBeat.o(80194);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80194);
            return -1;
        }
    }
}
