package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bgf */
public final class bgf extends C1331a {
    public String app_id;
    public int cvd;
    public int dtS;
    public String geZ;
    public String hHV;
    public String nickname;
    public int type;
    public String vEP;
    public String wJW;
    public String wJX;
    public String wKh;
    public String wKj;
    public String wKk;
    public String wKl;
    public String wKm;
    public bgg wKn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80132);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.geZ != null) {
                c6093a.mo13475e(1, this.geZ);
            }
            if (this.nickname != null) {
                c6093a.mo13475e(2, this.nickname);
            }
            c6093a.mo13480iz(3, this.type);
            if (this.hHV != null) {
                c6093a.mo13475e(4, this.hHV);
            }
            if (this.wJW != null) {
                c6093a.mo13475e(5, this.wJW);
            }
            if (this.wJX != null) {
                c6093a.mo13475e(6, this.wJX);
            }
            c6093a.mo13480iz(7, this.cvd);
            if (this.wKj != null) {
                c6093a.mo13475e(8, this.wKj);
            }
            if (this.wKk != null) {
                c6093a.mo13475e(9, this.wKk);
            }
            if (this.wKl != null) {
                c6093a.mo13475e(10, this.wKl);
            }
            if (this.wKm != null) {
                c6093a.mo13475e(11, this.wKm);
            }
            if (this.wKn != null) {
                c6093a.mo13479iy(12, this.wKn.computeSize());
                this.wKn.writeFields(c6093a);
            }
            if (this.vEP != null) {
                c6093a.mo13475e(13, this.vEP);
            }
            if (this.app_id != null) {
                c6093a.mo13475e(14, this.app_id);
            }
            c6093a.mo13480iz(15, this.dtS);
            if (this.wKh != null) {
                c6093a.mo13475e(16, this.wKh);
            }
            AppMethodBeat.m2505o(80132);
            return 0;
        } else if (i == 1) {
            if (this.geZ != null) {
                f = C6091a.m9575f(1, this.geZ) + 0;
            } else {
                f = 0;
            }
            if (this.nickname != null) {
                f += C6091a.m9575f(2, this.nickname);
            }
            f += C6091a.m9572bs(3, this.type);
            if (this.hHV != null) {
                f += C6091a.m9575f(4, this.hHV);
            }
            if (this.wJW != null) {
                f += C6091a.m9575f(5, this.wJW);
            }
            if (this.wJX != null) {
                f += C6091a.m9575f(6, this.wJX);
            }
            f += C6091a.m9572bs(7, this.cvd);
            if (this.wKj != null) {
                f += C6091a.m9575f(8, this.wKj);
            }
            if (this.wKk != null) {
                f += C6091a.m9575f(9, this.wKk);
            }
            if (this.wKl != null) {
                f += C6091a.m9575f(10, this.wKl);
            }
            if (this.wKm != null) {
                f += C6091a.m9575f(11, this.wKm);
            }
            if (this.wKn != null) {
                f += C6087a.m9557ix(12, this.wKn.computeSize());
            }
            if (this.vEP != null) {
                f += C6091a.m9575f(13, this.vEP);
            }
            if (this.app_id != null) {
                f += C6091a.m9575f(14, this.app_id);
            }
            f += C6091a.m9572bs(15, this.dtS);
            if (this.wKh != null) {
                f += C6091a.m9575f(16, this.wKh);
            }
            AppMethodBeat.m2505o(80132);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80132);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bgf bgf = (bgf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgf.geZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 2:
                    bgf.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 3:
                    bgf.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 4:
                    bgf.hHV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 5:
                    bgf.wJW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 6:
                    bgf.wJX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 7:
                    bgf.cvd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 8:
                    bgf.wKj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 9:
                    bgf.wKk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 10:
                    bgf.wKl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 11:
                    bgf.wKm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 12:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bgg bgg = new bgg();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgg.populateBuilderWithField(c6086a3, bgg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bgf.wKn = bgg;
                    }
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 13:
                    bgf.vEP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 14:
                    bgf.app_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 15:
                    bgf.dtS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                case 16:
                    bgf.wKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80132);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80132);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80132);
            return -1;
        }
    }
}
