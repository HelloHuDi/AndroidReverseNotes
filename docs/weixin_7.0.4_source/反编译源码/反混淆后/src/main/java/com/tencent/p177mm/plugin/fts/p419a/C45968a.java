package com.tencent.p177mm.plugin.fts.p419a;

import android.database.Cursor;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.p213cd.C6394d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43119b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.a */
public abstract class C45968a implements C34207i {
    private boolean aGx;
    private volatile boolean bZq;
    private C1177f<String, String> mBS;
    public volatile C34206h mBT;
    protected SQLiteStatement mBU;
    private SQLiteStatement mBV;
    private SQLiteStatement mBW;
    private SQLiteStatement mBX;
    private SQLiteStatement mBY;
    public SQLiteStatement mBZ;
    private SQLiteStatement mCa;
    protected SQLiteStatement mCb;

    /* renamed from: Po */
    public abstract void mo23702Po();

    public /* synthetic */ int compareTo(Object obj) {
        C34207i c34207i = (C34207i) obj;
        if (getPriority() < c34207i.getPriority()) {
            return -1;
        }
        if (getPriority() > c34207i.getPriority()) {
            return 1;
        }
        return 0;
    }

    public C45968a() {
        C4990ab.m7417i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", getName());
    }

    public final synchronized void create() {
        C4990ab.m7417i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.bZq));
        if (!this.bZq) {
            Object obj;
            if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
                this.mBT = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB();
                C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
                C4990ab.m7417i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", bAg(), bAf(), getTableName());
                if (this.mBT.mo54780MT(bAg()) && this.mBT.mo54780MT(r1) && !mo23703Pp()) {
                    C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
                } else {
                    C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
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
                this.mBS = new C6294h(100);
                mo23702Po();
                int obj2 = 1;
            } else {
                C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
                obj2 = null;
            }
            if (obj2 != null) {
                C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
                this.bZq = true;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public String getTableName() {
        return "Common";
    }

    /* renamed from: a */
    public final void mo73839a(int i, int i2, long j, String str, long j2, String str2) {
        String Na = C3161d.m5403Na(str2);
        if (!C5046bo.isNullOrNil(Na)) {
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
                    this.mBS.put(C45968a.m85365cj(str, i2), Na);
                }
            } catch (SQLiteException e) {
                C4990ab.m7412e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.mCb.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    C4990ab.m7412e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
                }
                throw e;
            }
        }
    }

    /* renamed from: cj */
    private static String m85365cj(String str, int i) {
        return str + "​" + i;
    }

    /* renamed from: b */
    public final void mo73840b(int[] iArr, String str) {
        ArrayList arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + C3161d.m5418t(iArr) + " AND aux_index=?;", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        mo73843bV(arrayList);
    }

    /* renamed from: s */
    public final void mo73853s(int[] iArr) {
        ArrayList arrayList = new ArrayList(2048);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + C3161d.m5418t(iArr) + ";", new Object[]{bAf()}), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        mo73843bV(arrayList);
    }

    /* renamed from: c */
    public final void mo73846c(int[] iArr, long j) {
        ArrayList arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + C3161d.m5418t(iArr) + " AND entity_id=?;", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        mo73843bV(arrayList);
    }

    /* renamed from: bV */
    public final void mo73843bV(List<Long> list) {
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

    /* renamed from: G */
    public final void mo73834G(String str, long j) {
        this.mCa.bindLong(1, j);
        this.mCa.bindString(2, str);
        this.mCa.execute();
    }

    /* renamed from: g */
    public final void mo73851g(Long l) {
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

    /* renamed from: l */
    public final void mo73852l(List<Long> list, int i) {
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

    /* renamed from: c */
    public final List<Long> mo73845c(int[] iArr, String str) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + C3161d.m5418t(iArr) + ";", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{str});
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        mo73852l(arrayList, 1);
        return arrayList;
    }

    /* renamed from: g */
    public final List<C43119b> mo73850g(int[] iArr, int i) {
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + C3161d.m5418t(iArr) + ";", new Object[]{bAf()}), null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            C43119b c43119b = new C43119b();
            c43119b.mo68630h(rawQuery);
            arrayList.add(c43119b);
            arrayList2.add(Long.valueOf(c43119b.mDv));
        }
        rawQuery.close();
        mo73852l(arrayList2, i);
        return arrayList;
    }

    /* renamed from: a */
    public final Cursor mo73837a(C20840g c20840g, int[] iArr, int[] iArr2, boolean z, boolean z2) {
        String bAl = c20840g.bAl();
        String format = z ? String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{bAg(), Integer.valueOf(c20840g.mEc.size())}) : "";
        String str = "";
        String str2 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + C3161d.m5418t(iArr2);
        String str3 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + C3161d.m5418t(iArr);
        return this.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp" + (z2 ? ", content" : "") + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str3 + str + " AND status >= 0" + str2 + ";", new Object[]{bAf(), bAf(), bAg(), bAf(), bAg(), bAg(), bAl}), null);
    }

    /* renamed from: a */
    public final Cursor mo73838a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return C6394d.dvo();
        }
        if (iArr == null || iArr.length == 0) {
            return C6394d.dvo();
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
        return this.mBT.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + C3161d.m5418t(iArr) + ";", new Object[]{stringBuilder2, bAf()}), null);
    }

    public final void destroy() {
        C4990ab.m7417i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.aGx), Boolean.valueOf(this.bZq));
        if (!this.aGx && this.bZq && mo36132Pq()) {
            C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
            this.aGx = true;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Pq */
    public boolean mo36132Pq() {
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

    /* renamed from: K */
    public final void mo73835K(long j, long j2) {
        this.mBT.mo54778K(j, j2);
    }

    /* renamed from: ei */
    public final boolean mo73849ei(int i, int i2) {
        return this.mBT.mo54784ei(i, i2);
    }

    /* Access modifiers changed, original: protected */
    public String bvr() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{bAf()});
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Pp */
    public boolean mo23703Pp() {
        return false;
    }

    /* renamed from: ck */
    public final String mo54789ck(String str, int i) {
        String cj;
        if (bAh()) {
            cj = C45968a.m85365cj(str, i);
            if (this.mBS.mo4405aj(cj)) {
                C4990ab.m7416i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
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

    /* renamed from: MY */
    public final void mo73836MY(String str) {
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
