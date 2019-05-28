package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class kh extends a {
    public kk vNe;
    public String vNf;
    public String vNg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11705);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNe != null) {
                aVar.iy(1, this.vNe.computeSize());
                this.vNe.writeFields(aVar);
            }
            if (this.vNf != null) {
                aVar.e(2, this.vNf);
            }
            if (this.vNg != null) {
                aVar.e(3, this.vNg);
            }
            AppMethodBeat.o(11705);
            return 0;
        } else if (i == 1) {
            if (this.vNe != null) {
                ix = e.a.a.a.ix(1, this.vNe.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vNf != null) {
                ix += e.a.a.b.b.a.f(2, this.vNf);
            }
            if (this.vNg != null) {
                ix += e.a.a.b.b.a.f(3, this.vNg);
            }
            AppMethodBeat.o(11705);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11705);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kh khVar = (kh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        kk kkVar = new kk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = kkVar.populateBuilderWithField(aVar4, kkVar, a.getNextFieldNumber(aVar4))) {
                        }
                        khVar.vNe = kkVar;
                    }
                    AppMethodBeat.o(11705);
                    return 0;
                case 2:
                    khVar.vNf = aVar3.BTU.readString();
                    AppMethodBeat.o(11705);
                    return 0;
                case 3:
                    khVar.vNg = aVar3.BTU.readString();
                    AppMethodBeat.o(11705);
                    return 0;
                default:
                    AppMethodBeat.o(11705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11705);
            return -1;
        }
    }
}
