package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.but */
public final class but extends C1331a {
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
    public C7285uy wCa;
    public int wWh;
    public bts wcB;
    public bts wce;
    public bts wcf;
    public String wlF;
    public bts wyX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80175);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else {
                if (this.wcB != null) {
                    c6093a.mo13479iy(1, this.wcB.computeSize());
                    this.wcB.writeFields(c6093a);
                }
                if (this.wyX != null) {
                    c6093a.mo13479iy(2, this.wyX.computeSize());
                    this.wyX.writeFields(c6093a);
                }
                if (this.wce != null) {
                    c6093a.mo13479iy(3, this.wce.computeSize());
                    this.wce.writeFields(c6093a);
                }
                if (this.wcf != null) {
                    c6093a.mo13479iy(4, this.wcf.computeSize());
                    this.wcf.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.guN);
                if (this.vEF != null) {
                    c6093a.mo13479iy(6, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                if (this.guO != null) {
                    c6093a.mo13475e(7, this.guO);
                }
                if (this.guP != null) {
                    c6093a.mo13475e(8, this.guP);
                }
                if (this.guQ != null) {
                    c6093a.mo13475e(9, this.guQ);
                }
                c6093a.mo13480iz(10, this.guR);
                c6093a.mo13480iz(11, this.wBT);
                if (this.wBU != null) {
                    c6093a.mo13475e(12, this.wBU);
                }
                if (this.wBV != null) {
                    c6093a.mo13475e(13, this.wBV);
                }
                if (this.guS != null) {
                    c6093a.mo13475e(14, this.guS);
                }
                if (this.wBW != null) {
                    c6093a.mo13475e(15, this.wBW);
                }
                c6093a.mo13480iz(16, this.wBX);
                c6093a.mo13480iz(17, this.guU);
                c6093a.mo13480iz(18, this.guT);
                if (this.guV != null) {
                    c6093a.mo13475e(19, this.guV);
                }
                if (this.wBZ != null) {
                    c6093a.mo13479iy(20, this.wBZ.computeSize());
                    this.wBZ.writeFields(c6093a);
                }
                if (this.guW != null) {
                    c6093a.mo13475e(21, this.guW);
                }
                if (this.guX != null) {
                    c6093a.mo13475e(22, this.guX);
                }
                if (this.wCa != null) {
                    c6093a.mo13479iy(23, this.wCa.computeSize());
                    this.wCa.writeFields(c6093a);
                }
                if (this.vXm != null) {
                    c6093a.mo13475e(24, this.vXm);
                }
                if (this.vXn != null) {
                    c6093a.mo13475e(25, this.vXn);
                }
                if (this.wlF != null) {
                    c6093a.mo13475e(26, this.wlF);
                }
                c6093a.mo13480iz(27, this.wWh);
                AppMethodBeat.m2505o(80175);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = C6087a.m9557ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wyX != null) {
                ix += C6087a.m9557ix(2, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += C6087a.m9557ix(3, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += C6087a.m9557ix(4, this.wcf.computeSize());
            }
            ix += C6091a.m9572bs(5, this.guN);
            if (this.vEF != null) {
                ix += C6087a.m9557ix(6, this.vEF.computeSize());
            }
            if (this.guO != null) {
                ix += C6091a.m9575f(7, this.guO);
            }
            if (this.guP != null) {
                ix += C6091a.m9575f(8, this.guP);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(9, this.guQ);
            }
            ix = (ix + C6091a.m9572bs(10, this.guR)) + C6091a.m9572bs(11, this.wBT);
            if (this.wBU != null) {
                ix += C6091a.m9575f(12, this.wBU);
            }
            if (this.wBV != null) {
                ix += C6091a.m9575f(13, this.wBV);
            }
            if (this.guS != null) {
                ix += C6091a.m9575f(14, this.guS);
            }
            if (this.wBW != null) {
                ix += C6091a.m9575f(15, this.wBW);
            }
            ix = ((ix + C6091a.m9572bs(16, this.wBX)) + C6091a.m9572bs(17, this.guU)) + C6091a.m9572bs(18, this.guT);
            if (this.guV != null) {
                ix += C6091a.m9575f(19, this.guV);
            }
            if (this.wBZ != null) {
                ix += C6087a.m9557ix(20, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += C6091a.m9575f(21, this.guW);
            }
            if (this.guX != null) {
                ix += C6091a.m9575f(22, this.guX);
            }
            if (this.wCa != null) {
                ix += C6087a.m9557ix(23, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                ix += C6091a.m9575f(24, this.vXm);
            }
            if (this.vXn != null) {
                ix += C6091a.m9575f(25, this.vXn);
            }
            if (this.wlF != null) {
                ix += C6091a.m9575f(26, this.wlF);
            }
            int bs = ix + C6091a.m9572bs(27, this.wWh);
            AppMethodBeat.m2505o(80175);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(80175);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80175);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            but but = (but) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        but.wcB = bts;
                    }
                    AppMethodBeat.m2505o(80175);
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
                        but.wyX = bts;
                    }
                    AppMethodBeat.m2505o(80175);
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
                        but.wce = bts;
                    }
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        but.wcf = bts;
                    }
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 5:
                    but.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        but.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 7:
                    but.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 8:
                    but.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 9:
                    but.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 10:
                    but.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 11:
                    but.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 12:
                    but.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 13:
                    but.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 14:
                    but.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 15:
                    but.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 16:
                    but.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 17:
                    but.guU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 18:
                    but.guT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 19:
                    but.guV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        but.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 21:
                    but.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 22:
                    but.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        but.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 24:
                    but.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 25:
                    but.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 26:
                    but.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                case 27:
                    but.wWh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80175);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80175);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80175);
            return -1;
        }
    }
}
