package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bjm extends a {
    public String title;
    public LinkedList<bjl> wMT = new LinkedList();

    public bjm() {
        AppMethodBeat.i(48919);
        AppMethodBeat.o(48919);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48920);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.e(2, 8, this.wMT);
            AppMethodBeat.o(48920);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.wMT);
            AppMethodBeat.o(48920);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMT.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48920);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjm bjm = (bjm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjm.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48920);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bjl bjl = new bjl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bjl.populateBuilderWithField(aVar4, bjl, a.getNextFieldNumber(aVar4))) {
                        }
                        bjm.wMT.add(bjl);
                    }
                    AppMethodBeat.o(48920);
                    return 0;
                default:
                    AppMethodBeat.o(48920);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48920);
            return -1;
        }
    }
}
