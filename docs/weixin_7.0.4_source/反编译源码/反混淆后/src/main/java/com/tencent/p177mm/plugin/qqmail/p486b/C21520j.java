package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.qqmail.b.j */
public final class C21520j extends C1331a {
    public String content;
    public int ptH;
    public String ptI;
    public LinkedList<C43404o> ptJ = new LinkedList();
    public LinkedList<C43404o> ptK = new LinkedList();
    public LinkedList<C43404o> ptL = new LinkedList();
    public LinkedList<C12886ai> ptM = new LinkedList();
    public String ptN;
    public int ptO = 5;

    public C21520j() {
        AppMethodBeat.m2504i(67931);
        AppMethodBeat.m2505o(67931);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(67932);
        C6092b c6092b;
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.content == null) {
                c6092b = new C6092b("Not all required fields were included: content");
                AppMethodBeat.m2505o(67932);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.ptH);
            if (this.ptI != null) {
                c6093a.mo13475e(2, this.ptI);
            }
            c6093a.mo13474e(3, 8, this.ptJ);
            c6093a.mo13474e(4, 8, this.ptK);
            c6093a.mo13474e(5, 8, this.ptL);
            c6093a.mo13474e(6, 8, this.ptM);
            if (this.ptN != null) {
                c6093a.mo13475e(7, this.ptN);
            }
            if (this.content != null) {
                c6093a.mo13475e(8, this.content);
            }
            c6093a.mo13480iz(9, this.ptO);
            AppMethodBeat.m2505o(67932);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ptH) + 0;
            if (this.ptI != null) {
                bs += C6091a.m9575f(2, this.ptI);
            }
            bs = (((bs + C6087a.m9552c(3, 8, this.ptJ)) + C6087a.m9552c(4, 8, this.ptK)) + C6087a.m9552c(5, 8, this.ptL)) + C6087a.m9552c(6, 8, this.ptM);
            if (this.ptN != null) {
                bs += C6091a.m9575f(7, this.ptN);
            }
            if (this.content != null) {
                bs += C6091a.m9575f(8, this.content);
            }
            bs += C6091a.m9572bs(9, this.ptO);
            AppMethodBeat.m2505o(67932);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ptJ.clear();
            this.ptK.clear();
            this.ptL.clear();
            this.ptM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.content == null) {
                c6092b = new C6092b("Not all required fields were included: content");
                AppMethodBeat.m2505o(67932);
                throw c6092b;
            }
            AppMethodBeat.m2505o(67932);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C21520j c21520j = (C21520j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C43404o c43404o;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c21520j.ptH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 2:
                    c21520j.ptI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43404o = new C43404o();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43404o.populateBuilderWithField(c6086a3, c43404o, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c21520j.ptJ.add(c43404o);
                    }
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43404o = new C43404o();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43404o.populateBuilderWithField(c6086a3, c43404o, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c21520j.ptK.add(c43404o);
                    }
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43404o = new C43404o();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43404o.populateBuilderWithField(c6086a3, c43404o, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c21520j.ptL.add(c43404o);
                    }
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12886ai c12886ai = new C12886ai();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12886ai.populateBuilderWithField(c6086a3, c12886ai, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c21520j.ptM.add(c12886ai);
                    }
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 7:
                    c21520j.ptN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 8:
                    c21520j.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67932);
                    return 0;
                case 9:
                    c21520j.ptO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67932);
                    return 0;
                default:
                    AppMethodBeat.m2505o(67932);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(67932);
            return -1;
        }
    }
}
