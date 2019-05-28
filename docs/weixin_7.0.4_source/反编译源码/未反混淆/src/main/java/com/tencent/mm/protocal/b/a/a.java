package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class a extends com.tencent.mm.bt.a {
    public int actionType;
    public int id;
    public String vzG;
    public String vzH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105576);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vzG == null) {
                bVar = new b("Not all required fields were included: btnStr");
                AppMethodBeat.o(105576);
                throw bVar;
            }
            aVar.iz(1, this.id);
            aVar.iz(2, this.actionType);
            if (this.vzG != null) {
                aVar.e(3, this.vzG);
            }
            if (this.vzH != null) {
                aVar.e(4, this.vzH);
            }
            AppMethodBeat.o(105576);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.id) + 0) + e.a.a.b.b.a.bs(2, this.actionType);
            if (this.vzG != null) {
                bs += e.a.a.b.b.a.f(3, this.vzG);
            }
            if (this.vzH != null) {
                bs += e.a.a.b.b.a.f(4, this.vzH);
            }
            AppMethodBeat.o(105576);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vzG == null) {
                bVar = new b("Not all required fields were included: btnStr");
                AppMethodBeat.o(105576);
                throw bVar;
            }
            AppMethodBeat.o(105576);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.BTU.vd();
                    AppMethodBeat.o(105576);
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.BTU.vd();
                    AppMethodBeat.o(105576);
                    return 0;
                case 3:
                    aVar4.vzG = aVar3.BTU.readString();
                    AppMethodBeat.o(105576);
                    return 0;
                case 4:
                    aVar4.vzH = aVar3.BTU.readString();
                    AppMethodBeat.o(105576);
                    return 0;
                default:
                    AppMethodBeat.o(105576);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105576);
            return -1;
        }
    }
}
