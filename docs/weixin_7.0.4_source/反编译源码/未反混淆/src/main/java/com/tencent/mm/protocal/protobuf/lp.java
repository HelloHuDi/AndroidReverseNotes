package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class lp extends a {
    public LinkedList<abw> vPg = new LinkedList();
    public LinkedList<abv> vPh = new LinkedList();
    public String vPi;
    public String vPj;
    public String vPk;

    public lp() {
        AppMethodBeat.i(56718);
        AppMethodBeat.o(56718);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56719);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vPg);
            aVar.e(2, 8, this.vPh);
            if (this.vPi != null) {
                aVar.e(3, this.vPi);
            }
            if (this.vPj != null) {
                aVar.e(4, this.vPj);
            }
            if (this.vPk != null) {
                aVar.e(5, this.vPk);
            }
            AppMethodBeat.o(56719);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.vPg) + 0) + e.a.a.a.c(2, 8, this.vPh);
            if (this.vPi != null) {
                c += e.a.a.b.b.a.f(3, this.vPi);
            }
            if (this.vPj != null) {
                c += e.a.a.b.b.a.f(4, this.vPj);
            }
            if (this.vPk != null) {
                c += e.a.a.b.b.a.f(5, this.vPk);
            }
            AppMethodBeat.o(56719);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPg.clear();
            this.vPh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56719);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lp lpVar = (lp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abw abw = new abw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abw.populateBuilderWithField(aVar4, abw, a.getNextFieldNumber(aVar4))) {
                        }
                        lpVar.vPg.add(abw);
                    }
                    AppMethodBeat.o(56719);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abv abv = new abv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abv.populateBuilderWithField(aVar4, abv, a.getNextFieldNumber(aVar4))) {
                        }
                        lpVar.vPh.add(abv);
                    }
                    AppMethodBeat.o(56719);
                    return 0;
                case 3:
                    lpVar.vPi = aVar3.BTU.readString();
                    AppMethodBeat.o(56719);
                    return 0;
                case 4:
                    lpVar.vPj = aVar3.BTU.readString();
                    AppMethodBeat.o(56719);
                    return 0;
                case 5:
                    lpVar.vPk = aVar3.BTU.readString();
                    AppMethodBeat.o(56719);
                    return 0;
                default:
                    AppMethodBeat.o(56719);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56719);
            return -1;
        }
    }
}
