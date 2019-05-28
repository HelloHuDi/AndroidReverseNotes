package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cig extends a {
    public String AesKey;
    public String vRA;
    public int xhn;
    public int xho;
    public long xhp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51437);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xhn);
            if (this.vRA != null) {
                aVar.e(2, this.vRA);
            }
            if (this.AesKey != null) {
                aVar.e(3, this.AesKey);
            }
            aVar.iz(4, this.xho);
            aVar.ai(5, this.xhp);
            AppMethodBeat.o(51437);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xhn) + 0;
            if (this.vRA != null) {
                bs += e.a.a.b.b.a.f(2, this.vRA);
            }
            if (this.AesKey != null) {
                bs += e.a.a.b.b.a.f(3, this.AesKey);
            }
            bs = (bs + e.a.a.b.b.a.bs(4, this.xho)) + e.a.a.b.b.a.o(5, this.xhp);
            AppMethodBeat.o(51437);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51437);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cig cig = (cig) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cig.xhn = aVar3.BTU.vd();
                    AppMethodBeat.o(51437);
                    return 0;
                case 2:
                    cig.vRA = aVar3.BTU.readString();
                    AppMethodBeat.o(51437);
                    return 0;
                case 3:
                    cig.AesKey = aVar3.BTU.readString();
                    AppMethodBeat.o(51437);
                    return 0;
                case 4:
                    cig.xho = aVar3.BTU.vd();
                    AppMethodBeat.o(51437);
                    return 0;
                case 5:
                    cig.xhp = aVar3.BTU.ve();
                    AppMethodBeat.o(51437);
                    return 0;
                default:
                    AppMethodBeat.o(51437);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51437);
            return -1;
        }
    }
}
