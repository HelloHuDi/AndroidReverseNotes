package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class att extends a {
    public String Label;
    public float vOu;
    public float vOv;
    public float wxP;
    public String wxQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28526);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.r(1, this.vOu);
            aVar.r(2, this.vOv);
            aVar.r(3, this.wxP);
            if (this.Label != null) {
                aVar.e(4, this.Label);
            }
            if (this.wxQ != null) {
                aVar.e(5, this.wxQ);
            }
            AppMethodBeat.o(28526);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 4) + 0) + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4);
            if (this.Label != null) {
                fv += e.a.a.b.b.a.f(4, this.Label);
            }
            if (this.wxQ != null) {
                fv += e.a.a.b.b.a.f(5, this.wxQ);
            }
            AppMethodBeat.o(28526);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28526);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            att att = (att) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    att.vOu = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28526);
                    return 0;
                case 2:
                    att.vOv = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28526);
                    return 0;
                case 3:
                    att.wxP = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28526);
                    return 0;
                case 4:
                    att.Label = aVar3.BTU.readString();
                    AppMethodBeat.o(28526);
                    return 0;
                case 5:
                    att.wxQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28526);
                    return 0;
                default:
                    AppMethodBeat.o(28526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28526);
            return -1;
        }
    }
}
