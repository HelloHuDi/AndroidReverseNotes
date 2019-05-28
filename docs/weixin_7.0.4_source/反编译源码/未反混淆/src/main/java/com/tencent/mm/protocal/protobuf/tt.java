package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class tt extends a {
    public String app_id;
    public String waU;
    public String waV;
    public String waW;
    public int waX;
    public int waY;
    public int waZ;
    public int wba;
    public int wbb;
    public int wbc;
    public String wbd;
    public String wbe;
    public String wbf;
    public b wbg;
    public String wbh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135599);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.app_id != null) {
                aVar.e(1, this.app_id);
            }
            if (this.waU != null) {
                aVar.e(2, this.waU);
            }
            if (this.waV != null) {
                aVar.e(3, this.waV);
            }
            if (this.waW != null) {
                aVar.e(4, this.waW);
            }
            aVar.iz(5, this.waX);
            aVar.iz(6, this.waY);
            aVar.iz(7, this.waZ);
            aVar.iz(10, this.wba);
            aVar.iz(11, this.wbb);
            aVar.iz(12, this.wbc);
            if (this.wbd != null) {
                aVar.e(15, this.wbd);
            }
            if (this.wbe != null) {
                aVar.e(16, this.wbe);
            }
            if (this.wbf != null) {
                aVar.e(17, this.wbf);
            }
            if (this.wbg != null) {
                aVar.c(18, this.wbg);
            }
            if (this.wbh != null) {
                aVar.e(19, this.wbh);
            }
            AppMethodBeat.o(135599);
            return 0;
        } else if (i == 1) {
            if (this.app_id != null) {
                f = e.a.a.b.b.a.f(1, this.app_id) + 0;
            } else {
                f = 0;
            }
            if (this.waU != null) {
                f += e.a.a.b.b.a.f(2, this.waU);
            }
            if (this.waV != null) {
                f += e.a.a.b.b.a.f(3, this.waV);
            }
            if (this.waW != null) {
                f += e.a.a.b.b.a.f(4, this.waW);
            }
            f = (((((f + e.a.a.b.b.a.bs(5, this.waX)) + e.a.a.b.b.a.bs(6, this.waY)) + e.a.a.b.b.a.bs(7, this.waZ)) + e.a.a.b.b.a.bs(10, this.wba)) + e.a.a.b.b.a.bs(11, this.wbb)) + e.a.a.b.b.a.bs(12, this.wbc);
            if (this.wbd != null) {
                f += e.a.a.b.b.a.f(15, this.wbd);
            }
            if (this.wbe != null) {
                f += e.a.a.b.b.a.f(16, this.wbe);
            }
            if (this.wbf != null) {
                f += e.a.a.b.b.a.f(17, this.wbf);
            }
            if (this.wbg != null) {
                f += e.a.a.b.b.a.b(18, this.wbg);
            }
            if (this.wbh != null) {
                f += e.a.a.b.b.a.f(19, this.wbh);
            }
            AppMethodBeat.o(135599);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135599);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tt ttVar = (tt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ttVar.app_id = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 2:
                    ttVar.waU = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 3:
                    ttVar.waV = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 4:
                    ttVar.waW = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 5:
                    ttVar.waX = aVar3.BTU.vd();
                    AppMethodBeat.o(135599);
                    return 0;
                case 6:
                    ttVar.waY = aVar3.BTU.vd();
                    AppMethodBeat.o(135599);
                    return 0;
                case 7:
                    ttVar.waZ = aVar3.BTU.vd();
                    AppMethodBeat.o(135599);
                    return 0;
                case 10:
                    ttVar.wba = aVar3.BTU.vd();
                    AppMethodBeat.o(135599);
                    return 0;
                case 11:
                    ttVar.wbb = aVar3.BTU.vd();
                    AppMethodBeat.o(135599);
                    return 0;
                case 12:
                    ttVar.wbc = aVar3.BTU.vd();
                    AppMethodBeat.o(135599);
                    return 0;
                case 15:
                    ttVar.wbd = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 16:
                    ttVar.wbe = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 17:
                    ttVar.wbf = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                case 18:
                    ttVar.wbg = aVar3.BTU.emu();
                    AppMethodBeat.o(135599);
                    return 0;
                case 19:
                    ttVar.wbh = aVar3.BTU.readString();
                    AppMethodBeat.o(135599);
                    return 0;
                default:
                    AppMethodBeat.o(135599);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135599);
            return -1;
        }
    }
}
