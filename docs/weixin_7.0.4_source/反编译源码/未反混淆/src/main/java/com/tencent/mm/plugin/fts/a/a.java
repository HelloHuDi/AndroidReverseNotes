package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.a.h;
import com.tencent.mm.cd.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class a implements i {
    private boolean aGx;
    private volatile boolean bZq;
    private f<String, String> mBS;
    public volatile h mBT;
    protected SQLiteStatement mBU;
    private SQLiteStatement mBV;
    private SQLiteStatement mBW;
    private SQLiteStatement mBX;
    private SQLiteStatement mBY;
    public SQLiteStatement mBZ;
    private SQLiteStatement mCa;
    protected SQLiteStatement mCb;

    public abstract void Po();

    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        if (getPriority() < iVar.getPriority()) {
            return -1;
        }
        if (getPriority() > iVar.getPriority()) {
            return 1;
        }
        return 0;
    }

    public a() {
        ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", getName());
    }

    public final synchronized void create() {
        ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.bZq));
        if (!this.bZq) {
            Object obj;
            if (((n) g.M(n.class)).isFTSContextReady()) {
                this.mBT = ((n) g.M(n.class)).getFTSIndexDB();
                ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
                ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", bAg(), bAf(), getTableName());
                if (this.mBT.MT(bAg()) && this.mBT.MT(r1) && !Pp()) {
                    ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
                } else {
                    ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r0});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r1});
                    this.mBT.execSQL(format);
                    this.mBT.execSQL(format2);
                    this.mBT.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{bAg()}));
                    this.mBT.execSQL(bvr());
                    this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", new Object[]{r1, r1}));
                    this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_entity_id_subtype ON %s(entity_id, subtype);", new Object[]{r1, r1}));
                    this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_aux_index_subtype ON %s(aux_index, subtype);", new Object[]{r1, r1}));
                    this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{r1, r1}));
                }
                this.mBU = this.mBT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{r0}));
                this.mBV = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[]{r1}));
                this.mBW = this.mBT.compileStatement(String.format("DELETE FROM %s WHERE rowid=?;", new Object[]{r0}));
                this.mBX = this.mBT.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", new Object[]{r1}));
                this.mBY = this.mBT.compileStatement(String.format("UPDATE %s SET status=? WHERE docid=?;", new Object[]{r1}));
                this.mBZ = this.mBT.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=? AND status=?", new Object[]{r1}));
                this.mCa = this.mBT.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE aux_index=?", new Object[]{r1}));
                this.mCb = this.mBT.compileStatement("SELECT mm_last_error();");
                this.mBS = new h(100);
                Po();
                int obj2 = 1;
            } else {
                ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
                obj2 = null;
            }
            if (obj2 != null) {
                ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
                this.bZq = true;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public String getTableName() {
        return "Common";
    }

    public final void a(int i, int i2, long j, String str, long j2, String str2) {
        String Na = d.Na(str2);
        if (!bo.isNullOrNil(Na)) {
            boolean inTransaction = this.mBT.inTransaction();
            if (!inTransaction) {
                this.mBT.beginTransaction();
            }
            try {
                this.mBU.bindString(1, Na);
                this.mBU.execute();
                this.mBV.bindLong(1, (long) i);
                this.mBV.bindLong(2, (long) i2);
                this.mBV.bindLong(3, j);
                this.mBV.bindString(4, str);
                this.mBV.bindLong(5, j2);
                this.mBV.execute();
                if (!inTransaction) {
                    this.mBT.commit();
                }
                if (bAh()) {
                    this.mBS.put(cj(str, i2), Na);
                }
            } catch (SQLiteException e) {
                ab.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.mCb.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    ab.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
                }
                throw e;
            }
        }
    }

    private static String cj(String str, int i) {
        return str + "​" + i;
    }

    public final void b(int[] iArr, String str) {
        ArrayList arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.t(iArr) + " AND aux_index=?;", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bV(arrayList);
    }

    public final void s(int[] iArr) {
        ArrayList arrayList = new ArrayList(2048);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + d.t(iArr) + ";", new Object[]{bAf()}), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bV(arrayList);
    }

    public final void c(int[] iArr, long j) {
        ArrayList arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.t(iArr) + " AND entity_id=?;", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bV(arrayList);
    }

    public final void bV(List<Long> list) {
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        for (Long longValue : list) {
            this.mBW.bindLong(1, longValue.longValue());
            this.mBW.execute();
        }
        for (Long longValue2 : list) {
            this.mBX.bindLong(1, longValue2.longValue());
            this.mBX.execute();
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void G(String str, long j) {
        this.mCa.bindLong(1, j);
        this.mCa.bindString(2, str);
        this.mCa.execute();
    }

    public final void g(Long l) {
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        this.mBW.bindLong(1, l.longValue());
        this.mBW.execute();
        this.mBX.bindLong(1, l.longValue());
        this.mBX.execute();
        if (!inTransaction) {
            commit();
        }
    }

    public final void l(List<Long> list, int i) {
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        this.mBY.bindLong(1, (long) i);
        for (Long longValue : list) {
            this.mBY.bindLong(2, longValue.longValue());
            this.mBY.execute();
        }
        if (!inTransaction) {
            this.mBT.commit();
        }
    }

    public final List<Long> c(int[] iArr, String str) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.t(iArr) + ";", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{str});
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        l(arrayList, 1);
        return arrayList;
    }

    public final List<b> g(int[] iArr, int i) {
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.t(iArr) + ";", new Object[]{bAf()}), null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.h(rawQuery);
            arrayList.add(bVar);
            arrayList2.add(Long.valueOf(bVar.mDv));
        }
        rawQuery.close();
        l(arrayList2, i);
        return arrayList;
    }

    public final Cursor a(com.tencent.mm.plugin.fts.a.a.g gVar, int[] iArr, int[] iArr2, boolean z, boolean z2) {
        String bAl = gVar.bAl();
        String format = z ? String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{bAg(), Integer.valueOf(gVar.mEc.size())}) : "";
        String str = "";
        String str2 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.t(iArr2);
        String str3 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.t(iArr);
        return this.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp" + (z2 ? ", content" : "") + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str3 + str + " AND status >= 0" + str2 + ";", new Object[]{bAf(), bAf(), bAg(), bAf(), bAg(), bAg(), bAl}), null);
    }

    public final Cursor a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return d.dvo();
        }
        if (iArr == null || iArr.length == 0) {
            return d.dvo();
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        if (z) {
            stringBuilder.append("docid,");
        }
        if (z2) {
            stringBuilder.append("entity_id,");
        }
        if (z3) {
            stringBuilder.append("aux_index,");
        }
        if (z4) {
            stringBuilder.append("timestamp,");
        }
        if (z5) {
            stringBuilder.append("status,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return this.mBT.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + d.t(iArr) + ";", new Object[]{stringBuilder2, bAf()}), null);
    }

    public final void destroy() {
        ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.aGx), Boolean.valueOf(this.bZq));
        if (!this.aGx && this.bZq && Pq()) {
            ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
            this.aGx = true;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean Pq() {
        this.mBT = null;
        this.mBU.close();
        this.mBV.close();
        this.mBW.close();
        this.mBX.close();
        this.mBY.close();
        this.mCb.close();
        if (this.mBS != null) {
            this.mBS.clear();
        }
        return true;
    }

    public final String bAf() {
        return "FTS5Meta" + getTableName();
    }

    public final String bAg() {
        return "FTS5Index" + getTableName();
    }

    public final void beginTransaction() {
        this.mBT.beginTransaction();
    }

    public final void commit() {
        this.mBT.commit();
    }

    public final void K(long j, long j2) {
        this.mBT.K(j, j2);
    }

    public final boolean ei(int i, int i2) {
        return this.mBT.ei(i, i2);
    }

    /* Access modifiers changed, original: protected */
    public String bvr() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{bAf()});
    }

    /* Access modifiers changed, original: protected */
    public boolean Pp() {
        return false;
    }

    public final String ck(String str, int i) {
        String cj;
        if (bAh()) {
            cj = cj(str, i);
            if (this.mBS.aj(cj)) {
                ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
                return (String) this.mBS.get(cj);
            }
        }
        cj = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[]{bAf(), bAg(), bAf(), bAg()});
        Cursor rawQuery = this.mBT.rawQuery(cj, new String[]{str, String.valueOf(i)});
        cj = null;
        if (rawQuery.moveToFirst()) {
            cj = rawQuery.getString(0);
        }
        rawQuery.close();
        return cj;
    }

    /* Access modifiers changed, original: protected */
    public boolean bAh() {
        return false;
    }

    public final void MY(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : this.mBS.keySet()) {
            if (str2.startsWith(str)) {
                hashSet.add(str2);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.mBS.remove((String) it.next());
        }
    }
}
