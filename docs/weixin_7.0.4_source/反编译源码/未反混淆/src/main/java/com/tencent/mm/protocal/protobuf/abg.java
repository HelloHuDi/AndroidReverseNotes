package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abg extends a {
    public String Desc;
    public String Title;
    public int vEt;
    public String vEu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(118271);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            aVar.iz(3, this.vEt);
            if (this.vEu != null) {
                aVar.e(4, this.vEu);
            }
            AppMethodBeat.o(118271);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(2, this.Desc);
            }
            f += e.a.a.b.b.a.bs(3, this.vEt);
            if (this.vEu != null) {
                f += e.a.a.b.b.a.f(4, this.vEu);
            }
            AppMethodBeat.o(118271);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(118271);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abg abg = (abg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abg.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(118271);
                    return 0;
                case 2:
                    abg.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(118271);
                    return 0;
                case 3:
                    abg.vEt = aVar3.BTU.vd();
                    AppMethodBeat.o(118271);
                    return 0;
                case 4:
                    abg.vEu = aVar3.BTU.readString();
                    AppMethodBeat.o(118271);
                    return 0;
                default:
                    AppMethodBeat.o(118271);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118271);
            return -1;
        }
    }
}
