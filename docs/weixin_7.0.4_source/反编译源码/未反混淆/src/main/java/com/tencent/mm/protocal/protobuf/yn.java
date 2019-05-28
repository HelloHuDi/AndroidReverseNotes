package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class yn extends btd {
    public LinkedList<cgm> vEh = new LinkedList();
    public int vIN;
    public LinkedList<cgl> vIO = new LinkedList();
    public int wem;
    public long wen;
    public int weo;
    public int wep;
    public int weq;

    public yn() {
        AppMethodBeat.i(28387);
        AppMethodBeat.o(28387);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28388);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28388);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.weo);
            aVar.iz(5, this.wep);
            aVar.e(6, 8, this.vEh);
            aVar.iz(7, this.weq);
            aVar.iz(8, this.vIN);
            aVar.e(9, 8, this.vIO);
            AppMethodBeat.o(28388);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.weo)) + e.a.a.b.b.a.bs(5, this.wep)) + e.a.a.a.c(6, 8, this.vEh)) + e.a.a.b.b.a.bs(7, this.weq)) + e.a.a.b.b.a.bs(8, this.vIN)) + e.a.a.a.c(9, 8, this.vIO);
            AppMethodBeat.o(28388);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            this.vIO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28388);
                throw bVar;
            }
            AppMethodBeat.o(28388);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yn ynVar = (yn) objArr[1];
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
                        ynVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28388);
                    return 0;
                case 2:
                    ynVar.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28388);
                    return 0;
                case 3:
                    ynVar.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28388);
                    return 0;
                case 4:
                    ynVar.weo = aVar3.BTU.vd();
                    AppMethodBeat.o(28388);
                    return 0;
                case 5:
                    ynVar.wep = aVar3.BTU.vd();
                    AppMethodBeat.o(28388);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgm cgm = new cgm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgm.populateBuilderWithField(aVar4, cgm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ynVar.vEh.add(cgm);
                    }
                    AppMethodBeat.o(28388);
                    return 0;
                case 7:
                    ynVar.weq = aVar3.BTU.vd();
                    AppMethodBeat.o(28388);
                    return 0;
                case 8:
                    ynVar.vIN = aVar3.BTU.vd();
                    AppMethodBeat.o(28388);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgl cgl = new cgl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgl.populateBuilderWithField(aVar4, cgl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ynVar.vIO.add(cgl);
                    }
                    AppMethodBeat.o(28388);
                    return 0;
                default:
                    AppMethodBeat.o(28388);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28388);
            return -1;
        }
    }
}
