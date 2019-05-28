package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lu extends bsr {
    public int cIb;
    public String jSY;
    public String nickname;
    public int pOA;
    public String pPT;
    public String pPU;
    public String pPW;
    public int pPY;
    public String pPZ;
    public String pPw;
    public String pQa;
    public String rOh;
    public int scene;
    public abv vFe;
    public String vFf;
    public int vFg;
    public String vPj;
    public String vPp;
    public String vPq;
    public String vPr;
    public int vPs;
    public boolean vPt;
    public boolean vPu;
    public String vPv;
    public int vPw;
    public String vPx;
    public int vPy;
    public int vPz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56724);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vPp == null) {
                bVar = new b("Not all required fields were included: qrcode_id");
                AppMethodBeat.o(56724);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.pPZ != null) {
                aVar.e(2, this.pPZ);
            }
            if (this.vPp != null) {
                aVar.e(3, this.vPp);
            }
            aVar.iz(4, this.scene);
            if (this.vPq != null) {
                aVar.e(5, this.vPq);
            }
            if (this.pPT != null) {
                aVar.e(6, this.pPT);
            }
            aVar.iz(7, this.vFg);
            aVar.iz(8, this.cIb);
            if (this.pQa != null) {
                aVar.e(9, this.pQa);
            }
            if (this.pPU != null) {
                aVar.e(10, this.pPU);
            }
            if (this.vPr != null) {
                aVar.e(11, this.vPr);
            }
            aVar.iz(12, this.vPs);
            aVar.iz(13, this.pPY);
            if (this.vFf != null) {
                aVar.e(14, this.vFf);
            }
            if (this.vFe != null) {
                aVar.iy(15, this.vFe.computeSize());
                this.vFe.writeFields(aVar);
            }
            if (this.vPj != null) {
                aVar.e(16, this.vPj);
            }
            aVar.iz(17, this.pOA);
            aVar.aO(18, this.vPt);
            aVar.aO(19, this.vPu);
            if (this.rOh != null) {
                aVar.e(20, this.rOh);
            }
            if (this.jSY != null) {
                aVar.e(21, this.jSY);
            }
            if (this.vPv != null) {
                aVar.e(22, this.vPv);
            }
            if (this.pPW != null) {
                aVar.e(23, this.pPW);
            }
            if (this.nickname != null) {
                aVar.e(24, this.nickname);
            }
            if (this.pPw != null) {
                aVar.e(25, this.pPw);
            }
            aVar.iz(26, this.vPw);
            if (this.vPx != null) {
                aVar.e(27, this.vPx);
            }
            aVar.iz(28, this.vPy);
            aVar.iz(29, this.vPz);
            AppMethodBeat.o(56724);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.pPZ != null) {
                ix += e.a.a.b.b.a.f(2, this.pPZ);
            }
            if (this.vPp != null) {
                ix += e.a.a.b.b.a.f(3, this.vPp);
            }
            ix += e.a.a.b.b.a.bs(4, this.scene);
            if (this.vPq != null) {
                ix += e.a.a.b.b.a.f(5, this.vPq);
            }
            if (this.pPT != null) {
                ix += e.a.a.b.b.a.f(6, this.pPT);
            }
            ix = (ix + e.a.a.b.b.a.bs(7, this.vFg)) + e.a.a.b.b.a.bs(8, this.cIb);
            if (this.pQa != null) {
                ix += e.a.a.b.b.a.f(9, this.pQa);
            }
            if (this.pPU != null) {
                ix += e.a.a.b.b.a.f(10, this.pPU);
            }
            if (this.vPr != null) {
                ix += e.a.a.b.b.a.f(11, this.vPr);
            }
            ix = (ix + e.a.a.b.b.a.bs(12, this.vPs)) + e.a.a.b.b.a.bs(13, this.pPY);
            if (this.vFf != null) {
                ix += e.a.a.b.b.a.f(14, this.vFf);
            }
            if (this.vFe != null) {
                ix += e.a.a.a.ix(15, this.vFe.computeSize());
            }
            if (this.vPj != null) {
                ix += e.a.a.b.b.a.f(16, this.vPj);
            }
            ix = ((ix + e.a.a.b.b.a.bs(17, this.pOA)) + (e.a.a.b.b.a.fv(18) + 1)) + (e.a.a.b.b.a.fv(19) + 1);
            if (this.rOh != null) {
                ix += e.a.a.b.b.a.f(20, this.rOh);
            }
            if (this.jSY != null) {
                ix += e.a.a.b.b.a.f(21, this.jSY);
            }
            if (this.vPv != null) {
                ix += e.a.a.b.b.a.f(22, this.vPv);
            }
            if (this.pPW != null) {
                ix += e.a.a.b.b.a.f(23, this.pPW);
            }
            if (this.nickname != null) {
                ix += e.a.a.b.b.a.f(24, this.nickname);
            }
            if (this.pPw != null) {
                ix += e.a.a.b.b.a.f(25, this.pPw);
            }
            ix += e.a.a.b.b.a.bs(26, this.vPw);
            if (this.vPx != null) {
                ix += e.a.a.b.b.a.f(27, this.vPx);
            }
            int bs = (ix + e.a.a.b.b.a.bs(28, this.vPy)) + e.a.a.b.b.a.bs(29, this.vPz);
            AppMethodBeat.o(56724);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vPp == null) {
                bVar = new b("Not all required fields were included: qrcode_id");
                AppMethodBeat.o(56724);
                throw bVar;
            }
            AppMethodBeat.o(56724);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lu luVar = (lu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        luVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56724);
                    return 0;
                case 2:
                    luVar.pPZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 3:
                    luVar.vPp = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 4:
                    luVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 5:
                    luVar.vPq = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 6:
                    luVar.pPT = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 7:
                    luVar.vFg = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 8:
                    luVar.cIb = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 9:
                    luVar.pQa = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 10:
                    luVar.pPU = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 11:
                    luVar.vPr = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 12:
                    luVar.vPs = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 13:
                    luVar.pPY = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 14:
                    luVar.vFf = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abv abv = new abv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abv.populateBuilderWithField(aVar4, abv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        luVar.vFe = abv;
                    }
                    AppMethodBeat.o(56724);
                    return 0;
                case 16:
                    luVar.vPj = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 17:
                    luVar.pOA = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 18:
                    luVar.vPt = aVar3.BTU.ehX();
                    AppMethodBeat.o(56724);
                    return 0;
                case 19:
                    luVar.vPu = aVar3.BTU.ehX();
                    AppMethodBeat.o(56724);
                    return 0;
                case 20:
                    luVar.rOh = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 21:
                    luVar.jSY = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 22:
                    luVar.vPv = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 23:
                    luVar.pPW = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 24:
                    luVar.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 25:
                    luVar.pPw = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case 26:
                    luVar.vPw = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 27:
                    luVar.vPx = aVar3.BTU.readString();
                    AppMethodBeat.o(56724);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    luVar.vPy = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                case 29:
                    luVar.vPz = aVar3.BTU.vd();
                    AppMethodBeat.o(56724);
                    return 0;
                default:
                    AppMethodBeat.o(56724);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56724);
            return -1;
        }
    }
}
