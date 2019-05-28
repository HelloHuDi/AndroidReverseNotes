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

/* renamed from: com.tencent.mm.protocal.protobuf.beh */
public final class beh extends btd {
    public String jBB;
    public int jBT;
    public int luF;
    public String luH;
    public String vAN;
    public String vCg;
    public int vCj;
    public String vCm;
    public String vCn;
    public int vCo;
    public String vCp;
    public String vHO;
    public bzr vHR;
    public int vHW;
    public ato vLK;
    public C7270lm vLL;
    public bdu vLM;
    public C7273mw vMl;
    public C7273mw vMm;
    public C7273mw vMn;
    public String wIh;
    public int wIi;
    public String wIj;
    public int wIk;
    public bkq wIl;
    public int wIm;
    public String wIn;
    public String wIo;
    public bvv wIp;
    public String wsL;
    public SKBuiltinBuffer_t wsO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58921);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(58921);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.luF);
            if (this.vAN != null) {
                c6093a.mo13475e(3, this.vAN);
            }
            if (this.vCm != null) {
                c6093a.mo13475e(4, this.vCm);
            }
            if (this.vCn != null) {
                c6093a.mo13475e(5, this.vCn);
            }
            if (this.wIh != null) {
                c6093a.mo13475e(6, this.wIh);
            }
            if (this.vCg != null) {
                c6093a.mo13475e(7, this.vCg);
            }
            c6093a.mo13480iz(8, this.vCo);
            c6093a.mo13480iz(9, this.wIi);
            if (this.wIj != null) {
                c6093a.mo13475e(10, this.wIj);
            }
            if (this.vLL != null) {
                c6093a.mo13479iy(14, this.vLL.computeSize());
                this.vLL.writeFields(c6093a);
            }
            if (this.vCp != null) {
                c6093a.mo13475e(15, this.vCp);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(16, this.jBB);
            }
            c6093a.mo13480iz(17, this.jBT);
            if (this.vLM != null) {
                c6093a.mo13479iy(18, this.vLM.computeSize());
                this.vLM.writeFields(c6093a);
            }
            c6093a.mo13480iz(19, this.wIk);
            c6093a.mo13480iz(20, this.vCj);
            if (this.vHO != null) {
                c6093a.mo13475e(21, this.vHO);
            }
            if (this.wIl != null) {
                c6093a.mo13479iy(22, this.wIl.computeSize());
                this.wIl.writeFields(c6093a);
            }
            if (this.luH != null) {
                c6093a.mo13475e(23, this.luH);
            }
            c6093a.mo13480iz(24, this.wIm);
            if (this.vLK != null) {
                c6093a.mo13479iy(25, this.vLK.computeSize());
                this.vLK.writeFields(c6093a);
            }
            if (this.wIn != null) {
                c6093a.mo13475e(26, this.wIn);
            }
            if (this.vMl != null) {
                c6093a.mo13479iy(27, this.vMl.computeSize());
                this.vMl.writeFields(c6093a);
            }
            if (this.wIo != null) {
                c6093a.mo13475e(28, this.wIo);
            }
            if (this.wsL != null) {
                c6093a.mo13475e(29, this.wsL);
            }
            if (this.wsO != null) {
                c6093a.mo13479iy(30, this.wsO.computeSize());
                this.wsO.writeFields(c6093a);
            }
            if (this.vHR != null) {
                c6093a.mo13479iy(31, this.vHR.computeSize());
                this.vHR.writeFields(c6093a);
            }
            if (this.vMm != null) {
                c6093a.mo13479iy(32, this.vMm.computeSize());
                this.vMm.writeFields(c6093a);
            }
            if (this.vMn != null) {
                c6093a.mo13479iy(33, this.vMn.computeSize());
                this.vMn.writeFields(c6093a);
            }
            if (this.wIp != null) {
                c6093a.mo13479iy(34, this.wIp.computeSize());
                this.wIp.writeFields(c6093a);
            }
            c6093a.mo13480iz(35, this.vHW);
            AppMethodBeat.m2505o(58921);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.luF);
            if (this.vAN != null) {
                ix += C6091a.m9575f(3, this.vAN);
            }
            if (this.vCm != null) {
                ix += C6091a.m9575f(4, this.vCm);
            }
            if (this.vCn != null) {
                ix += C6091a.m9575f(5, this.vCn);
            }
            if (this.wIh != null) {
                ix += C6091a.m9575f(6, this.wIh);
            }
            if (this.vCg != null) {
                ix += C6091a.m9575f(7, this.vCg);
            }
            ix = (ix + C6091a.m9572bs(8, this.vCo)) + C6091a.m9572bs(9, this.wIi);
            if (this.wIj != null) {
                ix += C6091a.m9575f(10, this.wIj);
            }
            if (this.vLL != null) {
                ix += C6087a.m9557ix(14, this.vLL.computeSize());
            }
            if (this.vCp != null) {
                ix += C6091a.m9575f(15, this.vCp);
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(16, this.jBB);
            }
            ix += C6091a.m9572bs(17, this.jBT);
            if (this.vLM != null) {
                ix += C6087a.m9557ix(18, this.vLM.computeSize());
            }
            ix = (ix + C6091a.m9572bs(19, this.wIk)) + C6091a.m9572bs(20, this.vCj);
            if (this.vHO != null) {
                ix += C6091a.m9575f(21, this.vHO);
            }
            if (this.wIl != null) {
                ix += C6087a.m9557ix(22, this.wIl.computeSize());
            }
            if (this.luH != null) {
                ix += C6091a.m9575f(23, this.luH);
            }
            ix += C6091a.m9572bs(24, this.wIm);
            if (this.vLK != null) {
                ix += C6087a.m9557ix(25, this.vLK.computeSize());
            }
            if (this.wIn != null) {
                ix += C6091a.m9575f(26, this.wIn);
            }
            if (this.vMl != null) {
                ix += C6087a.m9557ix(27, this.vMl.computeSize());
            }
            if (this.wIo != null) {
                ix += C6091a.m9575f(28, this.wIo);
            }
            if (this.wsL != null) {
                ix += C6091a.m9575f(29, this.wsL);
            }
            if (this.wsO != null) {
                ix += C6087a.m9557ix(30, this.wsO.computeSize());
            }
            if (this.vHR != null) {
                ix += C6087a.m9557ix(31, this.vHR.computeSize());
            }
            if (this.vMm != null) {
                ix += C6087a.m9557ix(32, this.vMm.computeSize());
            }
            if (this.vMn != null) {
                ix += C6087a.m9557ix(33, this.vMn.computeSize());
            }
            if (this.wIp != null) {
                ix += C6087a.m9557ix(34, this.wIp.computeSize());
            }
            int bs = ix + C6091a.m9572bs(35, this.vHW);
            AppMethodBeat.m2505o(58921);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(58921);
                throw c6092b;
            }
            AppMethodBeat.m2505o(58921);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            beh beh = (beh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            C7273mw c7273mw;
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
                        beh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 2:
                    beh.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 3:
                    beh.vAN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 4:
                    beh.vCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 5:
                    beh.vCn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 6:
                    beh.wIh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 7:
                    beh.vCg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 8:
                    beh.vCo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 9:
                    beh.wIi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 10:
                    beh.wIj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7270lm c7270lm = new C7270lm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7270lm.populateBuilderWithField(c6086a3, c7270lm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vLL = c7270lm;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 15:
                    beh.vCp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 16:
                    beh.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 17:
                    beh.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdu bdu = new bdu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdu.populateBuilderWithField(c6086a3, bdu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vLM = bdu;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 19:
                    beh.wIk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 20:
                    beh.vCj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 21:
                    beh.vHO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkq bkq = new bkq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkq.populateBuilderWithField(c6086a3, bkq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.wIl = bkq;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 23:
                    beh.luH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 24:
                    beh.wIm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ato ato = new ato();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ato.populateBuilderWithField(c6086a3, ato, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vLK = ato;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 26:
                    beh.wIn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 27:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vMl = c7273mw;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    beh.wIo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 29:
                    beh.wsL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 30:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.wsO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 31:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzr bzr = new bzr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzr.populateBuilderWithField(c6086a3, bzr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vHR = bzr;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 32:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vMm = c7273mw;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 33:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.vMn = c7273mw;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 34:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvv bvv = new bvv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvv.populateBuilderWithField(c6086a3, bvv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beh.wIp = bvv;
                    }
                    AppMethodBeat.m2505o(58921);
                    return 0;
                case 35:
                    beh.vHW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58921);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58921);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58921);
            return -1;
        }
    }
}
