package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class dr extends a {
    public String IconUrl;
    public String fKh;
    public String jBB;
    public String mZL;
    public String ncH;
    public String ndP;
    public int ndQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111682);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(111682);
                throw bVar;
            }
            if (this.fKh != null) {
                aVar.e(1, this.fKh);
            }
            if (this.ncH != null) {
                aVar.e(2, this.ncH);
            }
            if (this.IconUrl != null) {
                aVar.e(3, this.IconUrl);
            }
            if (this.jBB != null) {
                aVar.e(4, this.jBB);
            }
            if (this.ndP != null) {
                aVar.e(5, this.ndP);
            }
            aVar.iz(6, this.ndQ);
            if (this.mZL != null) {
                aVar.e(7, this.mZL);
            }
            AppMethodBeat.o(111682);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(2, this.ncH);
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(3, this.IconUrl);
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(4, this.jBB);
            }
            if (this.ndP != null) {
                f += e.a.a.b.b.a.f(5, this.ndP);
            }
            f += e.a.a.b.b.a.bs(6, this.ndQ);
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(7, this.mZL);
            }
            AppMethodBeat.o(111682);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(111682);
                throw bVar;
            }
            AppMethodBeat.o(111682);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(111682);
                    return 0;
                case 2:
                    drVar.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(111682);
                    return 0;
                case 3:
                    drVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(111682);
                    return 0;
                case 4:
                    drVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(111682);
                    return 0;
                case 5:
                    drVar.ndP = aVar3.BTU.readString();
                    AppMethodBeat.o(111682);
                    return 0;
                case 6:
                    drVar.ndQ = aVar3.BTU.vd();
                    AppMethodBeat.o(111682);
                    return 0;
                case 7:
                    drVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111682);
                    return 0;
                default:
                    AppMethodBeat.o(111682);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111682);
            return -1;
        }
    }
}
