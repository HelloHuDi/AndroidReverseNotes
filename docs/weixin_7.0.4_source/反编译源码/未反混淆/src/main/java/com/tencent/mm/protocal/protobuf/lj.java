package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class lj extends a {
    public String vNb;
    public LinkedList<String> vOW = new LinkedList();

    public lj() {
        AppMethodBeat.i(11729);
        AppMethodBeat.o(11729);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11730);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11730);
                throw bVar;
            }
            if (this.vNb != null) {
                aVar.e(2, this.vNb);
            }
            aVar.e(3, 1, this.vOW);
            AppMethodBeat.o(11730);
            return 0;
        } else if (i == 1) {
            if (this.vNb != null) {
                f = e.a.a.b.b.a.f(2, this.vNb) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(3, 1, this.vOW);
            AppMethodBeat.o(11730);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vOW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11730);
                throw bVar;
            }
            AppMethodBeat.o(11730);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lj ljVar = (lj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    ljVar.vNb = aVar3.BTU.readString();
                    AppMethodBeat.o(11730);
                    return 0;
                case 3:
                    ljVar.vOW.add(aVar3.BTU.readString());
                    AppMethodBeat.o(11730);
                    return 0;
                default:
                    AppMethodBeat.o(11730);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11730);
            return -1;
        }
    }
}
