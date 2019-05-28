package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

public final class d implements h {
    public boolean mBc;
    public SQLiteDatabase mBd;
    private SQLiteStatement mBe;
    private SQLiteStatement mBf;
    private SQLiteStatement mBg;

    public d(String str) {
        AppMethodBeat.i(136546);
        ab.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", str + "FTS5IndexMicroMsg_encrypt.db");
        if (this.mBd != null) {
            ab.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.mBd.close();
        }
        String absolutePath = new File(str, "FTS5IndexMicroMsg_encrypt.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        this.mBd = SQLiteDatabase.openOrCreateDatabase(absolutePath, com.tencent.mm.a.g.x(stringBuilder.append(a.QG()).append(q.LK()).append(r.Yz()).toString().getBytes()).substring(0, 7).getBytes(), null, null);
        String LK = q.LK();
        g.RQ();
        g.RN();
        byte[] y = com.tencent.mm.a.g.y((LK + ((long) a.QF())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.mBd;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        this.mBc = false;
        if (!this.mBc) {
            e.pXa.a(146, 21, 1, false);
        }
        bAd();
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, y);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mBd.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.mBd.execSQL("PRAGMA synchronous=NORMAL;");
        this.mBd.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"FTS5IndexVersion"}));
        this.mBe = this.mBd.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"FTS5IndexVersion"}));
        this.mBf = this.mBd.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"FTS5IndexVersion"}));
        this.mBg = this.mBd.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"FTS5IndexVersion"}));
        com.tencent.mm.plugin.fts.a.e.K(18, System.currentTimeMillis() - currentTimeMillis);
        ab.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s %s supportICU %b", Long.valueOf(r4 - currentTimeMillis), bo.b((long) absolutePath.length(), 2.0d), q.LK(), Boolean.valueOf(this.mBc));
        AppMethodBeat.o(136546);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(136547);
        ab.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        a aVar = new a(this.mBd.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
        AppMethodBeat.o(136547);
        return aVar;
    }

    public final Cursor MS(String str) {
        AppMethodBeat.i(136548);
        ab.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        a aVar = new a(this.mBd.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null, null));
        AppMethodBeat.o(136548);
        return aVar;
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.i(136549);
        ab.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", str);
        SQLiteStatement compileStatement = this.mBd.compileStatement(str);
        AppMethodBeat.o(136549);
        return compileStatement;
    }

    public final boolean ei(int i, int i2) {
        int i3;
        AppMethodBeat.i(136550);
        if (!MT("FTS5IndexVersion") || this.mBe == null) {
            i3 = 0;
        } else {
            i3 = (int) J((long) i, 0);
        }
        ab.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", Integer.valueOf(i3), Integer.valueOf(i2));
        if (i3 == i2) {
            AppMethodBeat.o(136550);
            return true;
        }
        AppMethodBeat.o(136550);
        return false;
    }

    public final long J(long j, long j2) {
        AppMethodBeat.i(136551);
        this.mBe.bindLong(1, j);
        try {
            j2 = this.mBe.simpleQueryForLong();
            AppMethodBeat.o(136551);
        } catch (SQLiteDoneException e) {
            AppMethodBeat.o(136551);
        }
        return j2;
    }

    public final void K(long j, long j2) {
        AppMethodBeat.i(136552);
        this.mBf.bindLong(1, j);
        this.mBf.bindLong(2, j2);
        this.mBf.execute();
        AppMethodBeat.o(136552);
    }

    public final boolean MT(String str) {
        AppMethodBeat.i(136553);
        com.tencent.wcdb.Cursor rawQuery = this.mBd.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.o(136553);
        return moveToNext;
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(136554);
        ab.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.mBd.execSQL(str);
        AppMethodBeat.o(136554);
    }

    public final void execSQL(String str, Object[] objArr) {
        AppMethodBeat.i(136555);
        ab.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.mBd.execSQL(str, objArr);
        AppMethodBeat.o(136555);
    }

    public final void close() {
        boolean z;
        AppMethodBeat.i(136556);
        String str = "MicroMsg.FTS.FTSIndexDB";
        String str2 = "close db:%s isOpen:%b ";
        Object[] objArr = new Object[2];
        objArr[0] = this.mBd;
        if (this.mBd == null) {
            z = false;
        } else {
            z = this.mBd.isOpen();
        }
        objArr[1] = Boolean.valueOf(z);
        ab.w(str, str2, objArr);
        if (this.mBd != null && this.mBd.isOpen()) {
            ab.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", Boolean.valueOf(this.mBd.inTransaction()));
            while (this.mBd.inTransaction()) {
                this.mBd.endTransaction();
            }
            this.mBe.close();
            this.mBf.close();
            this.mBd.close();
            this.mBd = null;
        }
        AppMethodBeat.o(136556);
    }

    public final synchronized void beginTransaction() {
        AppMethodBeat.i(136557);
        if (this.mBd == null || this.mBd.inTransaction()) {
            AppMethodBeat.o(136557);
        } else {
            this.mBd.beginTransaction();
            AppMethodBeat.o(136557);
        }
    }

    public final boolean inTransaction() {
        AppMethodBeat.i(136558);
        if (this.mBd == null || !this.mBd.inTransaction()) {
            AppMethodBeat.o(136558);
            return false;
        }
        AppMethodBeat.o(136558);
        return true;
    }

    public final synchronized void commit() {
        AppMethodBeat.i(136559);
        if (this.mBd == null || !this.mBd.inTransaction()) {
            AppMethodBeat.o(136559);
        } else {
            this.mBd.setTransactionSuccessful();
            this.mBd.endTransaction();
            AppMethodBeat.o(136559);
        }
    }

    public final synchronized void rollback() {
        AppMethodBeat.i(136560);
        if (this.mBd != null && this.mBd.isOpen() && this.mBd.inTransaction()) {
            ab.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.mBd.endTransaction();
                AppMethodBeat.o(136560);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", e);
                AppMethodBeat.o(136560);
            }
        } else {
            AppMethodBeat.o(136560);
        }
        return;
    }

    protected static final void bAb() {
        AppMethodBeat.i(136561);
        g.RQ();
        new File(g.RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").delete();
        AppMethodBeat.o(136561);
    }

    public static final File bAc() {
        AppMethodBeat.i(136562);
        g.RQ();
        File file = new File(g.RP().cachePath, "FTS5IndexMicroMsg_encrypt.db");
        AppMethodBeat.o(136562);
        return file;
    }

    private static void bAd() {
        AppMethodBeat.i(136563);
        File[] listFiles = new File("/system/usr/icu").listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                ab.i("MicroMsg.FTS.FTSIndexDB", "icu file %s", listFiles[i].getName());
            }
        }
        AppMethodBeat.o(136563);
    }
}
