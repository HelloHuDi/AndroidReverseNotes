package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cvk extends btd {
    public int vOq;
    public String vOy;
    public int wCB;
    public int wXX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124388);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vOy == null) {
                bVar = new b("Not all required fields were included: Json");
                AppMethodBeat.o(124388);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wCB);
            aVar.iz(3, this.vOq);
            if (this.vOy != null) {
                aVar.e(4, this.vOy);
            }
            aVar.iz(5, this.wXX);
            AppMethodBeat.o(124388);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wCB)) + e.a.a.b.b.a.bs(3, this.vOq);
            if (this.vOy != null) {
                ix += e.a.a.b.b.a.f(4, this.vOy);
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.wXX);
            AppMethodBeat.o(124388);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vOy == null) {
                bVar = new b("Not all required fields were included: Json");
                AppMethodBeat.o(124388);
                throw bVar;
            }
            AppMethodBeat.o(124388);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvk cvk = (cvk) objArr[1];
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
                        cvk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124388);
                    return 0;
                case 2:
                    cvk.wCB = aVar3.BTU.vd();
                    AppMethodBeat.o(124388);
                    return 0;
                case 3:
                    cvk.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124388);
                    return 0;
                case 4:
                    cvk.vOy = aVar3.BTU.readString();
                    AppMethodBeat.o(124388);
                    return 0;
                case 5:
                    cvk.wXX = aVar3.BTU.vd();
                    AppMethodBeat.o(124388);
                    return 0;
                default:
                    AppMethodBeat.o(124388);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124388);
            return -1;
        }
    }
}
