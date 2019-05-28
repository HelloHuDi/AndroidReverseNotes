package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aay */
public final class aay extends C1331a {
    public int cED;
    public String cIK;
    public String label;
    public double lat;
    public double lng;
    public boolean wih = false;
    public boolean wii = false;
    public boolean wij = false;
    public boolean wik = false;
    public boolean wil = false;

    /* renamed from: D */
    public final aay mo15620D(double d) {
        this.lng = d;
        this.wih = true;
        return this;
    }

    /* renamed from: E */
    public final aay mo15621E(double d) {
        this.lat = d;
        this.wii = true;
        return this;
    }

    /* renamed from: LJ */
    public final aay mo15622LJ(int i) {
        this.cED = i;
        this.wij = true;
        return this;
    }

    public final aay alu(String str) {
        this.label = str;
        this.wik = true;
        return this;
    }

    public final aay alv(String str) {
        this.cIK = str;
        this.wil = true;
        return this;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51399);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wih) {
                c6093a.mo13476f(1, this.lng);
            }
            if (this.wii) {
                c6093a.mo13476f(2, this.lat);
            }
            if (this.wij) {
                c6093a.mo13480iz(3, this.cED);
            }
            if (this.label != null) {
                c6093a.mo13475e(4, this.label);
            }
            if (this.cIK != null) {
                c6093a.mo13475e(5, this.cIK);
            }
            AppMethodBeat.m2505o(51399);
            return 0;
        } else if (i == 1) {
            if (this.wih) {
                fv = (C6091a.m9576fv(1) + 8) + 0;
            } else {
                fv = 0;
            }
            if (this.wii) {
                fv += C6091a.m9576fv(2) + 8;
            }
            if (this.wij) {
                fv += C6091a.m9572bs(3, this.cED);
            }
            if (this.label != null) {
                fv += C6091a.m9575f(4, this.label);
            }
            if (this.cIK != null) {
                fv += C6091a.m9575f(5, this.cIK);
            }
            AppMethodBeat.m2505o(51399);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51399);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aay aay = (aay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aay.lng = Double.longBitsToDouble(c6086a2.BTU.eib());
                    aay.wih = true;
                    AppMethodBeat.m2505o(51399);
                    return 0;
                case 2:
                    aay.lat = Double.longBitsToDouble(c6086a2.BTU.eib());
                    aay.wii = true;
                    AppMethodBeat.m2505o(51399);
                    return 0;
                case 3:
                    aay.cED = c6086a2.BTU.mo13458vd();
                    aay.wij = true;
                    AppMethodBeat.m2505o(51399);
                    return 0;
                case 4:
                    aay.label = c6086a2.BTU.readString();
                    aay.wik = true;
                    AppMethodBeat.m2505o(51399);
                    return 0;
                case 5:
                    aay.cIK = c6086a2.BTU.readString();
                    aay.wil = true;
                    AppMethodBeat.m2505o(51399);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51399);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51399);
            return -1;
        }
    }
}
