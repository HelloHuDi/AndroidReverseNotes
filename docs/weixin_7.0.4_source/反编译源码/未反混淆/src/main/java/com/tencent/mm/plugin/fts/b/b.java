package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m eAX;
    private com.tencent.mm.sdk.b.c<bf> fAP = new com.tencent.mm.sdk.b.c<bf>() {
        {
            AppMethodBeat.i(136716);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(136716);
        }

        private boolean a(bf bfVar) {
            AppMethodBeat.i(136717);
            if (bfVar.cus.cut == 35 && bfVar.cus.cuu == 1) {
                ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", bfVar.cus.filePath);
                b bVar = b.this;
                String str = bfVar.cus.filePath;
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(b.bAx(), "temp");
                if (bVar2.exists()) {
                    e.N(j.w(bVar2.dMD()), true);
                }
                bVar2.mkdirs();
                try {
                    ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", str, Integer.valueOf(e.iu(str, j.w(bVar2.dMD()))));
                    if (e.iu(str, j.w(bVar2.dMD())) >= 0) {
                        com.tencent.mm.vfs.b bAy = b.bAy();
                        com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(bVar2, "fts_feature");
                        ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", Integer.valueOf(b.j(bVar3)), Integer.valueOf(b.j(bAy)));
                        if (b.j(bVar3) > b.j(bAy)) {
                            e.N(j.w(bAy.dMD()), true);
                            bVar3.o(bAy);
                            bVar.eAX.a(65596, new d(j.w(bAy.dMD())));
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "updateFeatureList", new Object[0]);
                    com.tencent.mm.plugin.report.e.pXa.a(146, 22, 1, false);
                }
            }
            AppMethodBeat.o(136717);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c mFG = new com.tencent.mm.sdk.b.c<ts>() {
        {
            AppMethodBeat.i(136714);
            this.xxI = ts.class.getName().hashCode();
            AppMethodBeat.o(136714);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136715);
            b.this.eAX.a(65596, new d(j.w(b.bAy().dMD())));
            AppMethodBeat.o(136715);
            return true;
        }
    };
    com.tencent.mm.plugin.fts.c.b mGl;

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int mGn;
        private int mGo;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136719);
            ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
            com.tencent.mm.plugin.fts.c.b bVar = b.this.mGl;
            List arrayList = new ArrayList();
            Cursor rawQuery = bVar.mBT.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.c cVar = new com.tencent.mm.plugin.fts.a.a.c();
                cVar.d(rawQuery);
                arrayList.add(cVar);
            }
            rawQuery.close();
            if (arrayList.size() == 0) {
                try {
                    arrayList = b.Nl(j.w(b.bAy().dMD()));
                    b.this.mGl.bZ(arrayList);
                } catch (Exception e) {
                }
            }
            List<com.tencent.mm.plugin.fts.c.b.a> bAI = b.this.mGl.bAI();
            HashMap hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.c cVar2 : arrayList) {
                hashMap.put(Integer.valueOf(cVar2.field_featureId), cVar2);
            }
            if (b.this.mGl.mBT.inTransaction()) {
                b.this.mGl.commit();
            }
            b.this.mGl.beginTransaction();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (com.tencent.mm.plugin.fts.c.b.a aVar : bAI) {
                com.tencent.mm.plugin.fts.a.a.c cVar3 = (com.tencent.mm.plugin.fts.a.a.c) hashMap.remove(Integer.valueOf(aVar.mHi));
                if (cVar3 == null) {
                    hashSet.add(Integer.valueOf(aVar.mHi));
                } else if (aVar.timestamp != cVar3.field_timestamp) {
                    hashSet2.add(cVar3);
                    b.this.mGl.c(com.tencent.mm.plugin.fts.a.c.mCe, (long) cVar3.field_featureId);
                    ((PluginFTS) g.M(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.mCe, String.valueOf(cVar3.field_featureId));
                }
            }
            hashSet2.addAll(hashMap.values());
            b.this.mGl.commit();
            b.this.mGl.beginTransaction();
            this.mGn = hashSet.size();
            this.mGo = hashSet2.size();
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.fts.a.a.c cVar4 = (com.tencent.mm.plugin.fts.a.a.c) it.next();
                b bVar2 = b.this;
                bVar2.mGl.a(262144, 1, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_title);
                String aL = com.tencent.mm.plugin.fts.a.d.aL(cVar4.field_title, false);
                if (!bo.isNullOrNil(aL)) {
                    bVar2.mGl.a(262144, 2, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, aL);
                }
                aL = com.tencent.mm.plugin.fts.a.d.aL(cVar4.field_title, true);
                if (!bo.isNullOrNil(aL)) {
                    bVar2.mGl.a(262144, 3, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, aL);
                }
                bVar2.mGl.a(262144, 4, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_tag);
                ((PluginFTS) g.M(PluginFTS.class)).getTopHitsLogic().Nn(String.valueOf(cVar4.field_featureId));
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                b.this.mGl.c(com.tencent.mm.plugin.fts.a.c.mCe, (long) ((Integer) it2.next()).intValue());
            }
            b.this.mGl.commit();
            AppMethodBeat.o(136719);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136720);
            String format = String.format("{remove: %d add: %d}", new Object[]{Integer.valueOf(this.mGn), Integer.valueOf(this.mGo)});
            AppMethodBeat.o(136720);
            return format;
        }

        public final String getName() {
            return "BuildFeatureIndexTask";
        }

        public final int getId() {
            return 5;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A:{SYNTHETIC, Splitter:B:24:0x0080} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0085 A:{SYNTHETIC, Splitter:B:27:0x0085} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6 A:{SYNTHETIC, Splitter:B:43:0x00c6} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb A:{SYNTHETIC, Splitter:B:46:0x00cb} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6 A:{SYNTHETIC, Splitter:B:43:0x00c6} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb A:{SYNTHETIC, Splitter:B:46:0x00cb} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            InputStream open;
            OutputStream fVar;
            Throwable e;
            AppMethodBeat.i(136721);
            int j = b.j(b.bAy());
            int bAz = b.bAz();
            ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d, pkgversion:%s", Integer.valueOf(j), Integer.valueOf(bAz));
            if (bAz > j && bAz > 0) {
                j = -1;
            }
            if (j < 0) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ah.getContext().getCacheDir(), "fts_feature.zip");
                try {
                    open = ah.getContext().getAssets().open("fts_feature.zip");
                    try {
                        if (bVar.exists()) {
                            bVar.delete();
                        }
                        fVar = new f(bVar);
                    } catch (Exception e2) {
                        e = e2;
                        fVar = null;
                        try {
                            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                            if (open != null) {
                            }
                            if (fVar != null) {
                            }
                            if (bVar.exists()) {
                            }
                            AppMethodBeat.o(136721);
                            return true;
                        } catch (Throwable th) {
                            e = th;
                            if (open != null) {
                            }
                            if (fVar != null) {
                            }
                            AppMethodBeat.o(136721);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        fVar = null;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (fVar != null) {
                            try {
                                fVar.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.o(136721);
                        throw e;
                    }
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = open.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fVar.write(bArr, 0, read);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e5) {
                            }
                        }
                        try {
                            fVar.close();
                        } catch (IOException e6) {
                        }
                    } catch (Exception e7) {
                        e = e7;
                        ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (fVar != null) {
                            try {
                                fVar.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (bVar.exists()) {
                        }
                        AppMethodBeat.o(136721);
                        return true;
                    }
                } catch (Exception e10) {
                    e = e10;
                    fVar = null;
                    open = null;
                } catch (Throwable th3) {
                    e = th3;
                    fVar = null;
                    open = null;
                    if (open != null) {
                    }
                    if (fVar != null) {
                    }
                    AppMethodBeat.o(136721);
                    throw e;
                }
                if (bVar.exists()) {
                    com.tencent.mm.sdk.b.b bfVar = new bf();
                    bfVar.cus.cut = 35;
                    bfVar.cus.cuu = 1;
                    bfVar.cus.filePath = j.w(bVar.dMD());
                    com.tencent.mm.sdk.b.a.xxA.a(bfVar, Looper.getMainLooper());
                }
            }
            AppMethodBeat.o(136721);
            return true;
        }

        public final String getName() {
            return "CheckFeatureResourceTask";
        }
    }

    class c extends h {
        /* synthetic */ c(b bVar, i iVar, byte b) {
            this(iVar);
        }

        private c(i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchFeatureTask";
        }

        public final int getId() {
            return 12;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136722);
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            jVar.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = b.this.mGl.a(jVar.mDz, com.tencent.mm.plugin.fts.a.c.mCe, this.mEl.mEs, true, true);
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.k(a);
                if (!(hashSet.contains(Long.valueOf(mVar.mEB)) || this.mEl.mEu.contains(mVar.mDx))) {
                    mVar.bAo();
                    jVar.mEy.add(mVar);
                    hashSet.add(Long.valueOf(mVar.mEB));
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(136722);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            for (l lVar : jVar.mEy) {
                lVar.userData = b.this.mGl.wa((int) lVar.mEB);
            }
            AppMethodBeat.o(136722);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String path;

        public d(String str) {
            this.path = str;
        }

        public final String getName() {
            return "UpdateFeatureIndexTask";
        }

        public final boolean execute() {
            AppMethodBeat.i(136723);
            List Nl = b.Nl(this.path);
            b.this.mGl.beginTransaction();
            b.this.mGl.bZ(Nl);
            b.this.mGl.commit();
            b.this.mGl.s(com.tencent.mm.plugin.fts.a.c.mCe);
            b.this.eAX.a(131132, new a(b.this, (byte) 0));
            e topHitsLogic = ((PluginFTS) g.M(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mGO.g(com.tencent.mm.plugin.fts.a.c.mCe, 1);
            AppMethodBeat.o(136723);
            return true;
        }
    }

    public b() {
        AppMethodBeat.i(136724);
        AppMethodBeat.o(136724);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        AppMethodBeat.i(136725);
        com.tencent.mm.plugin.fts.a.a.a a = this.eAX.a(-65536, new c(this, iVar, (byte) 0));
        AppMethodBeat.o(136725);
        return a;
    }

    public final boolean onCreate() {
        AppMethodBeat.i(136726);
        if (((n) g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
            this.eAX = ((n) g.M(n.class)).getFTSTaskDaemon();
            this.mGl = (com.tencent.mm.plugin.fts.c.b) ((n) g.M(n.class)).getFTSIndexStorage(17);
            this.mFG.dnU();
            this.fAP.dnU();
            this.eAX.a(131132, new b(this, (byte) 0));
            this.eAX.a(131133, new a(this, (byte) 0));
            AppMethodBeat.o(136726);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
        AppMethodBeat.o(136726);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136727);
        this.mFG.dead();
        this.fAP.dead();
        this.mGl = null;
        this.eAX = null;
        AppMethodBeat.o(136727);
        return true;
    }

    public final String getName() {
        return "FTS5SearchFeatureLogic";
    }

    public static com.tencent.mm.vfs.b bAx() {
        AppMethodBeat.i(136728);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.eSk, "fts"), "feature");
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        AppMethodBeat.o(136728);
        return bVar;
    }

    public static com.tencent.mm.vfs.b bAy() {
        AppMethodBeat.i(136729);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bAx(), "fts_feature");
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        AppMethodBeat.o(136729);
        return bVar;
    }

    static int j(com.tencent.mm.vfs.b bVar) {
        AppMethodBeat.i(136730);
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(bVar, "version.info");
        int i = -1;
        try {
            if (bVar2.exists()) {
                i = Integer.parseInt(e.cy(j.w(bVar2.dMD())), 10);
            } else {
                ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", j.w(bVar2.dMD()));
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "getFeatureVersion", new Object[0]);
        }
        AppMethodBeat.o(136730);
        return i;
    }

    static int bAz() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(136731);
        int i = -1;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(ah.getContext().getAssets().open("fts/version.info")));
            try {
                i = Integer.valueOf(bufferedReader.readLine()).intValue();
                bo.b(bufferedReader);
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, e.getMessage(), new Object[0]);
                    bo.b(bufferedReader);
                    AppMethodBeat.o(136731);
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(bufferedReader);
                    AppMethodBeat.o(136731);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, e.getMessage(), new Object[0]);
            bo.b(bufferedReader);
            AppMethodBeat.o(136731);
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(136731);
            throw th;
        }
        AppMethodBeat.o(136731);
        return i;
    }

    static /* synthetic */ List Nl(String str) {
        AppMethodBeat.i(136732);
        String str2 = "%s/feature_%s.conf";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String gw = aa.gw(ah.getContext());
        if (gw.equalsIgnoreCase("zh_CN")) {
            gw = "zh_CN".toLowerCase();
        } else if (gw.equalsIgnoreCase("zh_TW") || gw.equalsIgnoreCase("zh_HK")) {
            gw = "zh_TW".toLowerCase();
        } else {
            gw = "en".toLowerCase();
        }
        objArr[1] = gw;
        gw = String.format(str2, objArr);
        ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "decodeToFeatureList %s", gw);
        long ata = e.ata(gw);
        int asZ = (int) e.asZ(gw);
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.plugin.fts.a.a.n nVar;
        if (asZ == 0) {
            nVar = new com.tencent.mm.plugin.fts.a.a.n("data file no exist error");
            AppMethodBeat.o(136732);
            throw nVar;
        }
        String[] split = new String(e.e(gw, 0, asZ)).split(IOUtils.LINE_SEPARATOR_UNIX);
        com.tencent.mm.plugin.fts.a.a.c cVar = null;
        for (String str3 : split) {
            String str32;
            if (str32 != null) {
                str32 = str32.trim();
                if (str32.length() != 0) {
                    int indexOf = str32.indexOf("=");
                    if (indexOf >= 0) {
                        String substring = str32.substring(0, indexOf);
                        str32 = str32.substring(indexOf + 1);
                        if (substring.equals("FeatureID")) {
                            if (cVar != null) {
                                cVar.field_iconPath = str + "/icon/" + cVar.field_featureId + ".png";
                                arrayList.add(cVar);
                            }
                            cVar = new com.tencent.mm.plugin.fts.a.a.c();
                            cVar.field_featureId = Integer.valueOf(str32).intValue();
                            cVar.field_timestamp = ata;
                        }
                        if (cVar != null) {
                            if (substring.equals("Title")) {
                                cVar.field_title = str32;
                            } else if (substring.equals("TitlePY")) {
                                cVar.field_titlePY = str32;
                            } else if (substring.equals("TitleShortPY")) {
                                cVar.field_titleShortPY = str32;
                            } else if (substring.equals("Tag")) {
                                cVar.field_tag = str32;
                            } else if (substring.equals("ActionType")) {
                                if (str32.equals("H5")) {
                                    cVar.field_actionType = 2;
                                } else if (str32.equals("Native")) {
                                    cVar.field_actionType = 1;
                                }
                            } else if (substring.equals("Url")) {
                                cVar.field_url = str32;
                            } else if (substring.equals("HelpUrl")) {
                                cVar.field_helpUrl = str32;
                            } else if (substring.equals("UpdateUrl")) {
                                cVar.field_updateUrl = str32;
                            } else if (substring.equals("AndroidUrl")) {
                                cVar.field_androidUrl = str32;
                            }
                        }
                    }
                }
            }
        }
        if (cVar != null) {
            cVar.field_iconPath = str + "/icon/" + cVar.field_featureId + ".png";
            cVar.field_timestamp = ata;
            arrayList.add(cVar);
        }
        if (arrayList.size() == 0) {
            nVar = new com.tencent.mm.plugin.fts.a.a.n("no data error");
            AppMethodBeat.o(136732);
            throw nVar;
        }
        AppMethodBeat.o(136732);
        return arrayList;
    }
}
