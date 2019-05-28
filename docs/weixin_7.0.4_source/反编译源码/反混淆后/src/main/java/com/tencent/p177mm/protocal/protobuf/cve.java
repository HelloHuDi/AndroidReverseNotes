package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cve */
public final class cve extends btd {
    public int vOq;
    public String vOy;
    public int wCB;
    public bpy xrg;
    public bpw xrh;
    public int xri;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124381);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wCB);
            c6093a.mo13480iz(3, this.vOq);
            if (this.vOy != null) {
                c6093a.mo13475e(4, this.vOy);
            }
            if (this.xrg != null) {
                c6093a.mo13479iy(5, this.xrg.computeSize());
                this.xrg.writeFields(c6093a);
            }
            if (this.xrh != null) {
                c6093a.mo13479iy(6, this.xrh.computeSize());
                this.xrh.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.xri);
            AppMethodBeat.m2505o(124381);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.wCB)) + C6091a.m9572bs(3, this.vOq);
            if (this.vOy != null) {
                ix += C6091a.m9575f(4, this.vOy);
            }
            if (this.xrg != null) {
                ix += C6087a.m9557ix(5, this.xrg.computeSize());
            }
            if (this.xrh != null) {
                ix += C6087a.m9557ix(6, this.xrh.computeSize());
            }
            int bs = ix + C6091a.m9572bs(7, this.xri);
            AppMethodBeat.m2505o(124381);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124381);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cve cve = (cve) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cve.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(124381);
                    return 0;
                case 2:
                    cve.wCB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124381);
                    return 0;
                case 3:
                    cve.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124381);
                    return 0;
                case 4:
                    cve.vOy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124381);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpy bpy = new bpy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpy.populateBuilderWithField(c6086a3, bpy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cve.xrg = bpy;
                    }
                    AppMethodBeat.m2505o(124381);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpw bpw = new bpw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpw.populateBuilderWithField(c6086a3, bpw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cve.xrh = bpw;
                    }
                    AppMethodBeat.m2505o(124381);
                    return 0;
                case 7:
                    cve.xri = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124381);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124381);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124381);
            return -1;
        }
    }
}
