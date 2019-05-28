package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvq */
public final class cvq extends C1331a {
    public String wjQ;
    public String wjS;
    public cvp xrx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63697);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wjQ == null) {
                c6092b = new C6092b("Not all required fields were included: Rid");
                AppMethodBeat.m2505o(63697);
                throw c6092b;
            } else if (this.wjS == null) {
                c6092b = new C6092b("Not all required fields were included: MimeType");
                AppMethodBeat.m2505o(63697);
                throw c6092b;
            } else if (this.xrx == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.m2505o(63697);
                throw c6092b;
            } else {
                if (this.wjQ != null) {
                    c6093a.mo13475e(1, this.wjQ);
                }
                if (this.wjS != null) {
                    c6093a.mo13475e(2, this.wjS);
                }
                if (this.xrx != null) {
                    c6093a.mo13479iy(3, this.xrx.computeSize());
                    this.xrx.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(63697);
                return 0;
            }
        } else if (i == 1) {
            if (this.wjQ != null) {
                f = C6091a.m9575f(1, this.wjQ) + 0;
            } else {
                f = 0;
            }
            if (this.wjS != null) {
                f += C6091a.m9575f(2, this.wjS);
            }
            if (this.xrx != null) {
                f += C6087a.m9557ix(3, this.xrx.computeSize());
            }
            AppMethodBeat.m2505o(63697);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wjQ == null) {
                c6092b = new C6092b("Not all required fields were included: Rid");
                AppMethodBeat.m2505o(63697);
                throw c6092b;
            } else if (this.wjS == null) {
                c6092b = new C6092b("Not all required fields were included: MimeType");
                AppMethodBeat.m2505o(63697);
                throw c6092b;
            } else if (this.xrx == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.m2505o(63697);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(63697);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvq cvq = (cvq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvq.wjQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63697);
                    return 0;
                case 2:
                    cvq.wjS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63697);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cvp cvp = new cvp();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvp.populateBuilderWithField(c6086a3, cvp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvq.xrx = cvp;
                    }
                    AppMethodBeat.m2505o(63697);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63697);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63697);
            return -1;
        }
    }
}
