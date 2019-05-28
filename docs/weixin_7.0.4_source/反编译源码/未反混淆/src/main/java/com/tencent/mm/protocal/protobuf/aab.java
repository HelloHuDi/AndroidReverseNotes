package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aab extends bsr {
    public int cRT;
    public int kCd;
    public double latitude;
    public double longitude;
    public int pjg;
    public int wfj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56788);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.kCd);
            aVar.iz(3, this.pjg);
            aVar.iz(4, this.cRT);
            aVar.iz(5, this.wfj);
            aVar.f(6, this.latitude);
            aVar.f(7, this.longitude);
            AppMethodBeat.o(56788);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((((ix + e.a.a.b.b.a.bs(2, this.kCd)) + e.a.a.b.b.a.bs(3, this.pjg)) + e.a.a.b.b.a.bs(4, this.cRT)) + e.a.a.b.b.a.bs(5, this.wfj)) + (e.a.a.b.b.a.fv(6) + 8)) + (e.a.a.b.b.a.fv(7) + 8);
            AppMethodBeat.o(56788);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56788);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aab aab = (aab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aab.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56788);
                    return 0;
                case 2:
                    aab.kCd = aVar3.BTU.vd();
                    AppMethodBeat.o(56788);
                    return 0;
                case 3:
                    aab.pjg = aVar3.BTU.vd();
                    AppMethodBeat.o(56788);
                    return 0;
                case 4:
                    aab.cRT = aVar3.BTU.vd();
                    AppMethodBeat.o(56788);
                    return 0;
                case 5:
                    aab.wfj = aVar3.BTU.vd();
                    AppMethodBeat.o(56788);
                    return 0;
                case 6:
                    aab.latitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56788);
                    return 0;
                case 7:
                    aab.longitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56788);
                    return 0;
                default:
                    AppMethodBeat.o(56788);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56788);
            return -1;
        }
    }
}
