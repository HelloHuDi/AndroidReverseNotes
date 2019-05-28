package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bhw extends a {
    public String pdA;
    public LinkedList<bhw> tOS = new LinkedList();
    public int timestamp;
    public String type;
    public String wLb;
    public LinkedList<bhv> wLc = new LinkedList();
    public int wLd;
    public int wLe;

    public bhw() {
        AppMethodBeat.i(90697);
        AppMethodBeat.o(90697);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(90698);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wLb != null) {
                aVar.e(1, this.wLb);
            }
            if (this.pdA != null) {
                aVar.e(2, this.pdA);
            }
            aVar.e(3, 8, this.wLc);
            aVar.iz(4, this.timestamp);
            if (this.type != null) {
                aVar.e(5, this.type);
            }
            aVar.e(6, 8, this.tOS);
            aVar.iz(7, this.wLd);
            aVar.iz(8, this.wLe);
            AppMethodBeat.o(90698);
            return 0;
        } else if (i == 1) {
            if (this.wLb != null) {
                f = e.a.a.b.b.a.f(1, this.wLb) + 0;
            } else {
                f = 0;
            }
            if (this.pdA != null) {
                f += e.a.a.b.b.a.f(2, this.pdA);
            }
            f = (f + e.a.a.a.c(3, 8, this.wLc)) + e.a.a.b.b.a.bs(4, this.timestamp);
            if (this.type != null) {
                f += e.a.a.b.b.a.f(5, this.type);
            }
            int c = ((f + e.a.a.a.c(6, 8, this.tOS)) + e.a.a.b.b.a.bs(7, this.wLd)) + e.a.a.b.b.a.bs(8, this.wLe);
            AppMethodBeat.o(90698);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLc.clear();
            this.tOS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(90698);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhw bhw = (bhw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bhw.wLb = aVar3.BTU.readString();
                    AppMethodBeat.o(90698);
                    return 0;
                case 2:
                    bhw.pdA = aVar3.BTU.readString();
                    AppMethodBeat.o(90698);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhv bhv = new bhv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhv.populateBuilderWithField(aVar4, bhv, a.getNextFieldNumber(aVar4))) {
                        }
                        bhw.wLc.add(bhv);
                    }
                    AppMethodBeat.o(90698);
                    return 0;
                case 4:
                    bhw.timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(90698);
                    return 0;
                case 5:
                    bhw.type = aVar3.BTU.readString();
                    AppMethodBeat.o(90698);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhw bhw2 = new bhw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhw2.populateBuilderWithField(aVar4, bhw2, a.getNextFieldNumber(aVar4))) {
                        }
                        bhw.tOS.add(bhw2);
                    }
                    AppMethodBeat.o(90698);
                    return 0;
                case 7:
                    bhw.wLd = aVar3.BTU.vd();
                    AppMethodBeat.o(90698);
                    return 0;
                case 8:
                    bhw.wLe = aVar3.BTU.vd();
                    AppMethodBeat.o(90698);
                    return 0;
                default:
                    AppMethodBeat.o(90698);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90698);
            return -1;
        }
    }
}
