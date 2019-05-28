package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class m extends a {
    public String phX;
    public String phY;
    public LinkedList<h> phZ = new LinkedList();

    public m() {
        AppMethodBeat.i(56637);
        AppMethodBeat.o(56637);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56638);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.phX != null) {
                aVar.e(1, this.phX);
            }
            if (this.phY != null) {
                aVar.e(2, this.phY);
            }
            aVar.e(3, 8, this.phZ);
            AppMethodBeat.o(56638);
            return 0;
        } else if (i == 1) {
            if (this.phX != null) {
                f = e.a.a.b.b.a.f(1, this.phX) + 0;
            } else {
                f = 0;
            }
            if (this.phY != null) {
                f += e.a.a.b.b.a.f(2, this.phY);
            }
            int c = f + e.a.a.a.c(3, 8, this.phZ);
            AppMethodBeat.o(56638);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56638);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.phX = aVar3.BTU.readString();
                    AppMethodBeat.o(56638);
                    return 0;
                case 2:
                    mVar.phY = aVar3.BTU.readString();
                    AppMethodBeat.o(56638);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        h hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.phZ.add(hVar);
                    }
                    AppMethodBeat.o(56638);
                    return 0;
                default:
                    AppMethodBeat.o(56638);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56638);
            return -1;
        }
    }
}
