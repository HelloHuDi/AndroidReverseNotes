package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class aso extends a {
    public int wwc;
    public b wwd;
    public b wwe;
    public b wwf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5216);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wwd == null) {
                bVar = new e.a.a.b("Not all required fields were included: SPSBuf");
                AppMethodBeat.o(5216);
                throw bVar;
            } else if (this.wwe == null) {
                bVar = new e.a.a.b("Not all required fields were included: PPSBuf");
                AppMethodBeat.o(5216);
                throw bVar;
            } else {
                aVar.iz(1, this.wwc);
                if (this.wwd != null) {
                    aVar.c(2, this.wwd);
                }
                if (this.wwe != null) {
                    aVar.c(3, this.wwe);
                }
                if (this.wwf != null) {
                    aVar.c(4, this.wwf);
                }
                AppMethodBeat.o(5216);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wwc) + 0;
            if (this.wwd != null) {
                bs += e.a.a.b.b.a.b(2, this.wwd);
            }
            if (this.wwe != null) {
                bs += e.a.a.b.b.a.b(3, this.wwe);
            }
            if (this.wwf != null) {
                bs += e.a.a.b.b.a.b(4, this.wwf);
            }
            AppMethodBeat.o(5216);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wwd == null) {
                bVar = new e.a.a.b("Not all required fields were included: SPSBuf");
                AppMethodBeat.o(5216);
                throw bVar;
            } else if (this.wwe == null) {
                bVar = new e.a.a.b("Not all required fields were included: PPSBuf");
                AppMethodBeat.o(5216);
                throw bVar;
            } else {
                AppMethodBeat.o(5216);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aso aso = (aso) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aso.wwc = aVar3.BTU.vd();
                    AppMethodBeat.o(5216);
                    return 0;
                case 2:
                    aso.wwd = aVar3.BTU.emu();
                    AppMethodBeat.o(5216);
                    return 0;
                case 3:
                    aso.wwe = aVar3.BTU.emu();
                    AppMethodBeat.o(5216);
                    return 0;
                case 4:
                    aso.wwf = aVar3.BTU.emu();
                    AppMethodBeat.o(5216);
                    return 0;
                default:
                    AppMethodBeat.o(5216);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5216);
            return -1;
        }
    }
}
