package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnf extends btd {
    public int kdT;
    public String kdU;
    public String twd;
    public bks vLc;
    public String wQc;
    public LinkedList<hb> wQd = new LinkedList();

    public bnf() {
        AppMethodBeat.i(48928);
        AppMethodBeat.o(48928);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48929);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48929);
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
            if (this.wQc != null) {
                aVar.e(4, this.wQc);
            }
            aVar.e(5, 8, this.wQd);
            if (this.vLc != null) {
                aVar.iy(6, this.vLc.computeSize());
                this.vLc.writeFields(aVar);
            }
            if (this.twd != null) {
                aVar.e(7, this.twd);
            }
            AppMethodBeat.o(48929);
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
            if (this.wQc != null) {
                ix += e.a.a.b.b.a.f(4, this.wQc);
            }
            ix += e.a.a.a.c(5, 8, this.wQd);
            if (this.vLc != null) {
                ix += e.a.a.a.ix(6, this.vLc.computeSize());
            }
            if (this.twd != null) {
                ix += e.a.a.b.b.a.f(7, this.twd);
            }
            AppMethodBeat.o(48929);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wQd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48929);
                throw bVar;
            }
            AppMethodBeat.o(48929);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnf bnf = (bnf) objArr[1];
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
                        bnf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48929);
                    return 0;
                case 2:
                    bnf.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48929);
                    return 0;
                case 3:
                    bnf.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48929);
                    return 0;
                case 4:
                    bnf.wQc = aVar3.BTU.readString();
                    AppMethodBeat.o(48929);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hb hbVar = new hb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hbVar.populateBuilderWithField(aVar4, hbVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnf.wQd.add(hbVar);
                    }
                    AppMethodBeat.o(48929);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bks bks = new bks();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bks.populateBuilderWithField(aVar4, bks, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnf.vLc = bks;
                    }
                    AppMethodBeat.o(48929);
                    return 0;
                case 7:
                    bnf.twd = aVar3.BTU.readString();
                    AppMethodBeat.o(48929);
                    return 0;
                default:
                    AppMethodBeat.o(48929);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48929);
            return -1;
        }
    }
}
