package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class j extends a {
    public LinkedList<String> jBx = new LinkedList();
    public LinkedList<Long> jBy = new LinkedList();

    public j() {
        AppMethodBeat.i(18055);
        AppMethodBeat.o(18055);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18056);
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.jBx);
            aVar.e(2, 3, this.jBy);
            AppMethodBeat.o(18056);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 1, this.jBx) + 0) + e.a.a.a.c(2, 3, this.jBy);
            AppMethodBeat.o(18056);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jBx.clear();
            this.jBy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(18056);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jVar.jBx.add(aVar3.BTU.readString());
                    AppMethodBeat.o(18056);
                    return 0;
                case 2:
                    jVar.jBy.add(Long.valueOf(aVar3.BTU.ve()));
                    AppMethodBeat.o(18056);
                    return 0;
                default:
                    AppMethodBeat.o(18056);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18056);
            return -1;
        }
    }
}
