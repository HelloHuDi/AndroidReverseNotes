package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class awg extends a {
    public String qkh;
    public String scope;
    public int wzW;
    public LinkedList<String> wzX = new LinkedList();

    public awg() {
        AppMethodBeat.i(10212);
        AppMethodBeat.o(10212);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10213);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            aVar.iz(2, this.wzW);
            if (this.qkh != null) {
                aVar.e(3, this.qkh);
            }
            aVar.e(4, 1, this.wzX);
            AppMethodBeat.o(10213);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                f = e.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wzW);
            if (this.qkh != null) {
                f += e.a.a.b.b.a.f(3, this.qkh);
            }
            int c = f + e.a.a.a.c(4, 1, this.wzX);
            AppMethodBeat.o(10213);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wzX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10213);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awg awg = (awg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awg.scope = aVar3.BTU.readString();
                    AppMethodBeat.o(10213);
                    return 0;
                case 2:
                    awg.wzW = aVar3.BTU.vd();
                    AppMethodBeat.o(10213);
                    return 0;
                case 3:
                    awg.qkh = aVar3.BTU.readString();
                    AppMethodBeat.o(10213);
                    return 0;
                case 4:
                    awg.wzX.add(aVar3.BTU.readString());
                    AppMethodBeat.o(10213);
                    return 0;
                default:
                    AppMethodBeat.o(10213);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10213);
            return -1;
        }
    }
}
