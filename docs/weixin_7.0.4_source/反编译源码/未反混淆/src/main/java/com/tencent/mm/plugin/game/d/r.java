package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class r extends a {
    public LinkedList<dm> nak = new LinkedList();

    public r() {
        AppMethodBeat.i(116994);
        AppMethodBeat.o(116994);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116995);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.nak);
            AppMethodBeat.o(116995);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.nak) + 0;
            AppMethodBeat.o(116995);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nak.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(116995);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dm dmVar = new dm();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dmVar.populateBuilderWithField(aVar3, dmVar, a.getNextFieldNumber(aVar3))) {
                        }
                        rVar.nak.add(dmVar);
                    }
                    AppMethodBeat.o(116995);
                    return 0;
                default:
                    AppMethodBeat.o(116995);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116995);
            return -1;
        }
    }
}
