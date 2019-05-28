package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnw extends btd {
    public int kCl;
    public String kCm;
    public String mLd;
    public int nUf;
    public String pMf;
    public String pMg;
    public int state;
    public String wQY;
    public int wQZ;
    public String wRa;
    public String wRb;
    public String wRc;
    public String wRd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48940);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48940);
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
            aVar.iz(4, this.state);
            if (this.wQY != null) {
                aVar.e(5, this.wQY);
            }
            aVar.iz(6, this.nUf);
            aVar.iz(7, this.wQZ);
            if (this.pMf != null) {
                aVar.e(8, this.pMf);
            }
            if (this.wRa != null) {
                aVar.e(9, this.wRa);
            }
            if (this.pMg != null) {
                aVar.e(10, this.pMg);
            }
            if (this.wRb != null) {
                aVar.e(11, this.wRb);
            }
            if (this.wRc != null) {
                aVar.e(12, this.wRc);
            }
            if (this.wRd != null) {
                aVar.e(14, this.wRd);
            }
            if (this.mLd != null) {
                aVar.e(15, this.mLd);
            }
            AppMethodBeat.o(48940);
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
            ix += e.a.a.b.b.a.bs(4, this.state);
            if (this.wQY != null) {
                ix += e.a.a.b.b.a.f(5, this.wQY);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.nUf)) + e.a.a.b.b.a.bs(7, this.wQZ);
            if (this.pMf != null) {
                ix += e.a.a.b.b.a.f(8, this.pMf);
            }
            if (this.wRa != null) {
                ix += e.a.a.b.b.a.f(9, this.wRa);
            }
            if (this.pMg != null) {
                ix += e.a.a.b.b.a.f(10, this.pMg);
            }
            if (this.wRb != null) {
                ix += e.a.a.b.b.a.f(11, this.wRb);
            }
            if (this.wRc != null) {
                ix += e.a.a.b.b.a.f(12, this.wRc);
            }
            if (this.wRd != null) {
                ix += e.a.a.b.b.a.f(14, this.wRd);
            }
            if (this.mLd != null) {
                ix += e.a.a.b.b.a.f(15, this.mLd);
            }
            AppMethodBeat.o(48940);
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
                AppMethodBeat.o(48940);
                throw bVar;
            }
            AppMethodBeat.o(48940);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnw bnw = (bnw) objArr[1];
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
                        bnw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48940);
                    return 0;
                case 2:
                    bnw.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48940);
                    return 0;
                case 3:
                    bnw.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 4:
                    bnw.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48940);
                    return 0;
                case 5:
                    bnw.wQY = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 6:
                    bnw.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(48940);
                    return 0;
                case 7:
                    bnw.wQZ = aVar3.BTU.vd();
                    AppMethodBeat.o(48940);
                    return 0;
                case 8:
                    bnw.pMf = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 9:
                    bnw.wRa = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 10:
                    bnw.pMg = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 11:
                    bnw.wRb = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 12:
                    bnw.wRc = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 14:
                    bnw.wRd = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                case 15:
                    bnw.mLd = aVar3.BTU.readString();
                    AppMethodBeat.o(48940);
                    return 0;
                default:
                    AppMethodBeat.o(48940);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48940);
            return -1;
        }
    }
}
