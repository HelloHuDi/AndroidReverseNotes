package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bok extends bsr {
    public long timestamp;
    public int vZt;
    public int vZu;
    public int wRk;
    public b wRl;
    public b wRm;
    public b wRn;
    public int wRo;
    public hi wmx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48949);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wmx != null) {
                aVar.iy(2, this.wmx.computeSize());
                this.wmx.writeFields(aVar);
            }
            aVar.iz(3, this.wRk);
            if (this.wRl != null) {
                aVar.c(4, this.wRl);
            }
            if (this.wRm != null) {
                aVar.c(5, this.wRm);
            }
            if (this.wRn != null) {
                aVar.c(6, this.wRn);
            }
            aVar.iz(7, this.vZu);
            aVar.iz(8, this.vZt);
            aVar.iz(9, this.wRo);
            aVar.ai(10, this.timestamp);
            AppMethodBeat.o(48949);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wmx != null) {
                ix += e.a.a.a.ix(2, this.wmx.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.wRk);
            if (this.wRl != null) {
                ix += e.a.a.b.b.a.b(4, this.wRl);
            }
            if (this.wRm != null) {
                ix += e.a.a.b.b.a.b(5, this.wRm);
            }
            if (this.wRn != null) {
                ix += e.a.a.b.b.a.b(6, this.wRn);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(7, this.vZu)) + e.a.a.b.b.a.bs(8, this.vZt)) + e.a.a.b.b.a.bs(9, this.wRo)) + e.a.a.b.b.a.o(10, this.timestamp);
            AppMethodBeat.o(48949);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48949);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bok bok = (bok) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bok.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48949);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hi hiVar = new hi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hiVar.populateBuilderWithField(aVar4, hiVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bok.wmx = hiVar;
                    }
                    AppMethodBeat.o(48949);
                    return 0;
                case 3:
                    bok.wRk = aVar3.BTU.vd();
                    AppMethodBeat.o(48949);
                    return 0;
                case 4:
                    bok.wRl = aVar3.BTU.emu();
                    AppMethodBeat.o(48949);
                    return 0;
                case 5:
                    bok.wRm = aVar3.BTU.emu();
                    AppMethodBeat.o(48949);
                    return 0;
                case 6:
                    bok.wRn = aVar3.BTU.emu();
                    AppMethodBeat.o(48949);
                    return 0;
                case 7:
                    bok.vZu = aVar3.BTU.vd();
                    AppMethodBeat.o(48949);
                    return 0;
                case 8:
                    bok.vZt = aVar3.BTU.vd();
                    AppMethodBeat.o(48949);
                    return 0;
                case 9:
                    bok.wRo = aVar3.BTU.vd();
                    AppMethodBeat.o(48949);
                    return 0;
                case 10:
                    bok.timestamp = aVar3.BTU.ve();
                    AppMethodBeat.o(48949);
                    return 0;
                default:
                    AppMethodBeat.o(48949);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48949);
            return -1;
        }
    }
}
