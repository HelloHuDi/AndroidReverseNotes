package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class np extends a {
    public String vSs;
    public String vSt;
    public String vSu;
    public int vSv;
    public ny vSw;
    public int vSx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89021);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSs != null) {
                aVar.e(1, this.vSs);
            }
            if (this.vSt != null) {
                aVar.e(2, this.vSt);
            }
            if (this.vSu != null) {
                aVar.e(3, this.vSu);
            }
            aVar.iz(4, this.vSv);
            if (this.vSw != null) {
                aVar.iy(5, this.vSw.computeSize());
                this.vSw.writeFields(aVar);
            }
            aVar.iz(6, this.vSx);
            AppMethodBeat.o(89021);
            return 0;
        } else if (i == 1) {
            if (this.vSs != null) {
                f = e.a.a.b.b.a.f(1, this.vSs) + 0;
            } else {
                f = 0;
            }
            if (this.vSt != null) {
                f += e.a.a.b.b.a.f(2, this.vSt);
            }
            if (this.vSu != null) {
                f += e.a.a.b.b.a.f(3, this.vSu);
            }
            f += e.a.a.b.b.a.bs(4, this.vSv);
            if (this.vSw != null) {
                f += e.a.a.a.ix(5, this.vSw.computeSize());
            }
            int bs = f + e.a.a.b.b.a.bs(6, this.vSx);
            AppMethodBeat.o(89021);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89021);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            np npVar = (np) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    npVar.vSs = aVar3.BTU.readString();
                    AppMethodBeat.o(89021);
                    return 0;
                case 2:
                    npVar.vSt = aVar3.BTU.readString();
                    AppMethodBeat.o(89021);
                    return 0;
                case 3:
                    npVar.vSu = aVar3.BTU.readString();
                    AppMethodBeat.o(89021);
                    return 0;
                case 4:
                    npVar.vSv = aVar3.BTU.vd();
                    AppMethodBeat.o(89021);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        npVar.vSw = nyVar;
                    }
                    AppMethodBeat.o(89021);
                    return 0;
                case 6:
                    npVar.vSx = aVar3.BTU.vd();
                    AppMethodBeat.o(89021);
                    return 0;
                default:
                    AppMethodBeat.o(89021);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89021);
            return -1;
        }
    }
}
