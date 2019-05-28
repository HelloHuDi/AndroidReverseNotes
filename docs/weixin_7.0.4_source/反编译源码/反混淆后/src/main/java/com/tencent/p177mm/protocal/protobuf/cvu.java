package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvu */
public final class cvu extends C1331a {
    public String Md5;
    public String vMJ;
    public String xql;
    public int xrE;
    public int xrF;
    public String xrK;
    public cvm xrL;
    public cvt xrM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63702);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xrK == null) {
                c6092b = new C6092b("Not all required fields were included: EntranceDomain");
                AppMethodBeat.m2505o(63702);
                throw c6092b;
            } else if (this.xql == null) {
                c6092b = new C6092b("Not all required fields were included: Charset");
                AppMethodBeat.m2505o(63702);
                throw c6092b;
            } else {
                if (this.xrK != null) {
                    c6093a.mo13475e(4, this.xrK);
                }
                if (this.xql != null) {
                    c6093a.mo13475e(12, this.xql);
                }
                if (this.xrL != null) {
                    c6093a.mo13479iy(9, this.xrL.computeSize());
                    this.xrL.writeFields(c6093a);
                }
                if (this.xrM != null) {
                    c6093a.mo13479iy(10, this.xrM.computeSize());
                    this.xrM.writeFields(c6093a);
                }
                if (this.Md5 != null) {
                    c6093a.mo13475e(5, this.Md5);
                }
                if (this.vMJ != null) {
                    c6093a.mo13475e(6, this.vMJ);
                }
                c6093a.mo13480iz(7, this.xrE);
                c6093a.mo13480iz(8, this.xrF);
                AppMethodBeat.m2505o(63702);
                return 0;
            }
        } else if (i == 1) {
            if (this.xrK != null) {
                f = C6091a.m9575f(4, this.xrK) + 0;
            } else {
                f = 0;
            }
            if (this.xql != null) {
                f += C6091a.m9575f(12, this.xql);
            }
            if (this.xrL != null) {
                f += C6087a.m9557ix(9, this.xrL.computeSize());
            }
            if (this.xrM != null) {
                f += C6087a.m9557ix(10, this.xrM.computeSize());
            }
            if (this.Md5 != null) {
                f += C6091a.m9575f(5, this.Md5);
            }
            if (this.vMJ != null) {
                f += C6091a.m9575f(6, this.vMJ);
            }
            int bs = (f + C6091a.m9572bs(7, this.xrE)) + C6091a.m9572bs(8, this.xrF);
            AppMethodBeat.m2505o(63702);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.xrK == null) {
                c6092b = new C6092b("Not all required fields were included: EntranceDomain");
                AppMethodBeat.m2505o(63702);
                throw c6092b;
            } else if (this.xql == null) {
                c6092b = new C6092b("Not all required fields were included: Charset");
                AppMethodBeat.m2505o(63702);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(63702);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvu cvu = (cvu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 4:
                    cvu.xrK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 5:
                    cvu.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 6:
                    cvu.vMJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 7:
                    cvu.xrE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 8:
                    cvu.xrF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvm cvm = new cvm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvm.populateBuilderWithField(c6086a3, cvm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvu.xrL = cvm;
                    }
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvt cvt = new cvt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvt.populateBuilderWithField(c6086a3, cvt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvu.xrM = cvt;
                    }
                    AppMethodBeat.m2505o(63702);
                    return 0;
                case 12:
                    cvu.xql = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63702);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63702);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63702);
            return -1;
        }
    }
}
