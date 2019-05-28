package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ae extends a {
    public String Desc;
    public e mZk;
    public ag naM;
    public af naN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111568);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111568);
                throw bVar;
            }
            if (this.mZk != null) {
                aVar.iy(1, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            if (this.naM != null) {
                aVar.iy(2, this.naM.computeSize());
                this.naM.writeFields(aVar);
            }
            if (this.naN != null) {
                aVar.iy(3, this.naN.computeSize());
                this.naN.writeFields(aVar);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            AppMethodBeat.o(111568);
            return 0;
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = e.a.a.a.ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.naM != null) {
                ix += e.a.a.a.ix(2, this.naM.computeSize());
            }
            if (this.naN != null) {
                ix += e.a.a.a.ix(3, this.naN.computeSize());
            }
            if (this.Desc != null) {
                ix += e.a.a.b.b.a.f(4, this.Desc);
            }
            AppMethodBeat.o(111568);
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
                AppMethodBeat.o(111568);
                throw bVar;
            }
            AppMethodBeat.o(111568);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ae aeVar = (ae) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        aeVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111568);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ag agVar = new ag();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = agVar.populateBuilderWithField(aVar4, agVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aeVar.naM = agVar;
                    }
                    AppMethodBeat.o(111568);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        af afVar = new af();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = afVar.populateBuilderWithField(aVar4, afVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aeVar.naN = afVar;
                    }
                    AppMethodBeat.o(111568);
                    return 0;
                case 4:
                    aeVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111568);
                    return 0;
                default:
                    AppMethodBeat.o(111568);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111568);
            return -1;
        }
    }
}
