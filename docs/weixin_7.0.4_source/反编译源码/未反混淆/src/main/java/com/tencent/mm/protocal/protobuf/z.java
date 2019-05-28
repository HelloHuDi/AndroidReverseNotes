package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class z extends a {
    public int vAG;
    public LinkedList<cal> vAH = new LinkedList();

    public z() {
        AppMethodBeat.i(94487);
        AppMethodBeat.o(94487);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94488);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vAG);
            aVar.e(2, 8, this.vAH);
            AppMethodBeat.o(94488);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vAG) + 0) + e.a.a.a.c(2, 8, this.vAH);
            AppMethodBeat.o(94488);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94488);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    zVar.vAG = aVar3.BTU.vd();
                    AppMethodBeat.o(94488);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cal cal = new cal();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cal.populateBuilderWithField(aVar4, cal, a.getNextFieldNumber(aVar4))) {
                        }
                        zVar.vAH.add(cal);
                    }
                    AppMethodBeat.o(94488);
                    return 0;
                default:
                    AppMethodBeat.o(94488);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94488);
            return -1;
        }
    }
}
