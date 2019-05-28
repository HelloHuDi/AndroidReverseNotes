package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cdd extends a {
    public int fQh;
    public int fQi;
    public int fQj;
    public int fQk;
    public int opType;
    public long timeStamp;
    public String xcN;
    public String xcO;
    public String xcP;
    public String xcQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94628);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xcN == null) {
                bVar = new b("Not all required fields were included: StatusDesc1");
                AppMethodBeat.o(94628);
                throw bVar;
            } else if (this.xcO == null) {
                bVar = new b("Not all required fields were included: StatusDesc2");
                AppMethodBeat.o(94628);
                throw bVar;
            } else if (this.xcP == null) {
                bVar = new b("Not all required fields were included: DataFlowSourceInfo");
                AppMethodBeat.o(94628);
                throw bVar;
            } else if (this.xcQ == null) {
                bVar = new b("Not all required fields were included: DataFlowResultInfo");
                AppMethodBeat.o(94628);
                throw bVar;
            } else {
                aVar.iz(1, this.opType);
                aVar.iz(2, this.fQk);
                aVar.iz(3, this.fQh);
                aVar.ai(4, this.timeStamp);
                aVar.iz(5, this.fQi);
                aVar.iz(6, this.fQj);
                if (this.xcN != null) {
                    aVar.e(7, this.xcN);
                }
                if (this.xcO != null) {
                    aVar.e(8, this.xcO);
                }
                if (this.xcP != null) {
                    aVar.e(9, this.xcP);
                }
                if (this.xcQ != null) {
                    aVar.e(10, this.xcQ);
                }
                AppMethodBeat.o(94628);
                return 0;
            }
        } else if (i == 1) {
            bs = (((((e.a.a.b.b.a.bs(1, this.opType) + 0) + e.a.a.b.b.a.bs(2, this.fQk)) + e.a.a.b.b.a.bs(3, this.fQh)) + e.a.a.b.b.a.o(4, this.timeStamp)) + e.a.a.b.b.a.bs(5, this.fQi)) + e.a.a.b.b.a.bs(6, this.fQj);
            if (this.xcN != null) {
                bs += e.a.a.b.b.a.f(7, this.xcN);
            }
            if (this.xcO != null) {
                bs += e.a.a.b.b.a.f(8, this.xcO);
            }
            if (this.xcP != null) {
                bs += e.a.a.b.b.a.f(9, this.xcP);
            }
            if (this.xcQ != null) {
                bs += e.a.a.b.b.a.f(10, this.xcQ);
            }
            AppMethodBeat.o(94628);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xcN == null) {
                bVar = new b("Not all required fields were included: StatusDesc1");
                AppMethodBeat.o(94628);
                throw bVar;
            } else if (this.xcO == null) {
                bVar = new b("Not all required fields were included: StatusDesc2");
                AppMethodBeat.o(94628);
                throw bVar;
            } else if (this.xcP == null) {
                bVar = new b("Not all required fields were included: DataFlowSourceInfo");
                AppMethodBeat.o(94628);
                throw bVar;
            } else if (this.xcQ == null) {
                bVar = new b("Not all required fields were included: DataFlowResultInfo");
                AppMethodBeat.o(94628);
                throw bVar;
            } else {
                AppMethodBeat.o(94628);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdd cdd = (cdd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdd.opType = aVar3.BTU.vd();
                    AppMethodBeat.o(94628);
                    return 0;
                case 2:
                    cdd.fQk = aVar3.BTU.vd();
                    AppMethodBeat.o(94628);
                    return 0;
                case 3:
                    cdd.fQh = aVar3.BTU.vd();
                    AppMethodBeat.o(94628);
                    return 0;
                case 4:
                    cdd.timeStamp = aVar3.BTU.ve();
                    AppMethodBeat.o(94628);
                    return 0;
                case 5:
                    cdd.fQi = aVar3.BTU.vd();
                    AppMethodBeat.o(94628);
                    return 0;
                case 6:
                    cdd.fQj = aVar3.BTU.vd();
                    AppMethodBeat.o(94628);
                    return 0;
                case 7:
                    cdd.xcN = aVar3.BTU.readString();
                    AppMethodBeat.o(94628);
                    return 0;
                case 8:
                    cdd.xcO = aVar3.BTU.readString();
                    AppMethodBeat.o(94628);
                    return 0;
                case 9:
                    cdd.xcP = aVar3.BTU.readString();
                    AppMethodBeat.o(94628);
                    return 0;
                case 10:
                    cdd.xcQ = aVar3.BTU.readString();
                    AppMethodBeat.o(94628);
                    return 0;
                default:
                    AppMethodBeat.o(94628);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94628);
            return -1;
        }
    }
}
