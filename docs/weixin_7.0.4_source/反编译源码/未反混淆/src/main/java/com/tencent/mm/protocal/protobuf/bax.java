package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bax extends a {
    public String Desc;
    public int aPA;
    public String csB;
    public String cvZ;
    public int cyN;
    public int eRu;
    public String token;
    public String videoPath;
    public int wEJ;
    public bar wFA;
    public int wFB;
    public LinkedList<bar> wFC = new LinkedList();
    public int wFD;
    public String wFE;
    public String wFF;
    public String wFG;
    public baa wFH;
    public int wFI;
    public String wFc;
    public int wFd;
    public int wFe;
    public int wFm;
    public String wFn;

    public bax() {
        AppMethodBeat.i(94543);
        AppMethodBeat.o(94543);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94544);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wFd);
            aVar.iz(2, this.wFe);
            aVar.iz(3, this.wEJ);
            if (this.wFA != null) {
                aVar.iy(4, this.wFA.computeSize());
                this.wFA.writeFields(aVar);
            }
            aVar.iz(5, this.wFB);
            aVar.e(6, 8, this.wFC);
            aVar.iz(7, this.eRu);
            aVar.iz(8, this.wFD);
            if (this.Desc != null) {
                aVar.e(9, this.Desc);
            }
            if (this.wFE != null) {
                aVar.e(10, this.wFE);
            }
            if (this.token != null) {
                aVar.e(11, this.token);
            }
            if (this.wFn != null) {
                aVar.e(12, this.wFn);
            }
            aVar.iz(13, this.wFm);
            if (this.videoPath != null) {
                aVar.e(14, this.videoPath);
            }
            if (this.wFF != null) {
                aVar.e(15, this.wFF);
            }
            if (this.wFG != null) {
                aVar.e(16, this.wFG);
            }
            if (this.cvZ != null) {
                aVar.e(17, this.cvZ);
            }
            if (this.csB != null) {
                aVar.e(18, this.csB);
            }
            aVar.iz(19, this.aPA);
            aVar.iz(20, this.cyN);
            if (this.wFc != null) {
                aVar.e(21, this.wFc);
            }
            if (this.wFH != null) {
                aVar.iy(22, this.wFH.computeSize());
                this.wFH.writeFields(aVar);
            }
            aVar.iz(23, this.wFI);
            AppMethodBeat.o(94544);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wFd) + 0) + e.a.a.b.b.a.bs(2, this.wFe)) + e.a.a.b.b.a.bs(3, this.wEJ);
            if (this.wFA != null) {
                bs += e.a.a.a.ix(4, this.wFA.computeSize());
            }
            bs = (((bs + e.a.a.b.b.a.bs(5, this.wFB)) + e.a.a.a.c(6, 8, this.wFC)) + e.a.a.b.b.a.bs(7, this.eRu)) + e.a.a.b.b.a.bs(8, this.wFD);
            if (this.Desc != null) {
                bs += e.a.a.b.b.a.f(9, this.Desc);
            }
            if (this.wFE != null) {
                bs += e.a.a.b.b.a.f(10, this.wFE);
            }
            if (this.token != null) {
                bs += e.a.a.b.b.a.f(11, this.token);
            }
            if (this.wFn != null) {
                bs += e.a.a.b.b.a.f(12, this.wFn);
            }
            bs += e.a.a.b.b.a.bs(13, this.wFm);
            if (this.videoPath != null) {
                bs += e.a.a.b.b.a.f(14, this.videoPath);
            }
            if (this.wFF != null) {
                bs += e.a.a.b.b.a.f(15, this.wFF);
            }
            if (this.wFG != null) {
                bs += e.a.a.b.b.a.f(16, this.wFG);
            }
            if (this.cvZ != null) {
                bs += e.a.a.b.b.a.f(17, this.cvZ);
            }
            if (this.csB != null) {
                bs += e.a.a.b.b.a.f(18, this.csB);
            }
            bs = (bs + e.a.a.b.b.a.bs(19, this.aPA)) + e.a.a.b.b.a.bs(20, this.cyN);
            if (this.wFc != null) {
                bs += e.a.a.b.b.a.f(21, this.wFc);
            }
            if (this.wFH != null) {
                bs += e.a.a.a.ix(22, this.wFH.computeSize());
            }
            bs += e.a.a.b.b.a.bs(23, this.wFI);
            AppMethodBeat.o(94544);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94544);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bax bax = (bax) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bar bar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bax.wFd = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 2:
                    bax.wFe = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 3:
                    bax.wEJ = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bar = new bar();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bar.populateBuilderWithField(aVar4, bar, a.getNextFieldNumber(aVar4))) {
                        }
                        bax.wFA = bar;
                    }
                    AppMethodBeat.o(94544);
                    return 0;
                case 5:
                    bax.wFB = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bar = new bar();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bar.populateBuilderWithField(aVar4, bar, a.getNextFieldNumber(aVar4))) {
                        }
                        bax.wFC.add(bar);
                    }
                    AppMethodBeat.o(94544);
                    return 0;
                case 7:
                    bax.eRu = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 8:
                    bax.wFD = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 9:
                    bax.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 10:
                    bax.wFE = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 11:
                    bax.token = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 12:
                    bax.wFn = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 13:
                    bax.wFm = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 14:
                    bax.videoPath = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 15:
                    bax.wFF = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 16:
                    bax.wFG = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 17:
                    bax.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 18:
                    bax.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 19:
                    bax.aPA = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 20:
                    bax.cyN = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                case 21:
                    bax.wFc = aVar3.BTU.readString();
                    AppMethodBeat.o(94544);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        baa baa = new baa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baa.populateBuilderWithField(aVar4, baa, a.getNextFieldNumber(aVar4))) {
                        }
                        bax.wFH = baa;
                    }
                    AppMethodBeat.o(94544);
                    return 0;
                case 23:
                    bax.wFI = aVar3.BTU.vd();
                    AppMethodBeat.o(94544);
                    return 0;
                default:
                    AppMethodBeat.o(94544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94544);
            return -1;
        }
    }
}
