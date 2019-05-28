package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class n extends a {
    public String Desc;
    public String Name;
    public String mZW;
    public int mZX;
    public String mZj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111553);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZW != null) {
                aVar.e(1, this.mZW);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            if (this.mZj != null) {
                aVar.e(4, this.mZj);
            }
            aVar.iz(5, this.mZX);
            AppMethodBeat.o(111553);
            return 0;
        } else if (i == 1) {
            if (this.mZW != null) {
                f = e.a.a.b.b.a.f(1, this.mZW) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += e.a.a.b.b.a.f(2, this.Name);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(4, this.mZj);
            }
            int bs = f + e.a.a.b.b.a.bs(5, this.mZX);
            AppMethodBeat.o(111553);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111553);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.mZW = aVar3.BTU.readString();
                    AppMethodBeat.o(111553);
                    return 0;
                case 2:
                    nVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(111553);
                    return 0;
                case 3:
                    nVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111553);
                    return 0;
                case 4:
                    nVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111553);
                    return 0;
                case 5:
                    nVar.mZX = aVar3.BTU.vd();
                    AppMethodBeat.o(111553);
                    return 0;
                default:
                    AppMethodBeat.o(111553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111553);
            return -1;
        }
    }
}
