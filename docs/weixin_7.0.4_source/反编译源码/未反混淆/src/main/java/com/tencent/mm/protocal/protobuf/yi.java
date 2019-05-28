package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class yi extends a {
    public int vEq;
    public String wea;
    public String web;
    public String wec;
    public String wed;
    public String wee;
    public int wef;
    public int weg;
    public String weh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62544);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wea == null) {
                bVar = new b("Not all required fields were included: BegWord");
                AppMethodBeat.o(62544);
                throw bVar;
            } else if (this.web == null) {
                bVar = new b("Not all required fields were included: BegPicUrl");
                AppMethodBeat.o(62544);
                throw bVar;
            } else if (this.wec == null) {
                bVar = new b("Not all required fields were included: ThanksPicUrl");
                AppMethodBeat.o(62544);
                throw bVar;
            } else {
                if (this.wea != null) {
                    aVar.e(1, this.wea);
                }
                if (this.web != null) {
                    aVar.e(2, this.web);
                }
                if (this.wec != null) {
                    aVar.e(3, this.wec);
                }
                if (this.wed != null) {
                    aVar.e(4, this.wed);
                }
                if (this.wee != null) {
                    aVar.e(5, this.wee);
                }
                aVar.iz(6, this.wef);
                aVar.iz(7, this.weg);
                if (this.weh != null) {
                    aVar.e(8, this.weh);
                }
                aVar.iz(9, this.vEq);
                AppMethodBeat.o(62544);
                return 0;
            }
        } else if (i == 1) {
            if (this.wea != null) {
                f = e.a.a.b.b.a.f(1, this.wea) + 0;
            } else {
                f = 0;
            }
            if (this.web != null) {
                f += e.a.a.b.b.a.f(2, this.web);
            }
            if (this.wec != null) {
                f += e.a.a.b.b.a.f(3, this.wec);
            }
            if (this.wed != null) {
                f += e.a.a.b.b.a.f(4, this.wed);
            }
            if (this.wee != null) {
                f += e.a.a.b.b.a.f(5, this.wee);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.wef)) + e.a.a.b.b.a.bs(7, this.weg);
            if (this.weh != null) {
                f += e.a.a.b.b.a.f(8, this.weh);
            }
            int bs = f + e.a.a.b.b.a.bs(9, this.vEq);
            AppMethodBeat.o(62544);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wea == null) {
                bVar = new b("Not all required fields were included: BegWord");
                AppMethodBeat.o(62544);
                throw bVar;
            } else if (this.web == null) {
                bVar = new b("Not all required fields were included: BegPicUrl");
                AppMethodBeat.o(62544);
                throw bVar;
            } else if (this.wec == null) {
                bVar = new b("Not all required fields were included: ThanksPicUrl");
                AppMethodBeat.o(62544);
                throw bVar;
            } else {
                AppMethodBeat.o(62544);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yi yiVar = (yi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yiVar.wea = aVar3.BTU.readString();
                    AppMethodBeat.o(62544);
                    return 0;
                case 2:
                    yiVar.web = aVar3.BTU.readString();
                    AppMethodBeat.o(62544);
                    return 0;
                case 3:
                    yiVar.wec = aVar3.BTU.readString();
                    AppMethodBeat.o(62544);
                    return 0;
                case 4:
                    yiVar.wed = aVar3.BTU.readString();
                    AppMethodBeat.o(62544);
                    return 0;
                case 5:
                    yiVar.wee = aVar3.BTU.readString();
                    AppMethodBeat.o(62544);
                    return 0;
                case 6:
                    yiVar.wef = aVar3.BTU.vd();
                    AppMethodBeat.o(62544);
                    return 0;
                case 7:
                    yiVar.weg = aVar3.BTU.vd();
                    AppMethodBeat.o(62544);
                    return 0;
                case 8:
                    yiVar.weh = aVar3.BTU.readString();
                    AppMethodBeat.o(62544);
                    return 0;
                case 9:
                    yiVar.vEq = aVar3.BTU.vd();
                    AppMethodBeat.o(62544);
                    return 0;
                default:
                    AppMethodBeat.o(62544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62544);
            return -1;
        }
    }
}
