package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bii extends a {
    public String wLF;
    public String wLG;
    public String wLH;
    public int wLI;
    public String wLJ;
    public ny wLK;
    public String wLL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89116);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wLF != null) {
                aVar.e(1, this.wLF);
            }
            if (this.wLG != null) {
                aVar.e(2, this.wLG);
            }
            if (this.wLH != null) {
                aVar.e(3, this.wLH);
            }
            aVar.iz(4, this.wLI);
            if (this.wLJ != null) {
                aVar.e(5, this.wLJ);
            }
            if (this.wLK != null) {
                aVar.iy(6, this.wLK.computeSize());
                this.wLK.writeFields(aVar);
            }
            if (this.wLL != null) {
                aVar.e(7, this.wLL);
            }
            AppMethodBeat.o(89116);
            return 0;
        } else if (i == 1) {
            if (this.wLF != null) {
                f = e.a.a.b.b.a.f(1, this.wLF) + 0;
            } else {
                f = 0;
            }
            if (this.wLG != null) {
                f += e.a.a.b.b.a.f(2, this.wLG);
            }
            if (this.wLH != null) {
                f += e.a.a.b.b.a.f(3, this.wLH);
            }
            f += e.a.a.b.b.a.bs(4, this.wLI);
            if (this.wLJ != null) {
                f += e.a.a.b.b.a.f(5, this.wLJ);
            }
            if (this.wLK != null) {
                f += e.a.a.a.ix(6, this.wLK.computeSize());
            }
            if (this.wLL != null) {
                f += e.a.a.b.b.a.f(7, this.wLL);
            }
            AppMethodBeat.o(89116);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89116);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bii bii = (bii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bii.wLF = aVar3.BTU.readString();
                    AppMethodBeat.o(89116);
                    return 0;
                case 2:
                    bii.wLG = aVar3.BTU.readString();
                    AppMethodBeat.o(89116);
                    return 0;
                case 3:
                    bii.wLH = aVar3.BTU.readString();
                    AppMethodBeat.o(89116);
                    return 0;
                case 4:
                    bii.wLI = aVar3.BTU.vd();
                    AppMethodBeat.o(89116);
                    return 0;
                case 5:
                    bii.wLJ = aVar3.BTU.readString();
                    AppMethodBeat.o(89116);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bii.wLK = nyVar;
                    }
                    AppMethodBeat.o(89116);
                    return 0;
                case 7:
                    bii.wLL = aVar3.BTU.readString();
                    AppMethodBeat.o(89116);
                    return 0;
                default:
                    AppMethodBeat.o(89116);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89116);
            return -1;
        }
    }
}
