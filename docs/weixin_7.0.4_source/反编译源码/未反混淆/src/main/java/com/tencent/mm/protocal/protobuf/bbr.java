package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bbr extends a {
    public String jBB;
    public String vEf;
    public String vXl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5596);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEf != null) {
                aVar.e(1, this.vEf);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            if (this.vXl != null) {
                aVar.e(3, this.vXl);
            }
            AppMethodBeat.o(5596);
            return 0;
        } else if (i == 1) {
            if (this.vEf != null) {
                f = e.a.a.b.b.a.f(1, this.vEf) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(2, this.jBB);
            }
            if (this.vXl != null) {
                f += e.a.a.b.b.a.f(3, this.vXl);
            }
            AppMethodBeat.o(5596);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5596);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbr bbr = (bbr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbr.vEf = aVar3.BTU.readString();
                    AppMethodBeat.o(5596);
                    return 0;
                case 2:
                    bbr.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(5596);
                    return 0;
                case 3:
                    bbr.vXl = aVar3.BTU.readString();
                    AppMethodBeat.o(5596);
                    return 0;
                default:
                    AppMethodBeat.o(5596);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5596);
            return -1;
        }
    }
}
