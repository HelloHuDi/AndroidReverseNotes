package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public int bJt;
    public int cGj;
    public int ehD;
    public LinkedList<b> eow = new LinkedList();
    public String eox;
    public int eoy;
    public int status;
    public int type;

    public a() {
        AppMethodBeat.i(59614);
        AppMethodBeat.o(59614);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(59615);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.eow);
            aVar.iz(2, this.bJt);
            aVar.iz(3, this.type);
            aVar.iz(4, this.status);
            aVar.iz(5, this.ehD);
            if (this.eox != null) {
                aVar.e(6, this.eox);
            }
            aVar.iz(7, this.cGj);
            aVar.iz(8, this.eoy);
            AppMethodBeat.o(59615);
            return 0;
        } else if (i == 1) {
            c = ((((e.a.a.a.c(1, 8, this.eow) + 0) + e.a.a.b.b.a.bs(2, this.bJt)) + e.a.a.b.b.a.bs(3, this.type)) + e.a.a.b.b.a.bs(4, this.status)) + e.a.a.b.b.a.bs(5, this.ehD);
            if (this.eox != null) {
                c += e.a.a.b.b.a.f(6, this.eox);
            }
            c = (c + e.a.a.b.b.a.bs(7, this.cGj)) + e.a.a.b.b.a.bs(8, this.eoy);
            AppMethodBeat.o(59615);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.eow.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); c > 0; c = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(59615);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar5, bVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.eow.add(bVar);
                    }
                    AppMethodBeat.o(59615);
                    return 0;
                case 2:
                    aVar4.bJt = aVar3.BTU.vd();
                    AppMethodBeat.o(59615);
                    return 0;
                case 3:
                    aVar4.type = aVar3.BTU.vd();
                    AppMethodBeat.o(59615);
                    return 0;
                case 4:
                    aVar4.status = aVar3.BTU.vd();
                    AppMethodBeat.o(59615);
                    return 0;
                case 5:
                    aVar4.ehD = aVar3.BTU.vd();
                    AppMethodBeat.o(59615);
                    return 0;
                case 6:
                    aVar4.eox = aVar3.BTU.readString();
                    AppMethodBeat.o(59615);
                    return 0;
                case 7:
                    aVar4.cGj = aVar3.BTU.vd();
                    AppMethodBeat.o(59615);
                    return 0;
                case 8:
                    aVar4.eoy = aVar3.BTU.vd();
                    AppMethodBeat.o(59615);
                    return 0;
                default:
                    AppMethodBeat.o(59615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(59615);
            return -1;
        }
    }
}
