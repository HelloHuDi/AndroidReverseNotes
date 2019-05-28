package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aur */
public final class aur extends C1331a {
    public String wyN;
    public String wyO;
    public C30240wx wyP;
    public C30240wx wyQ;
    public String wyR;
    public String wyS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48876);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wyN != null) {
                c6093a.mo13475e(1, this.wyN);
            }
            if (this.wyO != null) {
                c6093a.mo13475e(2, this.wyO);
            }
            if (this.wyP != null) {
                c6093a.mo13479iy(3, this.wyP.computeSize());
                this.wyP.writeFields(c6093a);
            }
            if (this.wyQ != null) {
                c6093a.mo13479iy(4, this.wyQ.computeSize());
                this.wyQ.writeFields(c6093a);
            }
            if (this.wyR != null) {
                c6093a.mo13475e(5, this.wyR);
            }
            if (this.wyS != null) {
                c6093a.mo13475e(6, this.wyS);
            }
            AppMethodBeat.m2505o(48876);
            return 0;
        } else if (i == 1) {
            if (this.wyN != null) {
                f = C6091a.m9575f(1, this.wyN) + 0;
            } else {
                f = 0;
            }
            if (this.wyO != null) {
                f += C6091a.m9575f(2, this.wyO);
            }
            if (this.wyP != null) {
                f += C6087a.m9557ix(3, this.wyP.computeSize());
            }
            if (this.wyQ != null) {
                f += C6087a.m9557ix(4, this.wyQ.computeSize());
            }
            if (this.wyR != null) {
                f += C6091a.m9575f(5, this.wyR);
            }
            if (this.wyS != null) {
                f += C6091a.m9575f(6, this.wyS);
            }
            AppMethodBeat.m2505o(48876);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48876);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aur aur = (aur) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C30240wx c30240wx;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    aur.wyN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48876);
                    return 0;
                case 2:
                    aur.wyO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48876);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c30240wx = new C30240wx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30240wx.populateBuilderWithField(c6086a3, c30240wx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aur.wyP = c30240wx;
                    }
                    AppMethodBeat.m2505o(48876);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c30240wx = new C30240wx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30240wx.populateBuilderWithField(c6086a3, c30240wx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aur.wyQ = c30240wx;
                    }
                    AppMethodBeat.m2505o(48876);
                    return 0;
                case 5:
                    aur.wyR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48876);
                    return 0;
                case 6:
                    aur.wyS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48876);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48876);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48876);
            return -1;
        }
    }
}
