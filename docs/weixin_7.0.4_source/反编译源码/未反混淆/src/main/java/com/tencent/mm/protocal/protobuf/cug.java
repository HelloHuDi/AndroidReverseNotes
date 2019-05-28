package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cug extends a {
    public String Title;
    public String ncM;
    public int ndE;
    public int wXt;
    public String wyw;
    public boolean xqI;
    public boolean xqJ;
    public boolean xqK;
    public b xqr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28746);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28746);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new e.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(28746);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new e.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(28746);
                throw bVar;
            } else {
                aVar.iz(1, this.ndE);
                if (this.wyw != null) {
                    aVar.e(2, this.wyw);
                }
                if (this.Title != null) {
                    aVar.e(3, this.Title);
                }
                if (this.ncM != null) {
                    aVar.e(4, this.ncM);
                }
                aVar.iz(5, this.wXt);
                if (this.xqr != null) {
                    aVar.c(6, this.xqr);
                }
                aVar.aO(7, this.xqI);
                aVar.aO(8, this.xqJ);
                aVar.aO(9, this.xqK);
                AppMethodBeat.o(28746);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ndE) + 0;
            if (this.wyw != null) {
                bs += e.a.a.b.b.a.f(2, this.wyw);
            }
            if (this.Title != null) {
                bs += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.ncM != null) {
                bs += e.a.a.b.b.a.f(4, this.ncM);
            }
            bs += e.a.a.b.b.a.bs(5, this.wXt);
            if (this.xqr != null) {
                bs += e.a.a.b.b.a.b(6, this.xqr);
            }
            bs = ((bs + (e.a.a.b.b.a.fv(7) + 1)) + (e.a.a.b.b.a.fv(8) + 1)) + (e.a.a.b.b.a.fv(9) + 1);
            AppMethodBeat.o(28746);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28746);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new e.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(28746);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new e.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(28746);
                throw bVar;
            } else {
                AppMethodBeat.o(28746);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cug cug = (cug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cug.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(28746);
                    return 0;
                case 2:
                    cug.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28746);
                    return 0;
                case 3:
                    cug.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28746);
                    return 0;
                case 4:
                    cug.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(28746);
                    return 0;
                case 5:
                    cug.wXt = aVar3.BTU.vd();
                    AppMethodBeat.o(28746);
                    return 0;
                case 6:
                    cug.xqr = aVar3.BTU.emu();
                    AppMethodBeat.o(28746);
                    return 0;
                case 7:
                    cug.xqI = aVar3.BTU.ehX();
                    AppMethodBeat.o(28746);
                    return 0;
                case 8:
                    cug.xqJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(28746);
                    return 0;
                case 9:
                    cug.xqK = aVar3.BTU.ehX();
                    AppMethodBeat.o(28746);
                    return 0;
                default:
                    AppMethodBeat.o(28746);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28746);
            return -1;
        }
    }
}
