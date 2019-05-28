package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cit extends a {
    public int Height;
    public int Width;
    public int X;
    public int Y;
    public String wIG;
    public int weB;
    public String xhG;
    public int xhH;
    public int xhI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(81507);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.X);
            aVar.iz(2, this.Y);
            aVar.iz(3, this.Width);
            aVar.iz(4, this.Height);
            if (this.xhG != null) {
                aVar.e(5, this.xhG);
            }
            if (this.wIG != null) {
                aVar.e(6, this.wIG);
            }
            aVar.iz(7, this.xhH);
            aVar.iz(8, this.weB);
            aVar.iz(9, this.xhI);
            AppMethodBeat.o(81507);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.X) + 0) + e.a.a.b.b.a.bs(2, this.Y)) + e.a.a.b.b.a.bs(3, this.Width)) + e.a.a.b.b.a.bs(4, this.Height);
            if (this.xhG != null) {
                bs += e.a.a.b.b.a.f(5, this.xhG);
            }
            if (this.wIG != null) {
                bs += e.a.a.b.b.a.f(6, this.wIG);
            }
            bs = ((bs + e.a.a.b.b.a.bs(7, this.xhH)) + e.a.a.b.b.a.bs(8, this.weB)) + e.a.a.b.b.a.bs(9, this.xhI);
            AppMethodBeat.o(81507);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(81507);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cit cit = (cit) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cit.X = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                case 2:
                    cit.Y = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                case 3:
                    cit.Width = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                case 4:
                    cit.Height = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                case 5:
                    cit.xhG = aVar3.BTU.readString();
                    AppMethodBeat.o(81507);
                    return 0;
                case 6:
                    cit.wIG = aVar3.BTU.readString();
                    AppMethodBeat.o(81507);
                    return 0;
                case 7:
                    cit.xhH = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                case 8:
                    cit.weB = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                case 9:
                    cit.xhI = aVar3.BTU.vd();
                    AppMethodBeat.o(81507);
                    return 0;
                default:
                    AppMethodBeat.o(81507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(81507);
            return -1;
        }
    }
}
