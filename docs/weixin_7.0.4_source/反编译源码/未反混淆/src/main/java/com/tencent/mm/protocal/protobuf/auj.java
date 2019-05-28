package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class auj extends a {
    public float height;
    public String url;
    public String vJS;
    public float width;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48875);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.vJS != null) {
                aVar.e(2, this.vJS);
            }
            aVar.r(3, this.width);
            aVar.r(4, this.height);
            AppMethodBeat.o(48875);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = e.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.vJS != null) {
                f += e.a.a.b.b.a.f(2, this.vJS);
            }
            int fv = (f + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4);
            AppMethodBeat.o(48875);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48875);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auj auj = (auj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auj.url = aVar3.BTU.readString();
                    AppMethodBeat.o(48875);
                    return 0;
                case 2:
                    auj.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48875);
                    return 0;
                case 3:
                    auj.width = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48875);
                    return 0;
                case 4:
                    auj.height = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48875);
                    return 0;
                default:
                    AppMethodBeat.o(48875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48875);
            return -1;
        }
    }
}
