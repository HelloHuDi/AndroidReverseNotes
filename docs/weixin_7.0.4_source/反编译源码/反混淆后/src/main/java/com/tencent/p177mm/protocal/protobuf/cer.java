package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cer */
public final class cer extends C1331a {
    public String jBB;
    public String jCH;
    public int pcX;
    public long vQE;
    public int wGu;
    public int xar;
    public int xek;
    public int xem;
    public SKBuiltinBuffer_t xen;
    public LinkedList<cdv> xeo = new LinkedList();
    public int xep;
    public LinkedList<cdv> xeq = new LinkedList();
    public int xer;
    public int xes;

    public cer() {
        AppMethodBeat.m2504i(56534);
        AppMethodBeat.m2505o(56534);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56535);
        C6092b c6092b;
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xen == null) {
                c6092b = new C6092b("Not all required fields were included: ObjDesc");
                AppMethodBeat.m2505o(56535);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vQE);
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(3, this.jCH);
            }
            c6093a.mo13480iz(4, this.pcX);
            c6093a.mo13480iz(5, this.xem);
            if (this.xen != null) {
                c6093a.mo13479iy(6, this.xen.computeSize());
                this.xen.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.xar);
            c6093a.mo13474e(8, 8, this.xeo);
            c6093a.mo13480iz(9, this.xep);
            c6093a.mo13474e(10, 8, this.xeq);
            c6093a.mo13480iz(11, this.wGu);
            c6093a.mo13480iz(12, this.xer);
            c6093a.mo13480iz(13, this.xek);
            c6093a.mo13480iz(14, this.xes);
            AppMethodBeat.m2505o(56535);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vQE) + 0;
            if (this.jBB != null) {
                o += C6091a.m9575f(2, this.jBB);
            }
            if (this.jCH != null) {
                o += C6091a.m9575f(3, this.jCH);
            }
            o = (o + C6091a.m9572bs(4, this.pcX)) + C6091a.m9572bs(5, this.xem);
            if (this.xen != null) {
                o += C6087a.m9557ix(6, this.xen.computeSize());
            }
            o = (((((((o + C6091a.m9572bs(7, this.xar)) + C6087a.m9552c(8, 8, this.xeo)) + C6091a.m9572bs(9, this.xep)) + C6087a.m9552c(10, 8, this.xeq)) + C6091a.m9572bs(11, this.wGu)) + C6091a.m9572bs(12, this.xer)) + C6091a.m9572bs(13, this.xek)) + C6091a.m9572bs(14, this.xes);
            AppMethodBeat.m2505o(56535);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeo.clear();
            this.xeq.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.xen == null) {
                c6092b = new C6092b("Not all required fields were included: ObjDesc");
                AppMethodBeat.m2505o(56535);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56535);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cer cer = (cer) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cdv cdv;
            switch (intValue) {
                case 1:
                    cer.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 2:
                    cer.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 3:
                    cer.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 4:
                    cer.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 5:
                    cer.xem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
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
                        cer.xen = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 7:
                    cer.xar = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdv = new cdv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdv.populateBuilderWithField(c6086a3, cdv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cer.xeo.add(cdv);
                    }
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 9:
                    cer.xep = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdv = new cdv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdv.populateBuilderWithField(c6086a3, cdv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cer.xeq.add(cdv);
                    }
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 11:
                    cer.wGu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 12:
                    cer.xer = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 13:
                    cer.xek = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                case 14:
                    cer.xes = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56535);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56535);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56535);
            return -1;
        }
    }
}
