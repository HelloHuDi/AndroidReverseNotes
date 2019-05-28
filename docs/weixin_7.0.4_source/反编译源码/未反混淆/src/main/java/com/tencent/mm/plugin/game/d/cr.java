package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cr extends a {
    public e mZk;
    public String mZo;
    public boolean mZy;
    public LinkedList<String> mZz = new LinkedList();

    public cr() {
        AppMethodBeat.i(111656);
        AppMethodBeat.o(111656);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111657);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111657);
                throw bVar;
            }
            if (this.mZk != null) {
                aVar.iy(1, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            if (this.mZo != null) {
                aVar.e(2, this.mZo);
            }
            aVar.aO(3, this.mZy);
            aVar.e(4, 1, this.mZz);
            AppMethodBeat.o(111657);
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
            int fv = (ix + (e.a.a.b.b.a.fv(3) + 1)) + e.a.a.a.c(4, 1, this.mZz);
            AppMethodBeat.o(111657);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111657);
                throw bVar;
            }
            AppMethodBeat.o(111657);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cr crVar = (cr) objArr[1];
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
                        crVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111657);
                    return 0;
                case 2:
                    crVar.mZo = aVar3.BTU.readString();
                    AppMethodBeat.o(111657);
                    return 0;
                case 3:
                    crVar.mZy = aVar3.BTU.ehX();
                    AppMethodBeat.o(111657);
                    return 0;
                case 4:
                    crVar.mZz.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111657);
                    return 0;
                default:
                    AppMethodBeat.o(111657);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111657);
            return -1;
        }
    }
}
