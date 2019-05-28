package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bhk extends btd {
    public long cSh;
    public int nSb;
    public int nSc;
    public String nSd;
    public String nSe;
    public String nSf;
    public bpt vWf;
    public int vzO;
    public int wKA;
    public long wKB;
    public long wKC;
    public LinkedList<ash> wKD = new LinkedList();
    public String wKE;
    public String wKF;
    public String wKG;
    public int wKH;
    public int wKI;
    public String wKJ;
    public int wKy;
    public int wKz;

    public bhk() {
        AppMethodBeat.i(56874);
        AppMethodBeat.o(56874);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56875);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56875);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wKy);
            aVar.iz(3, this.wKz);
            aVar.iz(4, this.nSb);
            aVar.ai(5, this.cSh);
            aVar.iz(6, this.wKA);
            aVar.ai(7, this.wKB);
            aVar.iz(8, this.vzO);
            aVar.ai(9, this.wKC);
            aVar.iz(10, this.nSc);
            aVar.e(11, 8, this.wKD);
            if (this.nSd != null) {
                aVar.e(12, this.nSd);
            }
            if (this.wKE != null) {
                aVar.e(13, this.wKE);
            }
            if (this.wKF != null) {
                aVar.e(14, this.wKF);
            }
            if (this.wKG != null) {
                aVar.e(15, this.wKG);
            }
            aVar.iz(16, this.wKH);
            if (this.nSf != null) {
                aVar.e(17, this.nSf);
            }
            aVar.iz(18, this.wKI);
            if (this.nSe != null) {
                aVar.e(19, this.nSe);
            }
            if (this.vWf != null) {
                aVar.iy(20, this.vWf.computeSize());
                this.vWf.writeFields(aVar);
            }
            if (this.wKJ != null) {
                aVar.e(21, this.wKJ);
            }
            AppMethodBeat.o(56875);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((((((ix + e.a.a.b.b.a.bs(2, this.wKy)) + e.a.a.b.b.a.bs(3, this.wKz)) + e.a.a.b.b.a.bs(4, this.nSb)) + e.a.a.b.b.a.o(5, this.cSh)) + e.a.a.b.b.a.bs(6, this.wKA)) + e.a.a.b.b.a.o(7, this.wKB)) + e.a.a.b.b.a.bs(8, this.vzO)) + e.a.a.b.b.a.o(9, this.wKC)) + e.a.a.b.b.a.bs(10, this.nSc)) + e.a.a.a.c(11, 8, this.wKD);
            if (this.nSd != null) {
                ix += e.a.a.b.b.a.f(12, this.nSd);
            }
            if (this.wKE != null) {
                ix += e.a.a.b.b.a.f(13, this.wKE);
            }
            if (this.wKF != null) {
                ix += e.a.a.b.b.a.f(14, this.wKF);
            }
            if (this.wKG != null) {
                ix += e.a.a.b.b.a.f(15, this.wKG);
            }
            ix += e.a.a.b.b.a.bs(16, this.wKH);
            if (this.nSf != null) {
                ix += e.a.a.b.b.a.f(17, this.nSf);
            }
            ix += e.a.a.b.b.a.bs(18, this.wKI);
            if (this.nSe != null) {
                ix += e.a.a.b.b.a.f(19, this.nSe);
            }
            if (this.vWf != null) {
                ix += e.a.a.a.ix(20, this.vWf.computeSize());
            }
            if (this.wKJ != null) {
                ix += e.a.a.b.b.a.f(21, this.wKJ);
            }
            AppMethodBeat.o(56875);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wKD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56875);
                throw bVar;
            }
            AppMethodBeat.o(56875);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhk bhk = (bhk) objArr[1];
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
                        bhk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56875);
                    return 0;
                case 2:
                    bhk.wKy = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 3:
                    bhk.wKz = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 4:
                    bhk.nSb = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 5:
                    bhk.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56875);
                    return 0;
                case 6:
                    bhk.wKA = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 7:
                    bhk.wKB = aVar3.BTU.ve();
                    AppMethodBeat.o(56875);
                    return 0;
                case 8:
                    bhk.vzO = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 9:
                    bhk.wKC = aVar3.BTU.ve();
                    AppMethodBeat.o(56875);
                    return 0;
                case 10:
                    bhk.nSc = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ash ash = new ash();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ash.populateBuilderWithField(aVar4, ash, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bhk.wKD.add(ash);
                    }
                    AppMethodBeat.o(56875);
                    return 0;
                case 12:
                    bhk.nSd = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                case 13:
                    bhk.wKE = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                case 14:
                    bhk.wKF = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                case 15:
                    bhk.wKG = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                case 16:
                    bhk.wKH = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 17:
                    bhk.nSf = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                case 18:
                    bhk.wKI = aVar3.BTU.vd();
                    AppMethodBeat.o(56875);
                    return 0;
                case 19:
                    bhk.nSe = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(aVar4, bpt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bhk.vWf = bpt;
                    }
                    AppMethodBeat.o(56875);
                    return 0;
                case 21:
                    bhk.wKJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56875);
                    return 0;
                default:
                    AppMethodBeat.o(56875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56875);
            return -1;
        }
    }
}
