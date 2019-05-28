package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cmk extends a {
    public String IconUrl;
    public String jBF;
    public String ncH;
    public String vIk;
    public String wLX;
    public String wbq;
    public String wwn;
    public long xkn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28694);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wbq != null) {
                aVar.e(1, this.wbq);
            }
            if (this.vIk != null) {
                aVar.e(2, this.vIk);
            }
            if (this.wLX != null) {
                aVar.e(3, this.wLX);
            }
            if (this.ncH != null) {
                aVar.e(4, this.ncH);
            }
            if (this.jBF != null) {
                aVar.e(5, this.jBF);
            }
            if (this.IconUrl != null) {
                aVar.e(6, this.IconUrl);
            }
            if (this.wwn != null) {
                aVar.e(7, this.wwn);
            }
            aVar.ai(8, this.xkn);
            AppMethodBeat.o(28694);
            return 0;
        } else if (i == 1) {
            if (this.wbq != null) {
                f = e.a.a.b.b.a.f(1, this.wbq) + 0;
            } else {
                f = 0;
            }
            if (this.vIk != null) {
                f += e.a.a.b.b.a.f(2, this.vIk);
            }
            if (this.wLX != null) {
                f += e.a.a.b.b.a.f(3, this.wLX);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(4, this.ncH);
            }
            if (this.jBF != null) {
                f += e.a.a.b.b.a.f(5, this.jBF);
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(6, this.IconUrl);
            }
            if (this.wwn != null) {
                f += e.a.a.b.b.a.f(7, this.wwn);
            }
            int o = f + e.a.a.b.b.a.o(8, this.xkn);
            AppMethodBeat.o(28694);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28694);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmk cmk = (cmk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmk.wbq = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 2:
                    cmk.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 3:
                    cmk.wLX = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 4:
                    cmk.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 5:
                    cmk.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 6:
                    cmk.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 7:
                    cmk.wwn = aVar3.BTU.readString();
                    AppMethodBeat.o(28694);
                    return 0;
                case 8:
                    cmk.xkn = aVar3.BTU.ve();
                    AppMethodBeat.o(28694);
                    return 0;
                default:
                    AppMethodBeat.o(28694);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28694);
            return -1;
        }
    }
}
