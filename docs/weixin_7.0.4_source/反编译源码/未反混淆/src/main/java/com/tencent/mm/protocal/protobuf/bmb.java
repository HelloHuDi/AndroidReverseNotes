package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmb extends btd {
    public int nwA;
    public String nwB;
    public int nwF;
    public int nwL;
    public int nwM;
    public int nwN;
    public b nwO;
    public int nwQ;
    public int nwT;
    public LinkedList<blt> vIO = new LinkedList();
    public long wOS;
    public int wPb;
    public int wPc;
    public LinkedList<blt> wPd = new LinkedList();
    public String wPe;
    public b wPf;
    public int wPg;
    public int wem;
    public long wen;

    public bmb() {
        AppMethodBeat.i(28582);
        AppMethodBeat.o(28582);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28583);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28583);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.wPb);
            aVar.e(5, 8, this.vIO);
            aVar.iz(6, this.wPc);
            aVar.iz(7, this.nwL);
            aVar.iz(8, this.nwM);
            aVar.ai(9, this.wOS);
            aVar.iz(10, this.nwN);
            if (this.nwO != null) {
                aVar.c(11, this.nwO);
            }
            aVar.iz(12, this.nwF);
            aVar.iz(13, this.nwA);
            if (this.nwB != null) {
                aVar.e(14, this.nwB);
            }
            aVar.iz(15, this.nwQ);
            aVar.e(16, 8, this.wPd);
            aVar.iz(17, this.nwT);
            if (this.wPe != null) {
                aVar.e(18, this.wPe);
            }
            if (this.wPf != null) {
                aVar.c(19, this.wPf);
            }
            aVar.iz(20, this.wPg);
            AppMethodBeat.o(28583);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.wPb)) + e.a.a.a.c(5, 8, this.vIO)) + e.a.a.b.b.a.bs(6, this.wPc)) + e.a.a.b.b.a.bs(7, this.nwL)) + e.a.a.b.b.a.bs(8, this.nwM)) + e.a.a.b.b.a.o(9, this.wOS)) + e.a.a.b.b.a.bs(10, this.nwN);
            if (this.nwO != null) {
                ix += e.a.a.b.b.a.b(11, this.nwO);
            }
            ix = (ix + e.a.a.b.b.a.bs(12, this.nwF)) + e.a.a.b.b.a.bs(13, this.nwA);
            if (this.nwB != null) {
                ix += e.a.a.b.b.a.f(14, this.nwB);
            }
            ix = ((ix + e.a.a.b.b.a.bs(15, this.nwQ)) + e.a.a.a.c(16, 8, this.wPd)) + e.a.a.b.b.a.bs(17, this.nwT);
            if (this.wPe != null) {
                ix += e.a.a.b.b.a.f(18, this.wPe);
            }
            if (this.wPf != null) {
                ix += e.a.a.b.b.a.b(19, this.wPf);
            }
            int bs = ix + e.a.a.b.b.a.bs(20, this.wPg);
            AppMethodBeat.o(28583);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            this.wPd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28583);
                throw bVar;
            }
            AppMethodBeat.o(28583);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmb bmb = (bmb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            blt blt;
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
                        bmb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28583);
                    return 0;
                case 2:
                    bmb.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 3:
                    bmb.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28583);
                    return 0;
                case 4:
                    bmb.wPb = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blt = new blt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blt.populateBuilderWithField(aVar4, blt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmb.vIO.add(blt);
                    }
                    AppMethodBeat.o(28583);
                    return 0;
                case 6:
                    bmb.wPc = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 7:
                    bmb.nwL = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 8:
                    bmb.nwM = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 9:
                    bmb.wOS = aVar3.BTU.ve();
                    AppMethodBeat.o(28583);
                    return 0;
                case 10:
                    bmb.nwN = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 11:
                    bmb.nwO = aVar3.BTU.emu();
                    AppMethodBeat.o(28583);
                    return 0;
                case 12:
                    bmb.nwF = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 13:
                    bmb.nwA = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 14:
                    bmb.nwB = aVar3.BTU.readString();
                    AppMethodBeat.o(28583);
                    return 0;
                case 15:
                    bmb.nwQ = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blt = new blt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blt.populateBuilderWithField(aVar4, blt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmb.wPd.add(blt);
                    }
                    AppMethodBeat.o(28583);
                    return 0;
                case 17:
                    bmb.nwT = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                case 18:
                    bmb.wPe = aVar3.BTU.readString();
                    AppMethodBeat.o(28583);
                    return 0;
                case 19:
                    bmb.wPf = aVar3.BTU.emu();
                    AppMethodBeat.o(28583);
                    return 0;
                case 20:
                    bmb.wPg = aVar3.BTU.vd();
                    AppMethodBeat.o(28583);
                    return 0;
                default:
                    AppMethodBeat.o(28583);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28583);
            return -1;
        }
    }
}
