package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class azh extends a {
    public String type;
    public int vXd;
    public String wDs;
    public String wDt;
    public String woO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(70486);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wDs != null) {
                aVar.e(1, this.wDs);
            }
            if (this.woO != null) {
                aVar.e(2, this.woO);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            aVar.iz(4, this.vXd);
            if (this.wDt != null) {
                aVar.e(5, this.wDt);
            }
            AppMethodBeat.o(70486);
            return 0;
        } else if (i == 1) {
            if (this.wDs != null) {
                f = e.a.a.b.b.a.f(1, this.wDs) + 0;
            } else {
                f = 0;
            }
            if (this.woO != null) {
                f += e.a.a.b.b.a.f(2, this.woO);
            }
            if (this.type != null) {
                f += e.a.a.b.b.a.f(3, this.type);
            }
            f += e.a.a.b.b.a.bs(4, this.vXd);
            if (this.wDt != null) {
                f += e.a.a.b.b.a.f(5, this.wDt);
            }
            AppMethodBeat.o(70486);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(70486);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azh azh = (azh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azh.wDs = aVar3.BTU.readString();
                    AppMethodBeat.o(70486);
                    return 0;
                case 2:
                    azh.woO = aVar3.BTU.readString();
                    AppMethodBeat.o(70486);
                    return 0;
                case 3:
                    azh.type = aVar3.BTU.readString();
                    AppMethodBeat.o(70486);
                    return 0;
                case 4:
                    azh.vXd = aVar3.BTU.vd();
                    AppMethodBeat.o(70486);
                    return 0;
                case 5:
                    azh.wDt = aVar3.BTU.readString();
                    AppMethodBeat.o(70486);
                    return 0;
                default:
                    AppMethodBeat.o(70486);
                    return -1;
            }
        } else {
            AppMethodBeat.o(70486);
            return -1;
        }
    }
}
