package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class k extends a {
    public long cSh;
    public int state;
    public String title;
    public String vzL;
    public String vzM;
    public String vzV;
    public int vzW;
    public String vzX;
    public String vzY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56679);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vzL != null) {
                aVar.e(1, this.vzL);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.ai(3, this.cSh);
            if (this.vzV != null) {
                aVar.e(5, this.vzV);
            }
            aVar.iz(10, this.state);
            aVar.iz(11, this.vzW);
            if (this.vzX != null) {
                aVar.e(12, this.vzX);
            }
            if (this.vzM != null) {
                aVar.e(13, this.vzM);
            }
            if (this.vzY != null) {
                aVar.e(14, this.vzY);
            }
            AppMethodBeat.o(56679);
            return 0;
        } else if (i == 1) {
            if (this.vzL != null) {
                f = e.a.a.b.b.a.f(1, this.vzL) + 0;
            } else {
                f = 0;
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(2, this.title);
            }
            f += e.a.a.b.b.a.o(3, this.cSh);
            if (this.vzV != null) {
                f += e.a.a.b.b.a.f(5, this.vzV);
            }
            f = (f + e.a.a.b.b.a.bs(10, this.state)) + e.a.a.b.b.a.bs(11, this.vzW);
            if (this.vzX != null) {
                f += e.a.a.b.b.a.f(12, this.vzX);
            }
            if (this.vzM != null) {
                f += e.a.a.b.b.a.f(13, this.vzM);
            }
            if (this.vzY != null) {
                f += e.a.a.b.b.a.f(14, this.vzY);
            }
            AppMethodBeat.o(56679);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56679);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.vzL = aVar3.BTU.readString();
                    AppMethodBeat.o(56679);
                    return 0;
                case 2:
                    kVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56679);
                    return 0;
                case 3:
                    kVar.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56679);
                    return 0;
                case 5:
                    kVar.vzV = aVar3.BTU.readString();
                    AppMethodBeat.o(56679);
                    return 0;
                case 10:
                    kVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(56679);
                    return 0;
                case 11:
                    kVar.vzW = aVar3.BTU.vd();
                    AppMethodBeat.o(56679);
                    return 0;
                case 12:
                    kVar.vzX = aVar3.BTU.readString();
                    AppMethodBeat.o(56679);
                    return 0;
                case 13:
                    kVar.vzM = aVar3.BTU.readString();
                    AppMethodBeat.o(56679);
                    return 0;
                case 14:
                    kVar.vzY = aVar3.BTU.readString();
                    AppMethodBeat.o(56679);
                    return 0;
                default:
                    AppMethodBeat.o(56679);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56679);
            return -1;
        }
    }
}
