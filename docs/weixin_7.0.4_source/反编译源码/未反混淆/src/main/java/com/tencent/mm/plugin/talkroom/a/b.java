package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> sxH = new LinkedList();

    public b() {
        AppMethodBeat.i(25752);
        AppMethodBeat.o(25752);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(25753);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.sxH);
            AppMethodBeat.o(25753);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.sxH) + 0;
            AppMethodBeat.o(25753);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sxH.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(25753);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar3 = new a();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar3.populateBuilderWithField(aVar4, aVar3, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.sxH.add(aVar3);
                    }
                    AppMethodBeat.o(25753);
                    return 0;
                default:
                    AppMethodBeat.o(25753);
                    return -1;
            }
        } else {
            AppMethodBeat.o(25753);
            return -1;
        }
    }
}
