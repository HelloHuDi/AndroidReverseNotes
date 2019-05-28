package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class azt extends a {
    public int Scene;
    public String csB;
    public String username;
    public int vMG;
    public int wDA;
    public String wDB;
    public int wDC;
    public int wDz;
    public int wzF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102382);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.iz(3, this.wzF);
            aVar.iz(4, this.vMG);
            aVar.iz(5, this.Scene);
            aVar.iz(6, this.wDz);
            aVar.iz(7, this.wDA);
            if (this.wDB != null) {
                aVar.e(8, this.wDB);
            }
            aVar.iz(9, this.wDC);
            AppMethodBeat.o(102382);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.username != null) {
                f += e.a.a.b.b.a.f(2, this.username);
            }
            f = ((((f + e.a.a.b.b.a.bs(3, this.wzF)) + e.a.a.b.b.a.bs(4, this.vMG)) + e.a.a.b.b.a.bs(5, this.Scene)) + e.a.a.b.b.a.bs(6, this.wDz)) + e.a.a.b.b.a.bs(7, this.wDA);
            if (this.wDB != null) {
                f += e.a.a.b.b.a.f(8, this.wDB);
            }
            int bs = f + e.a.a.b.b.a.bs(9, this.wDC);
            AppMethodBeat.o(102382);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102382);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azt azt = (azt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azt.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(102382);
                    return 0;
                case 2:
                    azt.username = aVar3.BTU.readString();
                    AppMethodBeat.o(102382);
                    return 0;
                case 3:
                    azt.wzF = aVar3.BTU.vd();
                    AppMethodBeat.o(102382);
                    return 0;
                case 4:
                    azt.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(102382);
                    return 0;
                case 5:
                    azt.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(102382);
                    return 0;
                case 6:
                    azt.wDz = aVar3.BTU.vd();
                    AppMethodBeat.o(102382);
                    return 0;
                case 7:
                    azt.wDA = aVar3.BTU.vd();
                    AppMethodBeat.o(102382);
                    return 0;
                case 8:
                    azt.wDB = aVar3.BTU.readString();
                    AppMethodBeat.o(102382);
                    return 0;
                case 9:
                    azt.wDC = aVar3.BTU.vd();
                    AppMethodBeat.o(102382);
                    return 0;
                default:
                    AppMethodBeat.o(102382);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102382);
            return -1;
        }
    }
}
