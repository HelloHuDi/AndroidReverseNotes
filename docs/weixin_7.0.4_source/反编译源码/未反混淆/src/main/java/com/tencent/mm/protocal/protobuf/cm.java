package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cm extends a {
    public int jBT;
    public int nao;
    public int pcX;
    public int ptD;
    public long ptF;
    public bts vEB;
    public bts vEC;
    public bts vED;
    public int vEE;
    public SKBuiltinBuffer_t vEF;
    public String vEG;
    public String vEH;
    public int vEI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58884);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(58884);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(58884);
                throw bVar;
            } else if (this.vED == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(58884);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(58884);
                throw bVar;
            } else {
                aVar.iz(1, this.ptD);
                if (this.vEB != null) {
                    aVar.iy(2, this.vEB.computeSize());
                    this.vEB.writeFields(aVar);
                }
                if (this.vEC != null) {
                    aVar.iy(3, this.vEC.computeSize());
                    this.vEC.writeFields(aVar);
                }
                aVar.iz(4, this.nao);
                if (this.vED != null) {
                    aVar.iy(5, this.vED.computeSize());
                    this.vED.writeFields(aVar);
                }
                aVar.iz(6, this.jBT);
                aVar.iz(7, this.vEE);
                if (this.vEF != null) {
                    aVar.iy(8, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                aVar.iz(9, this.pcX);
                if (this.vEG != null) {
                    aVar.e(10, this.vEG);
                }
                if (this.vEH != null) {
                    aVar.e(11, this.vEH);
                }
                aVar.ai(12, this.ptF);
                aVar.iz(13, this.vEI);
                AppMethodBeat.o(58884);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ptD) + 0;
            if (this.vEB != null) {
                bs += e.a.a.a.ix(2, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                bs += e.a.a.a.ix(3, this.vEC.computeSize());
            }
            bs += e.a.a.b.b.a.bs(4, this.nao);
            if (this.vED != null) {
                bs += e.a.a.a.ix(5, this.vED.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(6, this.jBT)) + e.a.a.b.b.a.bs(7, this.vEE);
            if (this.vEF != null) {
                bs += e.a.a.a.ix(8, this.vEF.computeSize());
            }
            bs += e.a.a.b.b.a.bs(9, this.pcX);
            if (this.vEG != null) {
                bs += e.a.a.b.b.a.f(10, this.vEG);
            }
            if (this.vEH != null) {
                bs += e.a.a.b.b.a.f(11, this.vEH);
            }
            bs = (bs + e.a.a.b.b.a.o(12, this.ptF)) + e.a.a.b.b.a.bs(13, this.vEI);
            AppMethodBeat.o(58884);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(58884);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(58884);
                throw bVar;
            } else if (this.vED == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(58884);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(58884);
                throw bVar;
            } else {
                AppMethodBeat.o(58884);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cm cmVar = (cm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cmVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(58884);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cmVar.vEB = bts;
                    }
                    AppMethodBeat.o(58884);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cmVar.vEC = bts;
                    }
                    AppMethodBeat.o(58884);
                    return 0;
                case 4:
                    cmVar.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(58884);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cmVar.vED = bts;
                    }
                    AppMethodBeat.o(58884);
                    return 0;
                case 6:
                    cmVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(58884);
                    return 0;
                case 7:
                    cmVar.vEE = aVar3.BTU.vd();
                    AppMethodBeat.o(58884);
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
                        cmVar.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58884);
                    return 0;
                case 9:
                    cmVar.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(58884);
                    return 0;
                case 10:
                    cmVar.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(58884);
                    return 0;
                case 11:
                    cmVar.vEH = aVar3.BTU.readString();
                    AppMethodBeat.o(58884);
                    return 0;
                case 12:
                    cmVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(58884);
                    return 0;
                case 13:
                    cmVar.vEI = aVar3.BTU.vd();
                    AppMethodBeat.o(58884);
                    return 0;
                default:
                    AppMethodBeat.o(58884);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58884);
            return -1;
        }
    }
}
