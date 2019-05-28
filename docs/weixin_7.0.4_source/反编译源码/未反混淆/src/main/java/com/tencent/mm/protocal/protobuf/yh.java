package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class yh extends a {
    public String Md5;
    public int jBv;
    public LinkedList<axm> jBw = new LinkedList();

    public yh() {
        AppMethodBeat.i(62537);
        AppMethodBeat.o(62537);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62538);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Md5 != null) {
                aVar.e(1, this.Md5);
            }
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.jBw);
            AppMethodBeat.o(62538);
            return 0;
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = e.a.a.b.b.a.f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            int bs = (f + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.jBw);
            AppMethodBeat.o(62538);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62538);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yh yhVar = (yh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    yhVar.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(62538);
                    return 0;
                case 2:
                    yhVar.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(62538);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axm axm = new axm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axm.populateBuilderWithField(aVar4, axm, a.getNextFieldNumber(aVar4))) {
                        }
                        yhVar.jBw.add(axm);
                    }
                    AppMethodBeat.o(62538);
                    return 0;
                default:
                    AppMethodBeat.o(62538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62538);
            return -1;
        }
    }
}
