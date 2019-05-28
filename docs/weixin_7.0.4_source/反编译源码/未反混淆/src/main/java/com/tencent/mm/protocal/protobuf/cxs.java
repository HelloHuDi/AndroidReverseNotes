package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxs extends a {
    public String Md5;
    public int vMG;
    public int wUZ;
    public int wVb;
    public cxp xsZ;
    public int xtk;
    public boolean xtl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115019);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xsZ != null) {
                aVar.iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(aVar);
            }
            aVar.iz(2, this.xtk);
            aVar.iz(3, this.wUZ);
            aVar.iz(4, this.wVb);
            aVar.aO(5, this.xtl);
            aVar.iz(6, this.vMG);
            if (this.Md5 != null) {
                aVar.e(7, this.Md5);
            }
            AppMethodBeat.o(115019);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = e.a.a.a.ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.xtk)) + e.a.a.b.b.a.bs(3, this.wUZ)) + e.a.a.b.b.a.bs(4, this.wVb)) + (e.a.a.b.b.a.fv(5) + 1)) + e.a.a.b.b.a.bs(6, this.vMG);
            if (this.Md5 != null) {
                ix += e.a.a.b.b.a.f(7, this.Md5);
            }
            AppMethodBeat.o(115019);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115019);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxs cxs = (cxs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cxp cxp = new cxp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxp.populateBuilderWithField(aVar4, cxp, a.getNextFieldNumber(aVar4))) {
                        }
                        cxs.xsZ = cxp;
                    }
                    AppMethodBeat.o(115019);
                    return 0;
                case 2:
                    cxs.xtk = aVar3.BTU.vd();
                    AppMethodBeat.o(115019);
                    return 0;
                case 3:
                    cxs.wUZ = aVar3.BTU.vd();
                    AppMethodBeat.o(115019);
                    return 0;
                case 4:
                    cxs.wVb = aVar3.BTU.vd();
                    AppMethodBeat.o(115019);
                    return 0;
                case 5:
                    cxs.xtl = aVar3.BTU.ehX();
                    AppMethodBeat.o(115019);
                    return 0;
                case 6:
                    cxs.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(115019);
                    return 0;
                case 7:
                    cxs.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(115019);
                    return 0;
                default:
                    AppMethodBeat.o(115019);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115019);
            return -1;
        }
    }
}
