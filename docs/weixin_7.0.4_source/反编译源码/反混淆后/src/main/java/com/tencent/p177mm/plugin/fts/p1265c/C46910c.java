package com.tencent.p177mm.plugin.fts.p1265c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fts.c.c */
public final class C46910c extends C45968a {
    private SQLiteStatement mHj;
    private SQLiteStatement mHk;

    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(136827);
        if (mo23703Pp()) {
            this.mBT.mo54778K(-105, 3);
            this.mBT.mo54778K(-200, Long.MAX_VALUE);
        }
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{bAf(), bAf()}));
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[]{bAf(), bAf()}));
        this.mHj = this.mBT.compileStatement(String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[]{bAf()}));
        this.mHk = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{bAf()}));
        AppMethodBeat.m2505o(136827);
    }

    /* renamed from: Pq */
    public final boolean mo36132Pq() {
        AppMethodBeat.m2504i(136828);
        this.mHj.close();
        this.mHk.close();
        boolean Pq = super.mo36132Pq();
        AppMethodBeat.m2505o(136828);
        return Pq;
    }

    public final String getTableName() {
        return "Message";
    }

    public final String getName() {
        return "FTS5MessageStorage";
    }

    public final int getType() {
        return 4;
    }

    public final int getPriority() {
        return 4;
    }

    /* renamed from: a */
    public final void mo76116a(int[] iArr, long j, long j2) {
        AppMethodBeat.m2504i(136829);
        ArrayList arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + C3161d.m5418t(iArr) + " AND entity_id=? AND timestamp=?;", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        mo73843bV(arrayList);
        AppMethodBeat.m2505o(136829);
    }

    /* renamed from: a */
    public final Cursor mo76113a(C20840g c20840g, String str, Set<String> set) {
        String str2;
        AppMethodBeat.m2504i(136830);
        String bAl = c20840g.bAl();
        String str3 = "";
        if (C5046bo.isNullOrNil(str)) {
            str2 = str3;
        } else {
            str2 = String.format(" AND aux_index = '%s'", new Object[]{str});
        }
        String str4 = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (String str32 : set) {
            stringBuffer.append("'");
            stringBuffer.append(str32);
            stringBuffer.append("'");
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            str32 = " AND talker IN (" + stringBuffer.substring(0, stringBuffer.length() - 1) + ")";
        } else {
            str32 = str4;
        }
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str32 + str2 + " AND status >= 0;", new Object[]{bAf(), bAf(), bAg(), bAf(), bAg(), bAg(), bAl}), null);
        AppMethodBeat.m2505o(136830);
        return rawQuery;
    }

    /* renamed from: a */
    public final Cursor mo76114a(C20840g c20840g, List<String> list) {
        AppMethodBeat.m2504i(136831);
        String bAl = c20840g.bAl();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("',");
        }
        String str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[]{Integer.valueOf(list.size()), bAf(), bAg(), bAf(), bAg(), bAg(), bAl, str2}), null);
        AppMethodBeat.m2505o(136831);
        return rawQuery;
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(136832);
        if (mo73849ei(ZipJNI.UNZ_CRCERROR, 3)) {
            AppMethodBeat.m2505o(136832);
            return false;
        }
        AppMethodBeat.m2505o(136832);
        return true;
    }

    public final String bvr() {
        AppMethodBeat.m2504i(136833);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[]{bAf()});
        AppMethodBeat.m2505o(136833);
        return format;
    }

    /* renamed from: a */
    public final void mo76115a(int i, long j, String str, long j2, String str2, String str3) {
        AppMethodBeat.m2504i(136834);
        try {
            this.mBU.bindString(1, str2);
            this.mBU.execute();
            this.mHk.bindLong(1, 65536);
            this.mHk.bindLong(2, (long) i);
            this.mHk.bindLong(3, j);
            this.mHk.bindString(4, str);
            this.mHk.bindLong(5, j2);
            this.mHk.bindString(6, str3);
            this.mHk.execute();
            AppMethodBeat.m2505o(136834);
        } catch (SQLiteException e) {
            C4990ab.m7412e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(65536), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.mCb.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                C4990ab.m7412e("MicroMsg.FTS.FTS5MessageStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
            }
            AppMethodBeat.m2505o(136834);
            throw e;
        }
    }
}
