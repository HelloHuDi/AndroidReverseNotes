package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> nJr = new LinkedList();
    public String nJs;

    public b() {
        AppMethodBeat.i(113291);
        AppMethodBeat.o(113291);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113292);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.nJr);
            if (this.nJs != null) {
                aVar.e(2, this.nJs);
            }
            AppMethodBeat.o(113292);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.nJr) + 0;
            if (this.nJs != null) {
                c += e.a.a.b.b.a.f(2, this.nJs);
            }
            AppMethodBeat.o(113292);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nJr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(113292);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar4 = new a();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.nJr.add(aVar4);
                    }
                    AppMethodBeat.o(113292);
                    return 0;
                case 2:
                    bVar.nJs = aVar3.BTU.readString();
                    AppMethodBeat.o(113292);
                    return 0;
                default:
                    AppMethodBeat.o(113292);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113292);
            return -1;
        }
    }
}
