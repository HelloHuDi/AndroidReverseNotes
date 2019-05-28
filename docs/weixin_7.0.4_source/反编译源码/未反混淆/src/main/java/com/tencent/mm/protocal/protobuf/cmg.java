package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cmg extends a {
    public String guS;
    public String jBB;
    public String jCH;
    public String vEA;
    public String wbw;
    public String xkl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124372);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(124372);
                throw bVar;
            } else if (this.xkl == null) {
                bVar = new b("Not all required fields were included: MatchWord");
                AppMethodBeat.o(124372);
                throw bVar;
            } else {
                if (this.jBB != null) {
                    aVar.e(1, this.jBB);
                }
                if (this.xkl != null) {
                    aVar.e(2, this.xkl);
                }
                if (this.jCH != null) {
                    aVar.e(3, this.jCH);
                }
                if (this.wbw != null) {
                    aVar.e(4, this.wbw);
                }
                if (this.guS != null) {
                    aVar.e(5, this.guS);
                }
                if (this.vEA != null) {
                    aVar.e(6, this.vEA);
                }
                AppMethodBeat.o(124372);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.xkl != null) {
                f += e.a.a.b.b.a.f(2, this.xkl);
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(3, this.jCH);
            }
            if (this.wbw != null) {
                f += e.a.a.b.b.a.f(4, this.wbw);
            }
            if (this.guS != null) {
                f += e.a.a.b.b.a.f(5, this.guS);
            }
            if (this.vEA != null) {
                f += e.a.a.b.b.a.f(6, this.vEA);
            }
            AppMethodBeat.o(124372);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(124372);
                throw bVar;
            } else if (this.xkl == null) {
                bVar = new b("Not all required fields were included: MatchWord");
                AppMethodBeat.o(124372);
                throw bVar;
            } else {
                AppMethodBeat.o(124372);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmg cmg = (cmg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmg.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(124372);
                    return 0;
                case 2:
                    cmg.xkl = aVar3.BTU.readString();
                    AppMethodBeat.o(124372);
                    return 0;
                case 3:
                    cmg.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(124372);
                    return 0;
                case 4:
                    cmg.wbw = aVar3.BTU.readString();
                    AppMethodBeat.o(124372);
                    return 0;
                case 5:
                    cmg.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(124372);
                    return 0;
                case 6:
                    cmg.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(124372);
                    return 0;
                default:
                    AppMethodBeat.o(124372);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124372);
            return -1;
        }
    }
}
