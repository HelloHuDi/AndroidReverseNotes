package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class asj extends a {
    public String cIY;
    public int iAd;
    public String kdf;
    public String kfM;
    public asi wpr;
    public boolean wvW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48864);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kdf != null) {
                aVar.e(1, this.kdf);
            }
            if (this.kfM != null) {
                aVar.e(2, this.kfM);
            }
            if (this.cIY != null) {
                aVar.e(3, this.cIY);
            }
            aVar.aO(4, this.wvW);
            aVar.iz(5, this.iAd);
            if (this.wpr != null) {
                aVar.iy(6, this.wpr.computeSize());
                this.wpr.writeFields(aVar);
            }
            AppMethodBeat.o(48864);
            return 0;
        } else if (i == 1) {
            if (this.kdf != null) {
                f = e.a.a.b.b.a.f(1, this.kdf) + 0;
            } else {
                f = 0;
            }
            if (this.kfM != null) {
                f += e.a.a.b.b.a.f(2, this.kfM);
            }
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(3, this.cIY);
            }
            f = (f + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.b.b.a.bs(5, this.iAd);
            if (this.wpr != null) {
                f += e.a.a.a.ix(6, this.wpr.computeSize());
            }
            AppMethodBeat.o(48864);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48864);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asj asj = (asj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asj.kdf = aVar3.BTU.readString();
                    AppMethodBeat.o(48864);
                    return 0;
                case 2:
                    asj.kfM = aVar3.BTU.readString();
                    AppMethodBeat.o(48864);
                    return 0;
                case 3:
                    asj.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(48864);
                    return 0;
                case 4:
                    asj.wvW = aVar3.BTU.ehX();
                    AppMethodBeat.o(48864);
                    return 0;
                case 5:
                    asj.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(48864);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        asi asi = new asi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = asi.populateBuilderWithField(aVar4, asi, a.getNextFieldNumber(aVar4))) {
                        }
                        asj.wpr = asi;
                    }
                    AppMethodBeat.o(48864);
                    return 0;
                default:
                    AppMethodBeat.o(48864);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48864);
            return -1;
        }
    }
}
