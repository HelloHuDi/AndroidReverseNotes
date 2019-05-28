package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class y extends a {
    public String Desc;
    public e mZk;
    public LinkedList<String> nar = new LinkedList();
    public String nas;

    public y() {
        AppMethodBeat.i(111562);
        AppMethodBeat.o(111562);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111563);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZk != null) {
                aVar.iy(1, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            aVar.e(2, 1, this.nar);
            if (this.nas != null) {
                aVar.e(3, this.nas);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            AppMethodBeat.o(111563);
            return 0;
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = e.a.a.a.ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 1, this.nar);
            if (this.nas != null) {
                ix += e.a.a.b.b.a.f(3, this.nas);
            }
            if (this.Desc != null) {
                ix += e.a.a.b.b.a.f(4, this.Desc);
            }
            AppMethodBeat.o(111563);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nar.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111563);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        yVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111563);
                    return 0;
                case 2:
                    yVar.nar.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111563);
                    return 0;
                case 3:
                    yVar.nas = aVar3.BTU.readString();
                    AppMethodBeat.o(111563);
                    return 0;
                case 4:
                    yVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111563);
                    return 0;
                default:
                    AppMethodBeat.o(111563);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111563);
            return -1;
        }
    }
}
