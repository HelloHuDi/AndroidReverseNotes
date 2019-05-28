package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class clz extends a {
    public int Height;
    public int Width;
    public b xjH;
    public int xjI;
    public long xjJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124371);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xjH != null) {
                aVar.c(1, this.xjH);
            }
            aVar.iz(2, this.xjI);
            aVar.ai(3, this.xjJ);
            aVar.iz(4, this.Width);
            aVar.iz(5, this.Height);
            AppMethodBeat.o(124371);
            return 0;
        } else if (i == 1) {
            if (this.xjH != null) {
                b = e.a.a.b.b.a.b(1, this.xjH) + 0;
            } else {
                b = 0;
            }
            int bs = (((b + e.a.a.b.b.a.bs(2, this.xjI)) + e.a.a.b.b.a.o(3, this.xjJ)) + e.a.a.b.b.a.bs(4, this.Width)) + e.a.a.b.b.a.bs(5, this.Height);
            AppMethodBeat.o(124371);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124371);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clz clz = (clz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clz.xjH = aVar3.BTU.emu();
                    AppMethodBeat.o(124371);
                    return 0;
                case 2:
                    clz.xjI = aVar3.BTU.vd();
                    AppMethodBeat.o(124371);
                    return 0;
                case 3:
                    clz.xjJ = aVar3.BTU.ve();
                    AppMethodBeat.o(124371);
                    return 0;
                case 4:
                    clz.Width = aVar3.BTU.vd();
                    AppMethodBeat.o(124371);
                    return 0;
                case 5:
                    clz.Height = aVar3.BTU.vd();
                    AppMethodBeat.o(124371);
                    return 0;
                default:
                    AppMethodBeat.o(124371);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124371);
            return -1;
        }
    }
}
