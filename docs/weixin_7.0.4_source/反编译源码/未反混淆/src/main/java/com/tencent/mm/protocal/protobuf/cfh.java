package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cfh extends a {
    public String fiG;
    public String fiI;
    public String fiJ;
    public String fiK;
    public String fiL;
    public String fiM;
    public String fiN;
    public int wid;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51006);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fiG != null) {
                aVar.e(1, this.fiG);
            }
            aVar.iz(2, this.wid);
            if (this.fiJ != null) {
                aVar.e(3, this.fiJ);
            }
            if (this.fiK != null) {
                aVar.e(4, this.fiK);
            }
            if (this.fiI != null) {
                aVar.e(5, this.fiI);
            }
            if (this.fiL != null) {
                aVar.e(6, this.fiL);
            }
            if (this.fiM != null) {
                aVar.e(7, this.fiM);
            }
            if (this.fiN != null) {
                aVar.e(8, this.fiN);
            }
            AppMethodBeat.o(51006);
            return 0;
        } else if (i == 1) {
            if (this.fiG != null) {
                f = e.a.a.b.b.a.f(1, this.fiG) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wid);
            if (this.fiJ != null) {
                f += e.a.a.b.b.a.f(3, this.fiJ);
            }
            if (this.fiK != null) {
                f += e.a.a.b.b.a.f(4, this.fiK);
            }
            if (this.fiI != null) {
                f += e.a.a.b.b.a.f(5, this.fiI);
            }
            if (this.fiL != null) {
                f += e.a.a.b.b.a.f(6, this.fiL);
            }
            if (this.fiM != null) {
                f += e.a.a.b.b.a.f(7, this.fiM);
            }
            if (this.fiN != null) {
                f += e.a.a.b.b.a.f(8, this.fiN);
            }
            AppMethodBeat.o(51006);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51006);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfh cfh = (cfh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfh.fiG = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                case 2:
                    cfh.wid = aVar3.BTU.vd();
                    AppMethodBeat.o(51006);
                    return 0;
                case 3:
                    cfh.fiJ = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                case 4:
                    cfh.fiK = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                case 5:
                    cfh.fiI = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                case 6:
                    cfh.fiL = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                case 7:
                    cfh.fiM = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                case 8:
                    cfh.fiN = aVar3.BTU.readString();
                    AppMethodBeat.o(51006);
                    return 0;
                default:
                    AppMethodBeat.o(51006);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51006);
            return -1;
        }
    }
}
