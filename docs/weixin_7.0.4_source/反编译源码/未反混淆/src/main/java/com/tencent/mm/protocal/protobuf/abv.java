package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class abv extends a {
    public String pOz;
    public LinkedList<abw> vPg = new LinkedList();
    public String vWF;
    public String wjd;
    public long wje;
    public long wjf;
    public String wjg;
    public long wjh;

    public abv() {
        AppMethodBeat.i(56790);
        AppMethodBeat.o(56790);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56791);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wjd != null) {
                aVar.e(1, this.wjd);
            }
            aVar.e(2, 8, this.vPg);
            aVar.ai(3, this.wje);
            aVar.ai(4, this.wjf);
            if (this.wjg != null) {
                aVar.e(5, this.wjg);
            }
            if (this.pOz != null) {
                aVar.e(6, this.pOz);
            }
            aVar.ai(7, this.wjh);
            if (this.vWF != null) {
                aVar.e(8, this.vWF);
            }
            AppMethodBeat.o(56791);
            return 0;
        } else if (i == 1) {
            if (this.wjd != null) {
                f = e.a.a.b.b.a.f(1, this.wjd) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.a.c(2, 8, this.vPg)) + e.a.a.b.b.a.o(3, this.wje)) + e.a.a.b.b.a.o(4, this.wjf);
            if (this.wjg != null) {
                f += e.a.a.b.b.a.f(5, this.wjg);
            }
            if (this.pOz != null) {
                f += e.a.a.b.b.a.f(6, this.pOz);
            }
            f += e.a.a.b.b.a.o(7, this.wjh);
            if (this.vWF != null) {
                f += e.a.a.b.b.a.f(8, this.vWF);
            }
            AppMethodBeat.o(56791);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56791);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abv abv = (abv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abv.wjd = aVar3.BTU.readString();
                    AppMethodBeat.o(56791);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abw abw = new abw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = abw.populateBuilderWithField(aVar4, abw, a.getNextFieldNumber(aVar4))) {
                        }
                        abv.vPg.add(abw);
                    }
                    AppMethodBeat.o(56791);
                    return 0;
                case 3:
                    abv.wje = aVar3.BTU.ve();
                    AppMethodBeat.o(56791);
                    return 0;
                case 4:
                    abv.wjf = aVar3.BTU.ve();
                    AppMethodBeat.o(56791);
                    return 0;
                case 5:
                    abv.wjg = aVar3.BTU.readString();
                    AppMethodBeat.o(56791);
                    return 0;
                case 6:
                    abv.pOz = aVar3.BTU.readString();
                    AppMethodBeat.o(56791);
                    return 0;
                case 7:
                    abv.wjh = aVar3.BTU.ve();
                    AppMethodBeat.o(56791);
                    return 0;
                case 8:
                    abv.vWF = aVar3.BTU.readString();
                    AppMethodBeat.o(56791);
                    return 0;
                default:
                    AppMethodBeat.o(56791);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56791);
            return -1;
        }
    }
}
