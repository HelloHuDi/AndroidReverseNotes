package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class k extends a {
    public boolean kLB;
    public String kLC;
    public String kLD;
    public String kLE;
    public int kLF;
    public boolean kLG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35537);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.kLB);
            if (this.kLC != null) {
                aVar.e(2, this.kLC);
            }
            if (this.kLD != null) {
                aVar.e(3, this.kLD);
            }
            if (this.kLE != null) {
                aVar.e(4, this.kLE);
            }
            aVar.iz(5, this.kLF);
            aVar.aO(6, this.kLG);
            AppMethodBeat.o(35537);
            return 0;
        } else if (i == 1) {
            fv = (e.a.a.b.b.a.fv(1) + 1) + 0;
            if (this.kLC != null) {
                fv += e.a.a.b.b.a.f(2, this.kLC);
            }
            if (this.kLD != null) {
                fv += e.a.a.b.b.a.f(3, this.kLD);
            }
            if (this.kLE != null) {
                fv += e.a.a.b.b.a.f(4, this.kLE);
            }
            fv = (fv + e.a.a.b.b.a.bs(5, this.kLF)) + (e.a.a.b.b.a.fv(6) + 1);
            AppMethodBeat.o(35537);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35537);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.kLB = aVar3.BTU.ehX();
                    AppMethodBeat.o(35537);
                    return 0;
                case 2:
                    kVar.kLC = aVar3.BTU.readString();
                    AppMethodBeat.o(35537);
                    return 0;
                case 3:
                    kVar.kLD = aVar3.BTU.readString();
                    AppMethodBeat.o(35537);
                    return 0;
                case 4:
                    kVar.kLE = aVar3.BTU.readString();
                    AppMethodBeat.o(35537);
                    return 0;
                case 5:
                    kVar.kLF = aVar3.BTU.vd();
                    AppMethodBeat.o(35537);
                    return 0;
                case 6:
                    kVar.kLG = aVar3.BTU.ehX();
                    AppMethodBeat.o(35537);
                    return 0;
                default:
                    AppMethodBeat.o(35537);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35537);
            return -1;
        }
    }
}
