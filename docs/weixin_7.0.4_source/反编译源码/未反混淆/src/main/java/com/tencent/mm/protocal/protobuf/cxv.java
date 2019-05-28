package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxv extends a {
    public String Md5;
    public int vMG;
    public cxp xsZ;
    public String xtn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115022);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xsZ != null) {
                aVar.iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(aVar);
            }
            if (this.xtn != null) {
                aVar.e(2, this.xtn);
            }
            aVar.iz(3, this.vMG);
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            AppMethodBeat.o(115022);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = e.a.a.a.ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xtn != null) {
                ix += e.a.a.b.b.a.f(2, this.xtn);
            }
            ix += e.a.a.b.b.a.bs(3, this.vMG);
            if (this.Md5 != null) {
                ix += e.a.a.b.b.a.f(4, this.Md5);
            }
            AppMethodBeat.o(115022);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115022);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxv cxv = (cxv) objArr[1];
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
                        cxv.xsZ = cxp;
                    }
                    AppMethodBeat.o(115022);
                    return 0;
                case 2:
                    cxv.xtn = aVar3.BTU.readString();
                    AppMethodBeat.o(115022);
                    return 0;
                case 3:
                    cxv.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(115022);
                    return 0;
                case 4:
                    cxv.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(115022);
                    return 0;
                default:
                    AppMethodBeat.o(115022);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115022);
            return -1;
        }
    }
}
