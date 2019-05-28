package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bzm extends a {
    public LinkedList<String> wYv = new LinkedList();
    public LinkedList<String> wYw = new LinkedList();
    public LinkedList<Integer> wYx = new LinkedList();
    public LinkedList<Integer> wYy = new LinkedList();

    public bzm() {
        AppMethodBeat.i(89146);
        AppMethodBeat.o(89146);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89147);
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.wYv);
            aVar.e(2, 1, this.wYw);
            aVar.e(3, 2, this.wYx);
            aVar.e(4, 2, this.wYy);
            AppMethodBeat.o(89147);
            return 0;
        } else if (i == 1) {
            c = (((e.a.a.a.c(1, 1, this.wYv) + 0) + e.a.a.a.c(2, 1, this.wYw)) + e.a.a.a.c(3, 2, this.wYx)) + e.a.a.a.c(4, 2, this.wYy);
            AppMethodBeat.o(89147);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wYv.clear();
            this.wYw.clear();
            this.wYx.clear();
            this.wYy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89147);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzm bzm = (bzm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzm.wYv.add(aVar3.BTU.readString());
                    AppMethodBeat.o(89147);
                    return 0;
                case 2:
                    bzm.wYw.add(aVar3.BTU.readString());
                    AppMethodBeat.o(89147);
                    return 0;
                case 3:
                    bzm.wYx.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(89147);
                    return 0;
                case 4:
                    bzm.wYy.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(89147);
                    return 0;
                default:
                    AppMethodBeat.o(89147);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89147);
            return -1;
        }
    }
}
