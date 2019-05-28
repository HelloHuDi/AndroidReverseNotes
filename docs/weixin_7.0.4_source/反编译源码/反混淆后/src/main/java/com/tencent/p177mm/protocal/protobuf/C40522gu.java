package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gu */
public final class C40522gu extends C1331a {
    public int jCt;
    public int ptD;
    public long ptF;
    public bts vEB;
    public bts vEC;
    public bts vED;
    public String vEG;
    public String vFF;
    public int vIY;
    public int vIZ;
    public int vJa;
    public LinkedList<bts> vJb = new LinkedList();
    public LinkedList<btt> vJc = new LinkedList();
    public SKBuiltinBuffer_t vJd;
    public int vJe;
    public int vJf;
    public int vJg;
    public long vJh;
    public int vJi;

    public C40522gu() {
        AppMethodBeat.m2504i(28333);
        AppMethodBeat.m2505o(28333);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28334);
        C6092b c6092b;
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(28334);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(28334);
                throw c6092b;
            } else if (this.vED == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28334);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.jCt);
                if (this.vFF != null) {
                    c6093a.mo13475e(2, this.vFF);
                }
                if (this.vEB != null) {
                    c6093a.mo13479iy(3, this.vEB.computeSize());
                    this.vEB.writeFields(c6093a);
                }
                if (this.vEC != null) {
                    c6093a.mo13479iy(4, this.vEC.computeSize());
                    this.vEC.writeFields(c6093a);
                }
                if (this.vED != null) {
                    c6093a.mo13479iy(5, this.vED.computeSize());
                    this.vED.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.vIY);
                c6093a.mo13480iz(7, this.vIZ);
                if (this.vEG != null) {
                    c6093a.mo13475e(8, this.vEG);
                }
                c6093a.mo13480iz(9, this.ptD);
                c6093a.mo13480iz(10, this.vJa);
                c6093a.mo13474e(11, 8, this.vJb);
                c6093a.mo13474e(12, 8, this.vJc);
                if (this.vJd != null) {
                    c6093a.mo13479iy(13, this.vJd.computeSize());
                    this.vJd.writeFields(c6093a);
                }
                c6093a.mo13480iz(14, this.vJe);
                c6093a.mo13480iz(15, this.vJf);
                c6093a.mo13472ai(16, this.ptF);
                c6093a.mo13480iz(17, this.vJg);
                c6093a.mo13472ai(18, this.vJh);
                c6093a.mo13480iz(19, this.vJi);
                AppMethodBeat.m2505o(28334);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jCt) + 0;
            if (this.vFF != null) {
                bs += C6091a.m9575f(2, this.vFF);
            }
            if (this.vEB != null) {
                bs += C6087a.m9557ix(3, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                bs += C6087a.m9557ix(4, this.vEC.computeSize());
            }
            if (this.vED != null) {
                bs += C6087a.m9557ix(5, this.vED.computeSize());
            }
            bs = (bs + C6091a.m9572bs(6, this.vIY)) + C6091a.m9572bs(7, this.vIZ);
            if (this.vEG != null) {
                bs += C6091a.m9575f(8, this.vEG);
            }
            bs = (((bs + C6091a.m9572bs(9, this.ptD)) + C6091a.m9572bs(10, this.vJa)) + C6087a.m9552c(11, 8, this.vJb)) + C6087a.m9552c(12, 8, this.vJc);
            if (this.vJd != null) {
                bs += C6087a.m9557ix(13, this.vJd.computeSize());
            }
            bs = (((((bs + C6091a.m9572bs(14, this.vJe)) + C6091a.m9572bs(15, this.vJf)) + C6091a.m9578o(16, this.ptF)) + C6091a.m9572bs(17, this.vJg)) + C6091a.m9578o(18, this.vJh)) + C6091a.m9572bs(19, this.vJi);
            AppMethodBeat.m2505o(28334);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJb.clear();
            this.vJc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(28334);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(28334);
                throw c6092b;
            } else if (this.vED == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28334);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28334);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40522gu c40522gu = (C40522gu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c40522gu.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 2:
                    c40522gu.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28334);
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
                        c40522gu.vEB = bts;
                    }
                    AppMethodBeat.m2505o(28334);
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
                        c40522gu.vEC = bts;
                    }
                    AppMethodBeat.m2505o(28334);
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
                        c40522gu.vED = bts;
                    }
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 6:
                    c40522gu.vIY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 7:
                    c40522gu.vIZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 8:
                    c40522gu.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 9:
                    c40522gu.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 10:
                    c40522gu.vJa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40522gu.vJb.add(bts);
                    }
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btt btt = new btt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btt.populateBuilderWithField(c6086a3, btt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40522gu.vJc.add(btt);
                    }
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40522gu.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 14:
                    c40522gu.vJe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 15:
                    c40522gu.vJf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 16:
                    c40522gu.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 17:
                    c40522gu.vJg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 18:
                    c40522gu.vJh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                case 19:
                    c40522gu.vJi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28334);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28334);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28334);
            return -1;
        }
    }
}
