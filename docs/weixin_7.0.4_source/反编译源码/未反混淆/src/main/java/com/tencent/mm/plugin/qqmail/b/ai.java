package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ai extends a {
    public String name;
    public String path;
    public long pvG;
    public String pvH;
    public long size;
    public int state;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(68075);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.path == null) {
                bVar = new b("Not all required fields were included: path");
                AppMethodBeat.o(68075);
                throw bVar;
            } else if (this.name == null) {
                bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(68075);
                throw bVar;
            } else {
                if (this.path != null) {
                    aVar.e(1, this.path);
                }
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                aVar.ai(3, this.size);
                aVar.iz(4, this.state);
                aVar.ai(5, this.pvG);
                if (this.pvH != null) {
                    aVar.e(6, this.pvH);
                }
                AppMethodBeat.o(68075);
                return 0;
            }
        } else if (i == 1) {
            if (this.path != null) {
                f = e.a.a.b.b.a.f(1, this.path) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(2, this.name);
            }
            f = ((f + e.a.a.b.b.a.o(3, this.size)) + e.a.a.b.b.a.bs(4, this.state)) + e.a.a.b.b.a.o(5, this.pvG);
            if (this.pvH != null) {
                f += e.a.a.b.b.a.f(6, this.pvH);
            }
            AppMethodBeat.o(68075);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.path == null) {
                bVar = new b("Not all required fields were included: path");
                AppMethodBeat.o(68075);
                throw bVar;
            } else if (this.name == null) {
                bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(68075);
                throw bVar;
            } else {
                AppMethodBeat.o(68075);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ai aiVar = (ai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aiVar.path = aVar3.BTU.readString();
                    AppMethodBeat.o(68075);
                    return 0;
                case 2:
                    aiVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(68075);
                    return 0;
                case 3:
                    aiVar.size = aVar3.BTU.ve();
                    AppMethodBeat.o(68075);
                    return 0;
                case 4:
                    aiVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(68075);
                    return 0;
                case 5:
                    aiVar.pvG = aVar3.BTU.ve();
                    AppMethodBeat.o(68075);
                    return 0;
                case 6:
                    aiVar.pvH = aVar3.BTU.readString();
                    AppMethodBeat.o(68075);
                    return 0;
                default:
                    AppMethodBeat.o(68075);
                    return -1;
            }
        } else {
            AppMethodBeat.o(68075);
            return -1;
        }
    }
}
