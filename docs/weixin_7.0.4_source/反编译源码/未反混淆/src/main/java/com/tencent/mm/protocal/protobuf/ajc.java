package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajc extends btd {
    public int OpCode;
    public String woW;
    public mk woX;
    public long woY;
    public cm woZ;
    public int wpa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(59564);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(59564);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            aVar.ai(3, this.woY);
            if (this.woZ != null) {
                aVar.iy(4, this.woZ.computeSize());
                this.woZ.writeFields(aVar);
            }
            if (this.woW != null) {
                aVar.e(5, this.woW);
            }
            aVar.iz(6, this.wpa);
            if (this.woX != null) {
                aVar.iy(7, this.woX.computeSize());
                this.woX.writeFields(aVar);
            }
            AppMethodBeat.o(59564);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.OpCode)) + e.a.a.b.b.a.o(3, this.woY);
            if (this.woZ != null) {
                ix += e.a.a.a.ix(4, this.woZ.computeSize());
            }
            if (this.woW != null) {
                ix += e.a.a.b.b.a.f(5, this.woW);
            }
            ix += e.a.a.b.b.a.bs(6, this.wpa);
            if (this.woX != null) {
                ix += e.a.a.a.ix(7, this.woX.computeSize());
            }
            AppMethodBeat.o(59564);
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
                AppMethodBeat.o(59564);
                throw bVar;
            }
            AppMethodBeat.o(59564);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajc ajc = (ajc) objArr[1];
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
                        ajc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(59564);
                    return 0;
                case 2:
                    ajc.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(59564);
                    return 0;
                case 3:
                    ajc.woY = aVar3.BTU.ve();
                    AppMethodBeat.o(59564);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cm cmVar = new cm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.populateBuilderWithField(aVar4, cmVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajc.woZ = cmVar;
                    }
                    AppMethodBeat.o(59564);
                    return 0;
                case 5:
                    ajc.woW = aVar3.BTU.readString();
                    AppMethodBeat.o(59564);
                    return 0;
                case 6:
                    ajc.wpa = aVar3.BTU.vd();
                    AppMethodBeat.o(59564);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mk mkVar = new mk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mkVar.populateBuilderWithField(aVar4, mkVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajc.woX = mkVar;
                    }
                    AppMethodBeat.o(59564);
                    return 0;
                default:
                    AppMethodBeat.o(59564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(59564);
            return -1;
        }
    }
}
