package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class baf extends bsr {
    public String guQ;
    public String jBF;
    public String luP;
    public String luQ;
    public int nbj;
    public String nqc;
    public int vAM;
    public hh vIg;
    public String vIh;
    public int vIi;
    public String vIj;
    public String vIk;
    public SKBuiltinBuffer_t vIl;
    public String vOA;
    public String vOz;
    public String wDX;
    public String wDY;
    public String wDZ;
    public int wEa;
    public String wdz;
    public String wlq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58912);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vIg != null) {
                aVar.iy(2, this.vIg.computeSize());
                this.vIg.writeFields(aVar);
            }
            if (this.nqc != null) {
                aVar.e(3, this.nqc);
            }
            if (this.vIh != null) {
                aVar.e(4, this.vIh);
            }
            aVar.iz(5, this.vIi);
            if (this.vIj != null) {
                aVar.e(6, this.vIj);
            }
            if (this.guQ != null) {
                aVar.e(7, this.guQ);
            }
            if (this.jBF != null) {
                aVar.e(8, this.jBF);
            }
            if (this.vIk != null) {
                aVar.e(9, this.vIk);
            }
            if (this.luQ != null) {
                aVar.e(10, this.luQ);
            }
            if (this.luP != null) {
                aVar.e(11, this.luP);
            }
            aVar.iz(13, this.vAM);
            aVar.iz(14, this.nbj);
            if (this.vOA != null) {
                aVar.e(15, this.vOA);
            }
            if (this.vOz != null) {
                aVar.e(16, this.vOz);
            }
            if (this.wDX != null) {
                aVar.e(17, this.wDX);
            }
            if (this.wdz != null) {
                aVar.e(18, this.wdz);
            }
            if (this.wlq != null) {
                aVar.e(19, this.wlq);
            }
            if (this.wDY != null) {
                aVar.e(20, this.wDY);
            }
            if (this.wDZ != null) {
                aVar.e(21, this.wDZ);
            }
            aVar.iz(22, this.wEa);
            if (this.vIl != null) {
                aVar.iy(23, this.vIl.computeSize());
                this.vIl.writeFields(aVar);
            }
            AppMethodBeat.o(58912);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vIg != null) {
                ix += e.a.a.a.ix(2, this.vIg.computeSize());
            }
            if (this.nqc != null) {
                ix += e.a.a.b.b.a.f(3, this.nqc);
            }
            if (this.vIh != null) {
                ix += e.a.a.b.b.a.f(4, this.vIh);
            }
            ix += e.a.a.b.b.a.bs(5, this.vIi);
            if (this.vIj != null) {
                ix += e.a.a.b.b.a.f(6, this.vIj);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(7, this.guQ);
            }
            if (this.jBF != null) {
                ix += e.a.a.b.b.a.f(8, this.jBF);
            }
            if (this.vIk != null) {
                ix += e.a.a.b.b.a.f(9, this.vIk);
            }
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(10, this.luQ);
            }
            if (this.luP != null) {
                ix += e.a.a.b.b.a.f(11, this.luP);
            }
            ix = (ix + e.a.a.b.b.a.bs(13, this.vAM)) + e.a.a.b.b.a.bs(14, this.nbj);
            if (this.vOA != null) {
                ix += e.a.a.b.b.a.f(15, this.vOA);
            }
            if (this.vOz != null) {
                ix += e.a.a.b.b.a.f(16, this.vOz);
            }
            if (this.wDX != null) {
                ix += e.a.a.b.b.a.f(17, this.wDX);
            }
            if (this.wdz != null) {
                ix += e.a.a.b.b.a.f(18, this.wdz);
            }
            if (this.wlq != null) {
                ix += e.a.a.b.b.a.f(19, this.wlq);
            }
            if (this.wDY != null) {
                ix += e.a.a.b.b.a.f(20, this.wDY);
            }
            if (this.wDZ != null) {
                ix += e.a.a.b.b.a.f(21, this.wDZ);
            }
            ix += e.a.a.b.b.a.bs(22, this.wEa);
            if (this.vIl != null) {
                ix += e.a.a.a.ix(23, this.vIl.computeSize());
            }
            AppMethodBeat.o(58912);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58912);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            baf baf = (baf) objArr[1];
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
                        baf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(58912);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hh hhVar = new hh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hhVar.populateBuilderWithField(aVar4, hhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baf.vIg = hhVar;
                    }
                    AppMethodBeat.o(58912);
                    return 0;
                case 3:
                    baf.nqc = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 4:
                    baf.vIh = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 5:
                    baf.vIi = aVar3.BTU.vd();
                    AppMethodBeat.o(58912);
                    return 0;
                case 6:
                    baf.vIj = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 7:
                    baf.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 8:
                    baf.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 9:
                    baf.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 10:
                    baf.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 11:
                    baf.luP = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 13:
                    baf.vAM = aVar3.BTU.vd();
                    AppMethodBeat.o(58912);
                    return 0;
                case 14:
                    baf.nbj = aVar3.BTU.vd();
                    AppMethodBeat.o(58912);
                    return 0;
                case 15:
                    baf.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 16:
                    baf.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 17:
                    baf.wDX = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 18:
                    baf.wdz = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 19:
                    baf.wlq = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 20:
                    baf.wDY = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 21:
                    baf.wDZ = aVar3.BTU.readString();
                    AppMethodBeat.o(58912);
                    return 0;
                case 22:
                    baf.wEa = aVar3.BTU.vd();
                    AppMethodBeat.o(58912);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baf.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58912);
                    return 0;
                default:
                    AppMethodBeat.o(58912);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58912);
            return -1;
        }
    }
}
