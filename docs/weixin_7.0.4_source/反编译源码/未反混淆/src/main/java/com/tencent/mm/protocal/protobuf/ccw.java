package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ccw extends a {
    public int xce;
    public int xcf;
    public int xcg;
    public coj xch;
    public int xci;
    public int xcj;
    public int xck;
    public int xcl;
    public LinkedList<Integer> xcm = new LinkedList();
    public int xcn;
    public LinkedList<Integer> xco = new LinkedList();
    public int xcp;
    public LinkedList<Integer> xcq = new LinkedList();

    public ccw() {
        AppMethodBeat.i(5219);
        AppMethodBeat.o(5219);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5220);
        b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xch == null) {
                bVar = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(5220);
                throw bVar;
            }
            aVar.iz(1, this.xce);
            aVar.iz(2, this.xcf);
            aVar.iz(3, this.xcg);
            if (this.xch != null) {
                aVar.iy(4, this.xch.computeSize());
                this.xch.writeFields(aVar);
            }
            aVar.iz(5, this.xci);
            aVar.iz(6, this.xcj);
            aVar.iz(7, this.xck);
            aVar.iz(8, this.xcl);
            aVar.f(9, 2, this.xcm);
            aVar.iz(10, this.xcn);
            aVar.f(11, 2, this.xco);
            aVar.iz(12, this.xcp);
            aVar.f(13, 2, this.xcq);
            AppMethodBeat.o(5220);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.xce) + 0) + e.a.a.b.b.a.bs(2, this.xcf)) + e.a.a.b.b.a.bs(3, this.xcg);
            if (this.xch != null) {
                bs += e.a.a.a.ix(4, this.xch.computeSize());
            }
            bs = ((((((((bs + e.a.a.b.b.a.bs(5, this.xci)) + e.a.a.b.b.a.bs(6, this.xcj)) + e.a.a.b.b.a.bs(7, this.xck)) + e.a.a.b.b.a.bs(8, this.xcl)) + e.a.a.a.d(9, 2, this.xcm)) + e.a.a.b.b.a.bs(10, this.xcn)) + e.a.a.a.d(11, 2, this.xco)) + e.a.a.b.b.a.bs(12, this.xcp)) + e.a.a.a.d(13, 2, this.xcq);
            AppMethodBeat.o(5220);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xcm.clear();
            this.xco.clear();
            this.xcq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xch == null) {
                bVar = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(5220);
                throw bVar;
            }
            AppMethodBeat.o(5220);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccw ccw = (ccw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccw.xce = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 2:
                    ccw.xcf = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 3:
                    ccw.xcg = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = coj.populateBuilderWithField(aVar4, coj, a.getNextFieldNumber(aVar4))) {
                        }
                        ccw.xch = coj;
                    }
                    AppMethodBeat.o(5220);
                    return 0;
                case 5:
                    ccw.xci = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 6:
                    ccw.xcj = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 7:
                    ccw.xck = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 8:
                    ccw.xcl = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 9:
                    ccw.xcm = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(5220);
                    return 0;
                case 10:
                    ccw.xcn = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 11:
                    ccw.xco = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(5220);
                    return 0;
                case 12:
                    ccw.xcp = aVar3.BTU.vd();
                    AppMethodBeat.o(5220);
                    return 0;
                case 13:
                    ccw.xcq = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(5220);
                    return 0;
                default:
                    AppMethodBeat.o(5220);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5220);
            return -1;
        }
    }
}
