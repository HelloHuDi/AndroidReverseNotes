package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class csj extends a {
    public String xpI;
    public nb xpJ;
    public boolean xpK;
    public String xpL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56999);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpI != null) {
                aVar.e(1, this.xpI);
            }
            if (this.xpJ != null) {
                aVar.iy(2, this.xpJ.computeSize());
                this.xpJ.writeFields(aVar);
            }
            aVar.aO(3, this.xpK);
            if (this.xpL != null) {
                aVar.e(4, this.xpL);
            }
            AppMethodBeat.o(56999);
            return 0;
        } else if (i == 1) {
            if (this.xpI != null) {
                f = e.a.a.b.b.a.f(1, this.xpI) + 0;
            } else {
                f = 0;
            }
            if (this.xpJ != null) {
                f += e.a.a.a.ix(2, this.xpJ.computeSize());
            }
            f += e.a.a.b.b.a.fv(3) + 1;
            if (this.xpL != null) {
                f += e.a.a.b.b.a.f(4, this.xpL);
            }
            AppMethodBeat.o(56999);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56999);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csj csj = (csj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csj.xpI = aVar3.BTU.readString();
                    AppMethodBeat.o(56999);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        nb nbVar = new nb();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nbVar.populateBuilderWithField(aVar4, nbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        csj.xpJ = nbVar;
                    }
                    AppMethodBeat.o(56999);
                    return 0;
                case 3:
                    csj.xpK = aVar3.BTU.ehX();
                    AppMethodBeat.o(56999);
                    return 0;
                case 4:
                    csj.xpL = aVar3.BTU.readString();
                    AppMethodBeat.o(56999);
                    return 0;
                default:
                    AppMethodBeat.o(56999);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56999);
            return -1;
        }
    }
}
