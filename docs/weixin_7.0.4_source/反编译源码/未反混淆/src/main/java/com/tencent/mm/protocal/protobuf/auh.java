package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class auh extends a {
    public String pdz;
    public String pho;
    public String wma;
    public String wym;
    public String wyn;
    public String wyo;
    public String wyp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48873);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pho == null) {
                bVar = new b("Not all required fields were included: product_id");
                AppMethodBeat.o(48873);
                throw bVar;
            } else if (this.pdz == null) {
                bVar = new b("Not all required fields were included: price");
                AppMethodBeat.o(48873);
                throw bVar;
            } else if (this.wma == null) {
                bVar = new b("Not all required fields were included: currency_type");
                AppMethodBeat.o(48873);
                throw bVar;
            } else if (this.wym == null) {
                bVar = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(48873);
                throw bVar;
            } else {
                if (this.pho != null) {
                    aVar.e(1, this.pho);
                }
                if (this.pdz != null) {
                    aVar.e(2, this.pdz);
                }
                if (this.wma != null) {
                    aVar.e(3, this.wma);
                }
                if (this.wym != null) {
                    aVar.e(4, this.wym);
                }
                if (this.wyn != null) {
                    aVar.e(5, this.wyn);
                }
                if (this.wyo != null) {
                    aVar.e(6, this.wyo);
                }
                if (this.wyp != null) {
                    aVar.e(7, this.wyp);
                }
                AppMethodBeat.o(48873);
                return 0;
            }
        } else if (i == 1) {
            if (this.pho != null) {
                f = e.a.a.b.b.a.f(1, this.pho) + 0;
            } else {
                f = 0;
            }
            if (this.pdz != null) {
                f += e.a.a.b.b.a.f(2, this.pdz);
            }
            if (this.wma != null) {
                f += e.a.a.b.b.a.f(3, this.wma);
            }
            if (this.wym != null) {
                f += e.a.a.b.b.a.f(4, this.wym);
            }
            if (this.wyn != null) {
                f += e.a.a.b.b.a.f(5, this.wyn);
            }
            if (this.wyo != null) {
                f += e.a.a.b.b.a.f(6, this.wyo);
            }
            if (this.wyp != null) {
                f += e.a.a.b.b.a.f(7, this.wyp);
            }
            AppMethodBeat.o(48873);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.pho == null) {
                bVar = new b("Not all required fields were included: product_id");
                AppMethodBeat.o(48873);
                throw bVar;
            } else if (this.pdz == null) {
                bVar = new b("Not all required fields were included: price");
                AppMethodBeat.o(48873);
                throw bVar;
            } else if (this.wma == null) {
                bVar = new b("Not all required fields were included: currency_type");
                AppMethodBeat.o(48873);
                throw bVar;
            } else if (this.wym == null) {
                bVar = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(48873);
                throw bVar;
            } else {
                AppMethodBeat.o(48873);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auh auh = (auh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auh.pho = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                case 2:
                    auh.pdz = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                case 3:
                    auh.wma = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                case 4:
                    auh.wym = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                case 5:
                    auh.wyn = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                case 6:
                    auh.wyo = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                case 7:
                    auh.wyp = aVar3.BTU.readString();
                    AppMethodBeat.o(48873);
                    return 0;
                default:
                    AppMethodBeat.o(48873);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48873);
            return -1;
        }
    }
}
