package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anm extends bsr {
    public float cEB;
    public float cGm;
    public long rUb;
    public int wsn;
    public LinkedList<b> wso = new LinkedList();

    public anm() {
        AppMethodBeat.i(108894);
        AppMethodBeat.o(108894);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108895);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wsn);
            aVar.r(3, this.cEB);
            aVar.r(4, this.cGm);
            aVar.e(5, 6, this.wso);
            aVar.ai(6, this.rUb);
            AppMethodBeat.o(108895);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(2, this.wsn)) + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4)) + e.a.a.a.c(5, 6, this.wso)) + e.a.a.b.b.a.o(6, this.rUb);
            AppMethodBeat.o(108895);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wso.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(108895);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anm anm = (anm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anm.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(108895);
                    return 0;
                case 2:
                    anm.wsn = aVar3.BTU.vd();
                    AppMethodBeat.o(108895);
                    return 0;
                case 3:
                    anm.cEB = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(108895);
                    return 0;
                case 4:
                    anm.cGm = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(108895);
                    return 0;
                case 5:
                    anm.wso.add(aVar3.BTU.emu());
                    AppMethodBeat.o(108895);
                    return 0;
                case 6:
                    anm.rUb = aVar3.BTU.ve();
                    AppMethodBeat.o(108895);
                    return 0;
                default:
                    AppMethodBeat.o(108895);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108895);
            return -1;
        }
    }
}
