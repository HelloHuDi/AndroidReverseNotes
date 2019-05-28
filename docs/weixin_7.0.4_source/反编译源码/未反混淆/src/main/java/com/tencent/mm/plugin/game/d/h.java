package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class h extends a {
    public LinkedList<aq> mZK = new LinkedList();
    public String mZL;

    public h() {
        AppMethodBeat.i(111547);
        AppMethodBeat.o(111547);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111548);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.mZK);
            if (this.mZL != null) {
                aVar.e(2, this.mZL);
            }
            AppMethodBeat.o(111548);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.mZK) + 0;
            if (this.mZL != null) {
                c += e.a.a.b.b.a.f(2, this.mZL);
            }
            AppMethodBeat.o(111548);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111548);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aq aqVar = new aq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aqVar.populateBuilderWithField(aVar4, aqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.mZK.add(aqVar);
                    }
                    AppMethodBeat.o(111548);
                    return 0;
                case 2:
                    hVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111548);
                    return 0;
                default:
                    AppMethodBeat.o(111548);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111548);
            return -1;
        }
    }
}
