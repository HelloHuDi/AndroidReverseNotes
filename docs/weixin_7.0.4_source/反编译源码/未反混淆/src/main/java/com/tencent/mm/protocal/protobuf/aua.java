package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aua extends a {
    public String eCq;
    public int major;
    public LinkedList<auc> wxZ = new LinkedList();

    public aua() {
        AppMethodBeat.i(10192);
        AppMethodBeat.o(10192);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10193);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.eCq != null) {
                aVar.e(1, this.eCq);
            }
            aVar.iz(2, this.major);
            aVar.e(3, 8, this.wxZ);
            AppMethodBeat.o(10193);
            return 0;
        } else if (i == 1) {
            if (this.eCq != null) {
                f = e.a.a.b.b.a.f(1, this.eCq) + 0;
            } else {
                f = 0;
            }
            int bs = (f + e.a.a.b.b.a.bs(2, this.major)) + e.a.a.a.c(3, 8, this.wxZ);
            AppMethodBeat.o(10193);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10193);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aua aua = (aua) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aua.eCq = aVar3.BTU.readString();
                    AppMethodBeat.o(10193);
                    return 0;
                case 2:
                    aua.major = aVar3.BTU.vd();
                    AppMethodBeat.o(10193);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auc auc = new auc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = auc.populateBuilderWithField(aVar4, auc, a.getNextFieldNumber(aVar4))) {
                        }
                        aua.wxZ.add(auc);
                    }
                    AppMethodBeat.o(10193);
                    return 0;
                default:
                    AppMethodBeat.o(10193);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10193);
            return -1;
        }
    }
}
