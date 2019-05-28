package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class am extends a {
    public String content;
    public String cxb;
    public String pkI;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28297);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.cxb != null) {
                aVar.e(2, this.cxb);
            }
            if (this.pkI != null) {
                aVar.e(3, this.pkI);
            }
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            AppMethodBeat.o(28297);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.cxb != null) {
                f += e.a.a.b.b.a.f(2, this.cxb);
            }
            if (this.pkI != null) {
                f += e.a.a.b.b.a.f(3, this.pkI);
            }
            if (this.content != null) {
                f += e.a.a.b.b.a.f(4, this.content);
            }
            AppMethodBeat.o(28297);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28297);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(28297);
                    return 0;
                case 2:
                    amVar.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(28297);
                    return 0;
                case 3:
                    amVar.pkI = aVar3.BTU.readString();
                    AppMethodBeat.o(28297);
                    return 0;
                case 4:
                    amVar.content = aVar3.BTU.readString();
                    AppMethodBeat.o(28297);
                    return 0;
                default:
                    AppMethodBeat.o(28297);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28297);
            return -1;
        }
    }
}
