package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ado */
public final class ado extends bsr {
    public int OpCode;
    public int Scene;
    public String jBB;
    public int vEq;
    public int vGB;
    public SKBuiltinBuffer_t vHP;
    public int vIw;
    public String vKt;
    public int vXI;
    public int vXJ;
    public bts wlk;
    public bts wll;
    public bts wlm;
    public bts wln;
    public String wlo;
    public int wlp;
    public String wlq;
    public SKBuiltinBuffer_t wlr;
    public int wls;
    public int wlt;
    public String wlu;
    public int wlv;
    public SKBuiltinBuffer_t wlw;
    public String wlx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80054);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.OpCode);
            if (this.vHP != null) {
                c6093a.mo13479iy(3, this.vHP.computeSize());
                this.vHP.writeFields(c6093a);
            }
            if (this.wlk != null) {
                c6093a.mo13479iy(4, this.wlk.computeSize());
                this.wlk.writeFields(c6093a);
            }
            if (this.wll != null) {
                c6093a.mo13479iy(5, this.wll.computeSize());
                this.wll.writeFields(c6093a);
            }
            if (this.wlm != null) {
                c6093a.mo13479iy(6, this.wlm.computeSize());
                this.wlm.writeFields(c6093a);
            }
            if (this.wln != null) {
                c6093a.mo13479iy(7, this.wln.computeSize());
                this.wln.writeFields(c6093a);
            }
            if (this.wlo != null) {
                c6093a.mo13475e(8, this.wlo);
            }
            c6093a.mo13480iz(9, this.wlp);
            c6093a.mo13480iz(10, this.Scene);
            if (this.jBB != null) {
                c6093a.mo13475e(11, this.jBB);
            }
            if (this.wlq != null) {
                c6093a.mo13475e(12, this.wlq);
            }
            if (this.wlr != null) {
                c6093a.mo13479iy(13, this.wlr.computeSize());
                this.wlr.writeFields(c6093a);
            }
            c6093a.mo13480iz(14, this.vIw);
            c6093a.mo13480iz(15, this.wls);
            c6093a.mo13480iz(16, this.vEq);
            if (this.vKt != null) {
                c6093a.mo13475e(17, this.vKt);
            }
            c6093a.mo13480iz(18, this.vXI);
            c6093a.mo13480iz(19, this.vXJ);
            c6093a.mo13480iz(20, this.wlt);
            if (this.wlu != null) {
                c6093a.mo13475e(21, this.wlu);
            }
            c6093a.mo13480iz(22, this.wlv);
            if (this.wlw != null) {
                c6093a.mo13479iy(23, this.wlw.computeSize());
                this.wlw.writeFields(c6093a);
            }
            if (this.wlx != null) {
                c6093a.mo13475e(24, this.wlx);
            }
            c6093a.mo13480iz(25, this.vGB);
            AppMethodBeat.m2505o(80054);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.OpCode);
            if (this.vHP != null) {
                ix += C6087a.m9557ix(3, this.vHP.computeSize());
            }
            if (this.wlk != null) {
                ix += C6087a.m9557ix(4, this.wlk.computeSize());
            }
            if (this.wll != null) {
                ix += C6087a.m9557ix(5, this.wll.computeSize());
            }
            if (this.wlm != null) {
                ix += C6087a.m9557ix(6, this.wlm.computeSize());
            }
            if (this.wln != null) {
                ix += C6087a.m9557ix(7, this.wln.computeSize());
            }
            if (this.wlo != null) {
                ix += C6091a.m9575f(8, this.wlo);
            }
            ix = (ix + C6091a.m9572bs(9, this.wlp)) + C6091a.m9572bs(10, this.Scene);
            if (this.jBB != null) {
                ix += C6091a.m9575f(11, this.jBB);
            }
            if (this.wlq != null) {
                ix += C6091a.m9575f(12, this.wlq);
            }
            if (this.wlr != null) {
                ix += C6087a.m9557ix(13, this.wlr.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(14, this.vIw)) + C6091a.m9572bs(15, this.wls)) + C6091a.m9572bs(16, this.vEq);
            if (this.vKt != null) {
                ix += C6091a.m9575f(17, this.vKt);
            }
            ix = ((ix + C6091a.m9572bs(18, this.vXI)) + C6091a.m9572bs(19, this.vXJ)) + C6091a.m9572bs(20, this.wlt);
            if (this.wlu != null) {
                ix += C6091a.m9575f(21, this.wlu);
            }
            ix += C6091a.m9572bs(22, this.wlv);
            if (this.wlw != null) {
                ix += C6087a.m9557ix(23, this.wlw.computeSize());
            }
            if (this.wlx != null) {
                ix += C6091a.m9575f(24, this.wlx);
            }
            int bs = ix + C6091a.m9572bs(25, this.vGB);
            AppMethodBeat.m2505o(80054);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80054);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ado ado = (ado) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            bts bts;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 2:
                    ado.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.wlk = bts;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.wll = bts;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.wlm = bts;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.wln = bts;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 8:
                    ado.wlo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 9:
                    ado.wlp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 10:
                    ado.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 11:
                    ado.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 12:
                    ado.wlq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80054);
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
                        ado.wlr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 14:
                    ado.vIw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 15:
                    ado.wls = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 16:
                    ado.vEq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 17:
                    ado.vKt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 18:
                    ado.vXI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 19:
                    ado.vXJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 20:
                    ado.wlt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 21:
                    ado.wlu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 22:
                    ado.wlv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ado.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 24:
                    ado.wlx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                case 25:
                    ado.vGB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80054);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80054);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80054);
            return -1;
        }
    }
}
