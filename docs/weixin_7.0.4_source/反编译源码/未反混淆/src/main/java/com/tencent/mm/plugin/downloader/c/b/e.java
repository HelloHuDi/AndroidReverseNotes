package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class e extends a {
    public LinkedList<o> kLl = new LinkedList();
    public int kLm;

    public e() {
        AppMethodBeat.i(35530);
        AppMethodBeat.o(35530);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35531);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(4, 8, this.kLl);
            aVar.iz(5, this.kLm);
            AppMethodBeat.o(35531);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(4, 8, this.kLl) + 0) + e.a.a.b.b.a.bs(5, this.kLm);
            AppMethodBeat.o(35531);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kLl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35531);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        o oVar = new o();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.kLl.add(oVar);
                    }
                    AppMethodBeat.o(35531);
                    return 0;
                case 5:
                    eVar.kLm = aVar3.BTU.vd();
                    AppMethodBeat.o(35531);
                    return 0;
                default:
                    AppMethodBeat.o(35531);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35531);
            return -1;
        }
    }
}
