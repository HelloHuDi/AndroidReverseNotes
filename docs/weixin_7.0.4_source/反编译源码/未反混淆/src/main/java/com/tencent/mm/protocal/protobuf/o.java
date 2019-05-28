package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class o extends btd {
    public String cJF;
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public String nYX;
    public String pPw;
    public a vAf;
    public String vAg;
    public String vzN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56683);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56683);
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
            if (this.nYX != null) {
                aVar.e(4, this.nYX);
            }
            if (this.cJF != null) {
                aVar.e(5, this.cJF);
            }
            if (this.pPw != null) {
                aVar.e(7, this.pPw);
            }
            if (this.vzN != null) {
                aVar.e(8, this.vzN);
            }
            if (this.vAf != null) {
                aVar.iy(9, this.vAf.computeSize());
                this.vAf.writeFields(aVar);
            }
            if (this.vAg != null) {
                aVar.e(10, this.vAg);
            }
            AppMethodBeat.o(56683);
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
            if (this.nYX != null) {
                ix += e.a.a.b.b.a.f(4, this.nYX);
            }
            if (this.cJF != null) {
                ix += e.a.a.b.b.a.f(5, this.cJF);
            }
            if (this.pPw != null) {
                ix += e.a.a.b.b.a.f(7, this.pPw);
            }
            if (this.vzN != null) {
                ix += e.a.a.b.b.a.f(8, this.vzN);
            }
            if (this.vAf != null) {
                ix += e.a.a.a.ix(9, this.vAf.computeSize());
            }
            if (this.vAg != null) {
                ix += e.a.a.b.b.a.f(10, this.vAg);
            }
            AppMethodBeat.o(56683);
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
                AppMethodBeat.o(56683);
                throw bVar;
            }
            AppMethodBeat.o(56683);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        oVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56683);
                    return 0;
                case 2:
                    oVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56683);
                    return 0;
                case 3:
                    oVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56683);
                    return 0;
                case 4:
                    oVar.nYX = aVar3.BTU.readString();
                    AppMethodBeat.o(56683);
                    return 0;
                case 5:
                    oVar.cJF = aVar3.BTU.readString();
                    AppMethodBeat.o(56683);
                    return 0;
                case 7:
                    oVar.pPw = aVar3.BTU.readString();
                    AppMethodBeat.o(56683);
                    return 0;
                case 8:
                    oVar.vzN = aVar3.BTU.readString();
                    AppMethodBeat.o(56683);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.populateBuilderWithField(aVar4, aVar5, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        oVar.vAf = aVar5;
                    }
                    AppMethodBeat.o(56683);
                    return 0;
                case 10:
                    oVar.vAg = aVar3.BTU.readString();
                    AppMethodBeat.o(56683);
                    return 0;
                default:
                    AppMethodBeat.o(56683);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56683);
            return -1;
        }
    }
}
