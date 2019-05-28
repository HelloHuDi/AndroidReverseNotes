package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bho extends btd {
    public int kCl;
    public String kCm;
    public String kCx;
    public String kCy;
    public int wKN;
    public int wKO;
    public String wKP;
    public String wKQ;
    public int wKR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48912);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48912);
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
            aVar.iz(4, this.wKN);
            aVar.iz(5, this.wKO);
            if (this.kCx != null) {
                aVar.e(6, this.kCx);
            }
            if (this.kCy != null) {
                aVar.e(7, this.kCy);
            }
            if (this.wKP != null) {
                aVar.e(8, this.wKP);
            }
            if (this.wKQ != null) {
                aVar.e(9, this.wKQ);
            }
            aVar.iz(10, this.wKR);
            AppMethodBeat.o(48912);
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
            ix = (ix + e.a.a.b.b.a.bs(4, this.wKN)) + e.a.a.b.b.a.bs(5, this.wKO);
            if (this.kCx != null) {
                ix += e.a.a.b.b.a.f(6, this.kCx);
            }
            if (this.kCy != null) {
                ix += e.a.a.b.b.a.f(7, this.kCy);
            }
            if (this.wKP != null) {
                ix += e.a.a.b.b.a.f(8, this.wKP);
            }
            if (this.wKQ != null) {
                ix += e.a.a.b.b.a.f(9, this.wKQ);
            }
            int bs = ix + e.a.a.b.b.a.bs(10, this.wKR);
            AppMethodBeat.o(48912);
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
                AppMethodBeat.o(48912);
                throw bVar;
            }
            AppMethodBeat.o(48912);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bho bho = (bho) objArr[1];
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
                        bho.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48912);
                    return 0;
                case 2:
                    bho.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48912);
                    return 0;
                case 3:
                    bho.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48912);
                    return 0;
                case 4:
                    bho.wKN = aVar3.BTU.vd();
                    AppMethodBeat.o(48912);
                    return 0;
                case 5:
                    bho.wKO = aVar3.BTU.vd();
                    AppMethodBeat.o(48912);
                    return 0;
                case 6:
                    bho.kCx = aVar3.BTU.readString();
                    AppMethodBeat.o(48912);
                    return 0;
                case 7:
                    bho.kCy = aVar3.BTU.readString();
                    AppMethodBeat.o(48912);
                    return 0;
                case 8:
                    bho.wKP = aVar3.BTU.readString();
                    AppMethodBeat.o(48912);
                    return 0;
                case 9:
                    bho.wKQ = aVar3.BTU.readString();
                    AppMethodBeat.o(48912);
                    return 0;
                case 10:
                    bho.wKR = aVar3.BTU.vd();
                    AppMethodBeat.o(48912);
                    return 0;
                default:
                    AppMethodBeat.o(48912);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48912);
            return -1;
        }
    }
}
