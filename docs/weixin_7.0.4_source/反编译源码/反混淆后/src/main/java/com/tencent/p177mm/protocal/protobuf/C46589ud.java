package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ud */
public final class C46589ud extends C1331a {
    public int guN;
    public String guS;
    public String jBB;
    public String jCH;
    public String ndT;
    public SKBuiltinBuffer_t vEF;
    public int wbA;
    public int wbB;
    public LinkedList<btp> wbC = new LinkedList();
    public String wbD;
    public int wbE;
    public int wbF;
    public int wbG;
    public int wbH;
    public String wbs;
    public String wbt;
    public int wbu;
    public int wbv;
    public String wbw;
    public int wbx;
    public String wby;
    public String wbz;

    public C46589ud() {
        AppMethodBeat.m2504i(28370);
        AppMethodBeat.m2505o(28370);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28371);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(28371);
                throw c6092b;
            }
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
            if (this.vEF != null) {
                c6093a.mo13479iy(6, this.vEF.computeSize());
                this.vEF.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.wbu);
            c6093a.mo13480iz(8, this.wbv);
            if (this.wbw != null) {
                c6093a.mo13475e(9, this.wbw);
            }
            c6093a.mo13480iz(10, this.wbx);
            if (this.wby != null) {
                c6093a.mo13475e(11, this.wby);
            }
            if (this.wbz != null) {
                c6093a.mo13475e(12, this.wbz);
            }
            c6093a.mo13480iz(13, this.wbA);
            c6093a.mo13480iz(14, this.wbB);
            c6093a.mo13474e(15, 8, this.wbC);
            if (this.wbD != null) {
                c6093a.mo13475e(16, this.wbD);
            }
            c6093a.mo13480iz(17, this.wbE);
            c6093a.mo13480iz(18, this.wbF);
            if (this.ndT != null) {
                c6093a.mo13475e(19, this.ndT);
            }
            c6093a.mo13480iz(20, this.wbG);
            c6093a.mo13480iz(21, this.wbH);
            if (this.guS != null) {
                c6093a.mo13475e(22, this.guS);
            }
            AppMethodBeat.m2505o(28371);
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
            if (this.vEF != null) {
                f += C6087a.m9557ix(6, this.vEF.computeSize());
            }
            f = (f + C6091a.m9572bs(7, this.wbu)) + C6091a.m9572bs(8, this.wbv);
            if (this.wbw != null) {
                f += C6091a.m9575f(9, this.wbw);
            }
            f += C6091a.m9572bs(10, this.wbx);
            if (this.wby != null) {
                f += C6091a.m9575f(11, this.wby);
            }
            if (this.wbz != null) {
                f += C6091a.m9575f(12, this.wbz);
            }
            f = ((f + C6091a.m9572bs(13, this.wbA)) + C6091a.m9572bs(14, this.wbB)) + C6087a.m9552c(15, 8, this.wbC);
            if (this.wbD != null) {
                f += C6091a.m9575f(16, this.wbD);
            }
            f = (f + C6091a.m9572bs(17, this.wbE)) + C6091a.m9572bs(18, this.wbF);
            if (this.ndT != null) {
                f += C6091a.m9575f(19, this.ndT);
            }
            f = (f + C6091a.m9572bs(20, this.wbG)) + C6091a.m9572bs(21, this.wbH);
            if (this.guS != null) {
                f += C6091a.m9575f(22, this.guS);
            }
            AppMethodBeat.m2505o(28371);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(28371);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28371);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46589ud c46589ud = (C46589ud) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c46589ud.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 2:
                    c46589ud.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 3:
                    c46589ud.wbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 4:
                    c46589ud.wbt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 5:
                    c46589ud.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46589ud.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 7:
                    c46589ud.wbu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 8:
                    c46589ud.wbv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 9:
                    c46589ud.wbw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 10:
                    c46589ud.wbx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 11:
                    c46589ud.wby = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 12:
                    c46589ud.wbz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 13:
                    c46589ud.wbA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 14:
                    c46589ud.wbB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btp btp = new btp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btp.populateBuilderWithField(c6086a3, btp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46589ud.wbC.add(btp);
                    }
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 16:
                    c46589ud.wbD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 17:
                    c46589ud.wbE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 18:
                    c46589ud.wbF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 19:
                    c46589ud.ndT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 20:
                    c46589ud.wbG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 21:
                    c46589ud.wbH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                case 22:
                    c46589ud.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28371);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28371);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28371);
            return -1;
        }
    }
}
