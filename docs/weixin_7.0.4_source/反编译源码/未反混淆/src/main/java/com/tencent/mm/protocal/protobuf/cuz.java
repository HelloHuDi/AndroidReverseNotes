package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cuz extends a {
    public String jCH;
    public String wyw;
    public b xqr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28767);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28767);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new e.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(28767);
                throw bVar;
            } else {
                if (this.wyw != null) {
                    aVar.e(1, this.wyw);
                }
                if (this.jCH != null) {
                    aVar.e(2, this.jCH);
                }
                if (this.xqr != null) {
                    aVar.c(3, this.xqr);
                }
                AppMethodBeat.o(28767);
                return 0;
            }
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.xqr != null) {
                f += e.a.a.b.b.a.b(3, this.xqr);
            }
            AppMethodBeat.o(28767);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28767);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new e.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(28767);
                throw bVar;
            } else {
                AppMethodBeat.o(28767);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuz cuz = (cuz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuz.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28767);
                    return 0;
                case 2:
                    cuz.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28767);
                    return 0;
                case 3:
                    cuz.xqr = aVar3.BTU.emu();
                    AppMethodBeat.o(28767);
                    return 0;
                default:
                    AppMethodBeat.o(28767);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28767);
            return -1;
        }
    }
}
