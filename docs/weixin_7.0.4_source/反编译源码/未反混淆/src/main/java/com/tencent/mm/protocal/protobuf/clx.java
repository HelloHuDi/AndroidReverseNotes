package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class clx extends bsr {
    public int fJT;
    public String ndF;
    public String ndG;
    public int ptD;
    public long ptF;
    public SKBuiltinBuffer_t ptz;
    public String vEG;
    public String vFF;
    public int vOq;
    public int wEz;
    public int wdW;
    public int wdn;
    public int wdp;
    public int wdq;
    public int xjF;
    public int xjG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116811);
        b bVar;
        int f;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116811);
                throw bVar;
            }
            if (this.ndG != null) {
                aVar.e(1, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(2, this.ndF);
            }
            aVar.iz(3, this.vOq);
            aVar.iz(4, this.wdn);
            if (this.vFF != null) {
                aVar.e(5, this.vFF);
            }
            aVar.iz(6, this.ptD);
            aVar.iz(7, this.wdp);
            if (this.ptz != null) {
                aVar.iy(8, this.ptz.computeSize());
                this.ptz.writeFields(aVar);
            }
            aVar.iz(9, this.fJT);
            if (this.BaseRequest != null) {
                aVar.iy(10, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(11, this.wdq);
            if (this.vEG != null) {
                aVar.e(12, this.vEG);
            }
            aVar.iz(13, this.wEz);
            aVar.iz(14, this.xjF);
            aVar.iz(15, this.xjG);
            aVar.ai(16, this.ptF);
            aVar.iz(17, this.wdW);
            AppMethodBeat.o(116811);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = e.a.a.b.b.a.f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndF != null) {
                f += e.a.a.b.b.a.f(2, this.ndF);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.vOq)) + e.a.a.b.b.a.bs(4, this.wdn);
            if (this.vFF != null) {
                f += e.a.a.b.b.a.f(5, this.vFF);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.ptD)) + e.a.a.b.b.a.bs(7, this.wdp);
            if (this.ptz != null) {
                f += e.a.a.a.ix(8, this.ptz.computeSize());
            }
            f += e.a.a.b.b.a.bs(9, this.fJT);
            if (this.BaseRequest != null) {
                f += e.a.a.a.ix(10, this.BaseRequest.computeSize());
            }
            f += e.a.a.b.b.a.bs(11, this.wdq);
            if (this.vEG != null) {
                f += e.a.a.b.b.a.f(12, this.vEG);
            }
            int bs = ((((f + e.a.a.b.b.a.bs(13, this.wEz)) + e.a.a.b.b.a.bs(14, this.xjF)) + e.a.a.b.b.a.bs(15, this.xjG)) + e.a.a.b.b.a.o(16, this.ptF)) + e.a.a.b.b.a.bs(17, this.wdW);
            AppMethodBeat.o(116811);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116811);
                throw bVar;
            }
            AppMethodBeat.o(116811);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clx clx = (clx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    clx.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(116811);
                    return 0;
                case 2:
                    clx.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(116811);
                    return 0;
                case 3:
                    clx.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 4:
                    clx.wdn = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 5:
                    clx.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(116811);
                    return 0;
                case 6:
                    clx.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 7:
                    clx.wdp = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clx.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116811);
                    return 0;
                case 9:
                    clx.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clx.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116811);
                    return 0;
                case 11:
                    clx.wdq = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 12:
                    clx.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(116811);
                    return 0;
                case 13:
                    clx.wEz = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 14:
                    clx.xjF = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 15:
                    clx.xjG = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                case 16:
                    clx.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(116811);
                    return 0;
                case 17:
                    clx.wdW = aVar3.BTU.vd();
                    AppMethodBeat.o(116811);
                    return 0;
                default:
                    AppMethodBeat.o(116811);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116811);
            return -1;
        }
    }
}
