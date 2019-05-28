package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class i extends a {
    public String mZL;
    public String mZM;
    public int mZN;
    public a mZO;
    public db mZP;
    public int mZQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111549);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZM != null) {
                aVar.e(1, this.mZM);
            }
            aVar.iz(2, this.mZN);
            if (this.mZO != null) {
                aVar.iy(3, this.mZO.computeSize());
                this.mZO.writeFields(aVar);
            }
            if (this.mZP != null) {
                aVar.iy(4, this.mZP.computeSize());
                this.mZP.writeFields(aVar);
            }
            aVar.iz(5, this.mZQ);
            if (this.mZL != null) {
                aVar.e(6, this.mZL);
            }
            AppMethodBeat.o(111549);
            return 0;
        } else if (i == 1) {
            if (this.mZM != null) {
                f = e.a.a.b.b.a.f(1, this.mZM) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.mZN);
            if (this.mZO != null) {
                f += e.a.a.a.ix(3, this.mZO.computeSize());
            }
            if (this.mZP != null) {
                f += e.a.a.a.ix(4, this.mZP.computeSize());
            }
            f += e.a.a.b.b.a.bs(5, this.mZQ);
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(6, this.mZL);
            }
            AppMethodBeat.o(111549);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111549);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iVar.mZM = aVar3.BTU.readString();
                    AppMethodBeat.o(111549);
                    return 0;
                case 2:
                    iVar.mZN = aVar3.BTU.vd();
                    AppMethodBeat.o(111549);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.populateBuilderWithField(aVar4, aVar5, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.mZO = aVar5;
                    }
                    AppMethodBeat.o(111549);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        db dbVar = new db();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dbVar.populateBuilderWithField(aVar4, dbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.mZP = dbVar;
                    }
                    AppMethodBeat.o(111549);
                    return 0;
                case 5:
                    iVar.mZQ = aVar3.BTU.vd();
                    AppMethodBeat.o(111549);
                    return 0;
                case 6:
                    iVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111549);
                    return 0;
                default:
                    AppMethodBeat.o(111549);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111549);
            return -1;
        }
    }
}
