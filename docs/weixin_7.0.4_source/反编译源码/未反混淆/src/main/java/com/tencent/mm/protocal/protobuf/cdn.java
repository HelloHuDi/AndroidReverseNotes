package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cdn extends a {
    public int Timestamp;
    public int jCs;
    public int xdi;
    public int xdj;
    public int xdk;
    public int xdl;
    public int xdm;
    public int xdn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28659);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCs);
            aVar.iz(2, this.Timestamp);
            aVar.iz(3, this.xdi);
            aVar.iz(4, this.xdj);
            aVar.iz(5, this.xdk);
            aVar.iz(6, this.xdl);
            aVar.iz(7, this.xdm);
            aVar.iz(8, this.xdn);
            AppMethodBeat.o(28659);
            return 0;
        } else if (i == 1) {
            bs = (((((((e.a.a.b.b.a.bs(1, this.jCs) + 0) + e.a.a.b.b.a.bs(2, this.Timestamp)) + e.a.a.b.b.a.bs(3, this.xdi)) + e.a.a.b.b.a.bs(4, this.xdj)) + e.a.a.b.b.a.bs(5, this.xdk)) + e.a.a.b.b.a.bs(6, this.xdl)) + e.a.a.b.b.a.bs(7, this.xdm)) + e.a.a.b.b.a.bs(8, this.xdn);
            AppMethodBeat.o(28659);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28659);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdn cdn = (cdn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdn.jCs = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 2:
                    cdn.Timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 3:
                    cdn.xdi = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 4:
                    cdn.xdj = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 5:
                    cdn.xdk = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 6:
                    cdn.xdl = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 7:
                    cdn.xdm = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                case 8:
                    cdn.xdn = aVar3.BTU.vd();
                    AppMethodBeat.o(28659);
                    return 0;
                default:
                    AppMethodBeat.o(28659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28659);
            return -1;
        }
    }
}
