package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public e mZk;
    public String mZl;
    public String mZm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111543);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZl == null) {
                bVar = new e.a.a.b("Not all required fields were included: AdURL");
                AppMethodBeat.o(111543);
                throw bVar;
            }
            if (this.mZk != null) {
                aVar.iy(1, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            if (this.mZl != null) {
                aVar.e(2, this.mZl);
            }
            if (this.mZm != null) {
                aVar.e(3, this.mZm);
            }
            AppMethodBeat.o(111543);
            return 0;
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = e.a.a.a.ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZl != null) {
                ix += e.a.a.b.b.a.f(2, this.mZl);
            }
            if (this.mZm != null) {
                ix += e.a.a.b.b.a.f(3, this.mZm);
            }
            AppMethodBeat.o(111543);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.mZl == null) {
                bVar = new e.a.a.b("Not all required fields were included: AdURL");
                AppMethodBeat.o(111543);
                throw bVar;
            }
            AppMethodBeat.o(111543);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar2 = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar2.mZk = eVar;
                    }
                    AppMethodBeat.o(111543);
                    return 0;
                case 2:
                    bVar2.mZl = aVar3.BTU.readString();
                    AppMethodBeat.o(111543);
                    return 0;
                case 3:
                    bVar2.mZm = aVar3.BTU.readString();
                    AppMethodBeat.o(111543);
                    return 0;
                default:
                    AppMethodBeat.o(111543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111543);
            return -1;
        }
    }
}
