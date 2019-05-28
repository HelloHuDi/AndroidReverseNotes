package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crt extends a {
    public String ProductID;
    public String Title;
    public String wOs;
    public int xpo;
    public String xpp;
    public String xpq;
    public String xpr;
    public String xps;
    public String xpt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28705);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.ProductID != null) {
                aVar.e(2, this.ProductID);
            }
            aVar.iz(3, this.xpo);
            if (this.xpp != null) {
                aVar.e(4, this.xpp);
            }
            if (this.wOs != null) {
                aVar.e(5, this.wOs);
            }
            if (this.xpq != null) {
                aVar.e(6, this.xpq);
            }
            if (this.xpr != null) {
                aVar.e(7, this.xpr);
            }
            if (this.xps != null) {
                aVar.e(8, this.xps);
            }
            if (this.xpt != null) {
                aVar.e(9, this.xpt);
            }
            AppMethodBeat.o(28705);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.ProductID != null) {
                f += e.a.a.b.b.a.f(2, this.ProductID);
            }
            f += e.a.a.b.b.a.bs(3, this.xpo);
            if (this.xpp != null) {
                f += e.a.a.b.b.a.f(4, this.xpp);
            }
            if (this.wOs != null) {
                f += e.a.a.b.b.a.f(5, this.wOs);
            }
            if (this.xpq != null) {
                f += e.a.a.b.b.a.f(6, this.xpq);
            }
            if (this.xpr != null) {
                f += e.a.a.b.b.a.f(7, this.xpr);
            }
            if (this.xps != null) {
                f += e.a.a.b.b.a.f(8, this.xps);
            }
            if (this.xpt != null) {
                f += e.a.a.b.b.a.f(9, this.xpt);
            }
            AppMethodBeat.o(28705);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28705);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crt crt = (crt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crt.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 2:
                    crt.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 3:
                    crt.xpo = aVar3.BTU.vd();
                    AppMethodBeat.o(28705);
                    return 0;
                case 4:
                    crt.xpp = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 5:
                    crt.wOs = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 6:
                    crt.xpq = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 7:
                    crt.xpr = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 8:
                    crt.xps = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                case 9:
                    crt.xpt = aVar3.BTU.readString();
                    AppMethodBeat.o(28705);
                    return 0;
                default:
                    AppMethodBeat.o(28705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28705);
            return -1;
        }
    }
}
