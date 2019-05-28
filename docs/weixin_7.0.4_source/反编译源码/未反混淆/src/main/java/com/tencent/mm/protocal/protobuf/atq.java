package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atq extends a {
    public String Md5;
    public String Name;
    public String Type;
    public String Url;
    public int jCo;
    public String vRA;
    public String vRw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28523);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Type != null) {
                aVar.e(1, this.Type);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            aVar.iz(3, this.jCo);
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            if (this.vRA != null) {
                aVar.e(5, this.vRA);
            }
            if (this.vRw != null) {
                aVar.e(6, this.vRw);
            }
            if (this.Url != null) {
                aVar.e(7, this.Url);
            }
            AppMethodBeat.o(28523);
            return 0;
        } else if (i == 1) {
            if (this.Type != null) {
                f = e.a.a.b.b.a.f(1, this.Type) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += e.a.a.b.b.a.f(2, this.Name);
            }
            f += e.a.a.b.b.a.bs(3, this.jCo);
            if (this.Md5 != null) {
                f += e.a.a.b.b.a.f(4, this.Md5);
            }
            if (this.vRA != null) {
                f += e.a.a.b.b.a.f(5, this.vRA);
            }
            if (this.vRw != null) {
                f += e.a.a.b.b.a.f(6, this.vRw);
            }
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(7, this.Url);
            }
            AppMethodBeat.o(28523);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28523);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atq atq = (atq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atq.Type = aVar3.BTU.readString();
                    AppMethodBeat.o(28523);
                    return 0;
                case 2:
                    atq.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(28523);
                    return 0;
                case 3:
                    atq.jCo = aVar3.BTU.vd();
                    AppMethodBeat.o(28523);
                    return 0;
                case 4:
                    atq.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(28523);
                    return 0;
                case 5:
                    atq.vRA = aVar3.BTU.readString();
                    AppMethodBeat.o(28523);
                    return 0;
                case 6:
                    atq.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(28523);
                    return 0;
                case 7:
                    atq.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(28523);
                    return 0;
                default:
                    AppMethodBeat.o(28523);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28523);
            return -1;
        }
    }
}
