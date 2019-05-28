package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cdw extends a {
    public String cEV;
    public String clientId;
    public String content;
    public String cvF;
    public int fDG;
    public long rUJ;
    public int rVd;
    public String rVl;
    public int rVm;
    public int retryCount;
    public int state;
    public String toUser;
    public int xdD;
    public int xdE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108907);
        b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cEV == null) {
                bVar = new b("Not all required fields were included: fromUser");
                AppMethodBeat.o(108907);
                throw bVar;
            } else if (this.toUser == null) {
                bVar = new b("Not all required fields were included: toUser");
                AppMethodBeat.o(108907);
                throw bVar;
            } else {
                aVar.ai(1, this.rUJ);
                aVar.iz(2, this.fDG);
                if (this.cEV != null) {
                    aVar.e(3, this.cEV);
                }
                if (this.toUser != null) {
                    aVar.e(4, this.toUser);
                }
                if (this.content != null) {
                    aVar.e(5, this.content);
                }
                aVar.iz(6, this.state);
                if (this.clientId != null) {
                    aVar.e(7, this.clientId);
                }
                aVar.iz(8, this.rVd);
                aVar.iz(9, this.xdD);
                aVar.iz(10, this.retryCount);
                aVar.iz(11, this.xdE);
                if (this.cvF != null) {
                    aVar.e(12, this.cvF);
                }
                if (this.rVl != null) {
                    aVar.e(13, this.rVl);
                }
                aVar.iz(14, this.rVm);
                AppMethodBeat.o(108907);
                return 0;
            }
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.rUJ) + 0) + e.a.a.b.b.a.bs(2, this.fDG);
            if (this.cEV != null) {
                o += e.a.a.b.b.a.f(3, this.cEV);
            }
            if (this.toUser != null) {
                o += e.a.a.b.b.a.f(4, this.toUser);
            }
            if (this.content != null) {
                o += e.a.a.b.b.a.f(5, this.content);
            }
            o += e.a.a.b.b.a.bs(6, this.state);
            if (this.clientId != null) {
                o += e.a.a.b.b.a.f(7, this.clientId);
            }
            o = (((o + e.a.a.b.b.a.bs(8, this.rVd)) + e.a.a.b.b.a.bs(9, this.xdD)) + e.a.a.b.b.a.bs(10, this.retryCount)) + e.a.a.b.b.a.bs(11, this.xdE);
            if (this.cvF != null) {
                o += e.a.a.b.b.a.f(12, this.cvF);
            }
            if (this.rVl != null) {
                o += e.a.a.b.b.a.f(13, this.rVl);
            }
            o += e.a.a.b.b.a.bs(14, this.rVm);
            AppMethodBeat.o(108907);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.cEV == null) {
                bVar = new b("Not all required fields were included: fromUser");
                AppMethodBeat.o(108907);
                throw bVar;
            } else if (this.toUser == null) {
                bVar = new b("Not all required fields were included: toUser");
                AppMethodBeat.o(108907);
                throw bVar;
            } else {
                AppMethodBeat.o(108907);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdw cdw = (cdw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdw.rUJ = aVar3.BTU.ve();
                    AppMethodBeat.o(108907);
                    return 0;
                case 2:
                    cdw.fDG = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                case 3:
                    cdw.cEV = aVar3.BTU.readString();
                    AppMethodBeat.o(108907);
                    return 0;
                case 4:
                    cdw.toUser = aVar3.BTU.readString();
                    AppMethodBeat.o(108907);
                    return 0;
                case 5:
                    cdw.content = aVar3.BTU.readString();
                    AppMethodBeat.o(108907);
                    return 0;
                case 6:
                    cdw.state = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                case 7:
                    cdw.clientId = aVar3.BTU.readString();
                    AppMethodBeat.o(108907);
                    return 0;
                case 8:
                    cdw.rVd = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                case 9:
                    cdw.xdD = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                case 10:
                    cdw.retryCount = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                case 11:
                    cdw.xdE = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                case 12:
                    cdw.cvF = aVar3.BTU.readString();
                    AppMethodBeat.o(108907);
                    return 0;
                case 13:
                    cdw.rVl = aVar3.BTU.readString();
                    AppMethodBeat.o(108907);
                    return 0;
                case 14:
                    cdw.rVm = aVar3.BTU.vd();
                    AppMethodBeat.o(108907);
                    return 0;
                default:
                    AppMethodBeat.o(108907);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108907);
            return -1;
        }
    }
}
