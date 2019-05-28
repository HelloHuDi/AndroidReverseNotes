package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class am extends a {
    public String Title;
    public String mZL;
    public String nbb;
    public LinkedList<ct> nbc = new LinkedList();
    public dr nbd;

    public am() {
        AppMethodBeat.i(111578);
        AppMethodBeat.o(111578);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111579);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nbb != null) {
                aVar.e(1, this.nbb);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            aVar.e(3, 8, this.nbc);
            if (this.nbd != null) {
                aVar.iy(4, this.nbd.computeSize());
                this.nbd.writeFields(aVar);
            }
            if (this.mZL != null) {
                aVar.e(5, this.mZL);
            }
            AppMethodBeat.o(111579);
            return 0;
        } else if (i == 1) {
            if (this.nbb != null) {
                f = e.a.a.b.b.a.f(1, this.nbb) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            f += e.a.a.a.c(3, 8, this.nbc);
            if (this.nbd != null) {
                f += e.a.a.a.ix(4, this.nbd.computeSize());
            }
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(5, this.mZL);
            }
            AppMethodBeat.o(111579);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111579);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    amVar.nbb = aVar3.BTU.readString();
                    AppMethodBeat.o(111579);
                    return 0;
                case 2:
                    amVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111579);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ct ctVar = new ct();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ctVar.populateBuilderWithField(aVar4, ctVar, a.getNextFieldNumber(aVar4))) {
                        }
                        amVar.nbc.add(ctVar);
                    }
                    AppMethodBeat.o(111579);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dr drVar = new dr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = drVar.populateBuilderWithField(aVar4, drVar, a.getNextFieldNumber(aVar4))) {
                        }
                        amVar.nbd = drVar;
                    }
                    AppMethodBeat.o(111579);
                    return 0;
                case 5:
                    amVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111579);
                    return 0;
                default:
                    AppMethodBeat.o(111579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111579);
            return -1;
        }
    }
}
