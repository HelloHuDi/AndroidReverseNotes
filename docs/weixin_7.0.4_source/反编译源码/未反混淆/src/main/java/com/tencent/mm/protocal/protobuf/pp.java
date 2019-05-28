package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pp extends btd {
    public String cBT;
    public int kCl;
    public String kCm;
    public int nUf;
    public String vFc;
    public String vWF;
    public String vWG;
    public String vWI;
    public String vWR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48800);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48800);
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
            if (this.cBT != null) {
                aVar.e(4, this.cBT);
            }
            if (this.vWI != null) {
                aVar.e(5, this.vWI);
            }
            if (this.vFc != null) {
                aVar.e(6, this.vFc);
            }
            aVar.iz(7, this.nUf);
            if (this.vWR != null) {
                aVar.e(8, this.vWR);
            }
            if (this.vWG != null) {
                aVar.e(9, this.vWG);
            }
            if (this.vWF != null) {
                aVar.e(10, this.vWF);
            }
            AppMethodBeat.o(48800);
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
            if (this.cBT != null) {
                ix += e.a.a.b.b.a.f(4, this.cBT);
            }
            if (this.vWI != null) {
                ix += e.a.a.b.b.a.f(5, this.vWI);
            }
            if (this.vFc != null) {
                ix += e.a.a.b.b.a.f(6, this.vFc);
            }
            ix += e.a.a.b.b.a.bs(7, this.nUf);
            if (this.vWR != null) {
                ix += e.a.a.b.b.a.f(8, this.vWR);
            }
            if (this.vWG != null) {
                ix += e.a.a.b.b.a.f(9, this.vWG);
            }
            if (this.vWF != null) {
                ix += e.a.a.b.b.a.f(10, this.vWF);
            }
            AppMethodBeat.o(48800);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48800);
                throw bVar;
            }
            AppMethodBeat.o(48800);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pp ppVar = (pp) objArr[1];
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
                        ppVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48800);
                    return 0;
                case 2:
                    ppVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48800);
                    return 0;
                case 3:
                    ppVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                case 4:
                    ppVar.cBT = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                case 5:
                    ppVar.vWI = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                case 6:
                    ppVar.vFc = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                case 7:
                    ppVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(48800);
                    return 0;
                case 8:
                    ppVar.vWR = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                case 9:
                    ppVar.vWG = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                case 10:
                    ppVar.vWF = aVar3.BTU.readString();
                    AppMethodBeat.o(48800);
                    return 0;
                default:
                    AppMethodBeat.o(48800);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48800);
            return -1;
        }
    }
}
