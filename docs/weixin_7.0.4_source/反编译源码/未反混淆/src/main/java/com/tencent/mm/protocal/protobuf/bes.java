package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bes extends btd {
    public String fhH;
    public String vGi;
    public LinkedList<bew> wIK = new LinkedList();
    public String wIL;
    public boolean wIM;
    public boolean wIN;
    public boolean wIO;

    public bes() {
        AppMethodBeat.i(10224);
        AppMethodBeat.o(10224);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10225);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10225);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(3, 8, this.wIK);
            if (this.fhH != null) {
                aVar.e(4, this.fhH);
            }
            if (this.wIL != null) {
                aVar.e(5, this.wIL);
            }
            if (this.vGi != null) {
                aVar.e(6, this.vGi);
            }
            aVar.aO(8, this.wIM);
            aVar.aO(9, this.wIN);
            aVar.aO(10, this.wIO);
            AppMethodBeat.o(10225);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(3, 8, this.wIK);
            if (this.fhH != null) {
                ix += e.a.a.b.b.a.f(4, this.fhH);
            }
            if (this.wIL != null) {
                ix += e.a.a.b.b.a.f(5, this.wIL);
            }
            if (this.vGi != null) {
                ix += e.a.a.b.b.a.f(6, this.vGi);
            }
            int fv = ((ix + (e.a.a.b.b.a.fv(8) + 1)) + (e.a.a.b.b.a.fv(9) + 1)) + (e.a.a.b.b.a.fv(10) + 1);
            AppMethodBeat.o(10225);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10225);
                throw bVar;
            }
            AppMethodBeat.o(10225);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bes bes = (bes) objArr[1];
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
                        bes.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10225);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bew bew = new bew();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bew.populateBuilderWithField(aVar4, bew, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bes.wIK.add(bew);
                    }
                    AppMethodBeat.o(10225);
                    return 0;
                case 4:
                    bes.fhH = aVar3.BTU.readString();
                    AppMethodBeat.o(10225);
                    return 0;
                case 5:
                    bes.wIL = aVar3.BTU.readString();
                    AppMethodBeat.o(10225);
                    return 0;
                case 6:
                    bes.vGi = aVar3.BTU.readString();
                    AppMethodBeat.o(10225);
                    return 0;
                case 8:
                    bes.wIM = aVar3.BTU.ehX();
                    AppMethodBeat.o(10225);
                    return 0;
                case 9:
                    bes.wIN = aVar3.BTU.ehX();
                    AppMethodBeat.o(10225);
                    return 0;
                case 10:
                    bes.wIO = aVar3.BTU.ehX();
                    AppMethodBeat.o(10225);
                    return 0;
                default:
                    AppMethodBeat.o(10225);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10225);
            return -1;
        }
    }
}
