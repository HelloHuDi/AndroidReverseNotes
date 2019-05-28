package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cq extends a {
    public String geZ;
    public String vEP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80011);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.geZ == null) {
                bVar = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(80011);
                throw bVar;
            } else if (this.vEP == null) {
                bVar = new b("Not all required fields were included: antispam_ticket");
                AppMethodBeat.o(80011);
                throw bVar;
            } else {
                if (this.geZ != null) {
                    aVar.e(1, this.geZ);
                }
                if (this.vEP != null) {
                    aVar.e(2, this.vEP);
                }
                AppMethodBeat.o(80011);
                return 0;
            }
        } else if (i == 1) {
            if (this.geZ != null) {
                f = e.a.a.b.b.a.f(1, this.geZ) + 0;
            } else {
                f = 0;
            }
            if (this.vEP != null) {
                f += e.a.a.b.b.a.f(2, this.vEP);
            }
            AppMethodBeat.o(80011);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.geZ == null) {
                bVar = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(80011);
                throw bVar;
            } else if (this.vEP == null) {
                bVar = new b("Not all required fields were included: antispam_ticket");
                AppMethodBeat.o(80011);
                throw bVar;
            } else {
                AppMethodBeat.o(80011);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cq cqVar = (cq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqVar.geZ = aVar3.BTU.readString();
                    AppMethodBeat.o(80011);
                    return 0;
                case 2:
                    cqVar.vEP = aVar3.BTU.readString();
                    AppMethodBeat.o(80011);
                    return 0;
                default:
                    AppMethodBeat.o(80011);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80011);
            return -1;
        }
    }
}
