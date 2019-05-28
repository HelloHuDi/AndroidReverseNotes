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

/* renamed from: com.tencent.mm.protocal.protobuf.clk */
public final class clk extends bsr {
    public String Md5;
    public String fKh;
    public String fKk;
    public int nao;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;
    public String vCs;
    public String vCt;
    public String vCu;
    public bts vEB;
    public bts vEC;
    public String vEG;
    public String vRw;
    public int vRx;
    public int vRy;
    public int vRz;
    public int vZF;
    public int wWT;
    public int wdW;
    public int wqw;
    public String wxW;
    public int xbN;
    public bts xja;
    public String xjb;
    public String xjc;
    public int xjd;
    public int xje;
    public String xjf;
    public int xjg;
    public int xjh;
    public int xji;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80203);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xja == null) {
                c6092b = new C6092b("Not all required fields were included: ClientImgId");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.xja != null) {
                    c6093a.mo13479iy(2, this.xja.computeSize());
                    this.xja.writeFields(c6093a);
                }
                if (this.vEB != null) {
                    c6093a.mo13479iy(3, this.vEB.computeSize());
                    this.vEB.writeFields(c6093a);
                }
                if (this.vEC != null) {
                    c6093a.mo13479iy(4, this.vEC.computeSize());
                    this.vEC.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.ptw);
                c6093a.mo13480iz(6, this.ptx);
                c6093a.mo13480iz(7, this.pty);
                if (this.ptz != null) {
                    c6093a.mo13479iy(8, this.ptz.computeSize());
                    this.ptz.writeFields(c6093a);
                }
                c6093a.mo13480iz(9, this.nao);
                if (this.vEG != null) {
                    c6093a.mo13475e(10, this.vEG);
                }
                c6093a.mo13480iz(11, this.wqw);
                c6093a.mo13480iz(12, this.vZF);
                c6093a.mo13480iz(13, this.xbN);
                if (this.fKk != null) {
                    c6093a.mo13475e(14, this.fKk);
                }
                if (this.xjb != null) {
                    c6093a.mo13475e(15, this.xjb);
                }
                if (this.xjc != null) {
                    c6093a.mo13475e(16, this.xjc);
                }
                if (this.vRw != null) {
                    c6093a.mo13475e(17, this.vRw);
                }
                c6093a.mo13480iz(18, this.vRx);
                c6093a.mo13480iz(19, this.xjd);
                c6093a.mo13480iz(20, this.xje);
                if (this.xjf != null) {
                    c6093a.mo13475e(21, this.xjf);
                }
                c6093a.mo13480iz(22, this.xjg);
                c6093a.mo13480iz(23, this.xjh);
                c6093a.mo13480iz(24, this.xji);
                if (this.wxW != null) {
                    c6093a.mo13475e(25, this.wxW);
                }
                c6093a.mo13480iz(26, this.wdW);
                if (this.Md5 != null) {
                    c6093a.mo13475e(27, this.Md5);
                }
                c6093a.mo13480iz(28, this.vRy);
                c6093a.mo13480iz(29, this.vRz);
                c6093a.mo13480iz(30, this.wWT);
                if (this.fKh != null) {
                    c6093a.mo13475e(31, this.fKh);
                }
                if (this.vCu != null) {
                    c6093a.mo13475e(32, this.vCu);
                }
                if (this.vCt != null) {
                    c6093a.mo13475e(33, this.vCt);
                }
                if (this.vCs != null) {
                    c6093a.mo13475e(34, this.vCs);
                }
                AppMethodBeat.m2505o(80203);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xja != null) {
                ix += C6087a.m9557ix(2, this.xja.computeSize());
            }
            if (this.vEB != null) {
                ix += C6087a.m9557ix(3, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                ix += C6087a.m9557ix(4, this.vEC.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(5, this.ptw)) + C6091a.m9572bs(6, this.ptx)) + C6091a.m9572bs(7, this.pty);
            if (this.ptz != null) {
                ix += C6087a.m9557ix(8, this.ptz.computeSize());
            }
            ix += C6091a.m9572bs(9, this.nao);
            if (this.vEG != null) {
                ix += C6091a.m9575f(10, this.vEG);
            }
            ix = ((ix + C6091a.m9572bs(11, this.wqw)) + C6091a.m9572bs(12, this.vZF)) + C6091a.m9572bs(13, this.xbN);
            if (this.fKk != null) {
                ix += C6091a.m9575f(14, this.fKk);
            }
            if (this.xjb != null) {
                ix += C6091a.m9575f(15, this.xjb);
            }
            if (this.xjc != null) {
                ix += C6091a.m9575f(16, this.xjc);
            }
            if (this.vRw != null) {
                ix += C6091a.m9575f(17, this.vRw);
            }
            ix = ((ix + C6091a.m9572bs(18, this.vRx)) + C6091a.m9572bs(19, this.xjd)) + C6091a.m9572bs(20, this.xje);
            if (this.xjf != null) {
                ix += C6091a.m9575f(21, this.xjf);
            }
            ix = ((ix + C6091a.m9572bs(22, this.xjg)) + C6091a.m9572bs(23, this.xjh)) + C6091a.m9572bs(24, this.xji);
            if (this.wxW != null) {
                ix += C6091a.m9575f(25, this.wxW);
            }
            ix += C6091a.m9572bs(26, this.wdW);
            if (this.Md5 != null) {
                ix += C6091a.m9575f(27, this.Md5);
            }
            ix = ((ix + C6091a.m9572bs(28, this.vRy)) + C6091a.m9572bs(29, this.vRz)) + C6091a.m9572bs(30, this.wWT);
            if (this.fKh != null) {
                ix += C6091a.m9575f(31, this.fKh);
            }
            if (this.vCu != null) {
                ix += C6091a.m9575f(32, this.vCu);
            }
            if (this.vCt != null) {
                ix += C6091a.m9575f(33, this.vCt);
            }
            if (this.vCs != null) {
                ix += C6091a.m9575f(34, this.vCs);
            }
            AppMethodBeat.m2505o(80203);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xja == null) {
                c6092b = new C6092b("Not all required fields were included: ClientImgId");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(80203);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80203);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            clk clk = (clk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            bts bts;
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
                        clk.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80203);
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
                        clk.xja = bts;
                    }
                    AppMethodBeat.m2505o(80203);
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
                        clk.vEB = bts;
                    }
                    AppMethodBeat.m2505o(80203);
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
                        clk.vEC = bts;
                    }
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 5:
                    clk.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 6:
                    clk.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 7:
                    clk.pty = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clk.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 9:
                    clk.nao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 10:
                    clk.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 11:
                    clk.wqw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 12:
                    clk.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 13:
                    clk.xbN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 14:
                    clk.fKk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 15:
                    clk.xjb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 16:
                    clk.xjc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 17:
                    clk.vRw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 18:
                    clk.vRx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 19:
                    clk.xjd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 20:
                    clk.xje = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 21:
                    clk.xjf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 22:
                    clk.xjg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 23:
                    clk.xjh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 24:
                    clk.xji = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 25:
                    clk.wxW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 26:
                    clk.wdW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 27:
                    clk.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    clk.vRy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 29:
                    clk.vRz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 30:
                    clk.wWT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 31:
                    clk.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 32:
                    clk.vCu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 33:
                    clk.vCt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                case 34:
                    clk.vCs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80203);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80203);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80203);
            return -1;
        }
    }
}
