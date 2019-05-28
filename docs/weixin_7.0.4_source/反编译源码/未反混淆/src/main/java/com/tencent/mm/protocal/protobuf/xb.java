package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class xb extends a {
    public String content;
    public String title;
    public LinkedList<xc> wct = new LinkedList();

    public xb() {
        AppMethodBeat.i(48837);
        AppMethodBeat.o(48837);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48838);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wct);
            if (this.content != null) {
                aVar.e(2, this.content);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            AppMethodBeat.o(48838);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wct) + 0;
            if (this.content != null) {
                c += e.a.a.b.b.a.f(2, this.content);
            }
            if (this.title != null) {
                c += e.a.a.b.b.a.f(3, this.title);
            }
            AppMethodBeat.o(48838);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wct.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48838);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xb xbVar = (xb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xc xcVar = new xc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = xcVar.populateBuilderWithField(aVar4, xcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        xbVar.wct.add(xcVar);
                    }
                    AppMethodBeat.o(48838);
                    return 0;
                case 2:
                    xbVar.content = aVar3.BTU.readString();
                    AppMethodBeat.o(48838);
                    return 0;
                case 3:
                    xbVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48838);
                    return 0;
                default:
                    AppMethodBeat.o(48838);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48838);
            return -1;
        }
    }
}
