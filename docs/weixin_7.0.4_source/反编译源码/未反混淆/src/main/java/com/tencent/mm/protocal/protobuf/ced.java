package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ced extends a {
    public String xdN;
    public String xdO;
    public String xdP;
    public String xdQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56512);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xdN == null) {
                bVar = new b("Not all required fields were included: videoFileMD5");
                AppMethodBeat.o(56512);
                throw bVar;
            }
            if (this.xdN != null) {
                aVar.e(1, this.xdN);
            }
            if (this.xdO != null) {
                aVar.e(2, this.xdO);
            }
            if (this.xdP != null) {
                aVar.e(3, this.xdP);
            }
            if (this.xdQ != null) {
                aVar.e(4, this.xdQ);
            }
            AppMethodBeat.o(56512);
            return 0;
        } else if (i == 1) {
            if (this.xdN != null) {
                f = e.a.a.b.b.a.f(1, this.xdN) + 0;
            } else {
                f = 0;
            }
            if (this.xdO != null) {
                f += e.a.a.b.b.a.f(2, this.xdO);
            }
            if (this.xdP != null) {
                f += e.a.a.b.b.a.f(3, this.xdP);
            }
            if (this.xdQ != null) {
                f += e.a.a.b.b.a.f(4, this.xdQ);
            }
            AppMethodBeat.o(56512);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xdN == null) {
                bVar = new b("Not all required fields were included: videoFileMD5");
                AppMethodBeat.o(56512);
                throw bVar;
            }
            AppMethodBeat.o(56512);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ced ced = (ced) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ced.xdN = aVar3.BTU.readString();
                    AppMethodBeat.o(56512);
                    return 0;
                case 2:
                    ced.xdO = aVar3.BTU.readString();
                    AppMethodBeat.o(56512);
                    return 0;
                case 3:
                    ced.xdP = aVar3.BTU.readString();
                    AppMethodBeat.o(56512);
                    return 0;
                case 4:
                    ced.xdQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56512);
                    return 0;
                default:
                    AppMethodBeat.o(56512);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56512);
            return -1;
        }
    }
}
