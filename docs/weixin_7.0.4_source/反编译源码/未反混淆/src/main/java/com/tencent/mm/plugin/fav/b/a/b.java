package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m eAX;
    private j mgD;
    a mgE;
    com.tencent.mm.sdk.e.e mgF;
    private com.tencent.mm.sdk.e.k.a mgG = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(5301);
            if (mVar == null) {
                AppMethodBeat.o(5301);
                return;
            }
            int i = mVar.hsh;
            if (mVar.obj == null) {
                AppMethodBeat.o(5301);
                return;
            }
            long longValue = ((Long) mVar.obj).longValue();
            if (longValue < 0) {
                AppMethodBeat.o(5301);
                return;
            }
            ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", mVar);
            switch (i) {
                case 2:
                case 3:
                    b.this.eAX.a(65576, new d(b.this, longValue, (byte) 0));
                    AppMethodBeat.o(5301);
                    return;
                case 5:
                    b.this.eAX.a(65576, new b(longValue));
                    break;
            }
            AppMethodBeat.o(5301);
        }
    };

    class f extends h {
        f(i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchTopFavoriteTask";
        }

        public final int getId() {
            return 9;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            InterruptedException interruptedException;
            AppMethodBeat.i(5310);
            jVar.mDz = g.aO(this.mEl.query, true);
            a aVar = b.this.mgE;
            int i = this.mEl.mEt + 1;
            String bAl = jVar.mDz.bAl();
            Cursor rawQuery = aVar.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1) + ";", new Object[]{aVar.bAf(), aVar.bAf(), aVar.bAg(), aVar.bAf(), aVar.bAg(), aVar.bAg(), bAl}), null);
            jVar.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            while (rawQuery.moveToNext()) {
                if (hashSet.add(String.valueOf(rawQuery.getLong(3)))) {
                    jVar.mEy.add(new com.tencent.mm.plugin.fts.a.a.m().k(rawQuery));
                    if (jVar.mEy.size() > this.mEl.mEt) {
                        break;
                    } else if (Thread.interrupted()) {
                        rawQuery.close();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.o(5310);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(5310);
                throw interruptedException;
            }
            AppMethodBeat.o(5310);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private long mgM;
        private int mgO;

        /* synthetic */ d(b bVar, long j, byte b) {
            this(j);
        }

        private d(long j) {
            this.mgM = j;
        }

        public final boolean execute() {
            AppMethodBeat.i(5307);
            if (b.this.mgF == null) {
                ab.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
                AppMethodBeat.o(5307);
            } else {
                ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
                Cursor a = b.this.mgF.a("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.mgM)}, 2);
                try {
                    if (a.moveToFirst()) {
                        c cVar = new c(b.this, (byte) 0);
                        cVar.d(a);
                        a.close();
                        a = null;
                        b.this.mgE.beginTransaction();
                        b.this.mgE.c(com.tencent.mm.plugin.fts.a.c.mCd, this.mgM);
                        this.mgO = b.a(b.this, cVar);
                        b.this.mgE.commit();
                    }
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(5307);
                } catch (Exception e) {
                    AppMethodBeat.o(5307);
                    throw e;
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(5307);
                }
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(5308);
            String format = String.format("{favItemId: %d transactionCount: %d}", new Object[]{Long.valueOf(this.mgM), Integer.valueOf(this.mgO)});
            AppMethodBeat.o(5308);
            return format;
        }

        public final String getName() {
            return "InsertFavItemTask";
        }
    }

    class e extends h {
        e(i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchFavoriteTask";
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            InterruptedException interruptedException;
            AppMethodBeat.i(5309);
            jVar.mDz = g.aO(this.mEl.query, true);
            HashMap hashMap = new HashMap();
            Cursor a = b.this.mgE.a(jVar.mDz, com.tencent.mm.plugin.fts.a.c.mCd, null, false, false);
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(a);
                l lVar = (l) hashMap.get(Long.valueOf(k.mEB));
                if (lVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mCw, k.mDw, lVar.mDw) < 0) {
                    hashMap.put(Long.valueOf(k.mEB), k);
                }
                if (Thread.interrupted()) {
                    a.close();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(5309);
                    throw interruptedException;
                }
            }
            a.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(5309);
                throw interruptedException;
            }
            jVar.mEy = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.m add : hashMap.values()) {
                jVar.mEy.add(add);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(5309);
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int mFailedCount;
        private HashSet<Long> mgI;
        private int mgJ;
        private int mgK;
        private int mgL;

        private a() {
            this.mgI = null;
            this.mgJ = 0;
            this.mgK = 0;
            this.mgL = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            Exception e;
            Throwable th;
            AppMethodBeat.i(5302);
            if (b.this.mgF == null) {
                ab.w("MicroMsg.FTS.FTS5SearchFavoriteLogic", "favorite db is null, you need to wait the favorite db event!");
                AppMethodBeat.o(5302);
            } else {
                ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to build favorite index!");
                if (this.mgI == null) {
                    this.mgI = new HashSet();
                    Cursor a;
                    try {
                        a = b.this.mgE.a(com.tencent.mm.plugin.fts.a.c.mCd, false, true, false, false, false);
                        while (a.moveToNext()) {
                            try {
                                this.mgI.add(Long.valueOf(a.getLong(0)));
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    AppMethodBeat.o(5302);
                                    throw e;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a != null) {
                                    }
                                    AppMethodBeat.o(5302);
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
                        AppMethodBeat.o(5302);
                        throw th;
                    }
                }
                InterruptedException interruptedException;
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(5302);
                    throw interruptedException;
                }
                int i;
                Cursor rawQuery = b.this.mgF.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE flag <> -1;", null);
                int i2 = 50;
                while (rawQuery.moveToNext()) {
                    try {
                        if (Thread.interrupted()) {
                            b.this.mgE.commit();
                            interruptedException = new InterruptedException();
                            AppMethodBeat.o(5302);
                            throw interruptedException;
                        }
                        c cVar = new c(b.this, (byte) 0);
                        cVar.d(rawQuery);
                        if (!this.mgI.remove(Long.valueOf(cVar.fDy))) {
                            if (i2 >= 50) {
                                b.this.mgE.commit();
                                b.this.mgE.beginTransaction();
                                i = 0;
                            } else {
                                i = i2;
                            }
                            try {
                                i += b.a(b.this, cVar);
                                this.mgK++;
                                i2 = i;
                            } catch (Exception e4) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFavoriteLogic", e4, "Build favorite index failed with exception.\n", new Object[0]);
                                this.mFailedCount++;
                                i2 = i;
                            }
                        }
                    } catch (Exception e42) {
                        AppMethodBeat.o(5302);
                        throw e42;
                    } catch (Throwable th4) {
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        AppMethodBeat.o(5302);
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                b.this.mgE.commit();
                Iterator it = this.mgI.iterator();
                while (it.hasNext()) {
                    if (Thread.interrupted()) {
                        b.this.mgE.commit();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.o(5302);
                        throw interruptedException;
                    }
                    if (i2 >= 50) {
                        b.this.mgE.commit();
                        b.this.mgE.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    b.this.mgE.c(com.tencent.mm.plugin.fts.a.c.mCd, ((Long) it.next()).longValue());
                    i2 = i + 1;
                    this.mgL++;
                    it.remove();
                }
                b.this.mgE.commit();
                AppMethodBeat.o(5302);
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(5303);
            String format = String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.mgK), Integer.valueOf(this.mgJ), Integer.valueOf(this.mgL), Integer.valueOf(this.mFailedCount)});
            AppMethodBeat.o(5303);
            return format;
        }

        public final String getName() {
            return "BuildFavoriteIndexTask";
        }

        public final int getId() {
            return 6;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private long mgM;

        public b(long j) {
            this.mgM = j;
        }

        public final boolean execute() {
            AppMethodBeat.i(5304);
            ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
            b.this.mgE.c(com.tencent.mm.plugin.fts.a.c.mCd, this.mgM);
            AppMethodBeat.o(5304);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(5305);
            String format = String.format("{favItemId: %d}", new Object[]{Long.valueOf(this.mgM)});
            AppMethodBeat.o(5305);
            return format;
        }

        public final String getName() {
            return "DeleteFavItemTask";
        }
    }

    class c {
        String cEV;
        abf cKb;
        long fDy;
        abs mgN;
        int type;
        long updateTime;

        private c() {
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void d(Cursor cursor) {
            AppMethodBeat.i(5306);
            this.fDy = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.updateTime = cursor.getLong(2);
            this.cEV = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.cKb = new abf();
            } else {
                this.cKb = (abf) new abf().parseFrom(blob);
            }
            blob = cursor.getBlob(5);
            if (blob == null || blob.length == 0) {
                this.mgN = null;
                AppMethodBeat.o(5306);
                return;
            }
            this.mgN = (abs) new abs().parseFrom(blob);
            AppMethodBeat.o(5306);
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        com.tencent.mm.plugin.fts.a.a.a fVar;
        AppMethodBeat.i(5311);
        if (iVar.hbo == 1) {
            fVar = new f(iVar);
        } else {
            fVar = new e(iVar);
        }
        fVar = this.eAX.a(-65536, fVar);
        AppMethodBeat.o(5311);
        return fVar;
    }

    public b() {
        AppMethodBeat.i(5312);
        AppMethodBeat.o(5312);
    }

    public final boolean onCreate() {
        AppMethodBeat.i(5313);
        if (((n) com.tencent.mm.kernel.g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
            this.eAX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon();
            this.mgE = (a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(256);
            this.mgD = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSMainDB();
            this.mgF = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buR();
            this.eAX.a(131122, new a(this, (byte) 0));
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().c(this.mgG);
            AppMethodBeat.o(5313);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
        AppMethodBeat.o(5313);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(5314);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().d(this.mgG);
        this.mgE = null;
        this.eAX = null;
        AppMethodBeat.o(5314);
        return true;
    }

    public final String getName() {
        return "FTS5SearchFavoriteLogic";
    }

    private int a(String[] strArr, int[] iArr, long j, int i, long j2, String str) {
        AppMethodBeat.i(5315);
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
            this.mgE.a(iArr[0], j, str, j2, str2, i);
            int i3 = 1;
            if (str5 != null && str5.length() > 0) {
                this.mgE.a(iArr[1], j, str, j2, str5, i);
                i3 = 2;
            }
            if (str7 == null || str7.length() <= 0) {
                i2 = i3;
            } else {
                this.mgE.a(iArr[2], j, str, j2, str7, i);
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.o(5315);
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
    static /* synthetic */ int a(b bVar, c cVar) {
        AppMethodBeat.i(5316);
        long j = cVar.fDy;
        int i = cVar.type;
        long j2 = cVar.updateTime;
        String str = cVar.cEV;
        abf abf = cVar.cKb;
        aaw a = com.tencent.mm.plugin.fav.a.b.a(i, abf, cVar.mgN);
        if (a == null) {
            ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Fav info is null");
            AppMethodBeat.o(5316);
            return 0;
        }
        String str2;
        String str3;
        int a2;
        ad MU;
        int a3;
        ad MU2;
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
            ad MU3 = bVar.mgD.MU(str3);
            if (MU3 != null) {
                String str7;
                String str8;
                String str9;
                String str10 = MU3.field_nickname;
                str3 = com.tencent.mm.plugin.fts.a.d.aL(str10, false);
                String aL = com.tencent.mm.plugin.fts.a.d.aL(str10, true);
                String str11 = MU3.field_conRemark;
                str5 = com.tencent.mm.plugin.fts.a.d.aL(str11, false);
                String aL2 = com.tencent.mm.plugin.fts.a.d.aL(str11, true);
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
                a2 = bVar.a(strArr, iArr, j, i, j2, str) + 0;
                strArr[0] = str7;
                strArr[1] = str8;
                strArr[2] = str9;
                iArr[0] = 12;
                iArr[1] = 13;
                iArr[2] = 14;
                a2 += bVar.a(strArr, iArr, j, i, j2, str);
                if (str2 != null && str2.length() > 0) {
                    MU = bVar.mgD.MU(str2);
                    if (MU != null) {
                        str5 = MU.field_conRemark;
                        if (str5 == null || str5.length() == 0) {
                            str5 = MU.field_nickname;
                        }
                        str2 = com.tencent.mm.plugin.fts.a.d.aL(str5, false);
                        str9 = com.tencent.mm.plugin.fts.a.d.aL(str5, true);
                        strArr[0] = str5;
                        strArr[1] = str2;
                        strArr[2] = str9;
                        iArr[0] = 16;
                        iArr[1] = 17;
                        iArr[2] = 18;
                        a3 = a2 + bVar.a(strArr, iArr, j, i, j2, str);
                        if (str6 != null && str6.length() > 0) {
                            MU2 = bVar.mgD.MU(str6);
                            if (MU2 != null) {
                                str5 = MU2.field_conRemark;
                                if (str5 == null || str5.length() == 0) {
                                    str5 = MU2.field_nickname;
                                }
                                str3 = com.tencent.mm.plugin.fts.a.d.aL(str5, false);
                                str9 = com.tencent.mm.plugin.fts.a.d.aL(str5, true);
                                strArr[0] = str5;
                                strArr[1] = str3;
                                strArr[2] = str9;
                                iArr[0] = 20;
                                iArr[1] = 21;
                                iArr[2] = 22;
                                a4 = bVar.a(strArr, iArr, j, i, j2, str) + a3;
                                linkedList = a.wig;
                                stringBuilder = new StringBuilder(256);
                                for (String str52 : linkedList) {
                                    if (str52 != null && str52.length() > 0) {
                                        stringBuilder.append(str52).append("​");
                                    }
                                }
                                if (stringBuilder.length() > 0) {
                                    bVar.mgE.a(7, j, str, j2, stringBuilder.toString(), i);
                                    a4++;
                                }
                                switch (i) {
                                    case 2:
                                        aL2 = a.title;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(23, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                    case 5:
                                        aL2 = a.title;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(1, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                    case 6:
                                        int i2;
                                        aL2 = abf.hHV;
                                        if (bo.isNullOrNil(aL2)) {
                                            i2 = a4;
                                        } else {
                                            bVar.mgE.a(4, j, str, j2, aL2, i);
                                            i2 = a4 + 1;
                                        }
                                        aL2 = abf.why.cIK;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(5, j, str, j2, aL2, i);
                                            i2++;
                                        }
                                        aL2 = abf.why.label;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(6, j, str, j2, aL2, i);
                                            a4 = i2 + 1;
                                            break;
                                        }
                                        a4 = i2;
                                        break;
                                    case 7:
                                        aL2 = a.title;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(1, j, str, j2, aL2, i);
                                            a4++;
                                        }
                                        aL2 = a.desc;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(3, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                    case 14:
                                        if (abf.wiv != null) {
                                            StringBuffer stringBuffer = new StringBuffer();
                                            Iterator it = abf.wiv.iterator();
                                            while (it.hasNext()) {
                                                str52 = com.tencent.mm.plugin.fav.a.b.a((aar) it.next());
                                                if (!bo.isNullOrNil(str52)) {
                                                    stringBuilder.append(str52);
                                                    stringBuilder.append("​");
                                                }
                                            }
                                            aL2 = stringBuffer.toString();
                                            if (!bo.isNullOrNil(aL2)) {
                                                bVar.mgE.a(1, j, str, j2, aL2, i);
                                                a4++;
                                                break;
                                            }
                                        }
                                        break;
                                    default:
                                        aL2 = a.title;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(1, j, str, j2, aL2, i);
                                            a4++;
                                        }
                                        aL2 = a.desc;
                                        if (!bo.isNullOrNil(aL2)) {
                                            bVar.mgE.a(2, j, str, j2, aL2, i);
                                            a4++;
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.o(5316);
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
                        AppMethodBeat.o(5316);
                        return a4;
                    }
                }
                a3 = a2;
                MU2 = bVar.mgD.MU(str6);
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
                AppMethodBeat.o(5316);
                return a4;
            }
        }
        a2 = 0;
        MU = bVar.mgD.MU(str2);
        if (MU != null) {
        }
        a3 = a2;
        MU2 = bVar.mgD.MU(str6);
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
        AppMethodBeat.o(5316);
        return a4;
    }
}
