package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cum extends a {
    public b vHn;
    public long vIs;
    public int xqP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28753);
        e.a.a.b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHn == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(28753);
                throw bVar;
            }
            aVar.ai(1, this.vIs);
            if (this.vHn != null) {
                aVar.c(2, this.vHn);
            }
            aVar.iz(3, this.xqP);
            AppMethodBeat.o(28753);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vIs) + 0;
            if (this.vHn != null) {
                o += e.a.a.b.b.a.b(2, this.vHn);
            }
            o += e.a.a.b.b.a.bs(3, this.xqP);
            AppMethodBeat.o(28753);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.vHn == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(28753);
                throw bVar;
            }
            AppMethodBeat.o(28753);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cum cum = (cum) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cum.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(28753);
                    return 0;
                case 2:
                    cum.vHn = aVar3.BTU.emu();
                    AppMethodBeat.o(28753);
                    return 0;
                case 3:
                    cum.xqP = aVar3.BTU.vd();
                    AppMethodBeat.o(28753);
                    return 0;
                default:
                    AppMethodBeat.o(28753);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28753);
            return -1;
        }
    }
}
