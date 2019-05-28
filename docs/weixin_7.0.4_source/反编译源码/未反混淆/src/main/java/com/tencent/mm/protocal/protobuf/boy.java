package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class boy extends a {
    public String jBB;
    public String wfK;
    public String wlF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102512);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.wlF != null) {
                aVar.e(2, this.wlF);
            }
            if (this.wfK != null) {
                aVar.e(3, this.wfK);
            }
            AppMethodBeat.o(102512);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.wlF != null) {
                f += e.a.a.b.b.a.f(2, this.wlF);
            }
            if (this.wfK != null) {
                f += e.a.a.b.b.a.f(3, this.wfK);
            }
            AppMethodBeat.o(102512);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102512);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            boy boy = (boy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    boy.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(102512);
                    return 0;
                case 2:
                    boy.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(102512);
                    return 0;
                case 3:
                    boy.wfK = aVar3.BTU.readString();
                    AppMethodBeat.o(102512);
                    return 0;
                default:
                    AppMethodBeat.o(102512);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102512);
            return -1;
        }
    }
}
