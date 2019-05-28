package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class gi extends a {
    public int jBT;
    public String ptA;
    public long vIA;
    public double vIB;
    public int vIC;
    public long vIs;
    public String vIt;
    public int vIu;
    public long vIv;
    public int vIw;
    public long vIx;
    public long vIy;
    public int vIz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(54936);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vIs);
            if (this.ptA != null) {
                aVar.e(2, this.ptA);
            }
            if (this.vIt != null) {
                aVar.e(3, this.vIt);
            }
            aVar.iz(4, this.vIu);
            aVar.ai(5, this.vIv);
            aVar.iz(6, this.vIw);
            aVar.iz(7, this.jBT);
            aVar.ai(8, this.vIx);
            aVar.ai(9, this.vIy);
            aVar.iz(10, this.vIz);
            aVar.ai(11, this.vIA);
            aVar.f(12, this.vIB);
            aVar.iz(13, this.vIC);
            AppMethodBeat.o(54936);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vIs) + 0;
            if (this.ptA != null) {
                o += e.a.a.b.b.a.f(2, this.ptA);
            }
            if (this.vIt != null) {
                o += e.a.a.b.b.a.f(3, this.vIt);
            }
            o = (((((((((o + e.a.a.b.b.a.bs(4, this.vIu)) + e.a.a.b.b.a.o(5, this.vIv)) + e.a.a.b.b.a.bs(6, this.vIw)) + e.a.a.b.b.a.bs(7, this.jBT)) + e.a.a.b.b.a.o(8, this.vIx)) + e.a.a.b.b.a.o(9, this.vIy)) + e.a.a.b.b.a.bs(10, this.vIz)) + e.a.a.b.b.a.o(11, this.vIA)) + (e.a.a.b.b.a.fv(12) + 8)) + e.a.a.b.b.a.bs(13, this.vIC);
            AppMethodBeat.o(54936);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(54936);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gi giVar = (gi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    giVar.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(54936);
                    return 0;
                case 2:
                    giVar.ptA = aVar3.BTU.readString();
                    AppMethodBeat.o(54936);
                    return 0;
                case 3:
                    giVar.vIt = aVar3.BTU.readString();
                    AppMethodBeat.o(54936);
                    return 0;
                case 4:
                    giVar.vIu = aVar3.BTU.vd();
                    AppMethodBeat.o(54936);
                    return 0;
                case 5:
                    giVar.vIv = aVar3.BTU.ve();
                    AppMethodBeat.o(54936);
                    return 0;
                case 6:
                    giVar.vIw = aVar3.BTU.vd();
                    AppMethodBeat.o(54936);
                    return 0;
                case 7:
                    giVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(54936);
                    return 0;
                case 8:
                    giVar.vIx = aVar3.BTU.ve();
                    AppMethodBeat.o(54936);
                    return 0;
                case 9:
                    giVar.vIy = aVar3.BTU.ve();
                    AppMethodBeat.o(54936);
                    return 0;
                case 10:
                    giVar.vIz = aVar3.BTU.vd();
                    AppMethodBeat.o(54936);
                    return 0;
                case 11:
                    giVar.vIA = aVar3.BTU.ve();
                    AppMethodBeat.o(54936);
                    return 0;
                case 12:
                    giVar.vIB = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(54936);
                    return 0;
                case 13:
                    giVar.vIC = aVar3.BTU.vd();
                    AppMethodBeat.o(54936);
                    return 0;
                default:
                    AppMethodBeat.o(54936);
                    return -1;
            }
        } else {
            AppMethodBeat.o(54936);
            return -1;
        }
    }
}
