package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bvk */
public final class bvk extends C1331a {
    public String fKh;
    public int guN;
    public String jBB;
    public String jCH;
    public String vXm;
    public String vXn;
    public int wWh;
    public bgg wWy;
    public String wbs;
    public String wbt;
    public String wlF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80179);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            if (this.wbs != null) {
                c6093a.mo13475e(3, this.wbs);
            }
            if (this.wbt != null) {
                c6093a.mo13475e(4, this.wbt);
            }
            c6093a.mo13480iz(5, this.guN);
            if (this.vXm != null) {
                c6093a.mo13475e(6, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(7, this.vXn);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(8, this.fKh);
            }
            c6093a.mo13480iz(9, this.wWh);
            if (this.wWy != null) {
                c6093a.mo13479iy(10, this.wWy.computeSize());
                this.wWy.writeFields(c6093a);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(11, this.wlF);
            }
            AppMethodBeat.m2505o(80179);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(2, this.jCH);
            }
            if (this.wbs != null) {
                f += C6091a.m9575f(3, this.wbs);
            }
            if (this.wbt != null) {
                f += C6091a.m9575f(4, this.wbt);
            }
            f += C6091a.m9572bs(5, this.guN);
            if (this.vXm != null) {
                f += C6091a.m9575f(6, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(7, this.vXn);
            }
            if (this.fKh != null) {
                f += C6091a.m9575f(8, this.fKh);
            }
            f += C6091a.m9572bs(9, this.wWh);
            if (this.wWy != null) {
                f += C6087a.m9557ix(10, this.wWy.computeSize());
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(11, this.wlF);
            }
            AppMethodBeat.m2505o(80179);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80179);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bvk bvk = (bvk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bvk.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 2:
                    bvk.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 3:
                    bvk.wbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 4:
                    bvk.wbt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 5:
                    bvk.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 6:
                    bvk.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 7:
                    bvk.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 8:
                    bvk.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 9:
                    bvk.wWh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 10:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bgg bgg = new bgg();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgg.populateBuilderWithField(c6086a3, bgg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bvk.wWy = bgg;
                    }
                    AppMethodBeat.m2505o(80179);
                    return 0;
                case 11:
                    bvk.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80179);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80179);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80179);
            return -1;
        }
    }
}
