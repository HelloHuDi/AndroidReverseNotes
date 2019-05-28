package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jq extends bsr {
    public SKBuiltinBuffer_t vJT;
    public String vLJ;
    public int vLV;
    public String vLW;
    public String vLX;
    public String vLY;
    public int vLZ;
    public String vLx;
    public String vLy;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public int vMc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73695);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vLV);
            if (this.vLJ != null) {
                aVar.e(3, this.vLJ);
            }
            if (this.vLW != null) {
                aVar.e(4, this.vLW);
            }
            if (this.vLX != null) {
                aVar.e(5, this.vLX);
            }
            if (this.vLY != null) {
                aVar.e(6, this.vLY);
            }
            aVar.iz(7, this.vLZ);
            if (this.vMa != null) {
                aVar.iy(8, this.vMa.computeSize());
                this.vMa.writeFields(aVar);
            }
            if (this.vMb != null) {
                aVar.iy(9, this.vMb.computeSize());
                this.vMb.writeFields(aVar);
            }
            aVar.iz(10, this.vMc);
            if (this.vLx != null) {
                aVar.e(11, this.vLx);
            }
            if (this.vLy != null) {
                aVar.e(12, this.vLy);
            }
            if (this.vJT != null) {
                aVar.iy(13, this.vJT.computeSize());
                this.vJT.writeFields(aVar);
            }
            AppMethodBeat.o(73695);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.vLV);
            if (this.vLJ != null) {
                ix += e.a.a.b.b.a.f(3, this.vLJ);
            }
            if (this.vLW != null) {
                ix += e.a.a.b.b.a.f(4, this.vLW);
            }
            if (this.vLX != null) {
                ix += e.a.a.b.b.a.f(5, this.vLX);
            }
            if (this.vLY != null) {
                ix += e.a.a.b.b.a.f(6, this.vLY);
            }
            ix += e.a.a.b.b.a.bs(7, this.vLZ);
            if (this.vMa != null) {
                ix += e.a.a.a.ix(8, this.vMa.computeSize());
            }
            if (this.vMb != null) {
                ix += e.a.a.a.ix(9, this.vMb.computeSize());
            }
            ix += e.a.a.b.b.a.bs(10, this.vMc);
            if (this.vLx != null) {
                ix += e.a.a.b.b.a.f(11, this.vLx);
            }
            if (this.vLy != null) {
                ix += e.a.a.b.b.a.f(12, this.vLy);
            }
            if (this.vJT != null) {
                ix += e.a.a.a.ix(13, this.vJT.computeSize());
            }
            AppMethodBeat.o(73695);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73695);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jq jqVar = (jq) objArr[1];
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
                        jqVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73695);
                    return 0;
                case 2:
                    jqVar.vLV = aVar3.BTU.vd();
                    AppMethodBeat.o(73695);
                    return 0;
                case 3:
                    jqVar.vLJ = aVar3.BTU.readString();
                    AppMethodBeat.o(73695);
                    return 0;
                case 4:
                    jqVar.vLW = aVar3.BTU.readString();
                    AppMethodBeat.o(73695);
                    return 0;
                case 5:
                    jqVar.vLX = aVar3.BTU.readString();
                    AppMethodBeat.o(73695);
                    return 0;
                case 6:
                    jqVar.vLY = aVar3.BTU.readString();
                    AppMethodBeat.o(73695);
                    return 0;
                case 7:
                    jqVar.vLZ = aVar3.BTU.vd();
                    AppMethodBeat.o(73695);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jqVar.vMa = bts;
                    }
                    AppMethodBeat.o(73695);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jqVar.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73695);
                    return 0;
                case 10:
                    jqVar.vMc = aVar3.BTU.vd();
                    AppMethodBeat.o(73695);
                    return 0;
                case 11:
                    jqVar.vLx = aVar3.BTU.readString();
                    AppMethodBeat.o(73695);
                    return 0;
                case 12:
                    jqVar.vLy = aVar3.BTU.readString();
                    AppMethodBeat.o(73695);
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
                        jqVar.vJT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73695);
                    return 0;
                default:
                    AppMethodBeat.o(73695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73695);
            return -1;
        }
    }
}
