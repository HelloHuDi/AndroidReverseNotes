package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.qqmail.b.ai */
public final class C12886ai extends C1331a {
    public String name;
    public String path;
    public long pvG;
    public String pvH;
    public long size;
    public int state;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(68075);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.path == null) {
                c6092b = new C6092b("Not all required fields were included: path");
                AppMethodBeat.m2505o(68075);
                throw c6092b;
            } else if (this.name == null) {
                c6092b = new C6092b("Not all required fields were included: name");
                AppMethodBeat.m2505o(68075);
                throw c6092b;
            } else {
                if (this.path != null) {
                    c6093a.mo13475e(1, this.path);
                }
                if (this.name != null) {
                    c6093a.mo13475e(2, this.name);
                }
                c6093a.mo13472ai(3, this.size);
                c6093a.mo13480iz(4, this.state);
                c6093a.mo13472ai(5, this.pvG);
                if (this.pvH != null) {
                    c6093a.mo13475e(6, this.pvH);
                }
                AppMethodBeat.m2505o(68075);
                return 0;
            }
        } else if (i == 1) {
            if (this.path != null) {
                f = C6091a.m9575f(1, this.path) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += C6091a.m9575f(2, this.name);
            }
            f = ((f + C6091a.m9578o(3, this.size)) + C6091a.m9572bs(4, this.state)) + C6091a.m9578o(5, this.pvG);
            if (this.pvH != null) {
                f += C6091a.m9575f(6, this.pvH);
            }
            AppMethodBeat.m2505o(68075);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.path == null) {
                c6092b = new C6092b("Not all required fields were included: path");
                AppMethodBeat.m2505o(68075);
                throw c6092b;
            } else if (this.name == null) {
                c6092b = new C6092b("Not all required fields were included: name");
                AppMethodBeat.m2505o(68075);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(68075);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12886ai c12886ai = (C12886ai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c12886ai.path = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(68075);
                    return 0;
                case 2:
                    c12886ai.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(68075);
                    return 0;
                case 3:
                    c12886ai.size = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(68075);
                    return 0;
                case 4:
                    c12886ai.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(68075);
                    return 0;
                case 5:
                    c12886ai.pvG = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(68075);
                    return 0;
                case 6:
                    c12886ai.pvH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(68075);
                    return 0;
                default:
                    AppMethodBeat.m2505o(68075);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(68075);
            return -1;
        }
    }
}
