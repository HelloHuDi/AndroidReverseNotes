package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class rg extends a {
    public b vYw;
    public LinkedList<b> vYx = new LinkedList();

    public rg() {
        AppMethodBeat.i(96213);
        AppMethodBeat.o(96213);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96214);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYw != null) {
                aVar.c(1, this.vYw);
            }
            aVar.e(2, 6, this.vYx);
            AppMethodBeat.o(96214);
            return 0;
        } else if (i == 1) {
            if (this.vYw != null) {
                b = e.a.a.b.b.a.b(1, this.vYw) + 0;
            } else {
                b = 0;
            }
            int c = b + e.a.a.a.c(2, 6, this.vYx);
            AppMethodBeat.o(96214);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vYx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96214);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rg rgVar = (rg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rgVar.vYw = aVar3.BTU.emu();
                    AppMethodBeat.o(96214);
                    return 0;
                case 2:
                    rgVar.vYx.add(aVar3.BTU.emu());
                    AppMethodBeat.o(96214);
                    return 0;
                default:
                    AppMethodBeat.o(96214);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96214);
            return -1;
        }
    }
}
