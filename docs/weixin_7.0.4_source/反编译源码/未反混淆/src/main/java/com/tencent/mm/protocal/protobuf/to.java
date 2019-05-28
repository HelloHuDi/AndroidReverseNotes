package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class to extends a {
    public int count;
    public int scene;
    public int vGr;
    public String vGs;
    public int waF;
    public int waG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14723);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGs != null) {
                aVar.e(1, this.vGs);
            }
            aVar.iz(2, this.vGr);
            aVar.iz(3, this.waF);
            aVar.iz(4, this.waG);
            aVar.iz(5, this.scene);
            aVar.iz(6, this.count);
            AppMethodBeat.o(14723);
            return 0;
        } else if (i == 1) {
            if (this.vGs != null) {
                f = e.a.a.b.b.a.f(1, this.vGs) + 0;
            } else {
                f = 0;
            }
            int bs = ((((f + e.a.a.b.b.a.bs(2, this.vGr)) + e.a.a.b.b.a.bs(3, this.waF)) + e.a.a.b.b.a.bs(4, this.waG)) + e.a.a.b.b.a.bs(5, this.scene)) + e.a.a.b.b.a.bs(6, this.count);
            AppMethodBeat.o(14723);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14723);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            to toVar = (to) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    toVar.vGs = aVar3.BTU.readString();
                    AppMethodBeat.o(14723);
                    return 0;
                case 2:
                    toVar.vGr = aVar3.BTU.vd();
                    AppMethodBeat.o(14723);
                    return 0;
                case 3:
                    toVar.waF = aVar3.BTU.vd();
                    AppMethodBeat.o(14723);
                    return 0;
                case 4:
                    toVar.waG = aVar3.BTU.vd();
                    AppMethodBeat.o(14723);
                    return 0;
                case 5:
                    toVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(14723);
                    return 0;
                case 6:
                    toVar.count = aVar3.BTU.vd();
                    AppMethodBeat.o(14723);
                    return 0;
                default:
                    AppMethodBeat.o(14723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14723);
            return -1;
        }
    }
}
