package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class oj extends a {
    public String code;
    public String csB;
    public String kbU;
    public String vUJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89044);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kbU != null) {
                aVar.e(1, this.kbU);
            }
            if (this.code != null) {
                aVar.e(2, this.code);
            }
            if (this.vUJ != null) {
                aVar.e(3, this.vUJ);
            }
            if (this.csB != null) {
                aVar.e(4, this.csB);
            }
            AppMethodBeat.o(89044);
            return 0;
        } else if (i == 1) {
            if (this.kbU != null) {
                f = e.a.a.b.b.a.f(1, this.kbU) + 0;
            } else {
                f = 0;
            }
            if (this.code != null) {
                f += e.a.a.b.b.a.f(2, this.code);
            }
            if (this.vUJ != null) {
                f += e.a.a.b.b.a.f(3, this.vUJ);
            }
            if (this.csB != null) {
                f += e.a.a.b.b.a.f(4, this.csB);
            }
            AppMethodBeat.o(89044);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89044);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oj ojVar = (oj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ojVar.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(89044);
                    return 0;
                case 2:
                    ojVar.code = aVar3.BTU.readString();
                    AppMethodBeat.o(89044);
                    return 0;
                case 3:
                    ojVar.vUJ = aVar3.BTU.readString();
                    AppMethodBeat.o(89044);
                    return 0;
                case 4:
                    ojVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(89044);
                    return 0;
                default:
                    AppMethodBeat.o(89044);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89044);
            return -1;
        }
    }
}
