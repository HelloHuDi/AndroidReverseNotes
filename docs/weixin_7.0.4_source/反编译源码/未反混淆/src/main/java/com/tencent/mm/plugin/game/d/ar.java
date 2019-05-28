package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ar extends a {
    public String naq;
    public LinkedList<String> nbh = new LinkedList();

    public ar() {
        AppMethodBeat.i(111585);
        AppMethodBeat.o(111585);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111586);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111586);
                throw bVar;
            }
            if (this.naq != null) {
                aVar.e(2, this.naq);
            }
            aVar.e(3, 1, this.nbh);
            AppMethodBeat.o(111586);
            return 0;
        } else if (i == 1) {
            if (this.naq != null) {
                f = e.a.a.b.b.a.f(2, this.naq) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(3, 1, this.nbh);
            AppMethodBeat.o(111586);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.nbh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111586);
                throw bVar;
            }
            AppMethodBeat.o(111586);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ar arVar = (ar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    arVar.naq = aVar3.BTU.readString();
                    AppMethodBeat.o(111586);
                    return 0;
                case 3:
                    arVar.nbh.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111586);
                    return 0;
                default:
                    AppMethodBeat.o(111586);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111586);
            return -1;
        }
    }
}
