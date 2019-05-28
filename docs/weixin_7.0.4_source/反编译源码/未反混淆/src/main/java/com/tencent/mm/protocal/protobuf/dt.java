package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class dt extends a {
    public String vFA;
    public String vFB;
    public String vFz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94508);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vFz != null) {
                aVar.e(1, this.vFz);
            }
            if (this.vFA != null) {
                aVar.e(2, this.vFA);
            }
            if (this.vFB != null) {
                aVar.e(3, this.vFB);
            }
            AppMethodBeat.o(94508);
            return 0;
        } else if (i == 1) {
            if (this.vFz != null) {
                f = e.a.a.b.b.a.f(1, this.vFz) + 0;
            } else {
                f = 0;
            }
            if (this.vFA != null) {
                f += e.a.a.b.b.a.f(2, this.vFA);
            }
            if (this.vFB != null) {
                f += e.a.a.b.b.a.f(3, this.vFB);
            }
            AppMethodBeat.o(94508);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94508);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dt dtVar = (dt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dtVar.vFz = aVar3.BTU.readString();
                    AppMethodBeat.o(94508);
                    return 0;
                case 2:
                    dtVar.vFA = aVar3.BTU.readString();
                    AppMethodBeat.o(94508);
                    return 0;
                case 3:
                    dtVar.vFB = aVar3.BTU.readString();
                    AppMethodBeat.o(94508);
                    return 0;
                default:
                    AppMethodBeat.o(94508);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94508);
            return -1;
        }
    }
}
