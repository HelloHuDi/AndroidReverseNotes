package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public m tmC;
    public int tmD;
    public String tmE;
    public String tmF;
    public String tmG;
    public String tmH;
    public String tmI;
    public String tmJ;
    public String tmK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56642);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tmC != null) {
                aVar.iy(1, this.tmC.computeSize());
                this.tmC.writeFields(aVar);
            }
            aVar.iz(2, this.tmD);
            if (this.tmE != null) {
                aVar.e(3, this.tmE);
            }
            if (this.tmF != null) {
                aVar.e(4, this.tmF);
            }
            if (this.tmG != null) {
                aVar.e(5, this.tmG);
            }
            if (this.tmH != null) {
                aVar.e(6, this.tmH);
            }
            if (this.tmI != null) {
                aVar.e(7, this.tmI);
            }
            if (this.tmJ != null) {
                aVar.e(8, this.tmJ);
            }
            if (this.tmK != null) {
                aVar.e(9, this.tmK);
            }
            AppMethodBeat.o(56642);
            return 0;
        } else if (i == 1) {
            if (this.tmC != null) {
                ix = e.a.a.a.ix(1, this.tmC.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.tmD);
            if (this.tmE != null) {
                ix += e.a.a.b.b.a.f(3, this.tmE);
            }
            if (this.tmF != null) {
                ix += e.a.a.b.b.a.f(4, this.tmF);
            }
            if (this.tmG != null) {
                ix += e.a.a.b.b.a.f(5, this.tmG);
            }
            if (this.tmH != null) {
                ix += e.a.a.b.b.a.f(6, this.tmH);
            }
            if (this.tmI != null) {
                ix += e.a.a.b.b.a.f(7, this.tmI);
            }
            if (this.tmJ != null) {
                ix += e.a.a.b.b.a.f(8, this.tmJ);
            }
            if (this.tmK != null) {
                ix += e.a.a.b.b.a.f(9, this.tmK);
            }
            AppMethodBeat.o(56642);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56642);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.tmC = mVar;
                    }
                    AppMethodBeat.o(56642);
                    return 0;
                case 2:
                    bVar.tmD = aVar3.BTU.vd();
                    AppMethodBeat.o(56642);
                    return 0;
                case 3:
                    bVar.tmE = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                case 4:
                    bVar.tmF = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                case 5:
                    bVar.tmG = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                case 6:
                    bVar.tmH = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                case 7:
                    bVar.tmI = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                case 8:
                    bVar.tmJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                case 9:
                    bVar.tmK = aVar3.BTU.readString();
                    AppMethodBeat.o(56642);
                    return 0;
                default:
                    AppMethodBeat.o(56642);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56642);
            return -1;
        }
    }
}
