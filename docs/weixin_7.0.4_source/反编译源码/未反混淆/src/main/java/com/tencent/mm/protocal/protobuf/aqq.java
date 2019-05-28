package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aqq extends btd {
    public String Desc;
    public String Title;
    public String nzz;
    public String wuA;
    public String wuB;
    public String wuC;
    public String wuD;
    public String wuE;
    public int wug;
    public LinkedList<crw> wuh = new LinkedList();
    public String wut;
    public String wuu;
    public String wuv;
    public String wuw;
    public String wux;
    public String wuy;
    public csc wuz;

    public aqq() {
        AppMethodBeat.i(28508);
        AppMethodBeat.o(28508);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28509);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28509);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wut != null) {
                aVar.e(2, this.wut);
            }
            if (this.nzz != null) {
                aVar.e(3, this.nzz);
            }
            if (this.Title != null) {
                aVar.e(4, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(5, this.Desc);
            }
            if (this.wuu != null) {
                aVar.e(6, this.wuu);
            }
            if (this.wuv != null) {
                aVar.e(7, this.wuv);
            }
            if (this.wuw != null) {
                aVar.e(8, this.wuw);
            }
            if (this.wux != null) {
                aVar.e(9, this.wux);
            }
            if (this.wuy != null) {
                aVar.e(10, this.wuy);
            }
            if (this.wuz != null) {
                aVar.iy(11, this.wuz.computeSize());
                this.wuz.writeFields(aVar);
            }
            if (this.wuA != null) {
                aVar.e(12, this.wuA);
            }
            if (this.wuB != null) {
                aVar.e(13, this.wuB);
            }
            if (this.wuC != null) {
                aVar.e(14, this.wuC);
            }
            if (this.wuD != null) {
                aVar.e(15, this.wuD);
            }
            if (this.wuE != null) {
                aVar.e(16, this.wuE);
            }
            aVar.iz(17, this.wug);
            aVar.e(18, 8, this.wuh);
            AppMethodBeat.o(28509);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wut != null) {
                ix += e.a.a.b.b.a.f(2, this.wut);
            }
            if (this.nzz != null) {
                ix += e.a.a.b.b.a.f(3, this.nzz);
            }
            if (this.Title != null) {
                ix += e.a.a.b.b.a.f(4, this.Title);
            }
            if (this.Desc != null) {
                ix += e.a.a.b.b.a.f(5, this.Desc);
            }
            if (this.wuu != null) {
                ix += e.a.a.b.b.a.f(6, this.wuu);
            }
            if (this.wuv != null) {
                ix += e.a.a.b.b.a.f(7, this.wuv);
            }
            if (this.wuw != null) {
                ix += e.a.a.b.b.a.f(8, this.wuw);
            }
            if (this.wux != null) {
                ix += e.a.a.b.b.a.f(9, this.wux);
            }
            if (this.wuy != null) {
                ix += e.a.a.b.b.a.f(10, this.wuy);
            }
            if (this.wuz != null) {
                ix += e.a.a.a.ix(11, this.wuz.computeSize());
            }
            if (this.wuA != null) {
                ix += e.a.a.b.b.a.f(12, this.wuA);
            }
            if (this.wuB != null) {
                ix += e.a.a.b.b.a.f(13, this.wuB);
            }
            if (this.wuC != null) {
                ix += e.a.a.b.b.a.f(14, this.wuC);
            }
            if (this.wuD != null) {
                ix += e.a.a.b.b.a.f(15, this.wuD);
            }
            if (this.wuE != null) {
                ix += e.a.a.b.b.a.f(16, this.wuE);
            }
            int bs = (ix + e.a.a.b.b.a.bs(17, this.wug)) + e.a.a.a.c(18, 8, this.wuh);
            AppMethodBeat.o(28509);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wuh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28509);
                throw bVar;
            }
            AppMethodBeat.o(28509);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqq aqq = (aqq) objArr[1];
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
                        aqq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28509);
                    return 0;
                case 2:
                    aqq.wut = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 3:
                    aqq.nzz = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 4:
                    aqq.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 5:
                    aqq.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 6:
                    aqq.wuu = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 7:
                    aqq.wuv = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 8:
                    aqq.wuw = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 9:
                    aqq.wux = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 10:
                    aqq.wuy = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csc csc = new csc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csc.populateBuilderWithField(aVar4, csc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aqq.wuz = csc;
                    }
                    AppMethodBeat.o(28509);
                    return 0;
                case 12:
                    aqq.wuA = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 13:
                    aqq.wuB = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 14:
                    aqq.wuC = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 15:
                    aqq.wuD = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 16:
                    aqq.wuE = aVar3.BTU.readString();
                    AppMethodBeat.o(28509);
                    return 0;
                case 17:
                    aqq.wug = aVar3.BTU.vd();
                    AppMethodBeat.o(28509);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        crw crw = new crw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crw.populateBuilderWithField(aVar4, crw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aqq.wuh.add(crw);
                    }
                    AppMethodBeat.o(28509);
                    return 0;
                default:
                    AppMethodBeat.o(28509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28509);
            return -1;
        }
    }
}
