package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class v extends btd {
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public int state;
    public String title;
    public int type;
    public String vAg;
    public String vAk;
    public long vAl;
    public int vAm;
    public long vAn;
    public int vAo;
    public int vAp;
    public int vAq;
    public int vAr;
    public long vAs;
    public long vAt;
    public long vAu;
    public int vAv;
    public String vAw;
    public int vAx;
    public long vAy;
    public String vzL;
    public LinkedList<t> vzQ = new LinkedList();
    public int vzW;

    public v() {
        AppMethodBeat.i(56690);
        AppMethodBeat.o(56690);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56691);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56691);
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
            if (this.vzL != null) {
                aVar.e(4, this.vzL);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            aVar.iz(6, this.type);
            if (this.vAk != null) {
                aVar.e(7, this.vAk);
            }
            aVar.ai(8, this.vAl);
            aVar.iz(9, this.vAm);
            aVar.ai(10, this.vAn);
            aVar.iz(11, this.vAo);
            aVar.iz(12, this.state);
            aVar.iz(13, this.vAp);
            aVar.iz(14, this.vAq);
            aVar.iz(15, this.vzW);
            aVar.iz(16, this.vAr);
            aVar.ai(17, this.vAs);
            aVar.ai(18, this.vAt);
            aVar.ai(19, this.vAu);
            aVar.iz(20, this.vAv);
            if (this.vAg != null) {
                aVar.e(21, this.vAg);
            }
            aVar.e(22, 8, this.vzQ);
            if (this.vAw != null) {
                aVar.e(23, this.vAw);
            }
            aVar.iz(24, this.vAx);
            aVar.ai(25, this.vAy);
            AppMethodBeat.o(56691);
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
            if (this.vzL != null) {
                ix += e.a.a.b.b.a.f(4, this.vzL);
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(5, this.title);
            }
            ix += e.a.a.b.b.a.bs(6, this.type);
            if (this.vAk != null) {
                ix += e.a.a.b.b.a.f(7, this.vAk);
            }
            ix = ((((((((((((ix + e.a.a.b.b.a.o(8, this.vAl)) + e.a.a.b.b.a.bs(9, this.vAm)) + e.a.a.b.b.a.o(10, this.vAn)) + e.a.a.b.b.a.bs(11, this.vAo)) + e.a.a.b.b.a.bs(12, this.state)) + e.a.a.b.b.a.bs(13, this.vAp)) + e.a.a.b.b.a.bs(14, this.vAq)) + e.a.a.b.b.a.bs(15, this.vzW)) + e.a.a.b.b.a.bs(16, this.vAr)) + e.a.a.b.b.a.o(17, this.vAs)) + e.a.a.b.b.a.o(18, this.vAt)) + e.a.a.b.b.a.o(19, this.vAu)) + e.a.a.b.b.a.bs(20, this.vAv);
            if (this.vAg != null) {
                ix += e.a.a.b.b.a.f(21, this.vAg);
            }
            ix += e.a.a.a.c(22, 8, this.vzQ);
            if (this.vAw != null) {
                ix += e.a.a.b.b.a.f(23, this.vAw);
            }
            int bs = (ix + e.a.a.b.b.a.bs(24, this.vAx)) + e.a.a.b.b.a.o(25, this.vAy);
            AppMethodBeat.o(56691);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56691);
                throw bVar;
            }
            AppMethodBeat.o(56691);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
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
                        vVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56691);
                    return 0;
                case 2:
                    vVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 3:
                    vVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56691);
                    return 0;
                case 4:
                    vVar.vzL = aVar3.BTU.readString();
                    AppMethodBeat.o(56691);
                    return 0;
                case 5:
                    vVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56691);
                    return 0;
                case 6:
                    vVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 7:
                    vVar.vAk = aVar3.BTU.readString();
                    AppMethodBeat.o(56691);
                    return 0;
                case 8:
                    vVar.vAl = aVar3.BTU.ve();
                    AppMethodBeat.o(56691);
                    return 0;
                case 9:
                    vVar.vAm = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 10:
                    vVar.vAn = aVar3.BTU.ve();
                    AppMethodBeat.o(56691);
                    return 0;
                case 11:
                    vVar.vAo = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 12:
                    vVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 13:
                    vVar.vAp = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 14:
                    vVar.vAq = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 15:
                    vVar.vzW = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 16:
                    vVar.vAr = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 17:
                    vVar.vAs = aVar3.BTU.ve();
                    AppMethodBeat.o(56691);
                    return 0;
                case 18:
                    vVar.vAt = aVar3.BTU.ve();
                    AppMethodBeat.o(56691);
                    return 0;
                case 19:
                    vVar.vAu = aVar3.BTU.ve();
                    AppMethodBeat.o(56691);
                    return 0;
                case 20:
                    vVar.vAv = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 21:
                    vVar.vAg = aVar3.BTU.readString();
                    AppMethodBeat.o(56691);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        t tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        vVar.vzQ.add(tVar);
                    }
                    AppMethodBeat.o(56691);
                    return 0;
                case 23:
                    vVar.vAw = aVar3.BTU.readString();
                    AppMethodBeat.o(56691);
                    return 0;
                case 24:
                    vVar.vAx = aVar3.BTU.vd();
                    AppMethodBeat.o(56691);
                    return 0;
                case 25:
                    vVar.vAy = aVar3.BTU.ve();
                    AppMethodBeat.o(56691);
                    return 0;
                default:
                    AppMethodBeat.o(56691);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56691);
            return -1;
        }
    }
}
