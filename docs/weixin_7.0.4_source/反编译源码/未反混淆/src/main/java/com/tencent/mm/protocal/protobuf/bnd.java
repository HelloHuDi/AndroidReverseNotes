package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bnd extends a {
    public String cMC;
    public int wPW;
    public boolean wPX;
    public String wPY;
    public int wPZ;
    public int wQa;
    public LinkedList<bnc> wQb = new LinkedList();

    public bnd() {
        AppMethodBeat.i(89124);
        AppMethodBeat.o(89124);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89125);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cMC != null) {
                aVar.e(1, this.cMC);
            }
            aVar.iz(2, this.wPW);
            aVar.aO(3, this.wPX);
            if (this.wPY != null) {
                aVar.e(4, this.wPY);
            }
            aVar.iz(5, this.wPZ);
            aVar.iz(6, this.wQa);
            aVar.e(7, 8, this.wQb);
            AppMethodBeat.o(89125);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = e.a.a.b.b.a.f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.wPW)) + (e.a.a.b.b.a.fv(3) + 1);
            if (this.wPY != null) {
                f += e.a.a.b.b.a.f(4, this.wPY);
            }
            int bs = ((f + e.a.a.b.b.a.bs(5, this.wPZ)) + e.a.a.b.b.a.bs(6, this.wQa)) + e.a.a.a.c(7, 8, this.wQb);
            AppMethodBeat.o(89125);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wQb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89125);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnd bnd = (bnd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bnd.cMC = aVar3.BTU.readString();
                    AppMethodBeat.o(89125);
                    return 0;
                case 2:
                    bnd.wPW = aVar3.BTU.vd();
                    AppMethodBeat.o(89125);
                    return 0;
                case 3:
                    bnd.wPX = aVar3.BTU.ehX();
                    AppMethodBeat.o(89125);
                    return 0;
                case 4:
                    bnd.wPY = aVar3.BTU.readString();
                    AppMethodBeat.o(89125);
                    return 0;
                case 5:
                    bnd.wPZ = aVar3.BTU.vd();
                    AppMethodBeat.o(89125);
                    return 0;
                case 6:
                    bnd.wQa = aVar3.BTU.vd();
                    AppMethodBeat.o(89125);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bnc bnc = new bnc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnc.populateBuilderWithField(aVar4, bnc, a.getNextFieldNumber(aVar4))) {
                        }
                        bnd.wQb.add(bnc);
                    }
                    AppMethodBeat.o(89125);
                    return 0;
                default:
                    AppMethodBeat.o(89125);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89125);
            return -1;
        }
    }
}
