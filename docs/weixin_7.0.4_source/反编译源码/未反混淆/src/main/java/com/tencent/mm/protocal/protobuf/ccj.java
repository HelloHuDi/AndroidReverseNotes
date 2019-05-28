package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ccj extends bsr {
    public String fKh;
    public int jCt;
    public String ptv;
    public int ptw;
    public int ptx;
    public String vEA;
    public SKBuiltinBuffer_t vJd;
    public int vZF;
    public int wFd;
    public int wFe;
    public int wGz;
    public civ wNQ;
    public String wdO;
    public int xbN;
    public int xbO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94620);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(94620);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.ptx);
            aVar.iz(4, this.ptw);
            if (this.vJd != null) {
                aVar.iy(5, this.vJd.computeSize());
                this.vJd.writeFields(aVar);
            }
            if (this.ptv != null) {
                aVar.e(6, this.ptv);
            }
            aVar.iz(7, this.wFd);
            aVar.iz(8, this.wFe);
            if (this.vEA != null) {
                aVar.e(9, this.vEA);
            }
            aVar.iz(10, this.xbN);
            aVar.iz(11, this.vZF);
            if (this.wNQ != null) {
                aVar.iy(12, this.wNQ.computeSize());
                this.wNQ.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(13, this.fKh);
            }
            aVar.iz(14, this.wGz);
            if (this.wdO != null) {
                aVar.e(15, this.wdO);
            }
            aVar.iz(16, this.xbO);
            AppMethodBeat.o(94620);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.ptx)) + e.a.a.b.b.a.bs(4, this.ptw);
            if (this.vJd != null) {
                ix += e.a.a.a.ix(5, this.vJd.computeSize());
            }
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(6, this.ptv);
            }
            ix = (ix + e.a.a.b.b.a.bs(7, this.wFd)) + e.a.a.b.b.a.bs(8, this.wFe);
            if (this.vEA != null) {
                ix += e.a.a.b.b.a.f(9, this.vEA);
            }
            ix = (ix + e.a.a.b.b.a.bs(10, this.xbN)) + e.a.a.b.b.a.bs(11, this.vZF);
            if (this.wNQ != null) {
                ix += e.a.a.a.ix(12, this.wNQ.computeSize());
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(13, this.fKh);
            }
            ix += e.a.a.b.b.a.bs(14, this.wGz);
            if (this.wdO != null) {
                ix += e.a.a.b.b.a.f(15, this.wdO);
            }
            int bs = ix + e.a.a.b.b.a.bs(16, this.xbO);
            AppMethodBeat.o(94620);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(94620);
                throw bVar;
            }
            AppMethodBeat.o(94620);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccj ccj = (ccj) objArr[1];
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
                        ccj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94620);
                    return 0;
                case 2:
                    ccj.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 3:
                    ccj.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 4:
                    ccj.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccj.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94620);
                    return 0;
                case 6:
                    ccj.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94620);
                    return 0;
                case 7:
                    ccj.wFd = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 8:
                    ccj.wFe = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 9:
                    ccj.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(94620);
                    return 0;
                case 10:
                    ccj.xbN = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 11:
                    ccj.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        civ civ = new civ();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = civ.populateBuilderWithField(aVar4, civ, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccj.wNQ = civ;
                    }
                    AppMethodBeat.o(94620);
                    return 0;
                case 13:
                    ccj.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(94620);
                    return 0;
                case 14:
                    ccj.wGz = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                case 15:
                    ccj.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(94620);
                    return 0;
                case 16:
                    ccj.xbO = aVar3.BTU.vd();
                    AppMethodBeat.o(94620);
                    return 0;
                default:
                    AppMethodBeat.o(94620);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94620);
            return -1;
        }
    }
}
