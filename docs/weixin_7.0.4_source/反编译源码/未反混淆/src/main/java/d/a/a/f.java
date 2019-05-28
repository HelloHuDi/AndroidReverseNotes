package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class f extends a {
    public String wMk;
    public String wMl;
    public int wMm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57011);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMk != null) {
                aVar.e(1, this.wMk);
            }
            if (this.wMl != null) {
                aVar.e(2, this.wMl);
            }
            aVar.iz(3, this.wMm);
            AppMethodBeat.o(57011);
            return 0;
        } else if (i == 1) {
            if (this.wMk != null) {
                f = e.a.a.b.b.a.f(1, this.wMk) + 0;
            } else {
                f = 0;
            }
            if (this.wMl != null) {
                f += e.a.a.b.b.a.f(2, this.wMl);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.wMm);
            AppMethodBeat.o(57011);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57011);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.wMk = aVar3.BTU.readString();
                    AppMethodBeat.o(57011);
                    return 0;
                case 2:
                    fVar.wMl = aVar3.BTU.readString();
                    AppMethodBeat.o(57011);
                    return 0;
                case 3:
                    fVar.wMm = aVar3.BTU.vd();
                    AppMethodBeat.o(57011);
                    return 0;
                default:
                    AppMethodBeat.o(57011);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57011);
            return -1;
        }
    }
}
