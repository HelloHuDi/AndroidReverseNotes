package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mg */
public final class C7271mg extends C1331a {
    public String jCH;
    public String mZj;
    public C35935mi vPY;
    public bvo vQb;
    public C15362mo vQc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124293);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jCH == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(124293);
                throw c6092b;
            } else if (this.vQb == null) {
                c6092b = new C6092b("Not all required fields were included: ContactItem");
                AppMethodBeat.m2505o(124293);
                throw c6092b;
            } else {
                if (this.jCH != null) {
                    c6093a.mo13475e(1, this.jCH);
                }
                if (this.vPY != null) {
                    c6093a.mo13479iy(2, this.vPY.computeSize());
                    this.vPY.writeFields(c6093a);
                }
                if (this.vQb != null) {
                    c6093a.mo13479iy(3, this.vQb.computeSize());
                    this.vQb.writeFields(c6093a);
                }
                if (this.vQc != null) {
                    c6093a.mo13479iy(4, this.vQc.computeSize());
                    this.vQc.writeFields(c6093a);
                }
                if (this.mZj != null) {
                    c6093a.mo13475e(5, this.mZj);
                }
                AppMethodBeat.m2505o(124293);
                return 0;
            }
        } else if (i == 1) {
            if (this.jCH != null) {
                f = C6091a.m9575f(1, this.jCH) + 0;
            } else {
                f = 0;
            }
            if (this.vPY != null) {
                f += C6087a.m9557ix(2, this.vPY.computeSize());
            }
            if (this.vQb != null) {
                f += C6087a.m9557ix(3, this.vQb.computeSize());
            }
            if (this.vQc != null) {
                f += C6087a.m9557ix(4, this.vQc.computeSize());
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(5, this.mZj);
            }
            AppMethodBeat.m2505o(124293);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jCH == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(124293);
                throw c6092b;
            } else if (this.vQb == null) {
                c6092b = new C6092b("Not all required fields were included: ContactItem");
                AppMethodBeat.m2505o(124293);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(124293);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7271mg c7271mg = (C7271mg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c7271mg.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124293);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35935mi c35935mi = new C35935mi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35935mi.populateBuilderWithField(c6086a3, c35935mi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7271mg.vPY = c35935mi;
                    }
                    AppMethodBeat.m2505o(124293);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvo bvo = new bvo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvo.populateBuilderWithField(c6086a3, bvo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7271mg.vQb = bvo;
                    }
                    AppMethodBeat.m2505o(124293);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15362mo c15362mo = new C15362mo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15362mo.populateBuilderWithField(c6086a3, c15362mo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7271mg.vQc = c15362mo;
                    }
                    AppMethodBeat.m2505o(124293);
                    return 0;
                case 5:
                    c7271mg.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124293);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124293);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124293);
            return -1;
        }
    }
}
