package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class af extends a {
    public LinkedList<i> naO = new LinkedList();

    public af() {
        AppMethodBeat.i(111569);
        AppMethodBeat.o(111569);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111570);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.naO);
            AppMethodBeat.o(111570);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.naO) + 0;
            AppMethodBeat.o(111570);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.naO.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(111570);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            af afVar = (af) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        i iVar = new i();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = iVar.populateBuilderWithField(aVar3, iVar, a.getNextFieldNumber(aVar3))) {
                        }
                        afVar.naO.add(iVar);
                    }
                    AppMethodBeat.o(111570);
                    return 0;
                default:
                    AppMethodBeat.o(111570);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111570);
            return -1;
        }
    }
}
