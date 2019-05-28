package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bjl */
public final class bjl extends C1331a {
    public String desc;
    public String kbV;
    public String name;
    public String title;
    public int ttd;
    public String tte;
    public String ttg;
    public String tzW;
    public bqo wMS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48918);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.name != null) {
                c6093a.mo13475e(1, this.name);
            }
            if (this.title != null) {
                c6093a.mo13475e(2, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(3, this.desc);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(4, this.kbV);
            }
            c6093a.mo13480iz(5, this.ttd);
            if (this.tte != null) {
                c6093a.mo13475e(6, this.tte);
            }
            if (this.tzW != null) {
                c6093a.mo13475e(7, this.tzW);
            }
            if (this.ttg != null) {
                c6093a.mo13475e(8, this.ttg);
            }
            if (this.wMS != null) {
                c6093a.mo13479iy(9, this.wMS.computeSize());
                this.wMS.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48918);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = C6091a.m9575f(1, this.name) + 0;
            } else {
                f = 0;
            }
            if (this.title != null) {
                f += C6091a.m9575f(2, this.title);
            }
            if (this.desc != null) {
                f += C6091a.m9575f(3, this.desc);
            }
            if (this.kbV != null) {
                f += C6091a.m9575f(4, this.kbV);
            }
            f += C6091a.m9572bs(5, this.ttd);
            if (this.tte != null) {
                f += C6091a.m9575f(6, this.tte);
            }
            if (this.tzW != null) {
                f += C6091a.m9575f(7, this.tzW);
            }
            if (this.ttg != null) {
                f += C6091a.m9575f(8, this.ttg);
            }
            if (this.wMS != null) {
                f += C6087a.m9557ix(9, this.wMS.computeSize());
            }
            AppMethodBeat.m2505o(48918);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48918);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bjl bjl = (bjl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjl.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 2:
                    bjl.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 3:
                    bjl.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 4:
                    bjl.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 5:
                    bjl.ttd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 6:
                    bjl.tte = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 7:
                    bjl.tzW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 8:
                    bjl.ttg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48918);
                    return 0;
                case 9:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bqo bqo = new bqo();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqo.populateBuilderWithField(c6086a3, bqo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjl.wMS = bqo;
                    }
                    AppMethodBeat.m2505o(48918);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48918);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48918);
            return -1;
        }
    }
}
