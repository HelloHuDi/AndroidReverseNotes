package com.tencent.p177mm.plugin.fav.p408b.p968a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C28113j;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aaw;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abs;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.b.a.b */
public final class C27976b extends C24765b {
    C12028m eAX;
    private C28113j mgD;
    C11857a mgE;
    C4927e mgF;
    private C4931a mgG = new C206811();

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$f */
    class C11858f extends C20844h {
        C11858f(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchTopFavoriteTask";
        }

        public final int getId() {
            return 9;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            InterruptedException interruptedException;
            AppMethodBeat.m2504i(5310);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            C11857a c11857a = C27976b.this.mgE;
            int i = this.mEl.mEt + 1;
            String bAl = c28109j.mDz.bAl();
            Cursor rawQuery = c11857a.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1) + ";", new Object[]{c11857a.bAf(), c11857a.bAf(), c11857a.bAg(), c11857a.bAf(), c11857a.bAg(), c11857a.bAg(), bAl}), null);
            c28109j.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            while (rawQuery.moveToNext()) {
                if (hashSet.add(String.valueOf(rawQuery.getLong(3)))) {
                    c28109j.mEy.add(new C39129m().mo62032k(rawQuery));
                    if (c28109j.mEy.size() > this.mEl.mEt) {
                        break;
                    } else if (Thread.interrupted()) {
                        rawQuery.close();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.m2505o(5310);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(5310);
                throw interruptedException;
            }
            AppMethodBeat.m2505o(5310);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$1 */
    class C206811 implements C4931a {
        C206811() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(5301);
            if (c4935m == null) {
                AppMethodBeat.m2505o(5301);
                return;
            }
            int i = c4935m.hsh;
            if (c4935m.obj == null) {
                AppMethodBeat.m2505o(5301);
                return;
            }
            long longValue = ((Long) c4935m.obj).longValue();
            if (longValue < 0) {
                AppMethodBeat.m2505o(5301);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", c4935m);
            switch (i) {
                case 2:
                case 3:
                    C27976b.this.eAX.mo23853a(65576, new C20682d(C27976b.this, longValue, (byte) 0));
                    AppMethodBeat.m2505o(5301);
                    return;
                case 5:
                    C27976b.this.eAX.mo23853a(65576, new C27978b(longValue));
                    break;
            }
            AppMethodBeat.m2505o(5301);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$d */
    class C20682d extends C28106a {
        private long mgM;
        private int mgO;

        /* synthetic */ C20682d(C27976b c27976b, long j, byte b) {
            this(j);
        }

        private C20682d(long j) {
            this.mgM = j;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(5307);
            if (C27976b.this.mgF == null) {
                C4990ab.m7412e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
                AppMethodBeat.m2505o(5307);
            } else {
                C4990ab.m7410d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
                Cursor a = C27976b.this.mgF.mo10104a("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.mgM)}, 2);
                try {
                    if (a.moveToFirst()) {
                        C27979c c27979c = new C27979c(C27976b.this, (byte) 0);
                        c27979c.mo45901d(a);
                        a.close();
                        a = null;
                        C27976b.this.mgE.beginTransaction();
                        C27976b.this.mgE.mo73846c(C34202c.mCd, this.mgM);
                        this.mgO = C27976b.m44539a(C27976b.this, c27979c);
                        C27976b.this.mgE.commit();
                    }
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(5307);
                } catch (Exception e) {
                    AppMethodBeat.m2505o(5307);
                    throw e;
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(5307);
                }
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(5308);
            String format = String.format("{favItemId: %d transactionCount: %d}", new Object[]{Long.valueOf(this.mgM), Integer.valueOf(this.mgO)});
            AppMethodBeat.m2505o(5308);
            return format;
        }

        public final String getName() {
            return "InsertFavItemTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$e */
    class C27975e extends C20844h {
        C27975e(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchFavoriteTask";
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            InterruptedException interruptedException;
            AppMethodBeat.m2504i(5309);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            HashMap hashMap = new HashMap();
            Cursor a = C27976b.this.mgE.mo73837a(c28109j.mDz, C34202c.mCd, null, false, false);
            while (a.moveToNext()) {
                C39129m k = new C39129m().mo62032k(a);
                C45966l c45966l = (C45966l) hashMap.get(Long.valueOf(k.mEB));
                if (c45966l == null || C3161d.m5416f(C34202c.mCw, k.mDw, c45966l.mDw) < 0) {
                    hashMap.put(Long.valueOf(k.mEB), k);
                }
                if (Thread.interrupted()) {
                    a.close();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(5309);
                    throw interruptedException;
                }
            }
            a.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(5309);
                throw interruptedException;
            }
            c28109j.mEy = new ArrayList(hashMap.size());
            for (C39129m add : hashMap.values()) {
                c28109j.mEy.add(add);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(5309);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$a */
    class C27977a extends C28106a {
        private int mFailedCount;
        private HashSet<Long> mgI;
        private int mgJ;
        private int mgK;
        private int mgL;

        private C27977a() {
            this.mgI = null;
            this.mgJ = 0;
            this.mgK = 0;
            this.mgL = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ C27977a(C27976b c27976b, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            Exception e;
            Throwable th;
            AppMethodBeat.m2504i(5302);
            if (C27976b.this.mgF == null) {
                C4990ab.m7420w("MicroMsg.FTS.FTS5SearchFavoriteLogic", "favorite db is null, you need to wait the favorite db event!");
                AppMethodBeat.m2505o(5302);
            } else {
                C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to build favorite index!");
                if (this.mgI == null) {
                    this.mgI = new HashSet();
                    Cursor a;
                    try {
                        a = C27976b.this.mgE.mo73838a(C34202c.mCd, false, true, false, false, false);
                        while (a.moveToNext()) {
                            try {
                                this.mgI.add(Long.valueOf(a.getLong(0)));
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    AppMethodBeat.m2505o(5302);
                                    throw e;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a != null) {
                                    }
                                    AppMethodBeat.m2505o(5302);
                                    throw th;
                                }
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                        this.mgJ = this.mgI.size();
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                    } catch (Throwable th3) {
                        th = th3;
                        a = null;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(5302);
                        throw th;
                    }
                }
                InterruptedException interruptedException;
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(5302);
                    throw interruptedException;
                }
                int i;
                Cursor rawQuery = C27976b.this.mgF.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE flag <> -1;", null);
                int i2 = 50;
                while (rawQuery.moveToNext()) {
                    try {
                        if (Thread.interrupted()) {
                            C27976b.this.mgE.commit();
                            interruptedException = new InterruptedException();
                            AppMethodBeat.m2505o(5302);
                            throw interruptedException;
                        }
                        C27979c c27979c = new C27979c(C27976b.this, (byte) 0);
                        c27979c.mo45901d(rawQuery);
                        if (!this.mgI.remove(Long.valueOf(c27979c.fDy))) {
                            if (i2 >= 50) {
                                C27976b.this.mgE.commit();
                                C27976b.this.mgE.beginTransaction();
                                i = 0;
                            } else {
                                i = i2;
                            }
                            try {
                                i += C27976b.m44539a(C27976b.this, c27979c);
                                this.mgK++;
                                i2 = i;
                            } catch (Exception e4) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFavoriteLogic", e4, "Build favorite index failed with exception.\n", new Object[0]);
                                this.mFailedCount++;
                                i2 = i;
                            }
                        }
                    } catch (Exception e42) {
                        AppMethodBeat.m2505o(5302);
                        throw e42;
                    } catch (Throwable th4) {
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        AppMethodBeat.m2505o(5302);
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                C27976b.this.mgE.commit();
                Iterator it = this.mgI.iterator();
                while (it.hasNext()) {
                    if (Thread.interrupted()) {
                        C27976b.this.mgE.commit();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.m2505o(5302);
                        throw interruptedException;
                    }
                    if (i2 >= 50) {
                        C27976b.this.mgE.commit();
                        C27976b.this.mgE.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    C27976b.this.mgE.mo73846c(C34202c.mCd, ((Long) it.next()).longValue());
                    i2 = i + 1;
                    this.mgL++;
                    it.remove();
                }
                C27976b.this.mgE.commit();
                AppMethodBeat.m2505o(5302);
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(5303);
            String format = String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.mgK), Integer.valueOf(this.mgJ), Integer.valueOf(this.mgL), Integer.valueOf(this.mFailedCount)});
            AppMethodBeat.m2505o(5303);
            return format;
        }

        public final String getName() {
            return "BuildFavoriteIndexTask";
        }

        public final int getId() {
            return 6;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$b */
    class C27978b extends C28106a {
        private long mgM;

        public C27978b(long j) {
            this.mgM = j;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(5304);
            C4990ab.m7410d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
            C27976b.this.mgE.mo73846c(C34202c.mCd, this.mgM);
            AppMethodBeat.m2505o(5304);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(5305);
            String format = String.format("{favItemId: %d}", new Object[]{Long.valueOf(this.mgM)});
            AppMethodBeat.m2505o(5305);
            return format;
        }

        public final String getName() {
            return "DeleteFavItemTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.a.b$c */
    class C27979c {
        String cEV;
        abf cKb;
        long fDy;
        abs mgN;
        int type;
        long updateTime;

        private C27979c() {
        }

        /* synthetic */ C27979c(C27976b c27976b, byte b) {
            this();
        }

        /* renamed from: d */
        public final void mo45901d(Cursor cursor) {
            AppMethodBeat.m2504i(5306);
            this.fDy = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.updateTime = cursor.getLong(2);
            this.cEV = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                C4990ab.m7410d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.cKb = new abf();
            } else {
                this.cKb = (abf) new abf().parseFrom(blob);
            }
            blob = cursor.getBlob(5);
            if (blob == null || blob.length == 0) {
                this.mgN = null;
                AppMethodBeat.m2505o(5306);
                return;
            }
            this.mgN = (abs) new abs().parseFrom(blob);
            AppMethodBeat.m2505o(5306);
        }
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        C28106a c11858f;
        AppMethodBeat.m2504i(5311);
        if (c20846i.hbo == 1) {
            c11858f = new C11858f(c20846i);
        } else {
            c11858f = new C27975e(c20846i);
        }
        c11858f = this.eAX.mo23853a(-65536, c11858f);
        AppMethodBeat.m2505o(5311);
        return c11858f;
    }

    public C27976b() {
        AppMethodBeat.m2504i(5312);
        AppMethodBeat.m2505o(5312);
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(5313);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.mgE = (C11857a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(256);
            this.mgD = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB();
            this.mgF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buR();
            this.eAX.mo23853a(131122, new C27977a(this, (byte) 0));
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(this.mgG);
            AppMethodBeat.m2505o(5313);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
        AppMethodBeat.m2505o(5313);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(5314);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(this.mgG);
        this.mgE = null;
        this.eAX = null;
        AppMethodBeat.m2505o(5314);
        return true;
    }

    public final String getName() {
        return "FTS5SearchFavoriteLogic";
    }

    /* renamed from: a */
    private int m44540a(String[] strArr, int[] iArr, long j, int i, long j2, String str) {
        AppMethodBeat.m2504i(5315);
        int i2 = 0;
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        if (str2 != null && str2.length() > 0) {
            String str5;
            String str6;
            String str7;
            if (str2.equalsIgnoreCase(str3)) {
                str5 = null;
                str6 = null;
            } else {
                str5 = str3;
                str6 = str4;
            }
            if (str5 == null || !str5.equalsIgnoreCase(str6)) {
                str7 = str6;
            } else {
                str7 = null;
            }
            this.mgE.mo23704a(iArr[0], j, str, j2, str2, i);
            int i3 = 1;
            if (str5 != null && str5.length() > 0) {
                this.mgE.mo23704a(iArr[1], j, str, j2, str5, i);
                i3 = 2;
            }
            if (str7 == null || str7.length() <= 0) {
                i2 = i3;
            } else {
                this.mgE.mo23704a(iArr[2], j, str, j2, str7, i);
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.m2505o(5315);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ int m44539a(C27976b c27976b, C27979c c27979c) {
        AppMethodBeat.m2504i(5316);
        long j = c27979c.fDy;
        int i = c27979c.type;
        long j2 = c27979c.updateTime;
        String str = c27979c.cEV;
        abf abf = c27979c.cKb;
        aaw a = C39037b.m66347a(i, abf, c27979c.mgN);
        if (a == null) {
            C4990ab.m7410d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Fav info is null");
            AppMethodBeat.m2505o(5316);
            return 0;
        }
        String str2;
        String str3;
        int a2;
        C7616ad MU;
        int a3;
        C7616ad MU2;
        int a4;
        LinkedList<String> linkedList;
        StringBuilder stringBuilder;
        String str4 = a.wif;
        String str5 = a.cEV;
        if (str4 == null || str4.length() == 0 || str4.equals(str5)) {
            str2 = null;
            str3 = a.cEV;
        } else {
            str2 = str5;
            str3 = str4;
        }
        String str6 = a.csl;
        String[] strArr = new String[3];
        int[] iArr = new int[3];
        if (str3 != null && str3.length() > 0) {
            C7616ad MU3 = c27976b.mgD.mo46033MU(str3);
            if (MU3 != null) {
                String str7;
                String str8;
                String str9;
                String str10 = MU3.field_nickname;
                str3 = C3161d.m5410aL(str10, false);
                String aL = C3161d.m5410aL(str10, true);
                String str11 = MU3.field_conRemark;
                str5 = C3161d.m5410aL(str11, false);
                String aL2 = C3161d.m5410aL(str11, true);
                if (str11 == null || str11.length() == 0) {
                    str7 = null;
                    str8 = null;
                    str9 = null;
                    str5 = str3;
                    str11 = str10;
                    aL2 = aL;
                } else {
                    str9 = aL;
                    str8 = str3;
                    str7 = str10;
                }
                strArr[0] = str11;
                strArr[1] = str5;
                strArr[2] = aL2;
                iArr[0] = 9;
                iArr[1] = 10;
                iArr[2] = 11;
                a2 = c27976b.m44540a(strArr, iArr, j, i, j2, str) + 0;
                strArr[0] = str7;
                strArr[1] = str8;
                strArr[2] = str9;
                iArr[0] = 12;
                iArr[1] = 13;
                iArr[2] = 14;
                a2 += c27976b.m44540a(strArr, iArr, j, i, j2, str);
                if (str2 != null && str2.length() > 0) {
                    MU = c27976b.mgD.mo46033MU(str2);
                    if (MU != null) {
                        str5 = MU.field_conRemark;
                        if (str5 == null || str5.length() == 0) {
                            str5 = MU.field_nickname;
                        }
                        str2 = C3161d.m5410aL(str5, false);
                        str9 = C3161d.m5410aL(str5, true);
                        strArr[0] = str5;
                        strArr[1] = str2;
                        strArr[2] = str9;
                        iArr[0] = 16;
                        iArr[1] = 17;
                        iArr[2] = 18;
                        a3 = a2 + c27976b.m44540a(strArr, iArr, j, i, j2, str);
                        if (str6 != null && str6.length() > 0) {
                            MU2 = c27976b.mgD.mo46033MU(str6);
                            if (MU2 != null) {
                                str5 = MU2.field_conRemark;
                                if (str5 == null || str5.length() == 0) {
                                    str5 = MU2.field_nickname;
                                }
                                str3 = C3161d.m5410aL(str5, false);
                                str9 = C3161d.m5410aL(str5, true);
                                strArr[0] = str5;
                                strArr[1] = str3;
                                strArr[2] = str9;
                                iArr[0] = 20;
                                iArr[1] = 21;
                                iArr[2] = 22;
                                a4 = c27976b.m44540a(strArr, iArr, j, i, j2, str) + a3;
                                linkedList = a.wig;
                                stringBuilder = new StringBuilder(256);
                                for (String str52 : linkedList) {
                                    if (str52 != null && str52.length() > 0) {
                                        stringBuilder.append(str52).append("​");
                                    }
                                }
                                if (stringBuilder.length() > 0) {
                                    c27976b.mgE.mo23704a(7, j, str, j2, stringBuilder.toString(), i);
                                    a4++;
                                }
                                switch (i) {
                                    case 2:
                                        aL2 = a.title;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(23, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                    case 5:
                                        aL2 = a.title;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(1, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                    case 6:
                                        int i2;
                                        aL2 = abf.hHV;
                                        if (C5046bo.isNullOrNil(aL2)) {
                                            i2 = a4;
                                        } else {
                                            c27976b.mgE.mo23704a(4, j, str, j2, aL2, i);
                                            i2 = a4 + 1;
                                        }
                                        aL2 = abf.why.cIK;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(5, j, str, j2, aL2, i);
                                            i2++;
                                        }
                                        aL2 = abf.why.label;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(6, j, str, j2, aL2, i);
                                            a4 = i2 + 1;
                                            break;
                                        }
                                        a4 = i2;
                                        break;
                                    case 7:
                                        aL2 = a.title;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(1, j, str, j2, aL2, i);
                                            a4++;
                                        }
                                        aL2 = a.desc;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(3, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                    case 14:
                                        if (abf.wiv != null) {
                                            StringBuffer stringBuffer = new StringBuffer();
                                            Iterator it = abf.wiv.iterator();
                                            while (it.hasNext()) {
                                                str52 = C39037b.m66348a((aar) it.next());
                                                if (!C5046bo.isNullOrNil(str52)) {
                                                    stringBuilder.append(str52);
                                                    stringBuilder.append("​");
                                                }
                                            }
                                            aL2 = stringBuffer.toString();
                                            if (!C5046bo.isNullOrNil(aL2)) {
                                                c27976b.mgE.mo23704a(1, j, str, j2, aL2, i);
                                                a4++;
                                                break;
                                            }
                                        }
                                        break;
                                    default:
                                        aL2 = a.title;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(1, j, str, j2, aL2, i);
                                            a4++;
                                        }
                                        aL2 = a.desc;
                                        if (!C5046bo.isNullOrNil(aL2)) {
                                            c27976b.mgE.mo23704a(2, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.m2505o(5316);
                                return a4;
                            }
                        }
                        a4 = a3;
                        linkedList = a.wig;
                        stringBuilder = new StringBuilder(256);
                        for (String str522 : linkedList) {
                        }
                        if (stringBuilder.length() > 0) {
                        }
                        switch (i) {
                            case 2:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 14:
                                break;
                            default:
                                break;
                        }
                        AppMethodBeat.m2505o(5316);
                        return a4;
                    }
                }
                a3 = a2;
                MU2 = c27976b.mgD.mo46033MU(str6);
                if (MU2 != null) {
                }
                a4 = a3;
                linkedList = a.wig;
                stringBuilder = new StringBuilder(256);
                for (String str5222 : linkedList) {
                }
                if (stringBuilder.length() > 0) {
                }
                switch (i) {
                    case 2:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 14:
                        break;
                    default:
                        break;
                }
                AppMethodBeat.m2505o(5316);
                return a4;
            }
        }
        a2 = 0;
        MU = c27976b.mgD.mo46033MU(str2);
        if (MU != null) {
        }
        a3 = a2;
        MU2 = c27976b.mgD.mo46033MU(str6);
        if (MU2 != null) {
        }
        a4 = a3;
        linkedList = a.wig;
        stringBuilder = new StringBuilder(256);
        for (String str52222 : linkedList) {
        }
        if (stringBuilder.length() > 0) {
        }
        switch (i) {
            case 2:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 14:
                break;
            default:
                break;
        }
        AppMethodBeat.m2505o(5316);
        return a4;
    }
}
