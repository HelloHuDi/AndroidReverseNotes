package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aue extends a {
    public String desc;
    public String title;
    public String wyc;
    public String wyd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10196);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.wyc != null) {
                aVar.e(3, this.wyc);
            }
            if (this.wyd != null) {
                aVar.e(4, this.wyd);
            }
            AppMethodBeat.o(10196);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.wyc != null) {
                f += e.a.a.b.b.a.f(3, this.wyc);
            }
            if (this.wyd != null) {
                f += e.a.a.b.b.a.f(4, this.wyd);
            }
            AppMethodBeat.o(10196);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10196);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aue aue = (aue) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aue.title = aVar3.BTU.readString();
                    AppMethodBeat.o(10196);
                    return 0;
                case 2:
                    aue.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(10196);
                    return 0;
                case 3:
                    aue.wyc = aVar3.BTU.readString();
                    AppMethodBeat.o(10196);
                    return 0;
                case 4:
                    aue.wyd = aVar3.BTU.readString();
                    AppMethodBeat.o(10196);
                    return 0;
                default:
                    AppMethodBeat.o(10196);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10196);
            return -1;
        }
    }
}
