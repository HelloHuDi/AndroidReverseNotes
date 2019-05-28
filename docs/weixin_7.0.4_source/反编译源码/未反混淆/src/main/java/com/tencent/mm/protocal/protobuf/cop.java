package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cop extends bsr {
    public int vIw;
    public long wOP;
    public int wOQ;
    public long wen;
    public long xeF;
    public String xmv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135443);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wOQ);
            aVar.ai(3, this.xeF);
            aVar.ai(4, this.wen);
            if (this.xmv != null) {
                aVar.e(5, this.xmv);
            }
            aVar.ai(6, this.wOP);
            aVar.iz(7, this.vIw);
            AppMethodBeat.o(135443);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.wOQ)) + e.a.a.b.b.a.o(3, this.xeF)) + e.a.a.b.b.a.o(4, this.wen);
            if (this.xmv != null) {
                ix += e.a.a.b.b.a.f(5, this.xmv);
            }
            int o = (ix + e.a.a.b.b.a.o(6, this.wOP)) + e.a.a.b.b.a.bs(7, this.vIw);
            AppMethodBeat.o(135443);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135443);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cop cop = (cop) objArr[1];
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
                        cop.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(135443);
                    return 0;
                case 2:
                    cop.wOQ = aVar3.BTU.vd();
                    AppMethodBeat.o(135443);
                    return 0;
                case 3:
                    cop.xeF = aVar3.BTU.ve();
                    AppMethodBeat.o(135443);
                    return 0;
                case 4:
                    cop.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(135443);
                    return 0;
                case 5:
                    cop.xmv = aVar3.BTU.readString();
                    AppMethodBeat.o(135443);
                    return 0;
                case 6:
                    cop.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(135443);
                    return 0;
                case 7:
                    cop.vIw = aVar3.BTU.vd();
                    AppMethodBeat.o(135443);
                    return 0;
                default:
                    AppMethodBeat.o(135443);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135443);
            return -1;
        }
    }
}
