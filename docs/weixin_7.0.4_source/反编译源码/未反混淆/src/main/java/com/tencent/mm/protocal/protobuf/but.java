package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class but extends a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public int guT;
    public int guU;
    public String guV;
    public String guW;
    public String guX;
    public SKBuiltinBuffer_t vEF;
    public String vXm;
    public String vXn;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public ccl wBZ;
    public uy wCa;
    public int wWh;
    public bts wcB;
    public bts wce;
    public bts wcf;
    public String wlF;
    public bts wyX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80175);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(80175);
                throw bVar;
            } else {
                if (this.wcB != null) {
                    aVar.iy(1, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                if (this.wyX != null) {
                    aVar.iy(2, this.wyX.computeSize());
                    this.wyX.writeFields(aVar);
                }
                if (this.wce != null) {
                    aVar.iy(3, this.wce.computeSize());
                    this.wce.writeFields(aVar);
                }
                if (this.wcf != null) {
                    aVar.iy(4, this.wcf.computeSize());
                    this.wcf.writeFields(aVar);
                }
                aVar.iz(5, this.guN);
                if (this.vEF != null) {
                    aVar.iy(6, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                if (this.guO != null) {
                    aVar.e(7, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(8, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(9, this.guQ);
                }
                aVar.iz(10, this.guR);
                aVar.iz(11, this.wBT);
                if (this.wBU != null) {
                    aVar.e(12, this.wBU);
                }
                if (this.wBV != null) {
                    aVar.e(13, this.wBV);
                }
                if (this.guS != null) {
                    aVar.e(14, this.guS);
                }
                if (this.wBW != null) {
                    aVar.e(15, this.wBW);
                }
                aVar.iz(16, this.wBX);
                aVar.iz(17, this.guU);
                aVar.iz(18, this.guT);
                if (this.guV != null) {
                    aVar.e(19, this.guV);
                }
                if (this.wBZ != null) {
                    aVar.iy(20, this.wBZ.computeSize());
                    this.wBZ.writeFields(aVar);
                }
                if (this.guW != null) {
                    aVar.e(21, this.guW);
                }
                if (this.guX != null) {
                    aVar.e(22, this.guX);
                }
                if (this.wCa != null) {
                    aVar.iy(23, this.wCa.computeSize());
                    this.wCa.writeFields(aVar);
                }
                if (this.vXm != null) {
                    aVar.e(24, this.vXm);
                }
                if (this.vXn != null) {
                    aVar.e(25, this.vXn);
                }
                if (this.wlF != null) {
                    aVar.e(26, this.wlF);
                }
                aVar.iz(27, this.wWh);
                AppMethodBeat.o(80175);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = e.a.a.a.ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wyX != null) {
                ix += e.a.a.a.ix(2, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += e.a.a.a.ix(3, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += e.a.a.a.ix(4, this.wcf.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.guN);
            if (this.vEF != null) {
                ix += e.a.a.a.ix(6, this.vEF.computeSize());
            }
            if (this.guO != null) {
                ix += e.a.a.b.b.a.f(7, this.guO);
            }
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(8, this.guP);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(9, this.guQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(10, this.guR)) + e.a.a.b.b.a.bs(11, this.wBT);
            if (this.wBU != null) {
                ix += e.a.a.b.b.a.f(12, this.wBU);
            }
            if (this.wBV != null) {
                ix += e.a.a.b.b.a.f(13, this.wBV);
            }
            if (this.guS != null) {
                ix += e.a.a.b.b.a.f(14, this.guS);
            }
            if (this.wBW != null) {
                ix += e.a.a.b.b.a.f(15, this.wBW);
            }
            ix = ((ix + e.a.a.b.b.a.bs(16, this.wBX)) + e.a.a.b.b.a.bs(17, this.guU)) + e.a.a.b.b.a.bs(18, this.guT);
            if (this.guV != null) {
                ix += e.a.a.b.b.a.f(19, this.guV);
            }
            if (this.wBZ != null) {
                ix += e.a.a.a.ix(20, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(21, this.guW);
            }
            if (this.guX != null) {
                ix += e.a.a.b.b.a.f(22, this.guX);
            }
            if (this.wCa != null) {
                ix += e.a.a.a.ix(23, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(24, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(25, this.vXn);
            }
            if (this.wlF != null) {
                ix += e.a.a.b.b.a.f(26, this.wlF);
            }
            int bs = ix + e.a.a.b.b.a.bs(27, this.wWh);
            AppMethodBeat.o(80175);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(80175);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(80175);
                throw bVar;
            } else {
                AppMethodBeat.o(80175);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            but but = (but) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        but.wcB = bts;
                    }
                    AppMethodBeat.o(80175);
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
                        but.wyX = bts;
                    }
                    AppMethodBeat.o(80175);
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
                        but.wce = bts;
                    }
                    AppMethodBeat.o(80175);
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
                        but.wcf = bts;
                    }
                    AppMethodBeat.o(80175);
                    return 0;
                case 5:
                    but.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
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
                        but.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80175);
                    return 0;
                case 7:
                    but.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 8:
                    but.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 9:
                    but.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 10:
                    but.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
                    return 0;
                case 11:
                    but.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
                    return 0;
                case 12:
                    but.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 13:
                    but.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 14:
                    but.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 15:
                    but.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 16:
                    but.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
                    return 0;
                case 17:
                    but.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
                    return 0;
                case 18:
                    but.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
                    return 0;
                case 19:
                    but.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        but.wBZ = ccl;
                    }
                    AppMethodBeat.o(80175);
                    return 0;
                case 21:
                    but.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 22:
                    but.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        but.wCa = uyVar;
                    }
                    AppMethodBeat.o(80175);
                    return 0;
                case 24:
                    but.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 25:
                    but.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 26:
                    but.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(80175);
                    return 0;
                case 27:
                    but.wWh = aVar3.BTU.vd();
                    AppMethodBeat.o(80175);
                    return 0;
                default:
                    AppMethodBeat.o(80175);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80175);
            return -1;
        }
    }
}
