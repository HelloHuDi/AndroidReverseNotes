package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class alk extends a {
    public String cxb;
    public String geY;
    public String geZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80083);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.geZ == null) {
                bVar = new b("Not all required fields were included: tp_username");
                AppMethodBeat.o(80083);
                throw bVar;
            }
            if (this.geZ != null) {
                aVar.e(1, this.geZ);
            }
            if (this.geY != null) {
                aVar.e(2, this.geY);
            }
            if (this.cxb != null) {
                aVar.e(3, this.cxb);
            }
            AppMethodBeat.o(80083);
            return 0;
        } else if (i == 1) {
            if (this.geZ != null) {
                f = e.a.a.b.b.a.f(1, this.geZ) + 0;
            } else {
                f = 0;
            }
            if (this.geY != null) {
                f += e.a.a.b.b.a.f(2, this.geY);
            }
            if (this.cxb != null) {
                f += e.a.a.b.b.a.f(3, this.cxb);
            }
            AppMethodBeat.o(80083);
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
                AppMethodBeat.o(80083);
                throw bVar;
            }
            AppMethodBeat.o(80083);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alk alk = (alk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alk.geZ = aVar3.BTU.readString();
                    AppMethodBeat.o(80083);
                    return 0;
                case 2:
                    alk.geY = aVar3.BTU.readString();
                    AppMethodBeat.o(80083);
                    return 0;
                case 3:
                    alk.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(80083);
                    return 0;
                default:
                    AppMethodBeat.o(80083);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80083);
            return -1;
        }
    }
}
