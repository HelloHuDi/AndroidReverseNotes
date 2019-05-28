package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class af extends a {
    public String jBt;
    public LinkedList<Long> jCP = new LinkedList();
    public LinkedList<String> jCQ = new LinkedList();
    public LinkedList<String> jCR = new LinkedList();

    public af() {
        AppMethodBeat.i(18081);
        AppMethodBeat.o(18081);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18082);
        b bVar;
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18082);
                throw bVar;
            }
            aVar.e(1, 3, this.jCP);
            aVar.e(2, 1, this.jCQ);
            aVar.e(3, 1, this.jCR);
            if (this.jBt != null) {
                aVar.e(4, this.jBt);
            }
            AppMethodBeat.o(18082);
            return 0;
        } else if (i == 1) {
            c = ((e.a.a.a.c(1, 3, this.jCP) + 0) + e.a.a.a.c(2, 1, this.jCQ)) + e.a.a.a.c(3, 1, this.jCR);
            if (this.jBt != null) {
                c += e.a.a.b.b.a.f(4, this.jBt);
            }
            AppMethodBeat.o(18082);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jCP.clear();
            this.jCQ.clear();
            this.jCR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18082);
                throw bVar;
            }
            AppMethodBeat.o(18082);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            af afVar = (af) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    afVar.jCP.add(Long.valueOf(aVar3.BTU.ve()));
                    AppMethodBeat.o(18082);
                    return 0;
                case 2:
                    afVar.jCQ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(18082);
                    return 0;
                case 3:
                    afVar.jCR.add(aVar3.BTU.readString());
                    AppMethodBeat.o(18082);
                    return 0;
                case 4:
                    afVar.jBt = aVar3.BTU.readString();
                    AppMethodBeat.o(18082);
                    return 0;
                default:
                    AppMethodBeat.o(18082);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18082);
            return -1;
        }
    }
}
