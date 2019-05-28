package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bic extends a {
    public String Md5;
    public String Name;
    public String PackName;
    public int Version;
    public int jCo;
    public int ndE;
    public SKBuiltinBuffer_t vFG;
    public SKBuiltinBuffer_t wLt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80153);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ndE);
            aVar.iz(2, this.Version);
            if (this.Name != null) {
                aVar.e(3, this.Name);
            }
            aVar.iz(4, this.jCo);
            if (this.vFG != null) {
                aVar.iy(5, this.vFG.computeSize());
                this.vFG.writeFields(aVar);
            }
            if (this.PackName != null) {
                aVar.e(6, this.PackName);
            }
            if (this.wLt != null) {
                aVar.iy(7, this.wLt.computeSize());
                this.wLt.writeFields(aVar);
            }
            if (this.Md5 != null) {
                aVar.e(8, this.Md5);
            }
            AppMethodBeat.o(80153);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.ndE) + 0) + e.a.a.b.b.a.bs(2, this.Version);
            if (this.Name != null) {
                bs += e.a.a.b.b.a.f(3, this.Name);
            }
            bs += e.a.a.b.b.a.bs(4, this.jCo);
            if (this.vFG != null) {
                bs += e.a.a.a.ix(5, this.vFG.computeSize());
            }
            if (this.PackName != null) {
                bs += e.a.a.b.b.a.f(6, this.PackName);
            }
            if (this.wLt != null) {
                bs += e.a.a.a.ix(7, this.wLt.computeSize());
            }
            if (this.Md5 != null) {
                bs += e.a.a.b.b.a.f(8, this.Md5);
            }
            AppMethodBeat.o(80153);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80153);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bic bic = (bic) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bic.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(80153);
                    return 0;
                case 2:
                    bic.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(80153);
                    return 0;
                case 3:
                    bic.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(80153);
                    return 0;
                case 4:
                    bic.jCo = aVar3.BTU.vd();
                    AppMethodBeat.o(80153);
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
                        bic.vFG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80153);
                    return 0;
                case 6:
                    bic.PackName = aVar3.BTU.readString();
                    AppMethodBeat.o(80153);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bic.wLt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80153);
                    return 0;
                case 8:
                    bic.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(80153);
                    return 0;
                default:
                    AppMethodBeat.o(80153);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80153);
            return -1;
        }
    }
}
