package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class clt extends btd {
    public int ptD;
    public long ptF;
    public String vFF;
    public String vRw;
    public int wEt;
    public int xjp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51009);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(51009);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vFF != null) {
                aVar.e(2, this.vFF);
            }
            aVar.iz(3, this.ptD);
            aVar.iz(4, this.wEt);
            aVar.iz(5, this.xjp);
            aVar.ai(6, this.ptF);
            if (this.vRw != null) {
                aVar.e(7, this.vRw);
            }
            AppMethodBeat.o(51009);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFF != null) {
                ix += e.a.a.b.b.a.f(2, this.vFF);
            }
            ix = (((ix + e.a.a.b.b.a.bs(3, this.ptD)) + e.a.a.b.b.a.bs(4, this.wEt)) + e.a.a.b.b.a.bs(5, this.xjp)) + e.a.a.b.b.a.o(6, this.ptF);
            if (this.vRw != null) {
                ix += e.a.a.b.b.a.f(7, this.vRw);
            }
            AppMethodBeat.o(51009);
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
                AppMethodBeat.o(51009);
                throw bVar;
            }
            AppMethodBeat.o(51009);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clt clt = (clt) objArr[1];
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
                        clt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(51009);
                    return 0;
                case 2:
                    clt.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(51009);
                    return 0;
                case 3:
                    clt.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(51009);
                    return 0;
                case 4:
                    clt.wEt = aVar3.BTU.vd();
                    AppMethodBeat.o(51009);
                    return 0;
                case 5:
                    clt.xjp = aVar3.BTU.vd();
                    AppMethodBeat.o(51009);
                    return 0;
                case 6:
                    clt.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(51009);
                    return 0;
                case 7:
                    clt.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(51009);
                    return 0;
                default:
                    AppMethodBeat.o(51009);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51009);
            return -1;
        }
    }
}
