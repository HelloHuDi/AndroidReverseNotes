package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ah extends a {
    public String mZL;
    public String mZM;
    public LinkedList<cx> naO = new LinkedList();
    public String naP;
    public String naQ;

    public ah() {
        AppMethodBeat.i(111573);
        AppMethodBeat.o(111573);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111574);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZM != null) {
                aVar.e(1, this.mZM);
            }
            aVar.e(2, 8, this.naO);
            if (this.naP != null) {
                aVar.e(3, this.naP);
            }
            if (this.naQ != null) {
                aVar.e(4, this.naQ);
            }
            if (this.mZL != null) {
                aVar.e(5, this.mZL);
            }
            AppMethodBeat.o(111574);
            return 0;
        } else if (i == 1) {
            if (this.mZM != null) {
                f = e.a.a.b.b.a.f(1, this.mZM) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 8, this.naO);
            if (this.naP != null) {
                f += e.a.a.b.b.a.f(3, this.naP);
            }
            if (this.naQ != null) {
                f += e.a.a.b.b.a.f(4, this.naQ);
            }
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(5, this.mZL);
            }
            AppMethodBeat.o(111574);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.naO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111574);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ah ahVar = (ah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahVar.mZM = aVar3.BTU.readString();
                    AppMethodBeat.o(111574);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cx cxVar = new cx();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxVar.populateBuilderWithField(aVar4, cxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ahVar.naO.add(cxVar);
                    }
                    AppMethodBeat.o(111574);
                    return 0;
                case 3:
                    ahVar.naP = aVar3.BTU.readString();
                    AppMethodBeat.o(111574);
                    return 0;
                case 4:
                    ahVar.naQ = aVar3.BTU.readString();
                    AppMethodBeat.o(111574);
                    return 0;
                case 5:
                    ahVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111574);
                    return 0;
                default:
                    AppMethodBeat.o(111574);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111574);
            return -1;
        }
    }
}
