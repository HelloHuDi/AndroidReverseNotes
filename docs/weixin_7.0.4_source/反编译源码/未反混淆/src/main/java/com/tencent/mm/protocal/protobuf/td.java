package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class td extends a {
    public String wav;
    public String waw;
    public LinkedList<bbg> wax = new LinkedList();

    public td() {
        AppMethodBeat.i(2538);
        AppMethodBeat.o(2538);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2539);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wav != null) {
                aVar.e(1, this.wav);
            }
            if (this.waw != null) {
                aVar.e(2, this.waw);
            }
            aVar.e(3, 8, this.wax);
            AppMethodBeat.o(2539);
            return 0;
        } else if (i == 1) {
            if (this.wav != null) {
                f = e.a.a.b.b.a.f(1, this.wav) + 0;
            } else {
                f = 0;
            }
            if (this.waw != null) {
                f += e.a.a.b.b.a.f(2, this.waw);
            }
            int c = f + e.a.a.a.c(3, 8, this.wax);
            AppMethodBeat.o(2539);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wax.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2539);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            td tdVar = (td) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tdVar.wav = aVar3.BTU.readString();
                    AppMethodBeat.o(2539);
                    return 0;
                case 2:
                    tdVar.waw = aVar3.BTU.readString();
                    AppMethodBeat.o(2539);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbg bbg = new bbg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bbg.populateBuilderWithField(aVar4, bbg, a.getNextFieldNumber(aVar4))) {
                        }
                        tdVar.wax.add(bbg);
                    }
                    AppMethodBeat.o(2539);
                    return 0;
                default:
                    AppMethodBeat.o(2539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2539);
            return -1;
        }
    }
}
