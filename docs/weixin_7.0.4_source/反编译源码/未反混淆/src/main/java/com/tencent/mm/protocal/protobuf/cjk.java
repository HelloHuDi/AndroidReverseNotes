package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cjk extends a {
    public String content;
    public int kCl;
    public int state;
    public String wYm;
    public int wYq;
    public String wYs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114992);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYs != null) {
                aVar.e(1, this.wYs);
            }
            aVar.iz(2, this.kCl);
            if (this.content != null) {
                aVar.e(3, this.content);
            }
            if (this.wYm != null) {
                aVar.e(4, this.wYm);
            }
            aVar.iz(5, this.wYq);
            aVar.iz(6, this.state);
            AppMethodBeat.o(114992);
            return 0;
        } else if (i == 1) {
            if (this.wYs != null) {
                f = e.a.a.b.b.a.f(1, this.wYs) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.kCl);
            if (this.content != null) {
                f += e.a.a.b.b.a.f(3, this.content);
            }
            if (this.wYm != null) {
                f += e.a.a.b.b.a.f(4, this.wYm);
            }
            int bs = (f + e.a.a.b.b.a.bs(5, this.wYq)) + e.a.a.b.b.a.bs(6, this.state);
            AppMethodBeat.o(114992);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114992);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cjk cjk = (cjk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjk.wYs = aVar3.BTU.readString();
                    AppMethodBeat.o(114992);
                    return 0;
                case 2:
                    cjk.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(114992);
                    return 0;
                case 3:
                    cjk.content = aVar3.BTU.readString();
                    AppMethodBeat.o(114992);
                    return 0;
                case 4:
                    cjk.wYm = aVar3.BTU.readString();
                    AppMethodBeat.o(114992);
                    return 0;
                case 5:
                    cjk.wYq = aVar3.BTU.vd();
                    AppMethodBeat.o(114992);
                    return 0;
                case 6:
                    cjk.state = aVar3.BTU.vd();
                    AppMethodBeat.o(114992);
                    return 0;
                default:
                    AppMethodBeat.o(114992);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114992);
            return -1;
        }
    }
}
