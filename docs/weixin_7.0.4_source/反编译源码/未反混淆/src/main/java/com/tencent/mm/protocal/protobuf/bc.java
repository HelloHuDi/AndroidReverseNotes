package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bc extends a {
    public String cEh;
    public String cIY;
    public String tID;
    public int tIE;
    public String title;
    public String ttg;
    public String tzW;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56698);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            if (this.cIY != null) {
                aVar.e(3, this.cIY);
            }
            if (this.tID != null) {
                aVar.e(4, this.tID);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.tzW != null) {
                aVar.e(6, this.tzW);
            }
            if (this.ttg != null) {
                aVar.e(7, this.ttg);
            }
            aVar.iz(8, this.tIE);
            AppMethodBeat.o(56698);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = e.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(3, this.cIY);
            }
            if (this.tID != null) {
                f += e.a.a.b.b.a.f(4, this.tID);
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(5, this.title);
            }
            if (this.tzW != null) {
                f += e.a.a.b.b.a.f(6, this.tzW);
            }
            if (this.ttg != null) {
                f += e.a.a.b.b.a.f(7, this.ttg);
            }
            int bs = f + e.a.a.b.b.a.bs(8, this.tIE);
            AppMethodBeat.o(56698);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56698);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bc bcVar = (bc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 2:
                    bcVar.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 3:
                    bcVar.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 4:
                    bcVar.tID = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 5:
                    bcVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 6:
                    bcVar.tzW = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 7:
                    bcVar.ttg = aVar3.BTU.readString();
                    AppMethodBeat.o(56698);
                    return 0;
                case 8:
                    bcVar.tIE = aVar3.BTU.vd();
                    AppMethodBeat.o(56698);
                    return 0;
                default:
                    AppMethodBeat.o(56698);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56698);
            return -1;
        }
    }
}
