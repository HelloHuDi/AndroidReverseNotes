package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bih extends a {
    public String vCb;
    public String wLA;
    public int wLB;
    public LinkedList<np> wLC = new LinkedList();
    public String wLD;
    public String wLE;
    public String wLy;
    public String wLz;

    public bih() {
        AppMethodBeat.i(89114);
        AppMethodBeat.o(89114);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89115);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCb != null) {
                aVar.e(1, this.vCb);
            }
            if (this.wLy != null) {
                aVar.e(2, this.wLy);
            }
            if (this.wLz != null) {
                aVar.e(3, this.wLz);
            }
            if (this.wLA != null) {
                aVar.e(4, this.wLA);
            }
            aVar.iz(5, this.wLB);
            aVar.e(6, 8, this.wLC);
            if (this.wLD != null) {
                aVar.e(7, this.wLD);
            }
            if (this.wLE != null) {
                aVar.e(8, this.wLE);
            }
            AppMethodBeat.o(89115);
            return 0;
        } else if (i == 1) {
            if (this.vCb != null) {
                f = e.a.a.b.b.a.f(1, this.vCb) + 0;
            } else {
                f = 0;
            }
            if (this.wLy != null) {
                f += e.a.a.b.b.a.f(2, this.wLy);
            }
            if (this.wLz != null) {
                f += e.a.a.b.b.a.f(3, this.wLz);
            }
            if (this.wLA != null) {
                f += e.a.a.b.b.a.f(4, this.wLA);
            }
            f = (f + e.a.a.b.b.a.bs(5, this.wLB)) + e.a.a.a.c(6, 8, this.wLC);
            if (this.wLD != null) {
                f += e.a.a.b.b.a.f(7, this.wLD);
            }
            if (this.wLE != null) {
                f += e.a.a.b.b.a.f(8, this.wLE);
            }
            AppMethodBeat.o(89115);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89115);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bih bih = (bih) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bih.vCb = aVar3.BTU.readString();
                    AppMethodBeat.o(89115);
                    return 0;
                case 2:
                    bih.wLy = aVar3.BTU.readString();
                    AppMethodBeat.o(89115);
                    return 0;
                case 3:
                    bih.wLz = aVar3.BTU.readString();
                    AppMethodBeat.o(89115);
                    return 0;
                case 4:
                    bih.wLA = aVar3.BTU.readString();
                    AppMethodBeat.o(89115);
                    return 0;
                case 5:
                    bih.wLB = aVar3.BTU.vd();
                    AppMethodBeat.o(89115);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        np npVar = new np();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = npVar.populateBuilderWithField(aVar4, npVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bih.wLC.add(npVar);
                    }
                    AppMethodBeat.o(89115);
                    return 0;
                case 7:
                    bih.wLD = aVar3.BTU.readString();
                    AppMethodBeat.o(89115);
                    return 0;
                case 8:
                    bih.wLE = aVar3.BTU.readString();
                    AppMethodBeat.o(89115);
                    return 0;
                default:
                    AppMethodBeat.o(89115);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89115);
            return -1;
        }
    }
}
