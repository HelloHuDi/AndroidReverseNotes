package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class b extends a {
    public String gIZ;
    public String gJa;
    public String gJb;
    public String gJc;
    public String gJd;
    public String gJe;
    public String gJf;
    public String gJg;
    public String gJh;
    public int id;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(16786);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.id);
            if (this.gIZ != null) {
                aVar.e(2, this.gIZ);
            }
            if (this.gJa != null) {
                aVar.e(3, this.gJa);
            }
            if (this.gJb != null) {
                aVar.e(4, this.gJb);
            }
            if (this.gJc != null) {
                aVar.e(5, this.gJc);
            }
            if (this.gJd != null) {
                aVar.e(6, this.gJd);
            }
            if (this.gJe != null) {
                aVar.e(7, this.gJe);
            }
            if (this.gJf != null) {
                aVar.e(8, this.gJf);
            }
            if (this.gJg != null) {
                aVar.e(9, this.gJg);
            }
            if (this.gJh != null) {
                aVar.e(10, this.gJh);
            }
            AppMethodBeat.o(16786);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.id) + 0;
            if (this.gIZ != null) {
                bs += e.a.a.b.b.a.f(2, this.gIZ);
            }
            if (this.gJa != null) {
                bs += e.a.a.b.b.a.f(3, this.gJa);
            }
            if (this.gJb != null) {
                bs += e.a.a.b.b.a.f(4, this.gJb);
            }
            if (this.gJc != null) {
                bs += e.a.a.b.b.a.f(5, this.gJc);
            }
            if (this.gJd != null) {
                bs += e.a.a.b.b.a.f(6, this.gJd);
            }
            if (this.gJe != null) {
                bs += e.a.a.b.b.a.f(7, this.gJe);
            }
            if (this.gJf != null) {
                bs += e.a.a.b.b.a.f(8, this.gJf);
            }
            if (this.gJg != null) {
                bs += e.a.a.b.b.a.f(9, this.gJg);
            }
            if (this.gJh != null) {
                bs += e.a.a.b.b.a.f(10, this.gJh);
            }
            AppMethodBeat.o(16786);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(16786);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.BTU.vd();
                    AppMethodBeat.o(16786);
                    return 0;
                case 2:
                    bVar.gIZ = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 3:
                    bVar.gJa = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 4:
                    bVar.gJb = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 5:
                    bVar.gJc = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 6:
                    bVar.gJd = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 7:
                    bVar.gJe = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 8:
                    bVar.gJf = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 9:
                    bVar.gJg = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                case 10:
                    bVar.gJh = aVar3.BTU.readString();
                    AppMethodBeat.o(16786);
                    return 0;
                default:
                    AppMethodBeat.o(16786);
                    return -1;
            }
        } else {
            AppMethodBeat.o(16786);
            return -1;
        }
    }
}
