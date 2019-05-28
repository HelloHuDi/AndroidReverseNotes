package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ckx extends a {
    public int Ret;
    public int ptw;
    public int ptx;
    public String wdO;
    public String wot;
    public boolean xiH;
    public boolean xiI = false;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62586);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Ret);
            aVar.iz(2, this.ptx);
            aVar.iz(3, this.ptw);
            if (this.wdO != null) {
                aVar.e(4, this.wdO);
            }
            aVar.aO(5, this.xiH);
            if (this.wot != null) {
                aVar.e(6, this.wot);
            }
            aVar.aO(7, this.xiI);
            AppMethodBeat.o(62586);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.Ret) + 0) + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.wdO != null) {
                bs += e.a.a.b.b.a.f(4, this.wdO);
            }
            bs += e.a.a.b.b.a.fv(5) + 1;
            if (this.wot != null) {
                bs += e.a.a.b.b.a.f(6, this.wot);
            }
            bs += e.a.a.b.b.a.fv(7) + 1;
            AppMethodBeat.o(62586);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62586);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckx ckx = (ckx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckx.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(62586);
                    return 0;
                case 2:
                    ckx.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(62586);
                    return 0;
                case 3:
                    ckx.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(62586);
                    return 0;
                case 4:
                    ckx.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(62586);
                    return 0;
                case 5:
                    ckx.xiH = aVar3.BTU.ehX();
                    AppMethodBeat.o(62586);
                    return 0;
                case 6:
                    ckx.wot = aVar3.BTU.readString();
                    AppMethodBeat.o(62586);
                    return 0;
                case 7:
                    ckx.xiI = aVar3.BTU.ehX();
                    AppMethodBeat.o(62586);
                    return 0;
                default:
                    AppMethodBeat.o(62586);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62586);
            return -1;
        }
    }
}
