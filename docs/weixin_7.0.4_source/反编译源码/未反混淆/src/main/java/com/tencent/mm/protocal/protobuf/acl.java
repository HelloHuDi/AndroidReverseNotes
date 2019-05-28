package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class acl extends a {
    public int cyE;
    public String id;
    public int mwG;
    public String wkh;
    public long wki;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28409);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.iz(2, this.mwG);
            if (this.wkh != null) {
                aVar.e(3, this.wkh);
            }
            aVar.ai(4, this.wki);
            aVar.iz(5, this.cyE);
            AppMethodBeat.o(28409);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                f = e.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.mwG);
            if (this.wkh != null) {
                f += e.a.a.b.b.a.f(3, this.wkh);
            }
            int o = (f + e.a.a.b.b.a.o(4, this.wki)) + e.a.a.b.b.a.bs(5, this.cyE);
            AppMethodBeat.o(28409);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28409);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acl acl = (acl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acl.id = aVar3.BTU.readString();
                    AppMethodBeat.o(28409);
                    return 0;
                case 2:
                    acl.mwG = aVar3.BTU.vd();
                    AppMethodBeat.o(28409);
                    return 0;
                case 3:
                    acl.wkh = aVar3.BTU.readString();
                    AppMethodBeat.o(28409);
                    return 0;
                case 4:
                    acl.wki = aVar3.BTU.ve();
                    AppMethodBeat.o(28409);
                    return 0;
                case 5:
                    acl.cyE = aVar3.BTU.vd();
                    AppMethodBeat.o(28409);
                    return 0;
                default:
                    AppMethodBeat.o(28409);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28409);
            return -1;
        }
    }
}
