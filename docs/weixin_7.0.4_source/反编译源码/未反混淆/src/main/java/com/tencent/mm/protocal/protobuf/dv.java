package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class dv extends a {
    public String fKh;
    public int jCt;
    public String ncM;
    public String ndF;
    public String ndG;
    public int pcX;
    public String vEG;
    public int vFE;
    public String vFF;
    public SKBuiltinBuffer_t vFG;
    public int vFH;
    public int vFI;
    public String vFJ;
    public String vFK;
    public String vFL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28312);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndG != null) {
                aVar.e(1, this.ndG);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            aVar.iz(3, this.vFE);
            if (this.ndF != null) {
                aVar.e(4, this.ndF);
            }
            aVar.iz(5, this.jCt);
            if (this.ncM != null) {
                aVar.e(6, this.ncM);
            }
            aVar.iz(7, this.pcX);
            if (this.vFF != null) {
                aVar.e(8, this.vFF);
            }
            if (this.vFG != null) {
                aVar.iy(9, this.vFG.computeSize());
                this.vFG.writeFields(aVar);
            }
            aVar.iz(10, this.vFH);
            aVar.iz(11, this.vFI);
            if (this.vEG != null) {
                aVar.e(12, this.vEG);
            }
            if (this.vFJ != null) {
                aVar.e(13, this.vFJ);
            }
            if (this.vFK != null) {
                aVar.e(14, this.vFK);
            }
            if (this.vFL != null) {
                aVar.e(15, this.vFL);
            }
            AppMethodBeat.o(28312);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = e.a.a.b.b.a.f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(2, this.fKh);
            }
            f += e.a.a.b.b.a.bs(3, this.vFE);
            if (this.ndF != null) {
                f += e.a.a.b.b.a.f(4, this.ndF);
            }
            f += e.a.a.b.b.a.bs(5, this.jCt);
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(6, this.ncM);
            }
            f += e.a.a.b.b.a.bs(7, this.pcX);
            if (this.vFF != null) {
                f += e.a.a.b.b.a.f(8, this.vFF);
            }
            if (this.vFG != null) {
                f += e.a.a.a.ix(9, this.vFG.computeSize());
            }
            f = (f + e.a.a.b.b.a.bs(10, this.vFH)) + e.a.a.b.b.a.bs(11, this.vFI);
            if (this.vEG != null) {
                f += e.a.a.b.b.a.f(12, this.vEG);
            }
            if (this.vFJ != null) {
                f += e.a.a.b.b.a.f(13, this.vFJ);
            }
            if (this.vFK != null) {
                f += e.a.a.b.b.a.f(14, this.vFK);
            }
            if (this.vFL != null) {
                f += e.a.a.b.b.a.f(15, this.vFL);
            }
            AppMethodBeat.o(28312);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28312);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dv dvVar = (dv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvVar.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 2:
                    dvVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 3:
                    dvVar.vFE = aVar3.BTU.vd();
                    AppMethodBeat.o(28312);
                    return 0;
                case 4:
                    dvVar.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 5:
                    dvVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28312);
                    return 0;
                case 6:
                    dvVar.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 7:
                    dvVar.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(28312);
                    return 0;
                case 8:
                    dvVar.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 9:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dvVar.vFG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28312);
                    return 0;
                case 10:
                    dvVar.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(28312);
                    return 0;
                case 11:
                    dvVar.vFI = aVar3.BTU.vd();
                    AppMethodBeat.o(28312);
                    return 0;
                case 12:
                    dvVar.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 13:
                    dvVar.vFJ = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 14:
                    dvVar.vFK = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                case 15:
                    dvVar.vFL = aVar3.BTU.readString();
                    AppMethodBeat.o(28312);
                    return 0;
                default:
                    AppMethodBeat.o(28312);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28312);
            return -1;
        }
    }
}
