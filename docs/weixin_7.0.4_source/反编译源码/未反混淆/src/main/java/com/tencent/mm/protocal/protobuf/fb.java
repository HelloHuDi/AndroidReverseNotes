package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class fb extends a {
    public b vGZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28313);
        e.a.a.b bVar;
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGZ == null) {
                bVar = new e.a.a.b("Not all required fields were included: Cookies");
                AppMethodBeat.o(28313);
                throw bVar;
            }
            if (this.vGZ != null) {
                aVar.c(1, this.vGZ);
            }
            AppMethodBeat.o(28313);
            return 0;
        } else if (i == 1) {
            if (this.vGZ != null) {
                b = e.a.a.b.b.a.b(1, this.vGZ) + 0;
            } else {
                b = 0;
            }
            AppMethodBeat.o(28313);
            return b;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            if (this.vGZ == null) {
                bVar = new e.a.a.b("Not all required fields were included: Cookies");
                AppMethodBeat.o(28313);
                throw bVar;
            }
            AppMethodBeat.o(28313);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fb fbVar = (fb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbVar.vGZ = aVar3.BTU.emu();
                    AppMethodBeat.o(28313);
                    return 0;
                default:
                    AppMethodBeat.o(28313);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28313);
            return -1;
        }
    }
}
