package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class biw extends a {
    public String cEh;
    public String cIY;
    public int tBA;
    public int tBB;
    public long tBC;
    public String tBl;
    public long tBx;
    public long tBy;
    public long tBz;
    public String tID;
    public String title;
    public String type;
    public String tzT;
    public String url;
    public String wMj;
    public String wMk;
    public String wMl;
    public int wMm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56883);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            if (this.cIY != null) {
                aVar.e(3, this.cIY);
            }
            if (this.tID != null) {
                aVar.e(4, this.tID);
            }
            if (this.tBl != null) {
                aVar.e(5, this.tBl);
            }
            if (this.wMj != null) {
                aVar.e(6, this.wMj);
            }
            if (this.type != null) {
                aVar.e(7, this.type);
            }
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            aVar.ai(9, this.tBx);
            aVar.ai(10, this.tBy);
            if (this.tzT != null) {
                aVar.e(11, this.tzT);
            }
            aVar.ai(12, this.tBz);
            aVar.iz(13, this.tBA);
            aVar.iz(14, this.tBB);
            if (this.wMk != null) {
                aVar.e(15, this.wMk);
            }
            if (this.wMl != null) {
                aVar.e(16, this.wMl);
            }
            aVar.ai(17, this.tBC);
            aVar.iz(18, this.wMm);
            AppMethodBeat.o(56883);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = e.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(3, this.cIY);
            }
            if (this.tID != null) {
                f += e.a.a.b.b.a.f(4, this.tID);
            }
            if (this.tBl != null) {
                f += e.a.a.b.b.a.f(5, this.tBl);
            }
            if (this.wMj != null) {
                f += e.a.a.b.b.a.f(6, this.wMj);
            }
            if (this.type != null) {
                f += e.a.a.b.b.a.f(7, this.type);
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(8, this.title);
            }
            f = (f + e.a.a.b.b.a.o(9, this.tBx)) + e.a.a.b.b.a.o(10, this.tBy);
            if (this.tzT != null) {
                f += e.a.a.b.b.a.f(11, this.tzT);
            }
            f = ((f + e.a.a.b.b.a.o(12, this.tBz)) + e.a.a.b.b.a.bs(13, this.tBA)) + e.a.a.b.b.a.bs(14, this.tBB);
            if (this.wMk != null) {
                f += e.a.a.b.b.a.f(15, this.wMk);
            }
            if (this.wMl != null) {
                f += e.a.a.b.b.a.f(16, this.wMl);
            }
            int o = (f + e.a.a.b.b.a.o(17, this.tBC)) + e.a.a.b.b.a.bs(18, this.wMm);
            AppMethodBeat.o(56883);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56883);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            biw biw = (biw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    biw.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 2:
                    biw.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 3:
                    biw.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 4:
                    biw.tID = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 5:
                    biw.tBl = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 6:
                    biw.wMj = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 7:
                    biw.type = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 8:
                    biw.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 9:
                    biw.tBx = aVar3.BTU.ve();
                    AppMethodBeat.o(56883);
                    return 0;
                case 10:
                    biw.tBy = aVar3.BTU.ve();
                    AppMethodBeat.o(56883);
                    return 0;
                case 11:
                    biw.tzT = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 12:
                    biw.tBz = aVar3.BTU.ve();
                    AppMethodBeat.o(56883);
                    return 0;
                case 13:
                    biw.tBA = aVar3.BTU.vd();
                    AppMethodBeat.o(56883);
                    return 0;
                case 14:
                    biw.tBB = aVar3.BTU.vd();
                    AppMethodBeat.o(56883);
                    return 0;
                case 15:
                    biw.wMk = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 16:
                    biw.wMl = aVar3.BTU.readString();
                    AppMethodBeat.o(56883);
                    return 0;
                case 17:
                    biw.tBC = aVar3.BTU.ve();
                    AppMethodBeat.o(56883);
                    return 0;
                case 18:
                    biw.wMm = aVar3.BTU.vd();
                    AppMethodBeat.o(56883);
                    return 0;
                default:
                    AppMethodBeat.o(56883);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56883);
            return -1;
        }
    }
}
