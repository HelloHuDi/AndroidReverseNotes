package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class boj extends btd {
    public int kCl;
    public String kCm;
    public int wRi;
    public csf wRj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56946);
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
            aVar.iz(4, this.wRi);
            if (this.wRj != null) {
                aVar.iy(5, this.wRj.computeSize());
                this.wRj.writeFields(aVar);
            }
            AppMethodBeat.o(56946);
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
            ix += e.a.a.b.b.a.bs(4, this.wRi);
            if (this.wRj != null) {
                ix += e.a.a.a.ix(5, this.wRj.computeSize());
            }
            AppMethodBeat.o(56946);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56946);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            boj boj = (boj) objArr[1];
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
                        boj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56946);
                    return 0;
                case 2:
                    boj.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56946);
                    return 0;
                case 3:
                    boj.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56946);
                    return 0;
                case 4:
                    boj.wRi = aVar3.BTU.vd();
                    AppMethodBeat.o(56946);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csf csf = new csf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csf.populateBuilderWithField(aVar4, csf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        boj.wRj = csf;
                    }
                    AppMethodBeat.o(56946);
                    return 0;
                default:
                    AppMethodBeat.o(56946);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56946);
            return -1;
        }
    }
}
