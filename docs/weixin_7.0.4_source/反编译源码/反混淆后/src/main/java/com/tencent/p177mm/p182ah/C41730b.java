package com.tencent.p177mm.p182ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C41733e.C25750c;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ah.b */
public final class C41730b {
    /* renamed from: at */
    public static String m73492at(String str, String str2) {
        AppMethodBeat.m2504i(77832);
        String str3 = str + "?access_token=" + str2;
        AppMethodBeat.m2505o(77832);
        return str3;
    }

    /* renamed from: pP */
    public static Bitmap m73497pP(String str) {
        AppMethodBeat.m2504i(77833);
        Bitmap a = C41730b.m73490a(str + "@google", false, -1);
        AppMethodBeat.m2505o(77833);
        return a;
    }

    /* renamed from: pQ */
    private static String m73498pQ(String str) {
        AppMethodBeat.m2504i(77834);
        String str2 = "http://graph.facebook.com/" + str + "/picture";
        AppMethodBeat.m2505o(77834);
        return str2;
    }

    /* renamed from: pR */
    public static void m73499pR(String str) {
        AppMethodBeat.m2504i(77835);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77835);
            return;
        }
        String str2 = str + "@fb";
        C17880h qo = C17884o.act().mo33392qo(str2);
        if (qo != null && str2.equals(qo.getUsername()) && 3 == qo.dtR) {
            AppMethodBeat.m2505o(77835);
            return;
        }
        if (qo == null) {
            qo = new C17880h();
        }
        qo.username = str2;
        qo.dtR = 3;
        qo.frW = C41730b.m73498pQ(str);
        qo.frV = C41730b.m73498pQ(str);
        qo.mo33385cB(true);
        qo.bJt = 31;
        C17884o.act().mo33391b(qo);
        AppMethodBeat.m2505o(77835);
    }

    /* renamed from: pS */
    public static Bitmap m73500pS(String str) {
        AppMethodBeat.m2504i(77836);
        Bitmap a = C41730b.m73490a(str + "@fb", false, -1);
        AppMethodBeat.m2505o(77836);
        return a;
    }

    /* renamed from: pT */
    public static long m73501pT(String str) {
        long j = -1;
        AppMethodBeat.m2504i(77837);
        if (C7616ad.aoz(str)) {
            try {
                j = C5046bo.getLong(str.split("@")[0], -1);
                AppMethodBeat.m2505o(77837);
            } catch (Exception e) {
                AppMethodBeat.m2505o(77837);
            }
        } else {
            AppMethodBeat.m2505o(77837);
        }
        return j;
    }

    /* renamed from: fq */
    private static String m73495fq(long j) {
        AppMethodBeat.m2504i(77838);
        String str = new C1183p(j) + "@qqim";
        AppMethodBeat.m2505o(77838);
        return str;
    }

    /* renamed from: pU */
    public static long m73502pU(String str) {
        long j = -1;
        AppMethodBeat.m2504i(77839);
        if (C7616ad.aow(str)) {
            try {
                j = C5046bo.getLong(str.split("@")[0], -1);
                AppMethodBeat.m2505o(77839);
            } catch (Exception e) {
                AppMethodBeat.m2505o(77839);
            }
        } else {
            AppMethodBeat.m2505o(77839);
        }
        return j;
    }

    /* renamed from: d */
    public static boolean m73494d(long j, int i) {
        AppMethodBeat.m2504i(77840);
        if (i != 3) {
            AppMethodBeat.m2505o(77840);
            return false;
        }
        boolean pV = C41730b.m73503pV(C41730b.m73495fq(j));
        AppMethodBeat.m2505o(77840);
        return pV;
    }

    /* renamed from: pV */
    public static boolean m73503pV(String str) {
        AppMethodBeat.m2504i(77841);
        if (str == null) {
            C4990ab.m7420w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            AppMethodBeat.m2505o(77841);
            return false;
        } else if (str.endsWith("@qqim")) {
            C17880h c17880h = new C17880h();
            c17880h.username = str;
            c17880h.dtR = 3;
            c17880h.bJt = 3;
            boolean b = C17884o.act().mo33391b(c17880h);
            AppMethodBeat.m2505o(77841);
            return b;
        } else {
            C4990ab.m7420w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            AppMethodBeat.m2505o(77841);
            return false;
        }
    }

    /* renamed from: fr */
    public static Bitmap m73496fr(long j) {
        AppMethodBeat.m2504i(77842);
        Bitmap a = C41730b.m73490a(C41730b.m73495fq(j), false, -1);
        AppMethodBeat.m2505o(77842);
        return a;
    }

    /* renamed from: U */
    public static boolean m73489U(String str, int i) {
        AppMethodBeat.m2504i(77843);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77843);
            return false;
        }
        C17880h qo = C17884o.act().mo33392qo(str);
        if (qo != null && str.equals(qo.getUsername()) && i == qo.dtR) {
            AppMethodBeat.m2505o(77843);
            return true;
        }
        if (qo == null) {
            qo = new C17880h();
        }
        qo.username = str;
        qo.dtR = i;
        qo.bJt = 3;
        boolean b = C17884o.act().mo33391b(qo);
        AppMethodBeat.m2505o(77843);
        return b;
    }

    /* renamed from: pW */
    public static Bitmap m73504pW(String str) {
        AppMethodBeat.m2504i(139131);
        Bitmap a = C41730b.m73490a(str, false, -1);
        AppMethodBeat.m2505o(139131);
        return a;
    }

    /* renamed from: d */
    public static Bitmap m73493d(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(77845);
        if (C5046bo.isNullOrNil(str) || !C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(77845);
            return null;
        }
        C17884o.acd();
        Bitmap j = C41732d.m73521j(str, i, i2);
        if (j == null) {
            final C41733e c41733e = new C41733e();
            c41733e.mo67507a(str, new C25750c() {
                /* renamed from: cr */
                public final int mo4442cr(int i, int i2) {
                    AppMethodBeat.m2504i(77831);
                    c41733e.ach();
                    C4990ab.m7417i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.m2505o(77831);
                    return 0;
                }
            });
            j = C41730b.m73490a(str, false, i3);
            AppMethodBeat.m2505o(77845);
            return j;
        }
        if (i3 > 5) {
            j = C5056d.m7616a(j, false, (float) i3);
        }
        AppMethodBeat.m2505o(77845);
        return j;
    }

    /* renamed from: a */
    public static Bitmap m73490a(String str, boolean z, int i) {
        AppMethodBeat.m2504i(77846);
        Bitmap b;
        if (C5046bo.isNullOrNil(str) || !C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(77846);
            return null;
        } else if (C1720g.m3536RP().mo5229RB()) {
            if (C7616ad.m13548mR(str)) {
                str = C7616ad.aoC(str);
            }
            b = C17884o.acv().mo67493b(str, z, i);
            AppMethodBeat.m2505o(77846);
            return b;
        } else {
            b = C17884o.acd().mo67501bU(C4996ah.getContext());
            AppMethodBeat.m2505o(77846);
            return b;
        }
    }

    /* renamed from: pX */
    public static String m73505pX(String str) {
        AppMethodBeat.m2504i(77847);
        String C;
        if (C5046bo.isNullOrNil(str) || !C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(77847);
            return null;
        } else if (!C1720g.m3536RP().mo5229RB()) {
            AppMethodBeat.m2505o(77847);
            return null;
        } else if (C7616ad.m13548mR(str)) {
            C17884o.acd();
            C = C41732d.m73514C(C7616ad.aoC(str), false);
            AppMethodBeat.m2505o(77847);
            return C;
        } else {
            C17884o.acd();
            C = C41732d.m73514C(str, false);
            AppMethodBeat.m2505o(77847);
            return C;
        }
    }

    /* renamed from: pY */
    public static void m73506pY(String str) {
        AppMethodBeat.m2504i(77848);
        C17880h qo = C17884o.act().mo33392qo(str);
        if (qo == null) {
            AppMethodBeat.m2505o(77848);
        } else if (str.equals(qo.getUsername())) {
            qo.frY = 0;
            qo.bJt = 64;
            C17884o.act().mo33391b(qo);
            AppMethodBeat.m2505o(77848);
        } else {
            AppMethodBeat.m2505o(77848);
        }
    }

    /* renamed from: a */
    public static C17880h m73491a(String str, bbv bbv) {
        AppMethodBeat.m2504i(77849);
        C17880h c17880h = new C17880h();
        c17880h.bJt = -1;
        c17880h.username = str;
        c17880h.frV = bbv.vXn;
        c17880h.frW = bbv.vXm;
        C4990ab.m7417i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
        c17880h.mo33385cB(bbv.wGg != 0);
        if (bbv.wGb == 3 || bbv.wGb == 4) {
            c17880h.dtR = bbv.wGb;
        } else if (bbv.wGb == 2) {
            c17880h.dtR = 3;
            if (!C1853r.m3846Yz().equals(str)) {
                C17884o.acd();
                C41732d.m73516E(str, false);
                C17884o.acd();
                C41732d.m73516E(str, true);
                C17884o.act().mo33391b(c17880h);
                C17884o.acv().mo67495pZ(str);
            }
        }
        AppMethodBeat.m2505o(77849);
        return c17880h;
    }
}
