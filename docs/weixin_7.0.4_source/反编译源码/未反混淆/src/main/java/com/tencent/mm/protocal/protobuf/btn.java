package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class btn extends a {
    public String title;
    public LinkedList<bbd> wVw = new LinkedList();

    public btn() {
        AppMethodBeat.i(48957);
        AppMethodBeat.o(48957);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48958);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wVw);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            AppMethodBeat.o(48958);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wVw) + 0;
            if (this.title != null) {
                c += e.a.a.b.b.a.f(2, this.title);
            }
            AppMethodBeat.o(48958);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wVw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48958);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btn btn = (btn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbd bbd = new bbd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bbd.populateBuilderWithField(aVar4, bbd, a.getNextFieldNumber(aVar4))) {
                        }
                        btn.wVw.add(bbd);
                    }
                    AppMethodBeat.o(48958);
                    return 0;
                case 2:
                    btn.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48958);
                    return 0;
                default:
                    AppMethodBeat.o(48958);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48958);
            return -1;
        }
    }
}
