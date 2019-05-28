package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class mw extends a {
    public int luF;
    public int vQV;
    public int vQW;
    public int vQX;
    public int vQY;
    public LinkedList<bts> vQZ = new LinkedList();
    public String vRa;
    public SKBuiltinBuffer_t vRb;
    public int vRc;
    public int vRd;
    public LinkedList<bts> vRe = new LinkedList();
    public LinkedList<mx> vRf = new LinkedList();
    public LinkedList<mx> vRg = new LinkedList();
    public int vRh;
    public int vRi;

    public mw() {
        AppMethodBeat.i(58898);
        AppMethodBeat.o(58898);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58899);
        b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRb == null) {
                bVar = new b("Not all required fields were included: AuthKey");
                AppMethodBeat.o(58899);
                throw bVar;
            }
            aVar.iz(1, this.vQV);
            aVar.iz(2, this.luF);
            aVar.iz(3, this.vQW);
            aVar.iz(4, this.vQX);
            aVar.iz(5, this.vQY);
            aVar.e(6, 8, this.vQZ);
            if (this.vRa != null) {
                aVar.e(7, this.vRa);
            }
            if (this.vRb != null) {
                aVar.iy(8, this.vRb.computeSize());
                this.vRb.writeFields(aVar);
            }
            aVar.iz(9, this.vRc);
            aVar.iz(10, this.vRd);
            aVar.e(11, 8, this.vRe);
            aVar.e(12, 8, this.vRf);
            aVar.e(13, 8, this.vRg);
            aVar.iz(14, this.vRh);
            aVar.iz(15, this.vRi);
            AppMethodBeat.o(58899);
            return 0;
        } else if (i == 1) {
            bs = (((((e.a.a.b.b.a.bs(1, this.vQV) + 0) + e.a.a.b.b.a.bs(2, this.luF)) + e.a.a.b.b.a.bs(3, this.vQW)) + e.a.a.b.b.a.bs(4, this.vQX)) + e.a.a.b.b.a.bs(5, this.vQY)) + e.a.a.a.c(6, 8, this.vQZ);
            if (this.vRa != null) {
                bs += e.a.a.b.b.a.f(7, this.vRa);
            }
            if (this.vRb != null) {
                bs += e.a.a.a.ix(8, this.vRb.computeSize());
            }
            bs = ((((((bs + e.a.a.b.b.a.bs(9, this.vRc)) + e.a.a.b.b.a.bs(10, this.vRd)) + e.a.a.a.c(11, 8, this.vRe)) + e.a.a.a.c(12, 8, this.vRf)) + e.a.a.a.c(13, 8, this.vRg)) + e.a.a.b.b.a.bs(14, this.vRh)) + e.a.a.b.b.a.bs(15, this.vRi);
            AppMethodBeat.o(58899);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQZ.clear();
            this.vRe.clear();
            this.vRf.clear();
            this.vRg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vRb == null) {
                bVar = new b("Not all required fields were included: AuthKey");
                AppMethodBeat.o(58899);
                throw bVar;
            }
            AppMethodBeat.o(58899);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mw mwVar = (mw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            mx mxVar;
            switch (intValue) {
                case 1:
                    mwVar.vQV = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 2:
                    mwVar.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 3:
                    mwVar.vQW = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 4:
                    mwVar.vQX = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 5:
                    mwVar.vQY = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        mwVar.vQZ.add(bts);
                    }
                    AppMethodBeat.o(58899);
                    return 0;
                case 7:
                    mwVar.vRa = aVar3.BTU.readString();
                    AppMethodBeat.o(58899);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        mwVar.vRb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58899);
                    return 0;
                case 9:
                    mwVar.vRc = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 10:
                    mwVar.vRd = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        mwVar.vRe.add(bts);
                    }
                    AppMethodBeat.o(58899);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mxVar = new mx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mxVar.populateBuilderWithField(aVar4, mxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mwVar.vRf.add(mxVar);
                    }
                    AppMethodBeat.o(58899);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mxVar = new mx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mxVar.populateBuilderWithField(aVar4, mxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mwVar.vRg.add(mxVar);
                    }
                    AppMethodBeat.o(58899);
                    return 0;
                case 14:
                    mwVar.vRh = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                case 15:
                    mwVar.vRi = aVar3.BTU.vd();
                    AppMethodBeat.o(58899);
                    return 0;
                default:
                    AppMethodBeat.o(58899);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58899);
            return -1;
        }
    }
}
