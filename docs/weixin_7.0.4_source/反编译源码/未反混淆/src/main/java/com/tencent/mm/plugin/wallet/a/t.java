package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class t extends a {
    public String pcj;
    public String tmO;
    public String tmP;
    public String tmQ;
    public int tnJ;
    public int tnK;
    public long tnL;
    public String tnM;
    public String tnN;
    public String tnO;
    public double tnP;
    public double tnQ;
    public int tnR;
    public String tnS;
    public String tnT;
    public LinkedList<b> tnU = new LinkedList();

    public t() {
        AppMethodBeat.i(56661);
        AppMethodBeat.o(56661);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56662);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.tnJ);
            aVar.iz(2, this.tnK);
            aVar.ai(3, this.tnL);
            if (this.tnM != null) {
                aVar.e(4, this.tnM);
            }
            if (this.tmO != null) {
                aVar.e(5, this.tmO);
            }
            if (this.tnN != null) {
                aVar.e(6, this.tnN);
            }
            if (this.tnO != null) {
                aVar.e(7, this.tnO);
            }
            if (this.tmP != null) {
                aVar.e(8, this.tmP);
            }
            if (this.tmQ != null) {
                aVar.e(9, this.tmQ);
            }
            aVar.f(10, this.tnP);
            aVar.f(11, this.tnQ);
            aVar.iz(12, this.tnR);
            if (this.tnS != null) {
                aVar.e(13, this.tnS);
            }
            if (this.pcj != null) {
                aVar.e(14, this.pcj);
            }
            if (this.tnT != null) {
                aVar.e(16, this.tnT);
            }
            aVar.e(17, 6, this.tnU);
            AppMethodBeat.o(56662);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.tnJ) + 0) + e.a.a.b.b.a.bs(2, this.tnK)) + e.a.a.b.b.a.o(3, this.tnL);
            if (this.tnM != null) {
                bs += e.a.a.b.b.a.f(4, this.tnM);
            }
            if (this.tmO != null) {
                bs += e.a.a.b.b.a.f(5, this.tmO);
            }
            if (this.tnN != null) {
                bs += e.a.a.b.b.a.f(6, this.tnN);
            }
            if (this.tnO != null) {
                bs += e.a.a.b.b.a.f(7, this.tnO);
            }
            if (this.tmP != null) {
                bs += e.a.a.b.b.a.f(8, this.tmP);
            }
            if (this.tmQ != null) {
                bs += e.a.a.b.b.a.f(9, this.tmQ);
            }
            bs = ((bs + (e.a.a.b.b.a.fv(10) + 8)) + (e.a.a.b.b.a.fv(11) + 8)) + e.a.a.b.b.a.bs(12, this.tnR);
            if (this.tnS != null) {
                bs += e.a.a.b.b.a.f(13, this.tnS);
            }
            if (this.pcj != null) {
                bs += e.a.a.b.b.a.f(14, this.pcj);
            }
            if (this.tnT != null) {
                bs += e.a.a.b.b.a.f(16, this.tnT);
            }
            bs += e.a.a.a.c(17, 6, this.tnU);
            AppMethodBeat.o(56662);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.tnU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56662);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.tnJ = aVar3.BTU.vd();
                    AppMethodBeat.o(56662);
                    return 0;
                case 2:
                    tVar.tnK = aVar3.BTU.vd();
                    AppMethodBeat.o(56662);
                    return 0;
                case 3:
                    tVar.tnL = aVar3.BTU.ve();
                    AppMethodBeat.o(56662);
                    return 0;
                case 4:
                    tVar.tnM = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 5:
                    tVar.tmO = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 6:
                    tVar.tnN = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 7:
                    tVar.tnO = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 8:
                    tVar.tmP = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 9:
                    tVar.tmQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 10:
                    tVar.tnP = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56662);
                    return 0;
                case 11:
                    tVar.tnQ = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56662);
                    return 0;
                case 12:
                    tVar.tnR = aVar3.BTU.vd();
                    AppMethodBeat.o(56662);
                    return 0;
                case 13:
                    tVar.tnS = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 14:
                    tVar.pcj = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 16:
                    tVar.tnT = aVar3.BTU.readString();
                    AppMethodBeat.o(56662);
                    return 0;
                case 17:
                    tVar.tnU.add(aVar3.BTU.emu());
                    AppMethodBeat.o(56662);
                    return 0;
                default:
                    AppMethodBeat.o(56662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56662);
            return -1;
        }
    }
}
