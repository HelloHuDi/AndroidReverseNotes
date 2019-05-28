package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bt.a {
    public String IconUrl;
    public String Name;
    public int jCt;
    public String ncM;
    public String phA;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56621);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.phA != null) {
                aVar.e(2, this.phA);
            }
            aVar.iz(3, this.jCt);
            if (this.ncM != null) {
                aVar.e(4, this.ncM);
            }
            if (this.IconUrl != null) {
                aVar.e(5, this.IconUrl);
            }
            AppMethodBeat.o(56621);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.phA != null) {
                f += e.a.a.b.b.a.f(2, this.phA);
            }
            f += e.a.a.b.b.a.bs(3, this.jCt);
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(4, this.ncM);
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(5, this.IconUrl);
            }
            AppMethodBeat.o(56621);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56621);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(56621);
                    return 0;
                case 2:
                    aVar4.phA = aVar3.BTU.readString();
                    AppMethodBeat.o(56621);
                    return 0;
                case 3:
                    aVar4.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(56621);
                    return 0;
                case 4:
                    aVar4.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(56621);
                    return 0;
                case 5:
                    aVar4.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56621);
                    return 0;
                default:
                    AppMethodBeat.o(56621);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56621);
            return -1;
        }
    }
}
