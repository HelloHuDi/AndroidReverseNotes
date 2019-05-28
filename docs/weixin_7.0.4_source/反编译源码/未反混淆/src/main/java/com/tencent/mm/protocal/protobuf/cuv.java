package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cuv extends a {
    public String xqS;
    public String xqT;
    public String xqU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28763);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xqS == null) {
                bVar = new b("Not all required fields were included: Plugin");
                AppMethodBeat.o(28763);
                throw bVar;
            } else if (this.xqT == null) {
                bVar = new b("Not all required fields were included: ActivityPath");
                AppMethodBeat.o(28763);
                throw bVar;
            } else {
                if (this.xqS != null) {
                    aVar.e(1, this.xqS);
                }
                if (this.xqT != null) {
                    aVar.e(2, this.xqT);
                }
                if (this.xqU != null) {
                    aVar.e(3, this.xqU);
                }
                AppMethodBeat.o(28763);
                return 0;
            }
        } else if (i == 1) {
            if (this.xqS != null) {
                f = e.a.a.b.b.a.f(1, this.xqS) + 0;
            } else {
                f = 0;
            }
            if (this.xqT != null) {
                f += e.a.a.b.b.a.f(2, this.xqT);
            }
            if (this.xqU != null) {
                f += e.a.a.b.b.a.f(3, this.xqU);
            }
            AppMethodBeat.o(28763);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xqS == null) {
                bVar = new b("Not all required fields were included: Plugin");
                AppMethodBeat.o(28763);
                throw bVar;
            } else if (this.xqT == null) {
                bVar = new b("Not all required fields were included: ActivityPath");
                AppMethodBeat.o(28763);
                throw bVar;
            } else {
                AppMethodBeat.o(28763);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuv cuv = (cuv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuv.xqS = aVar3.BTU.readString();
                    AppMethodBeat.o(28763);
                    return 0;
                case 2:
                    cuv.xqT = aVar3.BTU.readString();
                    AppMethodBeat.o(28763);
                    return 0;
                case 3:
                    cuv.xqU = aVar3.BTU.readString();
                    AppMethodBeat.o(28763);
                    return 0;
                default:
                    AppMethodBeat.o(28763);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28763);
            return -1;
        }
    }
}
