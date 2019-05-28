package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aaz;
import java.util.LinkedList;

public final class c extends a {
    public String desc;
    public LinkedList<aar> fjr = new LinkedList();
    public long lgR;
    public String title;
    public String vzJ;
    public aaz vzK;

    public c() {
        AppMethodBeat.i(111120);
        AppMethodBeat.o(111120);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111121);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.e(3, 8, this.fjr);
            if (this.vzJ != null) {
                aVar.e(4, this.vzJ);
            }
            if (this.vzK != null) {
                aVar.iy(5, this.vzK.computeSize());
                this.vzK.writeFields(aVar);
            }
            aVar.ai(6, this.lgR);
            AppMethodBeat.o(111121);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            f += e.a.a.a.c(3, 8, this.fjr);
            if (this.vzJ != null) {
                f += e.a.a.b.b.a.f(4, this.vzJ);
            }
            if (this.vzK != null) {
                f += e.a.a.a.ix(5, this.vzK.computeSize());
            }
            int o = f + e.a.a.b.b.a.o(6, this.lgR);
            AppMethodBeat.o(111121);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111121);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(111121);
                    return 0;
                case 2:
                    cVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111121);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aar aar = new aar();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aar.populateBuilderWithField(aVar4, aar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.fjr.add(aar);
                    }
                    AppMethodBeat.o(111121);
                    return 0;
                case 4:
                    cVar.vzJ = aVar3.BTU.readString();
                    AppMethodBeat.o(111121);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aaz aaz = new aaz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaz.populateBuilderWithField(aVar4, aaz, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.vzK = aaz;
                    }
                    AppMethodBeat.o(111121);
                    return 0;
                case 6:
                    cVar.lgR = aVar3.BTU.ve();
                    AppMethodBeat.o(111121);
                    return 0;
                default:
                    AppMethodBeat.o(111121);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111121);
            return -1;
        }
    }
}
