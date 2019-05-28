package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.view.d;
import java.util.LinkedList;

public final class bcr extends a {
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
    public int jBT;
    public int vCf;
    public int vCi;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public xe wGB;
    public int wGO;
    public int wGT;
    public b wGU;
    public int wGW = 2048;
    public bts wGX;
    public bts wGY;
    public int wGZ;
    public int wGh;
    public int wHa;
    public int wHb;
    public int wHc;
    public int wHd;
    public arr wHe;
    public int wHf;
    public String wHg;
    public bts wcB;
    public long wfm;
    public String wfn;
    public bts wyX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60051);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcB == null) {
                bVar = new e.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(60051);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new e.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(60051);
                throw bVar;
            } else if (this.wGX == null) {
                bVar = new e.a.a.b("Not all required fields were included: BindEmail");
                AppMethodBeat.o(60051);
                throw bVar;
            } else if (this.wGY == null) {
                bVar = new e.a.a.b("Not all required fields were included: BindMobile");
                AppMethodBeat.o(60051);
                throw bVar;
            } else {
                aVar.iz(1, this.wGW);
                if (this.wcB != null) {
                    aVar.iy(2, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                if (this.wyX != null) {
                    aVar.iy(3, this.wyX.computeSize());
                    this.wyX.writeFields(aVar);
                }
                aVar.iz(4, this.vCf);
                if (this.wGX != null) {
                    aVar.iy(5, this.wGX.computeSize());
                    this.wGX.writeFields(aVar);
                }
                if (this.wGY != null) {
                    aVar.iy(6, this.wGY.computeSize());
                    this.wGY.writeFields(aVar);
                }
                aVar.iz(7, this.jBT);
                aVar.iz(8, this.wGT);
                if (this.wGU != null) {
                    aVar.c(9, this.wGU);
                }
                aVar.iz(10, this.guN);
                if (this.guO != null) {
                    aVar.e(11, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(12, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(13, this.guQ);
                }
                aVar.iz(14, this.guR);
                if (this.wGB != null) {
                    aVar.iy(15, this.wGB.computeSize());
                    this.wGB.writeFields(aVar);
                }
                aVar.iz(16, this.vCi);
                aVar.iz(17, this.wBT);
                if (this.wBU != null) {
                    aVar.e(18, this.wBU);
                }
                aVar.iz(19, this.wGZ);
                aVar.iz(20, this.wHa);
                aVar.iz(21, this.wGh);
                aVar.iz(22, this.wHb);
                aVar.iz(23, this.wHc);
                if (this.wBV != null) {
                    aVar.e(24, this.wBV);
                }
                aVar.iz(25, this.wHd);
                if (this.wHe != null) {
                    aVar.iy(26, this.wHe.computeSize());
                    this.wHe.writeFields(aVar);
                }
                if (this.guS != null) {
                    aVar.e(27, this.guS);
                }
                if (this.wBW != null) {
                    aVar.e(28, this.wBW);
                }
                aVar.iz(29, this.wBX);
                aVar.iz(30, this.wHf);
                aVar.ai(31, this.wfm);
                if (this.wfn != null) {
                    aVar.e(32, this.wfn);
                }
                aVar.iz(33, this.guU);
                aVar.iz(34, this.guT);
                if (this.guV != null) {
                    aVar.e(35, this.guV);
                }
                aVar.iz(36, this.wGO);
                if (this.wHg != null) {
                    aVar.e(37, this.wHg);
                }
                if (this.guW != null) {
                    aVar.e(38, this.guW);
                }
                AppMethodBeat.o(60051);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wGW) + 0;
            if (this.wcB != null) {
                bs += e.a.a.a.ix(2, this.wcB.computeSize());
            }
            if (this.wyX != null) {
                bs += e.a.a.a.ix(3, this.wyX.computeSize());
            }
            bs += e.a.a.b.b.a.bs(4, this.vCf);
            if (this.wGX != null) {
                bs += e.a.a.a.ix(5, this.wGX.computeSize());
            }
            if (this.wGY != null) {
                bs += e.a.a.a.ix(6, this.wGY.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(7, this.jBT)) + e.a.a.b.b.a.bs(8, this.wGT);
            if (this.wGU != null) {
                bs += e.a.a.b.b.a.b(9, this.wGU);
            }
            bs += e.a.a.b.b.a.bs(10, this.guN);
            if (this.guO != null) {
                bs += e.a.a.b.b.a.f(11, this.guO);
            }
            if (this.guP != null) {
                bs += e.a.a.b.b.a.f(12, this.guP);
            }
            if (this.guQ != null) {
                bs += e.a.a.b.b.a.f(13, this.guQ);
            }
            bs += e.a.a.b.b.a.bs(14, this.guR);
            if (this.wGB != null) {
                bs += e.a.a.a.ix(15, this.wGB.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(16, this.vCi)) + e.a.a.b.b.a.bs(17, this.wBT);
            if (this.wBU != null) {
                bs += e.a.a.b.b.a.f(18, this.wBU);
            }
            bs = ((((bs + e.a.a.b.b.a.bs(19, this.wGZ)) + e.a.a.b.b.a.bs(20, this.wHa)) + e.a.a.b.b.a.bs(21, this.wGh)) + e.a.a.b.b.a.bs(22, this.wHb)) + e.a.a.b.b.a.bs(23, this.wHc);
            if (this.wBV != null) {
                bs += e.a.a.b.b.a.f(24, this.wBV);
            }
            bs += e.a.a.b.b.a.bs(25, this.wHd);
            if (this.wHe != null) {
                bs += e.a.a.a.ix(26, this.wHe.computeSize());
            }
            if (this.guS != null) {
                bs += e.a.a.b.b.a.f(27, this.guS);
            }
            if (this.wBW != null) {
                bs += e.a.a.b.b.a.f(28, this.wBW);
            }
            bs = ((bs + e.a.a.b.b.a.bs(29, this.wBX)) + e.a.a.b.b.a.bs(30, this.wHf)) + e.a.a.b.b.a.o(31, this.wfm);
            if (this.wfn != null) {
                bs += e.a.a.b.b.a.f(32, this.wfn);
            }
            bs = (bs + e.a.a.b.b.a.bs(33, this.guU)) + e.a.a.b.b.a.bs(34, this.guT);
            if (this.guV != null) {
                bs += e.a.a.b.b.a.f(35, this.guV);
            }
            bs += e.a.a.b.b.a.bs(36, this.wGO);
            if (this.wHg != null) {
                bs += e.a.a.b.b.a.f(37, this.wHg);
            }
            if (this.guW != null) {
                bs += e.a.a.b.b.a.f(38, this.guW);
            }
            AppMethodBeat.o(60051);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wcB == null) {
                bVar = new e.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(60051);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new e.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(60051);
                throw bVar;
            } else if (this.wGX == null) {
                bVar = new e.a.a.b("Not all required fields were included: BindEmail");
                AppMethodBeat.o(60051);
                throw bVar;
            } else if (this.wGY == null) {
                bVar = new e.a.a.b("Not all required fields were included: BindMobile");
                AppMethodBeat.o(60051);
                throw bVar;
            } else {
                AppMethodBeat.o(60051);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcr bcr = (bcr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bcr.wGW = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
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
                        bcr.wcB = bts;
                    }
                    AppMethodBeat.o(60051);
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
                        bcr.wyX = bts;
                    }
                    AppMethodBeat.o(60051);
                    return 0;
                case 4:
                    bcr.vCf = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
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
                        bcr.wGX = bts;
                    }
                    AppMethodBeat.o(60051);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bcr.wGY = bts;
                    }
                    AppMethodBeat.o(60051);
                    return 0;
                case 7:
                    bcr.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 8:
                    bcr.wGT = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 9:
                    bcr.wGU = aVar3.BTU.emu();
                    AppMethodBeat.o(60051);
                    return 0;
                case 10:
                    bcr.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 11:
                    bcr.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 12:
                    bcr.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 13:
                    bcr.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 14:
                    bcr.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xe xeVar = new xe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xeVar.populateBuilderWithField(aVar4, xeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bcr.wGB = xeVar;
                    }
                    AppMethodBeat.o(60051);
                    return 0;
                case 16:
                    bcr.vCi = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 17:
                    bcr.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 18:
                    bcr.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 19:
                    bcr.wGZ = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 20:
                    bcr.wHa = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 21:
                    bcr.wGh = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 22:
                    bcr.wHb = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 23:
                    bcr.wHc = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 24:
                    bcr.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 25:
                    bcr.wHd = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 26:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        arr arr = new arr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arr.populateBuilderWithField(aVar4, arr, a.getNextFieldNumber(aVar4))) {
                        }
                        bcr.wHe = arr;
                    }
                    AppMethodBeat.o(60051);
                    return 0;
                case 27:
                    bcr.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bcr.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 29:
                    bcr.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 30:
                    bcr.wHf = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 31:
                    bcr.wfm = aVar3.BTU.ve();
                    AppMethodBeat.o(60051);
                    return 0;
                case 32:
                    bcr.wfn = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 33:
                    bcr.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 34:
                    bcr.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case 35:
                    bcr.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 36:
                    bcr.wGO = aVar3.BTU.vd();
                    AppMethodBeat.o(60051);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    bcr.wHg = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                case 38:
                    bcr.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(60051);
                    return 0;
                default:
                    AppMethodBeat.o(60051);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60051);
            return -1;
        }
    }
}
