package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class c extends a {
    public int jCt;
    public e mZk;
    public b mZn;
    public String mZo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111544);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            if (this.mZk != null) {
                aVar.iy(2, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            if (this.mZn != null) {
                aVar.iy(3, this.mZn.computeSize());
                this.mZn.writeFields(aVar);
            }
            if (this.mZo != null) {
                aVar.e(4, this.mZo);
            }
            AppMethodBeat.o(111544);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCt) + 0;
            if (this.mZk != null) {
                bs += e.a.a.a.ix(2, this.mZk.computeSize());
            }
            if (this.mZn != null) {
                bs += e.a.a.a.ix(3, this.mZn.computeSize());
            }
            if (this.mZo != null) {
                bs += e.a.a.b.b.a.f(4, this.mZo);
            }
            AppMethodBeat.o(111544);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111544);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(111544);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111544);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.mZn = bVar;
                    }
                    AppMethodBeat.o(111544);
                    return 0;
                case 4:
                    cVar.mZo = aVar3.BTU.readString();
                    AppMethodBeat.o(111544);
                    return 0;
                default:
                    AppMethodBeat.o(111544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111544);
            return -1;
        }
    }
}
