package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cx extends a {
    public String guO;
    public String guP;
    public String guW;
    public String jBB;
    public String naq;
    public String vEV;
    public String vEW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56701);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.guW != null) {
                aVar.e(1, this.guW);
            }
            if (this.guO != null) {
                aVar.e(2, this.guO);
            }
            if (this.guP != null) {
                aVar.e(3, this.guP);
            }
            if (this.naq != null) {
                aVar.e(4, this.naq);
            }
            if (this.jBB != null) {
                aVar.e(5, this.jBB);
            }
            if (this.vEV != null) {
                aVar.e(6, this.vEV);
            }
            if (this.vEW != null) {
                aVar.e(7, this.vEW);
            }
            AppMethodBeat.o(56701);
            return 0;
        } else if (i == 1) {
            if (this.guW != null) {
                f = e.a.a.b.b.a.f(1, this.guW) + 0;
            } else {
                f = 0;
            }
            if (this.guO != null) {
                f += e.a.a.b.b.a.f(2, this.guO);
            }
            if (this.guP != null) {
                f += e.a.a.b.b.a.f(3, this.guP);
            }
            if (this.naq != null) {
                f += e.a.a.b.b.a.f(4, this.naq);
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(5, this.jBB);
            }
            if (this.vEV != null) {
                f += e.a.a.b.b.a.f(6, this.vEV);
            }
            if (this.vEW != null) {
                f += e.a.a.b.b.a.f(7, this.vEW);
            }
            AppMethodBeat.o(56701);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56701);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cx cxVar = (cx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxVar.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                case 2:
                    cxVar.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                case 3:
                    cxVar.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                case 4:
                    cxVar.naq = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                case 5:
                    cxVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                case 6:
                    cxVar.vEV = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                case 7:
                    cxVar.vEW = aVar3.BTU.readString();
                    AppMethodBeat.o(56701);
                    return 0;
                default:
                    AppMethodBeat.o(56701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56701);
            return -1;
        }
    }
}
