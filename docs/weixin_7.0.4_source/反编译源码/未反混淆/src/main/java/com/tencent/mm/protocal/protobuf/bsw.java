package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bsw extends a {
    public int vQW;
    public int vek;
    public int wOI;
    public bsz wUV;
    public bsy wUW;
    public int wUX;
    public String wUY;
    public int wUZ;
    public int wVa;
    public int wVb;
    public int wpk;
    public int wxG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80162);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUY == null) {
                bVar = new b("Not all required fields were included: SampleId");
                AppMethodBeat.o(80162);
                throw bVar;
            }
            aVar.iz(1, this.wOI);
            if (this.wUV != null) {
                aVar.iy(2, this.wUV.computeSize());
                this.wUV.writeFields(aVar);
            }
            if (this.wUW != null) {
                aVar.iy(3, this.wUW.computeSize());
                this.wUW.writeFields(aVar);
            }
            aVar.iz(4, this.wpk);
            aVar.iz(5, this.wUX);
            if (this.wUY != null) {
                aVar.e(6, this.wUY);
            }
            aVar.iz(7, this.vQW);
            aVar.iz(8, this.wUZ);
            aVar.iz(9, this.vek);
            aVar.iz(10, this.wVa);
            aVar.iz(11, this.wVb);
            aVar.iz(12, this.wxG);
            AppMethodBeat.o(80162);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wOI) + 0;
            if (this.wUV != null) {
                bs += e.a.a.a.ix(2, this.wUV.computeSize());
            }
            if (this.wUW != null) {
                bs += e.a.a.a.ix(3, this.wUW.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(4, this.wpk)) + e.a.a.b.b.a.bs(5, this.wUX);
            if (this.wUY != null) {
                bs += e.a.a.b.b.a.f(6, this.wUY);
            }
            bs = (((((bs + e.a.a.b.b.a.bs(7, this.vQW)) + e.a.a.b.b.a.bs(8, this.wUZ)) + e.a.a.b.b.a.bs(9, this.vek)) + e.a.a.b.b.a.bs(10, this.wVa)) + e.a.a.b.b.a.bs(11, this.wVb)) + e.a.a.b.b.a.bs(12, this.wxG);
            AppMethodBeat.o(80162);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wUY == null) {
                bVar = new b("Not all required fields were included: SampleId");
                AppMethodBeat.o(80162);
                throw bVar;
            }
            AppMethodBeat.o(80162);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsw bsw = (bsw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bsw.wOI = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsz bsz = new bsz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.populateBuilderWithField(aVar4, bsz, a.getNextFieldNumber(aVar4))) {
                        }
                        bsw.wUV = bsz;
                    }
                    AppMethodBeat.o(80162);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsy bsy = new bsy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsy.populateBuilderWithField(aVar4, bsy, a.getNextFieldNumber(aVar4))) {
                        }
                        bsw.wUW = bsy;
                    }
                    AppMethodBeat.o(80162);
                    return 0;
                case 4:
                    bsw.wpk = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 5:
                    bsw.wUX = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 6:
                    bsw.wUY = aVar3.BTU.readString();
                    AppMethodBeat.o(80162);
                    return 0;
                case 7:
                    bsw.vQW = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 8:
                    bsw.wUZ = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 9:
                    bsw.vek = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 10:
                    bsw.wVa = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 11:
                    bsw.wVb = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                case 12:
                    bsw.wxG = aVar3.BTU.vd();
                    AppMethodBeat.o(80162);
                    return 0;
                default:
                    AppMethodBeat.o(80162);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80162);
            return -1;
        }
    }
}
