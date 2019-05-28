package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class v extends a {
    public String Title;
    public String jBB;
    public String mZs;
    public String naq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111559);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111559);
                throw bVar;
            } else if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111559);
                throw bVar;
            } else {
                if (this.jBB != null) {
                    aVar.e(1, this.jBB);
                }
                if (this.mZs != null) {
                    aVar.e(2, this.mZs);
                }
                if (this.Title != null) {
                    aVar.e(3, this.Title);
                }
                if (this.naq != null) {
                    aVar.e(4, this.naq);
                }
                AppMethodBeat.o(111559);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.mZs != null) {
                f += e.a.a.b.b.a.f(2, this.mZs);
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.naq != null) {
                f += e.a.a.b.b.a.f(4, this.naq);
            }
            AppMethodBeat.o(111559);
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
                AppMethodBeat.o(111559);
                throw bVar;
            } else if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111559);
                throw bVar;
            } else {
                AppMethodBeat.o(111559);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(111559);
                    return 0;
                case 2:
                    vVar.mZs = aVar3.BTU.readString();
                    AppMethodBeat.o(111559);
                    return 0;
                case 3:
                    vVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111559);
                    return 0;
                case 4:
                    vVar.naq = aVar3.BTU.readString();
                    AppMethodBeat.o(111559);
                    return 0;
                default:
                    AppMethodBeat.o(111559);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111559);
            return -1;
        }
    }
}
