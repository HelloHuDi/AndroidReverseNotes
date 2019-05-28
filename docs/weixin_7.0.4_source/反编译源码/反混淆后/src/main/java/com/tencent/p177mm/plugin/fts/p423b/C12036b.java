package com.tencent.p177mm.plugin.fts.p423b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32645ts;
import com.tencent.p177mm.plugin.fts.PluginFTS;
import com.tencent.p177mm.plugin.fts.p1265c.C39136b;
import com.tencent.p177mm.plugin.fts.p1265c.C39136b.C34225a;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43120c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45967n;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5731f;
import com.tencent.p177mm.vfs.C5736j;
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

/* renamed from: com.tencent.mm.plugin.fts.b.b */
public final class C12036b extends C24765b {
    C12028m eAX;
    private C4884c<C32519bf> fAP = new C120372();
    private C4884c mFG = new C120421();
    C39136b mGl;

    /* renamed from: com.tencent.mm.plugin.fts.b.b$2 */
    class C120372 extends C4884c<C32519bf> {
        C120372() {
            AppMethodBeat.m2504i(136716);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(136716);
        }

        /* renamed from: a */
        private boolean m19952a(C32519bf c32519bf) {
            AppMethodBeat.m2504i(136717);
            if (c32519bf.cus.cut == 35 && c32519bf.cus.cuu == 1) {
                C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", c32519bf.cus.filePath);
                C12036b c12036b = C12036b.this;
                String str = c32519bf.cus.filePath;
                C5728b c5728b = new C5728b(C12036b.bAx(), "temp");
                if (c5728b.exists()) {
                    C5730e.m8618N(C5736j.m8649w(c5728b.dMD()), true);
                }
                c5728b.mkdirs();
                try {
                    C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", str, Integer.valueOf(C5730e.m8636iu(str, C5736j.m8649w(c5728b.dMD()))));
                    if (C5730e.m8636iu(str, C5736j.m8649w(c5728b.dMD())) >= 0) {
                        C5728b bAy = C12036b.bAy();
                        C5728b c5728b2 = new C5728b(c5728b, "fts_feature");
                        C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", Integer.valueOf(C12036b.m19949j(c5728b2)), Integer.valueOf(C12036b.m19949j(bAy)));
                        if (C12036b.m19949j(c5728b2) > C12036b.m19949j(bAy)) {
                            C5730e.m8618N(C5736j.m8649w(bAy.dMD()), true);
                            c5728b2.mo11675o(bAy);
                            c12036b.eAX.mo23853a(65596, new C12041d(C5736j.m8649w(bAy.dMD())));
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "updateFeatureList", new Object[0]);
                    C7053e.pXa.mo8378a(146, 22, 1, false);
                }
            }
            AppMethodBeat.m2505o(136717);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.b$a */
    class C12038a extends C28106a {
        private int mGn;
        private int mGo;

        private C12038a() {
        }

        /* synthetic */ C12038a(C12036b c12036b, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136719);
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
            C39136b c39136b = C12036b.this.mGl;
            List arrayList = new ArrayList();
            Cursor rawQuery = c39136b.mBT.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
            while (rawQuery.moveToNext()) {
                C43120c c43120c = new C43120c();
                c43120c.mo8995d(rawQuery);
                arrayList.add(c43120c);
            }
            rawQuery.close();
            if (arrayList.size() == 0) {
                try {
                    arrayList = C12036b.m19948Nl(C5736j.m8649w(C12036b.bAy().dMD()));
                    C12036b.this.mGl.mo62038bZ(arrayList);
                } catch (Exception e) {
                }
            }
            List<C34225a> bAI = C12036b.this.mGl.bAI();
            HashMap hashMap = new HashMap();
            for (C43120c c43120c2 : arrayList) {
                hashMap.put(Integer.valueOf(c43120c2.field_featureId), c43120c2);
            }
            if (C12036b.this.mGl.mBT.inTransaction()) {
                C12036b.this.mGl.commit();
            }
            C12036b.this.mGl.beginTransaction();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (C34225a c34225a : bAI) {
                C43120c c43120c3 = (C43120c) hashMap.remove(Integer.valueOf(c34225a.mHi));
                if (c43120c3 == null) {
                    hashSet.add(Integer.valueOf(c34225a.mHi));
                } else if (c34225a.timestamp != c43120c3.field_timestamp) {
                    hashSet2.add(c43120c3);
                    C12036b.this.mGl.mo73846c(C34202c.mCe, (long) c43120c3.field_featureId);
                    ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic().mo73855d(C34202c.mCe, String.valueOf(c43120c3.field_featureId));
                }
            }
            hashSet2.addAll(hashMap.values());
            C12036b.this.mGl.commit();
            C12036b.this.mGl.beginTransaction();
            this.mGn = hashSet.size();
            this.mGo = hashSet2.size();
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                C43120c c43120c4 = (C43120c) it.next();
                C12036b c12036b = C12036b.this;
                c12036b.mGl.mo73839a(262144, 1, (long) c43120c4.field_featureId, String.valueOf(c43120c4.field_featureId), c43120c4.field_timestamp, c43120c4.field_title);
                String aL = C3161d.m5410aL(c43120c4.field_title, false);
                if (!C5046bo.isNullOrNil(aL)) {
                    c12036b.mGl.mo73839a(262144, 2, (long) c43120c4.field_featureId, String.valueOf(c43120c4.field_featureId), c43120c4.field_timestamp, aL);
                }
                aL = C3161d.m5410aL(c43120c4.field_title, true);
                if (!C5046bo.isNullOrNil(aL)) {
                    c12036b.mGl.mo73839a(262144, 3, (long) c43120c4.field_featureId, String.valueOf(c43120c4.field_featureId), c43120c4.field_timestamp, aL);
                }
                c12036b.mGl.mo73839a(262144, 4, (long) c43120c4.field_featureId, String.valueOf(c43120c4.field_featureId), c43120c4.field_timestamp, c43120c4.field_tag);
                ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic().mo73854Nn(String.valueOf(c43120c4.field_featureId));
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                C12036b.this.mGl.mo73846c(C34202c.mCe, (long) ((Integer) it2.next()).intValue());
            }
            C12036b.this.mGl.commit();
            AppMethodBeat.m2505o(136719);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136720);
            String format = String.format("{remove: %d add: %d}", new Object[]{Integer.valueOf(this.mGn), Integer.valueOf(this.mGo)});
            AppMethodBeat.m2505o(136720);
            return format;
        }

        public final String getName() {
            return "BuildFeatureIndexTask";
        }

        public final int getId() {
            return 5;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.b$b */
    class C12039b extends C28106a {
        private C12039b() {
        }

        /* synthetic */ C12039b(C12036b c12036b, byte b) {
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
            OutputStream c5731f;
            Throwable e;
            AppMethodBeat.m2504i(136721);
            int j = C12036b.m19949j(C12036b.bAy());
            int bAz = C12036b.bAz();
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d, pkgversion:%s", Integer.valueOf(j), Integer.valueOf(bAz));
            if (bAz > j && bAz > 0) {
                j = -1;
            }
            if (j < 0) {
                C5728b c5728b = new C5728b(C4996ah.getContext().getCacheDir(), "fts_feature.zip");
                try {
                    open = C4996ah.getContext().getAssets().open("fts_feature.zip");
                    try {
                        if (c5728b.exists()) {
                            c5728b.delete();
                        }
                        c5731f = new C5731f(c5728b);
                    } catch (Exception e2) {
                        e = e2;
                        c5731f = null;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                            if (open != null) {
                            }
                            if (c5731f != null) {
                            }
                            if (c5728b.exists()) {
                            }
                            AppMethodBeat.m2505o(136721);
                            return true;
                        } catch (Throwable th) {
                            e = th;
                            if (open != null) {
                            }
                            if (c5731f != null) {
                            }
                            AppMethodBeat.m2505o(136721);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        c5731f = null;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (c5731f != null) {
                            try {
                                c5731f.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.m2505o(136721);
                        throw e;
                    }
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = open.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            c5731f.write(bArr, 0, read);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e5) {
                            }
                        }
                        try {
                            c5731f.close();
                        } catch (IOException e6) {
                        }
                    } catch (Exception e7) {
                        e = e7;
                        C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (c5731f != null) {
                            try {
                                c5731f.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (c5728b.exists()) {
                        }
                        AppMethodBeat.m2505o(136721);
                        return true;
                    }
                } catch (Exception e10) {
                    e = e10;
                    c5731f = null;
                    open = null;
                } catch (Throwable th3) {
                    e = th3;
                    c5731f = null;
                    open = null;
                    if (open != null) {
                    }
                    if (c5731f != null) {
                    }
                    AppMethodBeat.m2505o(136721);
                    throw e;
                }
                if (c5728b.exists()) {
                    C4883b c32519bf = new C32519bf();
                    c32519bf.cus.cut = 35;
                    c32519bf.cus.cuu = 1;
                    c32519bf.cus.filePath = C5736j.m8649w(c5728b.dMD());
                    C4879a.xxA.mo10048a(c32519bf, Looper.getMainLooper());
                }
            }
            AppMethodBeat.m2505o(136721);
            return true;
        }

        public final String getName() {
            return "CheckFeatureResourceTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.b$c */
    class C12040c extends C20844h {
        /* synthetic */ C12040c(C12036b c12036b, C20846i c20846i, byte b) {
            this(c20846i);
        }

        private C12040c(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchFeatureTask";
        }

        public final int getId() {
            return 12;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136722);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            c28109j.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = C12036b.this.mGl.mo73837a(c28109j.mDz, C34202c.mCe, this.mEl.mEs, true, true);
            while (a.moveToNext()) {
                C39129m c39129m = new C39129m();
                c39129m.mo62032k(a);
                if (!(hashSet.contains(Long.valueOf(c39129m.mEB)) || this.mEl.mEu.contains(c39129m.mDx))) {
                    c39129m.bAo();
                    c28109j.mEy.add(c39129m);
                    hashSet.add(Long.valueOf(c39129m.mEB));
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136722);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            for (C45966l c45966l : c28109j.mEy) {
                c45966l.userData = C12036b.this.mGl.mo62039wa((int) c45966l.mEB);
            }
            AppMethodBeat.m2505o(136722);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.b$d */
    class C12041d extends C28106a {
        private String path;

        public C12041d(String str) {
            this.path = str;
        }

        public final String getName() {
            return "UpdateFeatureIndexTask";
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136723);
            List Nl = C12036b.m19948Nl(this.path);
            C12036b.this.mGl.beginTransaction();
            C12036b.this.mGl.mo62038bZ(Nl);
            C12036b.this.mGl.commit();
            C12036b.this.mGl.mo73853s(C34202c.mCe);
            C12036b.this.eAX.mo23853a(131132, new C12038a(C12036b.this, (byte) 0));
            C45971e topHitsLogic = ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mGO.mo73850g(C34202c.mCe, 1);
            AppMethodBeat.m2505o(136723);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.b$1 */
    class C120421 extends C4884c<C32645ts> {
        C120421() {
            AppMethodBeat.m2504i(136714);
            this.xxI = C32645ts.class.getName().hashCode();
            AppMethodBeat.m2505o(136714);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136715);
            C12036b.this.eAX.mo23853a(65596, new C12041d(C5736j.m8649w(C12036b.bAy().dMD())));
            AppMethodBeat.m2505o(136715);
            return true;
        }
    }

    public C12036b() {
        AppMethodBeat.m2504i(136724);
        AppMethodBeat.m2505o(136724);
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        AppMethodBeat.m2504i(136725);
        C28106a a = this.eAX.mo23853a(-65536, new C12040c(this, c20846i, (byte) 0));
        AppMethodBeat.m2505o(136725);
        return a;
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(136726);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.mGl = (C39136b) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(17);
            this.mFG.dnU();
            this.fAP.dnU();
            this.eAX.mo23853a(131132, new C12039b(this, (byte) 0));
            this.eAX.mo23853a(131133, new C12038a(this, (byte) 0));
            AppMethodBeat.m2505o(136726);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
        AppMethodBeat.m2505o(136726);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(136727);
        this.mFG.dead();
        this.fAP.dead();
        this.mGl = null;
        this.eAX = null;
        AppMethodBeat.m2505o(136727);
        return true;
    }

    public final String getName() {
        return "FTS5SearchFeatureLogic";
    }

    public static C5728b bAx() {
        AppMethodBeat.m2504i(136728);
        C5728b c5728b = new C5728b(new C5728b(C6457e.eSk, "fts"), "feature");
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(136728);
        return c5728b;
    }

    public static C5728b bAy() {
        AppMethodBeat.m2504i(136729);
        C5728b c5728b = new C5728b(C12036b.bAx(), "fts_feature");
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(136729);
        return c5728b;
    }

    /* renamed from: j */
    static int m19949j(C5728b c5728b) {
        AppMethodBeat.m2504i(136730);
        C5728b c5728b2 = new C5728b(c5728b, "version.info");
        int i = -1;
        try {
            if (c5728b2.exists()) {
                i = Integer.parseInt(C5730e.m8631cy(C5736j.m8649w(c5728b2.dMD())), 10);
            } else {
                C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", C5736j.m8649w(c5728b2.dMD()));
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "getFeatureVersion", new Object[0]);
        }
        AppMethodBeat.m2505o(136730);
        return i;
    }

    static int bAz() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(136731);
        int i = -1;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(C4996ah.getContext().getAssets().open("fts/version.info")));
            try {
                i = Integer.valueOf(bufferedReader.readLine()).intValue();
                C5046bo.m7527b(bufferedReader);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, e.getMessage(), new Object[0]);
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(136731);
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(136731);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, e.getMessage(), new Object[0]);
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(136731);
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(136731);
            throw th;
        }
        AppMethodBeat.m2505o(136731);
        return i;
    }

    /* renamed from: Nl */
    static /* synthetic */ List m19948Nl(String str) {
        AppMethodBeat.m2504i(136732);
        String str2 = "%s/feature_%s.conf";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String gw = C4988aa.m7403gw(C4996ah.getContext());
        if (gw.equalsIgnoreCase("zh_CN")) {
            gw = "zh_CN".toLowerCase();
        } else if (gw.equalsIgnoreCase("zh_TW") || gw.equalsIgnoreCase("zh_HK")) {
            gw = "zh_TW".toLowerCase();
        } else {
            gw = "en".toLowerCase();
        }
        objArr[1] = gw;
        gw = String.format(str2, objArr);
        C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFeatureLogic", "decodeToFeatureList %s", gw);
        long ata = C5730e.ata(gw);
        int asZ = (int) C5730e.asZ(gw);
        ArrayList arrayList = new ArrayList();
        C45967n c45967n;
        if (asZ == 0) {
            c45967n = new C45967n("data file no exist error");
            AppMethodBeat.m2505o(136732);
            throw c45967n;
        }
        String[] split = new String(C5730e.m8632e(gw, 0, asZ)).split(IOUtils.LINE_SEPARATOR_UNIX);
        C43120c c43120c = null;
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
                            if (c43120c != null) {
                                c43120c.field_iconPath = str + "/icon/" + c43120c.field_featureId + ".png";
                                arrayList.add(c43120c);
                            }
                            c43120c = new C43120c();
                            c43120c.field_featureId = Integer.valueOf(str32).intValue();
                            c43120c.field_timestamp = ata;
                        }
                        if (c43120c != null) {
                            if (substring.equals("Title")) {
                                c43120c.field_title = str32;
                            } else if (substring.equals("TitlePY")) {
                                c43120c.field_titlePY = str32;
                            } else if (substring.equals("TitleShortPY")) {
                                c43120c.field_titleShortPY = str32;
                            } else if (substring.equals("Tag")) {
                                c43120c.field_tag = str32;
                            } else if (substring.equals("ActionType")) {
                                if (str32.equals("H5")) {
                                    c43120c.field_actionType = 2;
                                } else if (str32.equals("Native")) {
                                    c43120c.field_actionType = 1;
                                }
                            } else if (substring.equals("Url")) {
                                c43120c.field_url = str32;
                            } else if (substring.equals("HelpUrl")) {
                                c43120c.field_helpUrl = str32;
                            } else if (substring.equals("UpdateUrl")) {
                                c43120c.field_updateUrl = str32;
                            } else if (substring.equals("AndroidUrl")) {
                                c43120c.field_androidUrl = str32;
                            }
                        }
                    }
                }
            }
        }
        if (c43120c != null) {
            c43120c.field_iconPath = str + "/icon/" + c43120c.field_featureId + ".png";
            c43120c.field_timestamp = ata;
            arrayList.add(c43120c);
        }
        if (arrayList.size() == 0) {
            c45967n = new C45967n("no data error");
            AppMethodBeat.m2505o(136732);
            throw c45967n;
        }
        AppMethodBeat.m2505o(136732);
        return arrayList;
    }
}
