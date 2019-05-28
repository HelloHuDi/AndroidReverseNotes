package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzd extends a {
    public int Height;
    public int Width;
    public String wVm;
    public String wYi;
    public String wdO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28654);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdO != null) {
                aVar.e(1, this.wdO);
            }
            aVar.iz(2, this.Width);
            aVar.iz(3, this.Height);
            if (this.wVm != null) {
                aVar.e(4, this.wVm);
            }
            if (this.wYi != null) {
                aVar.e(5, this.wYi);
            }
            AppMethodBeat.o(28654);
            return 0;
        } else if (i == 1) {
            if (this.wdO != null) {
                f = e.a.a.b.b.a.f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.Width)) + e.a.a.b.b.a.bs(3, this.Height);
            if (this.wVm != null) {
                f += e.a.a.b.b.a.f(4, this.wVm);
            }
            if (this.wYi != null) {
                f += e.a.a.b.b.a.f(5, this.wYi);
            }
            AppMethodBeat.o(28654);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28654);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzd bzd = (bzd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzd.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(28654);
                    return 0;
                case 2:
                    bzd.Width = aVar3.BTU.vd();
                    AppMethodBeat.o(28654);
                    return 0;
                case 3:
                    bzd.Height = aVar3.BTU.vd();
                    AppMethodBeat.o(28654);
                    return 0;
                case 4:
                    bzd.wVm = aVar3.BTU.readString();
                    AppMethodBeat.o(28654);
                    return 0;
                case 5:
                    bzd.wYi = aVar3.BTU.readString();
                    AppMethodBeat.o(28654);
                    return 0;
                default:
                    AppMethodBeat.o(28654);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28654);
            return -1;
        }
    }
}
