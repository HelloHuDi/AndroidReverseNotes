package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cm */
public final class C7254cm extends C1331a {
    public int jBT;
    public int nao;
    public int pcX;
    public int ptD;
    public long ptF;
    public bts vEB;
    public bts vEC;
    public bts vED;
    public int vEE;
    public SKBuiltinBuffer_t vEF;
    public String vEG;
    public String vEH;
    public int vEI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58884);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else if (this.vED == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.ptD);
                if (this.vEB != null) {
                    c6093a.mo13479iy(2, this.vEB.computeSize());
                    this.vEB.writeFields(c6093a);
                }
                if (this.vEC != null) {
                    c6093a.mo13479iy(3, this.vEC.computeSize());
                    this.vEC.writeFields(c6093a);
                }
                c6093a.mo13480iz(4, this.nao);
                if (this.vED != null) {
                    c6093a.mo13479iy(5, this.vED.computeSize());
                    this.vED.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.jBT);
                c6093a.mo13480iz(7, this.vEE);
                if (this.vEF != null) {
                    c6093a.mo13479iy(8, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                c6093a.mo13480iz(9, this.pcX);
                if (this.vEG != null) {
                    c6093a.mo13475e(10, this.vEG);
                }
                if (this.vEH != null) {
                    c6093a.mo13475e(11, this.vEH);
                }
                c6093a.mo13472ai(12, this.ptF);
                c6093a.mo13480iz(13, this.vEI);
                AppMethodBeat.m2505o(58884);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ptD) + 0;
            if (this.vEB != null) {
                bs += C6087a.m9557ix(2, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                bs += C6087a.m9557ix(3, this.vEC.computeSize());
            }
            bs += C6091a.m9572bs(4, this.nao);
            if (this.vED != null) {
                bs += C6087a.m9557ix(5, this.vED.computeSize());
            }
            bs = (bs + C6091a.m9572bs(6, this.jBT)) + C6091a.m9572bs(7, this.vEE);
            if (this.vEF != null) {
                bs += C6087a.m9557ix(8, this.vEF.computeSize());
            }
            bs += C6091a.m9572bs(9, this.pcX);
            if (this.vEG != null) {
                bs += C6091a.m9575f(10, this.vEG);
            }
            if (this.vEH != null) {
                bs += C6091a.m9575f(11, this.vEH);
            }
            bs = (bs + C6091a.m9578o(12, this.ptF)) + C6091a.m9572bs(13, this.vEI);
            AppMethodBeat.m2505o(58884);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else if (this.vED == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(58884);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58884);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7254cm c7254cm = (C7254cm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c7254cm.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58884);
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
                        c7254cm.vEB = bts;
                    }
                    AppMethodBeat.m2505o(58884);
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
                        c7254cm.vEC = bts;
                    }
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 4:
                    c7254cm.nao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58884);
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
                        c7254cm.vED = bts;
                    }
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 6:
                    c7254cm.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 7:
                    c7254cm.vEE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58884);
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
                        c7254cm.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 9:
                    c7254cm.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 10:
                    c7254cm.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 11:
                    c7254cm.vEH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 12:
                    c7254cm.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(58884);
                    return 0;
                case 13:
                    c7254cm.vEI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58884);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58884);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58884);
            return -1;
        }
    }
}
