package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cck extends btd {
    public int jCt;
    public String ptv;
    public int ptw;
    public int ptx;
    public long vQE;
    public int wFB;
    public LinkedList<caq> wFC = new LinkedList();
    public caq xbP;

    public cck() {
        AppMethodBeat.i(94621);
        AppMethodBeat.o(94621);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94622);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94622);
                throw bVar;
            } else if (this.xbP == null) {
                bVar = new b("Not all required fields were included: BufferUrl");
                AppMethodBeat.o(94622);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.ptx);
                aVar.iz(3, this.ptw);
                if (this.ptv != null) {
                    aVar.e(4, this.ptv);
                }
                if (this.xbP != null) {
                    aVar.iy(5, this.xbP.computeSize());
                    this.xbP.writeFields(aVar);
                }
                aVar.iz(6, this.wFB);
                aVar.e(7, 8, this.wFC);
                aVar.ai(8, this.vQE);
                aVar.iz(9, this.jCt);
                AppMethodBeat.o(94622);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(4, this.ptv);
            }
            if (this.xbP != null) {
                ix += e.a.a.a.ix(5, this.xbP.computeSize());
            }
            int bs = (((ix + e.a.a.b.b.a.bs(6, this.wFB)) + e.a.a.a.c(7, 8, this.wFC)) + e.a.a.b.b.a.o(8, this.vQE)) + e.a.a.b.b.a.bs(9, this.jCt);
            AppMethodBeat.o(94622);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94622);
                throw bVar;
            } else if (this.xbP == null) {
                bVar = new b("Not all required fields were included: BufferUrl");
                AppMethodBeat.o(94622);
                throw bVar;
            } else {
                AppMethodBeat.o(94622);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cck cck = (cck) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            caq caq;
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
                        cck.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94622);
                    return 0;
                case 2:
                    cck.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(94622);
                    return 0;
                case 3:
                    cck.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(94622);
                    return 0;
                case 4:
                    cck.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94622);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caq = new caq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caq.populateBuilderWithField(aVar4, caq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cck.xbP = caq;
                    }
                    AppMethodBeat.o(94622);
                    return 0;
                case 6:
                    cck.wFB = aVar3.BTU.vd();
                    AppMethodBeat.o(94622);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caq = new caq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caq.populateBuilderWithField(aVar4, caq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cck.wFC.add(caq);
                    }
                    AppMethodBeat.o(94622);
                    return 0;
                case 8:
                    cck.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(94622);
                    return 0;
                case 9:
                    cck.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94622);
                    return 0;
                default:
                    AppMethodBeat.o(94622);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94622);
            return -1;
        }
    }
}
