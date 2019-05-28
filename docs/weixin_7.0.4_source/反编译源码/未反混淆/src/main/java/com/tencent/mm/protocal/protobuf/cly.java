package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cly extends btd {
    public int fJT;
    public String ndF;
    public String ndG;
    public int pcX;
    public int ptD;
    public long ptF;
    public String vFF;
    public int vOq;
    public int wdn;
    public int wdp;
    public int wdq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116812);
        b bVar;
        int f;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(116812);
                throw bVar;
            }
            if (this.ndG != null) {
                aVar.e(1, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(2, this.ndF);
            }
            aVar.iz(3, this.vOq);
            aVar.iz(4, this.wdn);
            aVar.iz(5, this.pcX);
            if (this.vFF != null) {
                aVar.e(6, this.vFF);
            }
            aVar.iz(7, this.ptD);
            aVar.iz(8, this.wdp);
            aVar.iz(9, this.fJT);
            if (this.BaseResponse != null) {
                aVar.iy(10, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(11, this.wdq);
            aVar.ai(12, this.ptF);
            AppMethodBeat.o(116812);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = e.a.a.b.b.a.f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndF != null) {
                f += e.a.a.b.b.a.f(2, this.ndF);
            }
            f = ((f + e.a.a.b.b.a.bs(3, this.vOq)) + e.a.a.b.b.a.bs(4, this.wdn)) + e.a.a.b.b.a.bs(5, this.pcX);
            if (this.vFF != null) {
                f += e.a.a.b.b.a.f(6, this.vFF);
            }
            f = ((f + e.a.a.b.b.a.bs(7, this.ptD)) + e.a.a.b.b.a.bs(8, this.wdp)) + e.a.a.b.b.a.bs(9, this.fJT);
            if (this.BaseResponse != null) {
                f += e.a.a.a.ix(10, this.BaseResponse.computeSize());
            }
            int bs = (f + e.a.a.b.b.a.bs(11, this.wdq)) + e.a.a.b.b.a.o(12, this.ptF);
            AppMethodBeat.o(116812);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(116812);
                throw bVar;
            }
            AppMethodBeat.o(116812);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cly cly = (cly) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cly.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(116812);
                    return 0;
                case 2:
                    cly.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(116812);
                    return 0;
                case 3:
                    cly.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 4:
                    cly.wdn = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 5:
                    cly.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 6:
                    cly.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(116812);
                    return 0;
                case 7:
                    cly.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 8:
                    cly.wdp = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 9:
                    cly.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 10:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cly.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(116812);
                    return 0;
                case 11:
                    cly.wdq = aVar3.BTU.vd();
                    AppMethodBeat.o(116812);
                    return 0;
                case 12:
                    cly.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(116812);
                    return 0;
                default:
                    AppMethodBeat.o(116812);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116812);
            return -1;
        }
    }
}
