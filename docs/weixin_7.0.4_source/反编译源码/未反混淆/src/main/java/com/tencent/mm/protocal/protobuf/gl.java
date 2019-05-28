package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class gl extends a {
    public int cyE;
    public String data;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114950);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.data != null) {
                aVar.e(2, this.data);
            }
            aVar.iz(3, this.cyE);
            AppMethodBeat.o(114950);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.data != null) {
                f += e.a.a.b.b.a.f(2, this.data);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.cyE);
            AppMethodBeat.o(114950);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114950);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gl glVar = (gl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    glVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(114950);
                    return 0;
                case 2:
                    glVar.data = aVar3.BTU.readString();
                    AppMethodBeat.o(114950);
                    return 0;
                case 3:
                    glVar.cyE = aVar3.BTU.vd();
                    AppMethodBeat.o(114950);
                    return 0;
                default:
                    AppMethodBeat.o(114950);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114950);
            return -1;
        }
    }
}
