package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class le extends a {
    public String vOF;
    public int vOG;
    public String vOH;
    public int vOI;
    public LinkedList<jw> vOJ = new LinkedList();

    public le() {
        AppMethodBeat.i(80029);
        AppMethodBeat.o(80029);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80030);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOF != null) {
                aVar.e(1, this.vOF);
            }
            aVar.iz(2, this.vOG);
            if (this.vOH != null) {
                aVar.e(3, this.vOH);
            }
            aVar.iz(4, this.vOI);
            aVar.e(5, 8, this.vOJ);
            AppMethodBeat.o(80030);
            return 0;
        } else if (i == 1) {
            if (this.vOF != null) {
                f = e.a.a.b.b.a.f(1, this.vOF) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vOG);
            if (this.vOH != null) {
                f += e.a.a.b.b.a.f(3, this.vOH);
            }
            int bs = (f + e.a.a.b.b.a.bs(4, this.vOI)) + e.a.a.a.c(5, 8, this.vOJ);
            AppMethodBeat.o(80030);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vOJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80030);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            le leVar = (le) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    leVar.vOF = aVar3.BTU.readString();
                    AppMethodBeat.o(80030);
                    return 0;
                case 2:
                    leVar.vOG = aVar3.BTU.vd();
                    AppMethodBeat.o(80030);
                    return 0;
                case 3:
                    leVar.vOH = aVar3.BTU.readString();
                    AppMethodBeat.o(80030);
                    return 0;
                case 4:
                    leVar.vOI = aVar3.BTU.vd();
                    AppMethodBeat.o(80030);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        jw jwVar = new jw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jwVar.populateBuilderWithField(aVar4, jwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        leVar.vOJ.add(jwVar);
                    }
                    AppMethodBeat.o(80030);
                    return 0;
                default:
                    AppMethodBeat.o(80030);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80030);
            return -1;
        }
    }
}
