package com.tencent.p177mm.plugin.sns.model;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.memory.C32771g;
import com.tencent.p177mm.memory.C37899l;
import com.tencent.p177mm.memory.C42178c;
import com.tencent.p177mm.memory.C42181e.C42180a;
import com.tencent.p177mm.memory.C9631o;
import com.tencent.p177mm.memory.C9631o.C9633b;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C42185ar;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelsns.C32830c;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1573q.C40600a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p198aw.C25848g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18281hf;
import com.tencent.p177mm.p230g.p231a.C18356ow;
import com.tencent.p177mm.p230g.p231a.C18357ox;
import com.tencent.p177mm.p230g.p231a.C26132f;
import com.tencent.p177mm.p230g.p231a.C32572ib;
import com.tencent.p177mm.p230g.p231a.C32609ol;
import com.tencent.p177mm.p230g.p231a.C32624qz;
import com.tencent.p177mm.p230g.p231a.C32640tk;
import com.tencent.p177mm.p230g.p231a.C37759lr;
import com.tencent.p177mm.p230g.p231a.C37792rc;
import com.tencent.p177mm.p230g.p231a.C42022lj;
import com.tencent.p177mm.p230g.p231a.C42053rl;
import com.tencent.p177mm.p230g.p231a.C42056rt;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.p230g.p231a.C6470cp;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p230g.p231a.C6530og;
import com.tencent.p177mm.p230g.p231a.C9303bm;
import com.tencent.p177mm.p230g.p231a.C9308cn;
import com.tencent.p177mm.p230g.p231a.C9309co;
import com.tencent.p177mm.p230g.p231a.C9430of;
import com.tencent.p177mm.p230g.p231a.C9470sk;
import com.tencent.p177mm.p230g.p231a.C9482tw;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.C21894g;
import com.tencent.p177mm.plugin.sns.C21936p;
import com.tencent.p177mm.plugin.sns.C34933b;
import com.tencent.p177mm.plugin.sns.C34934d;
import com.tencent.p177mm.plugin.sns.C34936e;
import com.tencent.p177mm.plugin.sns.C34944m;
import com.tencent.p177mm.plugin.sns.C39730c;
import com.tencent.p177mm.plugin.sns.C39740k;
import com.tencent.p177mm.plugin.sns.C39763n;
import com.tencent.p177mm.plugin.sns.C46211f;
import com.tencent.p177mm.plugin.sns.C7092h;
import com.tencent.p177mm.plugin.sns.C7094j;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21905g;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C29039j;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C43552d;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C43554f;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C46214l;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C29032b;
import com.tencent.p177mm.plugin.sns.p1024b.C43537j;
import com.tencent.p177mm.plugin.sns.p1025h.C29037i;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.sns.p1557f.C39734a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13341f;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13348i;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C46208c;
import com.tencent.p177mm.plugin.sns.p516g.C21884c;
import com.tencent.p177mm.plugin.sns.p516g.C21893e;
import com.tencent.p177mm.plugin.sns.p516g.C43543g;
import com.tencent.p177mm.plugin.sns.p520ui.C43588ai;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39783a.C29089e;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C39787m;
import com.tencent.p177mm.plugin.sns.storage.C13477q;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C29096k;
import com.tencent.p177mm.plugin.sns.storage.C35001u;
import com.tencent.p177mm.plugin.sns.storage.C35003y;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
import com.tencent.p177mm.plugin.sns.storage.C43569d;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C43571f;
import com.tencent.p177mm.plugin.sns.storage.C43573m;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.sns.storage.C46238w;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.p604g.p607c.C35984d;
import com.tencent.p177mm.sdk.platformtools.C30284ar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5034bd.C5033a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tencent.mm.plugin.sns.model.af */
public final class C13373af implements C1816at, C43537j {
    public static boolean qKD = true;
    private static int qKE = 0;
    private static int qKF = 0;
    private static int qKK;
    private static int qKL;
    private static String qLl = "";
    protected static HashMap<Integer, C1366d> qLm = new HashMap();
    private static C7306ak qLu;
    private static int qLv = 103;
    private static Point qLw = new Point();
    private C7480h eJN;
    private byte[] eMl = new byte[0];
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private C4884c oMA = new C1337429();
    private C4946a qKG;
    private C4946a qKH;
    private C4946a qKI;
    private C4946a qKJ;
    private C13478s qKM;
    private C39789o qKN;
    private C43571f qKO;
    private C43569d qKP;
    private C35003y qKQ;
    private C21925g qKR;
    private C43573m qKS;
    private C29096k qKT;
    private C35001u qKU;
    private C21915ad qKV;
    private C3890a qKW;
    private C43558b qKX;
    private C29050aw qKY;
    private C43588ai qKZ;
    private C21936p qLA;
    private C7092h qLB;
    private C21894g qLC;
    private C34944m qLD;
    private C7094j qLE;
    private C34933b qLF;
    private C39730c qLG;
    private C46211f qLH;
    private C4884c qLI = new C133957();
    private C4884c qLJ = new C133998();
    private C4884c qLK = new C134069();
    private C4884c qLL = new C1340010();
    private C4884c qLM = new C1338711();
    private C4884c qLN = new C1336913();
    private C4884c qLO = new C1337014();
    private C4884c qLP = new C709715();
    private C4884c qLQ = new C709916();
    private C4884c qLR = new C1340217();
    private C4884c qLS = new C1338818();
    private C4884c qLT = new C1338419();
    private C4884c qLU = new C1337120();
    private C4884c qLV = new C1338521();
    private C4884c qLW = new C1338922();
    private C4884c qLX = new C1339024();
    private C4884c qLY = new C1339125();
    private C4884c qLZ = new C1340426();
    private C21884c qLa;
    private C43543g qLb;
    private C13477q qLc;
    private C13348i qLd;
    private C13411ao qLe = new C13411ao();
    private boolean qLf = false;
    private boolean qLg = true;
    private C46238w qLh = new C46238w();
    private boolean qLi = false;
    private byte[] qLj = new byte[0];
    private String qLk;
    private C34934d qLn;
    private C39734a qLo;
    private C39754ar qLp;
    private C43554f qLq = new C43554f();
    private C29039j qLr = new C29039j();
    private C43552d qLs = new C43552d();
    private C46214l qLt = new C46214l();
    private C39763n qLx;
    private C39740k qLy;
    private C34936e qLz;
    private C4884c qMa = new C1337227();
    private boolean qMb = false;
    private C4884c qMc = new C1339630();
    private C4884c qMd = new C1339231();

    /* renamed from: com.tencent.mm.plugin.sns.model.af$15 */
    class C709715 extends C4884c<C18357ox> {
        C709715() {
            AppMethodBeat.m2504i(36438);
            this.xxI = C18357ox.class.getName().hashCode();
            AppMethodBeat.m2505o(36438);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36439);
            final long j = (long) ((C18357ox) c4883b).cLl.cLm;
            C4990ab.m7411d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", Long.valueOf(j));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36437);
                    C34955aj.m57386CY((int) j);
                    C13373af.cnB().cmp();
                    C4879a.xxA.mo10055m(new C9482tw());
                    AppMethodBeat.m2505o(36437);
                }
            });
            AppMethodBeat.m2505o(36439);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$16 */
    class C709916 extends C4884c<C37792rc> {
        C709916() {
            AppMethodBeat.m2504i(36440);
            this.xxI = C37792rc.class.getName().hashCode();
            AppMethodBeat.m2505o(36440);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36441);
            C13373af.m21490a(C13373af.this);
            AppMethodBeat.m2505o(36441);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$13 */
    class C1336913 extends C4884c<C18281hf> {
        C1336913() {
            AppMethodBeat.m2504i(36432);
            this.xxI = C18281hf.class.getName().hashCode();
            AppMethodBeat.m2505o(36432);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36433);
            ((C18281hf) c4883b).cBZ.cCa = C13373af.cnF().cmn();
            AppMethodBeat.m2505o(36433);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$14 */
    class C1337014 extends C4884c<C42022lj> {
        C1337014() {
            AppMethodBeat.m2504i(36434);
            this.xxI = C42022lj.class.getName().hashCode();
            AppMethodBeat.m2505o(36434);
        }

        /* renamed from: a */
        private static boolean m21485a(C42022lj c42022lj) {
            AppMethodBeat.m2504i(36435);
            ArrayList arrayList = c42022lj.cHj.cCa;
            C39789o cnF = C13373af.cnF();
            C7480h Ru = C13373af.m21489Ru();
            long iV = Ru.mo15639iV(-1);
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    C46236n DK = cnF.mo62914DK((int) longValue);
                    if (DK != null) {
                        DK.field_localFlag |= 64;
                        C4990ab.m7411d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", Long.valueOf(longValue));
                        cnF.mo62928b((int) longValue, DK);
                    }
                }
                return false;
            } finally {
                Ru.mo15640mB(iV);
                AppMethodBeat.m2505o(36435);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$20 */
    class C1337120 extends C4884c<C9308cn> {
        C1337120() {
            AppMethodBeat.m2504i(36450);
            this.xxI = C9308cn.class.getName().hashCode();
            AppMethodBeat.m2505o(36450);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36451);
            C21893e.m33453YB("100004");
            C21893e.m33453YB("100007");
            AppMethodBeat.m2505o(36451);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$27 */
    class C1337227 extends C4884c<C37759lr> {
        C1337227() {
            AppMethodBeat.m2504i(36464);
            this.xxI = C37759lr.class.getName().hashCode();
            AppMethodBeat.m2505o(36464);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            String j;
            AppMethodBeat.m2504i(36465);
            C37759lr c37759lr = (C37759lr) c4883b;
            if (c37759lr.cHv.cvd == 1) {
                j = C39787m.cqn().mo62907j(c37759lr.cHv.pageId, c37759lr.cHv.cvq, c37759lr.cHv.cHx, c37759lr.cHv.cHy);
            } else {
                j = C39787m.cqn().mo62908n(C5046bo.anl(c37759lr.cHv.pageId), c37759lr.cHv.cHx, c37759lr.cHv.cHy);
            }
            c37759lr.cHw.cHz = j;
            AppMethodBeat.m2505o(36465);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$29 */
    class C1337429 extends C4884c<C45337kd> {
        C1337429() {
            AppMethodBeat.m2504i(36467);
            this.xxI = C45337kd.class.getName().hashCode();
            AppMethodBeat.m2505o(36467);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36468);
            C45337kd c45337kd = (C45337kd) c4883b;
            if (c45337kd instanceof C45337kd) {
                switch (c45337kd.cFz.action) {
                    case -6:
                        List<C46236n> bo = C13373af.cnF().mo62931bo(c45337kd.cFz.cFB.fKm, C1853r.m3846Yz().equals(c45337kd.cFz.cFB.fKm));
                        c45337kd.cFA.cAV = new ArrayList();
                        for (C46236n cqu : bo) {
                            c45337kd.cFA.cAV.add(C25848g.m41159a(C13373af.getAccPath(), cqu.cqu(), 8));
                        }
                        break;
                    case -5:
                        C39789o cnF = C13373af.cnF();
                        Cursor a = cnF.bSd.mo10104a("select *,rowid from SnsInfo where type = 4 AND  (sourceType & 2 != 0 ) " + C39789o.rfn, null, 2);
                        ArrayList<C46236n> arrayList = new ArrayList();
                        while (a.moveToNext()) {
                            C46236n c46236n = new C46236n();
                            c46236n.mo8995d(a);
                            arrayList.add(c46236n);
                        }
                        a.close();
                        c45337kd.cFA.cAV = new ArrayList();
                        for (C46236n cqu2 : arrayList) {
                            c45337kd.cFA.cAV.add(C25848g.m41159a(C13373af.getAccPath(), cqu2.cqu(), 1));
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(36468);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$2 */
    static class C133752 implements C1366d {
        C133752() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35001u.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$33 */
    static class C1337633 implements C1366d {
        C1337633() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39789o.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$34 */
    static class C1337734 implements C1366d {
        C1337734() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39789o.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$35 */
    static class C1337835 implements C1366d {
        C1337835() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43571f.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$3 */
    static class C133793 implements C1366d {
        C133793() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C13477q.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$28 */
    class C1338128 implements Runnable {
        C1338128() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36466);
            C13373af.m21491b(C13373af.this);
            AppMethodBeat.m2505o(36466);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$4 */
    class C133824 extends C42180a {
        final int qMg = 120;

        C133824(C42178c c42178c) {
            c42178c.getClass();
            super();
            AppMethodBeat.m2504i(36415);
            AppMethodBeat.m2505o(36415);
        }

        /* renamed from: Xb */
        public final long mo25488Xb() {
            return 10485760;
        }

        /* renamed from: Xc */
        public final int mo25489Xc() {
            return -1;
        }

        /* renamed from: Xa */
        public final /* synthetic */ Comparable mo25487Xa() {
            AppMethodBeat.m2504i(36416);
            Integer valueOf = Integer.valueOf(C1338a.fromDPToPix(C4996ah.getContext(), 120) * C1338a.fromDPToPix(C4996ah.getContext(), 120));
            AppMethodBeat.m2505o(36416);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$12 */
    static class C1338312 implements C1366d {
        C1338312() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43569d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$19 */
    class C1338419 extends C4884c<C6470cp> {
        C1338419() {
            AppMethodBeat.m2504i(36448);
            this.xxI = C6470cp.class.getName().hashCode();
            AppMethodBeat.m2505o(36448);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36449);
            C13373af.cnS();
            AppMethodBeat.m2505o(36449);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$21 */
    class C1338521 extends C4884c<C32640tk> {
        C1338521() {
            AppMethodBeat.m2504i(36452);
            this.xxI = C32640tk.class.getName().hashCode();
            AppMethodBeat.m2505o(36452);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36453);
            C4990ab.m7416i("MicroMsg.SnsCore", "triger snslogmgr try report");
            C13373af.cnz().cmh();
            AppMethodBeat.m2505o(36453);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$32 */
    static class C1338632 implements C1366d {
        C1338632() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C13478s.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$11 */
    class C1338711 extends C4884c<C32572ib> {
        C1338711() {
            AppMethodBeat.m2504i(36430);
            this.xxI = C32572ib.class.getName().hashCode();
            AppMethodBeat.m2505o(36430);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36431);
            ((C32572ib) c4883b).cDa.isResume = C13373af.cnM().csu();
            AppMethodBeat.m2505o(36431);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$18 */
    class C1338818 extends C4884c<C6530og> {
        C1338818() {
            AppMethodBeat.m2504i(36445);
            this.xxI = C6530og.class.getName().hashCode();
            AppMethodBeat.m2505o(36445);
        }

        /* renamed from: a */
        private static boolean m21512a(C6530og c6530og) {
            AppMethodBeat.m2504i(36446);
            try {
                SnsAdClick snsAdClick = c6530og.cKA.cKz;
                C43570e ku = C13373af.cnI().mo69174ku(snsAdClick.cND);
                if (ku == null) {
                    AppMethodBeat.m2505o(36446);
                    return false;
                }
                C21980a cqr;
                C46236n cqB = ku.cqB();
                if (snsAdClick.cvd == 2) {
                    cqr = cqB.cqr();
                } else {
                    cqr = cqB.cqq();
                }
                if (cqr != null) {
                    if (snsAdClick.cvd == 2) {
                        C4990ab.m7416i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
                    } else {
                        C4990ab.m7416i("MicroMsg.SnsCore", "report ad h5 load");
                    }
                    C7060h.pYm.mo8381e(16972, Long.valueOf(snsAdClick.cND), Integer.valueOf(snsAdClick.fPY), cqr.qPj, Integer.valueOf(cqB.cre()), cqB.cqu().rjC, c6530og.cKA.url, Integer.valueOf(c6530og.cKA.cKB), Integer.valueOf(c6530og.cKA.errorCode), Long.valueOf(c6530og.cKA.timestamp));
                    AppMethodBeat.m2505o(36446);
                    return true;
                }
                AppMethodBeat.m2505o(36446);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsCore", e, "report load ad h5 error", new Object[0]);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$22 */
    class C1338922 extends C4884c<C32624qz> {
        C1338922() {
            AppMethodBeat.m2504i(36454);
            this.xxI = C32624qz.class.getName().hashCode();
            AppMethodBeat.m2505o(36454);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36455);
            C34955aj.cnY();
            C13373af.cnF().bSd.mo10108hY("SnsInfo", "delete from SnsInfo");
            C13373af.cnJ().mo69176YU("@__weixintimtline");
            AppMethodBeat.m2505o(36455);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$24 */
    class C1339024 extends C4884c<C32609ol> {
        C1339024() {
            AppMethodBeat.m2504i(36456);
            this.xxI = C32609ol.class.getName().hashCode();
            AppMethodBeat.m2505o(36456);
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x00d0=Splitter:B:14:0x00d0, B:27:0x0230=Splitter:B:27:0x0230} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private static boolean m21515a(C32609ol c32609ol) {
            AppMethodBeat.m2504i(36457);
            SnsAdClick snsAdClick = c32609ol.cKM.cKz;
            try {
                if (c32609ol.cKM.cKN == 1) {
                    if (snsAdClick.fQb == 1) {
                        C13348i cnz;
                        int i;
                        int i2;
                        int cqs;
                        Object[] objArr;
                        Object[] objArr2;
                        C43570e ku = C13373af.cnI().mo69174ku(snsAdClick.cND);
                        Object[] objArr3;
                        if (ku == null || !ku.coX()) {
                            cnz = C13373af.cnz();
                            i = 13155;
                            objArr3 = new Object[7];
                            objArr3[0] = Long.valueOf(snsAdClick.cND);
                            objArr3[1] = ku.cqq().qPj;
                            objArr3[2] = Integer.valueOf(snsAdClick.fPY);
                            objArr3[3] = Long.valueOf(snsAdClick.startTime);
                            objArr3[4] = Long.valueOf(System.currentTimeMillis());
                            i2 = 5;
                            if (ku != null) {
                                cqs = ku.cqs();
                                objArr = objArr3;
                                objArr2 = objArr3;
                            } else {
                                cqs = -1;
                                objArr = objArr3;
                                objArr2 = objArr3;
                            }
                        } else {
                            cnz = C13373af.cnz();
                            i = 14647;
                            objArr3 = new Object[7];
                            objArr3[0] = Long.valueOf(snsAdClick.cND);
                            objArr3[1] = ku.cqq().qPj;
                            objArr3[2] = Integer.valueOf(snsAdClick.fPY);
                            objArr3[3] = Long.valueOf(snsAdClick.startTime);
                            objArr3[4] = Long.valueOf(System.currentTimeMillis());
                            i2 = 5;
                            cqs = ku.cqs();
                            objArr = objArr3;
                            objArr2 = objArr3;
                        }
                        objArr[i2] = Integer.valueOf(cqs);
                        objArr2[6] = "";
                        cnz.mo25454e(i, objArr2);
                        C37952b lZ = C37952b.m64171lZ(750);
                        lZ.mo60722tx(snsAdClick.cND).mo60722tx(ku.cqq().qPj).mo60720mb(snsAdClick.fPY).mo60722tx(snsAdClick.startTime).mo60722tx(System.currentTimeMillis());
                        lZ.ajK();
                    } else {
                        C43570e ku2 = C13373af.cnI().mo69174ku(snsAdClick.cND);
                        String str = (C13341f.m21438a(snsAdClick.cND, snsAdClick, ku2.cqq().qPj, Integer.valueOf(snsAdClick.fPY), Long.valueOf(snsAdClick.startTime), Long.valueOf(System.currentTimeMillis())) + String.format(",%s", new Object[]{snsAdClick.fQc})) + String.format(",%s", new Object[]{((System.currentTimeMillis() - snsAdClick.startTime) - snsAdClick.fQe)});
                        if (ku2 == null || !ku2.coX()) {
                            C13373af.cnz().mo25454e(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_READ_FAILED, str);
                        } else {
                            C13373af.cnz().mo25454e(14643, str);
                        }
                        C37952b lZ2 = C37952b.m64171lZ(733);
                        lZ2.mo60722tx(snsAdClick.cND).mo60722tx(ku2.cqq().qPj).mo60720mb(snsAdClick.fPY).mo60722tx(snsAdClick.startTime).mo60722tx(System.currentTimeMillis());
                        lZ2.ajK();
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsCore", e, "report ad click error", new Object[0]);
            }
            AppMethodBeat.m2505o(36457);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$25 */
    class C1339125 extends C4884c<C42056rt> {
        C1339125() {
            AppMethodBeat.m2504i(36459);
            this.xxI = C42056rt.class.getName().hashCode();
            AppMethodBeat.m2505o(36459);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36461);
            boolean cnT = C1339125.cnT();
            AppMethodBeat.m2505o(36461);
            return cnT;
        }

        private static boolean cnT() {
            AppMethodBeat.m2504i(36460);
            C21905g.cmv();
            C5127a c5127a = C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKFULLSCREEN_STRING_SYNC;
            C29037i c29037i = new C29037i();
            try {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(c5127a, new String(c29037i.toByteArray(), Charset.forName("ISO-8859-1")));
            } catch (IOException e) {
                C4990ab.m7420w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
            }
            AppMethodBeat.m2505o(36460);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$31 */
    class C1339231 extends C4884c<C18356ow> {
        C1339231() {
            AppMethodBeat.m2504i(36472);
            this.xxI = C18356ow.class.getName().hashCode();
            AppMethodBeat.m2505o(36472);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36473);
            C18356ow c18356ow = (C18356ow) c4883b;
            final ArrayList arrayList = c18356ow.cLi.cLj;
            final String str = c18356ow.cLi.cLk;
            C4990ab.m7416i("MicroMsg.SnsCore", "ResendSnsByUpdateXmlEvent, try resend sns");
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36471);
                    C3889am.m6179e(arrayList, str);
                    AppMethodBeat.m2505o(36471);
                }
            });
            AppMethodBeat.m2505o(36473);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$5 */
    class C133945 extends C42180a {
        C133945(C9631o c9631o) {
            c9631o.getClass();
            super();
            AppMethodBeat.m2504i(36417);
            AppMethodBeat.m2505o(36417);
        }

        /* renamed from: Xb */
        public final long mo25488Xb() {
            return -1;
        }

        /* renamed from: Xc */
        public final int mo25489Xc() {
            return 3;
        }

        /* renamed from: Xa */
        public final /* synthetic */ Comparable mo25487Xa() {
            AppMethodBeat.m2504i(36418);
            C9633b c9633b = new C9633b(320, 240);
            AppMethodBeat.m2505o(36418);
            return c9633b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$7 */
    class C133957 extends C4884c<C6523mp> {
        C133957() {
            AppMethodBeat.m2504i(36421);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(36421);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = true;
            AppMethodBeat.m2504i(36422);
            int i = C26373g.m41964Nu().getInt("SnsHEVCSwitch", 0);
            int i2 = C26373g.m41964Nu().getInt("SnsWXPCSwitch", 0);
            boolean z2 = i == 1;
            if (i2 != 1) {
                z = false;
            }
            Editor edit = C30284ar.m48183s(C4996ah.getContext(), "sp_sns_dynswitch_stg", 4).edit();
            edit.putBoolean("sw_use_vcodec_img", z2);
            edit.putBoolean("sw_use_wxpc_img", z);
            edit.commit();
            AppMethodBeat.m2505o(36422);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$30 */
    class C1339630 extends C4884c<C42053rl> {
        C1339630() {
            AppMethodBeat.m2504i(36469);
            this.xxI = C42053rl.class.getName().hashCode();
            AppMethodBeat.m2505o(36469);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36470);
            C42053rl c42053rl = (C42053rl) c4883b;
            if (c42053rl instanceof C42053rl) {
                C21904b.m33474kT(c42053rl.cNu.key);
            }
            AppMethodBeat.m2505o(36470);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$36 */
    static class C1339736 implements C1366d {
        C1339736() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43573m.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$37 */
    static class C1339837 implements C1366d {
        C1339837() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C29096k.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$8 */
    class C133998 extends C4884c<C26132f> {
        C133998() {
            AppMethodBeat.m2504i(36423);
            this.xxI = C26132f.class.getName().hashCode();
            AppMethodBeat.m2505o(36423);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36424);
            String str = ((C26132f) c4883b).crT.crU;
            if (!C5046bo.isNullOrNil(str)) {
                C43555a.m77861XB(str);
            }
            AppMethodBeat.m2505o(36424);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$10 */
    class C1340010 extends C4884c<C9470sk> {
        C1340010() {
            AppMethodBeat.m2504i(36428);
            this.xxI = C9470sk.class.getName().hashCode();
            AppMethodBeat.m2505o(36428);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36429);
            final C9470sk c9470sk = (C9470sk) c4883b;
            if (c9470sk.cOH.czE != 9 && c9470sk.cOH.czE == 7) {
                new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(36427);
                        int i = (int) c9470sk.cOH.cOJ;
                        C29096k cnK = C13373af.cnK();
                        String concat = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= ".concat(String.valueOf(i));
                        C4990ab.m7416i("MicroMsg.SnsCommentStorage", "updateToread ".concat(String.valueOf(concat)));
                        C4990ab.m7416i("MicroMsg.SnsCore", "update msg read ".concat(String.valueOf(cnK.fni.mo10108hY("SnsComment", concat))));
                        C7101u.cna();
                        AppMethodBeat.m2505o(36427);
                    }
                });
            }
            AppMethodBeat.m2505o(36429);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$17 */
    class C1340217 extends C4884c<C9430of> {
        C1340217() {
            AppMethodBeat.m2504i(36442);
            this.xxI = C9430of.class.getName().hashCode();
            AppMethodBeat.m2505o(36442);
        }

        /* renamed from: a */
        private static boolean m21528a(C9430of c9430of) {
            AppMethodBeat.m2504i(36443);
            try {
                SnsAdClick snsAdClick = c9430of.cKy.cKz;
                C43570e ku = C13373af.cnI().mo69174ku(snsAdClick.cND);
                if (ku == null) {
                    AppMethodBeat.m2505o(36443);
                    return false;
                }
                C21980a cqr;
                C46236n cqB = ku.cqB();
                if (snsAdClick.cvd == 2) {
                    cqr = cqB.cqr();
                } else {
                    cqr = cqB.cqq();
                }
                if (cqr != null) {
                    C1207m c46208c;
                    if (snsAdClick.cvd == 2) {
                        C4990ab.m7416i("MicroMsg.SnsCore", "at_friend_detail report ad click");
                        c46208c = new C46208c(snsAdClick.cND, cqr.hnw, snsAdClick.fPZ, snsAdClick.fQa, snsAdClick.fPY, "", cqB.crf(), cqB.cqu().rjC, snsAdClick.fQf, cqB.crd().cqy(), cqB.crd().cqz());
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c46208c, 0);
                    } else {
                        C4990ab.m7416i("MicroMsg.SnsCore", "report ad click");
                        c46208c = new C46208c(snsAdClick.cND, cqr.hnw, snsAdClick.fPZ, snsAdClick.fQa, snsAdClick.fPY, "", cqB.crf(), cqB.cqu().rjC, snsAdClick.fQf, cqB.crd().cqw(), cqB.crd().cqx());
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c46208c, 0);
                    }
                    AppMethodBeat.m2505o(36443);
                    return true;
                }
                AppMethodBeat.m2505o(36443);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsCore", e, "report ad click error", new Object[0]);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$23 */
    static class C1340323 implements C1366d {
        C1340323() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35003y.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$26 */
    class C1340426 extends C4884c<C9303bm> {
        C1340426() {
            AppMethodBeat.m2504i(36462);
            this.xxI = C9303bm.class.getName().hashCode();
            AppMethodBeat.m2505o(36462);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36463);
            C43573m cnJ = C13373af.cnJ();
            System.currentTimeMillis();
            boolean hY = cnJ.bSd.mo10108hY("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';");
            C4990ab.m7417i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", "update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(hY));
            AppMethodBeat.m2505o(36463);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$6 */
    class C134056 extends C42180a {
        C134056(C32771g c32771g) {
            c32771g.getClass();
            super();
            AppMethodBeat.m2504i(36419);
            AppMethodBeat.m2505o(36419);
        }

        /* renamed from: Xb */
        public final long mo25488Xb() {
            return 0;
        }

        /* renamed from: Xc */
        public final int mo25489Xc() {
            return 5;
        }

        /* renamed from: Xa */
        public final /* synthetic */ Comparable mo25487Xa() {
            AppMethodBeat.m2504i(36420);
            Integer valueOf = Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(36420);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.af$9 */
    class C134069 extends C4884c<C9309co> {
        C134069() {
            AppMethodBeat.m2504i(36425);
            this.xxI = C9309co.class.getName().hashCode();
            AppMethodBeat.m2505o(36425);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36426);
            C1720g.m3537RQ();
            String str = C1720g.m3536RP().cachePath;
            C1720g.m3537RQ();
            String str2 = C1720g.m3536RP().eJL;
            C4990ab.m7417i("MicroMsg.SnsCore", "dump %s", str2);
            str = str + "SnsMicroMsg.db";
            C5730e.deleteFile(str2 + "sns.dump");
            C5730e.m8644y(str, str2 + "sns.dump");
            AppMethodBeat.m2505o(36426);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(36524);
        qLm.put(Integer.valueOf("CanvasInfo".hashCode()), new C1338312());
        qLm.put(Integer.valueOf("UxCanvasInfo".hashCode()), new C1340323());
        qLm.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new C1338632());
        qLm.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new C1337633());
        qLm.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new C1337734());
        qLm.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new C1337835());
        qLm.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new C1339736());
        qLm.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new C1339837());
        qLm.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new C133752());
        qLm.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new C133793());
        AppMethodBeat.m2505o(36524);
    }

    public static String getAccPath() {
        AppMethodBeat.m2504i(36474);
        C1720g.m3534RN().mo5159QU();
        C1720g.m3537RQ();
        String str = C1720g.m3536RP().eJM;
        AppMethodBeat.m2505o(36474);
        return str;
    }

    public static String cnk() {
        AppMethodBeat.m2504i(36475);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        AppMethodBeat.m2505o(36475);
        return str;
    }

    public static int cnl() {
        AppMethodBeat.m2504i(36476);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        int QF = C1668a.m3383QF();
        AppMethodBeat.m2505o(36476);
        return QF;
    }

    /* renamed from: Ru */
    public static C7480h m21489Ru() {
        AppMethodBeat.m2504i(36477);
        C7480h c7480h = C13373af.cnm().eJN;
        AppMethodBeat.m2505o(36477);
        return c7480h;
    }

    private static C13373af cnm() {
        AppMethodBeat.m2504i(36478);
        C13373af c13373af = (C13373af) C7485q.m12925Y(C13373af.class);
        if (!c13373af.qLi) {
            synchronized (c13373af.qLj) {
                try {
                    if (!c13373af.qLi) {
                        C4990ab.m7416i("MicroMsg.SnsCore", "onAccInit because bug!");
                        c13373af.mo5393bz(true);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(36478);
                    }
                }
            }
        }
        if (c13373af.qLf) {
            synchronized (c13373af.eMl) {
                try {
                    C4990ab.m7416i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + c13373af.hashCode());
                    if (c13373af.qLf) {
                        c13373af.qLg = false;
                        C46238w c46238w = c13373af.qLh;
                        HashMap hashMap = qLm;
                        if (c46238w.rfK) {
                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "pass hasTrim");
                        } else {
                            C1720g.m3537RQ();
                            if (C1720g.m3534RN().mo5161QY()) {
                                int i = C5046bo.getInt(C26373g.m41964Nu().getValue("AndroidCleanSnsDb"), 0);
                                C4990ab.m7416i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
                                if (i <= 0) {
                                    C1720g.m3537RQ();
                                    String str = C1720g.m3536RP().cachePath;
                                    if (C5730e.m8628ct(str + "SnsMicroMsg2.db.ini")) {
                                        C46238w.m86491Zq(str);
                                        C5730e.deleteFile(str + "SnsMicroMsg2.db.ini");
                                    }
                                    SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
                                    if (C5046bo.m7549fp(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                        C4990ab.m7416i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                                    } else {
                                        sharedPreferences.edit().putLong("check_trim_time", C5046bo.anT()).commit();
                                        c46238w.rfK = true;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        int On = C40600a.m70011On();
                                        if (On == 1 || On == 2) {
                                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                        } else {
                                            if (C5730e.m8628ct(str + "sns_mark.ini")) {
                                                if (C5046bo.m7566gb(C5730e.ata(str + "sns_mark.ini")) < 2592000000L) {
                                                    C4990ab.m7416i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                                    C46238w.m86491Zq(str);
                                                } else {
                                                    C5730e.deleteFile(str + "sns_mark.ini");
                                                }
                                            }
                                            long asZ = C5730e.asZ(str + "SnsMicroMsg.db");
                                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(asZ)));
                                            if (asZ < 52428800) {
                                                C4990ab.m7416i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                            } else {
                                                C5730e.atc(str + "sns_mark.ini");
                                                String str2 = str + "SnsMicroMsg2.db";
                                                C7480h c7480h = new C7480h();
                                                C1819b c1819b;
                                                if (c7480h.mo16661b(str2, null, false)) {
                                                    C7480h c7480h2 = new C7480h();
                                                    if (c7480h2.mo16661b(str + "SnsMicroMsg.db", hashMap, true)) {
                                                        long currentTimeMillis2;
                                                        long currentTimeMillis3 = System.currentTimeMillis();
                                                        if (C46238w.m86493a(c7480h2, c7480h)) {
                                                            currentTimeMillis2 = System.currentTimeMillis();
                                                            str2 = "snsExtInfo3";
                                                            C46238w.m86492a(c7480h2, c7480h, str2);
                                                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + c7480h.mo10108hY("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                            str2 = "SnsComment";
                                                            C46238w.m86492a(c7480h2, c7480h, str2);
                                                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + c7480h.mo10108hY("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                            str2 = "SnsInfo";
                                                            C46238w.m86492a(c7480h2, c7480h, str2);
                                                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + c7480h.mo10108hY("", "insert into " + str2 + " select * from old." + str2 + " where  (sourceType & 2 != 0 ) " + C39789o.rfn + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                            boolean hY = c7480h.mo10108hY("", "update snsExtinfo3 set md5 = '', faults = '';");
                                                            C4990ab.m7417i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Boolean.valueOf(hY));
                                                            c7480h.mo10108hY("", "DETACH DATABASE old");
                                                            On = 1;
                                                        } else {
                                                            On = -1;
                                                        }
                                                        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis3;
                                                        C4990ab.m7417i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(On)), Long.valueOf(currentTimeMillis2));
                                                        c7480h2.closeDB();
                                                        c7480h.closeDB();
                                                        if (On >= 0) {
                                                            C1720g.m3537RQ();
                                                            String str3 = C1720g.m3536RP().cachePath;
                                                            C5730e.deleteFile(str3 + "SnsMicroMsg.db");
                                                            C4990ab.m7416i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(C5730e.m8633h(str3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
                                                            C5730e.deleteFile(str3 + "SnsMicroMsg.db-shm");
                                                            C5730e.deleteFile(str3 + "SnsMicroMsg.db-wal");
                                                            C5730e.deleteFile(str3 + "SnsMicroMsg.db.ini");
                                                            C5730e.m8644y("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                            C5730e.deleteFile(str3 + "SnsMicroMsg2.db.ini");
                                                            C5730e.deleteFile(str3 + "SnsMicroMsg2.db");
                                                            C5730e.deleteFile(str3 + "sns_mark.ini");
                                                        }
                                                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                        C4990ab.m7417i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", Integer.valueOf(On), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis4 - currentTimeMillis2));
                                                        C4990ab.m7416i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                                    } else {
                                                        c1819b = new C1819b((byte) 0);
                                                        AppMethodBeat.m2505o(36478);
                                                        throw c1819b;
                                                    }
                                                }
                                                c1819b = new C1819b((byte) 0);
                                                AppMethodBeat.m2505o(36478);
                                                throw c1819b;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (c13373af.eJN == null) {
                            c13373af.eJN = new C7480h();
                            C1720g.m3537RQ();
                            if (!c13373af.eJN.mo16661b(C1720g.m3536RP().cachePath + "SnsMicroMsg.db", qLm, true)) {
                                Object sQLiteException = new SQLiteException("sns db init failed");
                                throw sQLiteException;
                            }
                        }
                        c13373af.qLf = false;
                        C4990ab.m7416i("MicroMsg.SnsCore", "resetdb done");
                    }
                } finally {
                    AppMethodBeat.m2505o(36478);
                }
            }
        }
        AppMethodBeat.m2505o(36478);
        return c13373af;
    }

    public static boolean cnn() {
        AppMethodBeat.m2504i(36479);
        C13373af.cnm();
        if (C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(36479);
            return false;
        }
        AppMethodBeat.m2505o(36479);
        return true;
    }

    public C13373af() {
        AppMethodBeat.m2504i(36480);
        C4990ab.m7416i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        if (this.qKI == null) {
            this.qKI = C35984d.m59189a("SnsCore_CDNDownload_handler", new LinkedBlockingQueue());
        }
        if (this.qKH == null) {
            this.qKH = C35984d.m59189a("SnsCore_thumbDecode_handler", new LinkedBlockingQueue());
        }
        if (this.qKG == null) {
            this.qKG = C35984d.anP("SnsCore#File");
        }
        if (this.qKJ == null) {
            this.qKJ = C35984d.anP("SnsCore#Task");
        }
        int largeMemoryClass = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        if (largeMemoryClass > 256) {
            if (VERSION.SDK_INT == 24 || VERSION.SDK_INT == 25) {
                largeMemoryClass = 3;
            } else {
                largeMemoryClass = 6;
            }
        } else if (largeMemoryClass > 128) {
            largeMemoryClass = 4;
        } else {
            largeMemoryClass = 2;
        }
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36414);
                C1742b.m3596SM().mo5277a("R.layout.sns_timeline_item_photo_one3", largeMemoryClass, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_timeline_imagesline_one", largeMemoryClass, 2131827717, 2130970819, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_timeline_imagesline1", largeMemoryClass, 2131827717, 2130970816, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_timeline_imagesline2", largeMemoryClass, 2131827717, 2130970817, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_timeline_imagesline3", largeMemoryClass, 2131827717, 2130970818, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_media_sub_item2", largeMemoryClass, 2131827717, 2130970780, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_media_sight_item", largeMemoryClass, 2131827717, 2130970778, 2131827911, 0);
                C1742b.m3596SM().mo5277a("R.layout.sns_hb_reward_item", largeMemoryClass, 2131827717, 2130970763, 2131827911, 0);
                AppMethodBeat.m2505o(36414);
            }
        }, 3000);
        AppMethodBeat.m2505o(36480);
    }

    public static C7306ak cno() {
        AppMethodBeat.m2504i(36481);
        if (qLu == null) {
            qLu = new C7306ak("MicroMsg.SnsCore#WorkingHandler");
        }
        C7306ak c7306ak = qLu;
        AppMethodBeat.m2505o(36481);
        return c7306ak;
    }

    public static C4946a cnp() {
        AppMethodBeat.m2504i(36482);
        C4946a c4946a = C13373af.cnm().qKI;
        AppMethodBeat.m2505o(36482);
        return c4946a;
    }

    public static C4946a cnq() {
        AppMethodBeat.m2504i(36483);
        C4946a c4946a = C13373af.cnm().qKH;
        AppMethodBeat.m2505o(36483);
        return c4946a;
    }

    protected static C4946a cnr() {
        AppMethodBeat.m2504i(36484);
        C4946a c4946a = C13373af.cnm().qKG;
        AppMethodBeat.m2505o(36484);
        return c4946a;
    }

    public static C4946a cns() {
        AppMethodBeat.m2504i(36485);
        C4946a c4946a = C13373af.cnm().qKJ;
        AppMethodBeat.m2505o(36485);
        return c4946a;
    }

    public static C7306ak bCo() {
        AppMethodBeat.m2504i(36486);
        C7306ak c7306ak = C13373af.cnm().handler;
        AppMethodBeat.m2505o(36486);
        return c7306ak;
    }

    public static String getAccSnsPath() {
        AppMethodBeat.m2504i(36487);
        String accSnsPath = ((C29032b) C1720g.m3530M(C29032b.class)).getAccSnsPath();
        AppMethodBeat.m2505o(36487);
        return accSnsPath;
    }

    public static String getAccSnsTmpPath() {
        AppMethodBeat.m2504i(36488);
        String accSnsTmpPath = ((C29032b) C1720g.m3530M(C29032b.class)).getAccSnsTmpPath();
        AppMethodBeat.m2505o(36488);
        return accSnsTmpPath;
    }

    public static C7309bd cnt() {
        AppMethodBeat.m2504i(36489);
        C1720g.m3537RQ();
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        AppMethodBeat.m2505o(36489);
        return XM;
    }

    public static C13478s cnu() {
        AppMethodBeat.m2504i(36490);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKM == null) {
            C13373af.cnm().qKM = new C13478s(C13373af.cnm().eJN);
        }
        C13478s c13478s = C13373af.cnm().qKM;
        AppMethodBeat.m2505o(36490);
        return c13478s;
    }

    public static C3890a cnv() {
        AppMethodBeat.m2504i(36491);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKW == null) {
            C13373af.cnm().qKW = new C3890a();
            C21877n.qFC = C13373af.cnm().qKW;
        }
        C3890a c3890a = C13373af.cnm().qKW;
        AppMethodBeat.m2505o(36491);
        return c3890a;
    }

    public static C21884c cnw() {
        AppMethodBeat.m2504i(36492);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qLa == null) {
            C13373af.cnm().qLa = new C21884c();
        }
        C21884c c21884c = C13373af.cnm().qLa;
        AppMethodBeat.m2505o(36492);
        return c21884c;
    }

    public static C43543g cnx() {
        AppMethodBeat.m2504i(36493);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qLb == null) {
            C13373af.cnm().qLb = new C43543g();
        }
        C43543g c43543g = C13373af.cnm().qLb;
        AppMethodBeat.m2505o(36493);
        return c43543g;
    }

    public static C13477q cny() {
        AppMethodBeat.m2504i(36494);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qLc == null) {
            C13373af.cnm().qLc = new C13477q(C13373af.cnm().eJN);
        }
        C13477q c13477q = C13373af.cnm().qLc;
        AppMethodBeat.m2505o(36494);
        return c13477q;
    }

    public static C13348i cnz() {
        AppMethodBeat.m2504i(36495);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qLd == null) {
            C13373af.cnm().qLd = new C13348i();
        }
        C13348i c13348i = C13373af.cnm().qLd;
        AppMethodBeat.m2505o(36495);
        return c13348i;
    }

    public static C43558b cnA() {
        AppMethodBeat.m2504i(36496);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKX == null) {
            C13373af.cnm().qKX = new C43558b();
        }
        C43558b c43558b = C13373af.cnm().qKX;
        AppMethodBeat.m2505o(36496);
        return c43558b;
    }

    public static C29050aw cnB() {
        AppMethodBeat.m2504i(36497);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKY == null) {
            C13373af.cnm().qKY = new C29050aw();
            C21877n.qFw = C13373af.cnm().qKY;
        }
        C29050aw c29050aw = C13373af.cnm().qKY;
        AppMethodBeat.m2505o(36497);
        return c29050aw;
    }

    public static C21925g cnC() {
        AppMethodBeat.m2504i(36498);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKR == null) {
            C13373af.cnm().qKR = new C21925g();
            C21877n.qFx = C13373af.cnm().qKR;
        }
        C21925g c21925g = C13373af.cnm().qKR;
        AppMethodBeat.m2505o(36498);
        return c21925g;
    }

    public static C39754ar cnD() {
        AppMethodBeat.m2504i(36499);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qLp == null) {
            C13373af.cnm().qLp = new C39754ar();
        }
        C39754ar c39754ar = C13373af.cnm().qLp;
        AppMethodBeat.m2505o(36499);
        return c39754ar;
    }

    public static C21915ad cnE() {
        AppMethodBeat.m2504i(36500);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKV == null) {
            C13373af cnm = C13373af.cnm();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            cnm.qKV = new C21915ad(stringBuilder.append(C1720g.m3536RP().cachePath).append("snsAsyncQueue.data").toString());
        }
        C21915ad c21915ad = C13373af.cnm().qKV;
        AppMethodBeat.m2505o(36500);
        return c21915ad;
    }

    public static C39789o cnF() {
        AppMethodBeat.m2504i(36501);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKN == null) {
            C13373af.cnm().qKN = new C39789o(C13373af.cnm().eJN);
            C21877n.qFD = C13373af.cnm().qKN;
        }
        C39789o c39789o = C13373af.cnm().qKN;
        AppMethodBeat.m2505o(36501);
        return c39789o;
    }

    public static C43569d cnG() {
        AppMethodBeat.m2504i(36502);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKP == null) {
            C13373af.cnm().qKP = new C43569d(C13373af.cnm().eJN);
        }
        C43569d c43569d = C13373af.cnm().qKP;
        AppMethodBeat.m2505o(36502);
        return c43569d;
    }

    public static C35003y cnH() {
        AppMethodBeat.m2504i(36503);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKQ == null) {
            C13373af.cnm().qKQ = new C35003y(C13373af.cnm().eJN);
        }
        C35003y c35003y = C13373af.cnm().qKQ;
        AppMethodBeat.m2505o(36503);
        return c35003y;
    }

    public static C43571f cnI() {
        AppMethodBeat.m2504i(36504);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKO == null) {
            C13373af.cnm().qKO = new C43571f(C13373af.cnm().eJN);
        }
        C43571f c43571f = C13373af.cnm().qKO;
        AppMethodBeat.m2505o(36504);
        return c43571f;
    }

    public static C43573m cnJ() {
        AppMethodBeat.m2504i(36505);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKS == null) {
            C13373af.cnm().qKS = new C43573m(C13373af.cnm().eJN, new C39750ah());
            C21877n.qFy = C13373af.cnm().qKS;
        }
        C43573m c43573m = C13373af.cnm().qKS;
        AppMethodBeat.m2505o(36505);
        return c43573m;
    }

    public static C29096k cnK() {
        AppMethodBeat.m2504i(36506);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKT == null) {
            C13373af.cnm().qKT = new C29096k(C13373af.cnm().eJN);
            C21877n.qFz = C13373af.cnm().qKT;
        }
        C29096k c29096k = C13373af.cnm().qKT;
        AppMethodBeat.m2505o(36506);
        return c29096k;
    }

    public static C35001u cnL() {
        AppMethodBeat.m2504i(36507);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKU == null) {
            C13373af.cnm().qKU = new C35001u(C13373af.cnm().eJN);
            C21877n.qFA = C13373af.cnm().qKU;
        }
        C35001u c35001u = C13373af.cnm().qKU;
        AppMethodBeat.m2505o(36507);
        return c35001u;
    }

    public static C43588ai cnM() {
        AppMethodBeat.m2504i(36508);
        C1720g.m3534RN().mo5159QU();
        if (C13373af.cnm().qKZ == null) {
            C13373af.cnm().qKZ = new C43588ai();
        }
        C43588ai c43588ai = C13373af.cnm().qKZ;
        AppMethodBeat.m2505o(36508);
        return c43588ai;
    }

    public static int cnN() {
        int i;
        AppMethodBeat.m2504i(36509);
        if (C13373af.bPg().y < C13373af.bPg().x) {
            i = C13373af.bPg().y;
        } else {
            i = C13373af.bPg().x - C1338a.fromDPToPix(C4996ah.getContext(), qLv);
        }
        i /= 3;
        qKK = i;
        if (i <= 10) {
            C4990ab.m7412e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
            AppMethodBeat.m2505o(36509);
            return 150;
        }
        i = qKK;
        AppMethodBeat.m2505o(36509);
        return i;
    }

    public static int cnO() {
        AppMethodBeat.m2504i(36510);
        if (qKL <= 0) {
            qKL = 200;
            qKL = C1338a.fromDPToPix(C4996ah.getContext(), qKL);
        }
        int i = qKL;
        AppMethodBeat.m2505o(36510);
        return i;
    }

    private static Point bPg() {
        AppMethodBeat.m2504i(36511);
        WindowManager windowManager = (WindowManager) C4996ah.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        qLw.x = displayMetrics.widthPixels;
        qLw.y = displayMetrics.heightPixels;
        Point point = qLw;
        AppMethodBeat.m2505o(36511);
        return point;
    }

    public static boolean cnP() {
        boolean z;
        AppMethodBeat.m2504i(36512);
        SharedPreferences s = C30284ar.m48183s(C4996ah.getContext(), "sp_sns_dynswitch_stg", 4);
        if (s.contains("st_sw_use_vcodec_img")) {
            z = s.getBoolean("st_sw_use_vcodec_img", false);
            C4990ab.m7421w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", Boolean.valueOf(z));
        } else {
            z = s.getBoolean("sw_use_vcodec_img", false);
            C4990ab.m7411d("MicroMsg.SnsCore", "isUseVCodecImg: %b", Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(36512);
        return z;
    }

    public static boolean cnQ() {
        boolean z;
        AppMethodBeat.m2504i(36513);
        SharedPreferences s = C30284ar.m48183s(C4996ah.getContext(), "sp_sns_dynswitch_stg", 4);
        if (s.contains("st_sw_use_wxpc_img")) {
            z = s.getBoolean("st_sw_use_wxpc_img", false);
            C4990ab.m7421w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", Boolean.valueOf(z));
        } else {
            z = s.getBoolean("sw_use_wxpc_img", false);
            C4990ab.m7411d("MicroMsg.SnsCore", "isUseWxpcImg: %b", Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(36513);
        return z;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(36514);
        C1202f cnz = C13373af.cnz();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1802, cnz);
        C13411ao c13411ao = this.qLe;
        C4879a.xxA.mo10053d(c13411ao.qML);
        C4879a.xxA.mo10053d(c13411ao.qMM);
        C4879a.xxA.mo10053d(c13411ao.qMN);
        C4879a.xxA.mo10053d(this.qLZ);
        C4879a.xxA.mo10053d(this.qMa);
        C4879a.xxA.mo10053d(this.qLY);
        C4879a.xxA.mo10053d(this.qLX);
        C4879a.xxA.mo10053d(this.qLM);
        C4879a.xxA.mo10053d(this.qLK);
        C4879a.xxA.mo10053d(this.qLL);
        C4879a.xxA.mo10053d(this.qLN);
        C4879a.xxA.mo10053d(this.qLO);
        C4879a.xxA.mo10053d(this.qLP);
        C4879a.xxA.mo10053d(this.qLA);
        C4879a.xxA.mo10053d(this.qLB);
        C4879a.xxA.mo10053d(this.qLR);
        C4879a.xxA.mo10053d(this.qLT);
        C4879a.xxA.mo10053d(this.qLx);
        C4879a.xxA.mo10053d(this.qLy);
        C4879a.xxA.mo10053d(this.qLz);
        C4879a.xxA.mo10053d(this.qLC);
        C4879a.xxA.mo10053d(this.qLD);
        C4879a.xxA.mo10053d(this.qLE);
        C4879a.xxA.mo10053d(this.qLF);
        C4879a.xxA.mo10053d(this.qLG);
        C4879a.xxA.mo10053d(this.qLH);
        C4879a.xxA.mo10053d(this.qLQ);
        C4879a.xxA.mo10053d(this.qLn);
        C4879a.xxA.mo10053d(this.qLU);
        C4879a.xxA.mo10053d(this.qLV);
        C4879a.xxA.mo10053d(this.oMA);
        C4879a.xxA.mo10053d(this.qMc);
        C4879a.xxA.mo10053d(this.qLW);
        C4879a.xxA.mo10053d(this.qLI);
        C4879a.xxA.mo10053d(this.qLJ);
        C4879a.xxA.mo10053d(this.qMd);
        C4879a.xxA.mo10053d(this.qLS);
        C39783a c39783a = C29089e.qVH;
        if (c39783a.qVA) {
            try {
                C4996ah.getContext().unregisterReceiver(c39783a.qVz);
                c39783a.qVA = false;
            } catch (IllegalArgumentException e) {
                C4990ab.m7413e("MicroMsg.AdDownloadApkMgr", "unregister install receiver exception", e.getMessage());
            }
        }
        C2896d.bij();
        C2886b.m5130b(c39783a.qVE);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("NewYearSNSCtrl2016", this.qLq, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("NewYearSNSTips2016", this.qLr, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("NewYearSNSAmountLevelCtrl2016", this.qLs, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("SnsAd", this.qLt, true);
        cnz = C13373af.cnB();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(207, cnz);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(209, cnz);
        C13373af c13373af = (C13373af) C7485q.m12925Y(C13373af.class);
        if (c13373af != null) {
            C4990ab.m7410d("MicroMsg.SnsCore", "SnsCore close db");
            if (c13373af.eJN != null) {
                c13373af.eJN.closeDB();
                c13373af.eJN = null;
            }
            if (c13373af.qKI != null) {
                c13373af.qKI.reset();
            }
            if (c13373af.qKH != null) {
                c13373af.qKH.reset();
            }
            if (c13373af.qKG != null) {
                c13373af.qKG.reset();
            }
            if (c13373af.qKJ != null) {
                c13373af.qKJ.reset();
            }
        }
        C43559b c43559b = this.qLo;
        C13373af.cnA().mo69142b(c43559b);
        C4879a.xxA.mo10053d(c43559b.qGl);
        C13413ap.aon();
        C32771g.fdE.mo45830WY();
        C42178c.fdx.mo45830WY();
        C9631o.fdT.mo45830WY();
        C39754ar cnD = C13373af.cnD();
        cnD.qMW = null;
        cnD.fWa = null;
        cnD.qMY.clear();
        cnD.qMX.clear();
        synchronized (cnD.qMZ) {
            try {
                cnD.qMZ.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(36514);
            }
        }
        C4879a.xxA.mo10053d(cnD.qNa);
        C4879a.xxA.mo10053d(cnD.qMM);
        C4879a.xxA.mo10053d(cnD.qMN);
        C39732a.destroy();
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(36515);
        C4990ab.m7416i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.qLi);
        if (this.qLi) {
            AppMethodBeat.m2505o(36515);
            return;
        }
        this.qLi = true;
        this.qLf = true;
        C5730e.m8643tf(C13373af.getAccPath() + "sfs");
        this.qLk = C13373af.getAccSnsPath();
        C13373af.checkDir();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("NewYearSNSCtrl2016", this.qLq, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("NewYearSNSTips2016", this.qLr, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("NewYearSNSAmountLevelCtrl2016", this.qLs, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("SnsAd", this.qLt, true);
        C21877n.qFw = C13373af.cnB();
        C21877n.qFx = C13373af.cnC();
        C21877n.qFy = C13373af.cnJ();
        C21877n.qFz = C13373af.cnK();
        C21877n.qFA = C13373af.cnL();
        C21877n.qFC = C13373af.cnv();
        C21877n.qFB = this;
        C21877n.qFD = C13373af.cnF();
        C4879a.xxA.mo10052c(this.qLZ);
        C4879a.xxA.mo10052c(this.qMa);
        C4879a.xxA.mo10052c(this.qLM);
        C4879a.xxA.mo10052c(this.qLK);
        C4879a.xxA.mo10052c(this.qLL);
        C4879a.xxA.mo10052c(this.qLN);
        C4879a.xxA.mo10052c(this.qLO);
        C4879a.xxA.mo10052c(this.qLP);
        C4879a.xxA.mo10052c(this.qLQ);
        C4879a.xxA.mo10052c(this.qLR);
        C4879a.xxA.mo10052c(this.qLT);
        C4879a.xxA.mo10052c(this.qLU);
        C4879a.xxA.mo10052c(this.qLV);
        C4879a.xxA.mo10052c(this.qMd);
        this.qLx = new C39763n();
        this.qLy = new C39740k();
        this.qLz = new C34936e();
        this.qLA = new C21936p();
        this.qLB = new C7092h();
        this.qLC = new C21894g();
        this.qLD = new C34944m();
        this.qLE = new C7094j();
        this.qLF = new C34933b();
        this.qLG = new C39730c();
        this.qLH = new C46211f();
        C4879a.xxA.mo10052c(this.qLY);
        C4879a.xxA.mo10052c(this.qLX);
        C4879a.xxA.mo10052c(this.qLA);
        C4879a.xxA.mo10052c(this.qLx);
        C4879a.xxA.mo10052c(this.qLy);
        C4879a.xxA.mo10052c(this.qLz);
        C4879a.xxA.mo10052c(this.qLB);
        C4879a.xxA.mo10052c(this.qLC);
        C4879a.xxA.mo10052c(this.qLD);
        C4879a.xxA.mo10052c(this.qLE);
        C4879a.xxA.mo10052c(this.qLF);
        C4879a.xxA.mo10052c(this.qLG);
        C4879a.xxA.mo10052c(this.qLH);
        C4879a.xxA.mo10052c(this.oMA);
        this.qLn = new C34934d();
        C4879a.xxA.mo10052c(this.qLn);
        C4879a.xxA.mo10052c(this.qMc);
        C4879a.xxA.mo10052c(this.qLI);
        C4879a.xxA.mo10052c(this.qLJ);
        C4879a.xxA.mo10052c(this.qLW);
        C4879a.xxA.mo10052c(this.qLS);
        C13373af.cnz().start();
        C13373af.cnB().start();
        this.qLe.start();
        this.qLo = new C39734a();
        C13413ap.init();
        C32830c c32830c = C32830c.fQs;
        C32830c.ajL();
        if (C37899l.m63998Xg()) {
            C42178c c42178c = C42178c.fdx;
            C42178c c42178c2 = C42178c.fdx;
            c42178c2.getClass();
            c42178c.mo67730a((C42180a) new C133824(c42178c2));
        }
        C9631o c9631o = C9631o.fdT;
        C9631o c9631o2 = C9631o.fdT;
        c9631o2.getClass();
        c9631o.mo67730a((C42180a) new C133945(c9631o2));
        C32771g c32771g = C32771g.fdE;
        C32771g c32771g2 = C32771g.fdE;
        c32771g2.getClass();
        c32771g.mo67730a((C42180a) new C134056(c32771g2));
        C13373af.cnD();
        C39732a.init();
        AppMethodBeat.m2505o(36515);
    }

    private static void checkDir() {
        AppMethodBeat.m2504i(36516);
        C5730e.m8643tf(((C29032b) C1720g.m3530M(C29032b.class)).getAccSnsPath());
        C5730e.m8643tf(((C29032b) C1720g.m3530M(C29032b.class)).getAccSnsTmpPath());
        AppMethodBeat.m2505o(36516);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(36517);
        C5730e.m8643tf(C13373af.getAccPath() + "sfs");
        C13373af.checkDir();
        AppMethodBeat.m2505o(36517);
    }

    /* renamed from: a */
    public final void mo25483a(C42185ar c42185ar) {
        AppMethodBeat.m2504i(36518);
        C7101u.m11894a(c42185ar);
        AppMethodBeat.m2505o(36518);
    }

    /* renamed from: b */
    public final void mo25484b(C42185ar c42185ar) {
        AppMethodBeat.m2504i(36519);
        C7101u.m11897b(c42185ar);
        AppMethodBeat.m2505o(36519);
    }

    public static String cnR() {
        AppMethodBeat.m2504i(36520);
        if (C5046bo.isNullOrNil(qLl)) {
            Iterator it = C5034bd.dpo().iterator();
            while (it.hasNext()) {
                C5033a c5033a = (C5033a) it.next();
                if (C6457e.eSl.equals(c5033a.xBt)) {
                    qLl = c5033a.xBu;
                    break;
                }
            }
            C4990ab.m7416i("MicroMsg.SnsCore", "get filesys " + qLl);
        }
        String bc = C5046bo.m7532bc(qLl, "");
        AppMethodBeat.m2505o(36520);
        return bc;
    }

    static /* synthetic */ void cnS() {
        int i;
        int i2;
        int i3;
        AppMethodBeat.m2504i(36522);
        C4990ab.m7416i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        C39789o cnF = C13373af.cnF();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = cnF.bSd.mo10104a("select count(*) from SnsInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        C13478s cnu = C13373af.cnu();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor a2 = cnu.fni.mo10104a("select count(*) from SnsMedia", null, 2);
        if (a2.moveToFirst()) {
            i2 = a2.getInt(0);
        } else {
            i2 = 0;
        }
        a2.close();
        C4990ab.m7417i("MicroMsg.snsMediaStorage", "media table count %d passed %d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        C43573m cnJ = C13373af.cnJ();
        currentTimeMillis2 = System.currentTimeMillis();
        a = cnJ.bSd.mo10104a("select count(*) from snsExtInfo3", null, 2);
        if (a.moveToFirst()) {
            i3 = a.getInt(0);
        } else {
            i3 = 0;
        }
        a.close();
        C4990ab.m7417i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        stringBuffer.append(" snscount ".concat(String.valueOf(i)));
        stringBuffer.append(" mediacount ".concat(String.valueOf(i2)));
        stringBuffer.append(" extcount ".concat(String.valueOf(i3)));
        C4990ab.m7416i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
        AppMethodBeat.m2505o(36522);
    }
}
