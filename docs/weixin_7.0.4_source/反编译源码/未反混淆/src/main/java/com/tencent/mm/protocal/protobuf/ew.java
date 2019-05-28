package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ew extends a {
    public int height;
    public String url;
    public int vGK;
    public int vGL;
    public long vGM;
    public int vGN;
    public int width;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14706);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            aVar.iz(2, this.vGK);
            aVar.iz(3, this.vGL);
            aVar.ai(4, this.vGM);
            aVar.iz(5, this.width);
            aVar.iz(6, this.height);
            aVar.iz(10, this.vGN);
            AppMethodBeat.o(14706);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = e.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                f = 0;
            }
            int bs = (((((f + e.a.a.b.b.a.bs(2, this.vGK)) + e.a.a.b.b.a.bs(3, this.vGL)) + e.a.a.b.b.a.o(4, this.vGM)) + e.a.a.b.b.a.bs(5, this.width)) + e.a.a.b.b.a.bs(6, this.height)) + e.a.a.b.b.a.bs(10, this.vGN);
            AppMethodBeat.o(14706);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14706);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ew ewVar = (ew) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ewVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(14706);
                    return 0;
                case 2:
                    ewVar.vGK = aVar3.BTU.vd();
                    AppMethodBeat.o(14706);
                    return 0;
                case 3:
                    ewVar.vGL = aVar3.BTU.vd();
                    AppMethodBeat.o(14706);
                    return 0;
                case 4:
                    ewVar.vGM = aVar3.BTU.ve();
                    AppMethodBeat.o(14706);
                    return 0;
                case 5:
                    ewVar.width = aVar3.BTU.vd();
                    AppMethodBeat.o(14706);
                    return 0;
                case 6:
                    ewVar.height = aVar3.BTU.vd();
                    AppMethodBeat.o(14706);
                    return 0;
                case 10:
                    ewVar.vGN = aVar3.BTU.vd();
                    AppMethodBeat.o(14706);
                    return 0;
                default:
                    AppMethodBeat.o(14706);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14706);
            return -1;
        }
    }
}
