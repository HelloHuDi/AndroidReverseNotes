package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class va extends a {
    public String data;
    public String wcw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96217);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.data != null) {
                aVar.e(1, this.data);
            }
            if (this.wcw != null) {
                aVar.e(2, this.wcw);
            }
            AppMethodBeat.o(96217);
            return 0;
        } else if (i == 1) {
            if (this.data != null) {
                f = e.a.a.b.b.a.f(1, this.data) + 0;
            } else {
                f = 0;
            }
            if (this.wcw != null) {
                f += e.a.a.b.b.a.f(2, this.wcw);
            }
            AppMethodBeat.o(96217);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96217);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            va vaVar = (va) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vaVar.data = aVar3.BTU.readString();
                    AppMethodBeat.o(96217);
                    return 0;
                case 2:
                    vaVar.wcw = aVar3.BTU.readString();
                    AppMethodBeat.o(96217);
                    return 0;
                default:
                    AppMethodBeat.o(96217);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96217);
            return -1;
        }
    }
}
