package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bxh extends a {
    public b wBe;
    public b wXp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124362);
        e.a.a.b bVar;
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXp == null) {
                bVar = new e.a.a.b("Not all required fields were included: Name");
                AppMethodBeat.o(124362);
                throw bVar;
            } else if (this.wBe == null) {
                bVar = new e.a.a.b("Not all required fields were included: Value");
                AppMethodBeat.o(124362);
                throw bVar;
            } else {
                if (this.wXp != null) {
                    aVar.c(1, this.wXp);
                }
                if (this.wBe != null) {
                    aVar.c(2, this.wBe);
                }
                AppMethodBeat.o(124362);
                return 0;
            }
        } else if (i == 1) {
            if (this.wXp != null) {
                b = e.a.a.b.b.a.b(1, this.wXp) + 0;
            } else {
                b = 0;
            }
            if (this.wBe != null) {
                b += e.a.a.b.b.a.b(2, this.wBe);
            }
            AppMethodBeat.o(124362);
            return b;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            if (this.wXp == null) {
                bVar = new e.a.a.b("Not all required fields were included: Name");
                AppMethodBeat.o(124362);
                throw bVar;
            } else if (this.wBe == null) {
                bVar = new e.a.a.b("Not all required fields were included: Value");
                AppMethodBeat.o(124362);
                throw bVar;
            } else {
                AppMethodBeat.o(124362);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxh bxh = (bxh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxh.wXp = aVar3.BTU.emu();
                    AppMethodBeat.o(124362);
                    return 0;
                case 2:
                    bxh.wBe = aVar3.BTU.emu();
                    AppMethodBeat.o(124362);
                    return 0;
                default:
                    AppMethodBeat.o(124362);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124362);
            return -1;
        }
    }
}
