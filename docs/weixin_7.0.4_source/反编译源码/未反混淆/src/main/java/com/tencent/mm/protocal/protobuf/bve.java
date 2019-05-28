package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bve extends a {
    public long wOP;
    public String wWv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124350);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWv == null) {
                bVar = new b("Not all required fields were included: Query");
                AppMethodBeat.o(124350);
                throw bVar;
            }
            if (this.wWv != null) {
                aVar.e(1, this.wWv);
            }
            aVar.ai(2, this.wOP);
            AppMethodBeat.o(124350);
            return 0;
        } else if (i == 1) {
            if (this.wWv != null) {
                f = e.a.a.b.b.a.f(1, this.wWv) + 0;
            } else {
                f = 0;
            }
            int o = f + e.a.a.b.b.a.o(2, this.wOP);
            AppMethodBeat.o(124350);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wWv == null) {
                bVar = new b("Not all required fields were included: Query");
                AppMethodBeat.o(124350);
                throw bVar;
            }
            AppMethodBeat.o(124350);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bve bve = (bve) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bve.wWv = aVar3.BTU.readString();
                    AppMethodBeat.o(124350);
                    return 0;
                case 2:
                    bve.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(124350);
                    return 0;
                default:
                    AppMethodBeat.o(124350);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124350);
            return -1;
        }
    }
}
