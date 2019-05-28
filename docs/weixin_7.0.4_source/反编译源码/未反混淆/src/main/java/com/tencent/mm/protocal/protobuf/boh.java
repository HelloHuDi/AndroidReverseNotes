package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class boh extends btd {
    public int kCl;
    public String kCm;
    public cji wRh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48948);
        int ix;
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
            if (this.wRh != null) {
                aVar.iy(4, this.wRh.computeSize());
                this.wRh.writeFields(aVar);
            }
            AppMethodBeat.o(48948);
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
            if (this.wRh != null) {
                ix += e.a.a.a.ix(4, this.wRh.computeSize());
            }
            AppMethodBeat.o(48948);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48948);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            boh boh = (boh) objArr[1];
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
                        boh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48948);
                    return 0;
                case 2:
                    boh.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48948);
                    return 0;
                case 3:
                    boh.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48948);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cji cji = new cji();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cji.populateBuilderWithField(aVar4, cji, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        boh.wRh = cji;
                    }
                    AppMethodBeat.o(48948);
                    return 0;
                default:
                    AppMethodBeat.o(48948);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48948);
            return -1;
        }
    }
}
