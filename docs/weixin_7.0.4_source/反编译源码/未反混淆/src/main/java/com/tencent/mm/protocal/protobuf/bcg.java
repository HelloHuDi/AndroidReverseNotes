package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bcg extends a {
    public String gfa;
    public bgc wGM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80122);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.gfa != null) {
                aVar.e(1, this.gfa);
            }
            if (this.wGM != null) {
                aVar.iy(2, this.wGM.computeSize());
                this.wGM.writeFields(aVar);
            }
            AppMethodBeat.o(80122);
            return 0;
        } else if (i == 1) {
            if (this.gfa != null) {
                f = e.a.a.b.b.a.f(1, this.gfa) + 0;
            } else {
                f = 0;
            }
            if (this.wGM != null) {
                f += e.a.a.a.ix(2, this.wGM.computeSize());
            }
            AppMethodBeat.o(80122);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80122);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcg bcg = (bcg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bcg.gfa = aVar3.BTU.readString();
                    AppMethodBeat.o(80122);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bgc bgc = new bgc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgc.populateBuilderWithField(aVar4, bgc, a.getNextFieldNumber(aVar4))) {
                        }
                        bcg.wGM = bgc;
                    }
                    AppMethodBeat.o(80122);
                    return 0;
                default:
                    AppMethodBeat.o(80122);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80122);
            return -1;
        }
    }
}
