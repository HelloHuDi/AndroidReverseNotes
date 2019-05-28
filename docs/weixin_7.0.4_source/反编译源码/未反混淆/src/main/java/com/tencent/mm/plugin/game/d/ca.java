package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ca extends a {
    public String Title;
    public String ncM;
    public LinkedList<String> ncN = new LinkedList();

    public ca() {
        AppMethodBeat.i(111634);
        AppMethodBeat.o(111634);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111635);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.ncM != null) {
                aVar.e(2, this.ncM);
            }
            aVar.e(3, 1, this.ncN);
            AppMethodBeat.o(111635);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(2, this.ncM);
            }
            int c = f + e.a.a.a.c(3, 1, this.ncN);
            AppMethodBeat.o(111635);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ncN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111635);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ca caVar = (ca) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    caVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111635);
                    return 0;
                case 2:
                    caVar.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(111635);
                    return 0;
                case 3:
                    caVar.ncN.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111635);
                    return 0;
                default:
                    AppMethodBeat.o(111635);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111635);
            return -1;
        }
    }
}
