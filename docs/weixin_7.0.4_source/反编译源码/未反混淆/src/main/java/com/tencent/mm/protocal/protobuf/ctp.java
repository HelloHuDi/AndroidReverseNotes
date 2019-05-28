package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctp extends a {
    public String Title;
    public String ncM;
    public int ndE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28724);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(28724);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(28724);
                throw bVar;
            } else {
                aVar.iz(1, this.ndE);
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.ncM != null) {
                    aVar.e(3, this.ncM);
                }
                AppMethodBeat.o(28724);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ndE) + 0;
            if (this.Title != null) {
                bs += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.ncM != null) {
                bs += e.a.a.b.b.a.f(3, this.ncM);
            }
            AppMethodBeat.o(28724);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(28724);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(28724);
                throw bVar;
            } else {
                AppMethodBeat.o(28724);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctp ctp = (ctp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctp.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(28724);
                    return 0;
                case 2:
                    ctp.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28724);
                    return 0;
                case 3:
                    ctp.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(28724);
                    return 0;
                default:
                    AppMethodBeat.o(28724);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28724);
            return -1;
        }
    }
}
