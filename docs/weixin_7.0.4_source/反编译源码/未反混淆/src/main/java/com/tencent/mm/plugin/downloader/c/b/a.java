package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public String cIY;
    public p kKL;
    public p kKM;
    public String kKN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35525);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cIY != null) {
                aVar.e(1, this.cIY);
            }
            if (this.kKL != null) {
                aVar.iy(2, this.kKL.computeSize());
                this.kKL.writeFields(aVar);
            }
            if (this.kKM != null) {
                aVar.iy(3, this.kKM.computeSize());
                this.kKM.writeFields(aVar);
            }
            if (this.kKN != null) {
                aVar.e(4, this.kKN);
            }
            AppMethodBeat.o(35525);
            return 0;
        } else if (i == 1) {
            if (this.cIY != null) {
                f = e.a.a.b.b.a.f(1, this.cIY) + 0;
            } else {
                f = 0;
            }
            if (this.kKL != null) {
                f += e.a.a.a.ix(2, this.kKL.computeSize());
            }
            if (this.kKM != null) {
                f += e.a.a.a.ix(3, this.kKM.computeSize());
            }
            if (this.kKN != null) {
                f += e.a.a.b.b.a.f(4, this.kKN);
            }
            AppMethodBeat.o(35525);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35525);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            p pVar;
            e.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    aVar4.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(35525);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pVar = new p();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pVar.populateBuilderWithField(aVar5, pVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.kKL = pVar;
                    }
                    AppMethodBeat.o(35525);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pVar = new p();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pVar.populateBuilderWithField(aVar5, pVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.kKM = pVar;
                    }
                    AppMethodBeat.o(35525);
                    return 0;
                case 4:
                    aVar4.kKN = aVar3.BTU.readString();
                    AppMethodBeat.o(35525);
                    return 0;
                default:
                    AppMethodBeat.o(35525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35525);
            return -1;
        }
    }
}
