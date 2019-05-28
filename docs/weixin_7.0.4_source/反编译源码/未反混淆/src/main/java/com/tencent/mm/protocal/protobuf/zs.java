package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class zs extends a {
    public String Name;
    public long lhy;
    public int wfb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73703);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.lhy);
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            aVar.iz(3, this.wfb);
            AppMethodBeat.o(73703);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.lhy) + 0;
            if (this.Name != null) {
                o += e.a.a.b.b.a.f(2, this.Name);
            }
            o += e.a.a.b.b.a.bs(3, this.wfb);
            AppMethodBeat.o(73703);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73703);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zs zsVar = (zs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zsVar.lhy = aVar3.BTU.ve();
                    AppMethodBeat.o(73703);
                    return 0;
                case 2:
                    zsVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(73703);
                    return 0;
                case 3:
                    zsVar.wfb = aVar3.BTU.vd();
                    AppMethodBeat.o(73703);
                    return 0;
                default:
                    AppMethodBeat.o(73703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73703);
            return -1;
        }
    }
}
