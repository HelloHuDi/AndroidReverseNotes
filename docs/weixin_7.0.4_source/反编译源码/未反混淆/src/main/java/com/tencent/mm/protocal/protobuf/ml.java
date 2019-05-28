package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ml extends a {
    public String Title;
    public String Url;
    public String vQl;
    public String vQm;
    public int vQn;
    public String vQo;
    public int vQp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124298);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(124298);
                throw bVar;
            } else if (this.Url == null) {
                bVar = new b("Not all required fields were included: Url");
                AppMethodBeat.o(124298);
                throw bVar;
            } else if (this.vQl == null) {
                bVar = new b("Not all required fields were included: Position");
                AppMethodBeat.o(124298);
                throw bVar;
            } else if (this.vQm == null) {
                bVar = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(124298);
                throw bVar;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.Url != null) {
                    aVar.e(2, this.Url);
                }
                if (this.vQl != null) {
                    aVar.e(3, this.vQl);
                }
                if (this.vQm != null) {
                    aVar.e(4, this.vQm);
                }
                aVar.iz(5, this.vQn);
                if (this.vQo != null) {
                    aVar.e(6, this.vQo);
                }
                aVar.iz(7, this.vQp);
                AppMethodBeat.o(124298);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(2, this.Url);
            }
            if (this.vQl != null) {
                f += e.a.a.b.b.a.f(3, this.vQl);
            }
            if (this.vQm != null) {
                f += e.a.a.b.b.a.f(4, this.vQm);
            }
            f += e.a.a.b.b.a.bs(5, this.vQn);
            if (this.vQo != null) {
                f += e.a.a.b.b.a.f(6, this.vQo);
            }
            int bs = f + e.a.a.b.b.a.bs(7, this.vQp);
            AppMethodBeat.o(124298);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(124298);
                throw bVar;
            } else if (this.Url == null) {
                bVar = new b("Not all required fields were included: Url");
                AppMethodBeat.o(124298);
                throw bVar;
            } else if (this.vQl == null) {
                bVar = new b("Not all required fields were included: Position");
                AppMethodBeat.o(124298);
                throw bVar;
            } else if (this.vQm == null) {
                bVar = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(124298);
                throw bVar;
            } else {
                AppMethodBeat.o(124298);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ml mlVar = (ml) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mlVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(124298);
                    return 0;
                case 2:
                    mlVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(124298);
                    return 0;
                case 3:
                    mlVar.vQl = aVar3.BTU.readString();
                    AppMethodBeat.o(124298);
                    return 0;
                case 4:
                    mlVar.vQm = aVar3.BTU.readString();
                    AppMethodBeat.o(124298);
                    return 0;
                case 5:
                    mlVar.vQn = aVar3.BTU.vd();
                    AppMethodBeat.o(124298);
                    return 0;
                case 6:
                    mlVar.vQo = aVar3.BTU.readString();
                    AppMethodBeat.o(124298);
                    return 0;
                case 7:
                    mlVar.vQp = aVar3.BTU.vd();
                    AppMethodBeat.o(124298);
                    return 0;
                default:
                    AppMethodBeat.o(124298);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124298);
            return -1;
        }
    }
}
