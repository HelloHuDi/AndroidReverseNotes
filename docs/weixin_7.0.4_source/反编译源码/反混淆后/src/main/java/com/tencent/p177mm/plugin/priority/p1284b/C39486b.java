package com.tencent.p177mm.plugin.priority.p1284b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.priority.b.b */
public final class C39486b {
    public SQLiteDatabase pgl;
    public SQLiteStatement pgm;
    public SQLiteStatement pgn;
    public SQLiteStatement pgo;

    public C39486b(String str) {
        AppMethodBeat.m2504i(54888);
        if (this.pgl != null) {
            C4990ab.m7420w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
            this.pgl.close();
        }
        String absolutePath = new File(str, "MicroMsgPriority.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        this.pgl = SQLiteDatabase.openOrCreateDatabase(absolutePath, C1178g.m2591x(stringBuilder.append(C1668a.m3384QG()).append(C1853r.m3846Yz()).append(C1427q.m3026LK()).toString().getBytes()).substring(0, 7).getBytes(), null, null);
        this.pgl.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"PriorityConfig"}));
        this.pgm = this.pgl.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"PriorityConfig"}));
        this.pgn = this.pgl.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"PriorityConfig"}));
        this.pgo = this.pgl.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"PriorityConfig"}));
        C4990ab.m7417i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), C5046bo.m7526b(C5730e.asZ(absolutePath), 100.0d));
        AppMethodBeat.m2505o(54888);
    }

    /* renamed from: R */
    public final long mo62441R(long j, long j2) {
        AppMethodBeat.m2504i(54889);
        this.pgm.bindLong(1, j);
        try {
            j2 = this.pgm.simpleQueryForLong();
            AppMethodBeat.m2505o(54889);
        } catch (SQLiteDoneException e) {
            AppMethodBeat.m2505o(54889);
        }
        return j2;
    }

    /* renamed from: S */
    public final void mo62442S(long j, long j2) {
        AppMethodBeat.m2504i(54890);
        this.pgn.bindLong(1, j);
        this.pgn.bindLong(2, j2);
        this.pgn.execute();
        AppMethodBeat.m2505o(54890);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.m2504i(54891);
        C4990ab.m7419v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", str);
        com.tencent.wcdb.Cursor rawQueryWithFactory = this.pgl.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null);
        AppMethodBeat.m2505o(54891);
        return rawQueryWithFactory;
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.m2504i(54892);
        C4990ab.m7419v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", str);
        SQLiteStatement compileStatement = this.pgl.compileStatement(str);
        AppMethodBeat.m2505o(54892);
        return compileStatement;
    }

    /* renamed from: UF */
    public final int mo62443UF(String str) {
        int i = 0;
        AppMethodBeat.m2504i(54893);
        com.tencent.wcdb.Cursor rawQuery = this.pgl.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[]{str}), null);
        try {
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            } else {
                rawQuery.close();
                AppMethodBeat.m2505o(54893);
            }
            return i;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54893);
        }
    }

    /* renamed from: MT */
    public final boolean mo62440MT(String str) {
        AppMethodBeat.m2504i(54894);
        com.tencent.wcdb.Cursor rawQuery = this.pgl.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.m2505o(54894);
        return moveToNext;
    }

    /* renamed from: UG */
    public final void mo62444UG(String str) {
        AppMethodBeat.m2504i(54895);
        C4990ab.m7419v("MicroMsg.Priority.PriorityDB", "dropTable: %s", str);
        this.pgl.execSQL(String.format("DROP TABLE %s", new Object[]{str}));
        AppMethodBeat.m2505o(54895);
    }

    public final void execSQL(String str) {
        AppMethodBeat.m2504i(54896);
        C4990ab.m7419v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", str);
        this.pgl.execSQL(str);
        AppMethodBeat.m2505o(54896);
    }
}
