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

/* renamed from: com.tencent.mm.protocal.protobuf.adp */
public final class adp extends btd {
    public String SSID;
    public String Title;
    public String jBB;
    public String ncM;
    public String nzz;
    public String vAI;
    public int vAS;
    public avn wlA;
    public adl wlB;
    public String wlC;
    public int wlD;
    public LinkedList<C40541le> wlE = new LinkedList();
    public String wlF;
    public C30233vc wlG;
    public SKBuiltinBuffer_t wlH;
    public int wlI;
    public LinkedList<atp> wlJ = new LinkedList();
    public String wlK;
    public String wlL;
    public SKBuiltinBuffer_t wlw;
    public String wly;
    public String wlz;

    public adp() {
        AppMethodBeat.m2504i(80055);
        AppMethodBeat.m2505o(80055);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80056);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80056);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wly != null) {
                c6093a.mo13475e(2, this.wly);
            }
            if (this.wlz != null) {
                c6093a.mo13475e(3, this.wlz);
            }
            c6093a.mo13480iz(4, this.vAS);
            if (this.Title != null) {
                c6093a.mo13475e(5, this.Title);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(6, this.ncM);
            }
            if (this.wlA != null) {
                c6093a.mo13479iy(7, this.wlA.computeSize());
                this.wlA.writeFields(c6093a);
            }
            if (this.wlB != null) {
                c6093a.mo13479iy(8, this.wlB.computeSize());
                this.wlB.writeFields(c6093a);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(9, this.jBB);
            }
            if (this.wlC != null) {
                c6093a.mo13475e(15, this.wlC);
            }
            c6093a.mo13480iz(16, this.wlD);
            c6093a.mo13474e(17, 8, this.wlE);
            if (this.wlF != null) {
                c6093a.mo13475e(18, this.wlF);
            }
            if (this.SSID != null) {
                c6093a.mo13475e(20, this.SSID);
            }
            if (this.vAI != null) {
                c6093a.mo13475e(21, this.vAI);
            }
            if (this.wlG != null) {
                c6093a.mo13479iy(22, this.wlG.computeSize());
                this.wlG.writeFields(c6093a);
            }
            if (this.wlH != null) {
                c6093a.mo13479iy(23, this.wlH.computeSize());
                this.wlH.writeFields(c6093a);
            }
            c6093a.mo13480iz(24, this.wlI);
            c6093a.mo13474e(25, 8, this.wlJ);
            if (this.nzz != null) {
                c6093a.mo13475e(26, this.nzz);
            }
            if (this.wlK != null) {
                c6093a.mo13475e(27, this.wlK);
            }
            if (this.wlw != null) {
                c6093a.mo13479iy(28, this.wlw.computeSize());
                this.wlw.writeFields(c6093a);
            }
            if (this.wlL != null) {
                c6093a.mo13475e(29, this.wlL);
            }
            AppMethodBeat.m2505o(80056);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wly != null) {
                ix += C6091a.m9575f(2, this.wly);
            }
            if (this.wlz != null) {
                ix += C6091a.m9575f(3, this.wlz);
            }
            ix += C6091a.m9572bs(4, this.vAS);
            if (this.Title != null) {
                ix += C6091a.m9575f(5, this.Title);
            }
            if (this.ncM != null) {
                ix += C6091a.m9575f(6, this.ncM);
            }
            if (this.wlA != null) {
                ix += C6087a.m9557ix(7, this.wlA.computeSize());
            }
            if (this.wlB != null) {
                ix += C6087a.m9557ix(8, this.wlB.computeSize());
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(9, this.jBB);
            }
            if (this.wlC != null) {
                ix += C6091a.m9575f(15, this.wlC);
            }
            ix = (ix + C6091a.m9572bs(16, this.wlD)) + C6087a.m9552c(17, 8, this.wlE);
            if (this.wlF != null) {
                ix += C6091a.m9575f(18, this.wlF);
            }
            if (this.SSID != null) {
                ix += C6091a.m9575f(20, this.SSID);
            }
            if (this.vAI != null) {
                ix += C6091a.m9575f(21, this.vAI);
            }
            if (this.wlG != null) {
                ix += C6087a.m9557ix(22, this.wlG.computeSize());
            }
            if (this.wlH != null) {
                ix += C6087a.m9557ix(23, this.wlH.computeSize());
            }
            ix = (ix + C6091a.m9572bs(24, this.wlI)) + C6087a.m9552c(25, 8, this.wlJ);
            if (this.nzz != null) {
                ix += C6091a.m9575f(26, this.nzz);
            }
            if (this.wlK != null) {
                ix += C6091a.m9575f(27, this.wlK);
            }
            if (this.wlw != null) {
                ix += C6087a.m9557ix(28, this.wlw.computeSize());
            }
            if (this.wlL != null) {
                ix += C6091a.m9575f(29, this.wlL);
            }
            AppMethodBeat.m2505o(80056);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlE.clear();
            this.wlJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80056);
                throw c6092b;
            }
            AppMethodBeat.m2505o(80056);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            adp adp = (adp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
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
                        adp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 2:
                    adp.wly = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 3:
                    adp.wlz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 4:
                    adp.vAS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 5:
                    adp.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 6:
                    adp.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avn avn = new avn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = avn.populateBuilderWithField(c6086a3, avn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlA = avn;
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        adl adl = new adl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = adl.populateBuilderWithField(c6086a3, adl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlB = adl;
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 9:
                    adp.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 15:
                    adp.wlC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 16:
                    adp.wlD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40541le c40541le = new C40541le();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40541le.populateBuilderWithField(c6086a3, c40541le, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlE.add(c40541le);
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 18:
                    adp.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 20:
                    adp.SSID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 21:
                    adp.vAI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30233vc c30233vc = new C30233vc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30233vc.populateBuilderWithField(c6086a3, c30233vc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlG = c30233vc;
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 24:
                    adp.wlI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atp atp = new atp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atp.populateBuilderWithField(c6086a3, atp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlJ.add(atp);
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 26:
                    adp.nzz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 27:
                    adp.wlK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adp.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80056);
                    return 0;
                case 29:
                    adp.wlL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80056);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80056);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80056);
            return -1;
        }
    }
}
