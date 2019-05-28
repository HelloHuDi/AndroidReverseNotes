package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ua extends a {
    public String vYA;
    public LinkedList<Integer> wbp = new LinkedList();

    public ua() {
        AppMethodBeat.i(28366);
        AppMethodBeat.o(28366);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28367);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYA != null) {
                aVar.e(1, this.vYA);
            }
            aVar.e(2, 2, this.wbp);
            AppMethodBeat.o(28367);
            return 0;
        } else if (i == 1) {
            if (this.vYA != null) {
                f = e.a.a.b.b.a.f(1, this.vYA) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 2, this.wbp);
            AppMethodBeat.o(28367);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wbp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28367);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ua uaVar = (ua) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uaVar.vYA = aVar3.BTU.readString();
                    AppMethodBeat.o(28367);
                    return 0;
                case 2:
                    uaVar.wbp.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(28367);
                    return 0;
                default:
                    AppMethodBeat.o(28367);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28367);
            return -1;
        }
    }
}
