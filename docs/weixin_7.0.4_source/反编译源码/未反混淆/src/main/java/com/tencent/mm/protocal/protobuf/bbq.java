package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import e.a.a.b;
import java.util.LinkedList;

public final class bbq extends a {
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
    public bts wFK;
    public bts wFL;
    public bts wFM;
    public int wGb;
    public int wbA;
    public bts wcB;
    public bts wce;
    public bts wcf;
    public String wsM;
    public bts wyX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5595);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wFK == null) {
                bVar = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wFL == null) {
                bVar = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wFM == null) {
                bVar = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(5595);
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
                aVar.iz(7, this.wGb);
                if (this.wFK != null) {
                    aVar.iy(8, this.wFK.computeSize());
                    this.wFK.writeFields(aVar);
                }
                if (this.wFL != null) {
                    aVar.iy(9, this.wFL.computeSize());
                    this.wFL.writeFields(aVar);
                }
                if (this.wFM != null) {
                    aVar.iy(10, this.wFM.computeSize());
                    this.wFM.writeFields(aVar);
                }
                aVar.iz(11, this.wbA);
                if (this.guO != null) {
                    aVar.e(12, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(13, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(14, this.guQ);
                }
                aVar.iz(15, this.guR);
                aVar.iz(16, this.wBT);
                if (this.wBU != null) {
                    aVar.e(17, this.wBU);
                }
                if (this.wBV != null) {
                    aVar.e(18, this.wBV);
                }
                if (this.wsM != null) {
                    aVar.e(19, this.wsM);
                }
                if (this.wBW != null) {
                    aVar.e(20, this.wBW);
                }
                aVar.iz(21, this.wBX);
                aVar.iz(22, this.guU);
                aVar.iz(23, this.guT);
                if (this.guV != null) {
                    aVar.e(24, this.guV);
                }
                if (this.guS != null) {
                    aVar.e(25, this.guS);
                }
                if (this.wBZ != null) {
                    aVar.iy(26, this.wBZ.computeSize());
                    this.wBZ.writeFields(aVar);
                }
                if (this.guW != null) {
                    aVar.e(27, this.guW);
                }
                if (this.vXm != null) {
                    aVar.e(28, this.vXm);
                }
                if (this.vXn != null) {
                    aVar.e(29, this.vXn);
                }
                if (this.guX != null) {
                    aVar.e(30, this.guX);
                }
                if (this.wCa != null) {
                    aVar.iy(31, this.wCa.computeSize());
                    this.wCa.writeFields(aVar);
                }
                AppMethodBeat.o(5595);
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
            ix += e.a.a.b.b.a.bs(7, this.wGb);
            if (this.wFK != null) {
                ix += e.a.a.a.ix(8, this.wFK.computeSize());
            }
            if (this.wFL != null) {
                ix += e.a.a.a.ix(9, this.wFL.computeSize());
            }
            if (this.wFM != null) {
                ix += e.a.a.a.ix(10, this.wFM.computeSize());
            }
            ix += e.a.a.b.b.a.bs(11, this.wbA);
            if (this.guO != null) {
                ix += e.a.a.b.b.a.f(12, this.guO);
            }
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(13, this.guP);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(14, this.guQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(15, this.guR)) + e.a.a.b.b.a.bs(16, this.wBT);
            if (this.wBU != null) {
                ix += e.a.a.b.b.a.f(17, this.wBU);
            }
            if (this.wBV != null) {
                ix += e.a.a.b.b.a.f(18, this.wBV);
            }
            if (this.wsM != null) {
                ix += e.a.a.b.b.a.f(19, this.wsM);
            }
            if (this.wBW != null) {
                ix += e.a.a.b.b.a.f(20, this.wBW);
            }
            ix = ((ix + e.a.a.b.b.a.bs(21, this.wBX)) + e.a.a.b.b.a.bs(22, this.guU)) + e.a.a.b.b.a.bs(23, this.guT);
            if (this.guV != null) {
                ix += e.a.a.b.b.a.f(24, this.guV);
            }
            if (this.guS != null) {
                ix += e.a.a.b.b.a.f(25, this.guS);
            }
            if (this.wBZ != null) {
                ix += e.a.a.a.ix(26, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(27, this.guW);
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(28, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(29, this.vXn);
            }
            if (this.guX != null) {
                ix += e.a.a.b.b.a.f(30, this.guX);
            }
            if (this.wCa != null) {
                ix += e.a.a.a.ix(31, this.wCa.computeSize());
            }
            AppMethodBeat.o(5595);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wFK == null) {
                bVar = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wFL == null) {
                bVar = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(5595);
                throw bVar;
            } else if (this.wFM == null) {
                bVar = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(5595);
                throw bVar;
            } else {
                AppMethodBeat.o(5595);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbq bbq = (bbq) objArr[1];
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
                        bbq.wcB = bts;
                    }
                    AppMethodBeat.o(5595);
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
                        bbq.wyX = bts;
                    }
                    AppMethodBeat.o(5595);
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
                        bbq.wce = bts;
                    }
                    AppMethodBeat.o(5595);
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
                        bbq.wcf = bts;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                case 5:
                    bbq.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
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
                        bbq.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                case 7:
                    bbq.wGb = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbq.wFK = bts;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbq.wFL = bts;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbq.wFM = bts;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                case 11:
                    bbq.wbA = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 12:
                    bbq.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 13:
                    bbq.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 14:
                    bbq.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 15:
                    bbq.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 16:
                    bbq.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 17:
                    bbq.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 18:
                    bbq.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 19:
                    bbq.wsM = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 20:
                    bbq.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 21:
                    bbq.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 22:
                    bbq.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 23:
                    bbq.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(5595);
                    return 0;
                case 24:
                    bbq.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 25:
                    bbq.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 26:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        bbq.wBZ = ccl;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                case 27:
                    bbq.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bbq.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 29:
                    bbq.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 30:
                    bbq.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(5595);
                    return 0;
                case 31:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bbq.wCa = uyVar;
                    }
                    AppMethodBeat.o(5595);
                    return 0;
                default:
                    AppMethodBeat.o(5595);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5595);
            return -1;
        }
    }
}
