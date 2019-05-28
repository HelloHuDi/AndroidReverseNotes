package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmh extends bsr {
    public int jBT;
    public String ndG;
    public long wOP;
    public long wOS;
    public int wem;
    public long wen;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28591);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ndG == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(28591);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ndG != null) {
                aVar.e(2, this.ndG);
            }
            aVar.iz(3, this.wem);
            aVar.ai(4, this.wen);
            aVar.ai(5, this.wOP);
            aVar.ai(6, this.wOS);
            aVar.iz(7, this.jBT);
            AppMethodBeat.o(28591);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(2, this.ndG);
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(3, this.wem)) + e.a.a.b.b.a.o(4, this.wen)) + e.a.a.b.b.a.o(5, this.wOP)) + e.a.a.b.b.a.o(6, this.wOS)) + e.a.a.b.b.a.bs(7, this.jBT);
            AppMethodBeat.o(28591);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.ndG == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(28591);
                throw bVar;
            }
            AppMethodBeat.o(28591);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmh bmh = (bmh) objArr[1];
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
                        bmh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28591);
                    return 0;
                case 2:
                    bmh.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28591);
                    return 0;
                case 3:
                    bmh.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28591);
                    return 0;
                case 4:
                    bmh.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28591);
                    return 0;
                case 5:
                    bmh.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(28591);
                    return 0;
                case 6:
                    bmh.wOS = aVar3.BTU.ve();
                    AppMethodBeat.o(28591);
                    return 0;
                case 7:
                    bmh.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(28591);
                    return 0;
                default:
                    AppMethodBeat.o(28591);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28591);
            return -1;
        }
    }
}
