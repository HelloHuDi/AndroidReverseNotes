package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aq extends a {
    public String mZL;
    public e mZk;
    public String mZo;
    public LinkedList<ar> nbg = new LinkedList();

    public aq() {
        AppMethodBeat.i(111583);
        AppMethodBeat.o(111583);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111584);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111584);
                throw bVar;
            }
            if (this.mZk != null) {
                aVar.iy(1, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            if (this.mZo != null) {
                aVar.e(2, this.mZo);
            }
            aVar.e(3, 8, this.nbg);
            if (this.mZL != null) {
                aVar.e(4, this.mZL);
            }
            AppMethodBeat.o(111584);
            return 0;
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = e.a.a.a.ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZo != null) {
                ix += e.a.a.b.b.a.f(2, this.mZo);
            }
            ix += e.a.a.a.c(3, 8, this.nbg);
            if (this.mZL != null) {
                ix += e.a.a.b.b.a.f(4, this.mZL);
            }
            AppMethodBeat.o(111584);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111584);
                throw bVar;
            }
            AppMethodBeat.o(111584);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aq aqVar = (aq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aqVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111584);
                    return 0;
                case 2:
                    aqVar.mZo = aVar3.BTU.readString();
                    AppMethodBeat.o(111584);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ar arVar = new ar();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.populateBuilderWithField(aVar4, arVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aqVar.nbg.add(arVar);
                    }
                    AppMethodBeat.o(111584);
                    return 0;
                case 4:
                    aqVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111584);
                    return 0;
                default:
                    AppMethodBeat.o(111584);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111584);
            return -1;
        }
    }
}
