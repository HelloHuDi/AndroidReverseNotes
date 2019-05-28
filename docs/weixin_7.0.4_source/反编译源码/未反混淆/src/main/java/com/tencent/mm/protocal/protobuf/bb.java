package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bb extends a {
    public boolean vCS = false;
    public boolean vCT = false;
    public boolean vCU = false;
    public boolean vCV = false;
    public String vCW = "";
    public String vCX = "";
    public String vCY = "";
    public String vCZ = "";
    public int vDa = -1;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73642);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.vCS);
            aVar.aO(2, this.vCT);
            aVar.aO(3, this.vCU);
            aVar.aO(4, this.vCV);
            if (this.vCW != null) {
                aVar.e(5, this.vCW);
            }
            if (this.vCX != null) {
                aVar.e(6, this.vCX);
            }
            if (this.vCY != null) {
                aVar.e(7, this.vCY);
            }
            if (this.vCZ != null) {
                aVar.e(8, this.vCZ);
            }
            aVar.iz(9, this.vDa);
            AppMethodBeat.o(73642);
            return 0;
        } else if (i == 1) {
            fv = ((((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + (e.a.a.b.b.a.fv(3) + 1)) + (e.a.a.b.b.a.fv(4) + 1);
            if (this.vCW != null) {
                fv += e.a.a.b.b.a.f(5, this.vCW);
            }
            if (this.vCX != null) {
                fv += e.a.a.b.b.a.f(6, this.vCX);
            }
            if (this.vCY != null) {
                fv += e.a.a.b.b.a.f(7, this.vCY);
            }
            if (this.vCZ != null) {
                fv += e.a.a.b.b.a.f(8, this.vCZ);
            }
            fv += e.a.a.b.b.a.bs(9, this.vDa);
            AppMethodBeat.o(73642);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73642);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bb bbVar = (bb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbVar.vCS = aVar3.BTU.ehX();
                    AppMethodBeat.o(73642);
                    return 0;
                case 2:
                    bbVar.vCT = aVar3.BTU.ehX();
                    AppMethodBeat.o(73642);
                    return 0;
                case 3:
                    bbVar.vCU = aVar3.BTU.ehX();
                    AppMethodBeat.o(73642);
                    return 0;
                case 4:
                    bbVar.vCV = aVar3.BTU.ehX();
                    AppMethodBeat.o(73642);
                    return 0;
                case 5:
                    bbVar.vCW = aVar3.BTU.readString();
                    AppMethodBeat.o(73642);
                    return 0;
                case 6:
                    bbVar.vCX = aVar3.BTU.readString();
                    AppMethodBeat.o(73642);
                    return 0;
                case 7:
                    bbVar.vCY = aVar3.BTU.readString();
                    AppMethodBeat.o(73642);
                    return 0;
                case 8:
                    bbVar.vCZ = aVar3.BTU.readString();
                    AppMethodBeat.o(73642);
                    return 0;
                case 9:
                    bbVar.vDa = aVar3.BTU.vd();
                    AppMethodBeat.o(73642);
                    return 0;
                default:
                    AppMethodBeat.o(73642);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73642);
            return -1;
        }
    }
}
