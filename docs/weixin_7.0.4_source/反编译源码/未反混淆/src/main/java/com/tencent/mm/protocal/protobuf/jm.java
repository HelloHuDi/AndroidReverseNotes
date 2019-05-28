package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jm extends bsr {
    public int vIJ;
    public int vLk;
    public String vLl;
    public String vLm;
    public String vLn;
    public String vLo;
    public String vLp;
    public String vLq;
    public String vLr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73693);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vIJ);
            aVar.iz(3, this.vLk);
            if (this.vLl != null) {
                aVar.e(4, this.vLl);
            }
            if (this.vLm != null) {
                aVar.e(5, this.vLm);
            }
            if (this.vLn != null) {
                aVar.e(6, this.vLn);
            }
            if (this.vLo != null) {
                aVar.e(7, this.vLo);
            }
            if (this.vLp != null) {
                aVar.e(8, this.vLp);
            }
            if (this.vLq != null) {
                aVar.e(9, this.vLq);
            }
            if (this.vLr != null) {
                aVar.e(10, this.vLr);
            }
            AppMethodBeat.o(73693);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vIJ)) + e.a.a.b.b.a.bs(3, this.vLk);
            if (this.vLl != null) {
                ix += e.a.a.b.b.a.f(4, this.vLl);
            }
            if (this.vLm != null) {
                ix += e.a.a.b.b.a.f(5, this.vLm);
            }
            if (this.vLn != null) {
                ix += e.a.a.b.b.a.f(6, this.vLn);
            }
            if (this.vLo != null) {
                ix += e.a.a.b.b.a.f(7, this.vLo);
            }
            if (this.vLp != null) {
                ix += e.a.a.b.b.a.f(8, this.vLp);
            }
            if (this.vLq != null) {
                ix += e.a.a.b.b.a.f(9, this.vLq);
            }
            if (this.vLr != null) {
                ix += e.a.a.b.b.a.f(10, this.vLr);
            }
            AppMethodBeat.o(73693);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73693);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jm jmVar = (jm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jmVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73693);
                    return 0;
                case 2:
                    jmVar.vIJ = aVar3.BTU.vd();
                    AppMethodBeat.o(73693);
                    return 0;
                case 3:
                    jmVar.vLk = aVar3.BTU.vd();
                    AppMethodBeat.o(73693);
                    return 0;
                case 4:
                    jmVar.vLl = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                case 5:
                    jmVar.vLm = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                case 6:
                    jmVar.vLn = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                case 7:
                    jmVar.vLo = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                case 8:
                    jmVar.vLp = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                case 9:
                    jmVar.vLq = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                case 10:
                    jmVar.vLr = aVar3.BTU.readString();
                    AppMethodBeat.o(73693);
                    return 0;
                default:
                    AppMethodBeat.o(73693);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73693);
            return -1;
        }
    }
}
