package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ati extends a {
    public String cIY;
    public int iAd;
    public String kdf;
    public String vYh;
    public long wch;
    public String wpp;
    public int wxp;
    public long wxq;
    public long wxr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48870);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYh != null) {
                aVar.e(1, this.vYh);
            }
            aVar.ai(2, this.wch);
            aVar.iz(3, this.wxp);
            aVar.ai(4, this.wxq);
            aVar.ai(5, this.wxr);
            if (this.wpp != null) {
                aVar.e(6, this.wpp);
            }
            if (this.kdf != null) {
                aVar.e(7, this.kdf);
            }
            aVar.iz(8, this.iAd);
            if (this.cIY != null) {
                aVar.e(9, this.cIY);
            }
            AppMethodBeat.o(48870);
            return 0;
        } else if (i == 1) {
            if (this.vYh != null) {
                f = e.a.a.b.b.a.f(1, this.vYh) + 0;
            } else {
                f = 0;
            }
            f = (((f + e.a.a.b.b.a.o(2, this.wch)) + e.a.a.b.b.a.bs(3, this.wxp)) + e.a.a.b.b.a.o(4, this.wxq)) + e.a.a.b.b.a.o(5, this.wxr);
            if (this.wpp != null) {
                f += e.a.a.b.b.a.f(6, this.wpp);
            }
            if (this.kdf != null) {
                f += e.a.a.b.b.a.f(7, this.kdf);
            }
            f += e.a.a.b.b.a.bs(8, this.iAd);
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(9, this.cIY);
            }
            AppMethodBeat.o(48870);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48870);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ati ati = (ati) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ati.vYh = aVar3.BTU.readString();
                    AppMethodBeat.o(48870);
                    return 0;
                case 2:
                    ati.wch = aVar3.BTU.ve();
                    AppMethodBeat.o(48870);
                    return 0;
                case 3:
                    ati.wxp = aVar3.BTU.vd();
                    AppMethodBeat.o(48870);
                    return 0;
                case 4:
                    ati.wxq = aVar3.BTU.ve();
                    AppMethodBeat.o(48870);
                    return 0;
                case 5:
                    ati.wxr = aVar3.BTU.ve();
                    AppMethodBeat.o(48870);
                    return 0;
                case 6:
                    ati.wpp = aVar3.BTU.readString();
                    AppMethodBeat.o(48870);
                    return 0;
                case 7:
                    ati.kdf = aVar3.BTU.readString();
                    AppMethodBeat.o(48870);
                    return 0;
                case 8:
                    ati.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(48870);
                    return 0;
                case 9:
                    ati.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(48870);
                    return 0;
                default:
                    AppMethodBeat.o(48870);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48870);
            return -1;
        }
    }
}
