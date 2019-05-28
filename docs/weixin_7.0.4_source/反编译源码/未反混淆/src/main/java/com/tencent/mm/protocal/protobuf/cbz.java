package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cbz extends a {
    public int jBv;
    public LinkedList<bts> jBw = new LinkedList();
    public String ncF;
    public long xbt;

    public cbz() {
        AppMethodBeat.i(94606);
        AppMethodBeat.o(94606);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94607);
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xbt);
            if (this.ncF != null) {
                aVar.e(2, this.ncF);
            }
            aVar.iz(3, this.jBv);
            aVar.e(4, 8, this.jBw);
            AppMethodBeat.o(94607);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.xbt) + 0;
            if (this.ncF != null) {
                o += e.a.a.b.b.a.f(2, this.ncF);
            }
            o = (o + e.a.a.b.b.a.bs(3, this.jBv)) + e.a.a.a.c(4, 8, this.jBw);
            AppMethodBeat.o(94607);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94607);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbz cbz = (cbz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbz.xbt = aVar3.BTU.ve();
                    AppMethodBeat.o(94607);
                    return 0;
                case 2:
                    cbz.ncF = aVar3.BTU.readString();
                    AppMethodBeat.o(94607);
                    return 0;
                case 3:
                    cbz.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(94607);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cbz.jBw.add(bts);
                    }
                    AppMethodBeat.o(94607);
                    return 0;
                default:
                    AppMethodBeat.o(94607);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94607);
            return -1;
        }
    }
}
