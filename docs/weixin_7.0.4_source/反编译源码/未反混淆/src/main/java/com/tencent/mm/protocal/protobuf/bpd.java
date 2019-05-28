package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpd extends btd {
    public int OpCode;
    public int ehB;
    public LinkedList<bpb> vEh = new LinkedList();
    public String wdB;

    public bpd() {
        AppMethodBeat.i(102518);
        AppMethodBeat.o(102518);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102519);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(102519);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wdB != null) {
                aVar.e(2, this.wdB);
            }
            aVar.iz(3, this.OpCode);
            aVar.iz(4, this.ehB);
            aVar.e(5, 8, this.vEh);
            AppMethodBeat.o(102519);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(2, this.wdB);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(3, this.OpCode)) + e.a.a.b.b.a.bs(4, this.ehB)) + e.a.a.a.c(5, 8, this.vEh);
            AppMethodBeat.o(102519);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(102519);
                throw bVar;
            }
            AppMethodBeat.o(102519);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpd bpd = (bpd) objArr[1];
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
                        bpd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(102519);
                    return 0;
                case 2:
                    bpd.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(102519);
                    return 0;
                case 3:
                    bpd.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(102519);
                    return 0;
                case 4:
                    bpd.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(102519);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpb bpb = new bpb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpb.populateBuilderWithField(aVar4, bpb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bpd.vEh.add(bpb);
                    }
                    AppMethodBeat.o(102519);
                    return 0;
                default:
                    AppMethodBeat.o(102519);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102519);
            return -1;
        }
    }
}
