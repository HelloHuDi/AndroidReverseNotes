package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anh extends btd {
    public int kCl;
    public String kCm;
    public boolean ttQ;
    public String wrM;
    public String wrN;
    public String wrO;
    public String wrP;
    public String wrQ;
    public boolean wrR;
    public String wrS;
    public long wrT;
    public boolean wrU;
    public boolean wrV;
    public boolean wrW;
    public String wrX;
    public String wrY;
    public String wrZ;
    public String wsa;
    public boolean wsb;
    public LinkedList<String> wsc = new LinkedList();
    public awr wsd;
    public boolean wse;

    public anh() {
        AppMethodBeat.i(56834);
        AppMethodBeat.o(56834);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56835);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56835);
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
            if (this.wrM != null) {
                aVar.e(4, this.wrM);
            }
            if (this.wrN != null) {
                aVar.e(5, this.wrN);
            }
            if (this.wrO != null) {
                aVar.e(6, this.wrO);
            }
            if (this.wrP != null) {
                aVar.e(7, this.wrP);
            }
            if (this.wrQ != null) {
                aVar.e(8, this.wrQ);
            }
            aVar.aO(9, this.wrR);
            if (this.wrS != null) {
                aVar.e(10, this.wrS);
            }
            aVar.ai(11, this.wrT);
            aVar.aO(12, this.wrU);
            aVar.aO(13, this.wrV);
            aVar.aO(14, this.wrW);
            if (this.wrX != null) {
                aVar.e(15, this.wrX);
            }
            if (this.wrY != null) {
                aVar.e(16, this.wrY);
            }
            if (this.wrZ != null) {
                aVar.e(17, this.wrZ);
            }
            if (this.wsa != null) {
                aVar.e(18, this.wsa);
            }
            aVar.aO(19, this.wsb);
            aVar.e(20, 1, this.wsc);
            aVar.aO(21, this.ttQ);
            if (this.wsd != null) {
                aVar.iy(22, this.wsd.computeSize());
                this.wsd.writeFields(aVar);
            }
            aVar.aO(23, this.wse);
            AppMethodBeat.o(56835);
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
            if (this.wrM != null) {
                ix += e.a.a.b.b.a.f(4, this.wrM);
            }
            if (this.wrN != null) {
                ix += e.a.a.b.b.a.f(5, this.wrN);
            }
            if (this.wrO != null) {
                ix += e.a.a.b.b.a.f(6, this.wrO);
            }
            if (this.wrP != null) {
                ix += e.a.a.b.b.a.f(7, this.wrP);
            }
            if (this.wrQ != null) {
                ix += e.a.a.b.b.a.f(8, this.wrQ);
            }
            ix += e.a.a.b.b.a.fv(9) + 1;
            if (this.wrS != null) {
                ix += e.a.a.b.b.a.f(10, this.wrS);
            }
            ix = (((ix + e.a.a.b.b.a.o(11, this.wrT)) + (e.a.a.b.b.a.fv(12) + 1)) + (e.a.a.b.b.a.fv(13) + 1)) + (e.a.a.b.b.a.fv(14) + 1);
            if (this.wrX != null) {
                ix += e.a.a.b.b.a.f(15, this.wrX);
            }
            if (this.wrY != null) {
                ix += e.a.a.b.b.a.f(16, this.wrY);
            }
            if (this.wrZ != null) {
                ix += e.a.a.b.b.a.f(17, this.wrZ);
            }
            if (this.wsa != null) {
                ix += e.a.a.b.b.a.f(18, this.wsa);
            }
            ix = ((ix + (e.a.a.b.b.a.fv(19) + 1)) + e.a.a.a.c(20, 1, this.wsc)) + (e.a.a.b.b.a.fv(21) + 1);
            if (this.wsd != null) {
                ix += e.a.a.a.ix(22, this.wsd.computeSize());
            }
            int fv = ix + (e.a.a.b.b.a.fv(23) + 1);
            AppMethodBeat.o(56835);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56835);
                throw bVar;
            }
            AppMethodBeat.o(56835);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anh anh = (anh) objArr[1];
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
                        anh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56835);
                    return 0;
                case 2:
                    anh.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56835);
                    return 0;
                case 3:
                    anh.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 4:
                    anh.wrM = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 5:
                    anh.wrN = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 6:
                    anh.wrO = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 7:
                    anh.wrP = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 8:
                    anh.wrQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 9:
                    anh.wrR = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                case 10:
                    anh.wrS = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 11:
                    anh.wrT = aVar3.BTU.ve();
                    AppMethodBeat.o(56835);
                    return 0;
                case 12:
                    anh.wrU = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                case 13:
                    anh.wrV = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                case 14:
                    anh.wrW = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                case 15:
                    anh.wrX = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 16:
                    anh.wrY = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 17:
                    anh.wrZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 18:
                    anh.wsa = aVar3.BTU.readString();
                    AppMethodBeat.o(56835);
                    return 0;
                case 19:
                    anh.wsb = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                case 20:
                    anh.wsc.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56835);
                    return 0;
                case 21:
                    anh.ttQ = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awr awr = new awr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awr.populateBuilderWithField(aVar4, awr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anh.wsd = awr;
                    }
                    AppMethodBeat.o(56835);
                    return 0;
                case 23:
                    anh.wse = aVar3.BTU.ehX();
                    AppMethodBeat.o(56835);
                    return 0;
                default:
                    AppMethodBeat.o(56835);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56835);
            return -1;
        }
    }
}
