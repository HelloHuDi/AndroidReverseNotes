package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.buv */
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
    public C7285uy wCa;
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
        AppMethodBeat.m2504i(80177);
        AppMethodBeat.m2505o(80177);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80178);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wcB != null) {
                    c6093a.mo13479iy(2, this.wcB.computeSize());
                    this.wcB.writeFields(c6093a);
                }
                if (this.wyX != null) {
                    c6093a.mo13479iy(3, this.wyX.computeSize());
                    this.wyX.writeFields(c6093a);
                }
                if (this.wce != null) {
                    c6093a.mo13479iy(4, this.wce.computeSize());
                    this.wce.writeFields(c6093a);
                }
                if (this.wcf != null) {
                    c6093a.mo13479iy(5, this.wcf.computeSize());
                    this.wcf.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.guN);
                if (this.vEF != null) {
                    c6093a.mo13479iy(7, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                if (this.guO != null) {
                    c6093a.mo13475e(8, this.guO);
                }
                if (this.guP != null) {
                    c6093a.mo13475e(9, this.guP);
                }
                if (this.guQ != null) {
                    c6093a.mo13475e(10, this.guQ);
                }
                c6093a.mo13480iz(11, this.guR);
                c6093a.mo13480iz(12, this.wBT);
                if (this.wBU != null) {
                    c6093a.mo13475e(13, this.wBU);
                }
                if (this.wBV != null) {
                    c6093a.mo13475e(14, this.wBV);
                }
                if (this.guS != null) {
                    c6093a.mo13475e(15, this.guS);
                }
                if (this.wBW != null) {
                    c6093a.mo13475e(16, this.wBW);
                }
                c6093a.mo13480iz(17, this.wBX);
                c6093a.mo13480iz(18, this.guU);
                c6093a.mo13480iz(19, this.guT);
                if (this.guV != null) {
                    c6093a.mo13475e(20, this.guV);
                }
                if (this.wBZ != null) {
                    c6093a.mo13479iy(21, this.wBZ.computeSize());
                    this.wBZ.writeFields(c6093a);
                }
                if (this.guW != null) {
                    c6093a.mo13475e(22, this.guW);
                }
                if (this.guX != null) {
                    c6093a.mo13475e(23, this.guX);
                }
                if (this.wCa != null) {
                    c6093a.mo13479iy(24, this.wCa.computeSize());
                    this.wCa.writeFields(c6093a);
                }
                c6093a.mo13480iz(25, this.wod);
                c6093a.mo13474e(26, 8, this.woe);
                if (this.vXm != null) {
                    c6093a.mo13475e(27, this.vXm);
                }
                if (this.vXn != null) {
                    c6093a.mo13475e(28, this.vXn);
                }
                if (this.wWj != null) {
                    c6093a.mo13479iy(29, this.wWj.computeSize());
                    this.wWj.writeFields(c6093a);
                }
                if (this.wlF != null) {
                    c6093a.mo13475e(30, this.wlF);
                }
                if (this.wWk != null) {
                    c6093a.mo13475e(31, this.wWk);
                }
                c6093a.mo13480iz(32, this.wWh);
                if (this.wWl != null) {
                    c6093a.mo13475e(33, this.wWl);
                }
                c6093a.mo13480iz(34, this.wWm);
                c6093a.mo13474e(35, 8, this.wWn);
                AppMethodBeat.m2505o(80178);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcB != null) {
                ix += C6087a.m9557ix(2, this.wcB.computeSize());
            }
            if (this.wyX != null) {
                ix += C6087a.m9557ix(3, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += C6087a.m9557ix(4, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += C6087a.m9557ix(5, this.wcf.computeSize());
            }
            ix += C6091a.m9572bs(6, this.guN);
            if (this.vEF != null) {
                ix += C6087a.m9557ix(7, this.vEF.computeSize());
            }
            if (this.guO != null) {
                ix += C6091a.m9575f(8, this.guO);
            }
            if (this.guP != null) {
                ix += C6091a.m9575f(9, this.guP);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(10, this.guQ);
            }
            ix = (ix + C6091a.m9572bs(11, this.guR)) + C6091a.m9572bs(12, this.wBT);
            if (this.wBU != null) {
                ix += C6091a.m9575f(13, this.wBU);
            }
            if (this.wBV != null) {
                ix += C6091a.m9575f(14, this.wBV);
            }
            if (this.guS != null) {
                ix += C6091a.m9575f(15, this.guS);
            }
            if (this.wBW != null) {
                ix += C6091a.m9575f(16, this.wBW);
            }
            ix = ((ix + C6091a.m9572bs(17, this.wBX)) + C6091a.m9572bs(18, this.guU)) + C6091a.m9572bs(19, this.guT);
            if (this.guV != null) {
                ix += C6091a.m9575f(20, this.guV);
            }
            if (this.wBZ != null) {
                ix += C6087a.m9557ix(21, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += C6091a.m9575f(22, this.guW);
            }
            if (this.guX != null) {
                ix += C6091a.m9575f(23, this.guX);
            }
            if (this.wCa != null) {
                ix += C6087a.m9557ix(24, this.wCa.computeSize());
            }
            ix = (ix + C6091a.m9572bs(25, this.wod)) + C6087a.m9552c(26, 8, this.woe);
            if (this.vXm != null) {
                ix += C6091a.m9575f(27, this.vXm);
            }
            if (this.vXn != null) {
                ix += C6091a.m9575f(28, this.vXn);
            }
            if (this.wWj != null) {
                ix += C6087a.m9557ix(29, this.wWj.computeSize());
            }
            if (this.wlF != null) {
                ix += C6091a.m9575f(30, this.wlF);
            }
            if (this.wWk != null) {
                ix += C6091a.m9575f(31, this.wWk);
            }
            ix += C6091a.m9572bs(32, this.wWh);
            if (this.wWl != null) {
                ix += C6091a.m9575f(33, this.wWl);
            }
            int bs = (ix + C6091a.m9572bs(34, this.wWm)) + C6087a.m9552c(35, 8, this.wWn);
            AppMethodBeat.m2505o(80178);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woe.clear();
            this.wWn.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(80178);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80178);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            buv buv = (buv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bts bts;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80178);
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
                        buv.wcB = bts;
                    }
                    AppMethodBeat.m2505o(80178);
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
                        buv.wyX = bts;
                    }
                    AppMethodBeat.m2505o(80178);
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
                        buv.wce = bts;
                    }
                    AppMethodBeat.m2505o(80178);
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
                        buv.wcf = bts;
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 6:
                    buv.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 8:
                    buv.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 9:
                    buv.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 10:
                    buv.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 11:
                    buv.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 12:
                    buv.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 13:
                    buv.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 14:
                    buv.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 15:
                    buv.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 16:
                    buv.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 17:
                    buv.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 18:
                    buv.guU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 19:
                    buv.guT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 20:
                    buv.guV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 21:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 22:
                    buv.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 23:
                    buv.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 25:
                    buv.wod = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 26:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        but but = new but();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = but.populateBuilderWithField(c6086a3, but, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.woe.add(but);
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 27:
                    buv.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    buv.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 29:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.wWj = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 30:
                    buv.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 31:
                    buv.wWk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 32:
                    buv.wWh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 33:
                    buv.wWl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 34:
                    buv.wWm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80178);
                    return 0;
                case 35:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvk bvk = new bvk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvk.populateBuilderWithField(c6086a3, bvk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buv.wWn.add(bvk);
                    }
                    AppMethodBeat.m2505o(80178);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80178);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80178);
            return -1;
        }
    }
}
