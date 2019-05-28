package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nt extends a {
    public String vTj;
    public int vTk;
    public String vTl;
    public ny vTm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89027);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTj != null) {
                aVar.e(1, this.vTj);
            }
            aVar.iz(2, this.vTk);
            if (this.vTl != null) {
                aVar.e(3, this.vTl);
            }
            if (this.vTm != null) {
                aVar.iy(4, this.vTm.computeSize());
                this.vTm.writeFields(aVar);
            }
            AppMethodBeat.o(89027);
            return 0;
        } else if (i == 1) {
            if (this.vTj != null) {
                f = e.a.a.b.b.a.f(1, this.vTj) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vTk);
            if (this.vTl != null) {
                f += e.a.a.b.b.a.f(3, this.vTl);
            }
            if (this.vTm != null) {
                f += e.a.a.a.ix(4, this.vTm.computeSize());
            }
            AppMethodBeat.o(89027);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89027);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nt ntVar = (nt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ntVar.vTj = aVar3.BTU.readString();
                    AppMethodBeat.o(89027);
                    return 0;
                case 2:
                    ntVar.vTk = aVar3.BTU.vd();
                    AppMethodBeat.o(89027);
                    return 0;
                case 3:
                    ntVar.vTl = aVar3.BTU.readString();
                    AppMethodBeat.o(89027);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ntVar.vTm = nyVar;
                    }
                    AppMethodBeat.o(89027);
                    return 0;
                default:
                    AppMethodBeat.o(89027);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89027);
            return -1;
        }
    }
}
