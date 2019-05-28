package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class are extends btd {
    public String cEh;
    public int jsN;
    public cwg vXT;
    public String wuS;
    public String wuU;
    public int wuV;
    public LinkedList<bdt> wuW = new LinkedList();
    public int wuX;
    public String wuY;
    public String wuZ;
    public int wva;
    public String wvb;
    public String wvc;
    public String wvd;
    public int wve;
    public int wvf;
    public bdt wvg;

    public are() {
        AppMethodBeat.i(96238);
        AppMethodBeat.o(96238);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96239);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96239);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vXT != null) {
                aVar.iy(2, this.vXT.computeSize());
                this.vXT.writeFields(aVar);
            }
            if (this.wuU != null) {
                aVar.e(3, this.wuU);
            }
            aVar.iz(4, this.wuV);
            aVar.iz(5, this.jsN);
            if (this.wuS != null) {
                aVar.e(6, this.wuS);
            }
            aVar.e(7, 8, this.wuW);
            aVar.iz(8, this.wuX);
            if (this.wuY != null) {
                aVar.e(9, this.wuY);
            }
            if (this.wuZ != null) {
                aVar.e(10, this.wuZ);
            }
            aVar.iz(11, this.wva);
            if (this.cEh != null) {
                aVar.e(12, this.cEh);
            }
            if (this.wvb != null) {
                aVar.e(13, this.wvb);
            }
            if (this.wvc != null) {
                aVar.e(14, this.wvc);
            }
            if (this.wvd != null) {
                aVar.e(15, this.wvd);
            }
            aVar.iz(16, this.wve);
            aVar.iz(17, this.wvf);
            if (this.wvg != null) {
                aVar.iy(18, this.wvg.computeSize());
                this.wvg.writeFields(aVar);
            }
            AppMethodBeat.o(96239);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vXT != null) {
                ix += e.a.a.a.ix(2, this.vXT.computeSize());
            }
            if (this.wuU != null) {
                ix += e.a.a.b.b.a.f(3, this.wuU);
            }
            ix = (ix + e.a.a.b.b.a.bs(4, this.wuV)) + e.a.a.b.b.a.bs(5, this.jsN);
            if (this.wuS != null) {
                ix += e.a.a.b.b.a.f(6, this.wuS);
            }
            ix = (ix + e.a.a.a.c(7, 8, this.wuW)) + e.a.a.b.b.a.bs(8, this.wuX);
            if (this.wuY != null) {
                ix += e.a.a.b.b.a.f(9, this.wuY);
            }
            if (this.wuZ != null) {
                ix += e.a.a.b.b.a.f(10, this.wuZ);
            }
            ix += e.a.a.b.b.a.bs(11, this.wva);
            if (this.cEh != null) {
                ix += e.a.a.b.b.a.f(12, this.cEh);
            }
            if (this.wvb != null) {
                ix += e.a.a.b.b.a.f(13, this.wvb);
            }
            if (this.wvc != null) {
                ix += e.a.a.b.b.a.f(14, this.wvc);
            }
            if (this.wvd != null) {
                ix += e.a.a.b.b.a.f(15, this.wvd);
            }
            ix = (ix + e.a.a.b.b.a.bs(16, this.wve)) + e.a.a.b.b.a.bs(17, this.wvf);
            if (this.wvg != null) {
                ix += e.a.a.a.ix(18, this.wvg.computeSize());
            }
            AppMethodBeat.o(96239);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wuW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96239);
                throw bVar;
            }
            AppMethodBeat.o(96239);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            are are = (are) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bdt bdt;
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
                        are.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96239);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(aVar4, cwg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        are.vXT = cwg;
                    }
                    AppMethodBeat.o(96239);
                    return 0;
                case 3:
                    are.wuU = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 4:
                    are.wuV = aVar3.BTU.vd();
                    AppMethodBeat.o(96239);
                    return 0;
                case 5:
                    are.jsN = aVar3.BTU.vd();
                    AppMethodBeat.o(96239);
                    return 0;
                case 6:
                    are.wuS = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdt = new bdt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdt.populateBuilderWithField(aVar4, bdt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        are.wuW.add(bdt);
                    }
                    AppMethodBeat.o(96239);
                    return 0;
                case 8:
                    are.wuX = aVar3.BTU.vd();
                    AppMethodBeat.o(96239);
                    return 0;
                case 9:
                    are.wuY = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 10:
                    are.wuZ = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 11:
                    are.wva = aVar3.BTU.vd();
                    AppMethodBeat.o(96239);
                    return 0;
                case 12:
                    are.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 13:
                    are.wvb = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 14:
                    are.wvc = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 15:
                    are.wvd = aVar3.BTU.readString();
                    AppMethodBeat.o(96239);
                    return 0;
                case 16:
                    are.wve = aVar3.BTU.vd();
                    AppMethodBeat.o(96239);
                    return 0;
                case 17:
                    are.wvf = aVar3.BTU.vd();
                    AppMethodBeat.o(96239);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdt = new bdt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdt.populateBuilderWithField(aVar4, bdt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        are.wvg = bdt;
                    }
                    AppMethodBeat.o(96239);
                    return 0;
                default:
                    AppMethodBeat.o(96239);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96239);
            return -1;
        }
    }
}
