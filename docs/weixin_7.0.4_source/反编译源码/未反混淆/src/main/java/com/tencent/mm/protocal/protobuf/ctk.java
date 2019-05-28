package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctk extends a {
    public String jBB;
    public String jCH;
    public int jCt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28718);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(28718);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(28718);
                throw bVar;
            } else {
                if (this.jBB != null) {
                    aVar.e(1, this.jBB);
                }
                if (this.jCH != null) {
                    aVar.e(2, this.jCH);
                }
                aVar.iz(3, this.jCt);
                AppMethodBeat.o(28718);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.jCt);
            AppMethodBeat.o(28718);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(28718);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(28718);
                throw bVar;
            } else {
                AppMethodBeat.o(28718);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctk ctk = (ctk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctk.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28718);
                    return 0;
                case 2:
                    ctk.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28718);
                    return 0;
                case 3:
                    ctk.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28718);
                    return 0;
                default:
                    AppMethodBeat.o(28718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28718);
            return -1;
        }
    }
}
