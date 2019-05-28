package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mn */
public final class C15361mn extends C1331a {
    public int jCt;
    public C35936ml vQA;
    public C7271mg vQv;
    public C15360mf vQw;
    public long vQx;
    public C7272mm vQy;
    public C15363mp vQz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124300);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCt);
            if (this.vQv != null) {
                c6093a.mo13479iy(2, this.vQv.computeSize());
                this.vQv.writeFields(c6093a);
            }
            if (this.vQw != null) {
                c6093a.mo13479iy(3, this.vQw.computeSize());
                this.vQw.writeFields(c6093a);
            }
            c6093a.mo13472ai(4, this.vQx);
            if (this.vQy != null) {
                c6093a.mo13479iy(5, this.vQy.computeSize());
                this.vQy.writeFields(c6093a);
            }
            if (this.vQz != null) {
                c6093a.mo13479iy(6, this.vQz.computeSize());
                this.vQz.writeFields(c6093a);
            }
            if (this.vQA != null) {
                c6093a.mo13479iy(7, this.vQA.computeSize());
                this.vQA.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(124300);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jCt) + 0;
            if (this.vQv != null) {
                bs += C6087a.m9557ix(2, this.vQv.computeSize());
            }
            if (this.vQw != null) {
                bs += C6087a.m9557ix(3, this.vQw.computeSize());
            }
            bs += C6091a.m9578o(4, this.vQx);
            if (this.vQy != null) {
                bs += C6087a.m9557ix(5, this.vQy.computeSize());
            }
            if (this.vQz != null) {
                bs += C6087a.m9557ix(6, this.vQz.computeSize());
            }
            if (this.vQA != null) {
                bs += C6087a.m9557ix(7, this.vQA.computeSize());
            }
            AppMethodBeat.m2505o(124300);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124300);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15361mn c15361mn = (C15361mn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c15361mn.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124300);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7271mg c7271mg = new C7271mg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7271mg.populateBuilderWithField(c6086a3, c7271mg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15361mn.vQv = c7271mg;
                    }
                    AppMethodBeat.m2505o(124300);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15360mf c15360mf = new C15360mf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15360mf.populateBuilderWithField(c6086a3, c15360mf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15361mn.vQw = c15360mf;
                    }
                    AppMethodBeat.m2505o(124300);
                    return 0;
                case 4:
                    c15361mn.vQx = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124300);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7272mm c7272mm = new C7272mm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7272mm.populateBuilderWithField(c6086a3, c7272mm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15361mn.vQy = c7272mm;
                    }
                    AppMethodBeat.m2505o(124300);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15363mp c15363mp = new C15363mp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15363mp.populateBuilderWithField(c6086a3, c15363mp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15361mn.vQz = c15363mp;
                    }
                    AppMethodBeat.m2505o(124300);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35936ml c35936ml = new C35936ml();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35936ml.populateBuilderWithField(c6086a3, c35936ml, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15361mn.vQA = c35936ml;
                    }
                    AppMethodBeat.m2505o(124300);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124300);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124300);
            return -1;
        }
    }
}
