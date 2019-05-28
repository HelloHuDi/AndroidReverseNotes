package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.av */
public final class C7252av extends C1331a {
    public int Scene;
    public String Url;
    public int jCt;
    public C15329dj vCA;
    public C44115du vCB;
    public C44114dt vCC;
    public C44114dt vCD;
    public String vCv;
    public String vCw;
    public String vCx;
    public C35904at vCy;
    public String vCz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94490);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCt);
            if (this.Url != null) {
                c6093a.mo13475e(2, this.Url);
            }
            c6093a.mo13480iz(3, this.Scene);
            if (this.vCv != null) {
                c6093a.mo13475e(4, this.vCv);
            }
            if (this.vCw != null) {
                c6093a.mo13475e(5, this.vCw);
            }
            if (this.vCx != null) {
                c6093a.mo13475e(6, this.vCx);
            }
            if (this.vCy != null) {
                c6093a.mo13479iy(7, this.vCy.computeSize());
                this.vCy.writeFields(c6093a);
            }
            if (this.vCz != null) {
                c6093a.mo13475e(8, this.vCz);
            }
            if (this.vCA != null) {
                c6093a.mo13479iy(9, this.vCA.computeSize());
                this.vCA.writeFields(c6093a);
            }
            if (this.vCB != null) {
                c6093a.mo13479iy(10, this.vCB.computeSize());
                this.vCB.writeFields(c6093a);
            }
            if (this.vCC != null) {
                c6093a.mo13479iy(11, this.vCC.computeSize());
                this.vCC.writeFields(c6093a);
            }
            if (this.vCD != null) {
                c6093a.mo13479iy(12, this.vCD.computeSize());
                this.vCD.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94490);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jCt) + 0;
            if (this.Url != null) {
                bs += C6091a.m9575f(2, this.Url);
            }
            bs += C6091a.m9572bs(3, this.Scene);
            if (this.vCv != null) {
                bs += C6091a.m9575f(4, this.vCv);
            }
            if (this.vCw != null) {
                bs += C6091a.m9575f(5, this.vCw);
            }
            if (this.vCx != null) {
                bs += C6091a.m9575f(6, this.vCx);
            }
            if (this.vCy != null) {
                bs += C6087a.m9557ix(7, this.vCy.computeSize());
            }
            if (this.vCz != null) {
                bs += C6091a.m9575f(8, this.vCz);
            }
            if (this.vCA != null) {
                bs += C6087a.m9557ix(9, this.vCA.computeSize());
            }
            if (this.vCB != null) {
                bs += C6087a.m9557ix(10, this.vCB.computeSize());
            }
            if (this.vCC != null) {
                bs += C6087a.m9557ix(11, this.vCC.computeSize());
            }
            if (this.vCD != null) {
                bs += C6087a.m9557ix(12, this.vCD.computeSize());
            }
            AppMethodBeat.m2505o(94490);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94490);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7252av c7252av = (C7252av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            C44114dt c44114dt;
            switch (intValue) {
                case 1:
                    c7252av.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 2:
                    c7252av.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 3:
                    c7252av.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 4:
                    c7252av.vCv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 5:
                    c7252av.vCw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 6:
                    c7252av.vCx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35904at c35904at = new C35904at();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35904at.populateBuilderWithField(c6086a3, c35904at, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7252av.vCy = c35904at;
                    }
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 8:
                    c7252av.vCz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15329dj c15329dj = new C15329dj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15329dj.populateBuilderWithField(c6086a3, c15329dj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7252av.vCA = c15329dj;
                    }
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44115du c44115du = new C44115du();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44115du.populateBuilderWithField(c6086a3, c44115du, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7252av.vCB = c44115du;
                    }
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44114dt = new C44114dt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44114dt.populateBuilderWithField(c6086a3, c44114dt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7252av.vCC = c44114dt;
                    }
                    AppMethodBeat.m2505o(94490);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44114dt = new C44114dt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44114dt.populateBuilderWithField(c6086a3, c44114dt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7252av.vCD = c44114dt;
                    }
                    AppMethodBeat.m2505o(94490);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94490);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94490);
            return -1;
        }
    }
}
