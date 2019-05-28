package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bdu extends a {
    public int wHA;
    public int wHB;
    public String wHw;
    public String wHx;
    public int wHy;
    public int wHz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58915);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHw != null) {
                aVar.e(1, this.wHw);
            }
            if (this.wHx != null) {
                aVar.e(2, this.wHx);
            }
            aVar.iz(3, this.wHy);
            aVar.iz(4, this.wHz);
            aVar.iz(5, this.wHA);
            aVar.iz(7, this.wHB);
            AppMethodBeat.o(58915);
            return 0;
        } else if (i == 1) {
            if (this.wHw != null) {
                f = e.a.a.b.b.a.f(1, this.wHw) + 0;
            } else {
                f = 0;
            }
            if (this.wHx != null) {
                f += e.a.a.b.b.a.f(2, this.wHx);
            }
            int bs = (((f + e.a.a.b.b.a.bs(3, this.wHy)) + e.a.a.b.b.a.bs(4, this.wHz)) + e.a.a.b.b.a.bs(5, this.wHA)) + e.a.a.b.b.a.bs(7, this.wHB);
            AppMethodBeat.o(58915);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58915);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdu bdu = (bdu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdu.wHw = aVar3.BTU.readString();
                    AppMethodBeat.o(58915);
                    return 0;
                case 2:
                    bdu.wHx = aVar3.BTU.readString();
                    AppMethodBeat.o(58915);
                    return 0;
                case 3:
                    bdu.wHy = aVar3.BTU.vd();
                    AppMethodBeat.o(58915);
                    return 0;
                case 4:
                    bdu.wHz = aVar3.BTU.vd();
                    AppMethodBeat.o(58915);
                    return 0;
                case 5:
                    bdu.wHA = aVar3.BTU.vd();
                    AppMethodBeat.o(58915);
                    return 0;
                case 7:
                    bdu.wHB = aVar3.BTU.vd();
                    AppMethodBeat.o(58915);
                    return 0;
                default:
                    AppMethodBeat.o(58915);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58915);
            return -1;
        }
    }
}
