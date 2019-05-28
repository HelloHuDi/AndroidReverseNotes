package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cno extends a {
    public String csB;
    public String cvO;
    public String kmr;
    public String wys;
    public String wzf;
    public String xkV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96315);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            if (this.cvO != null) {
                aVar.e(2, this.cvO);
            }
            if (this.wzf != null) {
                aVar.e(3, this.wzf);
            }
            if (this.xkV != null) {
                aVar.e(4, this.xkV);
            }
            if (this.kmr != null) {
                aVar.e(5, this.kmr);
            }
            if (this.wys != null) {
                aVar.e(6, this.wys);
            }
            AppMethodBeat.o(96315);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.cvO != null) {
                f += e.a.a.b.b.a.f(2, this.cvO);
            }
            if (this.wzf != null) {
                f += e.a.a.b.b.a.f(3, this.wzf);
            }
            if (this.xkV != null) {
                f += e.a.a.b.b.a.f(4, this.xkV);
            }
            if (this.kmr != null) {
                f += e.a.a.b.b.a.f(5, this.kmr);
            }
            if (this.wys != null) {
                f += e.a.a.b.b.a.f(6, this.wys);
            }
            AppMethodBeat.o(96315);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96315);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cno cno = (cno) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cno.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(96315);
                    return 0;
                case 2:
                    cno.cvO = aVar3.BTU.readString();
                    AppMethodBeat.o(96315);
                    return 0;
                case 3:
                    cno.wzf = aVar3.BTU.readString();
                    AppMethodBeat.o(96315);
                    return 0;
                case 4:
                    cno.xkV = aVar3.BTU.readString();
                    AppMethodBeat.o(96315);
                    return 0;
                case 5:
                    cno.kmr = aVar3.BTU.readString();
                    AppMethodBeat.o(96315);
                    return 0;
                case 6:
                    cno.wys = aVar3.BTU.readString();
                    AppMethodBeat.o(96315);
                    return 0;
                default:
                    AppMethodBeat.o(96315);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96315);
            return -1;
        }
    }
}
