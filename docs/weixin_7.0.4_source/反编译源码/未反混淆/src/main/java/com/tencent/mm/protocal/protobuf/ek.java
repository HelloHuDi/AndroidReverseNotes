package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ek extends btd {
    public String fgd;
    public String url;
    public LinkedList<ew> vGg = new LinkedList();
    public int vGh;
    public String vGi;
    public int vGj;
    public int vGk;
    public int vGl;
    public dw vGm;
    public cns vGn;
    public String vGo;
    public bac vGp;
    public eg vGq;

    public ek() {
        AppMethodBeat.i(14694);
        AppMethodBeat.o(14694);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14695);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14695);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.vGg);
            aVar.iz(3, this.vGh);
            if (this.vGi != null) {
                aVar.e(4, this.vGi);
            }
            aVar.iz(5, this.vGj);
            aVar.iz(6, this.vGk);
            aVar.iz(7, this.vGl);
            if (this.vGm != null) {
                aVar.iy(8, this.vGm.computeSize());
                this.vGm.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(9, this.url);
            }
            if (this.fgd != null) {
                aVar.e(10, this.fgd);
            }
            if (this.vGn != null) {
                aVar.iy(11, this.vGn.computeSize());
                this.vGn.writeFields(aVar);
            }
            if (this.vGo != null) {
                aVar.e(12, this.vGo);
            }
            if (this.vGp != null) {
                aVar.iy(13, this.vGp.computeSize());
                this.vGp.writeFields(aVar);
            }
            if (this.vGq != null) {
                aVar.iy(14, this.vGq.computeSize());
                this.vGq.writeFields(aVar);
            }
            AppMethodBeat.o(14695);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 8, this.vGg)) + e.a.a.b.b.a.bs(3, this.vGh);
            if (this.vGi != null) {
                ix += e.a.a.b.b.a.f(4, this.vGi);
            }
            ix = ((ix + e.a.a.b.b.a.bs(5, this.vGj)) + e.a.a.b.b.a.bs(6, this.vGk)) + e.a.a.b.b.a.bs(7, this.vGl);
            if (this.vGm != null) {
                ix += e.a.a.a.ix(8, this.vGm.computeSize());
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(9, this.url);
            }
            if (this.fgd != null) {
                ix += e.a.a.b.b.a.f(10, this.fgd);
            }
            if (this.vGn != null) {
                ix += e.a.a.a.ix(11, this.vGn.computeSize());
            }
            if (this.vGo != null) {
                ix += e.a.a.b.b.a.f(12, this.vGo);
            }
            if (this.vGp != null) {
                ix += e.a.a.a.ix(13, this.vGp.computeSize());
            }
            if (this.vGq != null) {
                ix += e.a.a.a.ix(14, this.vGq.computeSize());
            }
            AppMethodBeat.o(14695);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vGg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14695);
                throw bVar;
            }
            AppMethodBeat.o(14695);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ek ekVar = (ek) objArr[1];
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
                        ekVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(14695);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ew ewVar = new ew();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ewVar.populateBuilderWithField(aVar4, ewVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ekVar.vGg.add(ewVar);
                    }
                    AppMethodBeat.o(14695);
                    return 0;
                case 3:
                    ekVar.vGh = aVar3.BTU.vd();
                    AppMethodBeat.o(14695);
                    return 0;
                case 4:
                    ekVar.vGi = aVar3.BTU.readString();
                    AppMethodBeat.o(14695);
                    return 0;
                case 5:
                    ekVar.vGj = aVar3.BTU.vd();
                    AppMethodBeat.o(14695);
                    return 0;
                case 6:
                    ekVar.vGk = aVar3.BTU.vd();
                    AppMethodBeat.o(14695);
                    return 0;
                case 7:
                    ekVar.vGl = aVar3.BTU.vd();
                    AppMethodBeat.o(14695);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dw dwVar = new dw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dwVar.populateBuilderWithField(aVar4, dwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ekVar.vGm = dwVar;
                    }
                    AppMethodBeat.o(14695);
                    return 0;
                case 9:
                    ekVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(14695);
                    return 0;
                case 10:
                    ekVar.fgd = aVar3.BTU.readString();
                    AppMethodBeat.o(14695);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cns cns = new cns();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cns.populateBuilderWithField(aVar4, cns, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ekVar.vGn = cns;
                    }
                    AppMethodBeat.o(14695);
                    return 0;
                case 12:
                    ekVar.vGo = aVar3.BTU.readString();
                    AppMethodBeat.o(14695);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bac bac = new bac();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bac.populateBuilderWithField(aVar4, bac, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ekVar.vGp = bac;
                    }
                    AppMethodBeat.o(14695);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        eg egVar = new eg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = egVar.populateBuilderWithField(aVar4, egVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ekVar.vGq = egVar;
                    }
                    AppMethodBeat.o(14695);
                    return 0;
                default:
                    AppMethodBeat.o(14695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14695);
            return -1;
        }
    }
}
