package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ud extends a {
    public int guN;
    public String guS;
    public String jBB;
    public String jCH;
    public String ndT;
    public SKBuiltinBuffer_t vEF;
    public int wbA;
    public int wbB;
    public LinkedList<btp> wbC = new LinkedList();
    public String wbD;
    public int wbE;
    public int wbF;
    public int wbG;
    public int wbH;
    public String wbs;
    public String wbt;
    public int wbu;
    public int wbv;
    public String wbw;
    public int wbx;
    public String wby;
    public String wbz;

    public ud() {
        AppMethodBeat.i(28370);
        AppMethodBeat.o(28370);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28371);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(28371);
                throw bVar;
            }
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.wbs != null) {
                aVar.e(3, this.wbs);
            }
            if (this.wbt != null) {
                aVar.e(4, this.wbt);
            }
            aVar.iz(5, this.guN);
            if (this.vEF != null) {
                aVar.iy(6, this.vEF.computeSize());
                this.vEF.writeFields(aVar);
            }
            aVar.iz(7, this.wbu);
            aVar.iz(8, this.wbv);
            if (this.wbw != null) {
                aVar.e(9, this.wbw);
            }
            aVar.iz(10, this.wbx);
            if (this.wby != null) {
                aVar.e(11, this.wby);
            }
            if (this.wbz != null) {
                aVar.e(12, this.wbz);
            }
            aVar.iz(13, this.wbA);
            aVar.iz(14, this.wbB);
            aVar.e(15, 8, this.wbC);
            if (this.wbD != null) {
                aVar.e(16, this.wbD);
            }
            aVar.iz(17, this.wbE);
            aVar.iz(18, this.wbF);
            if (this.ndT != null) {
                aVar.e(19, this.ndT);
            }
            aVar.iz(20, this.wbG);
            aVar.iz(21, this.wbH);
            if (this.guS != null) {
                aVar.e(22, this.guS);
            }
            AppMethodBeat.o(28371);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.wbs != null) {
                f += e.a.a.b.b.a.f(3, this.wbs);
            }
            if (this.wbt != null) {
                f += e.a.a.b.b.a.f(4, this.wbt);
            }
            f += e.a.a.b.b.a.bs(5, this.guN);
            if (this.vEF != null) {
                f += e.a.a.a.ix(6, this.vEF.computeSize());
            }
            f = (f + e.a.a.b.b.a.bs(7, this.wbu)) + e.a.a.b.b.a.bs(8, this.wbv);
            if (this.wbw != null) {
                f += e.a.a.b.b.a.f(9, this.wbw);
            }
            f += e.a.a.b.b.a.bs(10, this.wbx);
            if (this.wby != null) {
                f += e.a.a.b.b.a.f(11, this.wby);
            }
            if (this.wbz != null) {
                f += e.a.a.b.b.a.f(12, this.wbz);
            }
            f = ((f + e.a.a.b.b.a.bs(13, this.wbA)) + e.a.a.b.b.a.bs(14, this.wbB)) + e.a.a.a.c(15, 8, this.wbC);
            if (this.wbD != null) {
                f += e.a.a.b.b.a.f(16, this.wbD);
            }
            f = (f + e.a.a.b.b.a.bs(17, this.wbE)) + e.a.a.b.b.a.bs(18, this.wbF);
            if (this.ndT != null) {
                f += e.a.a.b.b.a.f(19, this.ndT);
            }
            f = (f + e.a.a.b.b.a.bs(20, this.wbG)) + e.a.a.b.b.a.bs(21, this.wbH);
            if (this.guS != null) {
                f += e.a.a.b.b.a.f(22, this.guS);
            }
            AppMethodBeat.o(28371);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(28371);
                throw bVar;
            }
            AppMethodBeat.o(28371);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ud udVar = (ud) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    udVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 2:
                    udVar.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 3:
                    udVar.wbs = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 4:
                    udVar.wbt = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 5:
                    udVar.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        udVar.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28371);
                    return 0;
                case 7:
                    udVar.wbu = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 8:
                    udVar.wbv = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 9:
                    udVar.wbw = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 10:
                    udVar.wbx = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 11:
                    udVar.wby = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 12:
                    udVar.wbz = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 13:
                    udVar.wbA = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 14:
                    udVar.wbB = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btp btp = new btp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btp.populateBuilderWithField(aVar4, btp, a.getNextFieldNumber(aVar4))) {
                        }
                        udVar.wbC.add(btp);
                    }
                    AppMethodBeat.o(28371);
                    return 0;
                case 16:
                    udVar.wbD = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 17:
                    udVar.wbE = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 18:
                    udVar.wbF = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 19:
                    udVar.ndT = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                case 20:
                    udVar.wbG = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 21:
                    udVar.wbH = aVar3.BTU.vd();
                    AppMethodBeat.o(28371);
                    return 0;
                case 22:
                    udVar.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(28371);
                    return 0;
                default:
                    AppMethodBeat.o(28371);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28371);
            return -1;
        }
    }
}
