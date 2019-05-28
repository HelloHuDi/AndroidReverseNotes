package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class hb extends a {
    public String kmu;
    public String nuL;
    public String pbn;
    public String tuk;
    public String vJG;
    public String vJH;
    public String vJI;
    public boolean vJJ;
    public String vJK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48775);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nuL != null) {
                aVar.e(1, this.nuL);
            }
            if (this.pbn != null) {
                aVar.e(2, this.pbn);
            }
            if (this.kmu != null) {
                aVar.e(3, this.kmu);
            }
            if (this.tuk != null) {
                aVar.e(4, this.tuk);
            }
            if (this.vJG != null) {
                aVar.e(5, this.vJG);
            }
            if (this.vJH != null) {
                aVar.e(6, this.vJH);
            }
            if (this.vJI != null) {
                aVar.e(8, this.vJI);
            }
            aVar.aO(9, this.vJJ);
            if (this.vJK != null) {
                aVar.e(10, this.vJK);
            }
            AppMethodBeat.o(48775);
            return 0;
        } else if (i == 1) {
            if (this.nuL != null) {
                f = e.a.a.b.b.a.f(1, this.nuL) + 0;
            } else {
                f = 0;
            }
            if (this.pbn != null) {
                f += e.a.a.b.b.a.f(2, this.pbn);
            }
            if (this.kmu != null) {
                f += e.a.a.b.b.a.f(3, this.kmu);
            }
            if (this.tuk != null) {
                f += e.a.a.b.b.a.f(4, this.tuk);
            }
            if (this.vJG != null) {
                f += e.a.a.b.b.a.f(5, this.vJG);
            }
            if (this.vJH != null) {
                f += e.a.a.b.b.a.f(6, this.vJH);
            }
            if (this.vJI != null) {
                f += e.a.a.b.b.a.f(8, this.vJI);
            }
            f += e.a.a.b.b.a.fv(9) + 1;
            if (this.vJK != null) {
                f += e.a.a.b.b.a.f(10, this.vJK);
            }
            AppMethodBeat.o(48775);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48775);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hb hbVar = (hb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hbVar.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 2:
                    hbVar.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 3:
                    hbVar.kmu = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 4:
                    hbVar.tuk = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 5:
                    hbVar.vJG = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 6:
                    hbVar.vJH = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 8:
                    hbVar.vJI = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                case 9:
                    hbVar.vJJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(48775);
                    return 0;
                case 10:
                    hbVar.vJK = aVar3.BTU.readString();
                    AppMethodBeat.o(48775);
                    return 0;
                default:
                    AppMethodBeat.o(48775);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48775);
            return -1;
        }
    }
}
