package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.p1024b.C29033e;
import com.tencent.p177mm.protocal.protobuf.acs;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.m */
public final class C43573m extends C7563j<C29097l> implements C29033e {
    public static final String[] fnj = new String[]{C7563j.m13217a(C29097l.ccO, "snsExtInfo3")};
    public C4927e bSd;
    private boolean rfc = false;
    private C43572g rfd = null;

    static {
        AppMethodBeat.m2504i(37881);
        AppMethodBeat.m2505o(37881);
    }

    public final void cmk() {
        AppMethodBeat.m2504i(37859);
        C4990ab.m7410d("MicroMsg.SnsExtStorage", "attachCache");
        this.rfc = true;
        AppMethodBeat.m2505o(37859);
    }

    public final void cml() {
        AppMethodBeat.m2504i(37860);
        this.rfc = false;
        this.rfd.cnV();
        C4990ab.m7410d("MicroMsg.SnsExtStorage", "detchCache");
        AppMethodBeat.m2505o(37860);
    }

    public C43573m(C4927e c4927e, C43572g c43572g) {
        super(c4927e, C29097l.ccO, "snsExtInfo3", null);
        AppMethodBeat.m2504i(37861);
        this.bSd = c4927e;
        this.rfd = c43572g;
        C4990ab.m7416i("MicroMsg.SnsExtStorage", "createExtStorage " + c4927e + "  " + Thread.currentThread().getId());
        AppMethodBeat.m2505o(37861);
    }

    /* renamed from: b */
    public final boolean mo69181b(C29097l c29097l) {
        AppMethodBeat.m2504i(37862);
        boolean a = super.mo10099a(c29097l);
        AppMethodBeat.m2505o(37862);
        return a;
    }

    /* renamed from: a */
    public final boolean mo69180a(C29097l c29097l) {
        AppMethodBeat.m2504i(37863);
        boolean a;
        if (!this.rfc || this.rfd == null) {
            a = super.mo10099a(c29097l);
            AppMethodBeat.m2505o(37863);
            return a;
        }
        a = this.rfd.mo62845a(c29097l);
        if (this.rfd != null) {
            this.rfd.cnU();
        }
        AppMethodBeat.m2505o(37863);
        return a;
    }

    /* renamed from: YU */
    public final void mo69176YU(String str) {
        AppMethodBeat.m2504i(37864);
        C4925c YX = mo69179YX(str);
        YX.field_userName = str;
        super.mo16760a(YX, this.xDe.xDc);
        AppMethodBeat.m2505o(37864);
    }

    /* renamed from: k */
    public final int mo69185k(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(37865);
        C29097l YX = mo69179YX(str);
        YX.field_md5 = str2;
        YX.field_lastFirstPageRequestErrType = i;
        YX.field_lastFirstPageRequestErrCode = i2;
        super.mo10099a(YX);
        AppMethodBeat.m2505o(37865);
        return 0;
    }

    /* renamed from: h */
    public final int mo69184h(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(37866);
        C29097l YX = mo69179YX(str);
        YX.field_md5 = str2;
        YX.field_adsession = bArr;
        super.mo10099a(YX);
        AppMethodBeat.m2505o(37866);
        return 0;
    }

    /* renamed from: gq */
    public final boolean mo69183gq(String str, String str2) {
        AppMethodBeat.m2504i(37867);
        C29097l YX = mo69179YX(str);
        YX.field_newerIds = str2;
        boolean a = super.mo10099a(YX);
        AppMethodBeat.m2505o(37867);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: YV */
    public final acs mo69177YV(String str) {
        acs acs;
        AppMethodBeat.m2504i(37868);
        acs acs2 = new acs();
        C29097l c29097l = new C29097l();
        c29097l = mo69179YX(str);
        try {
            if (!C5046bo.m7540cb(c29097l.field_faultS)) {
                acs = (acs) new acs().parseFrom(c29097l.field_faultS);
                if (acs == null) {
                    acs = new acs();
                }
                AppMethodBeat.m2505o(37868);
                return acs;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        }
        acs = acs2;
        if (acs == null) {
        }
        AppMethodBeat.m2505o(37868);
        return acs;
    }

    /* renamed from: YW */
    public final void mo69178YW(String str) {
        AppMethodBeat.m2504i(37869);
        C29097l c29097l = new C29097l();
        c29097l = mo69179YX(str);
        c29097l.field_userName = str;
        c29097l.field_local_flag &= -2;
        mo69182c(c29097l);
        AppMethodBeat.m2505o(37869);
    }

    /* renamed from: YX */
    public final C29097l mo69179YX(String str) {
        AppMethodBeat.m2504i(37870);
        C29097l c29097l = new C29097l();
        if (this.rfd != null && this.rfc) {
            c29097l = this.rfd.mo62844XW(str);
            if (c29097l != null) {
                AppMethodBeat.m2505o(37870);
                return c29097l;
            }
            c29097l = new C29097l();
        }
        c29097l.field_userName = str;
        super.mo10102b(c29097l, this.xDe.xDc);
        AppMethodBeat.m2505o(37870);
        return c29097l;
    }

    /* renamed from: c */
    public final boolean mo69182c(C29097l c29097l) {
        AppMethodBeat.m2504i(37871);
        if (c29097l == null || c29097l.field_userName == null || c29097l.field_userName.equals("")) {
            AppMethodBeat.m2505o(37871);
            return false;
        }
        boolean a = super.mo10099a(c29097l);
        AppMethodBeat.m2505o(37871);
        return a;
    }

    /* renamed from: a */
    public final boolean mo47112a(String str, ccl ccl) {
        AppMethodBeat.m2504i(37872);
        C29097l YX = mo69179YX(str);
        String jV = C29036i.m46117jV(ccl.gva);
        if (!C5046bo.isNullOrNil(ccl.guZ) && (YX.field_bgUrl == null || !YX.field_bgId.equals(jV))) {
            YX.field_older_bgId = YX.field_bgId;
            YX.field_local_flag |= 1;
            YX.cqI();
            C4990ab.m7410d("MicroMsg.SnsExtStorage", "bg change");
        }
        YX.field_bgId = jV;
        YX.field_bgUrl = ccl.guZ;
        YX.field_iFlag = ccl.guY;
        YX.field_snsBgId = ccl.gva;
        YX.field_local_flag |= 4;
        if ((ccl.xbQ & 4096) == 0) {
            if ((ccl.xbQ & 512) > 0) {
                ccl.xbQ |= 4096;
                ccl.xbR = 4320;
            } else if ((ccl.xbQ & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                ccl.xbQ |= 4096;
                ccl.xbR = 72;
            }
        }
        YX.mo47210a(ccl);
        mo69180a(YX);
        AppMethodBeat.m2505o(37872);
        return true;
    }

    /* renamed from: b */
    public final ccl mo47114b(String str, ccl ccl) {
        AppMethodBeat.m2504i(37873);
        C29097l YX = mo69179YX(str);
        C29097l a;
        if (YX == null) {
            a = m77941a(str, YX);
            if (a != null) {
                ccl.guY = ccl.guY == -1 ? a.field_iFlag : ccl.guY;
            }
            AppMethodBeat.m2505o(37873);
        } else {
            ccl.guZ = C5046bo.isNullOrNil(ccl.guZ) ? YX.field_bgUrl : ccl.guZ;
            Object obj = ccl.guY == -1 ? 1 : null;
            ccl.guY = obj != null ? YX.field_iFlag : ccl.guY;
            a = m77941a(str, YX);
            if (a != null) {
                ccl.guY = obj != null ? a.field_iFlag : ccl.guY;
            }
            AppMethodBeat.m2505o(37873);
        }
        return ccl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private C29097l m77941a(String str, C29097l c29097l) {
        int i;
        int i2;
        Cursor a;
        AppMethodBeat.m2504i(37874);
        if (c29097l == null) {
            i = 0;
        } else {
            if ((c29097l.field_iFlag & 1) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((c29097l.field_local_flag & 4) > 0) {
                i2 = 1;
                if (i2 == 0 && r0 == 0) {
                    a = this.bSd.mo10104a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
                    if (a.moveToFirst()) {
                        i = 0;
                    } else {
                        i = a.getInt(0);
                    }
                    a.close();
                    if (i != 0) {
                        C4990ab.m7419v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", str);
                        AppMethodBeat.m2505o(37874);
                        return null;
                    }
                    C4990ab.m7411d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", "select * from snsExtInfo2 where userName=\"" + C5046bo.m7586vA(str) + "\"");
                    a = this.bSd.mo10104a(r0, null, 2);
                    C29097l c29097l2 = new C29097l();
                    if (a.moveToFirst()) {
                        c29097l2.mo8995d(a);
                        a.close();
                        C4990ab.m7417i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", str);
                        AppMethodBeat.m2505o(37874);
                        return c29097l2;
                    }
                    a.close();
                }
                AppMethodBeat.m2505o(37874);
                return null;
            }
        }
        i2 = 0;
        a = this.bSd.mo10104a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
        if (a.moveToFirst()) {
        }
        a.close();
        if (i != 0) {
        }
    }

    /* renamed from: WX */
    public final ccl mo47111WX(String str) {
        AppMethodBeat.m2504i(37875);
        C29097l YX = mo69179YX(str);
        ccl ccl;
        if (YX == null) {
            ccl = new ccl();
            AppMethodBeat.m2505o(37875);
            return ccl;
        }
        ccl = YX.cqK();
        AppMethodBeat.m2505o(37875);
        return ccl;
    }

    /* renamed from: bh */
    public final boolean mo47116bh(String str, boolean z) {
        AppMethodBeat.m2504i(37876);
        C29097l YX = mo69179YX(str);
        int i = YX.field_iFlag;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        YX.field_iFlag = i;
        mo69182c(YX);
        AppMethodBeat.m2505o(37876);
        return true;
    }

    /* renamed from: bi */
    public final ccl mo47117bi(String str, boolean z) {
        AppMethodBeat.m2504i(37877);
        ccl cqK = mo69179YX(str).cqK();
        if (cqK == null) {
            C4990ab.m7412e("MicroMsg.SnsExtStorage", "userinfo is null");
            AppMethodBeat.m2505o(37877);
            return null;
        }
        int i = cqK.xbQ;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        cqK.xbQ = i;
        AppMethodBeat.m2505o(37877);
        return cqK;
    }

    /* renamed from: a */
    public final boolean mo47113a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        AppMethodBeat.m2504i(37878);
        C29097l YX = mo69179YX(str);
        int i2 = YX.field_iFlag;
        if (YX.cqK() != null) {
            i = YX.cqK().xbQ;
        } else {
            i = 0;
        }
        int i3 = -1;
        int i4 = i2 | 4096;
        int i5 = i | 4096;
        if (z) {
            i3 = 4320;
        }
        if (z2) {
            i3 = 72;
        }
        if (z4) {
            i2 = 720;
        } else {
            i2 = i3;
        }
        if (z3) {
            i = i4 | 2048;
            i3 = i5 | 2048;
        } else {
            i = i4 & -2049;
            i3 = i5 & -2049;
        }
        YX.field_iFlag = i;
        ccl cqK = YX.cqK();
        if (cqK != null) {
            cqK.xbQ = i3;
            cqK.xbR = i2;
            YX.mo47210a(cqK);
        }
        mo69182c(YX);
        AppMethodBeat.m2505o(37878);
        return true;
    }

    /* renamed from: b */
    public final ccl mo47115b(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.m2504i(37879);
        ccl cqK = mo69179YX(str).cqK();
        if (cqK == null) {
            C4990ab.m7412e("MicroMsg.SnsExtStorage", "userinfo is null");
            AppMethodBeat.m2505o(37879);
            return null;
        }
        int i;
        int i2 = -1;
        int i3 = cqK.xbQ | 4096;
        if (z) {
            i2 = 4320;
        }
        if (z2) {
            i2 = 72;
        }
        if (z4) {
            i = 720;
        } else {
            i = i2;
        }
        if (z3) {
            i2 = i3 | 2048;
        } else {
            i2 = i3 & -2049;
        }
        cqK.xbQ = i2;
        cqK.xbR = i;
        AppMethodBeat.m2505o(37879);
        return cqK;
    }
}
