package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cw extends a {
    public String Label;
    public String jBB;
    public int ndr;
    public long nds;
    public boolean ndt;
    public int ndu;
    public String ndv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111663);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(111663);
                throw bVar;
            }
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            aVar.iz(2, this.ndr);
            aVar.ai(3, this.nds);
            if (this.Label != null) {
                aVar.e(4, this.Label);
            }
            aVar.aO(5, this.ndt);
            aVar.iz(6, this.ndu);
            if (this.ndv != null) {
                aVar.e(7, this.ndv);
            }
            AppMethodBeat.o(111663);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.ndr)) + e.a.a.b.b.a.o(3, this.nds);
            if (this.Label != null) {
                f += e.a.a.b.b.a.f(4, this.Label);
            }
            f = (f + (e.a.a.b.b.a.fv(5) + 1)) + e.a.a.b.b.a.bs(6, this.ndu);
            if (this.ndv != null) {
                f += e.a.a.b.b.a.f(7, this.ndv);
            }
            AppMethodBeat.o(111663);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(111663);
                throw bVar;
            }
            AppMethodBeat.o(111663);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cw cwVar = (cw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(111663);
                    return 0;
                case 2:
                    cwVar.ndr = aVar3.BTU.vd();
                    AppMethodBeat.o(111663);
                    return 0;
                case 3:
                    cwVar.nds = aVar3.BTU.ve();
                    AppMethodBeat.o(111663);
                    return 0;
                case 4:
                    cwVar.Label = aVar3.BTU.readString();
                    AppMethodBeat.o(111663);
                    return 0;
                case 5:
                    cwVar.ndt = aVar3.BTU.ehX();
                    AppMethodBeat.o(111663);
                    return 0;
                case 6:
                    cwVar.ndu = aVar3.BTU.vd();
                    AppMethodBeat.o(111663);
                    return 0;
                case 7:
                    cwVar.ndv = aVar3.BTU.readString();
                    AppMethodBeat.o(111663);
                    return 0;
                default:
                    AppMethodBeat.o(111663);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111663);
            return -1;
        }
    }
}
