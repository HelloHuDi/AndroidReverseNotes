package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cts extends a {
    public String jBB;
    public String jCH;
    public String ncM;
    public int ndE;
    public b xqr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28728);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB == null) {
                bVar = new e.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(28728);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new e.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(28728);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new e.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(28728);
                throw bVar;
            } else {
                aVar.iz(1, this.ndE);
                if (this.jBB != null) {
                    aVar.e(2, this.jBB);
                }
                if (this.jCH != null) {
                    aVar.e(3, this.jCH);
                }
                if (this.ncM != null) {
                    aVar.e(4, this.ncM);
                }
                if (this.xqr != null) {
                    aVar.c(5, this.xqr);
                }
                AppMethodBeat.o(28728);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ndE) + 0;
            if (this.jBB != null) {
                bs += e.a.a.b.b.a.f(2, this.jBB);
            }
            if (this.jCH != null) {
                bs += e.a.a.b.b.a.f(3, this.jCH);
            }
            if (this.ncM != null) {
                bs += e.a.a.b.b.a.f(4, this.ncM);
            }
            if (this.xqr != null) {
                bs += e.a.a.b.b.a.b(5, this.xqr);
            }
            AppMethodBeat.o(28728);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.jBB == null) {
                bVar = new e.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(28728);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new e.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(28728);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new e.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(28728);
                throw bVar;
            } else {
                AppMethodBeat.o(28728);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cts cts = (cts) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cts.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(28728);
                    return 0;
                case 2:
                    cts.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28728);
                    return 0;
                case 3:
                    cts.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28728);
                    return 0;
                case 4:
                    cts.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(28728);
                    return 0;
                case 5:
                    cts.xqr = aVar3.BTU.emu();
                    AppMethodBeat.o(28728);
                    return 0;
                default:
                    AppMethodBeat.o(28728);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28728);
            return -1;
        }
    }
}
