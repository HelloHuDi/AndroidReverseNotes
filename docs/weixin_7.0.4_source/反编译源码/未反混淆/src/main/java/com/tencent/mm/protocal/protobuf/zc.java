package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a.a;
import d.a.a.g;
import java.util.LinkedList;

public final class zc extends btd {
    public int kdT;
    public String kdU;
    public LinkedList<g> wew = new LinkedList();
    public int wex;
    public a wey;

    public zc() {
        AppMethodBeat.i(56776);
        AppMethodBeat.o(56776);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56777);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            aVar.e(4, 8, this.wew);
            aVar.iz(5, this.wex);
            if (this.wey != null) {
                aVar.iy(6, this.wey.computeSize());
                this.wey.writeFields(aVar);
            }
            AppMethodBeat.o(56777);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            ix = (ix + e.a.a.a.c(4, 8, this.wew)) + e.a.a.b.b.a.bs(5, this.wex);
            if (this.wey != null) {
                ix += e.a.a.a.ix(6, this.wey.computeSize());
            }
            AppMethodBeat.o(56777);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wew.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56777);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zc zcVar = (zc) objArr[1];
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
                        zcVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56777);
                    return 0;
                case 2:
                    zcVar.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56777);
                    return 0;
                case 3:
                    zcVar.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56777);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        zcVar.wew.add(gVar);
                    }
                    AppMethodBeat.o(56777);
                    return 0;
                case 5:
                    zcVar.wex = aVar3.BTU.vd();
                    AppMethodBeat.o(56777);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.populateBuilderWithField(aVar4, aVar5, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        zcVar.wey = aVar5;
                    }
                    AppMethodBeat.o(56777);
                    return 0;
                default:
                    AppMethodBeat.o(56777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56777);
            return -1;
        }
    }
}
