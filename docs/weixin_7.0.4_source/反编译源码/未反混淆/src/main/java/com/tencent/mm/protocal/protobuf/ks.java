package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import java.util.LinkedList;

public class ks extends a {
    public int cancel;
    public long cuQ;
    public int pos;
    public String vNN;
    public LinkedList<Integer> vNO = new LinkedList();
    public int vNP;
    public int vNQ;
    public int vNR;
    public int vNS;
    public int vNT;
    public int vNU;
    public int vNV;
    public int vNW;
    public int vNX;
    public int vNY;
    public int vNZ;
    public int vNr;
    public int vOa;
    public int vOb;
    public String vOc;
    public long vOd;
    public int vOe;
    public int vOf;
    public int vOg;
    public int vOh;
    public int vOi;
    public int vOj;
    public int vOk;

    public ks() {
        AppMethodBeat.i(14714);
        AppMethodBeat.o(14714);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14715);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNN != null) {
                aVar.e(1, this.vNN);
            }
            aVar.ai(2, this.cuQ);
            aVar.iz(3, this.pos);
            aVar.e(4, 2, this.vNO);
            aVar.iz(5, this.vNP);
            aVar.iz(6, this.vNQ);
            aVar.iz(7, this.vNR);
            aVar.iz(8, this.vNS);
            aVar.iz(9, this.vNT);
            aVar.iz(10, this.vNU);
            aVar.iz(11, this.vNr);
            aVar.iz(12, this.vNV);
            aVar.iz(13, this.vNW);
            aVar.iz(14, this.cancel);
            aVar.iz(15, this.vNX);
            aVar.iz(16, this.vNY);
            aVar.iz(17, this.vNZ);
            aVar.iz(18, this.vOa);
            aVar.iz(19, this.vOb);
            if (this.vOc != null) {
                aVar.e(20, this.vOc);
            }
            aVar.ai(21, this.vOd);
            aVar.iz(22, this.vOe);
            aVar.iz(23, this.vOf);
            aVar.iz(24, this.vOg);
            aVar.iz(25, this.vOh);
            aVar.iz(26, this.vOi);
            aVar.iz(27, this.vOj);
            aVar.iz(28, this.vOk);
            AppMethodBeat.o(14715);
            return 0;
        } else if (i == 1) {
            if (this.vNN != null) {
                f = e.a.a.b.b.a.f(1, this.vNN) + 0;
            } else {
                f = 0;
            }
            f = (((((((((((((((((f + e.a.a.b.b.a.o(2, this.cuQ)) + e.a.a.b.b.a.bs(3, this.pos)) + e.a.a.a.c(4, 2, this.vNO)) + e.a.a.b.b.a.bs(5, this.vNP)) + e.a.a.b.b.a.bs(6, this.vNQ)) + e.a.a.b.b.a.bs(7, this.vNR)) + e.a.a.b.b.a.bs(8, this.vNS)) + e.a.a.b.b.a.bs(9, this.vNT)) + e.a.a.b.b.a.bs(10, this.vNU)) + e.a.a.b.b.a.bs(11, this.vNr)) + e.a.a.b.b.a.bs(12, this.vNV)) + e.a.a.b.b.a.bs(13, this.vNW)) + e.a.a.b.b.a.bs(14, this.cancel)) + e.a.a.b.b.a.bs(15, this.vNX)) + e.a.a.b.b.a.bs(16, this.vNY)) + e.a.a.b.b.a.bs(17, this.vNZ)) + e.a.a.b.b.a.bs(18, this.vOa)) + e.a.a.b.b.a.bs(19, this.vOb);
            if (this.vOc != null) {
                f += e.a.a.b.b.a.f(20, this.vOc);
            }
            int o = (((((((f + e.a.a.b.b.a.o(21, this.vOd)) + e.a.a.b.b.a.bs(22, this.vOe)) + e.a.a.b.b.a.bs(23, this.vOf)) + e.a.a.b.b.a.bs(24, this.vOg)) + e.a.a.b.b.a.bs(25, this.vOh)) + e.a.a.b.b.a.bs(26, this.vOi)) + e.a.a.b.b.a.bs(27, this.vOj)) + e.a.a.b.b.a.bs(28, this.vOk);
            AppMethodBeat.o(14715);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vNO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14715);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ks ksVar = (ks) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ksVar.vNN = aVar3.BTU.readString();
                    AppMethodBeat.o(14715);
                    return 0;
                case 2:
                    ksVar.cuQ = aVar3.BTU.ve();
                    AppMethodBeat.o(14715);
                    return 0;
                case 3:
                    ksVar.pos = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 4:
                    ksVar.vNO.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(14715);
                    return 0;
                case 5:
                    ksVar.vNP = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 6:
                    ksVar.vNQ = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 7:
                    ksVar.vNR = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 8:
                    ksVar.vNS = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 9:
                    ksVar.vNT = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 10:
                    ksVar.vNU = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 11:
                    ksVar.vNr = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 12:
                    ksVar.vNV = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 13:
                    ksVar.vNW = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 14:
                    ksVar.cancel = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 15:
                    ksVar.vNX = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 16:
                    ksVar.vNY = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 17:
                    ksVar.vNZ = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 18:
                    ksVar.vOa = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 19:
                    ksVar.vOb = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 20:
                    ksVar.vOc = aVar3.BTU.readString();
                    AppMethodBeat.o(14715);
                    return 0;
                case 21:
                    ksVar.vOd = aVar3.BTU.ve();
                    AppMethodBeat.o(14715);
                    return 0;
                case 22:
                    ksVar.vOe = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 23:
                    ksVar.vOf = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 24:
                    ksVar.vOg = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 25:
                    ksVar.vOh = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 26:
                    ksVar.vOi = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case 27:
                    ksVar.vOj = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    ksVar.vOk = aVar3.BTU.vd();
                    AppMethodBeat.o(14715);
                    return 0;
                default:
                    AppMethodBeat.o(14715);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14715);
            return -1;
        }
    }
}
