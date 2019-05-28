package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cd extends a {
    public e mZk;
    public String ncR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111639);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111639);
                throw bVar;
            } else if (this.ncR == null) {
                bVar = new b("Not all required fields were included: Rank");
                AppMethodBeat.o(111639);
                throw bVar;
            } else {
                if (this.mZk != null) {
                    aVar.iy(1, this.mZk.computeSize());
                    this.mZk.writeFields(aVar);
                }
                if (this.ncR != null) {
                    aVar.e(2, this.ncR);
                }
                AppMethodBeat.o(111639);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = e.a.a.a.ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncR != null) {
                ix += e.a.a.b.b.a.f(2, this.ncR);
            }
            AppMethodBeat.o(111639);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111639);
                throw bVar;
            } else if (this.ncR == null) {
                bVar = new b("Not all required fields were included: Rank");
                AppMethodBeat.o(111639);
                throw bVar;
            } else {
                AppMethodBeat.o(111639);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
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
                        cdVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111639);
                    return 0;
                case 2:
                    cdVar.ncR = aVar3.BTU.readString();
                    AppMethodBeat.o(111639);
                    return 0;
                default:
                    AppMethodBeat.o(111639);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111639);
            return -1;
        }
    }
}
