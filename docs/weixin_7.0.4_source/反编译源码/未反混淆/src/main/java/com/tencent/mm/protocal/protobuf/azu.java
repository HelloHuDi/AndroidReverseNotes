package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class azu extends a {
    public String desc;
    public int duration;
    public int fga;
    public int fgb = 0;
    public int fgc;
    public String fgd;
    public String lvx;
    public int vGc = -1;
    public int videoHeight;
    public int videoWidth;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94536);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vGc);
            aVar.iz(2, this.fgb);
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.iz(4, this.videoWidth);
            aVar.iz(5, this.videoHeight);
            aVar.iz(6, this.fga);
            aVar.iz(7, this.duration);
            if (this.fgd != null) {
                aVar.e(8, this.fgd);
            }
            aVar.iz(9, this.fgc);
            if (this.lvx != null) {
                aVar.e(10, this.lvx);
            }
            AppMethodBeat.o(94536);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vGc) + 0) + e.a.a.b.b.a.bs(2, this.fgb);
            if (this.desc != null) {
                bs += e.a.a.b.b.a.f(3, this.desc);
            }
            bs = (((bs + e.a.a.b.b.a.bs(4, this.videoWidth)) + e.a.a.b.b.a.bs(5, this.videoHeight)) + e.a.a.b.b.a.bs(6, this.fga)) + e.a.a.b.b.a.bs(7, this.duration);
            if (this.fgd != null) {
                bs += e.a.a.b.b.a.f(8, this.fgd);
            }
            bs += e.a.a.b.b.a.bs(9, this.fgc);
            if (this.lvx != null) {
                bs += e.a.a.b.b.a.f(10, this.lvx);
            }
            AppMethodBeat.o(94536);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94536);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azu azu = (azu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azu.vGc = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 2:
                    azu.fgb = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 3:
                    azu.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(94536);
                    return 0;
                case 4:
                    azu.videoWidth = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 5:
                    azu.videoHeight = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 6:
                    azu.fga = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 7:
                    azu.duration = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 8:
                    azu.fgd = aVar3.BTU.readString();
                    AppMethodBeat.o(94536);
                    return 0;
                case 9:
                    azu.fgc = aVar3.BTU.vd();
                    AppMethodBeat.o(94536);
                    return 0;
                case 10:
                    azu.lvx = aVar3.BTU.readString();
                    AppMethodBeat.o(94536);
                    return 0;
                default:
                    AppMethodBeat.o(94536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94536);
            return -1;
        }
    }
}
