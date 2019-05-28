package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cel extends a {
    public String cvZ;
    public int eRu;
    public String ptv;
    public int wFD;
    public long wFi;
    public int wFm;
    public int xei;
    public cej xej;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56528);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ptv != null) {
                aVar.e(1, this.ptv);
            }
            aVar.iz(2, this.eRu);
            aVar.ai(3, this.wFi);
            aVar.iz(4, this.wFm);
            if (this.cvZ != null) {
                aVar.e(5, this.cvZ);
            }
            aVar.iz(6, this.wFD);
            aVar.iz(7, this.xei);
            if (this.xej != null) {
                aVar.iy(8, this.xej.computeSize());
                this.xej.writeFields(aVar);
            }
            AppMethodBeat.o(56528);
            return 0;
        } else if (i == 1) {
            if (this.ptv != null) {
                f = e.a.a.b.b.a.f(1, this.ptv) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.b.b.a.bs(2, this.eRu)) + e.a.a.b.b.a.o(3, this.wFi)) + e.a.a.b.b.a.bs(4, this.wFm);
            if (this.cvZ != null) {
                f += e.a.a.b.b.a.f(5, this.cvZ);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.wFD)) + e.a.a.b.b.a.bs(7, this.xei);
            if (this.xej != null) {
                f += e.a.a.a.ix(8, this.xej.computeSize());
            }
            AppMethodBeat.o(56528);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56528);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cel cel = (cel) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cel.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(56528);
                    return 0;
                case 2:
                    cel.eRu = aVar3.BTU.vd();
                    AppMethodBeat.o(56528);
                    return 0;
                case 3:
                    cel.wFi = aVar3.BTU.ve();
                    AppMethodBeat.o(56528);
                    return 0;
                case 4:
                    cel.wFm = aVar3.BTU.vd();
                    AppMethodBeat.o(56528);
                    return 0;
                case 5:
                    cel.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56528);
                    return 0;
                case 6:
                    cel.wFD = aVar3.BTU.vd();
                    AppMethodBeat.o(56528);
                    return 0;
                case 7:
                    cel.xei = aVar3.BTU.vd();
                    AppMethodBeat.o(56528);
                    return 0;
                case 8:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cej cej = new cej();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cej.populateBuilderWithField(aVar4, cej, a.getNextFieldNumber(aVar4))) {
                        }
                        cel.xej = cej;
                    }
                    AppMethodBeat.o(56528);
                    return 0;
                default:
                    AppMethodBeat.o(56528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56528);
            return -1;
        }
    }
}
