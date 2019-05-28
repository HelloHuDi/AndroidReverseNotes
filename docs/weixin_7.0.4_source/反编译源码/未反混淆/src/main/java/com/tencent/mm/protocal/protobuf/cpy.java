package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cpy extends a {
    public int xnY;
    public int xnZ;
    public int xoa;
    public int xob;
    public int xoc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5264);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xnY);
            aVar.iz(2, this.xnZ);
            aVar.iz(3, this.xoa);
            aVar.iz(4, this.xob);
            aVar.iz(5, this.xoc);
            AppMethodBeat.o(5264);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.xnY) + 0) + e.a.a.b.b.a.bs(2, this.xnZ)) + e.a.a.b.b.a.bs(3, this.xoa)) + e.a.a.b.b.a.bs(4, this.xob)) + e.a.a.b.b.a.bs(5, this.xoc);
            AppMethodBeat.o(5264);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5264);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpy cpy = (cpy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpy.xnY = aVar3.BTU.vd();
                    AppMethodBeat.o(5264);
                    return 0;
                case 2:
                    cpy.xnZ = aVar3.BTU.vd();
                    AppMethodBeat.o(5264);
                    return 0;
                case 3:
                    cpy.xoa = aVar3.BTU.vd();
                    AppMethodBeat.o(5264);
                    return 0;
                case 4:
                    cpy.xob = aVar3.BTU.vd();
                    AppMethodBeat.o(5264);
                    return 0;
                case 5:
                    cpy.xoc = aVar3.BTU.vd();
                    AppMethodBeat.o(5264);
                    return 0;
                default:
                    AppMethodBeat.o(5264);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5264);
            return -1;
        }
    }
}
