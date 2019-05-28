package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public final class e extends com.tencent.mm.plugin.fts.a.b {
    private m eAX;
    com.tencent.mm.plugin.fts.c.e mGO;
    HashSet<String> mGP;

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        int mGQ;
        int mGR;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136777);
            this.mGR = e.this.mGO.bAJ();
            long currentTimeMillis = System.currentTimeMillis() - 5184000000L;
            com.tencent.mm.plugin.fts.c.e eVar = e.this.mGO;
            String format = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[]{eVar.bAf()});
            Cursor rawQuery = eVar.mBT.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
            LinkedList linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                linkedList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            eVar.bV(linkedList);
            this.mGQ = linkedList.size();
            AppMethodBeat.o(136777);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136778);
            String format = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[]{Integer.valueOf(this.mGR), Integer.valueOf(this.mGQ)});
            AppMethodBeat.o(136778);
            return format;
        }

        public final String getName() {
            return "BuildTopHitsIndexTask";
        }
    }

    class b extends h {
        public b(i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchTopHitsTask";
        }

        public final int getId() {
            return 8;
        }

        public final void a(j jVar) {
            com.tencent.mm.plugin.fts.a.a.m k;
            AppMethodBeat.i(136779);
            jVar.mDz = g.aO(this.mEl.query, true);
            ab.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", jVar.mDz.bAl().replaceAll("​", ","));
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            jVar.mEy = new ArrayList();
            HashSet hashSet2 = new HashSet();
            com.tencent.mm.plugin.fts.c.e eVar = e.this.mGO;
            g gVar = jVar.mDz;
            int[] iArr = this.mEl.mEr;
            int i = this.mEl.scene;
            int size = this.mEl.mEt + this.mEl.mEu.size();
            String str = gVar.mDY + '%';
            String bAl = gVar.bAl();
            String str2 = "query LIKE ?";
            bAl = String.format("AND %s MATCH '%s'", new Object[]{eVar.bAg(), bAl});
            String str3 = "AND type IN " + d.t(iArr);
            String str4 = "AND status >= 0 AND score >= 3";
            String concat = size > 0 ? "LIMIT ".concat(String.valueOf(size)) : "";
            long size2 = (long) gVar.mEc.size();
            Cursor rawQuery = eVar.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[]{eVar.bAf(), eVar.bAg(), Long.valueOf(size2), eVar.bAg(), eVar.bAf(), str2, bAl, str3, "AND scene=?", str4, eVar.bAf(), eVar.bAg(), concat}), new String[]{str, String.valueOf(i)});
            while (rawQuery.moveToNext()) {
                try {
                    k = new com.tencent.mm.plugin.fts.a.a.m().k(rawQuery);
                    if (hashSet.add(k.mDx)) {
                        k.bAo();
                        k.userData = "";
                        if (k.type == 262144) {
                            k.userData = ((com.tencent.mm.plugin.fts.c.b) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(17)).wa((int) k.mEB);
                            if (k.userData == null) {
                                continue;
                            }
                        } else if (k.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT && com.tencent.mm.plugin.fts.c.e.Ns(k.mDx)) {
                            hashSet2.add(k.mDx);
                        }
                        jVar.mEy.add(k);
                        if (jVar.mEy.size() >= this.mEl.mEt) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    rawQuery.close();
                    AppMethodBeat.o(136779);
                }
            }
            rawQuery.close();
            ab.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", Integer.valueOf(jVar.mEy.size()));
            if (jVar.mDz.mEa.length > 1) {
                if (jVar.mEy.size() > 2) {
                    jVar.mEy = jVar.mEy.subList(0, 2);
                }
                hashSet.clear();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jVar.mEy.size()) {
                        break;
                    }
                    hashSet.add(((l) jVar.mEy.get(i3)).mDx);
                    i2 = i3 + 1;
                }
                HashSet hashSet3 = new HashSet();
                com.tencent.mm.plugin.fts.c.e eVar2 = e.this.mGO;
                gVar = jVar.mDz;
                int[] iArr2 = this.mEl.mEr;
                size = this.mEl.scene;
                int size3 = this.mEl.mEt + this.mEl.mEu.size();
                String bAl2 = gVar.bAl();
                Cursor rawQuery2 = eVar2.mBT.rawQuery(String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + size + (" AND type IN " + d.t(iArr2)) + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[]{eVar2.bAg(), bAl2}) + " ORDER BY score desc limit " + size3 + ";", new Object[]{eVar2.bAf(), eVar2.bAg(), eVar2.bAf(), eVar2.bAg(), eVar2.bAf(), eVar2.bAg()}), new String[]{"​chatroom_tophits"});
                while (rawQuery2.moveToNext()) {
                    bAl2 = rawQuery2.getString(0);
                    if (!hashSet.contains(bAl2)) {
                        hashSet3.add(bAl2);
                    }
                }
                rawQuery2.close();
                com.tencent.mm.plugin.fts.c.a aVar = (com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(3);
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    String str5 = (String) it.next();
                    gVar = jVar.mDz;
                    String bAl3 = gVar.bAl();
                    long size4 = (long) gVar.mEc.size();
                    rawQuery = aVar.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[]{aVar.bAf(), aVar.bAg(), Long.valueOf(size4), aVar.bAf(), aVar.bAg(), aVar.bAf(), aVar.bAg(), aVar.bAg(), bAl3}), new String[]{str5});
                    if (rawQuery.moveToNext()) {
                        k = new com.tencent.mm.plugin.fts.a.a.m().k(rawQuery);
                        k.userData = "​chatroom_tophits";
                        k.bAo();
                        jVar.mEy.add(k);
                        if (jVar.mEy.size() >= this.mEl.mEt) {
                            break;
                        }
                    }
                    rawQuery.close();
                }
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                e.this.Nn((String) it2.next());
            }
            AppMethodBeat.o(136779);
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private HashMap<String, String> mCH;
        private l mGT;
        private String query;
        private int scene;

        private c() {
        }

        /* synthetic */ c(e eVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136780);
            com.tencent.mm.plugin.fts.c.e eVar = e.this.mGO;
            String str = this.query;
            l lVar = this.mGT;
            int i = this.scene;
            HashMap hashMap = this.mCH;
            String trim = str.trim();
            hashMap.remove(lVar.mDx);
            boolean inTransaction = eVar.mBT.inTransaction();
            if (!inTransaction) {
                eVar.mBT.beginTransaction();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if ((lVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || lVar.type == 131075) && com.tencent.mm.plugin.fts.c.e.Ns(lVar.mDx)) {
                ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
            } else {
                int i2;
                int i3;
                int i4;
                int i5;
                Cursor rawQuery = eVar.mBT.rawQuery(String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[]{eVar.bAf()}), new String[]{trim, lVar.mDx, String.valueOf(lVar.mDw), String.valueOf(i)});
                if (rawQuery.moveToNext()) {
                    i2 = rawQuery.getInt(0);
                    i3 = rawQuery.getInt(1);
                    i4 = i2;
                } else {
                    i3 = -1;
                    i4 = -1;
                }
                rawQuery.close();
                String str2 = "";
                for (Entry entry : hashMap.entrySet()) {
                    if (((String) entry.getValue()).equals("​chatroom_tophits")) {
                        str = str2;
                    } else {
                        str = str2 + "'" + ((String) entry.getKey()) + "',";
                    }
                    str2 = str;
                }
                if (str2.length() > 0) {
                    str = "AND aux_index IN (" + str2.substring(0, str2.length() - 1) + ")";
                    eVar.mBT.execSQL(String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[]{eVar.bAf(), Integer.valueOf(i), str}));
                }
                str2 = "";
                for (Entry entry2 : hashMap.entrySet()) {
                    if (((String) entry2.getValue()).equals("​chatroom_tophits")) {
                        str = str2 + "'" + ((String) entry2.getKey()) + "',";
                    } else {
                        str = str2;
                    }
                    str2 = str;
                }
                if (str2.length() > 0) {
                    str = "AND aux_index IN(" + str2.substring(0, str2.length() - 1) + ")";
                    eVar.mBT.execSQL(String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[]{eVar.bAf(), Integer.valueOf(i), str}), new String[]{"​chatroom_tophits"});
                }
                if (i4 < 0 || i3 < 0) {
                    eVar.mHm.bindString(1, lVar.content);
                    eVar.mHm.execute();
                    eVar.mHn.bindLong(1, (long) lVar.type);
                    eVar.mHn.bindLong(2, (long) lVar.mDw);
                    eVar.mHn.bindLong(3, lVar.mEB);
                    eVar.mHn.bindString(4, lVar.mDx);
                    eVar.mHn.bindLong(5, currentTimeMillis);
                    eVar.mHn.bindString(6, trim);
                    eVar.mHn.bindLong(7, 3);
                    eVar.mHn.bindLong(8, (long) i);
                    eVar.mHn.bindString(9, lVar.content);
                    eVar.mHn.execute();
                } else {
                    if (i3 > 6) {
                        i5 = i3 + 1;
                    } else {
                        i5 = i3 + 3;
                    }
                    eVar.mBT.execSQL(String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[]{eVar.bAf()}), new String[]{String.valueOf(i5), String.valueOf(currentTimeMillis), String.valueOf(i4)});
                }
                if (!inTransaction) {
                    eVar.mBT.commit();
                }
                String[] split = com.tencent.mm.plugin.fts.a.c.a.mCE.split(trim);
                if (split.length > 1 && lVar.type == 131075 && lVar.mDw == 38) {
                    HashSet hashSet = new HashSet();
                    k kVar = new k();
                    Cursor rawQuery2 = eVar.mBT.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[]{eVar.bAf()}), new String[]{lVar.mDx, "​chatroom_tophits"});
                    if (rawQuery2.moveToNext()) {
                        kVar.d(rawQuery2);
                        for (Object add : com.tencent.mm.plugin.fts.a.c.a.mCA.split(kVar.mEC)) {
                            hashSet.add(add);
                        }
                    }
                    rawQuery2.close();
                    i5 = 0;
                    while (true) {
                        i2 = i5;
                        if (i2 >= lVar.mEI.size() || i2 >= split.length) {
                            ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", kVar.mEC);
                        } else {
                            f fVar = (f) lVar.mEI.get(i2);
                            if (hashSet.add(fVar.content)) {
                                kVar.mEC += fVar.content + "​";
                            }
                            i5 = i2 + 1;
                        }
                    }
                    ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", kVar.mEC);
                    if (kVar.mEz > 0) {
                        eVar.g(Long.valueOf(kVar.mEz));
                    }
                    kVar.mEz = 0;
                    kVar.query = "​chatroom_tophits";
                    kVar.mEA++;
                    kVar.fob = (long) i;
                    kVar.mDx = lVar.mDx;
                    kVar.mEB = lVar.mEB;
                    kVar.type = lVar.type;
                    kVar.mDw = lVar.mDw;
                    kVar.timestamp = currentTimeMillis;
                    eVar.mHm.bindString(1, kVar.mEC);
                    eVar.mHm.execute();
                    eVar.mHn.bindLong(1, (long) kVar.type);
                    eVar.mHn.bindLong(2, (long) kVar.mDw);
                    eVar.mHn.bindLong(3, kVar.mEB);
                    eVar.mHn.bindString(4, kVar.mDx);
                    eVar.mHn.bindLong(5, kVar.timestamp);
                    eVar.mHn.bindString(6, kVar.query);
                    eVar.mHn.bindLong(7, kVar.mEA);
                    eVar.mHn.bindLong(8, kVar.fob);
                    eVar.mHn.bindString(9, kVar.mEC);
                    eVar.mHn.execute();
                }
            }
            AppMethodBeat.o(136780);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(136781);
            String format = String.format("%s : query=%s scene=%d", new Object[]{super.toString(), this.query, Integer.valueOf(this.scene)});
            AppMethodBeat.o(136781);
            return format;
        }

        public final String getName() {
            return "UpdateTopHitsWithQueryTask";
        }
    }

    public final boolean onCreate() {
        AppMethodBeat.i(136782);
        if (((n) com.tencent.mm.kernel.g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
            this.mGP = new HashSet();
            this.mGO = (com.tencent.mm.plugin.fts.c.e) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(1);
            this.eAX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon();
            this.eAX.a(65626, new a(this, (byte) 0));
            AppMethodBeat.o(136782);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
        AppMethodBeat.o(136782);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136783);
        if (this.mGP != null) {
            this.mGP.clear();
        }
        this.mGO = null;
        this.eAX = null;
        AppMethodBeat.o(136783);
        return true;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        AppMethodBeat.i(136784);
        com.tencent.mm.plugin.fts.a.a.a a = this.eAX.a(-65536, new b(iVar));
        AppMethodBeat.o(136784);
        return a;
    }

    public final void Nn(String str) {
        AppMethodBeat.i(136785);
        if (this.mGP.add(str)) {
            this.mGO.Nr(str);
        }
        AppMethodBeat.o(136785);
    }

    public final void d(int[] iArr, String str) {
        AppMethodBeat.i(136786);
        this.mGO.b(iArr, str);
        AppMethodBeat.o(136786);
    }

    public final String getName() {
        return "FTS5SearchTopHitsLogic";
    }

    public final void a(String str, l lVar, int i, HashMap<String, String> hashMap) {
        AppMethodBeat.i(136787);
        c cVar = new c(this, (byte) 0);
        cVar.query = str;
        cVar.mGT = lVar;
        cVar.scene = i;
        cVar.mCH = hashMap;
        this.eAX.a(65626, cVar);
        AppMethodBeat.o(136787);
    }
}
