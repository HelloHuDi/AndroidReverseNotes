package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cgv extends a {
    public String vJS;
    public LinkedList<cgt> xfD = new LinkedList();

    public cgv() {
        AppMethodBeat.i(48970);
        AppMethodBeat.o(48970);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48971);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xfD);
            if (this.vJS != null) {
                aVar.e(2, this.vJS);
            }
            AppMethodBeat.o(48971);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xfD) + 0;
            if (this.vJS != null) {
                c += e.a.a.b.b.a.f(2, this.vJS);
            }
            AppMethodBeat.o(48971);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48971);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgv cgv = (cgv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgt cgt = new cgt();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgt.populateBuilderWithField(aVar4, cgt, a.getNextFieldNumber(aVar4))) {
                        }
                        cgv.xfD.add(cgt);
                    }
                    AppMethodBeat.o(48971);
                    return 0;
                case 2:
                    cgv.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48971);
                    return 0;
                default:
                    AppMethodBeat.o(48971);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48971);
            return -1;
        }
    }
}
