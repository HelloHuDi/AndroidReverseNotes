package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cuk extends a {
    public int xcZ;
    public String xpw;
    public b xqL;
    public b xqM;
    public String xqN;
    public String xqO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28751);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Msg");
                AppMethodBeat.o(28751);
                throw bVar;
            }
            aVar.iz(1, this.xcZ);
            if (this.xpw != null) {
                aVar.e(2, this.xpw);
            }
            if (this.xqL != null) {
                aVar.c(3, this.xqL);
            }
            if (this.xqM != null) {
                aVar.c(4, this.xqM);
            }
            if (this.xqN != null) {
                aVar.e(5, this.xqN);
            }
            if (this.xqO != null) {
                aVar.e(6, this.xqO);
            }
            AppMethodBeat.o(28751);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xcZ) + 0;
            if (this.xpw != null) {
                bs += e.a.a.b.b.a.f(2, this.xpw);
            }
            if (this.xqL != null) {
                bs += e.a.a.b.b.a.b(3, this.xqL);
            }
            if (this.xqM != null) {
                bs += e.a.a.b.b.a.b(4, this.xqM);
            }
            if (this.xqN != null) {
                bs += e.a.a.b.b.a.f(5, this.xqN);
            }
            if (this.xqO != null) {
                bs += e.a.a.b.b.a.f(6, this.xqO);
            }
            AppMethodBeat.o(28751);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xpw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Msg");
                AppMethodBeat.o(28751);
                throw bVar;
            }
            AppMethodBeat.o(28751);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuk cuk = (cuk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuk.xcZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28751);
                    return 0;
                case 2:
                    cuk.xpw = aVar3.BTU.readString();
                    AppMethodBeat.o(28751);
                    return 0;
                case 3:
                    cuk.xqL = aVar3.BTU.emu();
                    AppMethodBeat.o(28751);
                    return 0;
                case 4:
                    cuk.xqM = aVar3.BTU.emu();
                    AppMethodBeat.o(28751);
                    return 0;
                case 5:
                    cuk.xqN = aVar3.BTU.readString();
                    AppMethodBeat.o(28751);
                    return 0;
                case 6:
                    cuk.xqO = aVar3.BTU.readString();
                    AppMethodBeat.o(28751);
                    return 0;
                default:
                    AppMethodBeat.o(28751);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28751);
            return -1;
        }
    }
}
