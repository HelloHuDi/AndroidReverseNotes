package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class wz extends a {
    public String kbW;
    public String title;
    public int wcU;
    public LinkedList<tm> wcV = new LinkedList();

    public wz() {
        AppMethodBeat.i(89063);
        AppMethodBeat.o(89063);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89064);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.kbW != null) {
                aVar.e(2, this.kbW);
            }
            aVar.iz(3, this.wcU);
            aVar.e(4, 8, this.wcV);
            AppMethodBeat.o(89064);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.kbW != null) {
                f += e.a.a.b.b.a.f(2, this.kbW);
            }
            int bs = (f + e.a.a.b.b.a.bs(3, this.wcU)) + e.a.a.a.c(4, 8, this.wcV);
            AppMethodBeat.o(89064);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wcV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89064);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wz wzVar = (wz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wzVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(89064);
                    return 0;
                case 2:
                    wzVar.kbW = aVar3.BTU.readString();
                    AppMethodBeat.o(89064);
                    return 0;
                case 3:
                    wzVar.wcU = aVar3.BTU.vd();
                    AppMethodBeat.o(89064);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tm tmVar = new tm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        wzVar.wcV.add(tmVar);
                    }
                    AppMethodBeat.o(89064);
                    return 0;
                default:
                    AppMethodBeat.o(89064);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89064);
            return -1;
        }
    }
}
