package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpo extends btd {
    public int id;
    public bpj wRK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28609);
        b bVar;
        int bs;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRK == null) {
                bVar = new b("Not all required fields were included: rcptinfolist");
                AppMethodBeat.o(28609);
                throw bVar;
            } else if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28609);
                throw bVar;
            } else {
                aVar.iz(1, this.id);
                if (this.wRK != null) {
                    aVar.iy(2, this.wRK.computeSize());
                    this.wRK.writeFields(aVar);
                }
                if (this.BaseResponse != null) {
                    aVar.iy(3, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                AppMethodBeat.o(28609);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.id) + 0;
            if (this.wRK != null) {
                bs += e.a.a.a.ix(2, this.wRK.computeSize());
            }
            if (this.BaseResponse != null) {
                bs += e.a.a.a.ix(3, this.BaseResponse.computeSize());
            }
            AppMethodBeat.o(28609);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wRK == null) {
                bVar = new b("Not all required fields were included: rcptinfolist");
                AppMethodBeat.o(28609);
                throw bVar;
            } else if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28609);
                throw bVar;
            } else {
                AppMethodBeat.o(28609);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpo bpo = (bpo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bpo.id = aVar3.BTU.vd();
                    AppMethodBeat.o(28609);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpj bpj = new bpj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpj.populateBuilderWithField(aVar4, bpj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bpo.wRK = bpj;
                    }
                    AppMethodBeat.o(28609);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bpo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28609);
                    return 0;
                default:
                    AppMethodBeat.o(28609);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28609);
            return -1;
        }
    }
}
