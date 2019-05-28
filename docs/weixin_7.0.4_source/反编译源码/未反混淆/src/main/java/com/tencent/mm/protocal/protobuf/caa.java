package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class caa extends btd {
    public String wDM;
    public String wYV;
    public String wYW;
    public String wYX;
    public int wZh;
    public int wZi;
    public int wZj;
    public b wZk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124364);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wYV != null) {
                aVar.e(2, this.wYV);
            }
            aVar.iz(3, this.wZh);
            aVar.iz(4, this.wZi);
            if (this.wYW != null) {
                aVar.e(5, this.wYW);
            }
            if (this.wYX != null) {
                aVar.e(6, this.wYX);
            }
            aVar.iz(7, this.wZj);
            if (this.wDM != null) {
                aVar.e(8, this.wDM);
            }
            if (this.wZk != null) {
                aVar.c(9, this.wZk);
            }
            AppMethodBeat.o(124364);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wYV != null) {
                ix += e.a.a.b.b.a.f(2, this.wYV);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.wZh)) + e.a.a.b.b.a.bs(4, this.wZi);
            if (this.wYW != null) {
                ix += e.a.a.b.b.a.f(5, this.wYW);
            }
            if (this.wYX != null) {
                ix += e.a.a.b.b.a.f(6, this.wYX);
            }
            ix += e.a.a.b.b.a.bs(7, this.wZj);
            if (this.wDM != null) {
                ix += e.a.a.b.b.a.f(8, this.wDM);
            }
            if (this.wZk != null) {
                ix += e.a.a.b.b.a.b(9, this.wZk);
            }
            AppMethodBeat.o(124364);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124364);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            caa caa = (caa) objArr[1];
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
                        caa.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124364);
                    return 0;
                case 2:
                    caa.wYV = aVar3.BTU.readString();
                    AppMethodBeat.o(124364);
                    return 0;
                case 3:
                    caa.wZh = aVar3.BTU.vd();
                    AppMethodBeat.o(124364);
                    return 0;
                case 4:
                    caa.wZi = aVar3.BTU.vd();
                    AppMethodBeat.o(124364);
                    return 0;
                case 5:
                    caa.wYW = aVar3.BTU.readString();
                    AppMethodBeat.o(124364);
                    return 0;
                case 6:
                    caa.wYX = aVar3.BTU.readString();
                    AppMethodBeat.o(124364);
                    return 0;
                case 7:
                    caa.wZj = aVar3.BTU.vd();
                    AppMethodBeat.o(124364);
                    return 0;
                case 8:
                    caa.wDM = aVar3.BTU.readString();
                    AppMethodBeat.o(124364);
                    return 0;
                case 9:
                    caa.wZk = aVar3.BTU.emu();
                    AppMethodBeat.o(124364);
                    return 0;
                default:
                    AppMethodBeat.o(124364);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124364);
            return -1;
        }
    }
}
