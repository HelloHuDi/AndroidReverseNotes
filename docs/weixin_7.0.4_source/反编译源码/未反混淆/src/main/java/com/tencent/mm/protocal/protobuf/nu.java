package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nu extends a {
    public String vTn;
    public LinkedList<String> vTo = new LinkedList();

    public nu() {
        AppMethodBeat.i(89028);
        AppMethodBeat.o(89028);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89029);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTn != null) {
                aVar.e(1, this.vTn);
            }
            aVar.e(2, 1, this.vTo);
            AppMethodBeat.o(89029);
            return 0;
        } else if (i == 1) {
            if (this.vTn != null) {
                f = e.a.a.b.b.a.f(1, this.vTn) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 1, this.vTo);
            AppMethodBeat.o(89029);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vTo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89029);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nu nuVar = (nu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nuVar.vTn = aVar3.BTU.readString();
                    AppMethodBeat.o(89029);
                    return 0;
                case 2:
                    nuVar.vTo.add(aVar3.BTU.readString());
                    AppMethodBeat.o(89029);
                    return 0;
                default:
                    AppMethodBeat.o(89029);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89029);
            return -1;
        }
    }
}
