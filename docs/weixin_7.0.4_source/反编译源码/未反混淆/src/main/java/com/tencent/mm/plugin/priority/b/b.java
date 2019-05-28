package com.tencent.mm.plugin.priority.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

public final class b {
    public SQLiteDatabase pgl;
    public SQLiteStatement pgm;
    public SQLiteStatement pgn;
    public SQLiteStatement pgo;

    public b(String str) {
        AppMethodBeat.i(54888);
        if (this.pgl != null) {
            ab.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
            this.pgl.close();
        }
        String absolutePath = new File(str, "MicroMsgPriority.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        this.pgl = SQLiteDatabase.openOrCreateDatabase(absolutePath, com.tencent.mm.a.g.x(stringBuilder.append(a.QG()).append(r.Yz()).append(q.LK()).toString().getBytes()).substring(0, 7).getBytes(), null, null);
        this.pgl.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"PriorityConfig"}));
        this.pgm = this.pgl.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"PriorityConfig"}));
        this.pgn = this.pgl.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"PriorityConfig"}));
        this.pgo = this.pgl.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"PriorityConfig"}));
        ab.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bo.b(e.asZ(absolutePath), 100.0d));
        AppMethodBeat.o(54888);
    }

    public final long R(long j, long j2) {
        AppMethodBeat.i(54889);
        this.pgm.bindLong(1, j);
        try {
            j2 = this.pgm.simpleQueryForLong();
            AppMethodBeat.o(54889);
        } catch (SQLiteDoneException e) {
            AppMethodBeat.o(54889);
        }
        return j2;
    }

    public final void S(long j, long j2) {
        AppMethodBeat.i(54890);
        this.pgn.bindLong(1, j);
        this.pgn.bindLong(2, j2);
        this.pgn.execute();
        AppMethodBeat.o(54890);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(54891);
        ab.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", str);
        com.tencent.wcdb.Cursor rawQueryWithFactory = this.pgl.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null);
        AppMethodBeat.o(54891);
        return rawQueryWithFactory;
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.i(54892);
        ab.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", str);
        SQLiteStatement compileStatement = this.pgl.compileStatement(str);
        AppMethodBeat.o(54892);
        return compileStatement;
    }

    public final int UF(String str) {
        int i = 0;
        AppMethodBeat.i(54893);
        com.tencent.wcdb.Cursor rawQuery = this.pgl.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[]{str}), null);
        try {
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            } else {
                rawQuery.close();
                AppMethodBeat.o(54893);
            }
            return i;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54893);
        }
    }

    public final boolean MT(String str) {
        AppMethodBeat.i(54894);
        com.tencent.wcdb.Cursor rawQuery = this.pgl.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.o(54894);
        return moveToNext;
    }

    public final void UG(String str) {
        AppMethodBeat.i(54895);
        ab.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", str);
        this.pgl.execSQL(String.format("DROP TABLE %s", new Object[]{str}));
        AppMethodBeat.o(54895);
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(54896);
        ab.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", str);
        this.pgl.execSQL(str);
        AppMethodBeat.o(54896);
    }
}
