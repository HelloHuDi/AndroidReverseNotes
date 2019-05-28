package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bgd extends a {
    public String bCu;
    public int status;
    public String userName;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80130);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            aVar.iz(2, this.status);
            if (this.bCu != null) {
                aVar.e(3, this.bCu);
            }
            AppMethodBeat.o(80130);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = e.a.a.b.b.a.f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.status);
            if (this.bCu != null) {
                f += e.a.a.b.b.a.f(3, this.bCu);
            }
            AppMethodBeat.o(80130);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80130);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgd bgd = (bgd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgd.userName = aVar3.BTU.readString();
                    AppMethodBeat.o(80130);
                    return 0;
                case 2:
                    bgd.status = aVar3.BTU.vd();
                    AppMethodBeat.o(80130);
                    return 0;
                case 3:
                    bgd.bCu = aVar3.BTU.readString();
                    AppMethodBeat.o(80130);
                    return 0;
                default:
                    AppMethodBeat.o(80130);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80130);
            return -1;
        }
    }
}
