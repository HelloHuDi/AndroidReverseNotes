package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cjh */
public final class cjh extends C1331a {
    public String content;
    public String title;
    public ayi xhU;
    public ayi xhV;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48978);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.content != null) {
                c6093a.mo13475e(2, this.content);
            }
            if (this.xhU != null) {
                c6093a.mo13479iy(3, this.xhU.computeSize());
                this.xhU.writeFields(c6093a);
            }
            if (this.xhV != null) {
                c6093a.mo13479iy(4, this.xhV.computeSize());
                this.xhV.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48978);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.content != null) {
                f += C6091a.m9575f(2, this.content);
            }
            if (this.xhU != null) {
                f += C6087a.m9557ix(3, this.xhU.computeSize());
            }
            if (this.xhV != null) {
                f += C6087a.m9557ix(4, this.xhV.computeSize());
            }
            AppMethodBeat.m2505o(48978);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48978);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cjh cjh = (cjh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            ayi ayi;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cjh.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48978);
                    return 0;
                case 2:
                    cjh.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48978);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayi = new ayi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.populateBuilderWithField(c6086a3, ayi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjh.xhU = ayi;
                    }
                    AppMethodBeat.m2505o(48978);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayi = new ayi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.populateBuilderWithField(c6086a3, ayi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjh.xhV = ayi;
                    }
                    AppMethodBeat.m2505o(48978);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48978);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48978);
            return -1;
        }
    }
}
