package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class al extends a {
    public String Title;
    public String mZL;
    public int mZN;
    public String mZj;
    public String naV;
    public boolean naW;
    public boolean naX;
    public String naY;
    public String naZ;
    public int nba;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111577);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111577);
                throw bVar;
            } else if (this.naV == null) {
                bVar = new b("Not all required fields were included: NavKey");
                AppMethodBeat.o(111577);
                throw bVar;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.naV != null) {
                    aVar.e(2, this.naV);
                }
                if (this.mZj != null) {
                    aVar.e(3, this.mZj);
                }
                aVar.aO(4, this.naW);
                aVar.aO(5, this.naX);
                if (this.naY != null) {
                    aVar.e(6, this.naY);
                }
                if (this.naZ != null) {
                    aVar.e(7, this.naZ);
                }
                aVar.iz(8, this.nba);
                aVar.iz(9, this.mZN);
                if (this.mZL != null) {
                    aVar.e(10, this.mZL);
                }
                AppMethodBeat.o(111577);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.naV != null) {
                f += e.a.a.b.b.a.f(2, this.naV);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(3, this.mZj);
            }
            f = (f + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1);
            if (this.naY != null) {
                f += e.a.a.b.b.a.f(6, this.naY);
            }
            if (this.naZ != null) {
                f += e.a.a.b.b.a.f(7, this.naZ);
            }
            f = (f + e.a.a.b.b.a.bs(8, this.nba)) + e.a.a.b.b.a.bs(9, this.mZN);
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(10, this.mZL);
            }
            AppMethodBeat.o(111577);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111577);
                throw bVar;
            } else if (this.naV == null) {
                bVar = new b("Not all required fields were included: NavKey");
                AppMethodBeat.o(111577);
                throw bVar;
            } else {
                AppMethodBeat.o(111577);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            al alVar = (al) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111577);
                    return 0;
                case 2:
                    alVar.naV = aVar3.BTU.readString();
                    AppMethodBeat.o(111577);
                    return 0;
                case 3:
                    alVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111577);
                    return 0;
                case 4:
                    alVar.naW = aVar3.BTU.ehX();
                    AppMethodBeat.o(111577);
                    return 0;
                case 5:
                    alVar.naX = aVar3.BTU.ehX();
                    AppMethodBeat.o(111577);
                    return 0;
                case 6:
                    alVar.naY = aVar3.BTU.readString();
                    AppMethodBeat.o(111577);
                    return 0;
                case 7:
                    alVar.naZ = aVar3.BTU.readString();
                    AppMethodBeat.o(111577);
                    return 0;
                case 8:
                    alVar.nba = aVar3.BTU.vd();
                    AppMethodBeat.o(111577);
                    return 0;
                case 9:
                    alVar.mZN = aVar3.BTU.vd();
                    AppMethodBeat.o(111577);
                    return 0;
                case 10:
                    alVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111577);
                    return 0;
                default:
                    AppMethodBeat.o(111577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111577);
            return -1;
        }
    }
}
