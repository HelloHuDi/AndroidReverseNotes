package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cou extends btd {
    public int nwF;
    public int nwL;
    public int nwM;
    public int nwQ;
    public LinkedList<coo> vIO = new LinkedList();
    public b wPf;
    public long wen;
    public int xdw;
    public long xeF;
    public int xmA;
    public int xmB;
    public LinkedList<coo> xmC = new LinkedList();
    public int xmz;

    public cou() {
        AppMethodBeat.i(135448);
        AppMethodBeat.o(135448);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135449);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(135449);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.ai(2, this.xeF);
            aVar.ai(3, this.wen);
            aVar.e(4, 8, this.vIO);
            aVar.iz(5, this.xdw);
            aVar.iz(6, this.nwL);
            aVar.iz(7, this.nwM);
            aVar.iz(8, this.nwF);
            aVar.iz(9, this.nwQ);
            aVar.iz(10, this.xmz);
            aVar.iz(11, this.xmA);
            if (this.wPf != null) {
                aVar.c(12, this.wPf);
            }
            aVar.iz(13, this.xmB);
            aVar.e(14, 8, this.xmC);
            AppMethodBeat.o(135449);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((((((ix + e.a.a.b.b.a.o(2, this.xeF)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.a.c(4, 8, this.vIO)) + e.a.a.b.b.a.bs(5, this.xdw)) + e.a.a.b.b.a.bs(6, this.nwL)) + e.a.a.b.b.a.bs(7, this.nwM)) + e.a.a.b.b.a.bs(8, this.nwF)) + e.a.a.b.b.a.bs(9, this.nwQ)) + e.a.a.b.b.a.bs(10, this.xmz)) + e.a.a.b.b.a.bs(11, this.xmA);
            if (this.wPf != null) {
                ix += e.a.a.b.b.a.b(12, this.wPf);
            }
            int bs = (ix + e.a.a.b.b.a.bs(13, this.xmB)) + e.a.a.a.c(14, 8, this.xmC);
            AppMethodBeat.o(135449);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            this.xmC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(135449);
                throw bVar;
            }
            AppMethodBeat.o(135449);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cou cou = (cou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            coo coo;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cou.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(135449);
                    return 0;
                case 2:
                    cou.xeF = aVar3.BTU.ve();
                    AppMethodBeat.o(135449);
                    return 0;
                case 3:
                    cou.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(135449);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coo = new coo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coo.populateBuilderWithField(aVar4, coo, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cou.vIO.add(coo);
                    }
                    AppMethodBeat.o(135449);
                    return 0;
                case 5:
                    cou.xdw = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 6:
                    cou.nwL = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 7:
                    cou.nwM = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 8:
                    cou.nwF = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 9:
                    cou.nwQ = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 10:
                    cou.xmz = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 11:
                    cou.xmA = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 12:
                    cou.wPf = aVar3.BTU.emu();
                    AppMethodBeat.o(135449);
                    return 0;
                case 13:
                    cou.xmB = aVar3.BTU.vd();
                    AppMethodBeat.o(135449);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coo = new coo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coo.populateBuilderWithField(aVar4, coo, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cou.xmC.add(coo);
                    }
                    AppMethodBeat.o(135449);
                    return 0;
                default:
                    AppMethodBeat.o(135449);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135449);
            return -1;
        }
    }
}
