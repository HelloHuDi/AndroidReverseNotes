package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class d extends a {
    public int cKB;
    public LinkedList<e> fLY = new LinkedList();
    public int fLZ;
    public int fMa;
    public int fMb;
    public String fMc;
    public String fMd;
    public int fMe;
    public int fMf;
    public int fMg;
    public int maxSize;
    public String name;

    public d() {
        AppMethodBeat.i(78440);
        AppMethodBeat.o(78440);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(78441);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.fLY);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.iz(3, this.fLZ);
            aVar.iz(4, this.cKB);
            aVar.iz(5, this.fMa);
            aVar.iz(6, this.fMb);
            if (this.fMc != null) {
                aVar.e(7, this.fMc);
            }
            if (this.fMd != null) {
                aVar.e(8, this.fMd);
            }
            aVar.iz(9, this.fMe);
            aVar.iz(10, this.fMf);
            aVar.iz(11, this.fMg);
            aVar.iz(12, this.maxSize);
            AppMethodBeat.o(78441);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.fLY) + 0;
            if (this.name != null) {
                c += e.a.a.b.b.a.f(2, this.name);
            }
            c = (((c + e.a.a.b.b.a.bs(3, this.fLZ)) + e.a.a.b.b.a.bs(4, this.cKB)) + e.a.a.b.b.a.bs(5, this.fMa)) + e.a.a.b.b.a.bs(6, this.fMb);
            if (this.fMc != null) {
                c += e.a.a.b.b.a.f(7, this.fMc);
            }
            if (this.fMd != null) {
                c += e.a.a.b.b.a.f(8, this.fMd);
            }
            c = (((c + e.a.a.b.b.a.bs(9, this.fMe)) + e.a.a.b.b.a.bs(10, this.fMf)) + e.a.a.b.b.a.bs(11, this.fMg)) + e.a.a.b.b.a.bs(12, this.maxSize);
            AppMethodBeat.o(78441);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fLY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(78441);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.fLY.add(eVar);
                    }
                    AppMethodBeat.o(78441);
                    return 0;
                case 2:
                    dVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(78441);
                    return 0;
                case 3:
                    dVar.fLZ = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 4:
                    dVar.cKB = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 5:
                    dVar.fMa = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 6:
                    dVar.fMb = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 7:
                    dVar.fMc = aVar3.BTU.readString();
                    AppMethodBeat.o(78441);
                    return 0;
                case 8:
                    dVar.fMd = aVar3.BTU.readString();
                    AppMethodBeat.o(78441);
                    return 0;
                case 9:
                    dVar.fMe = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 10:
                    dVar.fMf = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 11:
                    dVar.fMg = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                case 12:
                    dVar.maxSize = aVar3.BTU.vd();
                    AppMethodBeat.o(78441);
                    return 0;
                default:
                    AppMethodBeat.o(78441);
                    return -1;
            }
        } else {
            AppMethodBeat.o(78441);
            return -1;
        }
    }
}
