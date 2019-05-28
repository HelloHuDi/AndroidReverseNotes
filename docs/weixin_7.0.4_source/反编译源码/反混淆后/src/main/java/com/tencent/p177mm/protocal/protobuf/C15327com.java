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

/* renamed from: com.tencent.mm.protocal.protobuf.com */
public final class C15327com extends btd {
    public int vIN;
    public LinkedList<coj> vIO = new LinkedList();
    public int wem;
    public long wen;
    public int xlS;
    public cpr xlT;
    public int xlU;
    public int xlV;
    public int xlW;
    public int xlX;
    public SKBuiltinBuffer_t xlY;
    public int xmd;
    public LinkedList<cpt> xme = new LinkedList();
    public int xmf;
    public int xmg;
    public int xmh;
    public int xmi;
    public int xmj;
    public int xmk;
    public int xml;
    public int xmm;
    public int xmn;
    public int xmo;
    public int xmp;
    public int xmq;
    public int xmr;
    public int xms;

    public C15327com() {
        AppMethodBeat.m2504i(5231);
        AppMethodBeat.m2505o(5231);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5232);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5232);
                throw c6092b;
            } else if (this.xlT == null) {
                c6092b = new C6092b("Not all required fields were included: RelayData");
                AppMethodBeat.m2505o(5232);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.vIN);
                c6093a.mo13474e(3, 8, this.vIO);
                c6093a.mo13480iz(4, this.wem);
                c6093a.mo13472ai(5, this.wen);
                c6093a.mo13480iz(6, this.xlS);
                if (this.xlT != null) {
                    c6093a.mo13479iy(7, this.xlT.computeSize());
                    this.xlT.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.xmd);
                c6093a.mo13474e(9, 8, this.xme);
                c6093a.mo13480iz(10, this.xmf);
                c6093a.mo13480iz(11, this.xmg);
                c6093a.mo13480iz(12, this.xmh);
                c6093a.mo13480iz(13, this.xmi);
                c6093a.mo13480iz(14, this.xmj);
                c6093a.mo13480iz(15, this.xmk);
                c6093a.mo13480iz(16, this.xlU);
                c6093a.mo13480iz(17, this.xml);
                c6093a.mo13480iz(18, this.xmm);
                c6093a.mo13480iz(19, this.xlV);
                c6093a.mo13480iz(20, this.xmn);
                c6093a.mo13480iz(21, this.xmo);
                c6093a.mo13480iz(22, this.xmp);
                c6093a.mo13480iz(23, this.xmq);
                c6093a.mo13480iz(24, this.xlW);
                c6093a.mo13480iz(25, this.xlX);
                c6093a.mo13480iz(26, this.xmr);
                c6093a.mo13480iz(27, this.xms);
                if (this.xlY != null) {
                    c6093a.mo13479iy(28, this.xlY.computeSize());
                    this.xlY.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(5232);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + C6091a.m9572bs(2, this.vIN)) + C6087a.m9552c(3, 8, this.vIO)) + C6091a.m9572bs(4, this.wem)) + C6091a.m9578o(5, this.wen)) + C6091a.m9572bs(6, this.xlS);
            if (this.xlT != null) {
                ix += C6087a.m9557ix(7, this.xlT.computeSize());
            }
            ix = (((((((((((((((((((ix + C6091a.m9572bs(8, this.xmd)) + C6087a.m9552c(9, 8, this.xme)) + C6091a.m9572bs(10, this.xmf)) + C6091a.m9572bs(11, this.xmg)) + C6091a.m9572bs(12, this.xmh)) + C6091a.m9572bs(13, this.xmi)) + C6091a.m9572bs(14, this.xmj)) + C6091a.m9572bs(15, this.xmk)) + C6091a.m9572bs(16, this.xlU)) + C6091a.m9572bs(17, this.xml)) + C6091a.m9572bs(18, this.xmm)) + C6091a.m9572bs(19, this.xlV)) + C6091a.m9572bs(20, this.xmn)) + C6091a.m9572bs(21, this.xmo)) + C6091a.m9572bs(22, this.xmp)) + C6091a.m9572bs(23, this.xmq)) + C6091a.m9572bs(24, this.xlW)) + C6091a.m9572bs(25, this.xlX)) + C6091a.m9572bs(26, this.xmr)) + C6091a.m9572bs(27, this.xms);
            if (this.xlY != null) {
                ix += C6087a.m9557ix(28, this.xlY.computeSize());
            }
            AppMethodBeat.m2505o(5232);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            this.xme.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5232);
                throw c6092b;
            } else if (this.xlT == null) {
                c6092b = new C6092b("Not all required fields were included: RelayData");
                AppMethodBeat.m2505o(5232);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5232);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15327com c15327com = (C15327com) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
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
                        c15327com.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 2:
                    c15327com.vIN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(c6086a3, coj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15327com.vIO.add(coj);
                    }
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 4:
                    c15327com.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 5:
                    c15327com.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 6:
                    c15327com.xlS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpr cpr = new cpr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpr.populateBuilderWithField(c6086a3, cpr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15327com.xlT = cpr;
                    }
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 8:
                    c15327com.xmd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpt cpt = new cpt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpt.populateBuilderWithField(c6086a3, cpt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15327com.xme.add(cpt);
                    }
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 10:
                    c15327com.xmf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 11:
                    c15327com.xmg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 12:
                    c15327com.xmh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 13:
                    c15327com.xmi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 14:
                    c15327com.xmj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 15:
                    c15327com.xmk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 16:
                    c15327com.xlU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 17:
                    c15327com.xml = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 18:
                    c15327com.xmm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 19:
                    c15327com.xlV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 20:
                    c15327com.xmn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 21:
                    c15327com.xmo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 22:
                    c15327com.xmp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 23:
                    c15327com.xmq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 24:
                    c15327com.xlW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 25:
                    c15327com.xlX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 26:
                    c15327com.xmr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case 27:
                    c15327com.xms = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5232);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15327com.xlY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5232);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5232);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5232);
            return -1;
        }
    }
}
