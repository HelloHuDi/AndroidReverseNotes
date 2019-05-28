package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hg */
public final class C7265hg extends C1331a {
    public String title;
    public btr vCP;
    public String vJS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48778);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.vCP != null) {
                c6093a.mo13479iy(2, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(3, this.vJS);
            }
            AppMethodBeat.m2505o(48778);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.vCP != null) {
                f += C6087a.m9557ix(2, this.vCP.computeSize());
            }
            if (this.vJS != null) {
                f += C6091a.m9575f(3, this.vJS);
            }
            AppMethodBeat.m2505o(48778);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48778);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7265hg c7265hg = (C7265hg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c7265hg.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48778);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7265hg.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48778);
                    return 0;
                case 3:
                    c7265hg.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48778);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48778);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48778);
            return -1;
        }
    }
}
