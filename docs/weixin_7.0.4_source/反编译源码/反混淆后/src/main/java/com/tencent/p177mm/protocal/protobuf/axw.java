package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axw */
public final class axw extends C1331a {
    public String Title;
    public int jCt;
    public String oQU;
    public float oQV;
    public int oQW;
    public LinkedList<Integer> oQX = new LinkedList();
    public int oQY;
    public LinkedList<bts> oQZ = new LinkedList();
    public float oRa;
    public String oRb;
    public SKBuiltinBuffer_t oRc;
    public String wCb;
    public SKBuiltinBuffer_t wCc;
    public int wCd;
    public int wCe;

    public axw() {
        AppMethodBeat.m2504i(70484);
        AppMethodBeat.m2505o(70484);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(70485);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.oQU != null) {
                c6093a.mo13475e(1, this.oQU);
            }
            if (this.Title != null) {
                c6093a.mo13475e(2, this.Title);
            }
            c6093a.mo13481r(3, this.oQV);
            c6093a.mo13480iz(4, this.oQW);
            c6093a.mo13477f(5, 2, this.oQX);
            c6093a.mo13480iz(6, this.oQY);
            c6093a.mo13474e(7, 8, this.oQZ);
            c6093a.mo13481r(8, this.oRa);
            if (this.oRb != null) {
                c6093a.mo13475e(9, this.oRb);
            }
            c6093a.mo13480iz(10, this.jCt);
            if (this.oRc != null) {
                c6093a.mo13479iy(11, this.oRc.computeSize());
                this.oRc.writeFields(c6093a);
            }
            if (this.wCb != null) {
                c6093a.mo13475e(12, this.wCb);
            }
            if (this.wCc != null) {
                c6093a.mo13479iy(13, this.wCc.computeSize());
                this.wCc.writeFields(c6093a);
            }
            c6093a.mo13480iz(14, this.wCd);
            c6093a.mo13480iz(15, this.wCe);
            AppMethodBeat.m2505o(70485);
            return 0;
        } else if (i == 1) {
            if (this.oQU != null) {
                f = C6091a.m9575f(1, this.oQU) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += C6091a.m9575f(2, this.Title);
            }
            f = (((((f + (C6091a.m9576fv(3) + 4)) + C6091a.m9572bs(4, this.oQW)) + C6087a.m9553d(5, 2, this.oQX)) + C6091a.m9572bs(6, this.oQY)) + C6087a.m9552c(7, 8, this.oQZ)) + (C6091a.m9576fv(8) + 4);
            if (this.oRb != null) {
                f += C6091a.m9575f(9, this.oRb);
            }
            f += C6091a.m9572bs(10, this.jCt);
            if (this.oRc != null) {
                f += C6087a.m9557ix(11, this.oRc.computeSize());
            }
            if (this.wCb != null) {
                f += C6091a.m9575f(12, this.wCb);
            }
            if (this.wCc != null) {
                f += C6087a.m9557ix(13, this.wCc.computeSize());
            }
            int bs = (f + C6091a.m9572bs(14, this.wCd)) + C6091a.m9572bs(15, this.wCe);
            AppMethodBeat.m2505o(70485);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.oQX.clear();
            this.oQZ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(70485);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axw axw = (axw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    axw.oQU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 2:
                    axw.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 3:
                    axw.oQV = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 4:
                    axw.oQW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 5:
                    axw.oQX = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 6:
                    axw.oQY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axw.oQZ.add(bts);
                    }
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 8:
                    axw.oRa = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 9:
                    axw.oRb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 10:
                    axw.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axw.oRc = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 12:
                    axw.wCb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axw.wCc = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 14:
                    axw.wCd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                case 15:
                    axw.wCe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70485);
                    return 0;
                default:
                    AppMethodBeat.m2505o(70485);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(70485);
            return -1;
        }
    }
}
