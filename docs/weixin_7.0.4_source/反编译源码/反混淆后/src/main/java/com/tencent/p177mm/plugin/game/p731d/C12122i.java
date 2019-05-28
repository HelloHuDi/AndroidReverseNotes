package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.i */
public final class C12122i extends C1331a {
    public String mZL;
    public String mZM;
    public int mZN;
    public C6929a mZO;
    public C39196db mZP;
    public int mZQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111549);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZM != null) {
                c6093a.mo13475e(1, this.mZM);
            }
            c6093a.mo13480iz(2, this.mZN);
            if (this.mZO != null) {
                c6093a.mo13479iy(3, this.mZO.computeSize());
                this.mZO.writeFields(c6093a);
            }
            if (this.mZP != null) {
                c6093a.mo13479iy(4, this.mZP.computeSize());
                this.mZP.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.mZQ);
            if (this.mZL != null) {
                c6093a.mo13475e(6, this.mZL);
            }
            AppMethodBeat.m2505o(111549);
            return 0;
        } else if (i == 1) {
            if (this.mZM != null) {
                f = C6091a.m9575f(1, this.mZM) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.mZN);
            if (this.mZO != null) {
                f += C6087a.m9557ix(3, this.mZO.computeSize());
            }
            if (this.mZP != null) {
                f += C6087a.m9557ix(4, this.mZP.computeSize());
            }
            f += C6091a.m9572bs(5, this.mZQ);
            if (this.mZL != null) {
                f += C6091a.m9575f(6, this.mZL);
            }
            AppMethodBeat.m2505o(111549);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111549);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12122i c12122i = (C12122i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c12122i.mZM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111549);
                    return 0;
                case 2:
                    c12122i.mZN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111549);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6929a c6929a = new C6929a();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c6929a.populateBuilderWithField(c6086a3, c6929a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12122i.mZO = c6929a;
                    }
                    AppMethodBeat.m2505o(111549);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39196db c39196db = new C39196db();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39196db.populateBuilderWithField(c6086a3, c39196db, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12122i.mZP = c39196db;
                    }
                    AppMethodBeat.m2505o(111549);
                    return 0;
                case 5:
                    c12122i.mZQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111549);
                    return 0;
                case 6:
                    c12122i.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111549);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111549);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111549);
            return -1;
        }
    }
}
