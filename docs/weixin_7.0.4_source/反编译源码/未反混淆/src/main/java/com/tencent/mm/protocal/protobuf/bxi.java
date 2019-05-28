package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bxi extends a {
    public String nickname;
    public String username;
    public boolean wXq;
    public String wrK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114983);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.aO(2, this.wXq);
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.wrK != null) {
                aVar.e(4, this.wrK);
            }
            AppMethodBeat.o(114983);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.fv(2) + 1;
            if (this.nickname != null) {
                f += e.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.wrK != null) {
                f += e.a.a.b.b.a.f(4, this.wrK);
            }
            AppMethodBeat.o(114983);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114983);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxi bxi = (bxi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxi.username = aVar3.BTU.readString();
                    AppMethodBeat.o(114983);
                    return 0;
                case 2:
                    bxi.wXq = aVar3.BTU.ehX();
                    AppMethodBeat.o(114983);
                    return 0;
                case 3:
                    bxi.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(114983);
                    return 0;
                case 4:
                    bxi.wrK = aVar3.BTU.readString();
                    AppMethodBeat.o(114983);
                    return 0;
                default:
                    AppMethodBeat.o(114983);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114983);
            return -1;
        }
    }
}
