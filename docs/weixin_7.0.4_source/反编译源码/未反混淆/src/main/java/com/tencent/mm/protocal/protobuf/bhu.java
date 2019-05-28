package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class bhu extends a {
    public String Name;
    public String guO;
    public String guP;
    public String oRb;
    public double vNH;
    public double vNI;
    public String wKW;
    public String wKX;
    public String wKY;
    public String wKZ;
    public String wcl;
    public String wcm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113787);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.wKW != null) {
                aVar.e(2, this.wKW);
            }
            aVar.f(3, this.vNH);
            aVar.f(4, this.vNI);
            if (this.wKX != null) {
                aVar.e(5, this.wKX);
            }
            if (this.oRb != null) {
                aVar.e(6, this.oRb);
            }
            if (this.wKY != null) {
                aVar.e(7, this.wKY);
            }
            if (this.guO != null) {
                aVar.e(8, this.guO);
            }
            if (this.guP != null) {
                aVar.e(9, this.guP);
            }
            if (this.wcl != null) {
                aVar.e(10, this.wcl);
            }
            if (this.wcm != null) {
                aVar.e(11, this.wcm);
            }
            if (this.wKZ != null) {
                aVar.e(12, this.wKZ);
            }
            AppMethodBeat.o(113787);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.wKW != null) {
                f += e.a.a.b.b.a.f(2, this.wKW);
            }
            f = (f + (e.a.a.b.b.a.fv(3) + 8)) + (e.a.a.b.b.a.fv(4) + 8);
            if (this.wKX != null) {
                f += e.a.a.b.b.a.f(5, this.wKX);
            }
            if (this.oRb != null) {
                f += e.a.a.b.b.a.f(6, this.oRb);
            }
            if (this.wKY != null) {
                f += e.a.a.b.b.a.f(7, this.wKY);
            }
            if (this.guO != null) {
                f += e.a.a.b.b.a.f(8, this.guO);
            }
            if (this.guP != null) {
                f += e.a.a.b.b.a.f(9, this.guP);
            }
            if (this.wcl != null) {
                f += e.a.a.b.b.a.f(10, this.wcl);
            }
            if (this.wcm != null) {
                f += e.a.a.b.b.a.f(11, this.wcm);
            }
            if (this.wKZ != null) {
                f += e.a.a.b.b.a.f(12, this.wKZ);
            }
            AppMethodBeat.o(113787);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(113787);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhu bhu = (bhu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhu.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 2:
                    bhu.wKW = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 3:
                    bhu.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113787);
                    return 0;
                case 4:
                    bhu.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113787);
                    return 0;
                case 5:
                    bhu.wKX = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 6:
                    bhu.oRb = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 7:
                    bhu.wKY = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 8:
                    bhu.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 9:
                    bhu.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 10:
                    bhu.wcl = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 11:
                    bhu.wcm = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                case 12:
                    bhu.wKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(113787);
                    return 0;
                default:
                    AppMethodBeat.o(113787);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113787);
            return -1;
        }
    }
}
