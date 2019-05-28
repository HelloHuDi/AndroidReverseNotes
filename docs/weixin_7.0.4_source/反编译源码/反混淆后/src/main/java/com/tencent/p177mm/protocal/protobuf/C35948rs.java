package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.rs */
public final class C35948rs extends bsr {
    public int jCt;
    public String vYZ;
    public LinkedList<bzd> vZa = new LinkedList();
    public LinkedList<bzf> vZb = new LinkedList();
    public LinkedList<bzc> vZc = new LinkedList();
    public LinkedList<bzb> vZd = new LinkedList();
    public LinkedList<bze> vZe = new LinkedList();

    public C35948rs() {
        AppMethodBeat.m2504i(28359);
        AppMethodBeat.m2505o(28359);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28360);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.jCt);
            if (this.vYZ != null) {
                c6093a.mo13475e(3, this.vYZ);
            }
            c6093a.mo13474e(4, 8, this.vZa);
            c6093a.mo13474e(5, 8, this.vZb);
            c6093a.mo13474e(6, 8, this.vZc);
            c6093a.mo13474e(7, 8, this.vZd);
            c6093a.mo13474e(8, 8, this.vZe);
            AppMethodBeat.m2505o(28360);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.jCt);
            if (this.vYZ != null) {
                ix += C6091a.m9575f(3, this.vYZ);
            }
            int c = ((((ix + C6087a.m9552c(4, 8, this.vZa)) + C6087a.m9552c(5, 8, this.vZb)) + C6087a.m9552c(6, 8, this.vZc)) + C6087a.m9552c(7, 8, this.vZd)) + C6087a.m9552c(8, 8, this.vZe);
            AppMethodBeat.m2505o(28360);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZa.clear();
            this.vZb.clear();
            this.vZc.clear();
            this.vZd.clear();
            this.vZe.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28360);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35948rs c35948rs = (C35948rs) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35948rs.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 2:
                    c35948rs.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 3:
                    c35948rs.vYZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzd bzd = new bzd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzd.populateBuilderWithField(c6086a3, bzd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35948rs.vZa.add(bzd);
                    }
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzf bzf = new bzf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzf.populateBuilderWithField(c6086a3, bzf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35948rs.vZb.add(bzf);
                    }
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzc bzc = new bzc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzc.populateBuilderWithField(c6086a3, bzc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35948rs.vZc.add(bzc);
                    }
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzb bzb = new bzb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzb.populateBuilderWithField(c6086a3, bzb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35948rs.vZd.add(bzb);
                    }
                    AppMethodBeat.m2505o(28360);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bze bze = new bze();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bze.populateBuilderWithField(c6086a3, bze, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35948rs.vZe.add(bze);
                    }
                    AppMethodBeat.m2505o(28360);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28360);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28360);
            return -1;
        }
    }
}
