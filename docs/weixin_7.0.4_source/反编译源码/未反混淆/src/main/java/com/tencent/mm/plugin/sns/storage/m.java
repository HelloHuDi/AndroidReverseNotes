package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m extends j<l> implements e {
    public static final String[] fnj = new String[]{j.a(l.ccO, "snsExtInfo3")};
    public com.tencent.mm.sdk.e.e bSd;
    private boolean rfc = false;
    private g rfd = null;

    static {
        AppMethodBeat.i(37881);
        AppMethodBeat.o(37881);
    }

    public final void cmk() {
        AppMethodBeat.i(37859);
        ab.d("MicroMsg.SnsExtStorage", "attachCache");
        this.rfc = true;
        AppMethodBeat.o(37859);
    }

    public final void cml() {
        AppMethodBeat.i(37860);
        this.rfc = false;
        this.rfd.cnV();
        ab.d("MicroMsg.SnsExtStorage", "detchCache");
        AppMethodBeat.o(37860);
    }

    public m(com.tencent.mm.sdk.e.e eVar, g gVar) {
        super(eVar, l.ccO, "snsExtInfo3", null);
        AppMethodBeat.i(37861);
        this.bSd = eVar;
        this.rfd = gVar;
        ab.i("MicroMsg.SnsExtStorage", "createExtStorage " + eVar + "  " + Thread.currentThread().getId());
        AppMethodBeat.o(37861);
    }

    public final boolean b(l lVar) {
        AppMethodBeat.i(37862);
        boolean a = super.a(lVar);
        AppMethodBeat.o(37862);
        return a;
    }

    public final boolean a(l lVar) {
        AppMethodBeat.i(37863);
        boolean a;
        if (!this.rfc || this.rfd == null) {
            a = super.a(lVar);
            AppMethodBeat.o(37863);
            return a;
        }
        a = this.rfd.a(lVar);
        if (this.rfd != null) {
            this.rfd.cnU();
        }
        AppMethodBeat.o(37863);
        return a;
    }

    public final void YU(String str) {
        AppMethodBeat.i(37864);
        c YX = YX(str);
        YX.field_userName = str;
        super.a(YX, this.xDe.xDc);
        AppMethodBeat.o(37864);
    }

    public final int k(String str, String str2, int i, int i2) {
        AppMethodBeat.i(37865);
        l YX = YX(str);
        YX.field_md5 = str2;
        YX.field_lastFirstPageRequestErrType = i;
        YX.field_lastFirstPageRequestErrCode = i2;
        super.a(YX);
        AppMethodBeat.o(37865);
        return 0;
    }

    public final int h(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(37866);
        l YX = YX(str);
        YX.field_md5 = str2;
        YX.field_adsession = bArr;
        super.a(YX);
        AppMethodBeat.o(37866);
        return 0;
    }

    public final boolean gq(String str, String str2) {
        AppMethodBeat.i(37867);
        l YX = YX(str);
        YX.field_newerIds = str2;
        boolean a = super.a(YX);
        AppMethodBeat.o(37867);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final acs YV(String str) {
        acs acs;
        AppMethodBeat.i(37868);
        acs acs2 = new acs();
        l lVar = new l();
        lVar = YX(str);
        try {
            if (!bo.cb(lVar.field_faultS)) {
                acs = (acs) new acs().parseFrom(lVar.field_faultS);
                if (acs == null) {
                    acs = new acs();
                }
                AppMethodBeat.o(37868);
                return acs;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        }
        acs = acs2;
        if (acs == null) {
        }
        AppMethodBeat.o(37868);
        return acs;
    }

    public final void YW(String str) {
        AppMethodBeat.i(37869);
        l lVar = new l();
        lVar = YX(str);
        lVar.field_userName = str;
        lVar.field_local_flag &= -2;
        c(lVar);
        AppMethodBeat.o(37869);
    }

    public final l YX(String str) {
        AppMethodBeat.i(37870);
        l lVar = new l();
        if (this.rfd != null && this.rfc) {
            lVar = this.rfd.XW(str);
            if (lVar != null) {
                AppMethodBeat.o(37870);
                return lVar;
            }
            lVar = new l();
        }
        lVar.field_userName = str;
        super.b(lVar, this.xDe.xDc);
        AppMethodBeat.o(37870);
        return lVar;
    }

    public final boolean c(l lVar) {
        AppMethodBeat.i(37871);
        if (lVar == null || lVar.field_userName == null || lVar.field_userName.equals("")) {
            AppMethodBeat.o(37871);
            return false;
        }
        boolean a = super.a(lVar);
        AppMethodBeat.o(37871);
        return a;
    }

    public final boolean a(String str, ccl ccl) {
        AppMethodBeat.i(37872);
        l YX = YX(str);
        String jV = i.jV(ccl.gva);
        if (!bo.isNullOrNil(ccl.guZ) && (YX.field_bgUrl == null || !YX.field_bgId.equals(jV))) {
            YX.field_older_bgId = YX.field_bgId;
            YX.field_local_flag |= 1;
            YX.cqI();
            ab.d("MicroMsg.SnsExtStorage", "bg change");
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
        YX.a(ccl);
        a(YX);
        AppMethodBeat.o(37872);
        return true;
    }

    public final ccl b(String str, ccl ccl) {
        AppMethodBeat.i(37873);
        l YX = YX(str);
        l a;
        if (YX == null) {
            a = a(str, YX);
            if (a != null) {
                ccl.guY = ccl.guY == -1 ? a.field_iFlag : ccl.guY;
            }
            AppMethodBeat.o(37873);
        } else {
            ccl.guZ = bo.isNullOrNil(ccl.guZ) ? YX.field_bgUrl : ccl.guZ;
            Object obj = ccl.guY == -1 ? 1 : null;
            ccl.guY = obj != null ? YX.field_iFlag : ccl.guY;
            a = a(str, YX);
            if (a != null) {
                ccl.guY = obj != null ? a.field_iFlag : ccl.guY;
            }
            AppMethodBeat.o(37873);
        }
        return ccl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private l a(String str, l lVar) {
        int i;
        int i2;
        Cursor a;
        AppMethodBeat.i(37874);
        if (lVar == null) {
            i = 0;
        } else {
            if ((lVar.field_iFlag & 1) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((lVar.field_local_flag & 4) > 0) {
                i2 = 1;
                if (i2 == 0 && r0 == 0) {
                    a = this.bSd.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
                    if (a.moveToFirst()) {
                        i = 0;
                    } else {
                        i = a.getInt(0);
                    }
                    a.close();
                    if (i != 0) {
                        ab.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", str);
                        AppMethodBeat.o(37874);
                        return null;
                    }
                    ab.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", "select * from snsExtInfo2 where userName=\"" + bo.vA(str) + "\"");
                    a = this.bSd.a(r0, null, 2);
                    l lVar2 = new l();
                    if (a.moveToFirst()) {
                        lVar2.d(a);
                        a.close();
                        ab.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", str);
                        AppMethodBeat.o(37874);
                        return lVar2;
                    }
                    a.close();
                }
                AppMethodBeat.o(37874);
                return null;
            }
        }
        i2 = 0;
        a = this.bSd.a("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
        if (a.moveToFirst()) {
        }
        a.close();
        if (i != 0) {
        }
    }

    public final ccl WX(String str) {
        AppMethodBeat.i(37875);
        l YX = YX(str);
        ccl ccl;
        if (YX == null) {
            ccl = new ccl();
            AppMethodBeat.o(37875);
            return ccl;
        }
        ccl = YX.cqK();
        AppMethodBeat.o(37875);
        return ccl;
    }

    public final boolean bh(String str, boolean z) {
        AppMethodBeat.i(37876);
        l YX = YX(str);
        int i = YX.field_iFlag;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        YX.field_iFlag = i;
        c(YX);
        AppMethodBeat.o(37876);
        return true;
    }

    public final ccl bi(String str, boolean z) {
        AppMethodBeat.i(37877);
        ccl cqK = YX(str).cqK();
        if (cqK == null) {
            ab.e("MicroMsg.SnsExtStorage", "userinfo is null");
            AppMethodBeat.o(37877);
            return null;
        }
        int i = cqK.xbQ;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        cqK.xbQ = i;
        AppMethodBeat.o(37877);
        return cqK;
    }

    public final boolean a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        AppMethodBeat.i(37878);
        l YX = YX(str);
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
            YX.a(cqK);
        }
        c(YX);
        AppMethodBeat.o(37878);
        return true;
    }

    public final ccl b(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(37879);
        ccl cqK = YX(str).cqK();
        if (cqK == null) {
            ab.e("MicroMsg.SnsExtStorage", "userinfo is null");
            AppMethodBeat.o(37879);
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
        AppMethodBeat.o(37879);
        return cqK;
    }
}
