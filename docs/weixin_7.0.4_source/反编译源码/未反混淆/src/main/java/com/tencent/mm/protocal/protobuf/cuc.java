package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cuc extends a {
    public int nao;
    public String ncM;
    public long vIs;
    public long vIv;
    public String wCW;
    public String wyw;
    public boolean xqD;
    public b xqE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28740);
        e.a.a.b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wCW == null) {
                bVar = new e.a.a.b("Not all required fields were included: Nickname");
                AppMethodBeat.o(28740);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new e.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(28740);
                throw bVar;
            } else if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28740);
                throw bVar;
            } else {
                aVar.ai(1, this.vIs);
                if (this.wCW != null) {
                    aVar.e(2, this.wCW);
                }
                if (this.ncM != null) {
                    aVar.e(3, this.ncM);
                }
                aVar.iz(4, this.nao);
                if (this.wyw != null) {
                    aVar.e(5, this.wyw);
                }
                aVar.ai(6, this.vIv);
                aVar.aO(7, this.xqD);
                if (this.xqE != null) {
                    aVar.c(8, this.xqE);
                }
                AppMethodBeat.o(28740);
                return 0;
            }
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vIs) + 0;
            if (this.wCW != null) {
                o += e.a.a.b.b.a.f(2, this.wCW);
            }
            if (this.ncM != null) {
                o += e.a.a.b.b.a.f(3, this.ncM);
            }
            o += e.a.a.b.b.a.bs(4, this.nao);
            if (this.wyw != null) {
                o += e.a.a.b.b.a.f(5, this.wyw);
            }
            o = (o + e.a.a.b.b.a.o(6, this.vIv)) + (e.a.a.b.b.a.fv(7) + 1);
            if (this.xqE != null) {
                o += e.a.a.b.b.a.b(8, this.xqE);
            }
            AppMethodBeat.o(28740);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.wCW == null) {
                bVar = new e.a.a.b("Not all required fields were included: Nickname");
                AppMethodBeat.o(28740);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new e.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(28740);
                throw bVar;
            } else if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28740);
                throw bVar;
            } else {
                AppMethodBeat.o(28740);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuc cuc = (cuc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuc.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(28740);
                    return 0;
                case 2:
                    cuc.wCW = aVar3.BTU.readString();
                    AppMethodBeat.o(28740);
                    return 0;
                case 3:
                    cuc.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(28740);
                    return 0;
                case 4:
                    cuc.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(28740);
                    return 0;
                case 5:
                    cuc.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28740);
                    return 0;
                case 6:
                    cuc.vIv = aVar3.BTU.ve();
                    AppMethodBeat.o(28740);
                    return 0;
                case 7:
                    cuc.xqD = aVar3.BTU.ehX();
                    AppMethodBeat.o(28740);
                    return 0;
                case 8:
                    cuc.xqE = aVar3.BTU.emu();
                    AppMethodBeat.o(28740);
                    return 0;
                default:
                    AppMethodBeat.o(28740);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28740);
            return -1;
        }
    }
}
