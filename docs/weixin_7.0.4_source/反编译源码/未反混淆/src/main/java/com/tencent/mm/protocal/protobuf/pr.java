package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pr extends btd {
    public String desc;
    public int kCl;
    public String kCm;
    public String pPw;
    public String vWG;
    public String vWJ;
    public String vWM;
    public String vWO;
    public String vWP;
    public String vWS;
    public LinkedList<Integer> vWt = new LinkedList();
    public int vWv;

    public pr() {
        AppMethodBeat.i(48802);
        AppMethodBeat.o(48802);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48803);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48803);
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
            if (this.vWJ != null) {
                aVar.e(4, this.vWJ);
            }
            aVar.e(5, 2, this.vWt);
            if (this.desc != null) {
                aVar.e(6, this.desc);
            }
            if (this.vWS != null) {
                aVar.e(7, this.vWS);
            }
            if (this.pPw != null) {
                aVar.e(8, this.pPw);
            }
            if (this.vWM != null) {
                aVar.e(9, this.vWM);
            }
            if (this.vWO != null) {
                aVar.e(10, this.vWO);
            }
            if (this.vWP != null) {
                aVar.e(11, this.vWP);
            }
            aVar.iz(12, this.vWv);
            if (this.vWG != null) {
                aVar.e(13, this.vWG);
            }
            AppMethodBeat.o(48803);
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
            if (this.vWJ != null) {
                ix += e.a.a.b.b.a.f(4, this.vWJ);
            }
            ix += e.a.a.a.c(5, 2, this.vWt);
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(6, this.desc);
            }
            if (this.vWS != null) {
                ix += e.a.a.b.b.a.f(7, this.vWS);
            }
            if (this.pPw != null) {
                ix += e.a.a.b.b.a.f(8, this.pPw);
            }
            if (this.vWM != null) {
                ix += e.a.a.b.b.a.f(9, this.vWM);
            }
            if (this.vWO != null) {
                ix += e.a.a.b.b.a.f(10, this.vWO);
            }
            if (this.vWP != null) {
                ix += e.a.a.b.b.a.f(11, this.vWP);
            }
            ix += e.a.a.b.b.a.bs(12, this.vWv);
            if (this.vWG != null) {
                ix += e.a.a.b.b.a.f(13, this.vWG);
            }
            AppMethodBeat.o(48803);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48803);
                throw bVar;
            }
            AppMethodBeat.o(48803);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pr prVar = (pr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        prVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48803);
                    return 0;
                case 2:
                    prVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48803);
                    return 0;
                case 3:
                    prVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 4:
                    prVar.vWJ = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 5:
                    prVar.vWt.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(48803);
                    return 0;
                case 6:
                    prVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 7:
                    prVar.vWS = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 8:
                    prVar.pPw = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 9:
                    prVar.vWM = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 10:
                    prVar.vWO = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 11:
                    prVar.vWP = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                case 12:
                    prVar.vWv = aVar3.BTU.vd();
                    AppMethodBeat.o(48803);
                    return 0;
                case 13:
                    prVar.vWG = aVar3.BTU.readString();
                    AppMethodBeat.o(48803);
                    return 0;
                default:
                    AppMethodBeat.o(48803);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48803);
            return -1;
        }
    }
}
