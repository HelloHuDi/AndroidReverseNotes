package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bon extends btd {
    public long cSh;
    public int nSb;
    public int nSc;
    public String nSd;
    public String nSe;
    public String nSf;
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

    public bon() {
        AppMethodBeat.i(56948);
        AppMethodBeat.o(56948);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56949);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56949);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.ai(2, this.cSh);
            aVar.iz(3, this.wKA);
            aVar.ai(4, this.wKB);
            aVar.iz(5, this.vzO);
            aVar.ai(6, this.wKC);
            aVar.iz(9, this.nSc);
            aVar.e(10, 8, this.wKD);
            if (this.nSd != null) {
                aVar.e(11, this.nSd);
            }
            if (this.wKE != null) {
                aVar.e(12, this.wKE);
            }
            if (this.wKF != null) {
                aVar.e(13, this.wKF);
            }
            if (this.wKG != null) {
                aVar.e(14, this.wKG);
            }
            aVar.iz(15, this.wKH);
            if (this.nSf != null) {
                aVar.e(16, this.nSf);
            }
            aVar.iz(17, this.wKI);
            if (this.nSe != null) {
                aVar.e(18, this.nSe);
            }
            aVar.iz(19, this.wKz);
            aVar.iz(20, this.nSb);
            aVar.iz(21, this.wKy);
            if (this.wKJ != null) {
                aVar.e(22, this.wKJ);
            }
            AppMethodBeat.o(56949);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + e.a.a.b.b.a.o(2, this.cSh)) + e.a.a.b.b.a.bs(3, this.wKA)) + e.a.a.b.b.a.o(4, this.wKB)) + e.a.a.b.b.a.bs(5, this.vzO)) + e.a.a.b.b.a.o(6, this.wKC)) + e.a.a.b.b.a.bs(9, this.nSc)) + e.a.a.a.c(10, 8, this.wKD);
            if (this.nSd != null) {
                ix += e.a.a.b.b.a.f(11, this.nSd);
            }
            if (this.wKE != null) {
                ix += e.a.a.b.b.a.f(12, this.wKE);
            }
            if (this.wKF != null) {
                ix += e.a.a.b.b.a.f(13, this.wKF);
            }
            if (this.wKG != null) {
                ix += e.a.a.b.b.a.f(14, this.wKG);
            }
            ix += e.a.a.b.b.a.bs(15, this.wKH);
            if (this.nSf != null) {
                ix += e.a.a.b.b.a.f(16, this.nSf);
            }
            ix += e.a.a.b.b.a.bs(17, this.wKI);
            if (this.nSe != null) {
                ix += e.a.a.b.b.a.f(18, this.nSe);
            }
            ix = ((ix + e.a.a.b.b.a.bs(19, this.wKz)) + e.a.a.b.b.a.bs(20, this.nSb)) + e.a.a.b.b.a.bs(21, this.wKy);
            if (this.wKJ != null) {
                ix += e.a.a.b.b.a.f(22, this.wKJ);
            }
            AppMethodBeat.o(56949);
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
                AppMethodBeat.o(56949);
                throw bVar;
            }
            AppMethodBeat.o(56949);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bon bon = (bon) objArr[1];
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
                        bon.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56949);
                    return 0;
                case 2:
                    bon.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56949);
                    return 0;
                case 3:
                    bon.wKA = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 4:
                    bon.wKB = aVar3.BTU.ve();
                    AppMethodBeat.o(56949);
                    return 0;
                case 5:
                    bon.vzO = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 6:
                    bon.wKC = aVar3.BTU.ve();
                    AppMethodBeat.o(56949);
                    return 0;
                case 9:
                    bon.nSc = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ash ash = new ash();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ash.populateBuilderWithField(aVar4, ash, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bon.wKD.add(ash);
                    }
                    AppMethodBeat.o(56949);
                    return 0;
                case 11:
                    bon.nSd = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                case 12:
                    bon.wKE = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                case 13:
                    bon.wKF = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                case 14:
                    bon.wKG = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                case 15:
                    bon.wKH = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 16:
                    bon.nSf = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                case 17:
                    bon.wKI = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 18:
                    bon.nSe = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                case 19:
                    bon.wKz = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 20:
                    bon.nSb = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 21:
                    bon.wKy = aVar3.BTU.vd();
                    AppMethodBeat.o(56949);
                    return 0;
                case 22:
                    bon.wKJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56949);
                    return 0;
                default:
                    AppMethodBeat.o(56949);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56949);
            return -1;
        }
    }
}
