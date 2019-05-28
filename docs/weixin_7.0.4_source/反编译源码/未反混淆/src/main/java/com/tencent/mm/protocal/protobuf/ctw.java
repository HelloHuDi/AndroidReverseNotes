package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctw extends a {
    public String luQ;
    public String vHl;
    public boolean xqy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28733);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHl == null) {
                bVar = new b("Not all required fields were included: Username");
                AppMethodBeat.o(28733);
                throw bVar;
            } else if (this.luQ == null) {
                bVar = new b("Not all required fields were included: Language");
                AppMethodBeat.o(28733);
                throw bVar;
            } else {
                if (this.vHl != null) {
                    aVar.e(1, this.vHl);
                }
                if (this.luQ != null) {
                    aVar.e(2, this.luQ);
                }
                aVar.aO(3, this.xqy);
                AppMethodBeat.o(28733);
                return 0;
            }
        } else if (i == 1) {
            if (this.vHl != null) {
                f = e.a.a.b.b.a.f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            if (this.luQ != null) {
                f += e.a.a.b.b.a.f(2, this.luQ);
            }
            int fv = f + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(28733);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vHl == null) {
                bVar = new b("Not all required fields were included: Username");
                AppMethodBeat.o(28733);
                throw bVar;
            } else if (this.luQ == null) {
                bVar = new b("Not all required fields were included: Language");
                AppMethodBeat.o(28733);
                throw bVar;
            } else {
                AppMethodBeat.o(28733);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctw ctw = (ctw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctw.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(28733);
                    return 0;
                case 2:
                    ctw.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28733);
                    return 0;
                case 3:
                    ctw.xqy = aVar3.BTU.ehX();
                    AppMethodBeat.o(28733);
                    return 0;
                default:
                    AppMethodBeat.o(28733);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28733);
            return -1;
        }
    }
}
