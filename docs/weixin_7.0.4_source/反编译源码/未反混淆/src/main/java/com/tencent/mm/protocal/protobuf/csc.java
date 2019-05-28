package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class csc extends a {
    public int jBv;
    public LinkedList<csb> xpz = new LinkedList();

    public csc() {
        AppMethodBeat.i(28714);
        AppMethodBeat.o(28714);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28715);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xpz);
            aVar.iz(2, this.jBv);
            AppMethodBeat.o(28715);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.xpz) + 0) + e.a.a.b.b.a.bs(2, this.jBv);
            AppMethodBeat.o(28715);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xpz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28715);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csc csc = (csc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csb csb = new csb();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = csb.populateBuilderWithField(aVar4, csb, a.getNextFieldNumber(aVar4))) {
                        }
                        csc.xpz.add(csb);
                    }
                    AppMethodBeat.o(28715);
                    return 0;
                case 2:
                    csc.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(28715);
                    return 0;
                default:
                    AppMethodBeat.o(28715);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28715);
            return -1;
        }
    }
}
