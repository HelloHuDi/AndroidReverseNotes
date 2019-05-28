package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class e extends a {
    public int nettype;
    public int uin;
    public int vyR;
    public LinkedList<d> vyS = new LinkedList();
    public String vzb;
    public String vzc;
    public String vzd;
    public String vze;
    public String vzf;
    public int vzg;

    public e() {
        AppMethodBeat.i(72820);
        AppMethodBeat.o(72820);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72821);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.uin);
            aVar.iz(2, this.vyR);
            aVar.iz(3, this.nettype);
            aVar.e(4, 8, this.vyS);
            if (this.vzb != null) {
                aVar.e(5, this.vzb);
            }
            if (this.vzc != null) {
                aVar.e(6, this.vzc);
            }
            if (this.vzd != null) {
                aVar.e(7, this.vzd);
            }
            if (this.vze != null) {
                aVar.e(8, this.vze);
            }
            if (this.vzf != null) {
                aVar.e(9, this.vzf);
            }
            aVar.iz(10, this.vzg);
            AppMethodBeat.o(72821);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.uin) + 0) + e.a.a.b.b.a.bs(2, this.vyR)) + e.a.a.b.b.a.bs(3, this.nettype)) + e.a.a.a.c(4, 8, this.vyS);
            if (this.vzb != null) {
                bs += e.a.a.b.b.a.f(5, this.vzb);
            }
            if (this.vzc != null) {
                bs += e.a.a.b.b.a.f(6, this.vzc);
            }
            if (this.vzd != null) {
                bs += e.a.a.b.b.a.f(7, this.vzd);
            }
            if (this.vze != null) {
                bs += e.a.a.b.b.a.f(8, this.vze);
            }
            if (this.vzf != null) {
                bs += e.a.a.b.b.a.f(9, this.vzf);
            }
            bs += e.a.a.b.b.a.bs(10, this.vzg);
            AppMethodBeat.o(72821);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vyS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72821);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.uin = aVar3.BTU.vd();
                    AppMethodBeat.o(72821);
                    return 0;
                case 2:
                    eVar.vyR = aVar3.BTU.vd();
                    AppMethodBeat.o(72821);
                    return 0;
                case 3:
                    eVar.nettype = aVar3.BTU.vd();
                    AppMethodBeat.o(72821);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.vyS.add(dVar);
                    }
                    AppMethodBeat.o(72821);
                    return 0;
                case 5:
                    eVar.vzb = aVar3.BTU.readString();
                    AppMethodBeat.o(72821);
                    return 0;
                case 6:
                    eVar.vzc = aVar3.BTU.readString();
                    AppMethodBeat.o(72821);
                    return 0;
                case 7:
                    eVar.vzd = aVar3.BTU.readString();
                    AppMethodBeat.o(72821);
                    return 0;
                case 8:
                    eVar.vze = aVar3.BTU.readString();
                    AppMethodBeat.o(72821);
                    return 0;
                case 9:
                    eVar.vzf = aVar3.BTU.readString();
                    AppMethodBeat.o(72821);
                    return 0;
                case 10:
                    eVar.vzg = aVar3.BTU.vd();
                    AppMethodBeat.o(72821);
                    return 0;
                default:
                    AppMethodBeat.o(72821);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72821);
            return -1;
        }
    }
}
