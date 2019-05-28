package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class jd extends a {
    public String kKZ;
    public String nickname;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96209);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.kKZ != null) {
                aVar.e(2, this.kKZ);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            AppMethodBeat.o(96209);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.kKZ != null) {
                f += e.a.a.b.b.a.f(2, this.kKZ);
            }
            if (this.nickname != null) {
                f += e.a.a.b.b.a.f(3, this.nickname);
            }
            AppMethodBeat.o(96209);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96209);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jd jdVar = (jd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jdVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(96209);
                    return 0;
                case 2:
                    jdVar.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(96209);
                    return 0;
                case 3:
                    jdVar.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(96209);
                    return 0;
                default:
                    AppMethodBeat.o(96209);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96209);
            return -1;
        }
    }
}
