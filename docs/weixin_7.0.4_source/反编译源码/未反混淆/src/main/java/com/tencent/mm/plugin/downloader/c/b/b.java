package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public String egm;
    public String kKO;
    public long kKP;
    public String kKQ;
    public int kKR;
    public int kKS;
    public String kKT;
    public n kKU;
    public String kKV;
    public String kKW;
    public boolean kKX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35526);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.egm != null) {
                aVar.e(1, this.egm);
            }
            if (this.kKO != null) {
                aVar.e(2, this.kKO);
            }
            aVar.ai(3, this.kKP);
            if (this.kKQ != null) {
                aVar.e(4, this.kKQ);
            }
            aVar.iz(6, this.kKR);
            aVar.iz(7, this.kKS);
            if (this.kKT != null) {
                aVar.e(8, this.kKT);
            }
            if (this.kKU != null) {
                aVar.iy(9, this.kKU.computeSize());
                this.kKU.writeFields(aVar);
            }
            if (this.kKV != null) {
                aVar.e(10, this.kKV);
            }
            if (this.kKW != null) {
                aVar.e(11, this.kKW);
            }
            aVar.aO(12, this.kKX);
            AppMethodBeat.o(35526);
            return 0;
        } else if (i == 1) {
            if (this.egm != null) {
                f = e.a.a.b.b.a.f(1, this.egm) + 0;
            } else {
                f = 0;
            }
            if (this.kKO != null) {
                f += e.a.a.b.b.a.f(2, this.kKO);
            }
            f += e.a.a.b.b.a.o(3, this.kKP);
            if (this.kKQ != null) {
                f += e.a.a.b.b.a.f(4, this.kKQ);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.kKR)) + e.a.a.b.b.a.bs(7, this.kKS);
            if (this.kKT != null) {
                f += e.a.a.b.b.a.f(8, this.kKT);
            }
            if (this.kKU != null) {
                f += e.a.a.a.ix(9, this.kKU.computeSize());
            }
            if (this.kKV != null) {
                f += e.a.a.b.b.a.f(10, this.kKV);
            }
            if (this.kKW != null) {
                f += e.a.a.b.b.a.f(11, this.kKW);
            }
            int fv = f + (e.a.a.b.b.a.fv(12) + 1);
            AppMethodBeat.o(35526);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35526);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.egm = aVar3.BTU.readString();
                    AppMethodBeat.o(35526);
                    return 0;
                case 2:
                    bVar.kKO = aVar3.BTU.readString();
                    AppMethodBeat.o(35526);
                    return 0;
                case 3:
                    bVar.kKP = aVar3.BTU.ve();
                    AppMethodBeat.o(35526);
                    return 0;
                case 4:
                    bVar.kKQ = aVar3.BTU.readString();
                    AppMethodBeat.o(35526);
                    return 0;
                case 6:
                    bVar.kKR = aVar3.BTU.vd();
                    AppMethodBeat.o(35526);
                    return 0;
                case 7:
                    bVar.kKS = aVar3.BTU.vd();
                    AppMethodBeat.o(35526);
                    return 0;
                case 8:
                    bVar.kKT = aVar3.BTU.readString();
                    AppMethodBeat.o(35526);
                    return 0;
                case 9:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        n nVar = new n();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.kKU = nVar;
                    }
                    AppMethodBeat.o(35526);
                    return 0;
                case 10:
                    bVar.kKV = aVar3.BTU.readString();
                    AppMethodBeat.o(35526);
                    return 0;
                case 11:
                    bVar.kKW = aVar3.BTU.readString();
                    AppMethodBeat.o(35526);
                    return 0;
                case 12:
                    bVar.kKX = aVar3.BTU.ehX();
                    AppMethodBeat.o(35526);
                    return 0;
                default:
                    AppMethodBeat.o(35526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35526);
            return -1;
        }
    }
}
