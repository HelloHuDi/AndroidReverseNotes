package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class w extends a {
    public String nWX;
    public long nXM;
    public String nXN;
    public String nXZ;
    public String nYa;
    public String nYb;
    public String nYc;
    public String userName;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56615);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nXZ != null) {
                aVar.e(1, this.nXZ);
            }
            if (this.nYa != null) {
                aVar.e(2, this.nYa);
            }
            aVar.ai(3, this.nXM);
            if (this.nXN != null) {
                aVar.e(4, this.nXN);
            }
            if (this.nYb != null) {
                aVar.e(5, this.nYb);
            }
            if (this.nWX != null) {
                aVar.e(6, this.nWX);
            }
            if (this.nYc != null) {
                aVar.e(7, this.nYc);
            }
            if (this.userName != null) {
                aVar.e(8, this.userName);
            }
            AppMethodBeat.o(56615);
            return 0;
        } else if (i == 1) {
            if (this.nXZ != null) {
                f = e.a.a.b.b.a.f(1, this.nXZ) + 0;
            } else {
                f = 0;
            }
            if (this.nYa != null) {
                f += e.a.a.b.b.a.f(2, this.nYa);
            }
            f += e.a.a.b.b.a.o(3, this.nXM);
            if (this.nXN != null) {
                f += e.a.a.b.b.a.f(4, this.nXN);
            }
            if (this.nYb != null) {
                f += e.a.a.b.b.a.f(5, this.nYb);
            }
            if (this.nWX != null) {
                f += e.a.a.b.b.a.f(6, this.nWX);
            }
            if (this.nYc != null) {
                f += e.a.a.b.b.a.f(7, this.nYc);
            }
            if (this.userName != null) {
                f += e.a.a.b.b.a.f(8, this.userName);
            }
            AppMethodBeat.o(56615);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56615);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.nXZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                case 2:
                    wVar.nYa = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                case 3:
                    wVar.nXM = aVar3.BTU.ve();
                    AppMethodBeat.o(56615);
                    return 0;
                case 4:
                    wVar.nXN = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                case 5:
                    wVar.nYb = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                case 6:
                    wVar.nWX = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                case 7:
                    wVar.nYc = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                case 8:
                    wVar.userName = aVar3.BTU.readString();
                    AppMethodBeat.o(56615);
                    return 0;
                default:
                    AppMethodBeat.o(56615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56615);
            return -1;
        }
    }
}
