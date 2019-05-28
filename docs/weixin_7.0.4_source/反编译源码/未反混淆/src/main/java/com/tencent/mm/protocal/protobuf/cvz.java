package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cvz extends a {
    public String cEh;
    public String puh;
    public String xrS;
    public String xrT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80212);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xrS != null) {
                aVar.e(1, this.xrS);
            }
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            if (this.puh != null) {
                aVar.e(3, this.puh);
            }
            if (this.xrT != null) {
                aVar.e(4, this.xrT);
            }
            AppMethodBeat.o(80212);
            return 0;
        } else if (i == 1) {
            if (this.xrS != null) {
                f = e.a.a.b.b.a.f(1, this.xrS) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.puh != null) {
                f += e.a.a.b.b.a.f(3, this.puh);
            }
            if (this.xrT != null) {
                f += e.a.a.b.b.a.f(4, this.xrT);
            }
            AppMethodBeat.o(80212);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80212);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvz cvz = (cvz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvz.xrS = aVar3.BTU.readString();
                    AppMethodBeat.o(80212);
                    return 0;
                case 2:
                    cvz.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(80212);
                    return 0;
                case 3:
                    cvz.puh = aVar3.BTU.readString();
                    AppMethodBeat.o(80212);
                    return 0;
                case 4:
                    cvz.xrT = aVar3.BTU.readString();
                    AppMethodBeat.o(80212);
                    return 0;
                default:
                    AppMethodBeat.o(80212);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80212);
            return -1;
        }
    }
}
