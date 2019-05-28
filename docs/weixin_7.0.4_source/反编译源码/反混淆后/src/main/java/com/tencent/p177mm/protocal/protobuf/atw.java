package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atw */
public final class atw extends C1331a {
    public String Md5;
    public String Name;
    public String Type;
    public String Url;
    public int jCo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28529);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Type != null) {
                c6093a.mo13475e(1, this.Type);
            }
            c6093a.mo13480iz(2, this.jCo);
            if (this.Md5 != null) {
                c6093a.mo13475e(3, this.Md5);
            }
            if (this.Url != null) {
                c6093a.mo13475e(4, this.Url);
            }
            if (this.Name != null) {
                c6093a.mo13475e(5, this.Name);
            }
            AppMethodBeat.m2505o(28529);
            return 0;
        } else if (i == 1) {
            if (this.Type != null) {
                f = C6091a.m9575f(1, this.Type) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.jCo);
            if (this.Md5 != null) {
                f += C6091a.m9575f(3, this.Md5);
            }
            if (this.Url != null) {
                f += C6091a.m9575f(4, this.Url);
            }
            if (this.Name != null) {
                f += C6091a.m9575f(5, this.Name);
            }
            AppMethodBeat.m2505o(28529);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28529);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atw atw = (atw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atw.Type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28529);
                    return 0;
                case 2:
                    atw.jCo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28529);
                    return 0;
                case 3:
                    atw.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28529);
                    return 0;
                case 4:
                    atw.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28529);
                    return 0;
                case 5:
                    atw.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28529);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28529);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28529);
            return -1;
        }
    }
}
