package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class d extends a {
    public int cKc;
    public String desc;
    public String mjO;
    public String thumbPath;
    public String title;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111122);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.thumbPath != null) {
                aVar.e(3, this.thumbPath);
            }
            aVar.iz(4, this.cKc);
            if (this.mjO != null) {
                aVar.e(5, this.mjO);
            }
            AppMethodBeat.o(111122);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.thumbPath != null) {
                f += e.a.a.b.b.a.f(3, this.thumbPath);
            }
            f += e.a.a.b.b.a.bs(4, this.cKc);
            if (this.mjO != null) {
                f += e.a.a.b.b.a.f(5, this.mjO);
            }
            AppMethodBeat.o(111122);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111122);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(111122);
                    return 0;
                case 2:
                    dVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111122);
                    return 0;
                case 3:
                    dVar.thumbPath = aVar3.BTU.readString();
                    AppMethodBeat.o(111122);
                    return 0;
                case 4:
                    dVar.cKc = aVar3.BTU.vd();
                    AppMethodBeat.o(111122);
                    return 0;
                case 5:
                    dVar.mjO = aVar3.BTU.readString();
                    AppMethodBeat.o(111122);
                    return 0;
                default:
                    AppMethodBeat.o(111122);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111122);
            return -1;
        }
    }
}
