package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aw extends a {
    public String IconUrl;
    public String Title;
    public String fKh;
    public String mZi;
    public e mZk;
    public LinkedList<String> nbo = new LinkedList();
    public String nbp;
    public String nbq;
    public String nbr;

    public aw() {
        AppMethodBeat.i(111592);
        AppMethodBeat.o(111592);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111593);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            aVar.e(3, 1, this.nbo);
            if (this.nbp != null) {
                aVar.e(4, this.nbp);
            }
            if (this.mZi != null) {
                aVar.e(5, this.mZi);
            }
            if (this.nbq != null) {
                aVar.e(6, this.nbq);
            }
            if (this.nbr != null) {
                aVar.e(8, this.nbr);
            }
            if (this.fKh != null) {
                aVar.e(9, this.fKh);
            }
            if (this.mZk != null) {
                aVar.iy(10, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            AppMethodBeat.o(111593);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(2, this.IconUrl);
            }
            f += e.a.a.a.c(3, 1, this.nbo);
            if (this.nbp != null) {
                f += e.a.a.b.b.a.f(4, this.nbp);
            }
            if (this.mZi != null) {
                f += e.a.a.b.b.a.f(5, this.mZi);
            }
            if (this.nbq != null) {
                f += e.a.a.b.b.a.f(6, this.nbq);
            }
            if (this.nbr != null) {
                f += e.a.a.b.b.a.f(8, this.nbr);
            }
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(9, this.fKh);
            }
            if (this.mZk != null) {
                f += e.a.a.a.ix(10, this.mZk.computeSize());
            }
            AppMethodBeat.o(111593);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111593);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aw awVar = (aw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 2:
                    awVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 3:
                    awVar.nbo.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111593);
                    return 0;
                case 4:
                    awVar.nbp = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 5:
                    awVar.mZi = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 6:
                    awVar.nbq = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 8:
                    awVar.nbr = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 9:
                    awVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(111593);
                    return 0;
                case 10:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        awVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111593);
                    return 0;
                default:
                    AppMethodBeat.o(111593);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111593);
            return -1;
        }
    }
}
