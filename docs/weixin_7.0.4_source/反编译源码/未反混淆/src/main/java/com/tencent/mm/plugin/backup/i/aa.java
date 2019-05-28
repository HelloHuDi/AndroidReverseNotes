package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class aa extends a {
    public String jBt;
    public long jCE;
    public long jCF;
    public String jCG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18076);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18076);
                throw bVar;
            } else if (this.jCG == null) {
                bVar = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(18076);
                throw bVar;
            } else {
                if (this.jBt != null) {
                    aVar.e(1, this.jBt);
                }
                aVar.ai(2, this.jCE);
                aVar.ai(3, this.jCF);
                if (this.jCG != null) {
                    aVar.e(4, this.jCG);
                }
                AppMethodBeat.o(18076);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBt != null) {
                f = e.a.a.b.b.a.f(1, this.jBt) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.o(2, this.jCE)) + e.a.a.b.b.a.o(3, this.jCF);
            if (this.jCG != null) {
                f += e.a.a.b.b.a.f(4, this.jCG);
            }
            AppMethodBeat.o(18076);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18076);
                throw bVar;
            } else if (this.jCG == null) {
                bVar = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(18076);
                throw bVar;
            } else {
                AppMethodBeat.o(18076);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaVar.jBt = aVar3.BTU.readString();
                    AppMethodBeat.o(18076);
                    return 0;
                case 2:
                    aaVar.jCE = aVar3.BTU.ve();
                    AppMethodBeat.o(18076);
                    return 0;
                case 3:
                    aaVar.jCF = aVar3.BTU.ve();
                    AppMethodBeat.o(18076);
                    return 0;
                case 4:
                    aaVar.jCG = aVar3.BTU.readString();
                    AppMethodBeat.o(18076);
                    return 0;
                default:
                    AppMethodBeat.o(18076);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18076);
            return -1;
        }
    }
}
