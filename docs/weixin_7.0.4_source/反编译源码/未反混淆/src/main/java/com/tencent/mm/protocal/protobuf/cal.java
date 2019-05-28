package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cal extends a {
    public String key;
    public String value;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94561);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            if (this.value != null) {
                aVar.e(2, this.value);
            }
            AppMethodBeat.o(94561);
            return 0;
        } else if (i == 1) {
            if (this.key != null) {
                f = e.a.a.b.b.a.f(1, this.key) + 0;
            } else {
                f = 0;
            }
            if (this.value != null) {
                f += e.a.a.b.b.a.f(2, this.value);
            }
            AppMethodBeat.o(94561);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94561);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cal cal = (cal) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cal.key = aVar3.BTU.readString();
                    AppMethodBeat.o(94561);
                    return 0;
                case 2:
                    cal.value = aVar3.BTU.readString();
                    AppMethodBeat.o(94561);
                    return 0;
                default:
                    AppMethodBeat.o(94561);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94561);
            return -1;
        }
    }
}
