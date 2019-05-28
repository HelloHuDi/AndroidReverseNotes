package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class mr extends a {
    public String cIY;
    public String tID;
    public String title;
    public int type;
    public String tzT;
    public String url;
    public String vQG;
    public String vQH;
    public int vQI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56733);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.tID != null) {
                aVar.e(2, this.tID);
            }
            if (this.cIY != null) {
                aVar.e(3, this.cIY);
            }
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            if (this.tzT != null) {
                aVar.e(5, this.tzT);
            }
            if (this.url != null) {
                aVar.e(6, this.url);
            }
            if (this.vQG != null) {
                aVar.e(7, this.vQG);
            }
            if (this.vQH != null) {
                aVar.e(8, this.vQH);
            }
            aVar.iz(9, this.vQI);
            AppMethodBeat.o(56733);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.tID != null) {
                bs += e.a.a.b.b.a.f(2, this.tID);
            }
            if (this.cIY != null) {
                bs += e.a.a.b.b.a.f(3, this.cIY);
            }
            if (this.title != null) {
                bs += e.a.a.b.b.a.f(4, this.title);
            }
            if (this.tzT != null) {
                bs += e.a.a.b.b.a.f(5, this.tzT);
            }
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(6, this.url);
            }
            if (this.vQG != null) {
                bs += e.a.a.b.b.a.f(7, this.vQG);
            }
            if (this.vQH != null) {
                bs += e.a.a.b.b.a.f(8, this.vQH);
            }
            bs += e.a.a.b.b.a.bs(9, this.vQI);
            AppMethodBeat.o(56733);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56733);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mr mrVar = (mr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mrVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56733);
                    return 0;
                case 2:
                    mrVar.tID = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 3:
                    mrVar.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 4:
                    mrVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 5:
                    mrVar.tzT = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 6:
                    mrVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 7:
                    mrVar.vQG = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 8:
                    mrVar.vQH = aVar3.BTU.readString();
                    AppMethodBeat.o(56733);
                    return 0;
                case 9:
                    mrVar.vQI = aVar3.BTU.vd();
                    AppMethodBeat.o(56733);
                    return 0;
                default:
                    AppMethodBeat.o(56733);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56733);
            return -1;
        }
    }
}
