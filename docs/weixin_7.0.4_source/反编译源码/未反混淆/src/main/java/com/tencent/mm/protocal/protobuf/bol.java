package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bol extends btd {
    public btr vCP;
    public cge wRp;
    public ctd wRq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48950);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48950);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wRp != null) {
                aVar.iy(2, this.wRp.computeSize());
                this.wRp.writeFields(aVar);
            }
            if (this.vCP != null) {
                aVar.iy(3, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            if (this.wRq != null) {
                aVar.iy(4, this.wRq.computeSize());
                this.wRq.writeFields(aVar);
            }
            AppMethodBeat.o(48950);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wRp != null) {
                ix += e.a.a.a.ix(2, this.wRp.computeSize());
            }
            if (this.vCP != null) {
                ix += e.a.a.a.ix(3, this.vCP.computeSize());
            }
            if (this.wRq != null) {
                ix += e.a.a.a.ix(4, this.wRq.computeSize());
            }
            AppMethodBeat.o(48950);
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
                AppMethodBeat.o(48950);
                throw bVar;
            }
            AppMethodBeat.o(48950);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bol bol = (bol) objArr[1];
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
                        bol.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48950);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cge cge = new cge();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cge.populateBuilderWithField(aVar4, cge, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bol.wRp = cge;
                    }
                    AppMethodBeat.o(48950);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bol.vCP = btr;
                    }
                    AppMethodBeat.o(48950);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ctd ctd = new ctd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ctd.populateBuilderWithField(aVar4, ctd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bol.wRq = ctd;
                    }
                    AppMethodBeat.o(48950);
                    return 0;
                default:
                    AppMethodBeat.o(48950);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48950);
            return -1;
        }
    }
}
