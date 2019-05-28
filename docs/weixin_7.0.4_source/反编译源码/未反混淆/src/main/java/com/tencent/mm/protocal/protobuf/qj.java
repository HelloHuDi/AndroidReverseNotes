package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class qj extends btd {
    public int kCl;
    public String kCm;
    public String pMd;
    public String pMe;
    public String pMf;
    public String vHu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48815);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48815);
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
            if (this.pMd != null) {
                aVar.e(4, this.pMd);
            }
            if (this.pMe != null) {
                aVar.e(5, this.pMe);
            }
            if (this.pMf != null) {
                aVar.e(6, this.pMf);
            }
            if (this.vHu != null) {
                aVar.e(7, this.vHu);
            }
            AppMethodBeat.o(48815);
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
            if (this.pMd != null) {
                ix += e.a.a.b.b.a.f(4, this.pMd);
            }
            if (this.pMe != null) {
                ix += e.a.a.b.b.a.f(5, this.pMe);
            }
            if (this.pMf != null) {
                ix += e.a.a.b.b.a.f(6, this.pMf);
            }
            if (this.vHu != null) {
                ix += e.a.a.b.b.a.f(7, this.vHu);
            }
            AppMethodBeat.o(48815);
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
                AppMethodBeat.o(48815);
                throw bVar;
            }
            AppMethodBeat.o(48815);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qj qjVar = (qj) objArr[1];
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
                        qjVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48815);
                    return 0;
                case 2:
                    qjVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48815);
                    return 0;
                case 3:
                    qjVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48815);
                    return 0;
                case 4:
                    qjVar.pMd = aVar3.BTU.readString();
                    AppMethodBeat.o(48815);
                    return 0;
                case 5:
                    qjVar.pMe = aVar3.BTU.readString();
                    AppMethodBeat.o(48815);
                    return 0;
                case 6:
                    qjVar.pMf = aVar3.BTU.readString();
                    AppMethodBeat.o(48815);
                    return 0;
                case 7:
                    qjVar.vHu = aVar3.BTU.readString();
                    AppMethodBeat.o(48815);
                    return 0;
                default:
                    AppMethodBeat.o(48815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48815);
            return -1;
        }
    }
}
