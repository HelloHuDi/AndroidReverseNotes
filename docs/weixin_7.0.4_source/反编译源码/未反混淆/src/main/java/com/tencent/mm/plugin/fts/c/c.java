package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class c extends a {
    private SQLiteStatement mHj;
    private SQLiteStatement mHk;

    public final void Po() {
        AppMethodBeat.i(136827);
        if (Pp()) {
            this.mBT.K(-105, 3);
            this.mBT.K(-200, Long.MAX_VALUE);
        }
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{bAf(), bAf()}));
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[]{bAf(), bAf()}));
        this.mHj = this.mBT.compileStatement(String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[]{bAf()}));
        this.mHk = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{bAf()}));
        AppMethodBeat.o(136827);
    }

    public final boolean Pq() {
        AppMethodBeat.i(136828);
        this.mHj.close();
        this.mHk.close();
        boolean Pq = super.Pq();
        AppMethodBeat.o(136828);
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

    public final void a(int[] iArr, long j, long j2) {
        AppMethodBeat.i(136829);
        ArrayList arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.t(iArr) + " AND entity_id=? AND timestamp=?;", new Object[]{bAf()});
        Cursor rawQuery = this.mBT.rawQuery(format, new String[]{Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        bV(arrayList);
        AppMethodBeat.o(136829);
    }

    public final Cursor a(g gVar, String str, Set<String> set) {
        String str2;
        AppMethodBeat.i(136830);
        String bAl = gVar.bAl();
        String str3 = "";
        if (bo.isNullOrNil(str)) {
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
        AppMethodBeat.o(136830);
        return rawQuery;
    }

    public final Cursor a(g gVar, List<String> list) {
        AppMethodBeat.i(136831);
        String bAl = gVar.bAl();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("',");
        }
        String str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[]{Integer.valueOf(list.size()), bAf(), bAg(), bAf(), bAg(), bAg(), bAl, str2}), null);
        AppMethodBeat.o(136831);
        return rawQuery;
    }

    public final boolean Pp() {
        AppMethodBeat.i(136832);
        if (ei(ZipJNI.UNZ_CRCERROR, 3)) {
            AppMethodBeat.o(136832);
            return false;
        }
        AppMethodBeat.o(136832);
        return true;
    }

    public final String bvr() {
        AppMethodBeat.i(136833);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[]{bAf()});
        AppMethodBeat.o(136833);
        return format;
    }

    public final void a(int i, long j, String str, long j2, String str2, String str3) {
        AppMethodBeat.i(136834);
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
            AppMethodBeat.o(136834);
        } catch (SQLiteException e) {
            ab.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(65536), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.mCb.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                ab.e("MicroMsg.FTS.FTS5MessageStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
            }
            AppMethodBeat.o(136834);
            throw e;
        }
    }
}
