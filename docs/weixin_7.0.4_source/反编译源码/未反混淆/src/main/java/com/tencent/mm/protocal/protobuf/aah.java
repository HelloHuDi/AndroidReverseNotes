package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aah extends bsr {
    public String csB;
    public int cvd;
    public int lSN;
    public float wfA;
    public int wfB;
    public String wfo;
    public long wfw;
    public String wfx;
    public String wfy;
    public int wfz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(841);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            aVar.ai(3, this.wfw);
            if (this.wfo != null) {
                aVar.e(4, this.wfo);
            }
            if (this.wfx != null) {
                aVar.e(5, this.wfx);
            }
            if (this.wfy != null) {
                aVar.e(6, this.wfy);
            }
            aVar.iz(7, this.cvd);
            aVar.iz(8, this.wfz);
            aVar.iz(9, this.lSN);
            aVar.r(10, this.wfA);
            aVar.iz(11, this.wfB);
            AppMethodBeat.o(841);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(2, this.csB);
            }
            ix += e.a.a.b.b.a.o(3, this.wfw);
            if (this.wfo != null) {
                ix += e.a.a.b.b.a.f(4, this.wfo);
            }
            if (this.wfx != null) {
                ix += e.a.a.b.b.a.f(5, this.wfx);
            }
            if (this.wfy != null) {
                ix += e.a.a.b.b.a.f(6, this.wfy);
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(7, this.cvd)) + e.a.a.b.b.a.bs(8, this.wfz)) + e.a.a.b.b.a.bs(9, this.lSN)) + (e.a.a.b.b.a.fv(10) + 4)) + e.a.a.b.b.a.bs(11, this.wfB);
            AppMethodBeat.o(841);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(841);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aah aah = (aah) objArr[1];
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
                        aah.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(841);
                    return 0;
                case 2:
                    aah.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(841);
                    return 0;
                case 3:
                    aah.wfw = aVar3.BTU.ve();
                    AppMethodBeat.o(841);
                    return 0;
                case 4:
                    aah.wfo = aVar3.BTU.readString();
                    AppMethodBeat.o(841);
                    return 0;
                case 5:
                    aah.wfx = aVar3.BTU.readString();
                    AppMethodBeat.o(841);
                    return 0;
                case 6:
                    aah.wfy = aVar3.BTU.readString();
                    AppMethodBeat.o(841);
                    return 0;
                case 7:
                    aah.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(841);
                    return 0;
                case 8:
                    aah.wfz = aVar3.BTU.vd();
                    AppMethodBeat.o(841);
                    return 0;
                case 9:
                    aah.lSN = aVar3.BTU.vd();
                    AppMethodBeat.o(841);
                    return 0;
                case 10:
                    aah.wfA = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(841);
                    return 0;
                case 11:
                    aah.wfB = aVar3.BTU.vd();
                    AppMethodBeat.o(841);
                    return 0;
                default:
                    AppMethodBeat.o(841);
                    return -1;
            }
        } else {
            AppMethodBeat.o(841);
            return -1;
        }
    }
}
