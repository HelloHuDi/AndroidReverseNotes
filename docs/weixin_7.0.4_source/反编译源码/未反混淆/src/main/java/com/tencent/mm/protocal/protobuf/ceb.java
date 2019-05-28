package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ceb extends bsr {
    public String jBB;
    public int lvg;
    public long wZU;
    public String xdK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56509);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            aVar.iz(3, this.lvg);
            if (this.xdK != null) {
                aVar.e(4, this.xdK);
            }
            aVar.ai(5, this.wZU);
            AppMethodBeat.o(56509);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(2, this.jBB);
            }
            ix += e.a.a.b.b.a.bs(3, this.lvg);
            if (this.xdK != null) {
                ix += e.a.a.b.b.a.f(4, this.xdK);
            }
            int o = ix + e.a.a.b.b.a.o(5, this.wZU);
            AppMethodBeat.o(56509);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56509);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ceb ceb = (ceb) objArr[1];
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
                        ceb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56509);
                    return 0;
                case 2:
                    ceb.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56509);
                    return 0;
                case 3:
                    ceb.lvg = aVar3.BTU.vd();
                    AppMethodBeat.o(56509);
                    return 0;
                case 4:
                    ceb.xdK = aVar3.BTU.readString();
                    AppMethodBeat.o(56509);
                    return 0;
                case 5:
                    ceb.wZU = aVar3.BTU.ve();
                    AppMethodBeat.o(56509);
                    return 0;
                default:
                    AppMethodBeat.o(56509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56509);
            return -1;
        }
    }
}
