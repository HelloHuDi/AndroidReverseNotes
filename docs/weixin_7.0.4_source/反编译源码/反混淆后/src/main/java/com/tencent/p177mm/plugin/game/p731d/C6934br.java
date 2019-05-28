package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.br */
public final class C6934br extends C1331a {
    public String desc;
    public LinkedList<C28188bz> kfL = new LinkedList();
    public String summary;
    public String title;
    public String url;

    public C6934br() {
        AppMethodBeat.m2504i(111622);
        AppMethodBeat.m2505o(111622);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111623);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.summary != null) {
                c6093a.mo13475e(1, this.summary);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            c6093a.mo13474e(3, 8, this.kfL);
            if (this.url != null) {
                c6093a.mo13475e(4, this.url);
            }
            if (this.title != null) {
                c6093a.mo13475e(5, this.title);
            }
            AppMethodBeat.m2505o(111623);
            return 0;
        } else if (i == 1) {
            if (this.summary != null) {
                f = C6091a.m9575f(1, this.summary) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            f += C6087a.m9552c(3, 8, this.kfL);
            if (this.url != null) {
                f += C6091a.m9575f(4, this.url);
            }
            if (this.title != null) {
                f += C6091a.m9575f(5, this.title);
            }
            AppMethodBeat.m2505o(111623);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kfL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111623);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6934br c6934br = (C6934br) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c6934br.summary = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111623);
                    return 0;
                case 2:
                    c6934br.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111623);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28188bz c28188bz = new C28188bz();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c28188bz.populateBuilderWithField(c6086a3, c28188bz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6934br.kfL.add(c28188bz);
                    }
                    AppMethodBeat.m2505o(111623);
                    return 0;
                case 4:
                    c6934br.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111623);
                    return 0;
                case 5:
                    c6934br.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111623);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111623);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111623);
            return -1;
        }
    }
}
