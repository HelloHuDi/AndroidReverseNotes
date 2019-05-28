package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class axw extends a {
    public String Title;
    public int jCt;
    public String oQU;
    public float oQV;
    public int oQW;
    public LinkedList<Integer> oQX = new LinkedList();
    public int oQY;
    public LinkedList<bts> oQZ = new LinkedList();
    public float oRa;
    public String oRb;
    public SKBuiltinBuffer_t oRc;
    public String wCb;
    public SKBuiltinBuffer_t wCc;
    public int wCd;
    public int wCe;

    public axw() {
        AppMethodBeat.i(70484);
        AppMethodBeat.o(70484);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(70485);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.oQU != null) {
                aVar.e(1, this.oQU);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            aVar.r(3, this.oQV);
            aVar.iz(4, this.oQW);
            aVar.f(5, 2, this.oQX);
            aVar.iz(6, this.oQY);
            aVar.e(7, 8, this.oQZ);
            aVar.r(8, this.oRa);
            if (this.oRb != null) {
                aVar.e(9, this.oRb);
            }
            aVar.iz(10, this.jCt);
            if (this.oRc != null) {
                aVar.iy(11, this.oRc.computeSize());
                this.oRc.writeFields(aVar);
            }
            if (this.wCb != null) {
                aVar.e(12, this.wCb);
            }
            if (this.wCc != null) {
                aVar.iy(13, this.wCc.computeSize());
                this.wCc.writeFields(aVar);
            }
            aVar.iz(14, this.wCd);
            aVar.iz(15, this.wCe);
            AppMethodBeat.o(70485);
            return 0;
        } else if (i == 1) {
            if (this.oQU != null) {
                f = e.a.a.b.b.a.f(1, this.oQU) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            f = (((((f + (e.a.a.b.b.a.fv(3) + 4)) + e.a.a.b.b.a.bs(4, this.oQW)) + e.a.a.a.d(5, 2, this.oQX)) + e.a.a.b.b.a.bs(6, this.oQY)) + e.a.a.a.c(7, 8, this.oQZ)) + (e.a.a.b.b.a.fv(8) + 4);
            if (this.oRb != null) {
                f += e.a.a.b.b.a.f(9, this.oRb);
            }
            f += e.a.a.b.b.a.bs(10, this.jCt);
            if (this.oRc != null) {
                f += e.a.a.a.ix(11, this.oRc.computeSize());
            }
            if (this.wCb != null) {
                f += e.a.a.b.b.a.f(12, this.wCb);
            }
            if (this.wCc != null) {
                f += e.a.a.a.ix(13, this.wCc.computeSize());
            }
            int bs = (f + e.a.a.b.b.a.bs(14, this.wCd)) + e.a.a.b.b.a.bs(15, this.wCe);
            AppMethodBeat.o(70485);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.oQX.clear();
            this.oQZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(70485);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axw axw = (axw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    axw.oQU = aVar3.BTU.readString();
                    AppMethodBeat.o(70485);
                    return 0;
                case 2:
                    axw.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(70485);
                    return 0;
                case 3:
                    axw.oQV = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(70485);
                    return 0;
                case 4:
                    axw.oQW = aVar3.BTU.vd();
                    AppMethodBeat.o(70485);
                    return 0;
                case 5:
                    axw.oQX = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(70485);
                    return 0;
                case 6:
                    axw.oQY = aVar3.BTU.vd();
                    AppMethodBeat.o(70485);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        axw.oQZ.add(bts);
                    }
                    AppMethodBeat.o(70485);
                    return 0;
                case 8:
                    axw.oRa = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(70485);
                    return 0;
                case 9:
                    axw.oRb = aVar3.BTU.readString();
                    AppMethodBeat.o(70485);
                    return 0;
                case 10:
                    axw.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(70485);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        axw.oRc = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(70485);
                    return 0;
                case 12:
                    axw.wCb = aVar3.BTU.readString();
                    AppMethodBeat.o(70485);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        axw.wCc = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(70485);
                    return 0;
                case 14:
                    axw.wCd = aVar3.BTU.vd();
                    AppMethodBeat.o(70485);
                    return 0;
                case 15:
                    axw.wCe = aVar3.BTU.vd();
                    AppMethodBeat.o(70485);
                    return 0;
                default:
                    AppMethodBeat.o(70485);
                    return -1;
            }
        } else {
            AppMethodBeat.o(70485);
            return -1;
        }
    }
}
