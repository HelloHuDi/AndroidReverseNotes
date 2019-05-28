package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnf extends a {
    public String pXM;
    public int vGB;
    public String wVn;
    public String wlF;
    public String wlx;
    public String xkE;
    public int xkF;
    public String xkG;
    public String xkH;
    public int xkI;
    public String xkJ;
    public int xkK;
    public SKBuiltinBuffer_t xkL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80207);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pXM != null) {
                aVar.e(1, this.pXM);
            }
            if (this.xkE != null) {
                aVar.e(2, this.xkE);
            }
            if (this.wlF != null) {
                aVar.e(3, this.wlF);
            }
            aVar.iz(4, this.xkF);
            if (this.wVn != null) {
                aVar.e(5, this.wVn);
            }
            if (this.xkG != null) {
                aVar.e(6, this.xkG);
            }
            if (this.xkH != null) {
                aVar.e(7, this.xkH);
            }
            aVar.iz(8, this.xkI);
            if (this.xkJ != null) {
                aVar.e(9, this.xkJ);
            }
            aVar.iz(10, this.xkK);
            if (this.xkL != null) {
                aVar.iy(11, this.xkL.computeSize());
                this.xkL.writeFields(aVar);
            }
            if (this.wlx != null) {
                aVar.e(12, this.wlx);
            }
            aVar.iz(13, this.vGB);
            AppMethodBeat.o(80207);
            return 0;
        } else if (i == 1) {
            if (this.pXM != null) {
                f = e.a.a.b.b.a.f(1, this.pXM) + 0;
            } else {
                f = 0;
            }
            if (this.xkE != null) {
                f += e.a.a.b.b.a.f(2, this.xkE);
            }
            if (this.wlF != null) {
                f += e.a.a.b.b.a.f(3, this.wlF);
            }
            f += e.a.a.b.b.a.bs(4, this.xkF);
            if (this.wVn != null) {
                f += e.a.a.b.b.a.f(5, this.wVn);
            }
            if (this.xkG != null) {
                f += e.a.a.b.b.a.f(6, this.xkG);
            }
            if (this.xkH != null) {
                f += e.a.a.b.b.a.f(7, this.xkH);
            }
            f += e.a.a.b.b.a.bs(8, this.xkI);
            if (this.xkJ != null) {
                f += e.a.a.b.b.a.f(9, this.xkJ);
            }
            f += e.a.a.b.b.a.bs(10, this.xkK);
            if (this.xkL != null) {
                f += e.a.a.a.ix(11, this.xkL.computeSize());
            }
            if (this.wlx != null) {
                f += e.a.a.b.b.a.f(12, this.wlx);
            }
            int bs = f + e.a.a.b.b.a.bs(13, this.vGB);
            AppMethodBeat.o(80207);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80207);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnf cnf = (cnf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnf.pXM = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 2:
                    cnf.xkE = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 3:
                    cnf.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 4:
                    cnf.xkF = aVar3.BTU.vd();
                    AppMethodBeat.o(80207);
                    return 0;
                case 5:
                    cnf.wVn = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 6:
                    cnf.xkG = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 7:
                    cnf.xkH = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 8:
                    cnf.xkI = aVar3.BTU.vd();
                    AppMethodBeat.o(80207);
                    return 0;
                case 9:
                    cnf.xkJ = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 10:
                    cnf.xkK = aVar3.BTU.vd();
                    AppMethodBeat.o(80207);
                    return 0;
                case 11:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cnf.xkL = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80207);
                    return 0;
                case 12:
                    cnf.wlx = aVar3.BTU.readString();
                    AppMethodBeat.o(80207);
                    return 0;
                case 13:
                    cnf.vGB = aVar3.BTU.vd();
                    AppMethodBeat.o(80207);
                    return 0;
                default:
                    AppMethodBeat.o(80207);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80207);
            return -1;
        }
    }
}
