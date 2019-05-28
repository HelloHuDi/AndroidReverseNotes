package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ado extends bsr {
    public int OpCode;
    public int Scene;
    public String jBB;
    public int vEq;
    public int vGB;
    public SKBuiltinBuffer_t vHP;
    public int vIw;
    public String vKt;
    public int vXI;
    public int vXJ;
    public bts wlk;
    public bts wll;
    public bts wlm;
    public bts wln;
    public String wlo;
    public int wlp;
    public String wlq;
    public SKBuiltinBuffer_t wlr;
    public int wls;
    public int wlt;
    public String wlu;
    public int wlv;
    public SKBuiltinBuffer_t wlw;
    public String wlx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80054);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            if (this.vHP != null) {
                aVar.iy(3, this.vHP.computeSize());
                this.vHP.writeFields(aVar);
            }
            if (this.wlk != null) {
                aVar.iy(4, this.wlk.computeSize());
                this.wlk.writeFields(aVar);
            }
            if (this.wll != null) {
                aVar.iy(5, this.wll.computeSize());
                this.wll.writeFields(aVar);
            }
            if (this.wlm != null) {
                aVar.iy(6, this.wlm.computeSize());
                this.wlm.writeFields(aVar);
            }
            if (this.wln != null) {
                aVar.iy(7, this.wln.computeSize());
                this.wln.writeFields(aVar);
            }
            if (this.wlo != null) {
                aVar.e(8, this.wlo);
            }
            aVar.iz(9, this.wlp);
            aVar.iz(10, this.Scene);
            if (this.jBB != null) {
                aVar.e(11, this.jBB);
            }
            if (this.wlq != null) {
                aVar.e(12, this.wlq);
            }
            if (this.wlr != null) {
                aVar.iy(13, this.wlr.computeSize());
                this.wlr.writeFields(aVar);
            }
            aVar.iz(14, this.vIw);
            aVar.iz(15, this.wls);
            aVar.iz(16, this.vEq);
            if (this.vKt != null) {
                aVar.e(17, this.vKt);
            }
            aVar.iz(18, this.vXI);
            aVar.iz(19, this.vXJ);
            aVar.iz(20, this.wlt);
            if (this.wlu != null) {
                aVar.e(21, this.wlu);
            }
            aVar.iz(22, this.wlv);
            if (this.wlw != null) {
                aVar.iy(23, this.wlw.computeSize());
                this.wlw.writeFields(aVar);
            }
            if (this.wlx != null) {
                aVar.e(24, this.wlx);
            }
            aVar.iz(25, this.vGB);
            AppMethodBeat.o(80054);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.OpCode);
            if (this.vHP != null) {
                ix += e.a.a.a.ix(3, this.vHP.computeSize());
            }
            if (this.wlk != null) {
                ix += e.a.a.a.ix(4, this.wlk.computeSize());
            }
            if (this.wll != null) {
                ix += e.a.a.a.ix(5, this.wll.computeSize());
            }
            if (this.wlm != null) {
                ix += e.a.a.a.ix(6, this.wlm.computeSize());
            }
            if (this.wln != null) {
                ix += e.a.a.a.ix(7, this.wln.computeSize());
            }
            if (this.wlo != null) {
                ix += e.a.a.b.b.a.f(8, this.wlo);
            }
            ix = (ix + e.a.a.b.b.a.bs(9, this.wlp)) + e.a.a.b.b.a.bs(10, this.Scene);
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(11, this.jBB);
            }
            if (this.wlq != null) {
                ix += e.a.a.b.b.a.f(12, this.wlq);
            }
            if (this.wlr != null) {
                ix += e.a.a.a.ix(13, this.wlr.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(14, this.vIw)) + e.a.a.b.b.a.bs(15, this.wls)) + e.a.a.b.b.a.bs(16, this.vEq);
            if (this.vKt != null) {
                ix += e.a.a.b.b.a.f(17, this.vKt);
            }
            ix = ((ix + e.a.a.b.b.a.bs(18, this.vXI)) + e.a.a.b.b.a.bs(19, this.vXJ)) + e.a.a.b.b.a.bs(20, this.wlt);
            if (this.wlu != null) {
                ix += e.a.a.b.b.a.f(21, this.wlu);
            }
            ix += e.a.a.b.b.a.bs(22, this.wlv);
            if (this.wlw != null) {
                ix += e.a.a.a.ix(23, this.wlw.computeSize());
            }
            if (this.wlx != null) {
                ix += e.a.a.b.b.a.f(24, this.wlx);
            }
            int bs = ix + e.a.a.b.b.a.bs(25, this.vGB);
            AppMethodBeat.o(80054);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80054);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ado ado = (ado) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            bts bts;
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
                        ado.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 2:
                    ado.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.wlk = bts;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.wll = bts;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.wlm = bts;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.wln = bts;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 8:
                    ado.wlo = aVar3.BTU.readString();
                    AppMethodBeat.o(80054);
                    return 0;
                case 9:
                    ado.wlp = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 10:
                    ado.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 11:
                    ado.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(80054);
                    return 0;
                case 12:
                    ado.wlq = aVar3.BTU.readString();
                    AppMethodBeat.o(80054);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.wlr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 14:
                    ado.vIw = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 15:
                    ado.wls = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 16:
                    ado.vEq = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 17:
                    ado.vKt = aVar3.BTU.readString();
                    AppMethodBeat.o(80054);
                    return 0;
                case 18:
                    ado.vXI = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 19:
                    ado.vXJ = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 20:
                    ado.wlt = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 21:
                    ado.wlu = aVar3.BTU.readString();
                    AppMethodBeat.o(80054);
                    return 0;
                case 22:
                    ado.wlv = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ado.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80054);
                    return 0;
                case 24:
                    ado.wlx = aVar3.BTU.readString();
                    AppMethodBeat.o(80054);
                    return 0;
                case 25:
                    ado.vGB = aVar3.BTU.vd();
                    AppMethodBeat.o(80054);
                    return 0;
                default:
                    AppMethodBeat.o(80054);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80054);
            return -1;
        }
    }
}
