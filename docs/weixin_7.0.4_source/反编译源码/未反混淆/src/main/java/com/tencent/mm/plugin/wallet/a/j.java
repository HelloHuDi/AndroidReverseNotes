package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class j extends a {
    public double tmT;
    public LinkedList<t> tmV = new LinkedList();
    public double tna;
    public double tnb;
    public int tnc;
    public String tnd;
    public String tne;
    public b tnj;
    public String tnk;
    public double tnl;
    public LinkedList<f> tnm = new LinkedList();

    public j() {
        AppMethodBeat.i(56653);
        AppMethodBeat.o(56653);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56654);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tnk != null) {
                aVar.e(1, this.tnk);
            }
            aVar.f(2, this.tnl);
            aVar.f(3, this.tmT);
            aVar.e(4, 8, this.tnm);
            aVar.e(5, 8, this.tmV);
            aVar.f(6, this.tna);
            aVar.f(7, this.tnb);
            aVar.iz(8, this.tnc);
            if (this.tnd != null) {
                aVar.e(9, this.tnd);
            }
            if (this.tne != null) {
                aVar.e(10, this.tne);
            }
            if (this.tnj != null) {
                aVar.c(11, this.tnj);
            }
            AppMethodBeat.o(56654);
            return 0;
        } else if (i == 1) {
            if (this.tnk != null) {
                f = e.a.a.b.b.a.f(1, this.tnk) + 0;
            } else {
                f = 0;
            }
            f = ((((((f + (e.a.a.b.b.a.fv(2) + 8)) + (e.a.a.b.b.a.fv(3) + 8)) + e.a.a.a.c(4, 8, this.tnm)) + e.a.a.a.c(5, 8, this.tmV)) + (e.a.a.b.b.a.fv(6) + 8)) + (e.a.a.b.b.a.fv(7) + 8)) + e.a.a.b.b.a.bs(8, this.tnc);
            if (this.tnd != null) {
                f += e.a.a.b.b.a.f(9, this.tnd);
            }
            if (this.tne != null) {
                f += e.a.a.b.b.a.f(10, this.tne);
            }
            if (this.tnj != null) {
                f += e.a.a.b.b.a.b(11, this.tnj);
            }
            AppMethodBeat.o(56654);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tnm.clear();
            this.tmV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56654);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jVar.tnk = aVar3.BTU.readString();
                    AppMethodBeat.o(56654);
                    return 0;
                case 2:
                    jVar.tnl = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56654);
                    return 0;
                case 3:
                    jVar.tmT = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56654);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.tnm.add(fVar);
                    }
                    AppMethodBeat.o(56654);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        t tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.tmV.add(tVar);
                    }
                    AppMethodBeat.o(56654);
                    return 0;
                case 6:
                    jVar.tna = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56654);
                    return 0;
                case 7:
                    jVar.tnb = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56654);
                    return 0;
                case 8:
                    jVar.tnc = aVar3.BTU.vd();
                    AppMethodBeat.o(56654);
                    return 0;
                case 9:
                    jVar.tnd = aVar3.BTU.readString();
                    AppMethodBeat.o(56654);
                    return 0;
                case 10:
                    jVar.tne = aVar3.BTU.readString();
                    AppMethodBeat.o(56654);
                    return 0;
                case 11:
                    jVar.tnj = aVar3.BTU.emu();
                    AppMethodBeat.o(56654);
                    return 0;
                default:
                    AppMethodBeat.o(56654);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56654);
            return -1;
        }
    }
}
