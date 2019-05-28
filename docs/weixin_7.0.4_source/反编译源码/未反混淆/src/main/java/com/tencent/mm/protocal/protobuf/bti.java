package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bti extends bsr {
    public String ndF;
    public String ndG;
    public int pcX;
    public String vFF;
    public int wVo;
    public int wVp;
    public int wVq;
    public long wVr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28618);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vFF != null) {
                aVar.e(2, this.vFF);
            }
            aVar.iz(3, this.wVo);
            aVar.iz(4, this.pcX);
            aVar.iz(5, this.wVp);
            if (this.ndG != null) {
                aVar.e(6, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(7, this.ndF);
            }
            aVar.iz(8, this.wVq);
            aVar.ai(9, this.wVr);
            AppMethodBeat.o(28618);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFF != null) {
                ix += e.a.a.b.b.a.f(2, this.vFF);
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.wVo)) + e.a.a.b.b.a.bs(4, this.pcX)) + e.a.a.b.b.a.bs(5, this.wVp);
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(6, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(7, this.ndF);
            }
            int bs = (ix + e.a.a.b.b.a.bs(8, this.wVq)) + e.a.a.b.b.a.o(9, this.wVr);
            AppMethodBeat.o(28618);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28618);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bti bti = (bti) objArr[1];
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
                        bti.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28618);
                    return 0;
                case 2:
                    bti.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(28618);
                    return 0;
                case 3:
                    bti.wVo = aVar3.BTU.vd();
                    AppMethodBeat.o(28618);
                    return 0;
                case 4:
                    bti.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(28618);
                    return 0;
                case 5:
                    bti.wVp = aVar3.BTU.vd();
                    AppMethodBeat.o(28618);
                    return 0;
                case 6:
                    bti.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28618);
                    return 0;
                case 7:
                    bti.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28618);
                    return 0;
                case 8:
                    bti.wVq = aVar3.BTU.vd();
                    AppMethodBeat.o(28618);
                    return 0;
                case 9:
                    bti.wVr = aVar3.BTU.ve();
                    AppMethodBeat.o(28618);
                    return 0;
                default:
                    AppMethodBeat.o(28618);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28618);
            return -1;
        }
    }
}
