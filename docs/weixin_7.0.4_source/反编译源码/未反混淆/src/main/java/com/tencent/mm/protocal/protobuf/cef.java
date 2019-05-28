package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cef extends a {
    public long vQE;
    public cer xdJ;
    public String xdK;
    public int xds;
    public LinkedList<Integer> xeb = new LinkedList();

    public cef() {
        AppMethodBeat.i(56519);
        AppMethodBeat.o(56519);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56520);
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vQE);
            if (this.xdK != null) {
                aVar.e(2, this.xdK);
            }
            if (this.xdJ != null) {
                aVar.iy(3, this.xdJ.computeSize());
                this.xdJ.writeFields(aVar);
            }
            aVar.iz(4, this.xds);
            aVar.f(5, 2, this.xeb);
            AppMethodBeat.o(56520);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vQE) + 0;
            if (this.xdK != null) {
                o += e.a.a.b.b.a.f(2, this.xdK);
            }
            if (this.xdJ != null) {
                o += e.a.a.a.ix(3, this.xdJ.computeSize());
            }
            o = (o + e.a.a.b.b.a.bs(4, this.xds)) + e.a.a.a.d(5, 2, this.xeb);
            AppMethodBeat.o(56520);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56520);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cef cef = (cef) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cef.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(56520);
                    return 0;
                case 2:
                    cef.xdK = aVar3.BTU.readString();
                    AppMethodBeat.o(56520);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cer.populateBuilderWithField(aVar4, cer, a.getNextFieldNumber(aVar4))) {
                        }
                        cef.xdJ = cer;
                    }
                    AppMethodBeat.o(56520);
                    return 0;
                case 4:
                    cef.xds = aVar3.BTU.vd();
                    AppMethodBeat.o(56520);
                    return 0;
                case 5:
                    cef.xeb = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(56520);
                    return 0;
                default:
                    AppMethodBeat.o(56520);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56520);
            return -1;
        }
    }
}
