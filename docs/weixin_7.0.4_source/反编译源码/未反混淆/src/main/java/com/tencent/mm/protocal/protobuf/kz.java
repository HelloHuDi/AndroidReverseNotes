package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class kz extends btd {
    public int fJT;
    public int jCt;
    public int vOn;
    public int vOr;
    public String vOt;
    public float vOu;
    public float vOv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11724);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(11724);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.vOn);
            aVar.iz(3, this.jCt);
            if (this.vOt != null) {
                aVar.e(4, this.vOt);
            }
            aVar.iz(5, this.fJT);
            aVar.iz(6, this.vOr);
            aVar.r(7, this.vOu);
            aVar.r(8, this.vOv);
            AppMethodBeat.o(11724);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vOn)) + e.a.a.b.b.a.bs(3, this.jCt);
            if (this.vOt != null) {
                ix += e.a.a.b.b.a.f(4, this.vOt);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(5, this.fJT)) + e.a.a.b.b.a.bs(6, this.vOr)) + (e.a.a.b.b.a.fv(7) + 4)) + (e.a.a.b.b.a.fv(8) + 4);
            AppMethodBeat.o(11724);
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
                AppMethodBeat.o(11724);
                throw bVar;
            }
            AppMethodBeat.o(11724);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kz kzVar = (kz) objArr[1];
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
                        kzVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(11724);
                    return 0;
                case 2:
                    kzVar.vOn = aVar3.BTU.vd();
                    AppMethodBeat.o(11724);
                    return 0;
                case 3:
                    kzVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(11724);
                    return 0;
                case 4:
                    kzVar.vOt = aVar3.BTU.readString();
                    AppMethodBeat.o(11724);
                    return 0;
                case 5:
                    kzVar.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(11724);
                    return 0;
                case 6:
                    kzVar.vOr = aVar3.BTU.vd();
                    AppMethodBeat.o(11724);
                    return 0;
                case 7:
                    kzVar.vOu = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(11724);
                    return 0;
                case 8:
                    kzVar.vOv = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(11724);
                    return 0;
                default:
                    AppMethodBeat.o(11724);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11724);
            return -1;
        }
    }
}
