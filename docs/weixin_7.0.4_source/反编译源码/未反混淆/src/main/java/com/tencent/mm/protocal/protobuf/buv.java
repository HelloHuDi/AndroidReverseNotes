package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buv extends btd {
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
    public SKBuiltinBuffer_t wWj;
    public String wWk;
    public String wWl;
    public int wWm;
    public LinkedList<bvk> wWn = new LinkedList();
    public bts wcB;
    public bts wce;
    public bts wcf;
    public String wlF;
    public int wod;
    public LinkedList<but> woe = new LinkedList();
    public bts wyX;

    public buv() {
        AppMethodBeat.i(80177);
        AppMethodBeat.o(80177);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80178);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(80178);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wcB != null) {
                    aVar.iy(2, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                if (this.wyX != null) {
                    aVar.iy(3, this.wyX.computeSize());
                    this.wyX.writeFields(aVar);
                }
                if (this.wce != null) {
                    aVar.iy(4, this.wce.computeSize());
                    this.wce.writeFields(aVar);
                }
                if (this.wcf != null) {
                    aVar.iy(5, this.wcf.computeSize());
                    this.wcf.writeFields(aVar);
                }
                aVar.iz(6, this.guN);
                if (this.vEF != null) {
                    aVar.iy(7, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                if (this.guO != null) {
                    aVar.e(8, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(9, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(10, this.guQ);
                }
                aVar.iz(11, this.guR);
                aVar.iz(12, this.wBT);
                if (this.wBU != null) {
                    aVar.e(13, this.wBU);
                }
                if (this.wBV != null) {
                    aVar.e(14, this.wBV);
                }
                if (this.guS != null) {
                    aVar.e(15, this.guS);
                }
                if (this.wBW != null) {
                    aVar.e(16, this.wBW);
                }
                aVar.iz(17, this.wBX);
                aVar.iz(18, this.guU);
                aVar.iz(19, this.guT);
                if (this.guV != null) {
                    aVar.e(20, this.guV);
                }
                if (this.wBZ != null) {
                    aVar.iy(21, this.wBZ.computeSize());
                    this.wBZ.writeFields(aVar);
                }
                if (this.guW != null) {
                    aVar.e(22, this.guW);
                }
                if (this.guX != null) {
                    aVar.e(23, this.guX);
                }
                if (this.wCa != null) {
                    aVar.iy(24, this.wCa.computeSize());
                    this.wCa.writeFields(aVar);
                }
                aVar.iz(25, this.wod);
                aVar.e(26, 8, this.woe);
                if (this.vXm != null) {
                    aVar.e(27, this.vXm);
                }
                if (this.vXn != null) {
                    aVar.e(28, this.vXn);
                }
                if (this.wWj != null) {
                    aVar.iy(29, this.wWj.computeSize());
                    this.wWj.writeFields(aVar);
                }
                if (this.wlF != null) {
                    aVar.e(30, this.wlF);
                }
                if (this.wWk != null) {
                    aVar.e(31, this.wWk);
                }
                aVar.iz(32, this.wWh);
                if (this.wWl != null) {
                    aVar.e(33, this.wWl);
                }
                aVar.iz(34, this.wWm);
                aVar.e(35, 8, this.wWn);
                AppMethodBeat.o(80178);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcB != null) {
                ix += e.a.a.a.ix(2, this.wcB.computeSize());
            }
            if (this.wyX != null) {
                ix += e.a.a.a.ix(3, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += e.a.a.a.ix(4, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += e.a.a.a.ix(5, this.wcf.computeSize());
            }
            ix += e.a.a.b.b.a.bs(6, this.guN);
            if (this.vEF != null) {
                ix += e.a.a.a.ix(7, this.vEF.computeSize());
            }
            if (this.guO != null) {
                ix += e.a.a.b.b.a.f(8, this.guO);
            }
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(9, this.guP);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(10, this.guQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(11, this.guR)) + e.a.a.b.b.a.bs(12, this.wBT);
            if (this.wBU != null) {
                ix += e.a.a.b.b.a.f(13, this.wBU);
            }
            if (this.wBV != null) {
                ix += e.a.a.b.b.a.f(14, this.wBV);
            }
            if (this.guS != null) {
                ix += e.a.a.b.b.a.f(15, this.guS);
            }
            if (this.wBW != null) {
                ix += e.a.a.b.b.a.f(16, this.wBW);
            }
            ix = ((ix + e.a.a.b.b.a.bs(17, this.wBX)) + e.a.a.b.b.a.bs(18, this.guU)) + e.a.a.b.b.a.bs(19, this.guT);
            if (this.guV != null) {
                ix += e.a.a.b.b.a.f(20, this.guV);
            }
            if (this.wBZ != null) {
                ix += e.a.a.a.ix(21, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(22, this.guW);
            }
            if (this.guX != null) {
                ix += e.a.a.b.b.a.f(23, this.guX);
            }
            if (this.wCa != null) {
                ix += e.a.a.a.ix(24, this.wCa.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(25, this.wod)) + e.a.a.a.c(26, 8, this.woe);
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(27, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(28, this.vXn);
            }
            if (this.wWj != null) {
                ix += e.a.a.a.ix(29, this.wWj.computeSize());
            }
            if (this.wlF != null) {
                ix += e.a.a.b.b.a.f(30, this.wlF);
            }
            if (this.wWk != null) {
                ix += e.a.a.b.b.a.f(31, this.wWk);
            }
            ix += e.a.a.b.b.a.bs(32, this.wWh);
            if (this.wWl != null) {
                ix += e.a.a.b.b.a.f(33, this.wWl);
            }
            int bs = (ix + e.a.a.b.b.a.bs(34, this.wWm)) + e.a.a.a.c(35, 8, this.wWn);
            AppMethodBeat.o(80178);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woe.clear();
            this.wWn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(80178);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(80178);
                throw bVar;
            } else {
                AppMethodBeat.o(80178);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buv buv = (buv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wcB = bts;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wyX = bts;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wce = bts;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wcf = bts;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 6:
                    buv.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 8:
                    buv.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 9:
                    buv.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 10:
                    buv.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 11:
                    buv.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 12:
                    buv.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 13:
                    buv.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 14:
                    buv.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 15:
                    buv.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 16:
                    buv.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 17:
                    buv.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 18:
                    buv.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 19:
                    buv.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 20:
                    buv.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 21:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wBZ = ccl;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 22:
                    buv.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 23:
                    buv.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wCa = uyVar;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 25:
                    buv.wod = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 26:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        but but = new but();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = but.populateBuilderWithField(aVar4, but, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.woe.add(but);
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 27:
                    buv.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    buv.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 29:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wWj = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                case 30:
                    buv.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 31:
                    buv.wWk = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 32:
                    buv.wWh = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 33:
                    buv.wWl = aVar3.BTU.readString();
                    AppMethodBeat.o(80178);
                    return 0;
                case 34:
                    buv.wWm = aVar3.BTU.vd();
                    AppMethodBeat.o(80178);
                    return 0;
                case 35:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvk bvk = new bvk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvk.populateBuilderWithField(aVar4, bvk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        buv.wWn.add(bvk);
                    }
                    AppMethodBeat.o(80178);
                    return 0;
                default:
                    AppMethodBeat.o(80178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80178);
            return -1;
        }
    }
}
