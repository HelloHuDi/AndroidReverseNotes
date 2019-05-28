package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class acq extends a {
    public String jBB;
    public String jCH;
    public String mZW;
    public int vAO;
    public String vEn;
    public String vLo;
    public String vYQ;
    public String wkr;
    public String wks;
    public String wkt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28414);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEn != null) {
                aVar.e(1, this.vEn);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.jBB != null) {
                aVar.e(3, this.jBB);
            }
            if (this.mZW != null) {
                aVar.e(4, this.mZW);
            }
            if (this.wkr != null) {
                aVar.e(5, this.wkr);
            }
            if (this.wks != null) {
                aVar.e(6, this.wks);
            }
            if (this.vLo != null) {
                aVar.e(7, this.vLo);
            }
            if (this.vYQ != null) {
                aVar.e(8, this.vYQ);
            }
            if (this.wkt != null) {
                aVar.e(9, this.wkt);
            }
            aVar.iz(10, this.vAO);
            AppMethodBeat.o(28414);
            return 0;
        } else if (i == 1) {
            if (this.vEn != null) {
                f = e.a.a.b.b.a.f(1, this.vEn) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(3, this.jBB);
            }
            if (this.mZW != null) {
                f += e.a.a.b.b.a.f(4, this.mZW);
            }
            if (this.wkr != null) {
                f += e.a.a.b.b.a.f(5, this.wkr);
            }
            if (this.wks != null) {
                f += e.a.a.b.b.a.f(6, this.wks);
            }
            if (this.vLo != null) {
                f += e.a.a.b.b.a.f(7, this.vLo);
            }
            if (this.vYQ != null) {
                f += e.a.a.b.b.a.f(8, this.vYQ);
            }
            if (this.wkt != null) {
                f += e.a.a.b.b.a.f(9, this.wkt);
            }
            int bs = f + e.a.a.b.b.a.bs(10, this.vAO);
            AppMethodBeat.o(28414);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28414);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acq acq = (acq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acq.vEn = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 2:
                    acq.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 3:
                    acq.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 4:
                    acq.mZW = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 5:
                    acq.wkr = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 6:
                    acq.wks = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 7:
                    acq.vLo = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 8:
                    acq.vYQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 9:
                    acq.wkt = aVar3.BTU.readString();
                    AppMethodBeat.o(28414);
                    return 0;
                case 10:
                    acq.vAO = aVar3.BTU.vd();
                    AppMethodBeat.o(28414);
                    return 0;
                default:
                    AppMethodBeat.o(28414);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28414);
            return -1;
        }
    }
}
