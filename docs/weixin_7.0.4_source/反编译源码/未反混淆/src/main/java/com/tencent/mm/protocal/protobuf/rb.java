package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rb extends btd {
    public int kdT;
    public String kdU;
    public ask vYe;
    public LinkedList<asj> vYf = new LinkedList();
    public String vYg;

    public rb() {
        AppMethodBeat.i(48817);
        AppMethodBeat.o(48817);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48818);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48818);
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
            if (this.vYe != null) {
                aVar.iy(4, this.vYe.computeSize());
                this.vYe.writeFields(aVar);
            }
            aVar.e(5, 8, this.vYf);
            if (this.vYg != null) {
                aVar.e(6, this.vYg);
            }
            AppMethodBeat.o(48818);
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
            if (this.vYe != null) {
                ix += e.a.a.a.ix(4, this.vYe.computeSize());
            }
            ix += e.a.a.a.c(5, 8, this.vYf);
            if (this.vYg != null) {
                ix += e.a.a.b.b.a.f(6, this.vYg);
            }
            AppMethodBeat.o(48818);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vYf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48818);
                throw bVar;
            }
            AppMethodBeat.o(48818);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rb rbVar = (rb) objArr[1];
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
                        rbVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48818);
                    return 0;
                case 2:
                    rbVar.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48818);
                    return 0;
                case 3:
                    rbVar.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48818);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ask ask = new ask();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ask.populateBuilderWithField(aVar4, ask, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rbVar.vYe = ask;
                    }
                    AppMethodBeat.o(48818);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asj asj = new asj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asj.populateBuilderWithField(aVar4, asj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rbVar.vYf.add(asj);
                    }
                    AppMethodBeat.o(48818);
                    return 0;
                case 6:
                    rbVar.vYg = aVar3.BTU.readString();
                    AppMethodBeat.o(48818);
                    return 0;
                default:
                    AppMethodBeat.o(48818);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48818);
            return -1;
        }
    }
}
