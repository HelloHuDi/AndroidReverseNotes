package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class hh extends a {
    public SKBuiltinBuffer_t vHM;
    public SKBuiltinBuffer_t vHN;
    public String vHS;
    public SKBuiltinBuffer_t vJT;
    public csd vJU;
    public cwd vJV;
    public int vJW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58891);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJT != null) {
                aVar.iy(1, this.vJT.computeSize());
                this.vJT.writeFields(aVar);
            }
            if (this.vJU != null) {
                aVar.iy(2, this.vJU.computeSize());
                this.vJU.writeFields(aVar);
            }
            if (this.vJV != null) {
                aVar.iy(3, this.vJV.computeSize());
                this.vJV.writeFields(aVar);
            }
            if (this.vHM != null) {
                aVar.iy(4, this.vHM.computeSize());
                this.vHM.writeFields(aVar);
            }
            if (this.vHN != null) {
                aVar.iy(5, this.vHN.computeSize());
                this.vHN.writeFields(aVar);
            }
            aVar.iz(6, this.vJW);
            if (this.vHS != null) {
                aVar.e(7, this.vHS);
            }
            AppMethodBeat.o(58891);
            return 0;
        } else if (i == 1) {
            if (this.vJT != null) {
                ix = e.a.a.a.ix(1, this.vJT.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vJU != null) {
                ix += e.a.a.a.ix(2, this.vJU.computeSize());
            }
            if (this.vJV != null) {
                ix += e.a.a.a.ix(3, this.vJV.computeSize());
            }
            if (this.vHM != null) {
                ix += e.a.a.a.ix(4, this.vHM.computeSize());
            }
            if (this.vHN != null) {
                ix += e.a.a.a.ix(5, this.vHN.computeSize());
            }
            ix += e.a.a.b.b.a.bs(6, this.vJW);
            if (this.vHS != null) {
                ix += e.a.a.b.b.a.f(7, this.vHS);
            }
            AppMethodBeat.o(58891);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58891);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hh hhVar = (hh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        hhVar.vJT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58891);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csd csd = new csd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csd.populateBuilderWithField(aVar4, csd, a.getNextFieldNumber(aVar4))) {
                        }
                        hhVar.vJU = csd;
                    }
                    AppMethodBeat.o(58891);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwd cwd = new cwd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwd.populateBuilderWithField(aVar4, cwd, a.getNextFieldNumber(aVar4))) {
                        }
                        hhVar.vJV = cwd;
                    }
                    AppMethodBeat.o(58891);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        hhVar.vHM = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58891);
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
                        hhVar.vHN = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58891);
                    return 0;
                case 6:
                    hhVar.vJW = aVar3.BTU.vd();
                    AppMethodBeat.o(58891);
                    return 0;
                case 7:
                    hhVar.vHS = aVar3.BTU.readString();
                    AppMethodBeat.o(58891);
                    return 0;
                default:
                    AppMethodBeat.o(58891);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58891);
            return -1;
        }
    }
}
