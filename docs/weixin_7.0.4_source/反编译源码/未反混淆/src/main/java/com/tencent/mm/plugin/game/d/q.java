package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class q extends a {
    public String nac;
    public String nad;
    public String nae;
    public ds naf;
    public int nag;
    public int nah;
    public String nai;
    public int naj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111556);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nac == null) {
                bVar = new b("Not all required fields were included: DownloadURL");
                AppMethodBeat.o(111556);
                throw bVar;
            }
            if (this.nac != null) {
                aVar.e(1, this.nac);
            }
            if (this.nad != null) {
                aVar.e(2, this.nad);
            }
            if (this.nae != null) {
                aVar.e(4, this.nae);
            }
            if (this.naf != null) {
                aVar.iy(5, this.naf.computeSize());
                this.naf.writeFields(aVar);
            }
            aVar.iz(6, this.nag);
            aVar.iz(7, this.nah);
            if (this.nai != null) {
                aVar.e(8, this.nai);
            }
            aVar.iz(9, this.naj);
            AppMethodBeat.o(111556);
            return 0;
        } else if (i == 1) {
            if (this.nac != null) {
                f = e.a.a.b.b.a.f(1, this.nac) + 0;
            } else {
                f = 0;
            }
            if (this.nad != null) {
                f += e.a.a.b.b.a.f(2, this.nad);
            }
            if (this.nae != null) {
                f += e.a.a.b.b.a.f(4, this.nae);
            }
            if (this.naf != null) {
                f += e.a.a.a.ix(5, this.naf.computeSize());
            }
            f = (f + e.a.a.b.b.a.bs(6, this.nag)) + e.a.a.b.b.a.bs(7, this.nah);
            if (this.nai != null) {
                f += e.a.a.b.b.a.f(8, this.nai);
            }
            int bs = f + e.a.a.b.b.a.bs(9, this.naj);
            AppMethodBeat.o(111556);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.nac == null) {
                bVar = new b("Not all required fields were included: DownloadURL");
                AppMethodBeat.o(111556);
                throw bVar;
            }
            AppMethodBeat.o(111556);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qVar.nac = aVar3.BTU.readString();
                    AppMethodBeat.o(111556);
                    return 0;
                case 2:
                    qVar.nad = aVar3.BTU.readString();
                    AppMethodBeat.o(111556);
                    return 0;
                case 4:
                    qVar.nae = aVar3.BTU.readString();
                    AppMethodBeat.o(111556);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ds dsVar = new ds();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dsVar.populateBuilderWithField(aVar4, dsVar, a.getNextFieldNumber(aVar4))) {
                        }
                        qVar.naf = dsVar;
                    }
                    AppMethodBeat.o(111556);
                    return 0;
                case 6:
                    qVar.nag = aVar3.BTU.vd();
                    AppMethodBeat.o(111556);
                    return 0;
                case 7:
                    qVar.nah = aVar3.BTU.vd();
                    AppMethodBeat.o(111556);
                    return 0;
                case 8:
                    qVar.nai = aVar3.BTU.readString();
                    AppMethodBeat.o(111556);
                    return 0;
                case 9:
                    qVar.naj = aVar3.BTU.vd();
                    AppMethodBeat.o(111556);
                    return 0;
                default:
                    AppMethodBeat.o(111556);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111556);
            return -1;
        }
    }
}
