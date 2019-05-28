package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crv extends a {
    public String mZW;
    public String ndG;
    public String wOs;
    public String xpu;
    public String xpv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28707);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wOs != null) {
                aVar.e(1, this.wOs);
            }
            if (this.xpu != null) {
                aVar.e(2, this.xpu);
            }
            if (this.ndG != null) {
                aVar.e(3, this.ndG);
            }
            if (this.mZW != null) {
                aVar.e(4, this.mZW);
            }
            if (this.xpv != null) {
                aVar.e(5, this.xpv);
            }
            AppMethodBeat.o(28707);
            return 0;
        } else if (i == 1) {
            if (this.wOs != null) {
                f = e.a.a.b.b.a.f(1, this.wOs) + 0;
            } else {
                f = 0;
            }
            if (this.xpu != null) {
                f += e.a.a.b.b.a.f(2, this.xpu);
            }
            if (this.ndG != null) {
                f += e.a.a.b.b.a.f(3, this.ndG);
            }
            if (this.mZW != null) {
                f += e.a.a.b.b.a.f(4, this.mZW);
            }
            if (this.xpv != null) {
                f += e.a.a.b.b.a.f(5, this.xpv);
            }
            AppMethodBeat.o(28707);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28707);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crv crv = (crv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crv.wOs = aVar3.BTU.readString();
                    AppMethodBeat.o(28707);
                    return 0;
                case 2:
                    crv.xpu = aVar3.BTU.readString();
                    AppMethodBeat.o(28707);
                    return 0;
                case 3:
                    crv.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28707);
                    return 0;
                case 4:
                    crv.mZW = aVar3.BTU.readString();
                    AppMethodBeat.o(28707);
                    return 0;
                case 5:
                    crv.xpv = aVar3.BTU.readString();
                    AppMethodBeat.o(28707);
                    return 0;
                default:
                    AppMethodBeat.o(28707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28707);
            return -1;
        }
    }
}
