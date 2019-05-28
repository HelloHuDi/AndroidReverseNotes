package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class arc extends btd {
    public String cDL;
    public int ret;
    public String url;
    public int wnU;
    public bie wuN;
    public LinkedList<bde> wuO = new LinkedList();
    public String wuP;

    public arc() {
        AppMethodBeat.i(96235);
        AppMethodBeat.o(96235);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96236);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96236);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.ret);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.iz(4, this.wnU);
            if (this.cDL != null) {
                aVar.e(5, this.cDL);
            }
            if (this.wuN != null) {
                aVar.iy(6, this.wuN.computeSize());
                this.wuN.writeFields(aVar);
            }
            aVar.e(7, 8, this.wuO);
            if (this.wuP != null) {
                aVar.e(8, this.wuP);
            }
            AppMethodBeat.o(96236);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.ret);
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(3, this.url);
            }
            ix += e.a.a.b.b.a.bs(4, this.wnU);
            if (this.cDL != null) {
                ix += e.a.a.b.b.a.f(5, this.cDL);
            }
            if (this.wuN != null) {
                ix += e.a.a.a.ix(6, this.wuN.computeSize());
            }
            ix += e.a.a.a.c(7, 8, this.wuO);
            if (this.wuP != null) {
                ix += e.a.a.b.b.a.f(8, this.wuP);
            }
            AppMethodBeat.o(96236);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wuO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96236);
                throw bVar;
            }
            AppMethodBeat.o(96236);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arc arc = (arc) objArr[1];
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
                        arc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96236);
                    return 0;
                case 2:
                    arc.ret = aVar3.BTU.vd();
                    AppMethodBeat.o(96236);
                    return 0;
                case 3:
                    arc.url = aVar3.BTU.readString();
                    AppMethodBeat.o(96236);
                    return 0;
                case 4:
                    arc.wnU = aVar3.BTU.vd();
                    AppMethodBeat.o(96236);
                    return 0;
                case 5:
                    arc.cDL = aVar3.BTU.readString();
                    AppMethodBeat.o(96236);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bie bie = new bie();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bie.populateBuilderWithField(aVar4, bie, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        arc.wuN = bie;
                    }
                    AppMethodBeat.o(96236);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bde bde = new bde();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bde.populateBuilderWithField(aVar4, bde, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        arc.wuO.add(bde);
                    }
                    AppMethodBeat.o(96236);
                    return 0;
                case 8:
                    arc.wuP = aVar3.BTU.readString();
                    AppMethodBeat.o(96236);
                    return 0;
                default:
                    AppMethodBeat.o(96236);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96236);
            return -1;
        }
    }
}
