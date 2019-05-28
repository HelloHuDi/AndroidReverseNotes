package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cue extends a {
    public LinkedList<cuc> wtc = new LinkedList();
    public boolean xqF;
    public boolean xqq;

    public cue() {
        AppMethodBeat.i(28742);
        AppMethodBeat.o(28742);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28743);
        int fv;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.xqq);
            aVar.e(2, 8, this.wtc);
            aVar.aO(3, this.xqF);
            AppMethodBeat.o(28743);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 1) + 0) + e.a.a.a.c(2, 8, this.wtc)) + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(28743);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28743);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cue cue = (cue) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cue.xqq = aVar3.BTU.ehX();
                    AppMethodBeat.o(28743);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cuc cuc = new cuc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cuc.populateBuilderWithField(aVar4, cuc, a.getNextFieldNumber(aVar4))) {
                        }
                        cue.wtc.add(cuc);
                    }
                    AppMethodBeat.o(28743);
                    return 0;
                case 3:
                    cue.xqF = aVar3.BTU.ehX();
                    AppMethodBeat.o(28743);
                    return 0;
                default:
                    AppMethodBeat.o(28743);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28743);
            return -1;
        }
    }
}
