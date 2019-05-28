package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ack extends a {
    public String jBB;
    public int pcX;
    public int vAR;
    public String vEA;
    public String vEy;
    public String wkf;
    public String wkg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51020);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEy != null) {
                aVar.e(1, this.vEy);
            }
            aVar.iz(2, this.pcX);
            aVar.iz(3, this.vAR);
            if (this.vEA != null) {
                aVar.e(4, this.vEA);
            }
            if (this.wkf != null) {
                aVar.e(5, this.wkf);
            }
            if (this.jBB != null) {
                aVar.e(6, this.jBB);
            }
            if (this.wkg != null) {
                aVar.e(7, this.wkg);
            }
            AppMethodBeat.o(51020);
            return 0;
        } else if (i == 1) {
            if (this.vEy != null) {
                f = e.a.a.b.b.a.f(1, this.vEy) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.pcX)) + e.a.a.b.b.a.bs(3, this.vAR);
            if (this.vEA != null) {
                f += e.a.a.b.b.a.f(4, this.vEA);
            }
            if (this.wkf != null) {
                f += e.a.a.b.b.a.f(5, this.wkf);
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(6, this.jBB);
            }
            if (this.wkg != null) {
                f += e.a.a.b.b.a.f(7, this.wkg);
            }
            AppMethodBeat.o(51020);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51020);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ack ack = (ack) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ack.vEy = aVar3.BTU.readString();
                    AppMethodBeat.o(51020);
                    return 0;
                case 2:
                    ack.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(51020);
                    return 0;
                case 3:
                    ack.vAR = aVar3.BTU.vd();
                    AppMethodBeat.o(51020);
                    return 0;
                case 4:
                    ack.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(51020);
                    return 0;
                case 5:
                    ack.wkf = aVar3.BTU.readString();
                    AppMethodBeat.o(51020);
                    return 0;
                case 6:
                    ack.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(51020);
                    return 0;
                case 7:
                    ack.wkg = aVar3.BTU.readString();
                    AppMethodBeat.o(51020);
                    return 0;
                default:
                    AppMethodBeat.o(51020);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51020);
            return -1;
        }
    }
}
