package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class dl extends a {
    public String ndG;
    public String ndH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111679);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndG == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(111679);
                throw bVar;
            } else if (this.ndH == null) {
                bVar = new b("Not all required fields were included: TimeDesc");
                AppMethodBeat.o(111679);
                throw bVar;
            } else {
                if (this.ndG != null) {
                    aVar.e(1, this.ndG);
                }
                if (this.ndH != null) {
                    aVar.e(2, this.ndH);
                }
                AppMethodBeat.o(111679);
                return 0;
            }
        } else if (i == 1) {
            if (this.ndG != null) {
                f = e.a.a.b.b.a.f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndH != null) {
                f += e.a.a.b.b.a.f(2, this.ndH);
            }
            AppMethodBeat.o(111679);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ndG == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(111679);
                throw bVar;
            } else if (this.ndH == null) {
                bVar = new b("Not all required fields were included: TimeDesc");
                AppMethodBeat.o(111679);
                throw bVar;
            } else {
                AppMethodBeat.o(111679);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlVar.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(111679);
                    return 0;
                case 2:
                    dlVar.ndH = aVar3.BTU.readString();
                    AppMethodBeat.o(111679);
                    return 0;
                default:
                    AppMethodBeat.o(111679);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111679);
            return -1;
        }
    }
}
