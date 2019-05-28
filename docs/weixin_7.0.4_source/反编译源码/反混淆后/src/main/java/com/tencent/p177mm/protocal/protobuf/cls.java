package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cls */
public final class cls extends bsr {
    public String ndF;
    public String ndG;
    public String vEG;
    public String vFF;
    public int vFH;
    public String vRw;
    public int vRx;
    public int vRy;
    public int vRz;
    public int wEs;
    public int wEt;
    public SKBuiltinBuffer_t wEu;
    public int wEv;
    public int wWT;
    public int wYj;
    public int wdW;
    public int wdl;
    public String wxU;
    public String wxW;
    public String xjA;
    public String xjB;
    public String xjC;
    public String xjD;
    public String xjE;
    public int xjg;
    public int xjh;
    public int xji;
    public int xjo;
    public int xjp;
    public SKBuiltinBuffer_t xjq;
    public int xjr;
    public String xjs;
    public int xjt;
    public String xju;
    public String xjv;
    public int xjw;
    public String xjx;
    public String xjy;
    public String xjz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51008);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wEu == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbData");
                AppMethodBeat.m2505o(51008);
                throw c6092b;
            } else if (this.xjq == null) {
                c6092b = new C6092b("Not all required fields were included: VideoData");
                AppMethodBeat.m2505o(51008);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.vFF != null) {
                    c6093a.mo13475e(2, this.vFF);
                }
                if (this.ndG != null) {
                    c6093a.mo13475e(3, this.ndG);
                }
                if (this.ndF != null) {
                    c6093a.mo13475e(4, this.ndF);
                }
                c6093a.mo13480iz(5, this.wEs);
                c6093a.mo13480iz(6, this.wEt);
                if (this.wEu != null) {
                    c6093a.mo13479iy(7, this.wEu.computeSize());
                    this.wEu.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.xjo);
                c6093a.mo13480iz(9, this.xjp);
                if (this.xjq != null) {
                    c6093a.mo13479iy(10, this.xjq.computeSize());
                    this.xjq.writeFields(c6093a);
                }
                c6093a.mo13480iz(11, this.wYj);
                c6093a.mo13480iz(12, this.wdl);
                c6093a.mo13480iz(13, this.wEv);
                c6093a.mo13480iz(14, this.xjr);
                if (this.vEG != null) {
                    c6093a.mo13475e(15, this.vEG);
                }
                if (this.xjs != null) {
                    c6093a.mo13475e(16, this.xjs);
                }
                if (this.vRw != null) {
                    c6093a.mo13475e(17, this.vRw);
                }
                c6093a.mo13480iz(18, this.vRx);
                if (this.wxU != null) {
                    c6093a.mo13475e(19, this.wxU);
                }
                c6093a.mo13480iz(20, this.xjg);
                c6093a.mo13480iz(21, this.xjh);
                c6093a.mo13480iz(22, this.xji);
                if (this.wxW != null) {
                    c6093a.mo13475e(23, this.wxW);
                }
                c6093a.mo13480iz(24, this.xjt);
                c6093a.mo13480iz(25, this.wdW);
                if (this.xju != null) {
                    c6093a.mo13475e(26, this.xju);
                }
                if (this.xjv != null) {
                    c6093a.mo13475e(27, this.xjv);
                }
                c6093a.mo13480iz(28, this.xjw);
                if (this.xjx != null) {
                    c6093a.mo13475e(29, this.xjx);
                }
                if (this.xjy != null) {
                    c6093a.mo13475e(30, this.xjy);
                }
                if (this.xjz != null) {
                    c6093a.mo13475e(31, this.xjz);
                }
                if (this.xjA != null) {
                    c6093a.mo13475e(32, this.xjA);
                }
                if (this.xjB != null) {
                    c6093a.mo13475e(33, this.xjB);
                }
                if (this.xjC != null) {
                    c6093a.mo13475e(34, this.xjC);
                }
                if (this.xjD != null) {
                    c6093a.mo13475e(35, this.xjD);
                }
                c6093a.mo13480iz(36, this.wWT);
                if (this.xjE != null) {
                    c6093a.mo13475e(37, this.xjE);
                }
                c6093a.mo13480iz(38, this.vRy);
                c6093a.mo13480iz(39, this.vRz);
                c6093a.mo13480iz(40, this.vFH);
                AppMethodBeat.m2505o(51008);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFF != null) {
                ix += C6091a.m9575f(2, this.vFF);
            }
            if (this.ndG != null) {
                ix += C6091a.m9575f(3, this.ndG);
            }
            if (this.ndF != null) {
                ix += C6091a.m9575f(4, this.ndF);
            }
            ix = (ix + C6091a.m9572bs(5, this.wEs)) + C6091a.m9572bs(6, this.wEt);
            if (this.wEu != null) {
                ix += C6087a.m9557ix(7, this.wEu.computeSize());
            }
            ix = (ix + C6091a.m9572bs(8, this.xjo)) + C6091a.m9572bs(9, this.xjp);
            if (this.xjq != null) {
                ix += C6087a.m9557ix(10, this.xjq.computeSize());
            }
            ix = (((ix + C6091a.m9572bs(11, this.wYj)) + C6091a.m9572bs(12, this.wdl)) + C6091a.m9572bs(13, this.wEv)) + C6091a.m9572bs(14, this.xjr);
            if (this.vEG != null) {
                ix += C6091a.m9575f(15, this.vEG);
            }
            if (this.xjs != null) {
                ix += C6091a.m9575f(16, this.xjs);
            }
            if (this.vRw != null) {
                ix += C6091a.m9575f(17, this.vRw);
            }
            ix += C6091a.m9572bs(18, this.vRx);
            if (this.wxU != null) {
                ix += C6091a.m9575f(19, this.wxU);
            }
            ix = ((ix + C6091a.m9572bs(20, this.xjg)) + C6091a.m9572bs(21, this.xjh)) + C6091a.m9572bs(22, this.xji);
            if (this.wxW != null) {
                ix += C6091a.m9575f(23, this.wxW);
            }
            ix = (ix + C6091a.m9572bs(24, this.xjt)) + C6091a.m9572bs(25, this.wdW);
            if (this.xju != null) {
                ix += C6091a.m9575f(26, this.xju);
            }
            if (this.xjv != null) {
                ix += C6091a.m9575f(27, this.xjv);
            }
            ix += C6091a.m9572bs(28, this.xjw);
            if (this.xjx != null) {
                ix += C6091a.m9575f(29, this.xjx);
            }
            if (this.xjy != null) {
                ix += C6091a.m9575f(30, this.xjy);
            }
            if (this.xjz != null) {
                ix += C6091a.m9575f(31, this.xjz);
            }
            if (this.xjA != null) {
                ix += C6091a.m9575f(32, this.xjA);
            }
            if (this.xjB != null) {
                ix += C6091a.m9575f(33, this.xjB);
            }
            if (this.xjC != null) {
                ix += C6091a.m9575f(34, this.xjC);
            }
            if (this.xjD != null) {
                ix += C6091a.m9575f(35, this.xjD);
            }
            ix += C6091a.m9572bs(36, this.wWT);
            if (this.xjE != null) {
                ix += C6091a.m9575f(37, this.xjE);
            }
            int bs = ((ix + C6091a.m9572bs(38, this.vRy)) + C6091a.m9572bs(39, this.vRz)) + C6091a.m9572bs(40, this.vFH);
            AppMethodBeat.m2505o(51008);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wEu == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbData");
                AppMethodBeat.m2505o(51008);
                throw c6092b;
            } else if (this.xjq == null) {
                c6092b = new C6092b("Not all required fields were included: VideoData");
                AppMethodBeat.m2505o(51008);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(51008);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cls cls = (cls) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cls.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 2:
                    cls.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 3:
                    cls.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 4:
                    cls.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 5:
                    cls.wEs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 6:
                    cls.wEt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
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
                        cls.wEu = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 8:
                    cls.xjo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 9:
                    cls.xjp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cls.xjq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 11:
                    cls.wYj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 12:
                    cls.wdl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 13:
                    cls.wEv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 14:
                    cls.xjr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 15:
                    cls.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 16:
                    cls.xjs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 17:
                    cls.vRw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 18:
                    cls.vRx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 19:
                    cls.wxU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 20:
                    cls.xjg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 21:
                    cls.xjh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 22:
                    cls.xji = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 23:
                    cls.wxW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 24:
                    cls.xjt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 25:
                    cls.wdW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 26:
                    cls.xju = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 27:
                    cls.xjv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    cls.xjw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 29:
                    cls.xjx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 30:
                    cls.xjy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 31:
                    cls.xjz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 32:
                    cls.xjA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 33:
                    cls.xjB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 34:
                    cls.xjC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 35:
                    cls.xjD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 36:
                    cls.wWT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    cls.xjE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 38:
                    cls.vRy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 39:
                    cls.vRz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                case 40:
                    cls.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51008);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51008);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51008);
            return -1;
        }
    }
}
