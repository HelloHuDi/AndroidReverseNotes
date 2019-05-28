package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwb extends bsr {
    public String Md5;
    public String guQ;
    public int vHo;
    public int vRy;
    public dv wWQ;
    public String wWR;
    public String wWS;
    public int wWT;
    public int wdW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28629);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wWQ == null) {
                bVar = new b("Not all required fields were included: Msg");
                AppMethodBeat.o(28629);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wWQ != null) {
                aVar.iy(2, this.wWQ.computeSize());
                this.wWQ.writeFields(aVar);
            }
            if (this.wWR != null) {
                aVar.e(3, this.wWR);
            }
            aVar.iz(4, this.wdW);
            if (this.Md5 != null) {
                aVar.e(5, this.Md5);
            }
            aVar.iz(6, this.vHo);
            if (this.guQ != null) {
                aVar.e(7, this.guQ);
            }
            if (this.wWS != null) {
                aVar.e(8, this.wWS);
            }
            aVar.iz(9, this.wWT);
            aVar.iz(10, this.vRy);
            AppMethodBeat.o(28629);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wWQ != null) {
                ix += e.a.a.a.ix(2, this.wWQ.computeSize());
            }
            if (this.wWR != null) {
                ix += e.a.a.b.b.a.f(3, this.wWR);
            }
            ix += e.a.a.b.b.a.bs(4, this.wdW);
            if (this.Md5 != null) {
                ix += e.a.a.b.b.a.f(5, this.Md5);
            }
            ix += e.a.a.b.b.a.bs(6, this.vHo);
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(7, this.guQ);
            }
            if (this.wWS != null) {
                ix += e.a.a.b.b.a.f(8, this.wWS);
            }
            int bs = (ix + e.a.a.b.b.a.bs(9, this.wWT)) + e.a.a.b.b.a.bs(10, this.vRy);
            AppMethodBeat.o(28629);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wWQ == null) {
                bVar = new b("Not all required fields were included: Msg");
                AppMethodBeat.o(28629);
                throw bVar;
            }
            AppMethodBeat.o(28629);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwb bwb = (bwb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bwb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28629);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dv dvVar = new dv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dvVar.populateBuilderWithField(aVar4, dvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bwb.wWQ = dvVar;
                    }
                    AppMethodBeat.o(28629);
                    return 0;
                case 3:
                    bwb.wWR = aVar3.BTU.readString();
                    AppMethodBeat.o(28629);
                    return 0;
                case 4:
                    bwb.wdW = aVar3.BTU.vd();
                    AppMethodBeat.o(28629);
                    return 0;
                case 5:
                    bwb.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(28629);
                    return 0;
                case 6:
                    bwb.vHo = aVar3.BTU.vd();
                    AppMethodBeat.o(28629);
                    return 0;
                case 7:
                    bwb.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28629);
                    return 0;
                case 8:
                    bwb.wWS = aVar3.BTU.readString();
                    AppMethodBeat.o(28629);
                    return 0;
                case 9:
                    bwb.wWT = aVar3.BTU.vd();
                    AppMethodBeat.o(28629);
                    return 0;
                case 10:
                    bwb.vRy = aVar3.BTU.vd();
                    AppMethodBeat.o(28629);
                    return 0;
                default:
                    AppMethodBeat.o(28629);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28629);
            return -1;
        }
    }
}
