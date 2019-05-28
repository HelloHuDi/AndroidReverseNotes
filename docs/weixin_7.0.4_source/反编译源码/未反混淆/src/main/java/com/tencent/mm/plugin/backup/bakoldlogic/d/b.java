package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.cd.f;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.i;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class b extends com.tencent.mm.plugin.backup.b.a {
    private static b jAO;
    private static int jAR = 0;
    private c jAP;
    private a jAQ;
    private c jAS;

    public static class a implements Runnable {
        public long dbSize = 0;
        public boolean jBa = true;
        public long jBb = 0;
        public long jBc = 0;

        public void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Runnable jAW;

        public AnonymousClass2(Runnable runnable) {
            this.jAW = runnable;
        }

        public final void run() {
            AppMethodBeat.i(18009);
            ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
            ab.dot();
            aw.RS().a(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean acg() {
                    AppMethodBeat.i(18006);
                    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
                    AnonymousClass2.this.jAW.run();
                    com.tencent.mm.sdk.b.a.xxA.m(new qo());
                    AppMethodBeat.o(18006);
                    return false;
                }

                public final boolean acf() {
                    AppMethodBeat.i(18007);
                    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
                    ab.dot();
                    b.aVe();
                    e.N(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aUy(), true);
                    a aVa = b.this.aVa();
                    aVa.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(17999);
                            Iterator it = a.this.jyk.iterator();
                            while (it.hasNext()) {
                                a aVar = (a) it.next();
                                if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                                    String str = (String) aVar.obj;
                                    ab.d("MicroMsg.BakOldRecoverDelayData", "getContact:".concat(String.valueOf(str)));
                                    com.tencent.mm.model.ao.a.flu.ai(str, "");
                                } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                                    am.bYI().aiH((String) aVar.obj);
                                }
                            }
                            a.this.jyk.clear();
                            AppMethodBeat.o(17999);
                        }
                    });
                    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
                    ab.dot();
                    AppMethodBeat.o(18007);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(18008);
                    String str = super.toString() + "|bakoldRecoverFromTempDb";
                    AppMethodBeat.o(18008);
                    return str;
                }
            });
            AppMethodBeat.o(18009);
        }
    }

    static /* synthetic */ int Fc() {
        int i = jAR;
        jAR = i + 1;
        return i;
    }

    static /* synthetic */ int Fd() {
        int i = jAR;
        jAR = i - 1;
        return i;
    }

    static /* synthetic */ boolean a(b bVar, PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i) {
        AppMethodBeat.i(18020);
        boolean a = bVar.a(pLong, pLong2, pLong3, aVar, i);
        AppMethodBeat.o(18020);
        return a;
    }

    public static b aUY() {
        b bVar;
        AppMethodBeat.i(18011);
        if (jAO == null) {
            bVar = new b();
            jAO = bVar;
            com.tencent.mm.plugin.backup.b.a.a(bVar);
        }
        bVar = jAO;
        AppMethodBeat.o(18011);
        return bVar;
    }

    public final void aSp() {
        jAO = null;
    }

    public final c aUZ() {
        AppMethodBeat.i(18012);
        if (this.jAP == null) {
            this.jAP = new c();
        }
        c cVar = this.jAP;
        AppMethodBeat.o(18012);
        return cVar;
    }

    public final a aVa() {
        AppMethodBeat.i(18013);
        if (this.jAQ == null) {
            this.jAQ = new a();
        }
        a aVar = this.jAQ;
        AppMethodBeat.o(18013);
        return aVar;
    }

    private static void aVb() {
        AppMethodBeat.i(18014);
        com.tencent.mm.sdk.b.a.xxA.m(new aa());
        AppMethodBeat.o(18014);
    }

    private c aVc() {
        AppMethodBeat.i(18015);
        if (this.jAS == null) {
            this.jAS = new c();
        }
        c cVar = this.jAS;
        AppMethodBeat.o(18015);
        return cVar;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(18016);
        final long anU = bo.anU();
        ab.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", Boolean.FALSE, bo.dpG());
        al.n(new Runnable() {
            final /* synthetic */ int jxL = -1;

            public final void run() {
                AppMethodBeat.i(18005);
                g.RN().QU();
                ab.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", Integer.valueOf(b.jAR), Long.valueOf(bo.gb(anU)));
                b.Fc();
                aw.RS().a(new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean acg() {
                        AppMethodBeat.i(18002);
                        ab.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
                        aVar.run();
                        b.Fd();
                        AppMethodBeat.o(18002);
                        return false;
                    }

                    public final boolean acf() {
                        AppMethodBeat.i(18003);
                        b.aVd();
                        b.a(b.this, new PLong(), new PLong(), new PLong(), aVar, AnonymousClass1.this.jxL);
                        AppMethodBeat.o(18003);
                        return true;
                    }

                    public final String toString() {
                        AppMethodBeat.i(18004);
                        String str = super.toString() + "|initTempDB";
                        AppMethodBeat.o(18004);
                        return str;
                    }
                });
                AppMethodBeat.o(18005);
            }
        }, 1000);
        AppMethodBeat.o(18016);
    }

    private boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i) {
        AppMethodBeat.i(18017);
        aw.ZK();
        c.closeDB();
        ab.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
        aw.ZK();
        long asZ = e.asZ(c.Rv());
        aw.ZK();
        pLong3.value = asZ + e.asZ(c.Rw());
        asZ = pLong3.value;
        aw.ZK();
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(asZ, pLong, pLong2, c.getAccPath())) {
            aw.ZK();
            String Rv = c.Rv();
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            e.y(Rv, stringBuilder.append(c.Rv()).append(".tem").toString());
            aw.ZK();
            Rv = c.Rw();
            stringBuilder = new StringBuilder();
            aw.ZK();
            e.y(Rv, stringBuilder.append(c.Rw()).append(".tem").toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            aw.ZK();
            Rv = stringBuilder2.append(c.Rw()).append("-journal").toString();
            stringBuilder = new StringBuilder();
            aw.ZK();
            e.y(Rv, stringBuilder.append(c.Rw()).append(".tem-journal").toString());
            stringBuilder2 = new StringBuilder();
            aw.ZK();
            Rv = stringBuilder2.append(c.Rw()).append("-wal").toString();
            stringBuilder = new StringBuilder();
            aw.ZK();
            e.y(Rv, stringBuilder.append(c.Rw()).append(".tem-wal").toString());
            ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
            g.RN().release();
            g.RN().initialize();
            ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
            c aVc = aVc();
            aw.ZK();
            String accPath = c.getAccPath();
            aw.ZK();
            ab.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", accPath, Integer.valueOf(c.QF()));
            aVc.uin = r2;
            aVc.eJM = accPath;
            ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
            c aVc2 = aVc();
            stringBuilder2 = new StringBuilder();
            aw.ZK();
            accPath = stringBuilder2.append(c.Rv()).append(".tem").toString();
            aw.ZK();
            int QF = c.QF();
            stringBuilder2 = new StringBuilder();
            aw.ZK();
            ab.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", aVc2.jBf, accPath, Integer.valueOf(QF), stringBuilder2.append(c.Rw()).append(".tem").toString(), bo.dpG());
            if (aVc2.eJN != null) {
                ab.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
            }
            if (i > 0) {
                if (!(aVc2.jBf == null || aVc2.jBf.booleanValue())) {
                    ab.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
                    aVc2.aVf();
                }
                Assert.assertTrue("bakoldInitDB here  isTempDb should null :" + aVc2.jBf, aVc2.jBf == null);
            }
            aVc2.jBf = Boolean.TRUE;
            aVc2.eJN = new h(new com.tencent.mm.cd.h.a() {
                public final void RF() {
                    AppMethodBeat.i(18023);
                    if (c.this.jBe != null) {
                        com.tencent.mm.cd.g gVar = c.this.jBe;
                        for (Object obj : gVar.ybM.keySet()) {
                            ((i) gVar.ybM.get(obj)).dvy();
                        }
                    }
                    AppMethodBeat.o(18023);
                }

                public final void RG() {
                }

                public final void RH() {
                    AppMethodBeat.i(18024);
                    if (c.this.jBe != null) {
                        com.tencent.mm.cd.g gVar = c.this.jBe;
                        if (gVar.ybN.size() != 0) {
                            ab.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", "stg_null", Integer.valueOf(gVar.ybN.size()));
                            if (gVar.ybk == null) {
                                ab.e("MicroMsg.MemoryStorage", "attachTable db is null");
                                AppMethodBeat.o(18024);
                                return;
                            } else if (gVar.ybK.inTransaction()) {
                                ab.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", Integer.valueOf(gVar.ybN.size()));
                                AppMethodBeat.o(18024);
                                return;
                            } else {
                                while (gVar.ybN.size() > 0) {
                                    if (gVar.ybK.inTransaction()) {
                                        ab.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", Integer.valueOf(gVar.ybN.size()));
                                        AppMethodBeat.o(18024);
                                        return;
                                    }
                                    a aVar = (a) gVar.ybN.peek();
                                    if (aVar == null) {
                                        gVar.ybN.poll();
                                    } else {
                                        String tableName = aVar.getTableName();
                                        if (bo.isNullOrNil(tableName)) {
                                            ab.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", tableName);
                                            gVar.ybN.poll();
                                        } else if (f.a(gVar.ybk, tableName)) {
                                            ab.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", tableName);
                                            gVar.ybN.poll();
                                        } else {
                                            if (gVar.aqv(tableName) != 0) {
                                                try {
                                                    if (gVar.vcA) {
                                                        gVar.ybk.execSQL("DETACH DATABASE old");
                                                        ab.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                                        gVar.vcA = false;
                                                    }
                                                    if (bo.isNullOrNil(gVar.ybK.getKey())) {
                                                        gVar.ybk.execSQL("ATTACH DATABASE '" + gVar.ybK.getPath() + "' AS old ");
                                                    } else {
                                                        gVar.ybk.execSQL("ATTACH DATABASE '" + gVar.ybK.getPath() + "' AS old KEY '" + gVar.ybK.getKey() + "'");
                                                    }
                                                    ab.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                                    gVar.vcA = true;
                                                } catch (Exception e) {
                                                    gVar.vcA = false;
                                                    ab.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
                                                    ab.e("MicroMsg.MemoryStorage", "exception:%s", bo.l(e));
                                                }
                                                if (gVar.aqv(tableName) != 0) {
                                                    ab.e("MicroMsg.MemoryStorage", "copy table failed :".concat(String.valueOf(tableName)));
                                                    AppMethodBeat.o(18024);
                                                    return;
                                                }
                                            }
                                            ab.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", tableName, Integer.valueOf(gVar.ybN.size()), Integer.valueOf(gVar.ybM.size()));
                                            gVar.ybM.put(tableName, new i(gVar.ybK, tableName));
                                            aVar.a(gVar);
                                            gVar.ybN.poll();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(18024);
                }
            });
            long j = (long) QF;
            q.LK();
            if (aVc2.eJN.b(accPath, r2, "", j, new HashMap(), false)) {
                aVc2.jym = new z(aVc2.eJN);
                k kVar = (k) g.K(k.class);
                aVc2.jyn = kVar.d(aVc2.eJN);
                aVc2.jyp = kVar.e(aVc2.eJN);
                aVc2.jyo = kVar.a(aVc2.eJN, aVc2.jyn, aVc2.jyp);
                aVc2.jyo.a(new au(aVc2.jyo));
                aVc2.jyo.a(new o(aVc2.jyo));
                aVc2.jys = kVar.f(aVc2.eJN);
                aVc2.jyq = new com.tencent.mm.at.g(aVc2.eJN);
                if (d.afj("emoji")) {
                    aVc2.jyr = new com.tencent.mm.storage.emotion.d(aVc2.eJN);
                }
                aVc2.jyu = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).c(aVc2.eJN);
                aVc2.jyt = new t(aVc2.eJN);
                aVc2.jyv = new com.tencent.mm.pluginsdk.model.app.k(aVc2.eJN);
                aVc2.jyw = new com.tencent.mm.pluginsdk.model.app.i(aVc2.eJN);
                aVc2.jyx = new com.tencent.mm.pluginsdk.model.app.c(aVc2.eJN);
                aVc2.jBd = new bs(aVc2.jym);
                aVc2.jBd.c(new com.tencent.mm.sdk.e.k.a() {
                    public final void a(String str, m mVar) {
                        AppMethodBeat.i(18022);
                        q.ku(str);
                        AppMethodBeat.o(18022);
                    }
                });
                aVc2.jBd.duo();
                ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
                aVb();
                aVar.jBa = true;
                aVar.jBb = pLong.value;
                aVar.jBc = pLong2.value;
                aVar.dbSize = pLong3.value;
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.Fo(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aUy());
                AppMethodBeat.o(18017);
                return true;
            }
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b((byte) 0);
            AppMethodBeat.o(18017);
            throw bVar;
        }
        ab.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", Long.valueOf(pLong3.value));
        aVar.jBa = false;
        aVar.jBb = pLong.value;
        aVar.jBc = pLong2.value;
        aVar.dbSize = pLong3.value;
        AppMethodBeat.o(18017);
        return false;
    }

    public static void aVd() {
        AppMethodBeat.i(18018);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        e.deleteFile(stringBuilder.append(c.Rv()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        aw.ZK();
        e.deleteFile(stringBuilder.append(c.Rv()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        aw.ZK();
        e.deleteFile(stringBuilder.append(c.Rw()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        aw.ZK();
        e.deleteFile(stringBuilder.append(c.Rw()).append(".ini.tem").toString());
        AppMethodBeat.o(18018);
    }

    public final void c(final Runnable runnable, final int i) {
        AppMethodBeat.i(18019);
        if (i < 0 || jAR == 0) {
            if (i < 0) {
                ab.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
            }
            ab.i("MicroMsg.BakOldTempDbModel", "closeDB before");
            aVc().aVf();
            ab.i("MicroMsg.BakOldTempDbModel", "closeDB after");
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.o(18019);
                return;
            }
        }
        new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18010);
                b.this.c(runnable, i - 1);
                AppMethodBeat.o(18010);
            }
        }, 500);
        AppMethodBeat.o(18019);
    }

    static /* synthetic */ void aVe() {
        AppMethodBeat.i(18021);
        long anU = bo.anU();
        aw.ZK();
        c.closeDB();
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.Rv()).append(".tem").toString();
        aw.ZK();
        e.y(stringBuilder2, c.Rv());
        stringBuilder = new StringBuilder();
        aw.ZK();
        stringBuilder2 = stringBuilder.append(c.Rw()).append(".tem").toString();
        aw.ZK();
        e.y(stringBuilder2, c.Rw());
        stringBuilder = new StringBuilder();
        aw.ZK();
        stringBuilder2 = stringBuilder.append(c.Rw()).append(".tem-journal").toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        aw.ZK();
        e.y(stringBuilder2, stringBuilder3.append(c.Rw()).append("-journal").toString());
        stringBuilder = new StringBuilder();
        aw.ZK();
        stringBuilder2 = stringBuilder.append(c.Rw()).append(".tem-wal").toString();
        stringBuilder3 = new StringBuilder();
        aw.ZK();
        e.y(stringBuilder2, stringBuilder3.append(c.Rw()).append("-wal").toString());
        com.tencent.mm.sdk.b.a.xxA.m(new bp());
        g.RN().release();
        g.RN().initialize();
        aVd();
        aVb();
        ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDbImp finish cost time[%d]", Long.valueOf(bo.gb(anU)));
        AppMethodBeat.o(18021);
    }
}
