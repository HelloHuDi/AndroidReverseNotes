package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class can extends a {
    public int jCt;
    public String ncM;
    public int pcX;
    public int vFH;
    public brf vFa;
    public String wPm;
    public String wZD;
    public String wZE;
    public int wZF;
    public int wZG;
    public int wZH;
    public long wZI;
    public long wZJ;
    public SKBuiltinBuffer_t wZK;
    public int wZL;
    public String wel;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94563);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPm != null) {
                aVar.e(1, this.wPm);
            }
            if (this.wel != null) {
                aVar.e(2, this.wel);
            }
            if (this.wZD != null) {
                aVar.e(3, this.wZD);
            }
            if (this.wZE != null) {
                aVar.e(4, this.wZE);
            }
            aVar.iz(5, this.jCt);
            aVar.iz(6, this.vFH);
            aVar.iz(7, this.pcX);
            if (this.ncM != null) {
                aVar.e(8, this.ncM);
            }
            aVar.iz(9, this.wZF);
            aVar.iz(10, this.wZG);
            aVar.iz(11, this.wZH);
            aVar.ai(12, this.wZI);
            aVar.ai(13, this.wZJ);
            if (this.wZK != null) {
                aVar.iy(14, this.wZK.computeSize());
                this.wZK.writeFields(aVar);
            }
            aVar.iz(15, this.wZL);
            if (this.vFa != null) {
                aVar.iy(16, this.vFa.computeSize());
                this.vFa.writeFields(aVar);
            }
            AppMethodBeat.o(94563);
            return 0;
        } else if (i == 1) {
            if (this.wPm != null) {
                f = e.a.a.b.b.a.f(1, this.wPm) + 0;
            } else {
                f = 0;
            }
            if (this.wel != null) {
                f += e.a.a.b.b.a.f(2, this.wel);
            }
            if (this.wZD != null) {
                f += e.a.a.b.b.a.f(3, this.wZD);
            }
            if (this.wZE != null) {
                f += e.a.a.b.b.a.f(4, this.wZE);
            }
            f = ((f + e.a.a.b.b.a.bs(5, this.jCt)) + e.a.a.b.b.a.bs(6, this.vFH)) + e.a.a.b.b.a.bs(7, this.pcX);
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(8, this.ncM);
            }
            f = ((((f + e.a.a.b.b.a.bs(9, this.wZF)) + e.a.a.b.b.a.bs(10, this.wZG)) + e.a.a.b.b.a.bs(11, this.wZH)) + e.a.a.b.b.a.o(12, this.wZI)) + e.a.a.b.b.a.o(13, this.wZJ);
            if (this.wZK != null) {
                f += e.a.a.a.ix(14, this.wZK.computeSize());
            }
            f += e.a.a.b.b.a.bs(15, this.wZL);
            if (this.vFa != null) {
                f += e.a.a.a.ix(16, this.vFa.computeSize());
            }
            AppMethodBeat.o(94563);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94563);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            can can = (can) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    can.wPm = aVar3.BTU.readString();
                    AppMethodBeat.o(94563);
                    return 0;
                case 2:
                    can.wel = aVar3.BTU.readString();
                    AppMethodBeat.o(94563);
                    return 0;
                case 3:
                    can.wZD = aVar3.BTU.readString();
                    AppMethodBeat.o(94563);
                    return 0;
                case 4:
                    can.wZE = aVar3.BTU.readString();
                    AppMethodBeat.o(94563);
                    return 0;
                case 5:
                    can.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 6:
                    can.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 7:
                    can.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 8:
                    can.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(94563);
                    return 0;
                case 9:
                    can.wZF = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 10:
                    can.wZG = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 11:
                    can.wZH = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 12:
                    can.wZI = aVar3.BTU.ve();
                    AppMethodBeat.o(94563);
                    return 0;
                case 13:
                    can.wZJ = aVar3.BTU.ve();
                    AppMethodBeat.o(94563);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        can.wZK = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94563);
                    return 0;
                case 15:
                    can.wZL = aVar3.BTU.vd();
                    AppMethodBeat.o(94563);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf brf = new brf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(aVar4, brf, a.getNextFieldNumber(aVar4))) {
                        }
                        can.vFa = brf;
                    }
                    AppMethodBeat.o(94563);
                    return 0;
                default:
                    AppMethodBeat.o(94563);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94563);
            return -1;
        }
    }
}
