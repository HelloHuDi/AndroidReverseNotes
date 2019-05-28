package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import org.xwalk.core.XWalkCoreWrapper;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bg */
public final class C44103bg extends C1331a {
    public String mZr;
    public String nad;
    public String ncH;
    public String vDk;
    public String vDl;
    public String vDm;
    public String vDn;
    public String vDo;
    public String vDp;
    public cyf vDq;
    public String vDr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZr != null) {
                c6093a.mo13475e(1, this.mZr);
            }
            if (this.vDk != null) {
                c6093a.mo13475e(2, this.vDk);
            }
            if (this.vDl != null) {
                c6093a.mo13475e(3, this.vDl);
            }
            if (this.nad != null) {
                c6093a.mo13475e(4, this.nad);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(5, this.ncH);
            }
            if (this.vDm != null) {
                c6093a.mo13475e(6, this.vDm);
            }
            if (this.vDn != null) {
                c6093a.mo13475e(7, this.vDn);
            }
            if (this.vDo != null) {
                c6093a.mo13475e(8, this.vDo);
            }
            if (this.vDp != null) {
                c6093a.mo13475e(9, this.vDp);
            }
            if (this.vDq != null) {
                c6093a.mo13479iy(10, this.vDq.computeSize());
                this.vDq.writeFields(c6093a);
            }
            if (this.vDr != null) {
                c6093a.mo13475e(11, this.vDr);
            }
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = C6091a.m9575f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.vDk != null) {
                f += C6091a.m9575f(2, this.vDk);
            }
            if (this.vDl != null) {
                f += C6091a.m9575f(3, this.vDl);
            }
            if (this.nad != null) {
                f += C6091a.m9575f(4, this.nad);
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(5, this.ncH);
            }
            if (this.vDm != null) {
                f += C6091a.m9575f(6, this.vDm);
            }
            if (this.vDn != null) {
                f += C6091a.m9575f(7, this.vDn);
            }
            if (this.vDo != null) {
                f += C6091a.m9575f(8, this.vDo);
            }
            if (this.vDp != null) {
                f += C6091a.m9575f(9, this.vDp);
            }
            if (this.vDq != null) {
                f += C6087a.m9557ix(10, this.vDq.computeSize());
            }
            if (this.vDr != null) {
                f += C6091a.m9575f(11, this.vDr);
            }
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44103bg c44103bg = (C44103bg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44103bg.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 2:
                    c44103bg.vDk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 3:
                    c44103bg.vDl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 4:
                    c44103bg.nad = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 5:
                    c44103bg.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 6:
                    c44103bg.vDm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 7:
                    c44103bg.vDn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 8:
                    c44103bg.vDo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 9:
                    c44103bg.vDp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 10:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cyf cyf = new cyf();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cyf.populateBuilderWithField(c6086a3, cyf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44103bg.vDq = cyf;
                    }
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 11:
                    c44103bg.vDr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                default:
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return -1;
        }
    }
}
