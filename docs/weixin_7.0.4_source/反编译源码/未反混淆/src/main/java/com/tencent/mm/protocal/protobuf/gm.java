package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class gm extends a {
    public LinkedList<String> vII = new LinkedList();
    public int vIJ;
    public int vIK;

    public gm() {
        AppMethodBeat.i(62511);
        AppMethodBeat.o(62511);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62512);
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.vII);
            aVar.iz(2, this.vIJ);
            aVar.iz(3, this.vIK);
            AppMethodBeat.o(62512);
            return 0;
        } else if (i == 1) {
            c = ((e.a.a.a.c(1, 1, this.vII) + 0) + e.a.a.b.b.a.bs(2, this.vIJ)) + e.a.a.b.b.a.bs(3, this.vIK);
            AppMethodBeat.o(62512);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vII.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62512);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gm gmVar = (gm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gmVar.vII.add(aVar3.BTU.readString());
                    AppMethodBeat.o(62512);
                    return 0;
                case 2:
                    gmVar.vIJ = aVar3.BTU.vd();
                    AppMethodBeat.o(62512);
                    return 0;
                case 3:
                    gmVar.vIK = aVar3.BTU.vd();
                    AppMethodBeat.o(62512);
                    return 0;
                default:
                    AppMethodBeat.o(62512);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62512);
            return -1;
        }
    }
}
