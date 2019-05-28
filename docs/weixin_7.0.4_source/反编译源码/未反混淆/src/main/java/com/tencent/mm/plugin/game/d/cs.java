package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cs extends a {
    public String Desc;
    public String Title;
    public String fKh;
    public String mZi;
    public e mZk;
    public String nas;
    public String nbr;
    public LinkedList<x> ndm = new LinkedList();

    public cs() {
        AppMethodBeat.i(111658);
        AppMethodBeat.o(111658);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111659);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.mZi != null) {
                aVar.e(3, this.mZi);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.nbr != null) {
                aVar.e(5, this.nbr);
            }
            if (this.mZk != null) {
                aVar.iy(6, this.mZk.computeSize());
                this.mZk.writeFields(aVar);
            }
            aVar.e(7, 8, this.ndm);
            if (this.nas != null) {
                aVar.e(8, this.nas);
            }
            AppMethodBeat.o(111659);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.mZi != null) {
                f += e.a.a.b.b.a.f(3, this.mZi);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.nbr != null) {
                f += e.a.a.b.b.a.f(5, this.nbr);
            }
            if (this.mZk != null) {
                f += e.a.a.a.ix(6, this.mZk.computeSize());
            }
            f += e.a.a.a.c(7, 8, this.ndm);
            if (this.nas != null) {
                f += e.a.a.b.b.a.f(8, this.nas);
            }
            AppMethodBeat.o(111659);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111659);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cs csVar = (cs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    csVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111659);
                    return 0;
                case 2:
                    csVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(111659);
                    return 0;
                case 3:
                    csVar.mZi = aVar3.BTU.readString();
                    AppMethodBeat.o(111659);
                    return 0;
                case 4:
                    csVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111659);
                    return 0;
                case 5:
                    csVar.nbr = aVar3.BTU.readString();
                    AppMethodBeat.o(111659);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        csVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111659);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        x xVar = new x();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xVar.populateBuilderWithField(aVar4, xVar, a.getNextFieldNumber(aVar4))) {
                        }
                        csVar.ndm.add(xVar);
                    }
                    AppMethodBeat.o(111659);
                    return 0;
                case 8:
                    csVar.nas = aVar3.BTU.readString();
                    AppMethodBeat.o(111659);
                    return 0;
                default:
                    AppMethodBeat.o(111659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111659);
            return -1;
        }
    }
}
