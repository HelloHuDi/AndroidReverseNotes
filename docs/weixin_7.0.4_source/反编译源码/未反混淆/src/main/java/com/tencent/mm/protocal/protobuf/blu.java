package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class blu extends bsr {
    public String ndF;
    public long wOP;
    public int wOQ;
    public String wOR;
    public long wOS;
    public int wem;
    public long wen;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28575);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            if (this.ndF != null) {
                aVar.e(4, this.ndF);
            }
            aVar.ai(5, this.wOP);
            aVar.iz(6, this.wOQ);
            if (this.wOR != null) {
                aVar.e(7, this.wOR);
            }
            aVar.ai(8, this.wOS);
            AppMethodBeat.o(28575);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen);
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(4, this.ndF);
            }
            ix = (ix + e.a.a.b.b.a.o(5, this.wOP)) + e.a.a.b.b.a.bs(6, this.wOQ);
            if (this.wOR != null) {
                ix += e.a.a.b.b.a.f(7, this.wOR);
            }
            int o = ix + e.a.a.b.b.a.o(8, this.wOS);
            AppMethodBeat.o(28575);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28575);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blu blu = (blu) objArr[1];
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
                        blu.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28575);
                    return 0;
                case 2:
                    blu.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28575);
                    return 0;
                case 3:
                    blu.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28575);
                    return 0;
                case 4:
                    blu.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28575);
                    return 0;
                case 5:
                    blu.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(28575);
                    return 0;
                case 6:
                    blu.wOQ = aVar3.BTU.vd();
                    AppMethodBeat.o(28575);
                    return 0;
                case 7:
                    blu.wOR = aVar3.BTU.readString();
                    AppMethodBeat.o(28575);
                    return 0;
                case 8:
                    blu.wOS = aVar3.BTU.ve();
                    AppMethodBeat.o(28575);
                    return 0;
                default:
                    AppMethodBeat.o(28575);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28575);
            return -1;
        }
    }
}
