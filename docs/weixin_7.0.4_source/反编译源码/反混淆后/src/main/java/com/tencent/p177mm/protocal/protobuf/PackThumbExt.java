package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.PackThumbExt */
public class PackThumbExt extends C1331a {
    public String ActivityID;
    public String AesKey;
    public String CDNUrl;
    public String Desc;
    public String EncryptUrl;
    public String ExternMd5;
    public String ExternUrl;
    public String Md5;
    public String PreviewUrl;
    public String ThumbUrl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62577);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.PreviewUrl != null) {
                c6093a.mo13475e(1, this.PreviewUrl);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(2, this.Desc);
            }
            if (this.Md5 != null) {
                c6093a.mo13475e(3, this.Md5);
            }
            if (this.AesKey != null) {
                c6093a.mo13475e(4, this.AesKey);
            }
            if (this.CDNUrl != null) {
                c6093a.mo13475e(5, this.CDNUrl);
            }
            if (this.ThumbUrl != null) {
                c6093a.mo13475e(6, this.ThumbUrl);
            }
            if (this.EncryptUrl != null) {
                c6093a.mo13475e(7, this.EncryptUrl);
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
            AppMethodBeat.m2505o(62577);
            return 0;
        } else if (i == 1) {
            if (this.PreviewUrl != null) {
                f = C6091a.m9575f(1, this.PreviewUrl) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(2, this.Desc);
            }
            if (this.Md5 != null) {
                f += C6091a.m9575f(3, this.Md5);
            }
            if (this.AesKey != null) {
                f += C6091a.m9575f(4, this.AesKey);
            }
            if (this.CDNUrl != null) {
                f += C6091a.m9575f(5, this.CDNUrl);
            }
            if (this.ThumbUrl != null) {
                f += C6091a.m9575f(6, this.ThumbUrl);
            }
            if (this.EncryptUrl != null) {
                f += C6091a.m9575f(7, this.EncryptUrl);
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
            AppMethodBeat.m2505o(62577);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62577);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            PackThumbExt packThumbExt = (PackThumbExt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    packThumbExt.PreviewUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 2:
                    packThumbExt.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 3:
                    packThumbExt.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 4:
                    packThumbExt.AesKey = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 5:
                    packThumbExt.CDNUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 6:
                    packThumbExt.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 7:
                    packThumbExt.EncryptUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 8:
                    packThumbExt.ExternUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 9:
                    packThumbExt.ExternMd5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                case 10:
                    packThumbExt.ActivityID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62577);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62577);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62577);
            return -1;
        }
    }
}
