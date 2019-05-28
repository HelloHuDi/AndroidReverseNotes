package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bu extends a {
    public String desc;
    public String ffv;
    public String kLe;
    public String ncD;
    public String title;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111627);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.ffv != null) {
                aVar.e(2, this.ffv);
            }
            if (this.kLe != null) {
                aVar.e(3, this.kLe);
            }
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            if (this.ncD != null) {
                aVar.e(5, this.ncD);
            }
            AppMethodBeat.o(111627);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.ffv != null) {
                f += e.a.a.b.b.a.f(2, this.ffv);
            }
            if (this.kLe != null) {
                f += e.a.a.b.b.a.f(3, this.kLe);
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(4, this.desc);
            }
            if (this.ncD != null) {
                f += e.a.a.b.b.a.f(5, this.ncD);
            }
            AppMethodBeat.o(111627);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111627);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bu buVar = (bu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    buVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(111627);
                    return 0;
                case 2:
                    buVar.ffv = aVar3.BTU.readString();
                    AppMethodBeat.o(111627);
                    return 0;
                case 3:
                    buVar.kLe = aVar3.BTU.readString();
                    AppMethodBeat.o(111627);
                    return 0;
                case 4:
                    buVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111627);
                    return 0;
                case 5:
                    buVar.ncD = aVar3.BTU.readString();
                    AppMethodBeat.o(111627);
                    return 0;
                default:
                    AppMethodBeat.o(111627);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111627);
            return -1;
        }
    }
}
