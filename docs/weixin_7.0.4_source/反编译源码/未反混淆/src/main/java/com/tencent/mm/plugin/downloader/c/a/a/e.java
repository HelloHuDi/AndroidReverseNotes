package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class e extends a {
    public LinkedList<g> kKu = new LinkedList();
    public long kKv;

    public e() {
        AppMethodBeat.i(35512);
        AppMethodBeat.o(35512);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35513);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.kKu);
            aVar.ai(2, this.kKv);
            AppMethodBeat.o(35513);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.kKu) + 0) + e.a.a.b.b.a.o(2, this.kKv);
            AppMethodBeat.o(35513);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35513);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.kKu.add(gVar);
                    }
                    AppMethodBeat.o(35513);
                    return 0;
                case 2:
                    eVar.kKv = aVar3.BTU.ve();
                    AppMethodBeat.o(35513);
                    return 0;
                default:
                    AppMethodBeat.o(35513);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35513);
            return -1;
        }
    }
}
