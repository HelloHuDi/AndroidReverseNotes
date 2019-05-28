package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvr */
public final class cvr extends C1331a {
    public String fKh;
    public cvo xrH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63698);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(63698);
                throw c6092b;
            } else if (this.xrH == null) {
                c6092b = new C6092b("Not all required fields were included: PkgConfig");
                AppMethodBeat.m2505o(63698);
                throw c6092b;
            } else {
                if (this.fKh != null) {
                    c6093a.mo13475e(1, this.fKh);
                }
                if (this.xrH != null) {
                    c6093a.mo13479iy(2, this.xrH.computeSize());
                    this.xrH.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(63698);
                return 0;
            }
        } else if (i == 1) {
            if (this.fKh != null) {
                f = C6091a.m9575f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.xrH != null) {
                f += C6087a.m9557ix(2, this.xrH.computeSize());
            }
            AppMethodBeat.m2505o(63698);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(63698);
                throw c6092b;
            } else if (this.xrH == null) {
                c6092b = new C6092b("Not all required fields were included: PkgConfig");
                AppMethodBeat.m2505o(63698);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(63698);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvr cvr = (cvr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvr.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63698);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cvo cvo = new cvo();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvo.populateBuilderWithField(c6086a3, cvo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvr.xrH = cvo;
                    }
                    AppMethodBeat.m2505o(63698);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63698);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63698);
            return -1;
        }
    }
}
