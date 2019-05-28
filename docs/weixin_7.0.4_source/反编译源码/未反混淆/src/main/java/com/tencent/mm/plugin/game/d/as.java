package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class as extends a {
    public String Title;
    public LinkedList<y> mZK = new LinkedList();
    public String naP;
    public String nbi;

    public as() {
        AppMethodBeat.i(111587);
        AppMethodBeat.o(111587);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111588);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.mZK);
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.naP != null) {
                aVar.e(3, this.naP);
            }
            if (this.nbi != null) {
                aVar.e(4, this.nbi);
            }
            AppMethodBeat.o(111588);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.mZK) + 0;
            if (this.Title != null) {
                c += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.naP != null) {
                c += e.a.a.b.b.a.f(3, this.naP);
            }
            if (this.nbi != null) {
                c += e.a.a.b.b.a.f(4, this.nbi);
            }
            AppMethodBeat.o(111588);
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
            AppMethodBeat.o(111588);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        y yVar = new y();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = yVar.populateBuilderWithField(aVar4, yVar, a.getNextFieldNumber(aVar4))) {
                        }
                        asVar.mZK.add(yVar);
                    }
                    AppMethodBeat.o(111588);
                    return 0;
                case 2:
                    asVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111588);
                    return 0;
                case 3:
                    asVar.naP = aVar3.BTU.readString();
                    AppMethodBeat.o(111588);
                    return 0;
                case 4:
                    asVar.nbi = aVar3.BTU.readString();
                    AppMethodBeat.o(111588);
                    return 0;
                default:
                    AppMethodBeat.o(111588);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111588);
            return -1;
        }
    }
}
