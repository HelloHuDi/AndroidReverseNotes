package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzj extends a {
    public String content;
    public int state;
    public String wYm;
    public String wYn;
    public String wYo;
    public String wYp;
    public int wYq;
    public String wYr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114986);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.content != null) {
                aVar.e(1, this.content);
            }
            if (this.wYm != null) {
                aVar.e(2, this.wYm);
            }
            if (this.wYn != null) {
                aVar.e(3, this.wYn);
            }
            if (this.wYo != null) {
                aVar.e(4, this.wYo);
            }
            if (this.wYp != null) {
                aVar.e(5, this.wYp);
            }
            aVar.iz(6, this.wYq);
            aVar.iz(7, this.state);
            if (this.wYr != null) {
                aVar.e(8, this.wYr);
            }
            AppMethodBeat.o(114986);
            return 0;
        } else if (i == 1) {
            if (this.content != null) {
                f = e.a.a.b.b.a.f(1, this.content) + 0;
            } else {
                f = 0;
            }
            if (this.wYm != null) {
                f += e.a.a.b.b.a.f(2, this.wYm);
            }
            if (this.wYn != null) {
                f += e.a.a.b.b.a.f(3, this.wYn);
            }
            if (this.wYo != null) {
                f += e.a.a.b.b.a.f(4, this.wYo);
            }
            if (this.wYp != null) {
                f += e.a.a.b.b.a.f(5, this.wYp);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.wYq)) + e.a.a.b.b.a.bs(7, this.state);
            if (this.wYr != null) {
                f += e.a.a.b.b.a.f(8, this.wYr);
            }
            AppMethodBeat.o(114986);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114986);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzj bzj = (bzj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzj.content = aVar3.BTU.readString();
                    AppMethodBeat.o(114986);
                    return 0;
                case 2:
                    bzj.wYm = aVar3.BTU.readString();
                    AppMethodBeat.o(114986);
                    return 0;
                case 3:
                    bzj.wYn = aVar3.BTU.readString();
                    AppMethodBeat.o(114986);
                    return 0;
                case 4:
                    bzj.wYo = aVar3.BTU.readString();
                    AppMethodBeat.o(114986);
                    return 0;
                case 5:
                    bzj.wYp = aVar3.BTU.readString();
                    AppMethodBeat.o(114986);
                    return 0;
                case 6:
                    bzj.wYq = aVar3.BTU.vd();
                    AppMethodBeat.o(114986);
                    return 0;
                case 7:
                    bzj.state = aVar3.BTU.vd();
                    AppMethodBeat.o(114986);
                    return 0;
                case 8:
                    bzj.wYr = aVar3.BTU.readString();
                    AppMethodBeat.o(114986);
                    return 0;
                default:
                    AppMethodBeat.o(114986);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114986);
            return -1;
        }
    }
}
