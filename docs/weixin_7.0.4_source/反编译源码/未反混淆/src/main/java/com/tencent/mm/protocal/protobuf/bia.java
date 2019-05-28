package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bia extends a {
    public String pdA;
    public int state;
    public LinkedList<bhz> wLj = new LinkedList();
    public int wLk;
    public int wLl;
    public bsz wLm;
    public int wLn;
    public LinkedList<bhy> wLo = new LinkedList();
    public boolean wLp;
    public LinkedList<bsz> wLq = new LinkedList();

    public bia() {
        AppMethodBeat.i(90704);
        AppMethodBeat.o(90704);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(90705);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pdA == null) {
                bVar = new b("Not all required fields were included: pid");
                AppMethodBeat.o(90705);
                throw bVar;
            }
            if (this.pdA != null) {
                aVar.e(1, this.pdA);
            }
            aVar.iz(2, this.state);
            aVar.e(3, 8, this.wLj);
            aVar.iz(4, this.wLk);
            aVar.iz(5, this.wLl);
            if (this.wLm != null) {
                aVar.iy(6, this.wLm.computeSize());
                this.wLm.writeFields(aVar);
            }
            aVar.iz(7, this.wLn);
            aVar.e(8, 8, this.wLo);
            aVar.aO(9, this.wLp);
            aVar.e(10, 8, this.wLq);
            AppMethodBeat.o(90705);
            return 0;
        } else if (i == 1) {
            if (this.pdA != null) {
                f = e.a.a.b.b.a.f(1, this.pdA) + 0;
            } else {
                f = 0;
            }
            f = (((f + e.a.a.b.b.a.bs(2, this.state)) + e.a.a.a.c(3, 8, this.wLj)) + e.a.a.b.b.a.bs(4, this.wLk)) + e.a.a.b.b.a.bs(5, this.wLl);
            if (this.wLm != null) {
                f += e.a.a.a.ix(6, this.wLm.computeSize());
            }
            int bs = (((f + e.a.a.b.b.a.bs(7, this.wLn)) + e.a.a.a.c(8, 8, this.wLo)) + (e.a.a.b.b.a.fv(9) + 1)) + e.a.a.a.c(10, 8, this.wLq);
            AppMethodBeat.o(90705);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLj.clear();
            this.wLo.clear();
            this.wLq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.pdA == null) {
                bVar = new b("Not all required fields were included: pid");
                AppMethodBeat.o(90705);
                throw bVar;
            }
            AppMethodBeat.o(90705);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bia bia = (bia) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bsz bsz;
            switch (intValue) {
                case 1:
                    bia.pdA = aVar3.BTU.readString();
                    AppMethodBeat.o(90705);
                    return 0;
                case 2:
                    bia.state = aVar3.BTU.vd();
                    AppMethodBeat.o(90705);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.populateBuilderWithField(aVar4, bhz, a.getNextFieldNumber(aVar4))) {
                        }
                        bia.wLj.add(bhz);
                    }
                    AppMethodBeat.o(90705);
                    return 0;
                case 4:
                    bia.wLk = aVar3.BTU.vd();
                    AppMethodBeat.o(90705);
                    return 0;
                case 5:
                    bia.wLl = aVar3.BTU.vd();
                    AppMethodBeat.o(90705);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsz = new bsz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.populateBuilderWithField(aVar4, bsz, a.getNextFieldNumber(aVar4))) {
                        }
                        bia.wLm = bsz;
                    }
                    AppMethodBeat.o(90705);
                    return 0;
                case 7:
                    bia.wLn = aVar3.BTU.vd();
                    AppMethodBeat.o(90705);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.populateBuilderWithField(aVar4, bhy, a.getNextFieldNumber(aVar4))) {
                        }
                        bia.wLo.add(bhy);
                    }
                    AppMethodBeat.o(90705);
                    return 0;
                case 9:
                    bia.wLp = aVar3.BTU.ehX();
                    AppMethodBeat.o(90705);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsz = new bsz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.populateBuilderWithField(aVar4, bsz, a.getNextFieldNumber(aVar4))) {
                        }
                        bia.wLq.add(bsz);
                    }
                    AppMethodBeat.o(90705);
                    return 0;
                default:
                    AppMethodBeat.o(90705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90705);
            return -1;
        }
    }
}
