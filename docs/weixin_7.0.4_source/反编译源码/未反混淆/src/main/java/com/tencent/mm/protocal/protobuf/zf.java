package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class zf extends a {
    public int weA;
    public int weB;
    public int weC;
    public String weD;
    public int weE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73648);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.weA);
            aVar.iz(2, this.weB);
            aVar.iz(3, this.weC);
            if (this.weD != null) {
                aVar.e(4, this.weD);
            }
            aVar.iz(5, this.weE);
            AppMethodBeat.o(73648);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.weA) + 0) + e.a.a.b.b.a.bs(2, this.weB)) + e.a.a.b.b.a.bs(3, this.weC);
            if (this.weD != null) {
                bs += e.a.a.b.b.a.f(4, this.weD);
            }
            bs += e.a.a.b.b.a.bs(5, this.weE);
            AppMethodBeat.o(73648);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73648);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zf zfVar = (zf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zfVar.weA = aVar3.BTU.vd();
                    AppMethodBeat.o(73648);
                    return 0;
                case 2:
                    zfVar.weB = aVar3.BTU.vd();
                    AppMethodBeat.o(73648);
                    return 0;
                case 3:
                    zfVar.weC = aVar3.BTU.vd();
                    AppMethodBeat.o(73648);
                    return 0;
                case 4:
                    zfVar.weD = aVar3.BTU.readString();
                    AppMethodBeat.o(73648);
                    return 0;
                case 5:
                    zfVar.weE = aVar3.BTU.vd();
                    AppMethodBeat.o(73648);
                    return 0;
                default:
                    AppMethodBeat.o(73648);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73648);
            return -1;
        }
    }
}
