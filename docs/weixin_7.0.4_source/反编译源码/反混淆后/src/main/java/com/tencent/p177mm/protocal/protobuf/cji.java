package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cji */
public final class cji extends C1331a {
    public String desc;
    public String title;
    public LinkedList<cjg> vBz = new LinkedList();
    public int wRi;
    public String xhW;
    public String xhX;
    public ayi xhY;
    public int xhZ;
    public cjh xia;
    public cjh xib;

    public cji() {
        AppMethodBeat.m2504i(48979);
        AppMethodBeat.m2505o(48979);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48980);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.xhW != null) {
                c6093a.mo13475e(3, this.xhW);
            }
            if (this.xhX != null) {
                c6093a.mo13475e(4, this.xhX);
            }
            if (this.xhY != null) {
                c6093a.mo13479iy(5, this.xhY.computeSize());
                this.xhY.writeFields(c6093a);
            }
            c6093a.mo13474e(6, 8, this.vBz);
            c6093a.mo13480iz(7, this.wRi);
            c6093a.mo13480iz(8, this.xhZ);
            if (this.xia != null) {
                c6093a.mo13479iy(9, this.xia.computeSize());
                this.xia.writeFields(c6093a);
            }
            if (this.xib != null) {
                c6093a.mo13479iy(10, this.xib.computeSize());
                this.xib.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48980);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            if (this.xhW != null) {
                f += C6091a.m9575f(3, this.xhW);
            }
            if (this.xhX != null) {
                f += C6091a.m9575f(4, this.xhX);
            }
            if (this.xhY != null) {
                f += C6087a.m9557ix(5, this.xhY.computeSize());
            }
            f = ((f + C6087a.m9552c(6, 8, this.vBz)) + C6091a.m9572bs(7, this.wRi)) + C6091a.m9572bs(8, this.xhZ);
            if (this.xia != null) {
                f += C6087a.m9557ix(9, this.xia.computeSize());
            }
            if (this.xib != null) {
                f += C6087a.m9557ix(10, this.xib.computeSize());
            }
            AppMethodBeat.m2505o(48980);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48980);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cji cji = (cji) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cjh cjh;
            switch (intValue) {
                case 1:
                    cji.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 2:
                    cji.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 3:
                    cji.xhW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 4:
                    cji.xhX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayi ayi = new ayi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.populateBuilderWithField(c6086a3, ayi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cji.xhY = ayi;
                    }
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjg cjg = new cjg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjg.populateBuilderWithField(c6086a3, cjg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cji.vBz.add(cjg);
                    }
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 7:
                    cji.wRi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 8:
                    cji.xhZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjh = new cjh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjh.populateBuilderWithField(c6086a3, cjh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cji.xia = cjh;
                    }
                    AppMethodBeat.m2505o(48980);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjh = new cjh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjh.populateBuilderWithField(c6086a3, cjh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cji.xib = cjh;
                    }
                    AppMethodBeat.m2505o(48980);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48980);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48980);
            return -1;
        }
    }
}
