package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bbg extends a {
    public String clY;
    public LinkedList<String> wFX = new LinkedList();

    public bbg() {
        AppMethodBeat.i(2544);
        AppMethodBeat.o(2544);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2545);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.clY != null) {
                aVar.e(1, this.clY);
            }
            aVar.e(2, 1, this.wFX);
            AppMethodBeat.o(2545);
            return 0;
        } else if (i == 1) {
            if (this.clY != null) {
                f = e.a.a.b.b.a.f(1, this.clY) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 1, this.wFX);
            AppMethodBeat.o(2545);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wFX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2545);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbg bbg = (bbg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbg.clY = aVar3.BTU.readString();
                    AppMethodBeat.o(2545);
                    return 0;
                case 2:
                    bbg.wFX.add(aVar3.BTU.readString());
                    AppMethodBeat.o(2545);
                    return 0;
                default:
                    AppMethodBeat.o(2545);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2545);
            return -1;
        }
    }
}
