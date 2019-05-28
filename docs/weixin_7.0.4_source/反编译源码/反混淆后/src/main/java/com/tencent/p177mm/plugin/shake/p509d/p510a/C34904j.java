package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1019b.C34894d;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21826a;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21828b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3829b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3832c;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3828m.C3834f;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C46198a.C34896a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.byq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.d.a.j */
public final class C34904j extends C21828b {
    public static boolean isInited = false;
    public static C34904j qtV;
    private boolean csi = false;
    private long iQb;
    public C46198a qtU = new C46198a();

    /* renamed from: com.tencent.mm.plugin.shake.d.a.j$1 */
    class C218311 implements C34896a {
        C218311() {
        }

        /* renamed from: b */
        public final void mo25333b(btd btd, long j, boolean z) {
            AppMethodBeat.m2504i(24638);
            if (C34904j.this.qrT == null) {
                C4990ab.m7420w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
                AppMethodBeat.m2505o(24638);
                return;
            }
            byq byq = (byq) btd;
            if (byq == null) {
                C4990ab.m7420w("Micromsg.ShakeMusicMgr", "resp null & return");
                C34904j.m57321a(C34904j.this, new ArrayList());
                AppMethodBeat.m2505o(24638);
            } else if (byq.wXX == 1) {
                long currentTimeMillis;
                if (j > C34904j.this.iQb) {
                    currentTimeMillis = System.currentTimeMillis() - j;
                } else {
                    currentTimeMillis = System.currentTimeMillis() - C34904j.this.iQb;
                }
                if (byq != null && !C5046bo.isNullOrNil(byq.wXZ)) {
                    boolean a;
                    C4990ab.m7421w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", Integer.valueOf(byq.wXY), byq.wXZ);
                    String str = byq.wXZ;
                    if (str != null) {
                        str = str.trim();
                    }
                    switch (byq.wXY) {
                        case 0:
                            a = C34904j.m57322a(C34904j.this, str);
                            break;
                        case 1:
                            a = C34904j.m57324b(C34904j.this, str);
                            break;
                        case 2:
                            a = C34904j.m57327c(C34904j.this, str);
                            break;
                        case 3:
                            a = C34904j.m57328d(C34904j.this, str);
                            break;
                        case 4:
                            a = C34904j.m57329e(C34904j.this, str);
                            break;
                        default:
                            C4990ab.m7420w("Micromsg.ShakeMusicMgr", "parse unknown type:" + byq.wXY);
                            C34904j.m57321a(C34904j.this, new ArrayList());
                            a = false;
                            break;
                    }
                    if (a) {
                        C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - C34904j.this.iQb)));
                        C7060h.pYm.mo15419k(835, 0, 1);
                        AppMethodBeat.m2505o(24638);
                        return;
                    }
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis));
                    C7060h.pYm.mo15419k(835, 4, 1);
                    AppMethodBeat.m2505o(24638);
                } else if (z) {
                    C34904j.m57321a(C34904j.this, new ArrayList());
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis));
                    C7060h.pYm.mo15419k(835, 3, 1);
                    AppMethodBeat.m2505o(24638);
                } else {
                    C34904j.m57321a(C34904j.this, new ArrayList());
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis));
                    C7060h.pYm.mo15419k(835, 2, 1);
                    AppMethodBeat.m2505o(24638);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                if (byq != null) {
                    C34894d c34894d = new C34894d();
                    if (!(byq.wXT == null || byq.wXT.getBuffer() == null)) {
                        c34894d.field_username = byq.wXT.getBuffer().dlY();
                    }
                    if (!(byq.wXS == null || byq.wXS.getBuffer() == null)) {
                        c34894d.field_nickname = byq.wXS.getBuffer().dlY();
                    }
                    if (!(byq.wXT == null || byq.wXT.getBuffer() == null)) {
                        c34894d.field_distance = byq.wXT.getBuffer().dlY();
                    }
                    if (!(byq.wrE == null || byq.wrE.getBuffer() == null)) {
                        c34894d.field_sns_bgurl = byq.wrE.getBuffer().dlY();
                    }
                    c34894d.field_type = 4;
                    c34894d.field_insertBatch = 1;
                    try {
                        c34894d.field_lvbuffer = byq.toByteArray();
                    } catch (IOException e) {
                        C4990ab.m7421w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", e.getLocalizedMessage());
                    }
                    C28987m.cjS().mo25304a(c34894d, true);
                    arrayList.add(c34894d);
                }
                C34904j.this.qrT.mo25340b(arrayList, j);
                AppMethodBeat.m2505o(24638);
            }
        }
    }

    /* renamed from: a */
    public static C34904j m57320a(C21826a c21826a) {
        AppMethodBeat.m2504i(24639);
        if (qtV == null || qtV.qrT == null) {
            qtV = new C34904j(c21826a);
        }
        C34904j c34904j = qtV;
        AppMethodBeat.m2505o(24639);
        return c34904j;
    }

    private C34904j(C21826a c21826a) {
        super(c21826a);
        AppMethodBeat.m2504i(24640);
        AppMethodBeat.m2505o(24640);
    }

    public final void init() {
        AppMethodBeat.m2504i(24642);
        if (!isInited) {
            if (this.qtU.ckt()) {
                isInited = true;
            } else {
                C4990ab.m7412e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
                AppMethodBeat.m2505o(24642);
                return;
            }
        }
        AppMethodBeat.m2505o(24642);
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void cjw() {
        AppMethodBeat.m2504i(24643);
        this.qtU.mo74193EB();
        super.cjw();
        AppMethodBeat.m2505o(24643);
    }

    public final void resume() {
    }

    /* renamed from: c */
    private void m57326c(List<C34894d> list, long j) {
        AppMethodBeat.m2504i(24644);
        if (this.qrT != null) {
            this.qrT.mo25340b(list, j);
        }
        AppMethodBeat.m2505o(24644);
    }

    public final void start() {
        AppMethodBeat.m2504i(24641);
        if (this.qrT == null) {
            C4990ab.m7420w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            AppMethodBeat.m2505o(24641);
            return;
        }
        this.iQb = System.currentTimeMillis();
        this.qtU.mo74194a(367, new C218311());
        AppMethodBeat.m2505o(24641);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m57324b(C34904j c34904j, String str) {
        AppMethodBeat.m2504i(24647);
        C3834f WL = C3834f.m6128WL(str);
        List arrayList = new ArrayList();
        if (WL == null || WL.userName == null) {
            C4990ab.m7420w("Micromsg.ShakeMusicMgr", "parse user fail");
            c34904j.m57326c(arrayList, 4);
            AppMethodBeat.m2505o(24647);
            return false;
        }
        C4990ab.m7410d("Micromsg.ShakeMusicMgr", "parse user: username=" + WL.userName + ", nickname=" + WL.bCu + ", showchat=" + WL.quc);
        C34894d c34894d = new C34894d();
        c34894d.field_username = WL.userName;
        c34894d.field_nickname = WL.bCu;
        c34894d.field_type = 6;
        c34894d.field_insertBatch = 1;
        c34894d.field_distance = WL.quc;
        C28987m.cjS().mo25304a(c34894d, true);
        arrayList.add(c34894d);
        c34904j.m57326c(arrayList, 1);
        AppMethodBeat.m2505o(24647);
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m57328d(C34904j c34904j, String str) {
        AppMethodBeat.m2504i(24649);
        List arrayList = new ArrayList();
        C3829b WH = C3829b.m6123WH(str);
        if (WH == null || WH.qtZ == null) {
            C4990ab.m7420w("Micromsg.ShakeMusicMgr", "parse pay fail");
            c34904j.m57326c(arrayList, 4);
            AppMethodBeat.m2505o(24649);
            return false;
        }
        C4990ab.m7410d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + WH.qtZ + ", title=" + WH.title + ", thumbUrl=" + WH.thumbUrl);
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
        c34904j.m57326c(arrayList, 1);
        AppMethodBeat.m2505o(24649);
        return true;
    }

    /* renamed from: e */
    static /* synthetic */ boolean m57329e(C34904j c34904j, String str) {
        AppMethodBeat.m2504i(24650);
        List arrayList = new ArrayList();
        C3832c WI = C3832c.m6126WI(str);
        if (WI == null || WI.f1278id == null) {
            C4990ab.m7420w("Micromsg.ShakeMusicMgr", "parse product fail");
            c34904j.m57326c(arrayList, 4);
            AppMethodBeat.m2505o(24650);
            return false;
        }
        C4990ab.m7410d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + WI.f1278id + ", title=" + WI.title + ", thumbUrl=" + WI.thumbUrl);
        C34894d c34894d = new C34894d();
        c34894d.field_username = WI.f1278id;
        c34894d.field_nickname = WI.title;
        c34894d.field_sns_bgurl = WI.thumbUrl;
        c34894d.field_type = 10;
        c34894d.field_insertBatch = 1;
        c34894d.field_lvbuffer = str.getBytes();
        C28987m.cjS().mo25304a(c34894d, true);
        arrayList.add(c34894d);
        c34904j.m57326c(arrayList, 1);
        AppMethodBeat.m2505o(24650);
        return true;
    }
}
