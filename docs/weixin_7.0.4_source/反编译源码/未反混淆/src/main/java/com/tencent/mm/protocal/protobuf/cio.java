package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cio extends a {
    public String nuL;
    public String pLH;
    public String pMd;
    public String pMe;
    public String pMf;
    public String pMg;
    public String pbn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48974);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pMd != null) {
                aVar.e(1, this.pMd);
            }
            if (this.pMe != null) {
                aVar.e(2, this.pMe);
            }
            if (this.pLH != null) {
                aVar.e(3, this.pLH);
            }
            if (this.nuL != null) {
                aVar.e(4, this.nuL);
            }
            if (this.pbn != null) {
                aVar.e(5, this.pbn);
            }
            if (this.pMf != null) {
                aVar.e(6, this.pMf);
            }
            if (this.pMg != null) {
                aVar.e(7, this.pMg);
            }
            AppMethodBeat.o(48974);
            return 0;
        } else if (i == 1) {
            if (this.pMd != null) {
                f = e.a.a.b.b.a.f(1, this.pMd) + 0;
            } else {
                f = 0;
            }
            if (this.pMe != null) {
                f += e.a.a.b.b.a.f(2, this.pMe);
            }
            if (this.pLH != null) {
                f += e.a.a.b.b.a.f(3, this.pLH);
            }
            if (this.nuL != null) {
                f += e.a.a.b.b.a.f(4, this.nuL);
            }
            if (this.pbn != null) {
                f += e.a.a.b.b.a.f(5, this.pbn);
            }
            if (this.pMf != null) {
                f += e.a.a.b.b.a.f(6, this.pMf);
            }
            if (this.pMg != null) {
                f += e.a.a.b.b.a.f(7, this.pMg);
            }
            AppMethodBeat.o(48974);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48974);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cio cio = (cio) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cio.pMd = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                case 2:
                    cio.pMe = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                case 3:
                    cio.pLH = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                case 4:
                    cio.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                case 5:
                    cio.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                case 6:
                    cio.pMf = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                case 7:
                    cio.pMg = aVar3.BTU.readString();
                    AppMethodBeat.o(48974);
                    return 0;
                default:
                    AppMethodBeat.o(48974);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48974);
            return -1;
        }
    }
}
