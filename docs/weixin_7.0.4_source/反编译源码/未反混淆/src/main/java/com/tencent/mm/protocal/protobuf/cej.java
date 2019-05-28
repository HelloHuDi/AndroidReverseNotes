package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cej extends a {
    public int rTW;
    public int xdZ;
    public long xee;
    public boolean xef;
    public LinkedList<String> xeg = new LinkedList();
    public LinkedList<String> xeh = new LinkedList();

    public cej() {
        AppMethodBeat.i(56525);
        AppMethodBeat.o(56525);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56526);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xee);
            aVar.iz(2, this.rTW);
            aVar.iz(3, this.xdZ);
            aVar.aO(4, this.xef);
            aVar.e(5, 1, this.xeg);
            aVar.e(6, 1, this.xeh);
            AppMethodBeat.o(56526);
            return 0;
        } else if (i == 1) {
            o = (((((e.a.a.b.b.a.o(1, this.xee) + 0) + e.a.a.b.b.a.bs(2, this.rTW)) + e.a.a.b.b.a.bs(3, this.xdZ)) + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.a.c(5, 1, this.xeg)) + e.a.a.a.c(6, 1, this.xeh);
            AppMethodBeat.o(56526);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xeg.clear();
            this.xeh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56526);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cej cej = (cej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cej.xee = aVar3.BTU.ve();
                    AppMethodBeat.o(56526);
                    return 0;
                case 2:
                    cej.rTW = aVar3.BTU.vd();
                    AppMethodBeat.o(56526);
                    return 0;
                case 3:
                    cej.xdZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56526);
                    return 0;
                case 4:
                    cej.xef = aVar3.BTU.ehX();
                    AppMethodBeat.o(56526);
                    return 0;
                case 5:
                    cej.xeg.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56526);
                    return 0;
                case 6:
                    cej.xeh.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56526);
                    return 0;
                default:
                    AppMethodBeat.o(56526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56526);
            return -1;
        }
    }
}
