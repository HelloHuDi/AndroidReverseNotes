package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ctr extends a {
    public int vOq;
    public LinkedList<ctk> woe = new LinkedList();
    public boolean xqq;

    public ctr() {
        AppMethodBeat.i(28726);
        AppMethodBeat.o(28726);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28727);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.woe);
            aVar.iz(2, this.vOq);
            aVar.aO(3, this.xqq);
            AppMethodBeat.o(28727);
            return 0;
        } else if (i == 1) {
            c = ((e.a.a.a.c(1, 8, this.woe) + 0) + e.a.a.b.b.a.bs(2, this.vOq)) + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(28727);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woe.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28727);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctr ctr = (ctr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ctk ctk = new ctk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ctk.populateBuilderWithField(aVar4, ctk, a.getNextFieldNumber(aVar4))) {
                        }
                        ctr.woe.add(ctk);
                    }
                    AppMethodBeat.o(28727);
                    return 0;
                case 2:
                    ctr.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(28727);
                    return 0;
                case 3:
                    ctr.xqq = aVar3.BTU.ehX();
                    AppMethodBeat.o(28727);
                    return 0;
                default:
                    AppMethodBeat.o(28727);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28727);
            return -1;
        }
    }
}
