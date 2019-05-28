package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bhi extends btd {
    public int kCl;
    public String kCm;
    public LinkedList<cjg> vBz = new LinkedList();

    public bhi() {
        AppMethodBeat.i(48909);
        AppMethodBeat.o(48909);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48910);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kCl);
            if (this.kCm != null) {
                aVar.e(3, this.kCm);
            }
            aVar.e(4, 8, this.vBz);
            AppMethodBeat.o(48910);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kCl);
            if (this.kCm != null) {
                ix += e.a.a.b.b.a.f(3, this.kCm);
            }
            int c = ix + e.a.a.a.c(4, 8, this.vBz);
            AppMethodBeat.o(48910);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48910);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhi bhi = (bhi) objArr[1];
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
                        bhi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48910);
                    return 0;
                case 2:
                    bhi.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48910);
                    return 0;
                case 3:
                    bhi.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48910);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjg cjg = new cjg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjg.populateBuilderWithField(aVar4, cjg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bhi.vBz.add(cjg);
                    }
                    AppMethodBeat.o(48910);
                    return 0;
                default:
                    AppMethodBeat.o(48910);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48910);
            return -1;
        }
    }
}
