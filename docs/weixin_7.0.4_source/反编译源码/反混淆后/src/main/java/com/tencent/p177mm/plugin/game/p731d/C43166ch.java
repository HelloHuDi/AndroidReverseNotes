package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ch */
public final class C43166ch extends C1331a {
    public LinkedList<C20947b> ncU = new LinkedList();
    public C39193cq ncV;
    public LinkedList<C45999l> ncW = new LinkedList();
    public C20953cm ncX;
    public LinkedList<C45995dc> ncY = new LinkedList();

    public C43166ch() {
        AppMethodBeat.m2504i(111644);
        AppMethodBeat.m2505o(111644);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111645);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.ncU);
            if (this.ncV != null) {
                c6093a.mo13479iy(2, this.ncV.computeSize());
                this.ncV.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.ncW);
            if (this.ncX != null) {
                c6093a.mo13479iy(4, this.ncX.computeSize());
                this.ncX.writeFields(c6093a);
            }
            c6093a.mo13474e(5, 8, this.ncY);
            AppMethodBeat.m2505o(111645);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.ncU) + 0;
            if (this.ncV != null) {
                c += C6087a.m9557ix(2, this.ncV.computeSize());
            }
            c += C6087a.m9552c(3, 8, this.ncW);
            if (this.ncX != null) {
                c += C6087a.m9557ix(4, this.ncX.computeSize());
            }
            c += C6087a.m9552c(5, 8, this.ncY);
            AppMethodBeat.m2505o(111645);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncU.clear();
            this.ncW.clear();
            this.ncY.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111645);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43166ch c43166ch = (C43166ch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20947b c20947b = new C20947b();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20947b.populateBuilderWithField(c6086a3, c20947b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43166ch.ncU.add(c20947b);
                    }
                    AppMethodBeat.m2505o(111645);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39193cq c39193cq = new C39193cq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39193cq.populateBuilderWithField(c6086a3, c39193cq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43166ch.ncV = c39193cq;
                    }
                    AppMethodBeat.m2505o(111645);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45999l c45999l = new C45999l();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45999l.populateBuilderWithField(c6086a3, c45999l, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43166ch.ncW.add(c45999l);
                    }
                    AppMethodBeat.m2505o(111645);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20953cm c20953cm = new C20953cm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20953cm.populateBuilderWithField(c6086a3, c20953cm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43166ch.ncX = c20953cm;
                    }
                    AppMethodBeat.m2505o(111645);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45995dc c45995dc = new C45995dc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45995dc.populateBuilderWithField(c6086a3, c45995dc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43166ch.ncY.add(c45995dc);
                    }
                    AppMethodBeat.m2505o(111645);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111645);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111645);
            return -1;
        }
    }
}
