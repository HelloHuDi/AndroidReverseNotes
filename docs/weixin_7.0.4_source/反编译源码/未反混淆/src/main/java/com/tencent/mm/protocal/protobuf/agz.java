package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class agz extends a {
    public String wno;
    public ph wnu;
    public String wnv;
    public boolean wnw;
    public int wnx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89091);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wnu != null) {
                aVar.iy(1, this.wnu.computeSize());
                this.wnu.writeFields(aVar);
            }
            if (this.wno != null) {
                aVar.e(2, this.wno);
            }
            if (this.wnv != null) {
                aVar.e(3, this.wnv);
            }
            aVar.aO(4, this.wnw);
            aVar.iz(5, this.wnx);
            AppMethodBeat.o(89091);
            return 0;
        } else if (i == 1) {
            if (this.wnu != null) {
                ix = e.a.a.a.ix(1, this.wnu.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wno != null) {
                ix += e.a.a.b.b.a.f(2, this.wno);
            }
            if (this.wnv != null) {
                ix += e.a.a.b.b.a.f(3, this.wnv);
            }
            int fv = (ix + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.b.b.a.bs(5, this.wnx);
            AppMethodBeat.o(89091);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89091);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agz agz = (agz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ph phVar = new ph();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = phVar.populateBuilderWithField(aVar4, phVar, a.getNextFieldNumber(aVar4))) {
                        }
                        agz.wnu = phVar;
                    }
                    AppMethodBeat.o(89091);
                    return 0;
                case 2:
                    agz.wno = aVar3.BTU.readString();
                    AppMethodBeat.o(89091);
                    return 0;
                case 3:
                    agz.wnv = aVar3.BTU.readString();
                    AppMethodBeat.o(89091);
                    return 0;
                case 4:
                    agz.wnw = aVar3.BTU.ehX();
                    AppMethodBeat.o(89091);
                    return 0;
                case 5:
                    agz.wnx = aVar3.BTU.vd();
                    AppMethodBeat.o(89091);
                    return 0;
                default:
                    AppMethodBeat.o(89091);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89091);
            return -1;
        }
    }
}
