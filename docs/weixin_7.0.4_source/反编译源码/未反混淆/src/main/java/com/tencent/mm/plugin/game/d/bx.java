package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bx extends a {
    public cg mZE;
    public String mZj;
    public String mZr;
    public String ncG;
    public String ncH;
    public String ncI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111631);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr != null) {
                aVar.e(1, this.mZr);
            }
            if (this.ncG != null) {
                aVar.e(2, this.ncG);
            }
            if (this.ncH != null) {
                aVar.e(3, this.ncH);
            }
            if (this.ncI != null) {
                aVar.e(4, this.ncI);
            }
            if (this.mZE != null) {
                aVar.iy(5, this.mZE.computeSize());
                this.mZE.writeFields(aVar);
            }
            if (this.mZj != null) {
                aVar.e(6, this.mZj);
            }
            AppMethodBeat.o(111631);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.ncG != null) {
                f += e.a.a.b.b.a.f(2, this.ncG);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(3, this.ncH);
            }
            if (this.ncI != null) {
                f += e.a.a.b.b.a.f(4, this.ncI);
            }
            if (this.mZE != null) {
                f += e.a.a.a.ix(5, this.mZE.computeSize());
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(6, this.mZj);
            }
            AppMethodBeat.o(111631);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111631);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bx bxVar = (bx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bxVar.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(111631);
                    return 0;
                case 2:
                    bxVar.ncG = aVar3.BTU.readString();
                    AppMethodBeat.o(111631);
                    return 0;
                case 3:
                    bxVar.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(111631);
                    return 0;
                case 4:
                    bxVar.ncI = aVar3.BTU.readString();
                    AppMethodBeat.o(111631);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cg cgVar = new cg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgVar.populateBuilderWithField(aVar4, cgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bxVar.mZE = cgVar;
                    }
                    AppMethodBeat.o(111631);
                    return 0;
                case 6:
                    bxVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111631);
                    return 0;
                default:
                    AppMethodBeat.o(111631);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111631);
            return -1;
        }
    }
}
