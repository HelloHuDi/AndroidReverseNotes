package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bla extends btd {
    public int kdT;
    public String kdU;
    public int vES;
    public String wCO;
    public boolean wCP = true;
    public aum wNW;
    public bls wNX;
    public String wNY;
    public int wNZ;
    public long wOa;
    public LinkedList<oq> wmz = new LinkedList();

    public bla() {
        AppMethodBeat.i(56923);
        AppMethodBeat.o(56923);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56924);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56924);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            if (this.wNW != null) {
                aVar.iy(4, this.wNW.computeSize());
                this.wNW.writeFields(aVar);
            }
            if (this.wNX != null) {
                aVar.iy(5, this.wNX.computeSize());
                this.wNX.writeFields(aVar);
            }
            if (this.wCO != null) {
                aVar.e(6, this.wCO);
            }
            aVar.e(7, 8, this.wmz);
            aVar.aO(8, this.wCP);
            aVar.iz(9, this.vES);
            if (this.wNY != null) {
                aVar.e(10, this.wNY);
            }
            aVar.iz(11, this.wNZ);
            aVar.ai(12, this.wOa);
            AppMethodBeat.o(56924);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            if (this.wNW != null) {
                ix += e.a.a.a.ix(4, this.wNW.computeSize());
            }
            if (this.wNX != null) {
                ix += e.a.a.a.ix(5, this.wNX.computeSize());
            }
            if (this.wCO != null) {
                ix += e.a.a.b.b.a.f(6, this.wCO);
            }
            ix = ((ix + e.a.a.a.c(7, 8, this.wmz)) + (e.a.a.b.b.a.fv(8) + 1)) + e.a.a.b.b.a.bs(9, this.vES);
            if (this.wNY != null) {
                ix += e.a.a.b.b.a.f(10, this.wNY);
            }
            int bs = (ix + e.a.a.b.b.a.bs(11, this.wNZ)) + e.a.a.b.b.a.o(12, this.wOa);
            AppMethodBeat.o(56924);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56924);
                throw bVar;
            }
            AppMethodBeat.o(56924);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bla bla = (bla) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
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
                        bla.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56924);
                    return 0;
                case 2:
                    bla.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56924);
                    return 0;
                case 3:
                    bla.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56924);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aum aum = new aum();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aum.populateBuilderWithField(aVar4, aum, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bla.wNW = aum;
                    }
                    AppMethodBeat.o(56924);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bls bls = new bls();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bls.populateBuilderWithField(aVar4, bls, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bla.wNX = bls;
                    }
                    AppMethodBeat.o(56924);
                    return 0;
                case 6:
                    bla.wCO = aVar3.BTU.readString();
                    AppMethodBeat.o(56924);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oq oqVar = new oq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oqVar.populateBuilderWithField(aVar4, oqVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bla.wmz.add(oqVar);
                    }
                    AppMethodBeat.o(56924);
                    return 0;
                case 8:
                    bla.wCP = aVar3.BTU.ehX();
                    AppMethodBeat.o(56924);
                    return 0;
                case 9:
                    bla.vES = aVar3.BTU.vd();
                    AppMethodBeat.o(56924);
                    return 0;
                case 10:
                    bla.wNY = aVar3.BTU.readString();
                    AppMethodBeat.o(56924);
                    return 0;
                case 11:
                    bla.wNZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56924);
                    return 0;
                case 12:
                    bla.wOa = aVar3.BTU.ve();
                    AppMethodBeat.o(56924);
                    return 0;
                default:
                    AppMethodBeat.o(56924);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56924);
            return -1;
        }
    }
}
