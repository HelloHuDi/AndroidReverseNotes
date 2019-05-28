package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agi extends btd {
    public int kdT;
    public String kdU;
    public boolean wne;
    public int wnf;
    public int wng;
    public ny wnh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89074);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89074);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            aVar.aO(4, this.wne);
            aVar.iz(5, this.wnf);
            aVar.iz(6, this.wng);
            if (this.wnh != null) {
                aVar.iy(7, this.wnh.computeSize());
                this.wnh.writeFields(aVar);
            }
            AppMethodBeat.o(89074);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            ix = ((ix + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.b.b.a.bs(5, this.wnf)) + e.a.a.b.b.a.bs(6, this.wng);
            if (this.wnh != null) {
                ix += e.a.a.a.ix(7, this.wnh.computeSize());
            }
            AppMethodBeat.o(89074);
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
                AppMethodBeat.o(89074);
                throw bVar;
            }
            AppMethodBeat.o(89074);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agi agi = (agi) objArr[1];
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
                        agi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89074);
                    return 0;
                case 2:
                    agi.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(89074);
                    return 0;
                case 3:
                    agi.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(89074);
                    return 0;
                case 4:
                    agi.wne = aVar3.BTU.ehX();
                    AppMethodBeat.o(89074);
                    return 0;
                case 5:
                    agi.wnf = aVar3.BTU.vd();
                    AppMethodBeat.o(89074);
                    return 0;
                case 6:
                    agi.wng = aVar3.BTU.vd();
                    AppMethodBeat.o(89074);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agi.wnh = nyVar;
                    }
                    AppMethodBeat.o(89074);
                    return 0;
                default:
                    AppMethodBeat.o(89074);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89074);
            return -1;
        }
    }
}
