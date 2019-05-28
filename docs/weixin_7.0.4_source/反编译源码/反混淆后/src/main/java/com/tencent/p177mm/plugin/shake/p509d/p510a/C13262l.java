package com.tencent.p177mm.plugin.shake.p509d.p510a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1019b.C34894d;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21826a;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21828b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3829b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3830a;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3832c;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3833d;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3834f;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C46198a.C34896a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.byu;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.shake.d.a.l */
public final class C13262l extends C21828b {
    private static boolean isInited = false;
    private static boolean isRunning = false;
    private Context context;
    private boolean csi = false;
    private long iQb;
    private C46198a qtU = new C46198a();

    /* renamed from: com.tencent.mm.plugin.shake.d.a.l$1 */
    class C132631 implements C34896a {
        C132631() {
        }

        /* renamed from: b */
        public final void mo25333b(btd btd, long j, boolean z) {
            long currentTimeMillis;
            AppMethodBeat.m2504i(24656);
            C4990ab.m7417i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", Boolean.valueOf(z));
            if (j > C13262l.this.iQb) {
                currentTimeMillis = System.currentTimeMillis() - j;
            } else {
                currentTimeMillis = System.currentTimeMillis() - C13262l.this.iQb;
            }
            if (btd != null && !C5046bo.isNullOrNil(((byu) btd).vOt)) {
                boolean a;
                byu byu = (byu) btd;
                C4990ab.m7421w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", Integer.valueOf(byu.jCt), byu.vOt);
                String str = null;
                String str2 = null;
                if (byu.vOt != null) {
                    byu.vOt = byu.vOt.trim();
                    int indexOf = byu.vOt.indexOf("<tvinfo>");
                    if (indexOf > 0) {
                        str = byu.vOt.substring(0, indexOf);
                        str2 = byu.vOt.substring(indexOf);
                    } else if (indexOf == 0) {
                        str2 = byu.vOt;
                    } else {
                        str = byu.vOt;
                    }
                }
                C13262l.m21276WF(str2);
                switch (byu.jCt) {
                    case 0:
                        a = C13262l.m21279a(C13262l.this, str);
                        break;
                    case 1:
                        a = C13262l.m21280b(C13262l.this, str);
                        break;
                    case 2:
                        a = C13262l.m21282c(C13262l.this, str);
                        break;
                    case 3:
                        a = C13262l.m21283d(C13262l.this, str);
                        break;
                    case 4:
                        a = C13262l.m21284e(C13262l.this, str);
                        break;
                    case 5:
                        a = C13262l.m21285f(C13262l.this, str);
                        break;
                    case 6:
                        a = C13262l.m21286g(C13262l.this, str);
                        break;
                    default:
                        C4990ab.m7420w("Micromsg.ShakeTVService", "parse unknown type:" + byu.jCt);
                        C13262l.m21278a(C13262l.this, new ArrayList());
                        a = false;
                        break;
                }
                if (a) {
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - C13262l.this.iQb)));
                    C7060h.pYm.mo15419k(835, 0, 1);
                } else {
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis));
                    C7060h.pYm.mo15419k(835, 4, 1);
                }
            } else if (z) {
                C13262l.m21278a(C13262l.this, new ArrayList());
                C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis));
                C7060h.pYm.mo15419k(835, 3, 1);
            } else {
                C13262l.m21278a(C13262l.this, new ArrayList());
                C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis));
                C7060h.pYm.mo15419k(835, 2, 1);
            }
            C13262l.isRunning = false;
            AppMethodBeat.m2505o(24656);
        }
    }

    public C13262l(Context context, C21826a c21826a) {
        super(c21826a);
        AppMethodBeat.m2504i(24657);
        this.context = context;
        isRunning = false;
        AppMethodBeat.m2505o(24657);
    }

    public final void init() {
        AppMethodBeat.m2504i(24659);
        if (!isInited) {
            if (this.qtU.ckt()) {
                isInited = true;
            } else {
                C4990ab.m7412e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
                AppMethodBeat.m2505o(24659);
                return;
            }
        }
        AppMethodBeat.m2505o(24659);
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void cjw() {
        AppMethodBeat.m2504i(24660);
        super.cjw();
        this.qtU.mo74193EB();
        if (isRunning) {
            long currentTimeMillis = System.currentTimeMillis() - this.iQb;
            C4990ab.m7411d("Micromsg.ShakeTVService", "a%s, isRunning=%s", Long.valueOf(currentTimeMillis), Boolean.valueOf(isRunning));
            C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis));
            C7060h.pYm.mo15419k(835, 1, 1);
            isRunning = false;
        }
        AppMethodBeat.m2505o(24660);
    }

    public final void resume() {
    }

    /* renamed from: c */
    private void m21281c(List<C34894d> list, long j) {
        AppMethodBeat.m2504i(24661);
        if (this.qrT != null) {
            this.qrT.mo25340b(list, j);
        }
        AppMethodBeat.m2505o(24661);
    }

    public final void start() {
        AppMethodBeat.m2504i(24658);
        C4990ab.m7418v("Micromsg.ShakeTVService", "hy: start shake tv!");
        if (this.qrT == null) {
            C4990ab.m7420w("Micromsg.ShakeTVService", "shakeGetListener == null");
            AppMethodBeat.m2505o(24658);
        } else if (this.context instanceof Activity) {
            isRunning = true;
            this.iQb = System.currentTimeMillis();
            this.qtU.mo74194a(408, new C132631());
            C7060h.pYm.mo15419k(835, 5, 1);
            AppMethodBeat.m2505o(24658);
        } else {
            C4990ab.m7412e("Micromsg.ShakeTVService", "context not an Activity");
            this.qrT.mo25340b(new ArrayList(), 0);
            AppMethodBeat.m2505o(24658);
        }
    }

    /* renamed from: WF */
    static /* synthetic */ void m21276WF(String str) {
        C13264n c13264n;
        String[] strArr = null;
        AppMethodBeat.m2504i(24662);
        if (C5046bo.isNullOrNil(str)) {
            c13264n = null;
        } else {
            C13264n c13264n2;
            Map z = C5049br.m7595z(str, "tvinfo");
            if (z != null) {
                String str2 = (String) z.get(".tvinfo.username");
                if (C5046bo.isNullOrNil(str2)) {
                    c13264n = null;
                } else {
                    C13264n c13264n3 = new C13264n();
                    c13264n3.field_username = str2;
                    c13264n3.field_iconurl = C5046bo.nullAsNil((String) z.get(".tvinfo.iconurl"));
                    c13264n3.field_title = C5046bo.nullAsNil((String) z.get(".tvinfo.title"));
                    c13264n3.field_deeplink = C5046bo.nullAsNil((String) z.get(".tvinfo.deeplinkjumpurl"));
                    c13264n3.field_createtime = C5046bo.getLong((String) z.get(".tvinfo.createtime"), 0);
                    c13264n2 = c13264n3;
                }
            } else {
                c13264n2 = null;
            }
            c13264n = c13264n2;
        }
        if (c13264n != null) {
            C46199o cjU = C28987m.cjU();
            Cursor a = cjU.bSd.mo10105a("shaketvhistory", null, "username=?", new String[]{c13264n.field_username}, null, null, null, 2);
            if (a.moveToFirst()) {
                strArr = new C13264n();
                strArr.mo8995d(a);
                a.close();
            } else {
                C4990ab.m7416i("MicroMsg.ShakeTvHistoryStorage", "get null with username:".concat(String.valueOf(r10)));
                a.close();
            }
            if (strArr != null) {
                C4990ab.m7416i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                cjU = C28987m.cjU();
                if (C5046bo.isNullOrNil(c13264n.field_username)) {
                    C4990ab.m7420w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    AppMethodBeat.m2505o(24662);
                    return;
                }
                cjU.bSd.update("shaketvhistory", c13264n.mo10098Hl(), "username=?", new String[]{c13264n.field_username});
                AppMethodBeat.m2505o(24662);
                return;
            }
            C4990ab.m7416i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            C28987m.cjU().mo10101b((C4925c) c13264n);
        }
        AppMethodBeat.m2505o(24662);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m21280b(C13262l c13262l, String str) {
        AppMethodBeat.m2504i(24664);
        C3834f WL = C3834f.m6128WL(str);
        List arrayList = new ArrayList();
        if (WL == null || WL.userName == null) {
            C4990ab.m7420w("Micromsg.ShakeTVService", "parse user fail");
            c13262l.m21281c(arrayList, 4);
            AppMethodBeat.m2505o(24664);
            return false;
        }
        C4990ab.m7410d("Micromsg.ShakeTVService", "parse user: username=" + WL.userName + ", nickname=" + WL.bCu + ", showchat=" + WL.quc);
        C34894d c34894d = new C34894d();
        c34894d.field_username = WL.userName;
        c34894d.field_nickname = WL.bCu;
        c34894d.field_type = 6;
        c34894d.field_insertBatch = 1;
        c34894d.field_distance = WL.quc;
        C28987m.cjS().mo25304a(c34894d, true);
        arrayList.add(c34894d);
        c13262l.m21281c(arrayList, 1);
        AppMethodBeat.m2505o(24664);
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m21283d(C13262l c13262l, String str) {
        AppMethodBeat.m2504i(24666);
        List arrayList = new ArrayList();
        C3829b WH = C3829b.m6123WH(str);
        if (WH == null || WH.qtZ == null) {
            C4990ab.m7420w("Micromsg.ShakeTVService", "parse pay fail");
            c13262l.m21281c(arrayList, 4);
            AppMethodBeat.m2505o(24666);
            return false;
        }
        C4990ab.m7410d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + WH.qtZ + ", title=" + WH.title + ", thumbUrl=" + WH.thumbUrl);
        C34894d c34894d = new C34894d();
        c34894d.field_username = WH.qtZ;
        c34894d.field_nickname = WH.title;
        c34894d.field_sns_bgurl = WH.thumbUrl;
        c34894d.field_distance = WH.pdz;
        c34894d.field_type = 9;
        c34894d.field_insertBatch = 1;
        c34894d.field_lvbuffer = str.getBytes();
        C28987m.cjS().mo25304a(c34894d, true);
        arrayList.add(c34894d);
        c13262l.m21281c(arrayList, 1);
        AppMethodBeat.m2505o(24666);
        return true;
    }

    /* renamed from: e */
    static /* synthetic */ boolean m21284e(C13262l c13262l, String str) {
        AppMethodBeat.m2504i(24667);
        List arrayList = new ArrayList();
        C3832c WI = C3832c.m6126WI(str);
        if (WI == null || WI.f1278id == null) {
            C4990ab.m7420w("Micromsg.ShakeTVService", "parse product fail");
            c13262l.m21281c(arrayList, 4);
            AppMethodBeat.m2505o(24667);
            return false;
        }
        C4990ab.m7410d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + WI.f1278id + ", title=" + WI.title + ", thumbUrl=" + WI.thumbUrl);
        C34894d c34894d = new C34894d();
        c34894d.field_username = WI.f1278id;
        c34894d.field_nickname = WI.title;
        c34894d.field_sns_bgurl = WI.thumbUrl;
        c34894d.field_type = 10;
        c34894d.field_insertBatch = 1;
        c34894d.field_lvbuffer = str.getBytes();
        C28987m.cjS().mo25304a(c34894d, true);
        arrayList.add(c34894d);
        c13262l.m21281c(arrayList, 1);
        AppMethodBeat.m2505o(24667);
        return true;
    }

    /* renamed from: f */
    static /* synthetic */ boolean m21285f(C13262l c13262l, String str) {
        AppMethodBeat.m2504i(24668);
        List arrayList = new ArrayList();
        C3833d WJ = C3833d.m6127WJ(str);
        if (WJ == null || C5046bo.isNullOrNil(WJ.qub)) {
            C4990ab.m7420w("Micromsg.ShakeTVService", "parse TempSession fail");
            c13262l.m21281c(arrayList, 4);
            AppMethodBeat.m2505o(24668);
            return false;
        }
        C34894d c34894d = new C34894d();
        c34894d.field_username = WJ.qub;
        c34894d.field_nickname = WJ.title;
        c34894d.field_distance = WJ.username;
        c34894d.field_sns_bgurl = WJ.thumbUrl;
        c34894d.field_type = 12;
        c34894d.field_insertBatch = 1;
        c34894d.field_lvbuffer = str.getBytes();
        C28987m.cjS().mo25304a(c34894d, true);
        arrayList.add(c34894d);
        c13262l.m21281c(arrayList, 1);
        AppMethodBeat.m2505o(24668);
        return true;
    }

    /* renamed from: g */
    static /* synthetic */ boolean m21286g(C13262l c13262l, String str) {
        AppMethodBeat.m2504i(24669);
        List arrayList = new ArrayList();
        C3830a WG = C3830a.m6124WG(str);
        if (WG != null) {
            C34894d c34894d = new C34894d();
            c34894d.field_username = WG.username;
            c34894d.field_nickname = WG.title;
            c34894d.field_reserved3 = WG.path;
            c34894d.field_sns_bgurl = WG.thumbUrl;
            c34894d.field_reserved2 = WG.version;
            c34894d.field_type = 13;
            c34894d.field_insertBatch = 1;
            c34894d.field_lvbuffer = str.getBytes();
            C28987m.cjS().mo25304a(c34894d, true);
            arrayList.add(c34894d);
            c13262l.m21281c(arrayList, 1);
            AppMethodBeat.m2505o(24669);
            return true;
        }
        C4990ab.m7420w("Micromsg.ShakeTVService", "parse appBrand fail");
        c13262l.m21281c(arrayList, 4);
        AppMethodBeat.m2505o(24669);
        return false;
    }
}
