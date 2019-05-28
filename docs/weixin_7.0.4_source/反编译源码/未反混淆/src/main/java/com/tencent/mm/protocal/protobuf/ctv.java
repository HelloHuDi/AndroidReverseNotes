package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctv extends a {
    public String dFt;
    public String jBG;
    public int vFE;
    public String wbq;
    public String xqs;
    public String xqt;
    public String xqu;
    public String xqv;
    public String xqw;
    public String xqx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28732);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xqs == null) {
                bVar = new b("Not all required fields were included: LocalNodeId");
                AppMethodBeat.o(28732);
                throw bVar;
            }
            if (this.xqs != null) {
                aVar.e(1, this.xqs);
            }
            if (this.jBG != null) {
                aVar.e(2, this.jBG);
            }
            if (this.xqt != null) {
                aVar.e(3, this.xqt);
            }
            if (this.dFt != null) {
                aVar.e(4, this.dFt);
            }
            if (this.xqu != null) {
                aVar.e(5, this.xqu);
            }
            if (this.wbq != null) {
                aVar.e(6, this.wbq);
            }
            if (this.xqv != null) {
                aVar.e(7, this.xqv);
            }
            if (this.xqw != null) {
                aVar.e(8, this.xqw);
            }
            if (this.xqx != null) {
                aVar.e(9, this.xqx);
            }
            aVar.iz(10, this.vFE);
            AppMethodBeat.o(28732);
            return 0;
        } else if (i == 1) {
            if (this.xqs != null) {
                f = e.a.a.b.b.a.f(1, this.xqs) + 0;
            } else {
                f = 0;
            }
            if (this.jBG != null) {
                f += e.a.a.b.b.a.f(2, this.jBG);
            }
            if (this.xqt != null) {
                f += e.a.a.b.b.a.f(3, this.xqt);
            }
            if (this.dFt != null) {
                f += e.a.a.b.b.a.f(4, this.dFt);
            }
            if (this.xqu != null) {
                f += e.a.a.b.b.a.f(5, this.xqu);
            }
            if (this.wbq != null) {
                f += e.a.a.b.b.a.f(6, this.wbq);
            }
            if (this.xqv != null) {
                f += e.a.a.b.b.a.f(7, this.xqv);
            }
            if (this.xqw != null) {
                f += e.a.a.b.b.a.f(8, this.xqw);
            }
            if (this.xqx != null) {
                f += e.a.a.b.b.a.f(9, this.xqx);
            }
            int bs = f + e.a.a.b.b.a.bs(10, this.vFE);
            AppMethodBeat.o(28732);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xqs == null) {
                bVar = new b("Not all required fields were included: LocalNodeId");
                AppMethodBeat.o(28732);
                throw bVar;
            }
            AppMethodBeat.o(28732);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctv ctv = (ctv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctv.xqs = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 2:
                    ctv.jBG = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 3:
                    ctv.xqt = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 4:
                    ctv.dFt = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 5:
                    ctv.xqu = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 6:
                    ctv.wbq = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 7:
                    ctv.xqv = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 8:
                    ctv.xqw = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 9:
                    ctv.xqx = aVar3.BTU.readString();
                    AppMethodBeat.o(28732);
                    return 0;
                case 10:
                    ctv.vFE = aVar3.BTU.vd();
                    AppMethodBeat.o(28732);
                    return 0;
                default:
                    AppMethodBeat.o(28732);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28732);
            return -1;
        }
    }
}
