package com.tencent.p177mm.p184aj;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.C44137km;
import com.tencent.p177mm.protocal.protobuf.C7264hf;
import com.tencent.p177mm.protocal.protobuf.afu;
import com.tencent.p177mm.protocal.protobuf.bxq;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.aj.c */
public final class C8927c extends C7563j<C36692b> implements C1202f {
    public static final String[] fnj = new String[]{C7563j.m13217a(C36692b.ccO, "BizEnterprise")};
    public static C7264hf fuK;
    private C4927e bSd;
    private final C4934l<C8929a, C8930a> fuL = new C89281();

    /* renamed from: com.tencent.mm.aj.c$1 */
    class C89281 extends C4934l<C8929a, C8930a> {
        C89281() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(11250);
            ((C8929a) obj).mo20352a((C8930a) obj2);
            AppMethodBeat.m2505o(11250);
        }
    }

    /* renamed from: com.tencent.mm.aj.c$a */
    public interface C8929a {

        /* renamed from: com.tencent.mm.aj.c$a$a */
        public static class C8930a {
            public C8931b fuN;
            public String fuO;
            public C36692b fuP;
        }

        /* renamed from: com.tencent.mm.aj.c$a$b */
        public enum C8931b {
            INSERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(11253);
            }
        }

        /* renamed from: a */
        void mo20352a(C8930a c8930a);
    }

    static {
        AppMethodBeat.m2504i(11270);
        AppMethodBeat.m2505o(11270);
    }

    public C8927c(C4927e c4927e) {
        super(c4927e, C36692b.ccO, "BizEnterprise", null);
        AppMethodBeat.m2504i(11254);
        this.bSd = c4927e;
        c4927e.mo10108hY("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        C1720g.m3535RO().eJo.mo14539a(1343, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1228, (C1202f) this);
        AppMethodBeat.m2505o(11254);
    }

    /* renamed from: a */
    public final void mo20345a(C8929a c8929a, Looper looper) {
        AppMethodBeat.m2504i(11255);
        this.fuL.mo10125a(c8929a, looper);
        AppMethodBeat.m2505o(11255);
    }

    /* renamed from: a */
    public final void mo20344a(C8929a c8929a) {
        AppMethodBeat.m2504i(11256);
        if (this.fuL != null) {
            this.fuL.remove(c8929a);
        }
        AppMethodBeat.m2505o(11256);
    }

    /* renamed from: qC */
    public final C36692b mo20347qC(String str) {
        AppMethodBeat.m2504i(11257);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11257);
            return null;
        }
        C4925c c36692b = new C36692b();
        c36692b.field_userName = str;
        if (super.mo10102b(c36692b, new String[0])) {
            AppMethodBeat.m2505o(11257);
            return c36692b;
        }
        C8927c.m16090a(str, null);
        AppMethodBeat.m2505o(11257);
        return null;
    }

    /* renamed from: qD */
    public final C36692b mo20348qD(String str) {
        AppMethodBeat.m2504i(11258);
        C36692b qC = mo20347qC(str);
        if (qC == null) {
            qC = new C36692b();
            qC.field_userName = str;
            qC.field_qyUin = 0;
            qC.field_userUin = 0;
            qC.field_userFlag = 0;
            qC.field_wwExposeTimes = 0;
            qC.field_wwMaxExposeTimes = 0;
            qC.field_wwUserVid = 0;
            qC.field_wwCorpId = 0;
            qC.field_chatOpen = false;
            qC.field_wwUnreadCnt = 0;
            AppMethodBeat.m2505o(11258);
            return qC;
        }
        AppMethodBeat.m2505o(11258);
        return qC;
    }

    /* renamed from: qE */
    public final int mo20349qE(String str) {
        AppMethodBeat.m2504i(11259);
        C36692b qC = mo20347qC(str);
        if (qC == null) {
            AppMethodBeat.m2505o(11259);
            return 0;
        }
        int i = qC.field_qyUin;
        AppMethodBeat.m2505o(11259);
        return i;
    }

    /* renamed from: pI */
    public final boolean mo20346pI(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(11260);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11260);
        } else {
            C4925c c36692b = new C36692b();
            c36692b.field_userName = str;
            z = super.mo16760a(c36692b, "userName");
            if (z) {
                C8930a c8930a = new C8930a();
                c8930a.fuO = str;
                c8930a.fuN = C8931b.DELETE;
                c8930a.fuP = c36692b;
                this.fuL.mo10126cF(c8930a);
                this.fuL.doNotify();
            }
            AppMethodBeat.m2505o(11260);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m16088a(C36692b c36692b) {
        AppMethodBeat.m2504i(11261);
        if (c36692b == null) {
            AppMethodBeat.m2505o(11261);
            return false;
        }
        boolean b = super.mo10101b((C4925c) c36692b);
        C8931b c8931b = C8931b.INSERT;
        if (!b) {
            b = super.mo10099a(c36692b);
            c8931b = C8931b.UPDATE;
        }
        if (b) {
            C8930a c8930a = new C8930a();
            c8930a.fuO = c36692b.field_userName;
            c8930a.fuN = c8931b;
            c8930a.fuP = c36692b;
            this.fuL.mo10126cF(c8930a);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11261);
        return b;
    }

    /* renamed from: a */
    private boolean m16089a(C44137km c44137km) {
        AppMethodBeat.m2504i(11262);
        C36692b qD = mo20348qD(c44137km.vNb);
        qD.field_userName = c44137km.vNb;
        qD.field_qyUin = c44137km.vNt;
        qD.field_userUin = c44137km.vNu;
        qD.field_wwMaxExposeTimes = c44137km.vNw;
        qD.field_wwUserVid = c44137km.vNx;
        qD.field_wwCorpId = c44137km.vNy;
        qD.field_userType = c44137km.vNz;
        qD.field_chatOpen = c44137km.vNA;
        qD.field_wwUnreadCnt = c44137km.vNB;
        qD.field_show_confirm = c44137km.vNC;
        qD.field_use_preset_banner_tips = c44137km.vNE;
        fuK = c44137km.vND;
        if (c44137km.vNx == 0 && c44137km.vNy == 0 && c44137km.vNt != 0) {
            qD.field_wwUserVid = (long) c44137km.vNu;
            qD.field_wwCorpId = (long) c44137km.vNt;
        }
        c44137km.vNv &= -9;
        qD.field_userFlag = c44137km.vNv | (qD.field_userFlag & 8);
        boolean a = m16088a(qD);
        AppMethodBeat.m2505o(11262);
        return a;
    }

    /* renamed from: a */
    public static boolean m16090a(String str, C1202f c1202f) {
        AppMethodBeat.m2504i(11263);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11263);
            return false;
        }
        int i;
        if (C17903f.m28109rc(str)) {
            i = 1;
        } else if (C17903f.m28108rb(str)) {
            i = 2;
        } else {
            AppMethodBeat.m2505o(11263);
            return false;
        }
        boolean a = C1720g.m3535RO().eJo.mo14541a(new C41746s(str, i, c1202f), 0);
        AppMethodBeat.m2505o(11263);
        return a;
    }

    /* renamed from: a */
    public static C45147y m16086a(String str, boolean z, C1202f c1202f) {
        AppMethodBeat.m2504i(11264);
        C44137km c44137km = new C44137km();
        c44137km.vNb = str;
        c44137km.vNv = z ? 1 : 0;
        c44137km.vNt = 0;
        C1207m c45147y = new C45147y(c44137km, c1202f);
        if (C1720g.m3535RO().eJo.mo14541a(c45147y, 0)) {
            AppMethodBeat.m2505o(11264);
            return c45147y;
        }
        AppMethodBeat.m2505o(11264);
        return null;
    }

    /* renamed from: qF */
    public final void mo20350qF(String str) {
        AppMethodBeat.m2504i(11265);
        C36692b qD = mo20348qD(str);
        if (qD.field_wwExposeTimes >= qD.field_wwMaxExposeTimes) {
            AppMethodBeat.m2505o(11265);
            return;
        }
        qD.field_wwExposeTimes++;
        m16088a(qD);
        AppMethodBeat.m2505o(11265);
    }

    /* renamed from: a */
    public static void m16087a(C45147y c45147y) {
        AppMethodBeat.m2504i(11266);
        C1720g.m3535RO().eJo.mo14547c((C1207m) c45147y);
        c45147y.data = null;
        AppMethodBeat.m2505o(11266);
    }

    /* renamed from: qG */
    public final boolean mo20351qG(String str) {
        AppMethodBeat.m2504i(11267);
        C36692b qC = mo20347qC(str);
        if (qC == null || (qC.field_userFlag & 1) == 0) {
            AppMethodBeat.m2505o(11267);
            return false;
        }
        AppMethodBeat.m2505o(11267);
        return true;
    }

    /* renamed from: lb */
    public static String m16091lb(int i) {
        AppMethodBeat.m2504i(11268);
        String str = null;
        if (fuK == null) {
            fuK = new C7264hf();
        }
        switch (i) {
            case 0:
                str = fuK.vJP;
                break;
            case 1:
                str = fuK.vJQ;
                break;
            case 2:
                str = fuK.vJR;
                break;
        }
        AppMethodBeat.m2505o(11268);
        return str;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = -1;
        AppMethodBeat.m2504i(11269);
        if (i == 0 && i2 == 0) {
            C1202f c1202f;
            if (c1207m instanceof C41746s) {
                afu afu;
                C41746s c41746s = (C41746s) c1207m;
                if (c41746s.ehh == null || c41746s.ehh.fsH.fsP == null) {
                    afu = null;
                } else {
                    afu = (afu) c41746s.ehh.fsH.fsP;
                }
                if (afu == null || afu.vNh == null || afu.vNh.ret != 0 || afu.wmX == null) {
                    AppMethodBeat.m2505o(11269);
                    return;
                }
                if (!m16089a(afu.wmX)) {
                    i2 = -1;
                }
                c1202f = (C1202f) c41746s.data;
                if (c1202f != null) {
                    c1202f.onSceneEnd(i, i2, str, c1207m);
                }
            }
            if (c1207m instanceof C45147y) {
                bxq bxq;
                C45147y c45147y = (C45147y) c1207m;
                if (c45147y.ehh == null || c45147y.ehh.fsH.fsP == null) {
                    bxq = null;
                } else {
                    bxq = (bxq) c45147y.ehh.fsH.fsP;
                }
                if (bxq == null || bxq.vNh == null || bxq.vNh.ret != 0 || bxq.wmX == null) {
                    AppMethodBeat.m2505o(11269);
                    return;
                }
                if (m16089a(bxq.wmX)) {
                    i3 = i2;
                }
                c1202f = (C1202f) c45147y.data;
                if (c1202f != null) {
                    c1202f.onSceneEnd(i, i3, str, c1207m);
                }
            }
            AppMethodBeat.m2505o(11269);
            return;
        }
        AppMethodBeat.m2505o(11269);
    }
}
