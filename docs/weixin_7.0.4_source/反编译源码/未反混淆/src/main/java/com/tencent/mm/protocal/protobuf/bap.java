package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bap extends bsr {
    public String ThumbUrl;
    public int nao;
    public String nbr;
    public int vRm;
    public int vRn;
    public String wEA;
    public String wEB;
    public String wEl;
    public String wEm;
    public String wEn;
    public int wEo;
    public SKBuiltinBuffer_t wEp;
    public int wEq;
    public int wEr;
    public int wEs;
    public int wEt;
    public SKBuiltinBuffer_t wEu;
    public int wEv;
    public int wEw;
    public int wEx;
    public int wEy;
    public int wEz;
    public int wqw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28548);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wEp == null) {
                bVar = new b("Not all required fields were included: DataBuffer");
                AppMethodBeat.o(28548);
                throw bVar;
            } else if (this.wEu == null) {
                bVar = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(28548);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wEl != null) {
                    aVar.e(2, this.wEl);
                }
                if (this.wEm != null) {
                    aVar.e(3, this.wEm);
                }
                if (this.wEn != null) {
                    aVar.e(4, this.wEn);
                }
                aVar.iz(5, this.nao);
                aVar.iz(6, this.wEo);
                if (this.wEp != null) {
                    aVar.iy(7, this.wEp.computeSize());
                    this.wEp.writeFields(aVar);
                }
                aVar.iz(8, this.wEq);
                aVar.iz(9, this.wEr);
                aVar.iz(10, this.wEs);
                aVar.iz(11, this.wEt);
                if (this.wEu != null) {
                    aVar.iy(12, this.wEu.computeSize());
                    this.wEu.writeFields(aVar);
                }
                aVar.iz(13, this.wEv);
                aVar.iz(14, this.wEw);
                aVar.iz(15, this.wEx);
                aVar.iz(16, this.wEy);
                aVar.iz(17, this.wqw);
                aVar.iz(18, this.wEz);
                if (this.nbr != null) {
                    aVar.e(19, this.nbr);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(20, this.ThumbUrl);
                }
                aVar.iz(21, this.vRn);
                aVar.iz(22, this.vRm);
                if (this.wEA != null) {
                    aVar.e(23, this.wEA);
                }
                if (this.wEB != null) {
                    aVar.e(24, this.wEB);
                }
                AppMethodBeat.o(28548);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wEl != null) {
                ix += e.a.a.b.b.a.f(2, this.wEl);
            }
            if (this.wEm != null) {
                ix += e.a.a.b.b.a.f(3, this.wEm);
            }
            if (this.wEn != null) {
                ix += e.a.a.b.b.a.f(4, this.wEn);
            }
            ix = (ix + e.a.a.b.b.a.bs(5, this.nao)) + e.a.a.b.b.a.bs(6, this.wEo);
            if (this.wEp != null) {
                ix += e.a.a.a.ix(7, this.wEp.computeSize());
            }
            ix = (((ix + e.a.a.b.b.a.bs(8, this.wEq)) + e.a.a.b.b.a.bs(9, this.wEr)) + e.a.a.b.b.a.bs(10, this.wEs)) + e.a.a.b.b.a.bs(11, this.wEt);
            if (this.wEu != null) {
                ix += e.a.a.a.ix(12, this.wEu.computeSize());
            }
            ix = (((((ix + e.a.a.b.b.a.bs(13, this.wEv)) + e.a.a.b.b.a.bs(14, this.wEw)) + e.a.a.b.b.a.bs(15, this.wEx)) + e.a.a.b.b.a.bs(16, this.wEy)) + e.a.a.b.b.a.bs(17, this.wqw)) + e.a.a.b.b.a.bs(18, this.wEz);
            if (this.nbr != null) {
                ix += e.a.a.b.b.a.f(19, this.nbr);
            }
            if (this.ThumbUrl != null) {
                ix += e.a.a.b.b.a.f(20, this.ThumbUrl);
            }
            ix = (ix + e.a.a.b.b.a.bs(21, this.vRn)) + e.a.a.b.b.a.bs(22, this.vRm);
            if (this.wEA != null) {
                ix += e.a.a.b.b.a.f(23, this.wEA);
            }
            if (this.wEB != null) {
                ix += e.a.a.b.b.a.f(24, this.wEB);
            }
            AppMethodBeat.o(28548);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wEp == null) {
                bVar = new b("Not all required fields were included: DataBuffer");
                AppMethodBeat.o(28548);
                throw bVar;
            } else if (this.wEu == null) {
                bVar = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(28548);
                throw bVar;
            } else {
                AppMethodBeat.o(28548);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bap bap = (bap) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        bap.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28548);
                    return 0;
                case 2:
                    bap.wEl = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                case 3:
                    bap.wEm = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                case 4:
                    bap.wEn = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                case 5:
                    bap.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 6:
                    bap.wEo = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bap.wEp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28548);
                    return 0;
                case 8:
                    bap.wEq = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 9:
                    bap.wEr = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 10:
                    bap.wEs = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 11:
                    bap.wEt = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bap.wEu = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28548);
                    return 0;
                case 13:
                    bap.wEv = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 14:
                    bap.wEw = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 15:
                    bap.wEx = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 16:
                    bap.wEy = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 17:
                    bap.wqw = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 18:
                    bap.wEz = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 19:
                    bap.nbr = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                case 20:
                    bap.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                case 21:
                    bap.vRn = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 22:
                    bap.vRm = aVar3.BTU.vd();
                    AppMethodBeat.o(28548);
                    return 0;
                case 23:
                    bap.wEA = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                case 24:
                    bap.wEB = aVar3.BTU.readString();
                    AppMethodBeat.o(28548);
                    return 0;
                default:
                    AppMethodBeat.o(28548);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28548);
            return -1;
        }
    }
}
