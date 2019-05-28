package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class add extends a {
    public String Desc;
    public String ThumbUrl;
    public String Title;
    public String fKh;
    public String ncH;
    public int vNm;
    public String wkC;
    public int wkX;
    public int wkY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112434);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(112434);
                throw bVar;
            } else if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(112434);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                bVar = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(112434);
                throw bVar;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.Desc != null) {
                    aVar.e(2, this.Desc);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(3, this.ThumbUrl);
                }
                if (this.wkC != null) {
                    aVar.e(4, this.wkC);
                }
                aVar.iz(5, this.wkX);
                aVar.iz(6, this.wkY);
                if (this.fKh != null) {
                    aVar.e(7, this.fKh);
                }
                aVar.iz(8, this.vNm);
                if (this.ncH != null) {
                    aVar.e(9, this.ncH);
                }
                AppMethodBeat.o(112434);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f += e.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.wkC != null) {
                f += e.a.a.b.b.a.f(4, this.wkC);
            }
            f = (f + e.a.a.b.b.a.bs(5, this.wkX)) + e.a.a.b.b.a.bs(6, this.wkY);
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(7, this.fKh);
            }
            f += e.a.a.b.b.a.bs(8, this.vNm);
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(9, this.ncH);
            }
            AppMethodBeat.o(112434);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(112434);
                throw bVar;
            } else if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(112434);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                bVar = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(112434);
                throw bVar;
            } else {
                AppMethodBeat.o(112434);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            add add = (add) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    add.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(112434);
                    return 0;
                case 2:
                    add.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(112434);
                    return 0;
                case 3:
                    add.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(112434);
                    return 0;
                case 4:
                    add.wkC = aVar3.BTU.readString();
                    AppMethodBeat.o(112434);
                    return 0;
                case 5:
                    add.wkX = aVar3.BTU.vd();
                    AppMethodBeat.o(112434);
                    return 0;
                case 6:
                    add.wkY = aVar3.BTU.vd();
                    AppMethodBeat.o(112434);
                    return 0;
                case 7:
                    add.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(112434);
                    return 0;
                case 8:
                    add.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(112434);
                    return 0;
                case 9:
                    add.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(112434);
                    return 0;
                default:
                    AppMethodBeat.o(112434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112434);
            return -1;
        }
    }
}
