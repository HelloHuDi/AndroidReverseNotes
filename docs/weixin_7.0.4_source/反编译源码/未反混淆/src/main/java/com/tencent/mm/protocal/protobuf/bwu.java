package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwu extends btd {
    public fz wXh;
    public String wXi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96287);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96287);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wXh != null) {
                aVar.iy(2, this.wXh.computeSize());
                this.wXh.writeFields(aVar);
            }
            if (this.wXi != null) {
                aVar.e(3, this.wXi);
            }
            AppMethodBeat.o(96287);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wXh != null) {
                ix += e.a.a.a.ix(2, this.wXh.computeSize());
            }
            if (this.wXi != null) {
                ix += e.a.a.b.b.a.f(3, this.wXi);
            }
            AppMethodBeat.o(96287);
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
                AppMethodBeat.o(96287);
                throw bVar;
            }
            AppMethodBeat.o(96287);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwu bwu = (bwu) objArr[1];
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
                        bwu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96287);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fz fzVar = new fz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fzVar.populateBuilderWithField(aVar4, fzVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bwu.wXh = fzVar;
                    }
                    AppMethodBeat.o(96287);
                    return 0;
                case 3:
                    bwu.wXi = aVar3.BTU.readString();
                    AppMethodBeat.o(96287);
                    return 0;
                default:
                    AppMethodBeat.o(96287);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96287);
            return -1;
        }
    }
}
