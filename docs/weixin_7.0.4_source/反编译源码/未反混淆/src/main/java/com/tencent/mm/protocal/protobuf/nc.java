package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nc extends a {
    public String vRI;
    public LinkedList<String> vRJ = new LinkedList();

    public nc() {
        AppMethodBeat.i(48787);
        AppMethodBeat.o(48787);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48788);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRI != null) {
                aVar.e(1, this.vRI);
            }
            aVar.e(2, 1, this.vRJ);
            AppMethodBeat.o(48788);
            return 0;
        } else if (i == 1) {
            if (this.vRI != null) {
                f = e.a.a.b.b.a.f(1, this.vRI) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 1, this.vRJ);
            AppMethodBeat.o(48788);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vRJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48788);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nc ncVar = (nc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ncVar.vRI = aVar3.BTU.readString();
                    AppMethodBeat.o(48788);
                    return 0;
                case 2:
                    ncVar.vRJ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(48788);
                    return 0;
                default:
                    AppMethodBeat.o(48788);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48788);
            return -1;
        }
    }
}
