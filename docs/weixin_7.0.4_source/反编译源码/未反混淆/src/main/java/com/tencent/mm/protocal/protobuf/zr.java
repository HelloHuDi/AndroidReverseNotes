package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class zr extends a {
    public String key;
    public String value;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56779);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.key == null) {
                bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(56779);
                throw bVar;
            } else if (this.value == null) {
                bVar = new b("Not all required fields were included: value");
                AppMethodBeat.o(56779);
                throw bVar;
            } else {
                if (this.key != null) {
                    aVar.e(1, this.key);
                }
                if (this.value != null) {
                    aVar.e(2, this.value);
                }
                AppMethodBeat.o(56779);
                return 0;
            }
        } else if (i == 1) {
            if (this.key != null) {
                f = e.a.a.b.b.a.f(1, this.key) + 0;
            } else {
                f = 0;
            }
            if (this.value != null) {
                f += e.a.a.b.b.a.f(2, this.value);
            }
            AppMethodBeat.o(56779);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.key == null) {
                bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(56779);
                throw bVar;
            } else if (this.value == null) {
                bVar = new b("Not all required fields were included: value");
                AppMethodBeat.o(56779);
                throw bVar;
            } else {
                AppMethodBeat.o(56779);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zr zrVar = (zr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zrVar.key = aVar3.BTU.readString();
                    AppMethodBeat.o(56779);
                    return 0;
                case 2:
                    zrVar.value = aVar3.BTU.readString();
                    AppMethodBeat.o(56779);
                    return 0;
                default:
                    AppMethodBeat.o(56779);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56779);
            return -1;
        }
    }
}
