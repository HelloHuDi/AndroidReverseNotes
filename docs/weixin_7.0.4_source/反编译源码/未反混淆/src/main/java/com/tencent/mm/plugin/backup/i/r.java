package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String ID;
    public long jBS;
    public int jBV;
    public int jBW;
    public int jBX;
    public long jBY;
    public long jBZ;
    public LinkedList<t> jCk = new LinkedList();
    public LinkedList<t> jCl = new LinkedList();

    public r() {
        AppMethodBeat.i(18065);
        AppMethodBeat.o(18065);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18066);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18066);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.iz(2, this.jBV);
            aVar.iz(3, this.jBW);
            aVar.iz(4, this.jBX);
            aVar.ai(5, this.jBS);
            aVar.ai(6, this.jBY);
            aVar.ai(7, this.jBZ);
            aVar.e(8, 8, this.jCk);
            aVar.e(9, 8, this.jCl);
            AppMethodBeat.o(18066);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                f = e.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                f = 0;
            }
            int bs = (((((((f + e.a.a.b.b.a.bs(2, this.jBV)) + e.a.a.b.b.a.bs(3, this.jBW)) + e.a.a.b.b.a.bs(4, this.jBX)) + e.a.a.b.b.a.o(5, this.jBS)) + e.a.a.b.b.a.o(6, this.jBY)) + e.a.a.b.b.a.o(7, this.jBZ)) + e.a.a.a.c(8, 8, this.jCk)) + e.a.a.a.c(9, 8, this.jCl);
            AppMethodBeat.o(18066);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jCk.clear();
            this.jCl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18066);
                throw bVar;
            }
            AppMethodBeat.o(18066);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            t tVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18066);
                    return 0;
                case 2:
                    rVar.jBV = aVar3.BTU.vd();
                    AppMethodBeat.o(18066);
                    return 0;
                case 3:
                    rVar.jBW = aVar3.BTU.vd();
                    AppMethodBeat.o(18066);
                    return 0;
                case 4:
                    rVar.jBX = aVar3.BTU.vd();
                    AppMethodBeat.o(18066);
                    return 0;
                case 5:
                    rVar.jBS = aVar3.BTU.ve();
                    AppMethodBeat.o(18066);
                    return 0;
                case 6:
                    rVar.jBY = aVar3.BTU.ve();
                    AppMethodBeat.o(18066);
                    return 0;
                case 7:
                    rVar.jBZ = aVar3.BTU.ve();
                    AppMethodBeat.o(18066);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, a.getNextFieldNumber(aVar4))) {
                        }
                        rVar.jCk.add(tVar);
                    }
                    AppMethodBeat.o(18066);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, a.getNextFieldNumber(aVar4))) {
                        }
                        rVar.jCl.add(tVar);
                    }
                    AppMethodBeat.o(18066);
                    return 0;
                default:
                    AppMethodBeat.o(18066);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18066);
            return -1;
        }
    }
}
