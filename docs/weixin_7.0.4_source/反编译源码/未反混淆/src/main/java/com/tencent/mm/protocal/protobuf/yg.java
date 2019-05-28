package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class yg extends a {
    public String IconUrl;
    public String Name;
    public String wdY;
    public int wdZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62531);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.wdY != null) {
                aVar.e(3, this.wdY);
            }
            aVar.iz(4, this.wdZ);
            AppMethodBeat.o(62531);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.wdY != null) {
                f += e.a.a.b.b.a.f(3, this.wdY);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.wdZ);
            AppMethodBeat.o(62531);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62531);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yg ygVar = (yg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ygVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(62531);
                    return 0;
                case 2:
                    ygVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62531);
                    return 0;
                case 3:
                    ygVar.wdY = aVar3.BTU.readString();
                    AppMethodBeat.o(62531);
                    return 0;
                case 4:
                    ygVar.wdZ = aVar3.BTU.vd();
                    AppMethodBeat.o(62531);
                    return 0;
                default:
                    AppMethodBeat.o(62531);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62531);
            return -1;
        }
    }
}
