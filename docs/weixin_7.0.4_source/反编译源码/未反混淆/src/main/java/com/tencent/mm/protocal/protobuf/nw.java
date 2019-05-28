package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nw extends a {
    public LinkedList<ns> vTp = new LinkedList();
    public String vTq;

    public nw() {
        AppMethodBeat.i(89032);
        AppMethodBeat.o(89032);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89033);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vTp);
            if (this.vTq != null) {
                aVar.e(2, this.vTq);
            }
            AppMethodBeat.o(89033);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vTp) + 0;
            if (this.vTq != null) {
                c += e.a.a.b.b.a.f(2, this.vTq);
            }
            AppMethodBeat.o(89033);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89033);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nw nwVar = (nw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ns nsVar = new ns();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nsVar.populateBuilderWithField(aVar4, nsVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nwVar.vTp.add(nsVar);
                    }
                    AppMethodBeat.o(89033);
                    return 0;
                case 2:
                    nwVar.vTq = aVar3.BTU.readString();
                    AppMethodBeat.o(89033);
                    return 0;
                default:
                    AppMethodBeat.o(89033);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89033);
            return -1;
        }
    }
}
