package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class op extends a {
    public String kKZ;
    public String kbW;
    public String kfM;
    public String title;
    public String url;
    public String vTL;
    public String vTM;
    public long vUW;
    public String vUX;
    public String vUY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89047);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.kbW != null) {
                aVar.e(2, this.kbW);
            }
            if (this.kfM != null) {
                aVar.e(3, this.kfM);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.ai(5, this.vUW);
            if (this.vUX != null) {
                aVar.e(6, this.vUX);
            }
            if (this.vUY != null) {
                aVar.e(7, this.vUY);
            }
            if (this.kKZ != null) {
                aVar.e(8, this.kKZ);
            }
            if (this.vTL != null) {
                aVar.e(9, this.vTL);
            }
            if (this.vTM != null) {
                aVar.e(10, this.vTM);
            }
            AppMethodBeat.o(89047);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.kbW != null) {
                f += e.a.a.b.b.a.f(2, this.kbW);
            }
            if (this.kfM != null) {
                f += e.a.a.b.b.a.f(3, this.kfM);
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(4, this.url);
            }
            f += e.a.a.b.b.a.o(5, this.vUW);
            if (this.vUX != null) {
                f += e.a.a.b.b.a.f(6, this.vUX);
            }
            if (this.vUY != null) {
                f += e.a.a.b.b.a.f(7, this.vUY);
            }
            if (this.kKZ != null) {
                f += e.a.a.b.b.a.f(8, this.kKZ);
            }
            if (this.vTL != null) {
                f += e.a.a.b.b.a.f(9, this.vTL);
            }
            if (this.vTM != null) {
                f += e.a.a.b.b.a.f(10, this.vTM);
            }
            AppMethodBeat.o(89047);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89047);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            op opVar = (op) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    opVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 2:
                    opVar.kbW = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 3:
                    opVar.kfM = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 4:
                    opVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 5:
                    opVar.vUW = aVar3.BTU.ve();
                    AppMethodBeat.o(89047);
                    return 0;
                case 6:
                    opVar.vUX = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 7:
                    opVar.vUY = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 8:
                    opVar.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 9:
                    opVar.vTL = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                case 10:
                    opVar.vTM = aVar3.BTU.readString();
                    AppMethodBeat.o(89047);
                    return 0;
                default:
                    AppMethodBeat.o(89047);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89047);
            return -1;
        }
    }
}
