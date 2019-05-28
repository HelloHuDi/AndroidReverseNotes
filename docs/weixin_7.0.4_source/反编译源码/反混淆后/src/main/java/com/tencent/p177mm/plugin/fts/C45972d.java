package com.tencent.p177mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.C34206h;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.fts.d */
public final class C45972d implements C34206h {
    public boolean mBc;
    public SQLiteDatabase mBd;
    private SQLiteStatement mBe;
    private SQLiteStatement mBf;
    private SQLiteStatement mBg;

    public C45972d(String str) {
        AppMethodBeat.m2504i(136546);
        C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", str + "FTS5IndexMicroMsg_encrypt.db");
        if (this.mBd != null) {
            C4990ab.m7420w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.mBd.close();
        }
        String absolutePath = new File(str, "FTS5IndexMicroMsg_encrypt.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        this.mBd = SQLiteDatabase.openOrCreateDatabase(absolutePath, C1178g.m2591x(stringBuilder.append(C1668a.m3384QG()).append(C1427q.m3026LK()).append(C1853r.m3846Yz()).toString().getBytes()).substring(0, 7).getBytes(), null, null);
        String LK = C1427q.m3026LK();
        C1720g.m3537RQ();
        C1720g.m3534RN();
        byte[] y = C1178g.m2592y((LK + ((long) C1668a.m3383QF())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.mBd;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        this.mBc = false;
        if (!this.mBc) {
            C7053e.pXa.mo8378a(146, 21, 1, false);
        }
        C45972d.bAd();
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, y);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mBd.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.mBd.execSQL("PRAGMA synchronous=NORMAL;");
        this.mBd.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"FTS5IndexVersion"}));
        this.mBe = this.mBd.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"FTS5IndexVersion"}));
        this.mBf = this.mBd.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"FTS5IndexVersion"}));
        this.mBg = this.mBd.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"FTS5IndexVersion"}));
        C3163e.m5419K(18, System.currentTimeMillis() - currentTimeMillis);
        C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s %s supportICU %b", Long.valueOf(r4 - currentTimeMillis), C5046bo.m7526b((long) absolutePath.length(), 2.0d), C1427q.m3026LK(), Boolean.valueOf(this.mBc));
        AppMethodBeat.m2505o(136546);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.m2504i(136547);
        C4990ab.m7419v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        C12030a c12030a = new C12030a(this.mBd.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
        AppMethodBeat.m2505o(136547);
        return c12030a;
    }

    /* renamed from: MS */
    public final Cursor mo54779MS(String str) {
        AppMethodBeat.m2504i(136548);
        C4990ab.m7419v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        C12030a c12030a = new C12030a(this.mBd.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null, null));
        AppMethodBeat.m2505o(136548);
        return c12030a;
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.m2504i(136549);
        C4990ab.m7419v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", str);
        SQLiteStatement compileStatement = this.mBd.compileStatement(str);
        AppMethodBeat.m2505o(136549);
        return compileStatement;
    }

    /* renamed from: ei */
    public final boolean mo54784ei(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(136550);
        if (!mo54780MT("FTS5IndexVersion") || this.mBe == null) {
            i3 = 0;
        } else {
            i3 = (int) mo54777J((long) i, 0);
        }
        C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", Integer.valueOf(i3), Integer.valueOf(i2));
        if (i3 == i2) {
            AppMethodBeat.m2505o(136550);
            return true;
        }
        AppMethodBeat.m2505o(136550);
        return false;
    }

    /* renamed from: J */
    public final long mo54777J(long j, long j2) {
        AppMethodBeat.m2504i(136551);
        this.mBe.bindLong(1, j);
        try {
            j2 = this.mBe.simpleQueryForLong();
            AppMethodBeat.m2505o(136551);
        } catch (SQLiteDoneException e) {
            AppMethodBeat.m2505o(136551);
        }
        return j2;
    }

    /* renamed from: K */
    public final void mo54778K(long j, long j2) {
        AppMethodBeat.m2504i(136552);
        this.mBf.bindLong(1, j);
        this.mBf.bindLong(2, j2);
        this.mBf.execute();
        AppMethodBeat.m2505o(136552);
    }

    /* renamed from: MT */
    public final boolean mo54780MT(String str) {
        AppMethodBeat.m2504i(136553);
        com.tencent.wcdb.Cursor rawQuery = this.mBd.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.m2505o(136553);
        return moveToNext;
    }

    public final void execSQL(String str) {
        AppMethodBeat.m2504i(136554);
        C4990ab.m7411d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.mBd.execSQL(str);
        AppMethodBeat.m2505o(136554);
    }

    public final void execSQL(String str, Object[] objArr) {
        AppMethodBeat.m2504i(136555);
        C4990ab.m7411d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.mBd.execSQL(str, objArr);
        AppMethodBeat.m2505o(136555);
    }

    public final void close() {
        boolean z;
        AppMethodBeat.m2504i(136556);
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
        C4990ab.m7421w(str, str2, objArr);
        if (this.mBd != null && this.mBd.isOpen()) {
            C4990ab.m7421w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", Boolean.valueOf(this.mBd.inTransaction()));
            while (this.mBd.inTransaction()) {
                this.mBd.endTransaction();
            }
            this.mBe.close();
            this.mBf.close();
            this.mBd.close();
            this.mBd = null;
        }
        AppMethodBeat.m2505o(136556);
    }

    public final synchronized void beginTransaction() {
        AppMethodBeat.m2504i(136557);
        if (this.mBd == null || this.mBd.inTransaction()) {
            AppMethodBeat.m2505o(136557);
        } else {
            this.mBd.beginTransaction();
            AppMethodBeat.m2505o(136557);
        }
    }

    public final boolean inTransaction() {
        AppMethodBeat.m2504i(136558);
        if (this.mBd == null || !this.mBd.inTransaction()) {
            AppMethodBeat.m2505o(136558);
            return false;
        }
        AppMethodBeat.m2505o(136558);
        return true;
    }

    public final synchronized void commit() {
        AppMethodBeat.m2504i(136559);
        if (this.mBd == null || !this.mBd.inTransaction()) {
            AppMethodBeat.m2505o(136559);
        } else {
            this.mBd.setTransactionSuccessful();
            this.mBd.endTransaction();
            AppMethodBeat.m2505o(136559);
        }
    }

    public final synchronized void rollback() {
        AppMethodBeat.m2504i(136560);
        if (this.mBd != null && this.mBd.isOpen() && this.mBd.inTransaction()) {
            C4990ab.m7416i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.mBd.endTransaction();
                AppMethodBeat.m2505o(136560);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", e);
                AppMethodBeat.m2505o(136560);
            }
        } else {
            AppMethodBeat.m2505o(136560);
        }
        return;
    }

    protected static final void bAb() {
        AppMethodBeat.m2504i(136561);
        C1720g.m3537RQ();
        new File(C1720g.m3536RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").delete();
        AppMethodBeat.m2505o(136561);
    }

    public static final File bAc() {
        AppMethodBeat.m2504i(136562);
        C1720g.m3537RQ();
        File file = new File(C1720g.m3536RP().cachePath, "FTS5IndexMicroMsg_encrypt.db");
        AppMethodBeat.m2505o(136562);
        return file;
    }

    private static void bAd() {
        AppMethodBeat.m2504i(136563);
        File[] listFiles = new File("/system/usr/icu").listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "icu file %s", listFiles[i].getName());
            }
        }
        AppMethodBeat.m2505o(136563);
    }
}
