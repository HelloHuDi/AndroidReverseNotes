package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class s extends a {
    public boolean nal;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116996);
        int fv;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).aO(1, this.nal);
            AppMethodBeat.o(116996);
            return 0;
        } else if (i == 1) {
            fv = (e.a.a.b.b.a.fv(1) + 1) + 0;
            AppMethodBeat.o(116996);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar); fv > 0; fv = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, fv)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(116996);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sVar.nal = aVar2.BTU.ehX();
                    AppMethodBeat.o(116996);
                    return 0;
                default:
                    AppMethodBeat.o(116996);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116996);
            return -1;
        }
    }
}
