package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class c extends a {
    public String detail;
    public String fjz;
    public String name;
    public String pcl;
    public LinkedList<d> phC = new LinkedList();
    public int phD;
    public int phE;
    public int phF;
    public LinkedList<String> phG = new LinkedList();
    public LinkedList<String> phH = new LinkedList();
    public LinkedList<b> phI = new LinkedList();
    public LinkedList<String> phJ = new LinkedList();
    public int phK;
    public int phL;
    public LinkedList<m> phM = new LinkedList();
    public LinkedList<a> phN = new LinkedList();
    public k phO;
    public int version;

    public c() {
        AppMethodBeat.i(56624);
        AppMethodBeat.o(56624);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56625);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.e(2, 8, this.phC);
            aVar.iz(3, this.phD);
            aVar.iz(4, this.phE);
            aVar.iz(5, this.phF);
            aVar.e(6, 1, this.phG);
            if (this.fjz != null) {
                aVar.e(7, this.fjz);
            }
            if (this.detail != null) {
                aVar.e(8, this.detail);
            }
            aVar.e(9, 1, this.phH);
            aVar.e(10, 8, this.phI);
            aVar.e(11, 1, this.phJ);
            aVar.iz(12, this.phK);
            aVar.iz(13, this.phL);
            aVar.e(14, 8, this.phM);
            aVar.iz(15, this.version);
            aVar.e(16, 8, this.phN);
            if (this.pcl != null) {
                aVar.e(17, this.pcl);
            }
            if (this.phO != null) {
                aVar.iy(18, this.phO.computeSize());
                this.phO.writeFields(aVar);
            }
            AppMethodBeat.o(56625);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = e.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                f = 0;
            }
            f = ((((f + e.a.a.a.c(2, 8, this.phC)) + e.a.a.b.b.a.bs(3, this.phD)) + e.a.a.b.b.a.bs(4, this.phE)) + e.a.a.b.b.a.bs(5, this.phF)) + e.a.a.a.c(6, 1, this.phG);
            if (this.fjz != null) {
                f += e.a.a.b.b.a.f(7, this.fjz);
            }
            if (this.detail != null) {
                f += e.a.a.b.b.a.f(8, this.detail);
            }
            f = (((((((f + e.a.a.a.c(9, 1, this.phH)) + e.a.a.a.c(10, 8, this.phI)) + e.a.a.a.c(11, 1, this.phJ)) + e.a.a.b.b.a.bs(12, this.phK)) + e.a.a.b.b.a.bs(13, this.phL)) + e.a.a.a.c(14, 8, this.phM)) + e.a.a.b.b.a.bs(15, this.version)) + e.a.a.a.c(16, 8, this.phN);
            if (this.pcl != null) {
                f += e.a.a.b.b.a.f(17, this.pcl);
            }
            if (this.phO != null) {
                f += e.a.a.a.ix(18, this.phO.computeSize());
            }
            AppMethodBeat.o(56625);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phC.clear();
            this.phG.clear();
            this.phH.clear();
            this.phI.clear();
            this.phJ.clear();
            this.phM.clear();
            this.phN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56625);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56625);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.phC.add(dVar);
                    }
                    AppMethodBeat.o(56625);
                    return 0;
                case 3:
                    cVar.phD = aVar3.BTU.vd();
                    AppMethodBeat.o(56625);
                    return 0;
                case 4:
                    cVar.phE = aVar3.BTU.vd();
                    AppMethodBeat.o(56625);
                    return 0;
                case 5:
                    cVar.phF = aVar3.BTU.vd();
                    AppMethodBeat.o(56625);
                    return 0;
                case 6:
                    cVar.phG.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56625);
                    return 0;
                case 7:
                    cVar.fjz = aVar3.BTU.readString();
                    AppMethodBeat.o(56625);
                    return 0;
                case 8:
                    cVar.detail = aVar3.BTU.readString();
                    AppMethodBeat.o(56625);
                    return 0;
                case 9:
                    cVar.phH.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56625);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.phI.add(bVar);
                    }
                    AppMethodBeat.o(56625);
                    return 0;
                case 11:
                    cVar.phJ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56625);
                    return 0;
                case 12:
                    cVar.phK = aVar3.BTU.vd();
                    AppMethodBeat.o(56625);
                    return 0;
                case 13:
                    cVar.phL = aVar3.BTU.vd();
                    AppMethodBeat.o(56625);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.phM.add(mVar);
                    }
                    AppMethodBeat.o(56625);
                    return 0;
                case 15:
                    cVar.version = aVar3.BTU.vd();
                    AppMethodBeat.o(56625);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.populateBuilderWithField(aVar4, aVar5, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.phN.add(aVar5);
                    }
                    AppMethodBeat.o(56625);
                    return 0;
                case 17:
                    cVar.pcl = aVar3.BTU.readString();
                    AppMethodBeat.o(56625);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        k kVar = new k();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.phO = kVar;
                    }
                    AppMethodBeat.o(56625);
                    return 0;
                default:
                    AppMethodBeat.o(56625);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56625);
            return -1;
        }
    }
}
