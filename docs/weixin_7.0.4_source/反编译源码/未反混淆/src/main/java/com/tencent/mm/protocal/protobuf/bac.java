package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bac extends a {
    public String fjx;
    public String fjz;
    public String title;
    public String wDU;
    public String wDV;
    public String wDW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14732);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.fjz != null) {
                aVar.e(2, this.fjz);
            }
            if (this.fjx != null) {
                aVar.e(3, this.fjx);
            }
            if (this.wDU != null) {
                aVar.e(4, this.wDU);
            }
            if (this.wDV != null) {
                aVar.e(5, this.wDV);
            }
            if (this.wDW != null) {
                aVar.e(6, this.wDW);
            }
            AppMethodBeat.o(14732);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.fjz != null) {
                f += e.a.a.b.b.a.f(2, this.fjz);
            }
            if (this.fjx != null) {
                f += e.a.a.b.b.a.f(3, this.fjx);
            }
            if (this.wDU != null) {
                f += e.a.a.b.b.a.f(4, this.wDU);
            }
            if (this.wDV != null) {
                f += e.a.a.b.b.a.f(5, this.wDV);
            }
            if (this.wDW != null) {
                f += e.a.a.b.b.a.f(6, this.wDW);
            }
            AppMethodBeat.o(14732);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14732);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bac bac = (bac) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bac.title = aVar3.BTU.readString();
                    AppMethodBeat.o(14732);
                    return 0;
                case 2:
                    bac.fjz = aVar3.BTU.readString();
                    AppMethodBeat.o(14732);
                    return 0;
                case 3:
                    bac.fjx = aVar3.BTU.readString();
                    AppMethodBeat.o(14732);
                    return 0;
                case 4:
                    bac.wDU = aVar3.BTU.readString();
                    AppMethodBeat.o(14732);
                    return 0;
                case 5:
                    bac.wDV = aVar3.BTU.readString();
                    AppMethodBeat.o(14732);
                    return 0;
                case 6:
                    bac.wDW = aVar3.BTU.readString();
                    AppMethodBeat.o(14732);
                    return 0;
                default:
                    AppMethodBeat.o(14732);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14732);
            return -1;
        }
    }
}
