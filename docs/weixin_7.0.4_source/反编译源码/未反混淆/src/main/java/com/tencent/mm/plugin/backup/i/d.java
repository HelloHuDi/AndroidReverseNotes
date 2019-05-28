package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String ID;
    public h jBj;
    public int jBk;
    public int jBl;
    public int jBm;
    public int jBn;
    public int jBo;
    public int jBp;
    public int jBq;
    public int jBr;
    public int jBs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18047);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18047);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            if (this.jBj != null) {
                aVar.iy(2, this.jBj.computeSize());
                this.jBj.writeFields(aVar);
            }
            aVar.iz(3, this.jBk);
            aVar.iz(4, this.jBl);
            aVar.iz(5, this.jBm);
            aVar.iz(6, this.jBn);
            aVar.iz(7, this.jBo);
            aVar.iz(8, this.jBp);
            aVar.iz(9, this.jBq);
            aVar.iz(10, this.jBr);
            aVar.iz(11, this.jBs);
            AppMethodBeat.o(18047);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                f = e.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                f = 0;
            }
            if (this.jBj != null) {
                f += e.a.a.a.ix(2, this.jBj.computeSize());
            }
            int bs = ((((((((f + e.a.a.b.b.a.bs(3, this.jBk)) + e.a.a.b.b.a.bs(4, this.jBl)) + e.a.a.b.b.a.bs(5, this.jBm)) + e.a.a.b.b.a.bs(6, this.jBn)) + e.a.a.b.b.a.bs(7, this.jBo)) + e.a.a.b.b.a.bs(8, this.jBp)) + e.a.a.b.b.a.bs(9, this.jBq)) + e.a.a.b.b.a.bs(10, this.jBr)) + e.a.a.b.b.a.bs(11, this.jBs);
            AppMethodBeat.o(18047);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18047);
                throw bVar;
            }
            AppMethodBeat.o(18047);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18047);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        h hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.jBj = hVar;
                    }
                    AppMethodBeat.o(18047);
                    return 0;
                case 3:
                    dVar.jBk = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 4:
                    dVar.jBl = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 5:
                    dVar.jBm = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 6:
                    dVar.jBn = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 7:
                    dVar.jBo = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 8:
                    dVar.jBp = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 9:
                    dVar.jBq = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 10:
                    dVar.jBr = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                case 11:
                    dVar.jBs = aVar3.BTU.vd();
                    AppMethodBeat.o(18047);
                    return 0;
                default:
                    AppMethodBeat.o(18047);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18047);
            return -1;
        }
    }
}
