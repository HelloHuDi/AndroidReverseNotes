package com.tencent.p177mm.plugin.backup.bakoldlogic.p918d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C6663ag;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p213cd.C1369i;
import com.tencent.p177mm.p213cd.C6395f;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1363a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.pluginsdk.model.app.C14884k;
import com.tencent.p177mm.pluginsdk.model.app.C30066c;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.emotion.C30303d;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.c */
public final class C27478c {
    String eJM;
    public C7480h eJN = null;
    C7574bs jBd;
    C6398g jBe = null;
    Boolean jBf = null;
    C7580z jym;
    C7309bd jyn;
    C6977h jyo;
    C7310be jyp;
    C45160g jyq;
    C30303d jyr;
    public C6978k jys;
    C9720t jyt;
    C6663ag jyu;
    public C14884k jyv;
    public C35796i jyw;
    C30066c jyx;
    public int uin = 0;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.c$2 */
    class C274792 implements C1363a {
        C274792() {
        }

        /* renamed from: RF */
        public final void mo4747RF() {
            AppMethodBeat.m2504i(18023);
            if (C27478c.this.jBe != null) {
                C6398g c6398g = C27478c.this.jBe;
                for (Object obj : c6398g.ybM.keySet()) {
                    ((C1369i) c6398g.ybM.get(obj)).dvy();
                }
            }
            AppMethodBeat.m2505o(18023);
        }

        /* renamed from: RG */
        public final void mo4748RG() {
        }

        /* renamed from: RH */
        public final void mo4749RH() {
            AppMethodBeat.m2504i(18024);
            if (C27478c.this.jBe != null) {
                C6398g c6398g = C27478c.this.jBe;
                if (c6398g.ybN.size() != 0) {
                    C4990ab.m7417i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", "stg_null", Integer.valueOf(c6398g.ybN.size()));
                    if (c6398g.ybk == null) {
                        C4990ab.m7412e("MicroMsg.MemoryStorage", "attachTable db is null");
                        AppMethodBeat.m2505o(18024);
                        return;
                    } else if (c6398g.ybK.inTransaction()) {
                        C4990ab.m7421w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", Integer.valueOf(c6398g.ybN.size()));
                        AppMethodBeat.m2505o(18024);
                        return;
                    } else {
                        while (c6398g.ybN.size() > 0) {
                            if (c6398g.ybK.inTransaction()) {
                                C4990ab.m7421w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", Integer.valueOf(c6398g.ybN.size()));
                                AppMethodBeat.m2505o(18024);
                                return;
                            }
                            C1361a c1361a = (C1361a) c6398g.ybN.peek();
                            if (c1361a == null) {
                                c6398g.ybN.poll();
                            } else {
                                String tableName = c1361a.getTableName();
                                if (C5046bo.isNullOrNil(tableName)) {
                                    C4990ab.m7413e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", tableName);
                                    c6398g.ybN.poll();
                                } else if (C6395f.m10547a(c6398g.ybk, tableName)) {
                                    C4990ab.m7413e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", tableName);
                                    c6398g.ybN.poll();
                                } else {
                                    if (c6398g.aqv(tableName) != 0) {
                                        try {
                                            if (c6398g.vcA) {
                                                c6398g.ybk.execSQL("DETACH DATABASE old");
                                                C4990ab.m7416i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                                c6398g.vcA = false;
                                            }
                                            if (C5046bo.isNullOrNil(c6398g.ybK.getKey())) {
                                                c6398g.ybk.execSQL("ATTACH DATABASE '" + c6398g.ybK.getPath() + "' AS old ");
                                            } else {
                                                c6398g.ybk.execSQL("ATTACH DATABASE '" + c6398g.ybK.getPath() + "' AS old KEY '" + c6398g.ybK.getKey() + "'");
                                            }
                                            C4990ab.m7416i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                            c6398g.vcA = true;
                                        } catch (Exception e) {
                                            c6398g.vcA = false;
                                            C4990ab.m7413e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
                                            C4990ab.m7413e("MicroMsg.MemoryStorage", "exception:%s", C5046bo.m7574l(e));
                                        }
                                        if (c6398g.aqv(tableName) != 0) {
                                            C4990ab.m7412e("MicroMsg.MemoryStorage", "copy table failed :".concat(String.valueOf(tableName)));
                                            AppMethodBeat.m2505o(18024);
                                            return;
                                        }
                                    }
                                    C4990ab.m7417i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", tableName, Integer.valueOf(c6398g.ybN.size()), Integer.valueOf(c6398g.ybM.size()));
                                    c6398g.ybM.put(tableName, new C1369i(c6398g.ybK, tableName));
                                    c1361a.mo4744a(c6398g);
                                    c6398g.ybN.poll();
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(18024);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.c$1 */
    class C274801 implements C4931a {
        C274801() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(18022);
            C1427q.m3050ku(str);
            AppMethodBeat.m2505o(18022);
        }
    }

    /* renamed from: Ry */
    public final C7580z mo45267Ry() {
        AppMethodBeat.m2504i(18025);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18025);
            throw c1819b;
        }
        C7580z c7580z = this.jym;
        AppMethodBeat.m2505o(18025);
        return c7580z;
    }

    /* renamed from: XM */
    public final C7309bd mo45268XM() {
        AppMethodBeat.m2504i(18026);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18026);
            throw c1819b;
        }
        C7309bd c7309bd = this.jyn;
        AppMethodBeat.m2505o(18026);
        return c7309bd;
    }

    /* renamed from: XO */
    public final C6977h mo45269XO() {
        AppMethodBeat.m2504i(18027);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18027);
            throw c1819b;
        }
        C6977h c6977h = this.jyo;
        AppMethodBeat.m2505o(18027);
        return c6977h;
    }

    /* renamed from: XR */
    public final C7310be mo45270XR() {
        AppMethodBeat.m2504i(18028);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18028);
            throw c1819b;
        }
        C7310be c7310be = this.jyp;
        AppMethodBeat.m2505o(18028);
        return c7310be;
    }

    public final C45160g aUo() {
        AppMethodBeat.m2504i(18029);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18029);
            throw c1819b;
        }
        C45160g c45160g = this.jyq;
        AppMethodBeat.m2505o(18029);
        return c45160g;
    }

    public final C30303d aUp() {
        AppMethodBeat.m2504i(18030);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18030);
            throw c1819b;
        }
        C30303d c30303d = this.jyr;
        AppMethodBeat.m2505o(18030);
        return c30303d;
    }

    /* renamed from: XV */
    public final C6663ag mo45271XV() {
        AppMethodBeat.m2504i(18031);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18031);
            throw c1819b;
        }
        C6663ag c6663ag = this.jyu;
        AppMethodBeat.m2505o(18031);
        return c6663ag;
    }

    public final C9720t all() {
        AppMethodBeat.m2504i(18032);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18032);
            throw c1819b;
        }
        C9720t c9720t = this.jyt;
        AppMethodBeat.m2505o(18032);
        return c9720t;
    }

    public final String amg() {
        AppMethodBeat.m2504i(18033);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18033);
            throw c1819b;
        }
        String str = this.eJM + "voice/";
        AppMethodBeat.m2505o(18033);
        return str;
    }

    /* renamed from: XY */
    public final String mo45272XY() {
        AppMethodBeat.m2504i(18034);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18034);
            throw c1819b;
        }
        String str = this.eJM + "voice2/";
        AppMethodBeat.m2505o(18034);
        return str;
    }

    /* renamed from: Yb */
    public final String mo45273Yb() {
        AppMethodBeat.m2504i(18035);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18035);
            throw c1819b;
        }
        String str = this.eJM + "emoji/";
        AppMethodBeat.m2505o(18035);
        return str;
    }

    public final C30066c aUq() {
        AppMethodBeat.m2504i(18036);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(18036);
            throw c1819b;
        }
        C30066c c30066c = this.jyx;
        AppMethodBeat.m2505o(18036);
        return c30066c;
    }

    public final void aVf() {
        AppMethodBeat.m2504i(18037);
        C4990ab.m7417i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", this.jBf, this.eJN, this.jBe, C5046bo.dpG());
        if (this.jBf == null || this.jBf.booleanValue()) {
            if (this.eJN != null) {
                C4990ab.m7417i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", this.eJN);
                this.eJN.closeDB();
                this.eJN = null;
            }
            if (this.jBe != null) {
                this.jBe.closeDB();
                this.jBe = null;
            }
            this.jBf = null;
            AppMethodBeat.m2505o(18037);
            return;
        }
        this.jBf = null;
        AppMethodBeat.m2505o(18037);
    }
}
