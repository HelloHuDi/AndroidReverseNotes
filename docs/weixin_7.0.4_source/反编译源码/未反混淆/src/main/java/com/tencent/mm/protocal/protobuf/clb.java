package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class clb extends btd {
    public int ptw;
    public int ptx;
    public String vXm;
    public String vXn;
    public String xiL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80202);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80202);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.ptw);
            aVar.iz(3, this.ptx);
            if (this.xiL != null) {
                aVar.e(4, this.xiL);
            }
            if (this.vXm != null) {
                aVar.e(5, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(6, this.vXn);
            }
            AppMethodBeat.o(80202);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ptw)) + e.a.a.b.b.a.bs(3, this.ptx);
            if (this.xiL != null) {
                ix += e.a.a.b.b.a.f(4, this.xiL);
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(5, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(6, this.vXn);
            }
            AppMethodBeat.o(80202);
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
                AppMethodBeat.o(80202);
                throw bVar;
            }
            AppMethodBeat.o(80202);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clb clb = (clb) objArr[1];
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
                        clb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80202);
                    return 0;
                case 2:
                    clb.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80202);
                    return 0;
                case 3:
                    clb.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80202);
                    return 0;
                case 4:
                    clb.xiL = aVar3.BTU.readString();
                    AppMethodBeat.o(80202);
                    return 0;
                case 5:
                    clb.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(80202);
                    return 0;
                case 6:
                    clb.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(80202);
                    return 0;
                default:
                    AppMethodBeat.o(80202);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80202);
            return -1;
        }
    }
}
