package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cot extends bsr {
    public int vZF;
    public long wOP;
    public int wOQ;
    public String xmv;
    public b xmw;
    public b xmx;
    public String xmy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135447);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xmv == null) {
                bVar = new e.a.a.b("Not all required fields were included: ToBizUserName");
                AppMethodBeat.o(135447);
                throw bVar;
            } else if (this.xmx == null) {
                bVar = new e.a.a.b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(135447);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.iz(2, this.wOQ);
                if (this.xmv != null) {
                    aVar.e(3, this.xmv);
                }
                aVar.iz(4, this.vZF);
                if (this.xmw != null) {
                    aVar.c(5, this.xmw);
                }
                if (this.xmx != null) {
                    aVar.c(6, this.xmx);
                }
                aVar.ai(7, this.wOP);
                if (this.xmy != null) {
                    aVar.e(8, this.xmy);
                }
                AppMethodBeat.o(135447);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wOQ);
            if (this.xmv != null) {
                ix += e.a.a.b.b.a.f(3, this.xmv);
            }
            ix += e.a.a.b.b.a.bs(4, this.vZF);
            if (this.xmw != null) {
                ix += e.a.a.b.b.a.b(5, this.xmw);
            }
            if (this.xmx != null) {
                ix += e.a.a.b.b.a.b(6, this.xmx);
            }
            ix += e.a.a.b.b.a.o(7, this.wOP);
            if (this.xmy != null) {
                ix += e.a.a.b.b.a.f(8, this.xmy);
            }
            AppMethodBeat.o(135447);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xmv == null) {
                bVar = new e.a.a.b("Not all required fields were included: ToBizUserName");
                AppMethodBeat.o(135447);
                throw bVar;
            } else if (this.xmx == null) {
                bVar = new e.a.a.b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(135447);
                throw bVar;
            } else {
                AppMethodBeat.o(135447);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cot cot = (cot) objArr[1];
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
                        cot.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(135447);
                    return 0;
                case 2:
                    cot.wOQ = aVar3.BTU.vd();
                    AppMethodBeat.o(135447);
                    return 0;
                case 3:
                    cot.xmv = aVar3.BTU.readString();
                    AppMethodBeat.o(135447);
                    return 0;
                case 4:
                    cot.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(135447);
                    return 0;
                case 5:
                    cot.xmw = aVar3.BTU.emu();
                    AppMethodBeat.o(135447);
                    return 0;
                case 6:
                    cot.xmx = aVar3.BTU.emu();
                    AppMethodBeat.o(135447);
                    return 0;
                case 7:
                    cot.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(135447);
                    return 0;
                case 8:
                    cot.xmy = aVar3.BTU.readString();
                    AppMethodBeat.o(135447);
                    return 0;
                default:
                    AppMethodBeat.o(135447);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135447);
            return -1;
        }
    }
}
