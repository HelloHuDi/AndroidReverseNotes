package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfg extends btd {
    public int kdT;
    public String kdU;
    public String tfp;
    public String tfq;
    public String tfr;
    public int tfs;
    public String tgu;
    public azb wJa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56867);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56867);
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
            if (this.wJa != null) {
                aVar.iy(4, this.wJa.computeSize());
                this.wJa.writeFields(aVar);
            }
            if (this.tfp != null) {
                aVar.e(5, this.tfp);
            }
            if (this.tfq != null) {
                aVar.e(6, this.tfq);
            }
            if (this.tfr != null) {
                aVar.e(7, this.tfr);
            }
            aVar.iz(8, this.tfs);
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56867);
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
            if (this.wJa != null) {
                ix += e.a.a.a.ix(4, this.wJa.computeSize());
            }
            if (this.tfp != null) {
                ix += e.a.a.b.b.a.f(5, this.tfp);
            }
            if (this.tfq != null) {
                ix += e.a.a.b.b.a.f(6, this.tfq);
            }
            if (this.tfr != null) {
                ix += e.a.a.b.b.a.f(7, this.tfr);
            }
            ix += e.a.a.b.b.a.bs(8, this.tfs);
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56867);
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
                AppMethodBeat.o(56867);
                throw bVar;
            }
            AppMethodBeat.o(56867);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfg bfg = (bfg) objArr[1];
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
                        bfg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56867);
                    return 0;
                case 2:
                    bfg.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56867);
                    return 0;
                case 3:
                    bfg.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56867);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azb azb = new azb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azb.populateBuilderWithField(aVar4, azb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfg.wJa = azb;
                    }
                    AppMethodBeat.o(56867);
                    return 0;
                case 5:
                    bfg.tfp = aVar3.BTU.readString();
                    AppMethodBeat.o(56867);
                    return 0;
                case 6:
                    bfg.tfq = aVar3.BTU.readString();
                    AppMethodBeat.o(56867);
                    return 0;
                case 7:
                    bfg.tfr = aVar3.BTU.readString();
                    AppMethodBeat.o(56867);
                    return 0;
                case 8:
                    bfg.tfs = aVar3.BTU.vd();
                    AppMethodBeat.o(56867);
                    return 0;
                case 100:
                    bfg.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56867);
                    return 0;
                default:
                    AppMethodBeat.o(56867);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56867);
            return -1;
        }
    }
}
