package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bpy */
public final class bpy extends C1331a {
    public String wSh;
    public String wSi;
    public int wSj;
    public int wSk = 0;
    public String wSl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124336);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wSh != null) {
                c6093a.mo13475e(1, this.wSh);
            }
            if (this.wSi != null) {
                c6093a.mo13475e(2, this.wSi);
            }
            c6093a.mo13480iz(3, this.wSj);
            c6093a.mo13480iz(4, this.wSk);
            if (this.wSl != null) {
                c6093a.mo13475e(5, this.wSl);
            }
            AppMethodBeat.m2505o(124336);
            return 0;
        } else if (i == 1) {
            if (this.wSh != null) {
                f = C6091a.m9575f(1, this.wSh) + 0;
            } else {
                f = 0;
            }
            if (this.wSi != null) {
                f += C6091a.m9575f(2, this.wSi);
            }
            f = (f + C6091a.m9572bs(3, this.wSj)) + C6091a.m9572bs(4, this.wSk);
            if (this.wSl != null) {
                f += C6091a.m9575f(5, this.wSl);
            }
            AppMethodBeat.m2505o(124336);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124336);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bpy bpy = (bpy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpy.wSh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124336);
                    return 0;
                case 2:
                    bpy.wSi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124336);
                    return 0;
                case 3:
                    bpy.wSj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124336);
                    return 0;
                case 4:
                    bpy.wSk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124336);
                    return 0;
                case 5:
                    bpy.wSl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124336);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124336);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124336);
            return -1;
        }
    }
}
