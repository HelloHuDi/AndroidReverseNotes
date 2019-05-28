package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aag extends btd {
    public int lSN;
    public String lSO;
    public LinkedList<axh> vWz = new LinkedList();
    public blr wfp;
    public String wfq;
    public String wfr;
    public String wfs;
    public String wft;
    public float wfu;
    public String wfv;

    public aag() {
        AppMethodBeat.i(839);
        AppMethodBeat.o(839);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(840);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(840);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.vWz);
            if (this.wfp != null) {
                aVar.iy(3, this.wfp.computeSize());
                this.wfp.writeFields(aVar);
            }
            if (this.wfq != null) {
                aVar.e(4, this.wfq);
            }
            if (this.wfr != null) {
                aVar.e(5, this.wfr);
            }
            if (this.wfs != null) {
                aVar.e(6, this.wfs);
            }
            if (this.wft != null) {
                aVar.e(7, this.wft);
            }
            aVar.r(8, this.wfu);
            aVar.iz(9, this.lSN);
            if (this.lSO != null) {
                aVar.e(10, this.lSO);
            }
            if (this.wfv != null) {
                aVar.e(11, this.wfv);
            }
            AppMethodBeat.o(840);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.vWz);
            if (this.wfp != null) {
                ix += e.a.a.a.ix(3, this.wfp.computeSize());
            }
            if (this.wfq != null) {
                ix += e.a.a.b.b.a.f(4, this.wfq);
            }
            if (this.wfr != null) {
                ix += e.a.a.b.b.a.f(5, this.wfr);
            }
            if (this.wfs != null) {
                ix += e.a.a.b.b.a.f(6, this.wfs);
            }
            if (this.wft != null) {
                ix += e.a.a.b.b.a.f(7, this.wft);
            }
            ix = (ix + (e.a.a.b.b.a.fv(8) + 4)) + e.a.a.b.b.a.bs(9, this.lSN);
            if (this.lSO != null) {
                ix += e.a.a.b.b.a.f(10, this.lSO);
            }
            if (this.wfv != null) {
                ix += e.a.a.b.b.a.f(11, this.wfv);
            }
            AppMethodBeat.o(840);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(840);
                throw bVar;
            }
            AppMethodBeat.o(840);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aag aag = (aag) objArr[1];
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
                        aag.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(840);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axh axh = new axh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axh.populateBuilderWithField(aVar4, axh, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aag.vWz.add(axh);
                    }
                    AppMethodBeat.o(840);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blr blr = new blr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blr.populateBuilderWithField(aVar4, blr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aag.wfp = blr;
                    }
                    AppMethodBeat.o(840);
                    return 0;
                case 4:
                    aag.wfq = aVar3.BTU.readString();
                    AppMethodBeat.o(840);
                    return 0;
                case 5:
                    aag.wfr = aVar3.BTU.readString();
                    AppMethodBeat.o(840);
                    return 0;
                case 6:
                    aag.wfs = aVar3.BTU.readString();
                    AppMethodBeat.o(840);
                    return 0;
                case 7:
                    aag.wft = aVar3.BTU.readString();
                    AppMethodBeat.o(840);
                    return 0;
                case 8:
                    aag.wfu = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(840);
                    return 0;
                case 9:
                    aag.lSN = aVar3.BTU.vd();
                    AppMethodBeat.o(840);
                    return 0;
                case 10:
                    aag.lSO = aVar3.BTU.readString();
                    AppMethodBeat.o(840);
                    return 0;
                case 11:
                    aag.wfv = aVar3.BTU.readString();
                    AppMethodBeat.o(840);
                    return 0;
                default:
                    AppMethodBeat.o(840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(840);
            return -1;
        }
    }
}
