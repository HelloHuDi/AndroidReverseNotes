package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cz */
public final class C46532cz extends C1331a {
    public int cIb;
    public int pOA;
    public String pPZ;
    public int scene;
    public String vFb;
    public String vFc;
    public String vFd;
    public abv vFe;
    public String vFf;
    public int vFg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56702);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vFb == null) {
                c6092b = new C6092b("Not all required fields were included: f2f_id");
                AppMethodBeat.m2505o(56702);
                throw c6092b;
            } else if (this.vFd == null) {
                c6092b = new C6092b("Not all required fields were included: payok_checksign");
                AppMethodBeat.m2505o(56702);
                throw c6092b;
            } else {
                if (this.vFb != null) {
                    c6093a.mo13475e(1, this.vFb);
                }
                if (this.vFc != null) {
                    c6093a.mo13475e(2, this.vFc);
                }
                c6093a.mo13480iz(3, this.cIb);
                c6093a.mo13480iz(4, this.pOA);
                c6093a.mo13480iz(5, this.scene);
                if (this.vFd != null) {
                    c6093a.mo13475e(6, this.vFd);
                }
                if (this.vFe != null) {
                    c6093a.mo13479iy(7, this.vFe.computeSize());
                    this.vFe.writeFields(c6093a);
                }
                if (this.vFf != null) {
                    c6093a.mo13475e(8, this.vFf);
                }
                if (this.pPZ != null) {
                    c6093a.mo13475e(9, this.pPZ);
                }
                c6093a.mo13480iz(10, this.vFg);
                AppMethodBeat.m2505o(56702);
                return 0;
            }
        } else if (i == 1) {
            if (this.vFb != null) {
                f = C6091a.m9575f(1, this.vFb) + 0;
            } else {
                f = 0;
            }
            if (this.vFc != null) {
                f += C6091a.m9575f(2, this.vFc);
            }
            f = ((f + C6091a.m9572bs(3, this.cIb)) + C6091a.m9572bs(4, this.pOA)) + C6091a.m9572bs(5, this.scene);
            if (this.vFd != null) {
                f += C6091a.m9575f(6, this.vFd);
            }
            if (this.vFe != null) {
                f += C6087a.m9557ix(7, this.vFe.computeSize());
            }
            if (this.vFf != null) {
                f += C6091a.m9575f(8, this.vFf);
            }
            if (this.pPZ != null) {
                f += C6091a.m9575f(9, this.pPZ);
            }
            int bs = f + C6091a.m9572bs(10, this.vFg);
            AppMethodBeat.m2505o(56702);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vFb == null) {
                c6092b = new C6092b("Not all required fields were included: f2f_id");
                AppMethodBeat.m2505o(56702);
                throw c6092b;
            } else if (this.vFd == null) {
                c6092b = new C6092b("Not all required fields were included: payok_checksign");
                AppMethodBeat.m2505o(56702);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(56702);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46532cz c46532cz = (C46532cz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46532cz.vFb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 2:
                    c46532cz.vFc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 3:
                    c46532cz.cIb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 4:
                    c46532cz.pOA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 5:
                    c46532cz.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 6:
                    c46532cz.vFd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        abv abv = new abv();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = abv.populateBuilderWithField(c6086a3, abv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46532cz.vFe = abv;
                    }
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 8:
                    c46532cz.vFf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 9:
                    c46532cz.pPZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                case 10:
                    c46532cz.vFg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56702);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56702);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56702);
            return -1;
        }
    }
}
