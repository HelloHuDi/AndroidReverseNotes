package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class ta extends a {
    public int waq;
    public b war;
    public bkd was;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48824);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.waq);
            if (this.war != null) {
                aVar.c(2, this.war);
            }
            if (this.was != null) {
                aVar.iy(3, this.was.computeSize());
                this.was.writeFields(aVar);
            }
            AppMethodBeat.o(48824);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.waq) + 0;
            if (this.war != null) {
                bs += e.a.a.b.b.a.b(2, this.war);
            }
            if (this.was != null) {
                bs += e.a.a.a.ix(3, this.was.computeSize());
            }
            AppMethodBeat.o(48824);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48824);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ta taVar = (ta) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    taVar.waq = aVar3.BTU.vd();
                    AppMethodBeat.o(48824);
                    return 0;
                case 2:
                    taVar.war = aVar3.BTU.emu();
                    AppMethodBeat.o(48824);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bkd bkd = new bkd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkd.populateBuilderWithField(aVar4, bkd, a.getNextFieldNumber(aVar4))) {
                        }
                        taVar.was = bkd;
                    }
                    AppMethodBeat.o(48824);
                    return 0;
                default:
                    AppMethodBeat.o(48824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48824);
            return -1;
        }
    }
}
