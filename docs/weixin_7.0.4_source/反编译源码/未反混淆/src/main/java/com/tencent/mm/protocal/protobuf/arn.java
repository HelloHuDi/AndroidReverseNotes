package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class arn extends a {
    public String CellTitle;
    public String wvA;
    public String wvz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80104);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.CellTitle != null) {
                aVar.e(1, this.CellTitle);
            }
            if (this.wvz != null) {
                aVar.e(2, this.wvz);
            }
            if (this.wvA != null) {
                aVar.e(3, this.wvA);
            }
            AppMethodBeat.o(80104);
            return 0;
        } else if (i == 1) {
            if (this.CellTitle != null) {
                f = e.a.a.b.b.a.f(1, this.CellTitle) + 0;
            } else {
                f = 0;
            }
            if (this.wvz != null) {
                f += e.a.a.b.b.a.f(2, this.wvz);
            }
            if (this.wvA != null) {
                f += e.a.a.b.b.a.f(3, this.wvA);
            }
            AppMethodBeat.o(80104);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80104);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arn arn = (arn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arn.CellTitle = aVar3.BTU.readString();
                    AppMethodBeat.o(80104);
                    return 0;
                case 2:
                    arn.wvz = aVar3.BTU.readString();
                    AppMethodBeat.o(80104);
                    return 0;
                case 3:
                    arn.wvA = aVar3.BTU.readString();
                    AppMethodBeat.o(80104);
                    return 0;
                default:
                    AppMethodBeat.o(80104);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80104);
            return -1;
        }
    }
}
