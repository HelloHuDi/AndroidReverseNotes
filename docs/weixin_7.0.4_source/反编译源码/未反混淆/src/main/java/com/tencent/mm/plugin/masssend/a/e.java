package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class e extends a {
    public int count;
    public LinkedList<d> oog = new LinkedList();

    public e() {
        AppMethodBeat.i(22736);
        AppMethodBeat.o(22736);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(22737);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.count);
            aVar.e(2, 8, this.oog);
            AppMethodBeat.o(22737);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.count) + 0) + e.a.a.a.c(2, 8, this.oog);
            AppMethodBeat.o(22737);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.oog.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(22737);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.count = aVar3.BTU.vd();
                    AppMethodBeat.o(22737);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.oog.add(dVar);
                    }
                    AppMethodBeat.o(22737);
                    return 0;
                default:
                    AppMethodBeat.o(22737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22737);
            return -1;
        }
    }
}
