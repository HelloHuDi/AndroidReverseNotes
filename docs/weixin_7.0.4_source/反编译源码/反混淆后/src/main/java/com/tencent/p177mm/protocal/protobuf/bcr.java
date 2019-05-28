package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bcr */
public final class bcr extends C1331a {
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
    public C44189xe wGB;
    public int wGO;
    public int wGT;
    public C1332b wGU;
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60051);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else if (this.wGX == null) {
                c6092b = new C6092b("Not all required fields were included: BindEmail");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else if (this.wGY == null) {
                c6092b = new C6092b("Not all required fields were included: BindMobile");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.wGW);
                if (this.wcB != null) {
                    c6093a.mo13479iy(2, this.wcB.computeSize());
                    this.wcB.writeFields(c6093a);
                }
                if (this.wyX != null) {
                    c6093a.mo13479iy(3, this.wyX.computeSize());
                    this.wyX.writeFields(c6093a);
                }
                c6093a.mo13480iz(4, this.vCf);
                if (this.wGX != null) {
                    c6093a.mo13479iy(5, this.wGX.computeSize());
                    this.wGX.writeFields(c6093a);
                }
                if (this.wGY != null) {
                    c6093a.mo13479iy(6, this.wGY.computeSize());
                    this.wGY.writeFields(c6093a);
                }
                c6093a.mo13480iz(7, this.jBT);
                c6093a.mo13480iz(8, this.wGT);
                if (this.wGU != null) {
                    c6093a.mo13473c(9, this.wGU);
                }
                c6093a.mo13480iz(10, this.guN);
                if (this.guO != null) {
                    c6093a.mo13475e(11, this.guO);
                }
                if (this.guP != null) {
                    c6093a.mo13475e(12, this.guP);
                }
                if (this.guQ != null) {
                    c6093a.mo13475e(13, this.guQ);
                }
                c6093a.mo13480iz(14, this.guR);
                if (this.wGB != null) {
                    c6093a.mo13479iy(15, this.wGB.computeSize());
                    this.wGB.writeFields(c6093a);
                }
                c6093a.mo13480iz(16, this.vCi);
                c6093a.mo13480iz(17, this.wBT);
                if (this.wBU != null) {
                    c6093a.mo13475e(18, this.wBU);
                }
                c6093a.mo13480iz(19, this.wGZ);
                c6093a.mo13480iz(20, this.wHa);
                c6093a.mo13480iz(21, this.wGh);
                c6093a.mo13480iz(22, this.wHb);
                c6093a.mo13480iz(23, this.wHc);
                if (this.wBV != null) {
                    c6093a.mo13475e(24, this.wBV);
                }
                c6093a.mo13480iz(25, this.wHd);
                if (this.wHe != null) {
                    c6093a.mo13479iy(26, this.wHe.computeSize());
                    this.wHe.writeFields(c6093a);
                }
                if (this.guS != null) {
                    c6093a.mo13475e(27, this.guS);
                }
                if (this.wBW != null) {
                    c6093a.mo13475e(28, this.wBW);
                }
                c6093a.mo13480iz(29, this.wBX);
                c6093a.mo13480iz(30, this.wHf);
                c6093a.mo13472ai(31, this.wfm);
                if (this.wfn != null) {
                    c6093a.mo13475e(32, this.wfn);
                }
                c6093a.mo13480iz(33, this.guU);
                c6093a.mo13480iz(34, this.guT);
                if (this.guV != null) {
                    c6093a.mo13475e(35, this.guV);
                }
                c6093a.mo13480iz(36, this.wGO);
                if (this.wHg != null) {
                    c6093a.mo13475e(37, this.wHg);
                }
                if (this.guW != null) {
                    c6093a.mo13475e(38, this.guW);
                }
                AppMethodBeat.m2505o(60051);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wGW) + 0;
            if (this.wcB != null) {
                bs += C6087a.m9557ix(2, this.wcB.computeSize());
            }
            if (this.wyX != null) {
                bs += C6087a.m9557ix(3, this.wyX.computeSize());
            }
            bs += C6091a.m9572bs(4, this.vCf);
            if (this.wGX != null) {
                bs += C6087a.m9557ix(5, this.wGX.computeSize());
            }
            if (this.wGY != null) {
                bs += C6087a.m9557ix(6, this.wGY.computeSize());
            }
            bs = (bs + C6091a.m9572bs(7, this.jBT)) + C6091a.m9572bs(8, this.wGT);
            if (this.wGU != null) {
                bs += C6091a.m9571b(9, this.wGU);
            }
            bs += C6091a.m9572bs(10, this.guN);
            if (this.guO != null) {
                bs += C6091a.m9575f(11, this.guO);
            }
            if (this.guP != null) {
                bs += C6091a.m9575f(12, this.guP);
            }
            if (this.guQ != null) {
                bs += C6091a.m9575f(13, this.guQ);
            }
            bs += C6091a.m9572bs(14, this.guR);
            if (this.wGB != null) {
                bs += C6087a.m9557ix(15, this.wGB.computeSize());
            }
            bs = (bs + C6091a.m9572bs(16, this.vCi)) + C6091a.m9572bs(17, this.wBT);
            if (this.wBU != null) {
                bs += C6091a.m9575f(18, this.wBU);
            }
            bs = ((((bs + C6091a.m9572bs(19, this.wGZ)) + C6091a.m9572bs(20, this.wHa)) + C6091a.m9572bs(21, this.wGh)) + C6091a.m9572bs(22, this.wHb)) + C6091a.m9572bs(23, this.wHc);
            if (this.wBV != null) {
                bs += C6091a.m9575f(24, this.wBV);
            }
            bs += C6091a.m9572bs(25, this.wHd);
            if (this.wHe != null) {
                bs += C6087a.m9557ix(26, this.wHe.computeSize());
            }
            if (this.guS != null) {
                bs += C6091a.m9575f(27, this.guS);
            }
            if (this.wBW != null) {
                bs += C6091a.m9575f(28, this.wBW);
            }
            bs = ((bs + C6091a.m9572bs(29, this.wBX)) + C6091a.m9572bs(30, this.wHf)) + C6091a.m9578o(31, this.wfm);
            if (this.wfn != null) {
                bs += C6091a.m9575f(32, this.wfn);
            }
            bs = (bs + C6091a.m9572bs(33, this.guU)) + C6091a.m9572bs(34, this.guT);
            if (this.guV != null) {
                bs += C6091a.m9575f(35, this.guV);
            }
            bs += C6091a.m9572bs(36, this.wGO);
            if (this.wHg != null) {
                bs += C6091a.m9575f(37, this.wHg);
            }
            if (this.guW != null) {
                bs += C6091a.m9575f(38, this.guW);
            }
            AppMethodBeat.m2505o(60051);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else if (this.wGX == null) {
                c6092b = new C6092b("Not all required fields were included: BindEmail");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else if (this.wGY == null) {
                c6092b = new C6092b("Not all required fields were included: BindMobile");
                AppMethodBeat.m2505o(60051);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(60051);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bcr bcr = (bcr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bcr.wGW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bcr.wcB = bts;
                    }
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bcr.wyX = bts;
                    }
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 4:
                    bcr.vCf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bcr.wGX = bts;
                    }
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bcr.wGY = bts;
                    }
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 7:
                    bcr.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 8:
                    bcr.wGT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 9:
                    bcr.wGU = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 10:
                    bcr.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 11:
                    bcr.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 12:
                    bcr.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 13:
                    bcr.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 14:
                    bcr.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44189xe c44189xe = new C44189xe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44189xe.populateBuilderWithField(c6086a3, c44189xe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bcr.wGB = c44189xe;
                    }
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 16:
                    bcr.vCi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 17:
                    bcr.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 18:
                    bcr.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 19:
                    bcr.wGZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 20:
                    bcr.wHa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 21:
                    bcr.wGh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 22:
                    bcr.wHb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 23:
                    bcr.wHc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 24:
                    bcr.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 25:
                    bcr.wHd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 26:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        arr arr = new arr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = arr.populateBuilderWithField(c6086a3, arr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bcr.wHe = arr;
                    }
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 27:
                    bcr.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bcr.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 29:
                    bcr.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 30:
                    bcr.wHf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 31:
                    bcr.wfm = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 32:
                    bcr.wfn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 33:
                    bcr.guU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 34:
                    bcr.guT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 35:
                    bcr.guV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 36:
                    bcr.wGO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    bcr.wHg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                case 38:
                    bcr.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60051);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60051);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60051);
            return -1;
        }
    }
}
