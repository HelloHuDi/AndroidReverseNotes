package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agw extends btd {
    public String kdS;
    public String wno;
    public ol wnp;
    public int wnq;
    public bvx wnr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89090);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89090);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.kdS != null) {
                aVar.e(2, this.kdS);
            }
            if (this.wno != null) {
                aVar.e(3, this.wno);
            }
            if (this.wnp != null) {
                aVar.iy(4, this.wnp.computeSize());
                this.wnp.writeFields(aVar);
            }
            aVar.iz(5, this.wnq);
            if (this.wnr != null) {
                aVar.iy(6, this.wnr.computeSize());
                this.wnr.writeFields(aVar);
            }
            AppMethodBeat.o(89090);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kdS != null) {
                ix += e.a.a.b.b.a.f(2, this.kdS);
            }
            if (this.wno != null) {
                ix += e.a.a.b.b.a.f(3, this.wno);
            }
            if (this.wnp != null) {
                ix += e.a.a.a.ix(4, this.wnp.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.wnq);
            if (this.wnr != null) {
                ix += e.a.a.a.ix(6, this.wnr.computeSize());
            }
            AppMethodBeat.o(89090);
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
                AppMethodBeat.o(89090);
                throw bVar;
            }
            AppMethodBeat.o(89090);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agw agw = (agw) objArr[1];
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
                        agw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89090);
                    return 0;
                case 2:
                    agw.kdS = aVar3.BTU.readString();
                    AppMethodBeat.o(89090);
                    return 0;
                case 3:
                    agw.wno = aVar3.BTU.readString();
                    AppMethodBeat.o(89090);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ol olVar = new ol();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = olVar.populateBuilderWithField(aVar4, olVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agw.wnp = olVar;
                    }
                    AppMethodBeat.o(89090);
                    return 0;
                case 5:
                    agw.wnq = aVar3.BTU.vd();
                    AppMethodBeat.o(89090);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvx bvx = new bvx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvx.populateBuilderWithField(aVar4, bvx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agw.wnr = bvx;
                    }
                    AppMethodBeat.o(89090);
                    return 0;
                default:
                    AppMethodBeat.o(89090);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89090);
            return -1;
        }
    }
}
