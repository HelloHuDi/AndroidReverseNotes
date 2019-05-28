package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cci extends a {
    public String cvF;
    public long xbJ = 0;
    public long xbK = 0;
    public long xbL = 0;
    public LinkedList<caz> xbM = new LinkedList();

    public cci() {
        AppMethodBeat.i(73657);
        AppMethodBeat.o(73657);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73658);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cvF != null) {
                aVar.e(1, this.cvF);
            }
            aVar.ai(2, this.xbJ);
            aVar.ai(3, this.xbK);
            aVar.ai(4, this.xbL);
            aVar.e(5, 8, this.xbM);
            AppMethodBeat.o(73658);
            return 0;
        } else if (i == 1) {
            if (this.cvF != null) {
                f = e.a.a.b.b.a.f(1, this.cvF) + 0;
            } else {
                f = 0;
            }
            int o = (((f + e.a.a.b.b.a.o(2, this.xbJ)) + e.a.a.b.b.a.o(3, this.xbK)) + e.a.a.b.b.a.o(4, this.xbL)) + e.a.a.a.c(5, 8, this.xbM);
            AppMethodBeat.o(73658);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73658);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cci cci = (cci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cci.cvF = aVar3.BTU.readString();
                    AppMethodBeat.o(73658);
                    return 0;
                case 2:
                    cci.xbJ = aVar3.BTU.ve();
                    AppMethodBeat.o(73658);
                    return 0;
                case 3:
                    cci.xbK = aVar3.BTU.ve();
                    AppMethodBeat.o(73658);
                    return 0;
                case 4:
                    cci.xbL = aVar3.BTU.ve();
                    AppMethodBeat.o(73658);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caz caz = new caz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = caz.populateBuilderWithField(aVar4, caz, a.getNextFieldNumber(aVar4))) {
                        }
                        cci.xbM.add(caz);
                    }
                    AppMethodBeat.o(73658);
                    return 0;
                default:
                    AppMethodBeat.o(73658);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73658);
            return -1;
        }
    }
}
