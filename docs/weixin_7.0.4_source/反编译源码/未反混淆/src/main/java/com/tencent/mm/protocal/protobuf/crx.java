package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crx extends a {
    public String Desc;
    public String ProductID;
    public String Title;
    public String nzz;
    public int vEq;
    public String wOs;
    public String xpy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28709);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.wOs != null) {
                aVar.e(2, this.wOs);
            }
            if (this.nzz != null) {
                aVar.e(3, this.nzz);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.xpy != null) {
                aVar.e(5, this.xpy);
            }
            aVar.iz(6, this.vEq);
            if (this.ProductID != null) {
                aVar.e(7, this.ProductID);
            }
            AppMethodBeat.o(28709);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.wOs != null) {
                f += e.a.a.b.b.a.f(2, this.wOs);
            }
            if (this.nzz != null) {
                f += e.a.a.b.b.a.f(3, this.nzz);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.xpy != null) {
                f += e.a.a.b.b.a.f(5, this.xpy);
            }
            f += e.a.a.b.b.a.bs(6, this.vEq);
            if (this.ProductID != null) {
                f += e.a.a.b.b.a.f(7, this.ProductID);
            }
            AppMethodBeat.o(28709);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28709);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crx crx = (crx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crx.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28709);
                    return 0;
                case 2:
                    crx.wOs = aVar3.BTU.readString();
                    AppMethodBeat.o(28709);
                    return 0;
                case 3:
                    crx.nzz = aVar3.BTU.readString();
                    AppMethodBeat.o(28709);
                    return 0;
                case 4:
                    crx.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(28709);
                    return 0;
                case 5:
                    crx.xpy = aVar3.BTU.readString();
                    AppMethodBeat.o(28709);
                    return 0;
                case 6:
                    crx.vEq = aVar3.BTU.vd();
                    AppMethodBeat.o(28709);
                    return 0;
                case 7:
                    crx.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(28709);
                    return 0;
                default:
                    AppMethodBeat.o(28709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28709);
            return -1;
        }
    }
}
