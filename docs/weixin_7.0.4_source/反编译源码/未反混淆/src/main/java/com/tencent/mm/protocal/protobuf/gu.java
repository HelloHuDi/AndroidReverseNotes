package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class gu extends a {
    public int jCt;
    public int ptD;
    public long ptF;
    public bts vEB;
    public bts vEC;
    public bts vED;
    public String vEG;
    public String vFF;
    public int vIY;
    public int vIZ;
    public int vJa;
    public LinkedList<bts> vJb = new LinkedList();
    public LinkedList<btt> vJc = new LinkedList();
    public SKBuiltinBuffer_t vJd;
    public int vJe;
    public int vJf;
    public int vJg;
    public long vJh;
    public int vJi;

    public gu() {
        AppMethodBeat.i(28333);
        AppMethodBeat.o(28333);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28334);
        b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(28334);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(28334);
                throw bVar;
            } else if (this.vED == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(28334);
                throw bVar;
            } else {
                aVar.iz(1, this.jCt);
                if (this.vFF != null) {
                    aVar.e(2, this.vFF);
                }
                if (this.vEB != null) {
                    aVar.iy(3, this.vEB.computeSize());
                    this.vEB.writeFields(aVar);
                }
                if (this.vEC != null) {
                    aVar.iy(4, this.vEC.computeSize());
                    this.vEC.writeFields(aVar);
                }
                if (this.vED != null) {
                    aVar.iy(5, this.vED.computeSize());
                    this.vED.writeFields(aVar);
                }
                aVar.iz(6, this.vIY);
                aVar.iz(7, this.vIZ);
                if (this.vEG != null) {
                    aVar.e(8, this.vEG);
                }
                aVar.iz(9, this.ptD);
                aVar.iz(10, this.vJa);
                aVar.e(11, 8, this.vJb);
                aVar.e(12, 8, this.vJc);
                if (this.vJd != null) {
                    aVar.iy(13, this.vJd.computeSize());
                    this.vJd.writeFields(aVar);
                }
                aVar.iz(14, this.vJe);
                aVar.iz(15, this.vJf);
                aVar.ai(16, this.ptF);
                aVar.iz(17, this.vJg);
                aVar.ai(18, this.vJh);
                aVar.iz(19, this.vJi);
                AppMethodBeat.o(28334);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCt) + 0;
            if (this.vFF != null) {
                bs += e.a.a.b.b.a.f(2, this.vFF);
            }
            if (this.vEB != null) {
                bs += e.a.a.a.ix(3, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                bs += e.a.a.a.ix(4, this.vEC.computeSize());
            }
            if (this.vED != null) {
                bs += e.a.a.a.ix(5, this.vED.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(6, this.vIY)) + e.a.a.b.b.a.bs(7, this.vIZ);
            if (this.vEG != null) {
                bs += e.a.a.b.b.a.f(8, this.vEG);
            }
            bs = (((bs + e.a.a.b.b.a.bs(9, this.ptD)) + e.a.a.b.b.a.bs(10, this.vJa)) + e.a.a.a.c(11, 8, this.vJb)) + e.a.a.a.c(12, 8, this.vJc);
            if (this.vJd != null) {
                bs += e.a.a.a.ix(13, this.vJd.computeSize());
            }
            bs = (((((bs + e.a.a.b.b.a.bs(14, this.vJe)) + e.a.a.b.b.a.bs(15, this.vJf)) + e.a.a.b.b.a.o(16, this.ptF)) + e.a.a.b.b.a.bs(17, this.vJg)) + e.a.a.b.b.a.o(18, this.vJh)) + e.a.a.b.b.a.bs(19, this.vJi);
            AppMethodBeat.o(28334);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJb.clear();
            this.vJc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(28334);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(28334);
                throw bVar;
            } else if (this.vED == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(28334);
                throw bVar;
            } else {
                AppMethodBeat.o(28334);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gu guVar = (gu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    guVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 2:
                    guVar.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(28334);
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
                        guVar.vEB = bts;
                    }
                    AppMethodBeat.o(28334);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        guVar.vEC = bts;
                    }
                    AppMethodBeat.o(28334);
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
                        guVar.vED = bts;
                    }
                    AppMethodBeat.o(28334);
                    return 0;
                case 6:
                    guVar.vIY = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 7:
                    guVar.vIZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 8:
                    guVar.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(28334);
                    return 0;
                case 9:
                    guVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 10:
                    guVar.vJa = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
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
                        guVar.vJb.add(bts);
                    }
                    AppMethodBeat.o(28334);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btt btt = new btt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btt.populateBuilderWithField(aVar4, btt, a.getNextFieldNumber(aVar4))) {
                        }
                        guVar.vJc.add(btt);
                    }
                    AppMethodBeat.o(28334);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        guVar.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28334);
                    return 0;
                case 14:
                    guVar.vJe = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 15:
                    guVar.vJf = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 16:
                    guVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(28334);
                    return 0;
                case 17:
                    guVar.vJg = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                case 18:
                    guVar.vJh = aVar3.BTU.ve();
                    AppMethodBeat.o(28334);
                    return 0;
                case 19:
                    guVar.vJi = aVar3.BTU.vd();
                    AppMethodBeat.o(28334);
                    return 0;
                default:
                    AppMethodBeat.o(28334);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28334);
            return -1;
        }
    }
}
