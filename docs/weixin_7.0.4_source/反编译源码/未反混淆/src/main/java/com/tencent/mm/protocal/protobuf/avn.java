package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class avn extends a {
    public int wli;
    public int wzu;
    public int wzv;
    public int wzw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80112);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wli);
            aVar.iz(2, this.wzu);
            aVar.iz(3, this.wzv);
            aVar.iz(4, this.wzw);
            AppMethodBeat.o(80112);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wli) + 0) + e.a.a.b.b.a.bs(2, this.wzu)) + e.a.a.b.b.a.bs(3, this.wzv)) + e.a.a.b.b.a.bs(4, this.wzw);
            AppMethodBeat.o(80112);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80112);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avn avn = (avn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avn.wli = aVar3.BTU.vd();
                    AppMethodBeat.o(80112);
                    return 0;
                case 2:
                    avn.wzu = aVar3.BTU.vd();
                    AppMethodBeat.o(80112);
                    return 0;
                case 3:
                    avn.wzv = aVar3.BTU.vd();
                    AppMethodBeat.o(80112);
                    return 0;
                case 4:
                    avn.wzw = aVar3.BTU.vd();
                    AppMethodBeat.o(80112);
                    return 0;
                default:
                    AppMethodBeat.o(80112);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80112);
            return -1;
        }
    }
}
