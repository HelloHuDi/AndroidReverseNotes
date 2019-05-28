package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import java.util.LinkedList;

public final class bau extends a {
    public String Desc;
    public String Id;
    public String Title;
    public String Url;
    public int cNE;
    public int cuu;
    public String cvZ;
    public int jCt;
    public boolean qFG;
    public int rEd;
    public String rik;
    public int wEG;
    public String wEH;
    public int wEI;
    public int wEJ;
    public baw wEK;
    public String wEL;
    public int wEM;
    public int wEN;
    public String wEO;
    public String wEP;
    public String wEQ;
    public String wER;
    public String wES;
    public int wET;
    public long wEU;
    public String wEV;
    public String wEW;
    public int wEX;
    public String wEY;
    public String wEZ;
    public int wFa;
    public String wFb;
    public String wFc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94539);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            aVar.iz(2, this.jCt);
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            aVar.iz(5, this.wEG);
            if (this.wEH != null) {
                aVar.e(6, this.wEH);
            }
            aVar.iz(7, this.wEI);
            aVar.iz(8, this.wEJ);
            if (this.Title != null) {
                aVar.e(9, this.Title);
            }
            if (this.wEK != null) {
                aVar.iy(10, this.wEK.computeSize());
                this.wEK.writeFields(aVar);
            }
            if (this.wEL != null) {
                aVar.e(11, this.wEL);
            }
            aVar.iz(12, this.wEM);
            aVar.iz(13, this.cNE);
            aVar.iz(14, this.wEN);
            if (this.rik != null) {
                aVar.e(15, this.rik);
            }
            aVar.iz(16, this.cuu);
            if (this.cvZ != null) {
                aVar.e(17, this.cvZ);
            }
            if (this.wEO != null) {
                aVar.e(18, this.wEO);
            }
            if (this.wEP != null) {
                aVar.e(19, this.wEP);
            }
            if (this.wEQ != null) {
                aVar.e(20, this.wEQ);
            }
            aVar.iz(21, this.rEd);
            if (this.wER != null) {
                aVar.e(22, this.wER);
            }
            if (this.wES != null) {
                aVar.e(23, this.wES);
            }
            aVar.iz(24, this.wET);
            aVar.ai(25, this.wEU);
            if (this.wEV != null) {
                aVar.e(26, this.wEV);
            }
            if (this.wEW != null) {
                aVar.e(27, this.wEW);
            }
            aVar.iz(28, this.wEX);
            if (this.wEY != null) {
                aVar.e(29, this.wEY);
            }
            if (this.wEZ != null) {
                aVar.e(30, this.wEZ);
            }
            aVar.iz(31, this.wFa);
            if (this.wFb != null) {
                aVar.e(32, this.wFb);
            }
            if (this.wFc != null) {
                aVar.e(33, this.wFc);
            }
            aVar.aO(34, this.qFG);
            AppMethodBeat.o(94539);
            return 0;
        } else if (i == 1) {
            if (this.Id != null) {
                f = e.a.a.b.b.a.f(1, this.Id) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.jCt);
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(4, this.Url);
            }
            f += e.a.a.b.b.a.bs(5, this.wEG);
            if (this.wEH != null) {
                f += e.a.a.b.b.a.f(6, this.wEH);
            }
            f = (f + e.a.a.b.b.a.bs(7, this.wEI)) + e.a.a.b.b.a.bs(8, this.wEJ);
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(9, this.Title);
            }
            if (this.wEK != null) {
                f += e.a.a.a.ix(10, this.wEK.computeSize());
            }
            if (this.wEL != null) {
                f += e.a.a.b.b.a.f(11, this.wEL);
            }
            f = ((f + e.a.a.b.b.a.bs(12, this.wEM)) + e.a.a.b.b.a.bs(13, this.cNE)) + e.a.a.b.b.a.bs(14, this.wEN);
            if (this.rik != null) {
                f += e.a.a.b.b.a.f(15, this.rik);
            }
            f += e.a.a.b.b.a.bs(16, this.cuu);
            if (this.cvZ != null) {
                f += e.a.a.b.b.a.f(17, this.cvZ);
            }
            if (this.wEO != null) {
                f += e.a.a.b.b.a.f(18, this.wEO);
            }
            if (this.wEP != null) {
                f += e.a.a.b.b.a.f(19, this.wEP);
            }
            if (this.wEQ != null) {
                f += e.a.a.b.b.a.f(20, this.wEQ);
            }
            f += e.a.a.b.b.a.bs(21, this.rEd);
            if (this.wER != null) {
                f += e.a.a.b.b.a.f(22, this.wER);
            }
            if (this.wES != null) {
                f += e.a.a.b.b.a.f(23, this.wES);
            }
            f = (f + e.a.a.b.b.a.bs(24, this.wET)) + e.a.a.b.b.a.o(25, this.wEU);
            if (this.wEV != null) {
                f += e.a.a.b.b.a.f(26, this.wEV);
            }
            if (this.wEW != null) {
                f += e.a.a.b.b.a.f(27, this.wEW);
            }
            f += e.a.a.b.b.a.bs(28, this.wEX);
            if (this.wEY != null) {
                f += e.a.a.b.b.a.f(29, this.wEY);
            }
            if (this.wEZ != null) {
                f += e.a.a.b.b.a.f(30, this.wEZ);
            }
            f += e.a.a.b.b.a.bs(31, this.wFa);
            if (this.wFb != null) {
                f += e.a.a.b.b.a.f(32, this.wFb);
            }
            if (this.wFc != null) {
                f += e.a.a.b.b.a.f(33, this.wFc);
            }
            int fv = f + (e.a.a.b.b.a.fv(34) + 1);
            AppMethodBeat.o(94539);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94539);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bau bau = (bau) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bau.Id = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 2:
                    bau.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 3:
                    bau.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 4:
                    bau.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 5:
                    bau.wEG = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 6:
                    bau.wEH = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 7:
                    bau.wEI = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 8:
                    bau.wEJ = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 9:
                    bau.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 10:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        baw baw = new baw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baw.populateBuilderWithField(aVar4, baw, a.getNextFieldNumber(aVar4))) {
                        }
                        bau.wEK = baw;
                    }
                    AppMethodBeat.o(94539);
                    return 0;
                case 11:
                    bau.wEL = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 12:
                    bau.wEM = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 13:
                    bau.cNE = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 14:
                    bau.wEN = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 15:
                    bau.rik = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 16:
                    bau.cuu = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 17:
                    bau.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 18:
                    bau.wEO = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 19:
                    bau.wEP = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 20:
                    bau.wEQ = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 21:
                    bau.rEd = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 22:
                    bau.wER = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 23:
                    bau.wES = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 24:
                    bau.wET = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 25:
                    bau.wEU = aVar3.BTU.ve();
                    AppMethodBeat.o(94539);
                    return 0;
                case 26:
                    bau.wEV = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 27:
                    bau.wEW = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bau.wEX = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 29:
                    bau.wEY = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 30:
                    bau.wEZ = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 31:
                    bau.wFa = aVar3.BTU.vd();
                    AppMethodBeat.o(94539);
                    return 0;
                case 32:
                    bau.wFb = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 33:
                    bau.wFc = aVar3.BTU.readString();
                    AppMethodBeat.o(94539);
                    return 0;
                case 34:
                    bau.qFG = aVar3.BTU.ehX();
                    AppMethodBeat.o(94539);
                    return 0;
                default:
                    AppMethodBeat.o(94539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94539);
            return -1;
        }
    }
}
