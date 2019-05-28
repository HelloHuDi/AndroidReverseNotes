package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class kd extends a {
    public String name;
    public int type;
    public String vMV;
    public String vMW;
    public int vMX;
    public int vMY;
    public String vMZ;
    public String vNa;
    public int ver;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11700);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMV != null) {
                aVar.e(1, this.vMV);
            }
            aVar.iz(2, this.type);
            if (this.vMW != null) {
                aVar.e(3, this.vMW);
            }
            if (this.name != null) {
                aVar.e(4, this.name);
            }
            aVar.iz(5, this.ver);
            aVar.iz(6, this.vMX);
            aVar.iz(7, this.vMY);
            if (this.vMZ != null) {
                aVar.e(8, this.vMZ);
            }
            if (this.vNa != null) {
                aVar.e(9, this.vNa);
            }
            AppMethodBeat.o(11700);
            return 0;
        } else if (i == 1) {
            if (this.vMV != null) {
                f = e.a.a.b.b.a.f(1, this.vMV) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.type);
            if (this.vMW != null) {
                f += e.a.a.b.b.a.f(3, this.vMW);
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(4, this.name);
            }
            f = ((f + e.a.a.b.b.a.bs(5, this.ver)) + e.a.a.b.b.a.bs(6, this.vMX)) + e.a.a.b.b.a.bs(7, this.vMY);
            if (this.vMZ != null) {
                f += e.a.a.b.b.a.f(8, this.vMZ);
            }
            if (this.vNa != null) {
                f += e.a.a.b.b.a.f(9, this.vNa);
            }
            AppMethodBeat.o(11700);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11700);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kd kdVar = (kd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kdVar.vMV = aVar3.BTU.readString();
                    AppMethodBeat.o(11700);
                    return 0;
                case 2:
                    kdVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(11700);
                    return 0;
                case 3:
                    kdVar.vMW = aVar3.BTU.readString();
                    AppMethodBeat.o(11700);
                    return 0;
                case 4:
                    kdVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(11700);
                    return 0;
                case 5:
                    kdVar.ver = aVar3.BTU.vd();
                    AppMethodBeat.o(11700);
                    return 0;
                case 6:
                    kdVar.vMX = aVar3.BTU.vd();
                    AppMethodBeat.o(11700);
                    return 0;
                case 7:
                    kdVar.vMY = aVar3.BTU.vd();
                    AppMethodBeat.o(11700);
                    return 0;
                case 8:
                    kdVar.vMZ = aVar3.BTU.readString();
                    AppMethodBeat.o(11700);
                    return 0;
                case 9:
                    kdVar.vNa = aVar3.BTU.readString();
                    AppMethodBeat.o(11700);
                    return 0;
                default:
                    AppMethodBeat.o(11700);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11700);
            return -1;
        }
    }
}
