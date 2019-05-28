package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqb extends btd {
    public String kfM;
    public int nSb;
    public int nSc;
    public String nSd;
    public String wKE;
    public String wKF;
    public String wKG;
    public int wKH;
    public String wKJ;
    public b wKx;
    public int wKy;
    public int wKz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56953);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56953);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wKy);
            if (this.nSd != null) {
                aVar.e(3, this.nSd);
            }
            if (this.wKF != null) {
                aVar.e(4, this.wKF);
            }
            if (this.wKG != null) {
                aVar.e(5, this.wKG);
            }
            if (this.wKx != null) {
                aVar.c(6, this.wKx);
            }
            aVar.iz(7, this.wKz);
            aVar.iz(8, this.nSb);
            aVar.iz(9, this.wKH);
            aVar.iz(10, this.nSc);
            if (this.kfM != null) {
                aVar.e(11, this.kfM);
            }
            if (this.wKJ != null) {
                aVar.e(12, this.wKJ);
            }
            if (this.wKE != null) {
                aVar.e(13, this.wKE);
            }
            AppMethodBeat.o(56953);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wKy);
            if (this.nSd != null) {
                ix += e.a.a.b.b.a.f(3, this.nSd);
            }
            if (this.wKF != null) {
                ix += e.a.a.b.b.a.f(4, this.wKF);
            }
            if (this.wKG != null) {
                ix += e.a.a.b.b.a.f(5, this.wKG);
            }
            if (this.wKx != null) {
                ix += e.a.a.b.b.a.b(6, this.wKx);
            }
            ix = (((ix + e.a.a.b.b.a.bs(7, this.wKz)) + e.a.a.b.b.a.bs(8, this.nSb)) + e.a.a.b.b.a.bs(9, this.wKH)) + e.a.a.b.b.a.bs(10, this.nSc);
            if (this.kfM != null) {
                ix += e.a.a.b.b.a.f(11, this.kfM);
            }
            if (this.wKJ != null) {
                ix += e.a.a.b.b.a.f(12, this.wKJ);
            }
            if (this.wKE != null) {
                ix += e.a.a.b.b.a.f(13, this.wKE);
            }
            AppMethodBeat.o(56953);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56953);
                throw bVar;
            }
            AppMethodBeat.o(56953);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqb bqb = (bqb) objArr[1];
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
                        bqb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56953);
                    return 0;
                case 2:
                    bqb.wKy = aVar3.BTU.vd();
                    AppMethodBeat.o(56953);
                    return 0;
                case 3:
                    bqb.nSd = aVar3.BTU.readString();
                    AppMethodBeat.o(56953);
                    return 0;
                case 4:
                    bqb.wKF = aVar3.BTU.readString();
                    AppMethodBeat.o(56953);
                    return 0;
                case 5:
                    bqb.wKG = aVar3.BTU.readString();
                    AppMethodBeat.o(56953);
                    return 0;
                case 6:
                    bqb.wKx = aVar3.BTU.emu();
                    AppMethodBeat.o(56953);
                    return 0;
                case 7:
                    bqb.wKz = aVar3.BTU.vd();
                    AppMethodBeat.o(56953);
                    return 0;
                case 8:
                    bqb.nSb = aVar3.BTU.vd();
                    AppMethodBeat.o(56953);
                    return 0;
                case 9:
                    bqb.wKH = aVar3.BTU.vd();
                    AppMethodBeat.o(56953);
                    return 0;
                case 10:
                    bqb.nSc = aVar3.BTU.vd();
                    AppMethodBeat.o(56953);
                    return 0;
                case 11:
                    bqb.kfM = aVar3.BTU.readString();
                    AppMethodBeat.o(56953);
                    return 0;
                case 12:
                    bqb.wKJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56953);
                    return 0;
                case 13:
                    bqb.wKE = aVar3.BTU.readString();
                    AppMethodBeat.o(56953);
                    return 0;
                default:
                    AppMethodBeat.o(56953);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56953);
            return -1;
        }
    }
}
