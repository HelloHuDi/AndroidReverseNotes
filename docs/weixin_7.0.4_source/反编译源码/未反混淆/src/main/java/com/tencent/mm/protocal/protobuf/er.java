package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class er extends a {
    public int Scene;
    public String Url;
    public String vGA;
    public int vGB;
    public long vGy;
    public int vGz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14702);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            aVar.ai(2, this.vGy);
            aVar.iz(3, this.vGz);
            if (this.vGA != null) {
                aVar.e(4, this.vGA);
            }
            aVar.iz(5, this.Scene);
            aVar.iz(6, this.vGB);
            AppMethodBeat.o(14702);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = e.a.a.b.b.a.f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.o(2, this.vGy)) + e.a.a.b.b.a.bs(3, this.vGz);
            if (this.vGA != null) {
                f += e.a.a.b.b.a.f(4, this.vGA);
            }
            int bs = (f + e.a.a.b.b.a.bs(5, this.Scene)) + e.a.a.b.b.a.bs(6, this.vGB);
            AppMethodBeat.o(14702);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14702);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            er erVar = (er) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    erVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(14702);
                    return 0;
                case 2:
                    erVar.vGy = aVar3.BTU.ve();
                    AppMethodBeat.o(14702);
                    return 0;
                case 3:
                    erVar.vGz = aVar3.BTU.vd();
                    AppMethodBeat.o(14702);
                    return 0;
                case 4:
                    erVar.vGA = aVar3.BTU.readString();
                    AppMethodBeat.o(14702);
                    return 0;
                case 5:
                    erVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(14702);
                    return 0;
                case 6:
                    erVar.vGB = aVar3.BTU.vd();
                    AppMethodBeat.o(14702);
                    return 0;
                default:
                    AppMethodBeat.o(14702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14702);
            return -1;
        }
    }
}
