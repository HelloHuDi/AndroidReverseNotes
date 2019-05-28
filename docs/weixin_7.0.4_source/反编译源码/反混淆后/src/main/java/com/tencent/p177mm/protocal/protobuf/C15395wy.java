package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.wy */
public final class C15395wy extends C1331a {
    public String desc;
    public String detail;
    public String title;
    public String url;
    public LinkedList<String> wcS = new LinkedList();
    public String wcT;

    public C15395wy() {
        AppMethodBeat.m2504i(89061);
        AppMethodBeat.m2505o(89061);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89062);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.desc != null) {
                c6093a.mo13475e(3, this.desc);
            }
            c6093a.mo13474e(4, 1, this.wcS);
            if (this.detail != null) {
                c6093a.mo13475e(5, this.detail);
            }
            if (this.wcT != null) {
                c6093a.mo13475e(6, this.wcT);
            }
            AppMethodBeat.m2505o(89062);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += C6091a.m9575f(2, this.url);
            }
            if (this.desc != null) {
                f += C6091a.m9575f(3, this.desc);
            }
            f += C6087a.m9552c(4, 1, this.wcS);
            if (this.detail != null) {
                f += C6091a.m9575f(5, this.detail);
            }
            if (this.wcT != null) {
                f += C6091a.m9575f(6, this.wcT);
            }
            AppMethodBeat.m2505o(89062);
            return f;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wcS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89062);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15395wy c15395wy = (C15395wy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15395wy.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89062);
                    return 0;
                case 2:
                    c15395wy.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89062);
                    return 0;
                case 3:
                    c15395wy.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89062);
                    return 0;
                case 4:
                    c15395wy.wcS.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(89062);
                    return 0;
                case 5:
                    c15395wy.detail = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89062);
                    return 0;
                case 6:
                    c15395wy.wcT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89062);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89062);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89062);
            return -1;
        }
    }
}
