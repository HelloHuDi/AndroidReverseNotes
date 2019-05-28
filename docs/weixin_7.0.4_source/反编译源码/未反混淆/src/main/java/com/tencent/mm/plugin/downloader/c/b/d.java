package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class d extends a {
    public String kLe;
    public LinkedList<String> kLf = new LinkedList();
    public String kLg;
    public String kLh;
    public LinkedList<String> kLi = new LinkedList();
    public m kLj;
    public e kLk;

    public d() {
        AppMethodBeat.i(35528);
        AppMethodBeat.o(35528);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35529);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kLe != null) {
                aVar.e(1, this.kLe);
            }
            aVar.e(2, 1, this.kLf);
            if (this.kLg != null) {
                aVar.e(3, this.kLg);
            }
            if (this.kLh != null) {
                aVar.e(4, this.kLh);
            }
            aVar.e(5, 1, this.kLi);
            if (this.kLj != null) {
                aVar.iy(6, this.kLj.computeSize());
                this.kLj.writeFields(aVar);
            }
            if (this.kLk != null) {
                aVar.iy(7, this.kLk.computeSize());
                this.kLk.writeFields(aVar);
            }
            AppMethodBeat.o(35529);
            return 0;
        } else if (i == 1) {
            if (this.kLe != null) {
                f = e.a.a.b.b.a.f(1, this.kLe) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 1, this.kLf);
            if (this.kLg != null) {
                f += e.a.a.b.b.a.f(3, this.kLg);
            }
            if (this.kLh != null) {
                f += e.a.a.b.b.a.f(4, this.kLh);
            }
            f += e.a.a.a.c(5, 1, this.kLi);
            if (this.kLj != null) {
                f += e.a.a.a.ix(6, this.kLj.computeSize());
            }
            if (this.kLk != null) {
                f += e.a.a.a.ix(7, this.kLk.computeSize());
            }
            AppMethodBeat.o(35529);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kLf.clear();
            this.kLi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35529);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.kLe = aVar3.BTU.readString();
                    AppMethodBeat.o(35529);
                    return 0;
                case 2:
                    dVar.kLf.add(aVar3.BTU.readString());
                    AppMethodBeat.o(35529);
                    return 0;
                case 3:
                    dVar.kLg = aVar3.BTU.readString();
                    AppMethodBeat.o(35529);
                    return 0;
                case 4:
                    dVar.kLh = aVar3.BTU.readString();
                    AppMethodBeat.o(35529);
                    return 0;
                case 5:
                    dVar.kLi.add(aVar3.BTU.readString());
                    AppMethodBeat.o(35529);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.kLj = mVar;
                    }
                    AppMethodBeat.o(35529);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.kLk = eVar;
                    }
                    AppMethodBeat.o(35529);
                    return 0;
                default:
                    AppMethodBeat.o(35529);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35529);
            return -1;
        }
    }
}
