package com.tencent.p177mm.plugin.sns.p517i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.i.c */
public final class C39737c {
    private static Map<String, C34938a> qSP = new ConcurrentHashMap();
    private static volatile long qSQ = 0;

    /* renamed from: com.tencent.mm.plugin.sns.i.c$b */
    static class C21899b {
        int mHeight;
        String mMimeType;
        int mWidth;
        String qSR;
        int qST;
        long qSU;

        private C21899b() {
            this.qSR = "";
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.qST = -1;
            this.qSU = -1;
        }

        /* synthetic */ C21899b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.i.c$a */
    static class C34938a {
        int mHeight;
        String mMimeType;
        int mWidth;
        String qSR;
        int qSS;
        int qST;
        long qSU;
        long qSV;
        long qSW;

        private C34938a() {
            this.qSR = "";
            this.qSS = 0;
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.qST = -1;
            this.qSU = -1;
            this.qSV = -1;
            this.qSW = -1;
        }

        /* synthetic */ C34938a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(36872);
        AppMethodBeat.m2505o(36872);
    }

    private static void coD() {
        AppMethodBeat.m2504i(36867);
        synchronized (qSP) {
            try {
                if (C5046bo.m7525az(qSQ) <= 120000) {
                } else {
                    qSQ = C5046bo.m7588yz();
                    qSP.clear();
                    AppMethodBeat.m2505o(36867);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36867);
            }
        }
    }

    /* renamed from: YG */
    private static String m67952YG(String str) {
        AppMethodBeat.m2504i(36868);
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 1);
            AppMethodBeat.m2505o(36868);
            return str;
        }
        AppMethodBeat.m2505o(36868);
        return str;
    }

    /* renamed from: a */
    public static void m67953a(String str, String str2, int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(36869);
        try {
            C21899b c21899b = new C21899b();
            c21899b.qSR = C39737c.m67952YG(str);
            c21899b.mMimeType = str2;
            c21899b.mWidth = i;
            c21899b.mHeight = i2;
            c21899b.qST = i3;
            c21899b.qSU = j;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append(c21899b.qSR).append(',').append(c21899b.mMimeType).append(',').append(c21899b.mWidth).append(',').append(c21899b.mHeight).append(',').append(c21899b.qST).append(',').append(c21899b.qSU);
            String stringBuilder2 = stringBuilder.toString();
            C4990ab.m7416i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(stringBuilder2)));
            C7060h.pYm.mo8374X(13512, stringBuilder2);
            AppMethodBeat.m2505o(36869);
        } catch (Exception e) {
            AppMethodBeat.m2505o(36869);
        }
    }

    /* renamed from: a */
    public static void m67954a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        AppMethodBeat.m2504i(36870);
        try {
            C34938a c34938a = new C34938a();
            c34938a.qSR = C39737c.m67952YG(str2);
            c34938a.qSS = i;
            c34938a.mMimeType = str3;
            c34938a.mWidth = i2;
            c34938a.mHeight = i3;
            c34938a.qST = i4;
            c34938a.qSU = j;
            c34938a.qSV = j2;
            qSP.put(str, c34938a);
            AppMethodBeat.m2505o(36870);
        } catch (Exception e) {
            AppMethodBeat.m2505o(36870);
        }
    }

    /* renamed from: an */
    public static void m67955an(String str, long j) {
        AppMethodBeat.m2504i(36871);
        try {
            C34938a c34938a = (C34938a) qSP.remove(str);
            if (c34938a != null) {
                c34938a.qSW = j;
                StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                stringBuilder.append(c34938a.qSR).append(',').append(c34938a.qSS).append(',').append(c34938a.mMimeType).append(',').append(c34938a.mWidth).append(',').append(c34938a.mHeight).append(',').append(c34938a.qST).append(',').append(c34938a.qSU).append(',').append(c34938a.qSV).append(',').append(c34938a.qSW);
                String stringBuilder2 = stringBuilder.toString();
                C4990ab.m7416i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(stringBuilder2)));
                C7060h.pYm.mo8374X(13513, stringBuilder2);
                C39737c.coD();
                AppMethodBeat.m2505o(36871);
            }
        } catch (Exception e) {
        } finally {
            C39737c.coD();
            AppMethodBeat.m2505o(36871);
        }
    }
}
