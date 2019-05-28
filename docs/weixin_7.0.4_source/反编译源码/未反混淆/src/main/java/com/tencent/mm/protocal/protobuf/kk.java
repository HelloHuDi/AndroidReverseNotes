package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class kk extends a {
    public String kfT;
    public String vMW;
    public int vMX;
    public String vNa;
    public String vNc;
    public String vNk;
    public int ver;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11709);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNc != null) {
                aVar.e(1, this.vNc);
            }
            if (this.kfT != null) {
                aVar.e(2, this.kfT);
            }
            aVar.iz(3, this.ver);
            if (this.vMW != null) {
                aVar.e(4, this.vMW);
            }
            if (this.vNk != null) {
                aVar.e(5, this.vNk);
            }
            aVar.iz(6, this.vMX);
            if (this.vNa != null) {
                aVar.e(7, this.vNa);
            }
            AppMethodBeat.o(11709);
            return 0;
        } else if (i == 1) {
            if (this.vNc != null) {
                f = e.a.a.b.b.a.f(1, this.vNc) + 0;
            } else {
                f = 0;
            }
            if (this.kfT != null) {
                f += e.a.a.b.b.a.f(2, this.kfT);
            }
            f += e.a.a.b.b.a.bs(3, this.ver);
            if (this.vMW != null) {
                f += e.a.a.b.b.a.f(4, this.vMW);
            }
            if (this.vNk != null) {
                f += e.a.a.b.b.a.f(5, this.vNk);
            }
            f += e.a.a.b.b.a.bs(6, this.vMX);
            if (this.vNa != null) {
                f += e.a.a.b.b.a.f(7, this.vNa);
            }
            AppMethodBeat.o(11709);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11709);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kk kkVar = (kk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kkVar.vNc = aVar3.BTU.readString();
                    AppMethodBeat.o(11709);
                    return 0;
                case 2:
                    kkVar.kfT = aVar3.BTU.readString();
                    AppMethodBeat.o(11709);
                    return 0;
                case 3:
                    kkVar.ver = aVar3.BTU.vd();
                    AppMethodBeat.o(11709);
                    return 0;
                case 4:
                    kkVar.vMW = aVar3.BTU.readString();
                    AppMethodBeat.o(11709);
                    return 0;
                case 5:
                    kkVar.vNk = aVar3.BTU.readString();
                    AppMethodBeat.o(11709);
                    return 0;
                case 6:
                    kkVar.vMX = aVar3.BTU.vd();
                    AppMethodBeat.o(11709);
                    return 0;
                case 7:
                    kkVar.vNa = aVar3.BTU.readString();
                    AppMethodBeat.o(11709);
                    return 0;
                default:
                    AppMethodBeat.o(11709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11709);
            return -1;
        }
    }
}
