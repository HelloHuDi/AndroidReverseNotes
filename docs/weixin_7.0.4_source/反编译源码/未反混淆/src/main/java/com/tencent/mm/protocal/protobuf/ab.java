package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ab extends btd {
    public int OpCode;
    public String vAQ;
    public int vAR;
    public int vAS;
    public String vAT;
    public bzt vAU;
    public bqv vAV;
    public bzt vAW;
    public bns vAX;
    public acq vAY;
    public gj vAZ;
    public String vBa;
    public String vBb;
    public int vBc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28293);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28293);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vAQ != null) {
                aVar.e(2, this.vAQ);
            }
            aVar.iz(3, this.vAR);
            aVar.iz(4, this.vAS);
            if (this.vAT != null) {
                aVar.e(5, this.vAT);
            }
            if (this.vAU != null) {
                aVar.iy(6, this.vAU.computeSize());
                this.vAU.writeFields(aVar);
            }
            aVar.iz(7, this.OpCode);
            if (this.vAV != null) {
                aVar.iy(8, this.vAV.computeSize());
                this.vAV.writeFields(aVar);
            }
            if (this.vAW != null) {
                aVar.iy(9, this.vAW.computeSize());
                this.vAW.writeFields(aVar);
            }
            if (this.vAX != null) {
                aVar.iy(10, this.vAX.computeSize());
                this.vAX.writeFields(aVar);
            }
            if (this.vAY != null) {
                aVar.iy(11, this.vAY.computeSize());
                this.vAY.writeFields(aVar);
            }
            if (this.vAZ != null) {
                aVar.iy(12, this.vAZ.computeSize());
                this.vAZ.writeFields(aVar);
            }
            if (this.vBa != null) {
                aVar.e(13, this.vBa);
            }
            if (this.vBb != null) {
                aVar.e(14, this.vBb);
            }
            aVar.iz(15, this.vBc);
            AppMethodBeat.o(28293);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vAQ != null) {
                ix += e.a.a.b.b.a.f(2, this.vAQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.vAR)) + e.a.a.b.b.a.bs(4, this.vAS);
            if (this.vAT != null) {
                ix += e.a.a.b.b.a.f(5, this.vAT);
            }
            if (this.vAU != null) {
                ix += e.a.a.a.ix(6, this.vAU.computeSize());
            }
            ix += e.a.a.b.b.a.bs(7, this.OpCode);
            if (this.vAV != null) {
                ix += e.a.a.a.ix(8, this.vAV.computeSize());
            }
            if (this.vAW != null) {
                ix += e.a.a.a.ix(9, this.vAW.computeSize());
            }
            if (this.vAX != null) {
                ix += e.a.a.a.ix(10, this.vAX.computeSize());
            }
            if (this.vAY != null) {
                ix += e.a.a.a.ix(11, this.vAY.computeSize());
            }
            if (this.vAZ != null) {
                ix += e.a.a.a.ix(12, this.vAZ.computeSize());
            }
            if (this.vBa != null) {
                ix += e.a.a.b.b.a.f(13, this.vBa);
            }
            if (this.vBb != null) {
                ix += e.a.a.b.b.a.f(14, this.vBb);
            }
            int bs = ix + e.a.a.b.b.a.bs(15, this.vBc);
            AppMethodBeat.o(28293);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28293);
                throw bVar;
            }
            AppMethodBeat.o(28293);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bzt bzt;
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
                        abVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 2:
                    abVar.vAQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28293);
                    return 0;
                case 3:
                    abVar.vAR = aVar3.BTU.vd();
                    AppMethodBeat.o(28293);
                    return 0;
                case 4:
                    abVar.vAS = aVar3.BTU.vd();
                    AppMethodBeat.o(28293);
                    return 0;
                case 5:
                    abVar.vAT = aVar3.BTU.readString();
                    AppMethodBeat.o(28293);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt = new bzt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(aVar4, bzt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.vAU = bzt;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 7:
                    abVar.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(28293);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqv bqv = new bqv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqv.populateBuilderWithField(aVar4, bqv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.vAV = bqv;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt = new bzt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(aVar4, bzt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.vAW = bzt;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bns bns = new bns();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bns.populateBuilderWithField(aVar4, bns, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.vAX = bns;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acq acq = new acq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acq.populateBuilderWithField(aVar4, acq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.vAY = acq;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        gj gjVar = new gj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gjVar.populateBuilderWithField(aVar4, gjVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.vAZ = gjVar;
                    }
                    AppMethodBeat.o(28293);
                    return 0;
                case 13:
                    abVar.vBa = aVar3.BTU.readString();
                    AppMethodBeat.o(28293);
                    return 0;
                case 14:
                    abVar.vBb = aVar3.BTU.readString();
                    AppMethodBeat.o(28293);
                    return 0;
                case 15:
                    abVar.vBc = aVar3.BTU.vd();
                    AppMethodBeat.o(28293);
                    return 0;
                default:
                    AppMethodBeat.o(28293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28293);
            return -1;
        }
    }
}
