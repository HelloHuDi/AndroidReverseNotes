package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brz extends bsr {
    public float cEB;
    public float cGm;
    public String cMC;
    public float wUa;
    public b wUb;
    public boolean wUc;
    public boolean wUd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89131);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.r(2, this.cGm);
            aVar.r(3, this.cEB);
            aVar.r(4, this.wUa);
            if (this.wUb != null) {
                aVar.c(5, this.wUb);
            }
            if (this.cMC != null) {
                aVar.e(6, this.cMC);
            }
            aVar.aO(7, this.wUc);
            aVar.aO(8, this.wUd);
            AppMethodBeat.o(89131);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4);
            if (this.wUb != null) {
                ix += e.a.a.b.b.a.b(5, this.wUb);
            }
            if (this.cMC != null) {
                ix += e.a.a.b.b.a.f(6, this.cMC);
            }
            int fv = (ix + (e.a.a.b.b.a.fv(7) + 1)) + (e.a.a.b.b.a.fv(8) + 1);
            AppMethodBeat.o(89131);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89131);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brz brz = (brz) objArr[1];
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
                        brz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89131);
                    return 0;
                case 2:
                    brz.cGm = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(89131);
                    return 0;
                case 3:
                    brz.cEB = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(89131);
                    return 0;
                case 4:
                    brz.wUa = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(89131);
                    return 0;
                case 5:
                    brz.wUb = aVar3.BTU.emu();
                    AppMethodBeat.o(89131);
                    return 0;
                case 6:
                    brz.cMC = aVar3.BTU.readString();
                    AppMethodBeat.o(89131);
                    return 0;
                case 7:
                    brz.wUc = aVar3.BTU.ehX();
                    AppMethodBeat.o(89131);
                    return 0;
                case 8:
                    brz.wUd = aVar3.BTU.ehX();
                    AppMethodBeat.o(89131);
                    return 0;
                default:
                    AppMethodBeat.o(89131);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89131);
            return -1;
        }
    }
}
