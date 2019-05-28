package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class cwb extends a {
    public LinkedList<cdn> xrV = new LinkedList();
    public b xrW;

    public cwb() {
        AppMethodBeat.i(28769);
        AppMethodBeat.o(28769);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28770);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xrV);
            if (this.xrW != null) {
                aVar.c(2, this.xrW);
            }
            AppMethodBeat.o(28770);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xrV) + 0;
            if (this.xrW != null) {
                c += e.a.a.b.b.a.b(2, this.xrW);
            }
            AppMethodBeat.o(28770);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xrV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28770);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwb cwb = (cwb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdn cdn = new cdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdn.populateBuilderWithField(aVar4, cdn, a.getNextFieldNumber(aVar4))) {
                        }
                        cwb.xrV.add(cdn);
                    }
                    AppMethodBeat.o(28770);
                    return 0;
                case 2:
                    cwb.xrW = aVar3.BTU.emu();
                    AppMethodBeat.o(28770);
                    return 0;
                default:
                    AppMethodBeat.o(28770);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28770);
            return -1;
        }
    }
}
