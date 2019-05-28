package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ayp extends a {
    public LinkedList<cnv> vCQ = new LinkedList();
    public String vJS;

    public ayp() {
        AppMethodBeat.i(48882);
        AppMethodBeat.o(48882);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48883);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vCQ);
            if (this.vJS != null) {
                aVar.e(2, this.vJS);
            }
            AppMethodBeat.o(48883);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vCQ) + 0;
            if (this.vJS != null) {
                c += e.a.a.b.b.a.f(2, this.vJS);
            }
            AppMethodBeat.o(48883);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48883);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayp ayp = (ayp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnv cnv = new cnv();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cnv.populateBuilderWithField(aVar4, cnv, a.getNextFieldNumber(aVar4))) {
                        }
                        ayp.vCQ.add(cnv);
                    }
                    AppMethodBeat.o(48883);
                    return 0;
                case 2:
                    ayp.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48883);
                    return 0;
                default:
                    AppMethodBeat.o(48883);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48883);
            return -1;
        }
    }
}
