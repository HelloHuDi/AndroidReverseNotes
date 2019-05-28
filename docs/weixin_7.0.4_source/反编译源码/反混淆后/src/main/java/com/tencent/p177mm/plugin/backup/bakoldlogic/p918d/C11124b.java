package com.tencent.p177mm.plugin.backup.bakoldlogic.p918d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C37786qo;
import com.tencent.p177mm.p230g.p231a.C45310bp;
import com.tencent.p177mm.p230g.p231a.C6458aa;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C27478c.C274792;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C27478c.C274801;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C45742a.C199692;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28494k;
import com.tencent.p177mm.pluginsdk.model.app.C14884k;
import com.tencent.p177mm.pluginsdk.model.app.C30066c;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C23509au;
import com.tencent.p177mm.storage.C46626o;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.emotion.C30303d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b */
public final class C11124b extends C33660a {
    private static C11124b jAO;
    private static int jAR = 0;
    private C27478c jAP;
    private C45742a jAQ;
    private C27478c jAS;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$a */
    public static class C11125a implements Runnable {
        public long dbSize = 0;
        public boolean jBa = true;
        public long jBb = 0;
        public long jBc = 0;

        public void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$2 */
    public class C111262 implements Runnable {
        final /* synthetic */ Runnable jAW;

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$2$1 */
        class C111271 implements C5002a {
            C111271() {
            }

            public final boolean acg() {
                AppMethodBeat.m2504i(18006);
                C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
                C111262.this.jAW.run();
                C4879a.xxA.mo10055m(new C37786qo());
                AppMethodBeat.m2505o(18006);
                return false;
            }

            public final boolean acf() {
                AppMethodBeat.m2504i(18007);
                C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
                C4990ab.dot();
                C11124b.aVe();
                C5730e.m8618N(C27452a.aUy(), true);
                C45742a aVa = C11124b.this.aVa();
                aVa.handler.post(new C199692());
                C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
                C4990ab.dot();
                AppMethodBeat.m2505o(18007);
                return true;
            }

            public final String toString() {
                AppMethodBeat.m2504i(18008);
                String str = super.toString() + "|bakoldRecoverFromTempDb";
                AppMethodBeat.m2505o(18008);
                return str;
            }
        }

        public C111262(Runnable runnable) {
            this.jAW = runnable;
        }

        public final void run() {
            AppMethodBeat.m2504i(18009);
            C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
            C4990ab.dot();
            C9638aw.m17180RS().mo10300a(new C111271());
            AppMethodBeat.m2505o(18009);
        }
    }

    /* renamed from: Fc */
    static /* synthetic */ int m18835Fc() {
        int i = jAR;
        jAR = i + 1;
        return i;
    }

    /* renamed from: Fd */
    static /* synthetic */ int m18836Fd() {
        int i = jAR;
        jAR = i - 1;
        return i;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m18837a(C11124b c11124b, PLong pLong, PLong pLong2, PLong pLong3, C11125a c11125a, int i) {
        AppMethodBeat.m2504i(18020);
        boolean a = c11124b.m18838a(pLong, pLong2, pLong3, c11125a, i);
        AppMethodBeat.m2505o(18020);
        return a;
    }

    public static C11124b aUY() {
        C11124b c11124b;
        AppMethodBeat.m2504i(18011);
        if (jAO == null) {
            c11124b = new C11124b();
            jAO = c11124b;
            C33660a.m54968a(c11124b);
        }
        c11124b = jAO;
        AppMethodBeat.m2505o(18011);
        return c11124b;
    }

    public final void aSp() {
        jAO = null;
    }

    public final C27478c aUZ() {
        AppMethodBeat.m2504i(18012);
        if (this.jAP == null) {
            this.jAP = new C27478c();
        }
        C27478c c27478c = this.jAP;
        AppMethodBeat.m2505o(18012);
        return c27478c;
    }

    public final C45742a aVa() {
        AppMethodBeat.m2504i(18013);
        if (this.jAQ == null) {
            this.jAQ = new C45742a();
        }
        C45742a c45742a = this.jAQ;
        AppMethodBeat.m2505o(18013);
        return c45742a;
    }

    private static void aVb() {
        AppMethodBeat.m2504i(18014);
        C4879a.xxA.mo10055m(new C6458aa());
        AppMethodBeat.m2505o(18014);
    }

    private C27478c aVc() {
        AppMethodBeat.m2504i(18015);
        if (this.jAS == null) {
            this.jAS = new C27478c();
        }
        C27478c c27478c = this.jAS;
        AppMethodBeat.m2505o(18015);
        return c27478c;
    }

    /* renamed from: a */
    public final void mo22827a(final C11125a c11125a) {
        AppMethodBeat.m2504i(18016);
        final long anU = C5046bo.anU();
        C4990ab.m7417i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", Boolean.FALSE, C5046bo.dpG());
        C5004al.m7442n(new Runnable() {
            final /* synthetic */ int jxL = -1;

            /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$1$1 */
            class C111291 implements C5002a {
                C111291() {
                }

                public final boolean acg() {
                    AppMethodBeat.m2504i(18002);
                    C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
                    c11125a.run();
                    C11124b.m18836Fd();
                    AppMethodBeat.m2505o(18002);
                    return false;
                }

                public final boolean acf() {
                    AppMethodBeat.m2504i(18003);
                    C11124b.aVd();
                    C11124b.m18837a(C11124b.this, new PLong(), new PLong(), new PLong(), c11125a, C111281.this.jxL);
                    AppMethodBeat.m2505o(18003);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.m2504i(18004);
                    String str = super.toString() + "|initTempDB";
                    AppMethodBeat.m2505o(18004);
                    return str;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(18005);
                C1720g.m3534RN().mo5159QU();
                C4990ab.m7417i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", Integer.valueOf(C11124b.jAR), Long.valueOf(C5046bo.m7566gb(anU)));
                C11124b.m18835Fc();
                C9638aw.m17180RS().mo10300a(new C111291());
                AppMethodBeat.m2505o(18005);
            }
        }, 1000);
        AppMethodBeat.m2505o(18016);
    }

    /* renamed from: a */
    private boolean m18838a(PLong pLong, PLong pLong2, PLong pLong3, C11125a c11125a, int i) {
        AppMethodBeat.m2504i(18017);
        C9638aw.m17190ZK();
        C18628c.closeDB();
        C4990ab.m7410d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
        C9638aw.m17190ZK();
        long asZ = C5730e.asZ(C18628c.m29070Rv());
        C9638aw.m17190ZK();
        pLong3.value = asZ + C5730e.asZ(C18628c.m29071Rw());
        asZ = pLong3.value;
        C9638aw.m17190ZK();
        if (C27452a.m43559a(asZ, pLong, pLong2, C18628c.getAccPath())) {
            C9638aw.m17190ZK();
            String Rv = C18628c.m29070Rv();
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            C5730e.m8644y(Rv, stringBuilder.append(C18628c.m29070Rv()).append(".tem").toString());
            C9638aw.m17190ZK();
            Rv = C18628c.m29071Rw();
            stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            C5730e.m8644y(Rv, stringBuilder.append(C18628c.m29071Rw()).append(".tem").toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            C9638aw.m17190ZK();
            Rv = stringBuilder2.append(C18628c.m29071Rw()).append("-journal").toString();
            stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            C5730e.m8644y(Rv, stringBuilder.append(C18628c.m29071Rw()).append(".tem-journal").toString());
            stringBuilder2 = new StringBuilder();
            C9638aw.m17190ZK();
            Rv = stringBuilder2.append(C18628c.m29071Rw()).append("-wal").toString();
            stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            C5730e.m8644y(Rv, stringBuilder.append(C18628c.m29071Rw()).append(".tem-wal").toString());
            C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
            C1720g.m3534RN().release();
            C1720g.m3534RN().initialize();
            C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
            C27478c aVc = aVc();
            C9638aw.m17190ZK();
            String accPath = C18628c.getAccPath();
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", accPath, Integer.valueOf(C18628c.m29064QF()));
            aVc.uin = r2;
            aVc.eJM = accPath;
            C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
            C27478c aVc2 = aVc();
            stringBuilder2 = new StringBuilder();
            C9638aw.m17190ZK();
            accPath = stringBuilder2.append(C18628c.m29070Rv()).append(".tem").toString();
            C9638aw.m17190ZK();
            int QF = C18628c.m29064QF();
            stringBuilder2 = new StringBuilder();
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", aVc2.jBf, accPath, Integer.valueOf(QF), stringBuilder2.append(C18628c.m29071Rw()).append(".tem").toString(), C5046bo.dpG());
            if (aVc2.eJN != null) {
                C4990ab.m7412e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
            }
            if (i > 0) {
                if (!(aVc2.jBf == null || aVc2.jBf.booleanValue())) {
                    C4990ab.m7412e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
                    aVc2.aVf();
                }
                Assert.assertTrue("bakoldInitDB here  isTempDb should null :" + aVc2.jBf, aVc2.jBf == null);
            }
            aVc2.jBf = Boolean.TRUE;
            aVc2.eJN = new C7480h(new C274792());
            long j = (long) QF;
            C1427q.m3026LK();
            if (aVc2.eJN.mo16660b(accPath, r2, "", j, new HashMap(), false)) {
                aVc2.jym = new C7580z(aVc2.eJN);
                C28494k c28494k = (C28494k) C1720g.m3528K(C28494k.class);
                aVc2.jyn = c28494k.mo24452d(aVc2.eJN);
                aVc2.jyp = c28494k.mo24453e(aVc2.eJN);
                aVc2.jyo = c28494k.mo24451a(aVc2.eJN, aVc2.jyn, aVc2.jyp);
                aVc2.jyo.mo15290a(new C23509au(aVc2.jyo));
                aVc2.jyo.mo15290a(new C46626o(aVc2.jyo));
                aVc2.jys = c28494k.mo24454f(aVc2.eJN);
                aVc2.jyq = new C45160g(aVc2.eJN);
                if (C25985d.afj("emoji")) {
                    aVc2.jyr = new C30303d(aVc2.eJN);
                }
                aVc2.jyu = ((C6822c) C1720g.m3528K(C6822c.class)).mo15091c(aVc2.eJN);
                aVc2.jyt = new C9720t(aVc2.eJN);
                aVc2.jyv = new C14884k(aVc2.eJN);
                aVc2.jyw = new C35796i(aVc2.eJN);
                aVc2.jyx = new C30066c(aVc2.eJN);
                aVc2.jBd = new C7574bs(aVc2.jym);
                aVc2.jBd.mo10116c(new C274801());
                aVc2.jBd.duo();
                C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
                C11124b.aVb();
                c11125a.jBa = true;
                c11125a.jBb = pLong.value;
                c11125a.jBc = pLong2.value;
                c11125a.dbSize = pLong3.value;
                C27452a.m43554Fo(C27452a.aUy());
                AppMethodBeat.m2505o(18017);
                return true;
            }
            C1819b c1819b = new C1819b((byte) 0);
            AppMethodBeat.m2505o(18017);
            throw c1819b;
        }
        C4990ab.m7413e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", Long.valueOf(pLong3.value));
        c11125a.jBa = false;
        c11125a.jBb = pLong.value;
        c11125a.jBc = pLong2.value;
        c11125a.dbSize = pLong3.value;
        AppMethodBeat.m2505o(18017);
        return false;
    }

    public static void aVd() {
        AppMethodBeat.m2504i(18018);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        C5730e.deleteFile(stringBuilder.append(C18628c.m29070Rv()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        C5730e.deleteFile(stringBuilder.append(C18628c.m29070Rv()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        C5730e.deleteFile(stringBuilder.append(C18628c.m29071Rw()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        C5730e.deleteFile(stringBuilder.append(C18628c.m29071Rw()).append(".ini.tem").toString());
        AppMethodBeat.m2505o(18018);
    }

    /* renamed from: c */
    public final void mo22831c(final Runnable runnable, final int i) {
        AppMethodBeat.m2504i(18019);
        if (i < 0 || jAR == 0) {
            if (i < 0) {
                C4990ab.m7412e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
            }
            C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "closeDB before");
            aVc().aVf();
            C4990ab.m7416i("MicroMsg.BakOldTempDbModel", "closeDB after");
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.m2505o(18019);
                return;
            }
        }
        new C7306ak(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18010);
                C11124b.this.mo22831c(runnable, i - 1);
                AppMethodBeat.m2505o(18010);
            }
        }, 500);
        AppMethodBeat.m2505o(18019);
    }

    static /* synthetic */ void aVe() {
        AppMethodBeat.m2504i(18021);
        long anU = C5046bo.anU();
        C9638aw.m17190ZK();
        C18628c.closeDB();
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29070Rv()).append(".tem").toString();
        C9638aw.m17190ZK();
        C5730e.m8644y(stringBuilder2, C18628c.m29070Rv());
        stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        stringBuilder2 = stringBuilder.append(C18628c.m29071Rw()).append(".tem").toString();
        C9638aw.m17190ZK();
        C5730e.m8644y(stringBuilder2, C18628c.m29071Rw());
        stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        stringBuilder2 = stringBuilder.append(C18628c.m29071Rw()).append(".tem-journal").toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        C9638aw.m17190ZK();
        C5730e.m8644y(stringBuilder2, stringBuilder3.append(C18628c.m29071Rw()).append("-journal").toString());
        stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        stringBuilder2 = stringBuilder.append(C18628c.m29071Rw()).append(".tem-wal").toString();
        stringBuilder3 = new StringBuilder();
        C9638aw.m17190ZK();
        C5730e.m8644y(stringBuilder2, stringBuilder3.append(C18628c.m29071Rw()).append("-wal").toString());
        C4879a.xxA.mo10055m(new C45310bp());
        C1720g.m3534RN().release();
        C1720g.m3534RN().initialize();
        C11124b.aVd();
        C11124b.aVb();
        C4990ab.m7417i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDbImp finish cost time[%d]", Long.valueOf(C5046bo.m7566gb(anU)));
        AppMethodBeat.m2505o(18021);
    }
}
