package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xx */
public final class C40588xx extends C1331a {
    public String ActivityID;
    public String AesKey;
    public String EncryptUrl;
    public String ExternMd5;
    public String ExternUrl;
    public String Md5;
    public String ProductID;
    public String ThumbUrl;
    public String Url;
    public String wdC;
    public String wdD;
    public String wdE;
    public String wdF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62523);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Md5 == null) {
                c6092b = new C6092b("Not all required fields were included: Md5");
                AppMethodBeat.m2505o(62523);
                throw c6092b;
            }
            if (this.Md5 != null) {
                c6093a.mo13475e(1, this.Md5);
            }
            if (this.Url != null) {
                c6093a.mo13475e(2, this.Url);
            }
            if (this.ThumbUrl != null) {
                c6093a.mo13475e(3, this.ThumbUrl);
            }
            if (this.wdC != null) {
                c6093a.mo13475e(4, this.wdC);
            }
            if (this.EncryptUrl != null) {
                c6093a.mo13475e(5, this.EncryptUrl);
            }
            if (this.AesKey != null) {
                c6093a.mo13475e(6, this.AesKey);
            }
            if (this.ProductID != null) {
                c6093a.mo13475e(7, this.ProductID);
            }
            if (this.ExternUrl != null) {
                c6093a.mo13475e(8, this.ExternUrl);
            }
            if (this.ExternMd5 != null) {
                c6093a.mo13475e(9, this.ExternMd5);
            }
            if (this.ActivityID != null) {
                c6093a.mo13475e(10, this.ActivityID);
            }
            if (this.wdD != null) {
                c6093a.mo13475e(11, this.wdD);
            }
            if (this.wdE != null) {
                c6093a.mo13475e(12, this.wdE);
            }
            if (this.wdF != null) {
                c6093a.mo13475e(13, this.wdF);
            }
            AppMethodBeat.m2505o(62523);
            return 0;
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = C6091a.m9575f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            if (this.Url != null) {
                f += C6091a.m9575f(2, this.Url);
            }
            if (this.ThumbUrl != null) {
                f += C6091a.m9575f(3, this.ThumbUrl);
            }
            if (this.wdC != null) {
                f += C6091a.m9575f(4, this.wdC);
            }
            if (this.EncryptUrl != null) {
                f += C6091a.m9575f(5, this.EncryptUrl);
            }
            if (this.AesKey != null) {
                f += C6091a.m9575f(6, this.AesKey);
            }
            if (this.ProductID != null) {
                f += C6091a.m9575f(7, this.ProductID);
            }
            if (this.ExternUrl != null) {
                f += C6091a.m9575f(8, this.ExternUrl);
            }
            if (this.ExternMd5 != null) {
                f += C6091a.m9575f(9, this.ExternMd5);
            }
            if (this.ActivityID != null) {
                f += C6091a.m9575f(10, this.ActivityID);
            }
            if (this.wdD != null) {
                f += C6091a.m9575f(11, this.wdD);
            }
            if (this.wdE != null) {
                f += C6091a.m9575f(12, this.wdE);
            }
            if (this.wdF != null) {
                f += C6091a.m9575f(13, this.wdF);
            }
            AppMethodBeat.m2505o(62523);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Md5 == null) {
                c6092b = new C6092b("Not all required fields were included: Md5");
                AppMethodBeat.m2505o(62523);
                throw c6092b;
            }
            AppMethodBeat.m2505o(62523);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40588xx c40588xx = (C40588xx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40588xx.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 2:
                    c40588xx.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 3:
                    c40588xx.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 4:
                    c40588xx.wdC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 5:
                    c40588xx.EncryptUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 6:
                    c40588xx.AesKey = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 7:
                    c40588xx.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 8:
                    c40588xx.ExternUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 9:
                    c40588xx.ExternMd5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 10:
                    c40588xx.ActivityID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 11:
                    c40588xx.wdD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 12:
                    c40588xx.wdE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                case 13:
                    c40588xx.wdF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62523);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62523);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62523);
            return -1;
        }
    }
}
