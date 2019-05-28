package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cy extends a {
    public String Title;
    public LinkedList<an> mZK = new LinkedList();
    public String naP;
    public String nbi;

    public cy() {
        AppMethodBeat.i(111665);
        AppMethodBeat.o(111665);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111666);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.mZK);
            if (this.naP != null) {
                aVar.e(3, this.naP);
            }
            if (this.nbi != null) {
                aVar.e(4, this.nbi);
            }
            AppMethodBeat.o(111666);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 8, this.mZK);
            if (this.naP != null) {
                f += e.a.a.b.b.a.f(3, this.naP);
            }
            if (this.nbi != null) {
                f += e.a.a.b.b.a.f(4, this.nbi);
            }
            AppMethodBeat.o(111666);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111666);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cy cyVar = (cy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111666);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        an anVar = new an();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = anVar.populateBuilderWithField(aVar4, anVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cyVar.mZK.add(anVar);
                    }
                    AppMethodBeat.o(111666);
                    return 0;
                case 3:
                    cyVar.naP = aVar3.BTU.readString();
                    AppMethodBeat.o(111666);
                    return 0;
                case 4:
                    cyVar.nbi = aVar3.BTU.readString();
                    AppMethodBeat.o(111666);
                    return 0;
                default:
                    AppMethodBeat.o(111666);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111666);
            return -1;
        }
    }
}
