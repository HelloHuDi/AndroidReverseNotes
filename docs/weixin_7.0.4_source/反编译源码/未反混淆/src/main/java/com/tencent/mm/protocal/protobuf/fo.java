package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class fo extends a {
    public String cxb;
    public String geY;
    public bgc vHx;
    public LinkedList<bgc> vHy = new LinkedList();

    public fo() {
        AppMethodBeat.i(80020);
        AppMethodBeat.o(80020);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80021);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.geY != null) {
                aVar.e(1, this.geY);
            }
            if (this.vHx != null) {
                aVar.iy(2, this.vHx.computeSize());
                this.vHx.writeFields(aVar);
            }
            aVar.e(3, 8, this.vHy);
            if (this.cxb != null) {
                aVar.e(4, this.cxb);
            }
            AppMethodBeat.o(80021);
            return 0;
        } else if (i == 1) {
            if (this.geY != null) {
                f = e.a.a.b.b.a.f(1, this.geY) + 0;
            } else {
                f = 0;
            }
            if (this.vHx != null) {
                f += e.a.a.a.ix(2, this.vHx.computeSize());
            }
            f += e.a.a.a.c(3, 8, this.vHy);
            if (this.cxb != null) {
                f += e.a.a.b.b.a.f(4, this.cxb);
            }
            AppMethodBeat.o(80021);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vHy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80021);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fo foVar = (fo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bgc bgc;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    foVar.geY = aVar3.BTU.readString();
                    AppMethodBeat.o(80021);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgc = new bgc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgc.populateBuilderWithField(aVar4, bgc, a.getNextFieldNumber(aVar4))) {
                        }
                        foVar.vHx = bgc;
                    }
                    AppMethodBeat.o(80021);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgc = new bgc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgc.populateBuilderWithField(aVar4, bgc, a.getNextFieldNumber(aVar4))) {
                        }
                        foVar.vHy.add(bgc);
                    }
                    AppMethodBeat.o(80021);
                    return 0;
                case 4:
                    foVar.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(80021);
                    return 0;
                default:
                    AppMethodBeat.o(80021);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80021);
            return -1;
        }
    }
}
