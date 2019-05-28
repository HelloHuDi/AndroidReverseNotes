package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zy extends btd {
    public int cRU;
    public int cRV;
    public int cvG;
    public int kCl;
    public String kCm;
    public String nSX;
    public int nUf;
    public int nUh;
    public String nUi;
    public String nUj;
    public String nUk;
    public int nUl;
    public String nXl;
    public bpt vWf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56785);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56785);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kCl);
            if (this.kCm != null) {
                aVar.e(3, this.kCm);
            }
            aVar.iz(4, this.cvG);
            if (this.nSX != null) {
                aVar.e(5, this.nSX);
            }
            aVar.iz(6, this.cRU);
            aVar.iz(7, this.cRV);
            if (this.nXl != null) {
                aVar.e(8, this.nXl);
            }
            aVar.iz(9, this.nUf);
            if (this.vWf != null) {
                aVar.iy(10, this.vWf.computeSize());
                this.vWf.writeFields(aVar);
            }
            aVar.iz(11, this.nUh);
            if (this.nUi != null) {
                aVar.e(12, this.nUi);
            }
            if (this.nUj != null) {
                aVar.e(13, this.nUj);
            }
            if (this.nUk != null) {
                aVar.e(14, this.nUk);
            }
            aVar.iz(15, this.nUl);
            AppMethodBeat.o(56785);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kCl);
            if (this.kCm != null) {
                ix += e.a.a.b.b.a.f(3, this.kCm);
            }
            ix += e.a.a.b.b.a.bs(4, this.cvG);
            if (this.nSX != null) {
                ix += e.a.a.b.b.a.f(5, this.nSX);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.cRU)) + e.a.a.b.b.a.bs(7, this.cRV);
            if (this.nXl != null) {
                ix += e.a.a.b.b.a.f(8, this.nXl);
            }
            ix += e.a.a.b.b.a.bs(9, this.nUf);
            if (this.vWf != null) {
                ix += e.a.a.a.ix(10, this.vWf.computeSize());
            }
            ix += e.a.a.b.b.a.bs(11, this.nUh);
            if (this.nUi != null) {
                ix += e.a.a.b.b.a.f(12, this.nUi);
            }
            if (this.nUj != null) {
                ix += e.a.a.b.b.a.f(13, this.nUj);
            }
            if (this.nUk != null) {
                ix += e.a.a.b.b.a.f(14, this.nUk);
            }
            int bs = ix + e.a.a.b.b.a.bs(15, this.nUl);
            AppMethodBeat.o(56785);
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
                AppMethodBeat.o(56785);
                throw bVar;
            }
            AppMethodBeat.o(56785);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zy zyVar = (zy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        zyVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56785);
                    return 0;
                case 2:
                    zyVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                case 3:
                    zyVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56785);
                    return 0;
                case 4:
                    zyVar.cvG = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                case 5:
                    zyVar.nSX = aVar3.BTU.readString();
                    AppMethodBeat.o(56785);
                    return 0;
                case 6:
                    zyVar.cRU = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                case 7:
                    zyVar.cRV = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                case 8:
                    zyVar.nXl = aVar3.BTU.readString();
                    AppMethodBeat.o(56785);
                    return 0;
                case 9:
                    zyVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(aVar4, bpt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        zyVar.vWf = bpt;
                    }
                    AppMethodBeat.o(56785);
                    return 0;
                case 11:
                    zyVar.nUh = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                case 12:
                    zyVar.nUi = aVar3.BTU.readString();
                    AppMethodBeat.o(56785);
                    return 0;
                case 13:
                    zyVar.nUj = aVar3.BTU.readString();
                    AppMethodBeat.o(56785);
                    return 0;
                case 14:
                    zyVar.nUk = aVar3.BTU.readString();
                    AppMethodBeat.o(56785);
                    return 0;
                case 15:
                    zyVar.nUl = aVar3.BTU.vd();
                    AppMethodBeat.o(56785);
                    return 0;
                default:
                    AppMethodBeat.o(56785);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56785);
            return -1;
        }
    }
}
