package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class nz extends a {
    public int qsz;
    public String text;
    public int type;
    public String url;
    public int vNm;
    public String vTr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89036);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.text != null) {
                aVar.e(2, this.text);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.iz(4, this.qsz);
            aVar.iz(5, this.vNm);
            if (this.vTr != null) {
                aVar.e(6, this.vTr);
            }
            AppMethodBeat.o(89036);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.text != null) {
                bs += e.a.a.b.b.a.f(2, this.text);
            }
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(3, this.url);
            }
            bs = (bs + e.a.a.b.b.a.bs(4, this.qsz)) + e.a.a.b.b.a.bs(5, this.vNm);
            if (this.vTr != null) {
                bs += e.a.a.b.b.a.f(6, this.vTr);
            }
            AppMethodBeat.o(89036);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89036);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nz nzVar = (nz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nzVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(89036);
                    return 0;
                case 2:
                    nzVar.text = aVar3.BTU.readString();
                    AppMethodBeat.o(89036);
                    return 0;
                case 3:
                    nzVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(89036);
                    return 0;
                case 4:
                    nzVar.qsz = aVar3.BTU.vd();
                    AppMethodBeat.o(89036);
                    return 0;
                case 5:
                    nzVar.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(89036);
                    return 0;
                case 6:
                    nzVar.vTr = aVar3.BTU.readString();
                    AppMethodBeat.o(89036);
                    return 0;
                default:
                    AppMethodBeat.o(89036);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89036);
            return -1;
        }
    }
}
