package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class jv extends a {
    public mw vMl;
    public mw vMm;
    public mw vMn;
    public SKBuiltinBuffer_t vMo;
    public SKBuiltinBuffer_t vMp;
    public mw vMq;
    public int vMr;
    public mv vMs;
    public mv vMt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(837);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMl != null) {
                aVar.iy(1, this.vMl.computeSize());
                this.vMl.writeFields(aVar);
            }
            if (this.vMm != null) {
                aVar.iy(2, this.vMm.computeSize());
                this.vMm.writeFields(aVar);
            }
            if (this.vMn != null) {
                aVar.iy(4, this.vMn.computeSize());
                this.vMn.writeFields(aVar);
            }
            if (this.vMo != null) {
                aVar.iy(5, this.vMo.computeSize());
                this.vMo.writeFields(aVar);
            }
            if (this.vMp != null) {
                aVar.iy(6, this.vMp.computeSize());
                this.vMp.writeFields(aVar);
            }
            if (this.vMq != null) {
                aVar.iy(7, this.vMq.computeSize());
                this.vMq.writeFields(aVar);
            }
            aVar.iz(8, this.vMr);
            if (this.vMs != null) {
                aVar.iy(9, this.vMs.computeSize());
                this.vMs.writeFields(aVar);
            }
            if (this.vMt != null) {
                aVar.iy(10, this.vMt.computeSize());
                this.vMt.writeFields(aVar);
            }
            AppMethodBeat.o(837);
            return 0;
        } else if (i == 1) {
            if (this.vMl != null) {
                ix = e.a.a.a.ix(1, this.vMl.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMm != null) {
                ix += e.a.a.a.ix(2, this.vMm.computeSize());
            }
            if (this.vMn != null) {
                ix += e.a.a.a.ix(4, this.vMn.computeSize());
            }
            if (this.vMo != null) {
                ix += e.a.a.a.ix(5, this.vMo.computeSize());
            }
            if (this.vMp != null) {
                ix += e.a.a.a.ix(6, this.vMp.computeSize());
            }
            if (this.vMq != null) {
                ix += e.a.a.a.ix(7, this.vMq.computeSize());
            }
            ix += e.a.a.b.b.a.bs(8, this.vMr);
            if (this.vMs != null) {
                ix += e.a.a.a.ix(9, this.vMs.computeSize());
            }
            if (this.vMt != null) {
                ix += e.a.a.a.ix(10, this.vMt.computeSize());
            }
            AppMethodBeat.o(837);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(837);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jv jvVar = (jv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            mw mwVar;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            mv mvVar;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMl = mwVar;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMm = mwVar;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMn = mwVar;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMq = mwVar;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 8:
                    jvVar.vMr = aVar3.BTU.vd();
                    AppMethodBeat.o(837);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mvVar = new mv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mvVar.populateBuilderWithField(aVar4, mvVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMs = mvVar;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mvVar = new mv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mvVar.populateBuilderWithField(aVar4, mvVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jvVar.vMt = mvVar;
                    }
                    AppMethodBeat.o(837);
                    return 0;
                default:
                    AppMethodBeat.o(837);
                    return -1;
            }
        } else {
            AppMethodBeat.o(837);
            return -1;
        }
    }
}
