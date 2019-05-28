package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class f extends a {
    public LinkedList<g> mZI = new LinkedList();

    public f() {
        AppMethodBeat.i(116990);
        AppMethodBeat.o(116990);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116991);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.mZI);
            AppMethodBeat.o(116991);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.mZI) + 0;
            AppMethodBeat.o(116991);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZI.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(116991);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar3, gVar, a.getNextFieldNumber(aVar3))) {
                        }
                        fVar.mZI.add(gVar);
                    }
                    AppMethodBeat.o(116991);
                    return 0;
                default:
                    AppMethodBeat.o(116991);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116991);
            return -1;
        }
    }
}
