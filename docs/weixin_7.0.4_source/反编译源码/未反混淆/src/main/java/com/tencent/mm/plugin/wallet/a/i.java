package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<j> tni = new LinkedList();
    public b tnj;

    public i() {
        AppMethodBeat.i(56651);
        AppMethodBeat.o(56651);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56652);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.tni);
            if (this.tnj != null) {
                aVar.c(2, this.tnj);
            }
            AppMethodBeat.o(56652);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.tni) + 0;
            if (this.tnj != null) {
                c += e.a.a.b.b.a.b(2, this.tnj);
            }
            AppMethodBeat.o(56652);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tni.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56652);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        j jVar = new j();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jVar.populateBuilderWithField(aVar4, jVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.tni.add(jVar);
                    }
                    AppMethodBeat.o(56652);
                    return 0;
                case 2:
                    iVar.tnj = aVar3.BTU.emu();
                    AppMethodBeat.o(56652);
                    return 0;
                default:
                    AppMethodBeat.o(56652);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56652);
            return -1;
        }
    }
}
