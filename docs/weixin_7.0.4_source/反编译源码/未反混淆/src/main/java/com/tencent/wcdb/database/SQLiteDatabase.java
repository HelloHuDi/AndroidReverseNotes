package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.database.SQLiteDebug.DbStats;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class SQLiteDatabase extends SQLiteClosable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteDatabase.class.desiredAssertionStatus());
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_IO_TRACE = 256;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    public static final int SYNCHRONOUS_EXTRA = 3;
    public static final int SYNCHRONOUS_FULL = 2;
    public static final int SYNCHRONOUS_NORMAL = 1;
    public static final int SYNCHRONOUS_OFF = 0;
    private static final String TAG = "WCDB.SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap();
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock = new Object();
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() {
        /* Access modifiers changed, original: protected */
        public SQLiteSession initialValue() {
            AppMethodBeat.i(12422);
            SQLiteSession createSession = SQLiteDatabase.this.createSession();
            AppMethodBeat.o(12422);
            return createSession;
        }
    };

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram);

        SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal);
    }

    public interface CustomFunction {
        void callback(String[] strArr);
    }

    static {
        AppMethodBeat.i(12539);
        SQLiteGlobal.loadLib();
        AppMethodBeat.o(12539);
    }

    private SQLiteDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12425);
        this.mCursorFactory = cursorFactory;
        if (databaseErrorHandler == null) {
            databaseErrorHandler = new DefaultDatabaseErrorHandler(true);
        }
        this.mErrorHandler = databaseErrorHandler;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(str, i);
        AppMethodBeat.o(12425);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(12426);
        try {
            dispose(true);
        } finally {
            super.finalize();
            AppMethodBeat.o(12426);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAllReferencesReleased() {
        AppMethodBeat.i(12427);
        dispose(false);
        AppMethodBeat.o(12427);
    }

    private void dispose(boolean z) {
        SQLiteConnectionPool sQLiteConnectionPool;
        AppMethodBeat.i(12428);
        synchronized (this.mLock) {
            try {
                sQLiteConnectionPool = this.mConnectionPoolLocked;
                this.mConnectionPoolLocked = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(12428);
                }
            }
        }
        if (!z) {
            synchronized (sActiveDatabases) {
                try {
                    sActiveDatabases.remove(this);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(12428);
                    }
                }
            }
            if (sQLiteConnectionPool != null) {
                sQLiteConnectionPool.close();
            }
        }
        AppMethodBeat.o(12428);
    }

    public static int releaseMemory() {
        AppMethodBeat.i(12429);
        int releaseMemory = SQLiteGlobal.releaseMemory();
        AppMethodBeat.o(12429);
        return releaseMemory;
    }

    @Deprecated
    public final void setLockingEnabled(boolean z) {
    }

    /* Access modifiers changed, original: final */
    public final String getLabel() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.label;
        }
        return str;
    }

    /* Access modifiers changed, original: final */
    public final void onCorruption() {
        AppMethodBeat.i(12430);
        this.mErrorHandler.onCorruption(this);
        AppMethodBeat.o(12430);
    }

    /* Access modifiers changed, original: final */
    public final SQLiteSession getThreadSession() {
        AppMethodBeat.i(12431);
        SQLiteSession sQLiteSession = (SQLiteSession) this.mThreadSession.get();
        AppMethodBeat.o(12431);
        return sQLiteSession;
    }

    /* Access modifiers changed, original: final */
    public final SQLiteSession createSession() {
        SQLiteConnectionPool sQLiteConnectionPool;
        AppMethodBeat.i(12432);
        SQLiteSession sQLiteSession = this.mLock;
        synchronized (sQLiteSession) {
            try {
                throwIfNotOpenLocked();
                sQLiteConnectionPool = this.mConnectionPoolLocked;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12432);
            }
        }
        sQLiteSession = new SQLiteSession(sQLiteConnectionPool);
        return sQLiteSession;
    }

    /* Access modifiers changed, original: final */
    public final int getThreadDefaultConnectionFlags(boolean z) {
        AppMethodBeat.i(12433);
        int i = z ? 1 : 2;
        if (isMainThread()) {
            i |= 4;
        }
        AppMethodBeat.o(12433);
        return i;
    }

    private static boolean isMainThread() {
        AppMethodBeat.i(12434);
        Looper myLooper = Looper.myLooper();
        if (myLooper == null || myLooper != Looper.getMainLooper()) {
            AppMethodBeat.o(12434);
            return false;
        }
        AppMethodBeat.o(12434);
        return true;
    }

    public final void beginTransaction() {
        AppMethodBeat.i(12435);
        beginTransaction(null, true);
        AppMethodBeat.o(12435);
    }

    public final void beginTransactionNonExclusive() {
        AppMethodBeat.i(12436);
        beginTransaction(null, false);
        AppMethodBeat.o(12436);
    }

    public final void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        AppMethodBeat.i(12437);
        beginTransaction(sQLiteTransactionListener, true);
        AppMethodBeat.o(12437);
    }

    public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        AppMethodBeat.i(12438);
        beginTransaction(sQLiteTransactionListener, false);
        AppMethodBeat.o(12438);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, boolean z) {
        AppMethodBeat.i(12439);
        acquireReference();
        try {
            getThreadSession().beginTransaction(z ? 2 : 1, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
        } finally {
            releaseReference();
            AppMethodBeat.o(12439);
        }
    }

    public final void endTransaction() {
        AppMethodBeat.i(12440);
        acquireReference();
        try {
            getThreadSession().endTransaction(null);
        } finally {
            releaseReference();
            AppMethodBeat.o(12440);
        }
    }

    public final void setTransactionSuccessful() {
        AppMethodBeat.i(12441);
        acquireReference();
        try {
            getThreadSession().setTransactionSuccessful();
        } finally {
            releaseReference();
            AppMethodBeat.o(12441);
        }
    }

    public final boolean inTransaction() {
        AppMethodBeat.i(12442);
        acquireReference();
        try {
            boolean hasTransaction = getThreadSession().hasTransaction();
            return hasTransaction;
        } finally {
            releaseReference();
            AppMethodBeat.o(12442);
        }
    }

    public final boolean isDbLockedByCurrentThread() {
        AppMethodBeat.i(12443);
        acquireReference();
        try {
            boolean hasConnection = getThreadSession().hasConnection();
            return hasConnection;
        } finally {
            releaseReference();
            AppMethodBeat.o(12443);
        }
    }

    @Deprecated
    public final boolean isDbLockedByOtherThreads() {
        return false;
    }

    @Deprecated
    public final boolean yieldIfContended() {
        AppMethodBeat.i(12444);
        boolean yieldIfContendedHelper = yieldIfContendedHelper(false, -1);
        AppMethodBeat.o(12444);
        return yieldIfContendedHelper;
    }

    public final boolean yieldIfContendedSafely() {
        AppMethodBeat.i(12445);
        boolean yieldIfContendedHelper = yieldIfContendedHelper(true, -1);
        AppMethodBeat.o(12445);
        return yieldIfContendedHelper;
    }

    public final boolean yieldIfContendedSafely(long j) {
        AppMethodBeat.i(12446);
        boolean yieldIfContendedHelper = yieldIfContendedHelper(true, j);
        AppMethodBeat.o(12446);
        return yieldIfContendedHelper;
    }

    private boolean yieldIfContendedHelper(boolean z, long j) {
        AppMethodBeat.i(12447);
        acquireReference();
        try {
            boolean yieldTransaction = getThreadSession().yieldTransaction(j, z, null);
            return yieldTransaction;
        } finally {
            releaseReference();
            AppMethodBeat.o(12447);
        }
    }

    @Deprecated
    public final Map<String, String> getSyncedTables() {
        AppMethodBeat.i(12448);
        HashMap hashMap = new HashMap(0);
        AppMethodBeat.o(12448);
        return hashMap;
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i) {
        AppMethodBeat.i(12449);
        SQLiteDatabase openDatabase = openDatabase(str, cursorFactory, i, null);
        AppMethodBeat.o(12449);
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(12450);
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(str, i, cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open(bArr, sQLiteCipherSpec, i2);
        AppMethodBeat.o(12450);
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12451);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, i, databaseErrorHandler, 0);
        AppMethodBeat.o(12451);
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12452);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, i, databaseErrorHandler, 0);
        AppMethodBeat.o(12452);
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(12453);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, i, databaseErrorHandler, i2);
        AppMethodBeat.o(12453);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorFactory) {
        AppMethodBeat.i(12454);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), cursorFactory);
        AppMethodBeat.o(12454);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12455);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, sQLiteCipherSpec, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(12455);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        AppMethodBeat.i(12456);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, sQLiteCipherSpec, cursorFactory, databaseErrorHandler, i);
        AppMethodBeat.o(12456);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12457);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, null, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(12457);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        AppMethodBeat.i(12458);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, null, cursorFactory, databaseErrorHandler, i);
        AppMethodBeat.o(12458);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, int i) {
        AppMethodBeat.i(12459);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 268435456, null, i);
        AppMethodBeat.o(12459);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, CursorFactory cursorFactory) {
        AppMethodBeat.i(12460);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 805306368, null, 0);
        AppMethodBeat.o(12460);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, CursorFactory cursorFactory, int i) {
        AppMethodBeat.i(12461);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 805306368, null, i);
        AppMethodBeat.o(12461);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        AppMethodBeat.i(12462);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 268435456, null, 0);
        AppMethodBeat.o(12462);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, boolean z) {
        AppMethodBeat.i(12463);
        int i = 268435456;
        if (z) {
            i = 805306368;
        }
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, i, null, 0);
        AppMethodBeat.o(12463);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        AppMethodBeat.i(12464);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 268435456, databaseErrorHandler, i);
        AppMethodBeat.o(12464);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        AppMethodBeat.i(12465);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 805306368, databaseErrorHandler, i);
        AppMethodBeat.o(12465);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory) {
        AppMethodBeat.i(12466);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 805306368, null, 0);
        AppMethodBeat.o(12466);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory cursorFactory) {
        AppMethodBeat.i(12467);
        SQLiteDatabase openDatabase = openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, null, null, cursorFactory, 805306368, null, 0);
        AppMethodBeat.o(12467);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        AppMethodBeat.i(12468);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(str, bArr, null, cursorFactory, databaseErrorHandler, i);
        AppMethodBeat.o(12468);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12469);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(str, bArr, null, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(12469);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12470);
        SQLiteDatabase openDatabase = openDatabase(str, cursorFactory, 268435456, databaseErrorHandler);
        AppMethodBeat.o(12470);
        return openDatabase;
    }

    public static boolean deleteDatabase(File file) {
        AppMethodBeat.i(12471);
        if (file == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("file must not be null");
            AppMethodBeat.o(12471);
            throw illegalArgumentException;
        }
        boolean delete = ((file.delete() | new File(file.getPath() + "-journal").delete()) | new File(file.getPath() + "-shm").delete()) | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] listFiles = parentFile.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.i(12424);
                    boolean startsWith = file.getName().startsWith(str);
                    AppMethodBeat.o(12424);
                    return startsWith;
                }
            });
            if (listFiles != null) {
                for (File delete2 : listFiles) {
                    delete |= delete2.delete();
                }
            }
        }
        AppMethodBeat.o(12471);
        return delete;
    }

    /* JADX WARNING: Missing block: B:18:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void reopenReadWrite() {
        int i;
        int i2 = 12472;
        AppMethodBeat.i(12472);
        synchronized (this.mLock) {
            boolean e;
            try {
                throwIfNotOpenLocked();
                e = isReadOnlyLocked();
                if (e) {
                    i = this.mConfigurationLocked.openFlags;
                    this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & -2) | 0;
                    e = this.mConnectionPoolLocked;
                    e.reconfigure(this.mConfigurationLocked);
                }
            } catch (RuntimeException e2) {
                e = e2;
                this.mConfigurationLocked.openFlags = i;
                i = 12472;
                throw e;
            } finally {
                AppMethodBeat.o(
/*
Method generation error in method: com.tencent.wcdb.database.SQLiteDatabase.reopenReadWrite():void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE  (wrap: int
  ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_3 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.wcdb.database.SQLiteDatabase.reopenReadWrite():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_3 'i' int) in method: com.tencent.wcdb.database.SQLiteDatabase.reopenReadWrite():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    private void open(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i) {
        AppMethodBeat.i(12473);
        try {
            openInner(bArr, sQLiteCipherSpec, i);
            try {
                AppMethodBeat.o(12473);
            } catch (SQLiteException e) {
                Log.e(TAG, "Failed to open database '" + getLabel() + "'.", e);
                close();
                AppMethodBeat.o(12473);
                throw e;
            }
        } catch (SQLiteDatabaseCorruptException e2) {
            onCorruption();
            openInner(bArr, sQLiteCipherSpec, i);
            AppMethodBeat.o(12473);
        }
    }

    private void openInner(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i) {
        AppMethodBeat.i(12474);
        synchronized (this.mLock) {
            try {
                if ($assertionsDisabled || this.mConnectionPoolLocked == null) {
                    this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, bArr, sQLiteCipherSpec, i);
                } else {
                    Object assertionError = new AssertionError();
                    throw assertionError;
                }
            } finally {
                AppMethodBeat.o(12474);
            }
        }
        synchronized (sActiveDatabases) {
            try {
                sActiveDatabases.put(this, null);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12474);
            }
        }
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory) {
        AppMethodBeat.i(12475);
        SQLiteDatabase openDatabase = openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, cursorFactory, 268435456);
        AppMethodBeat.o(12475);
        return openDatabase;
    }

    public final void addExtension(SQLiteExtension sQLiteExtension) {
        AppMethodBeat.i(12476);
        synchronized (this.mLock) {
            RuntimeException add;
            try {
                throwIfNotOpenLocked();
                add = this.mConfigurationLocked.extensions.add(sQLiteExtension);
                if (add == true) {
                    add = this.mConnectionPoolLocked;
                    add.reconfigure(this.mConfigurationLocked);
                }
            } catch (RuntimeException e) {
                add = e;
                this.mConfigurationLocked.extensions.remove(sQLiteExtension);
                throw add;
            } finally {
                AppMethodBeat.o(12476);
            }
        }
    }

    public final int getVersion() {
        AppMethodBeat.i(12477);
        int intValue = Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
        AppMethodBeat.o(12477);
        return intValue;
    }

    public final void setVersion(int i) {
        AppMethodBeat.i(12478);
        execSQL("PRAGMA user_version = ".concat(String.valueOf(i)));
        AppMethodBeat.o(12478);
    }

    public final long getMaximumSize() {
        AppMethodBeat.i(12479);
        long longForQuery = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
        AppMethodBeat.o(12479);
        return longForQuery;
    }

    public final long setMaximumSize(long j) {
        AppMethodBeat.i(12480);
        long pageSize = getPageSize();
        long j2 = j / pageSize;
        if (j % pageSize != 0) {
            j2++;
        }
        j2 = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = ".concat(String.valueOf(j2)), null) * pageSize;
        AppMethodBeat.o(12480);
        return j2;
    }

    public final long getPageSize() {
        AppMethodBeat.i(12481);
        long longForQuery = DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
        AppMethodBeat.o(12481);
        return longForQuery;
    }

    public final void setPageSize(long j) {
        AppMethodBeat.i(12482);
        execSQL("PRAGMA page_size = ".concat(String.valueOf(j)));
        AppMethodBeat.o(12482);
    }

    @Deprecated
    public final void markTableSyncable(String str, String str2) {
    }

    @Deprecated
    public final void markTableSyncable(String str, String str2, String str3) {
    }

    public static String findEditTable(String str) {
        AppMethodBeat.i(12483);
        if (TextUtils.isEmpty(str)) {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid tables");
            AppMethodBeat.o(12483);
            throw illegalStateException;
        }
        int indexOf = str.indexOf(32);
        int indexOf2 = str.indexOf(44);
        if (indexOf > 0 && (indexOf < indexOf2 || indexOf2 < 0)) {
            str = str.substring(0, indexOf);
            AppMethodBeat.o(12483);
            return str;
        } else if (indexOf2 <= 0 || (indexOf2 >= indexOf && indexOf >= 0)) {
            AppMethodBeat.o(12483);
            return str;
        } else {
            str = str.substring(0, indexOf2);
            AppMethodBeat.o(12483);
            return str;
        }
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.i(12484);
        acquireReference();
        try {
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, null);
            return sQLiteStatement;
        } finally {
            releaseReference();
            AppMethodBeat.o(12484);
        }
    }

    public final Cursor query(boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(12485);
        Cursor queryWithFactory = queryWithFactory(null, z, str, strArr, str2, objArr, str3, str4, str5, str6, null);
        AppMethodBeat.o(12485);
        return queryWithFactory;
    }

    public final Cursor query(boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12486);
        Cursor queryWithFactory = queryWithFactory(null, z, str, strArr, str2, objArr, str3, str4, str5, str6, cancellationSignal);
        AppMethodBeat.o(12486);
        return queryWithFactory;
    }

    public final Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(12487);
        Cursor queryWithFactory = queryWithFactory(cursorFactory, z, str, strArr, str2, objArr, str3, str4, str5, str6, null);
        AppMethodBeat.o(12487);
        return queryWithFactory;
    }

    public final Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12488);
        acquireReference();
        try {
            Cursor rawQueryWithFactory = rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), objArr, findEditTable(str), cancellationSignal);
            return rawQueryWithFactory;
        } finally {
            releaseReference();
            AppMethodBeat.o(12488);
        }
    }

    public final Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5) {
        AppMethodBeat.i(12489);
        Cursor query = query(false, str, strArr, str2, objArr, str3, str4, str5, null);
        AppMethodBeat.o(12489);
        return query;
    }

    public final Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(12490);
        Cursor query = query(false, str, strArr, str2, objArr, str3, str4, str5, str6);
        AppMethodBeat.o(12490);
        return query;
    }

    public final Cursor rawQuery(String str, Object[] objArr) {
        AppMethodBeat.i(12491);
        Cursor rawQueryWithFactory = rawQueryWithFactory(null, str, objArr, null, null);
        AppMethodBeat.o(12491);
        return rawQueryWithFactory;
    }

    public final Cursor rawQuery(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12492);
        Cursor rawQueryWithFactory = rawQueryWithFactory(null, str, objArr, null, cancellationSignal);
        AppMethodBeat.o(12492);
        return rawQueryWithFactory;
    }

    public final Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2) {
        AppMethodBeat.i(12493);
        Cursor rawQueryWithFactory = rawQueryWithFactory(cursorFactory, str, objArr, str2, null);
        AppMethodBeat.o(12493);
        return rawQueryWithFactory;
    }

    public final Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12494);
        acquireReference();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, cancellationSignal);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, objArr);
            return query;
        } finally {
            releaseReference();
            AppMethodBeat.o(12494);
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(12495);
        try {
            long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 0);
            AppMethodBeat.o(12495);
            return insertWithOnConflict;
        } catch (SQLiteDatabaseCorruptException e) {
            AppMethodBeat.o(12495);
            throw e;
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting %s: %s", contentValues, e2);
            AppMethodBeat.o(12495);
            return -1;
        }
    }

    public final long insertOrThrow(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(12496);
        long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 0);
        AppMethodBeat.o(12496);
        return insertWithOnConflict;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(12497);
        try {
            long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 5);
            AppMethodBeat.o(12497);
            return insertWithOnConflict;
        } catch (SQLiteDatabaseCorruptException e) {
            AppMethodBeat.o(12497);
            throw e;
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting ".concat(String.valueOf(contentValues)), e2);
            AppMethodBeat.o(12497);
            return -1;
        }
    }

    public final long replaceOrThrow(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(12498);
        long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 5);
        AppMethodBeat.o(12498);
        return insertWithOnConflict;
    }

    private Set<String> keySet(ContentValues contentValues) {
        AppMethodBeat.i(12499);
        if (VERSION.SDK_INT < 11) {
            try {
                Field declaredField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
                declaredField.setAccessible(true);
                Set keySet = ((HashMap) declaredField.get(contentValues)).keySet();
                AppMethodBeat.o(12499);
                return keySet;
            } catch (Exception e) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.o(12499);
                throw runtimeException;
            }
        }
        Set<String> keySet2 = contentValues.keySet();
        AppMethodBeat.o(12499);
        return keySet2;
    }

    public final long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i) {
        int i2 = 0;
        AppMethodBeat.i(GoogleSignInStatusCodes.SIGN_IN_FAILED);
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT");
            stringBuilder.append(CONFLICT_VALUES[i]);
            stringBuilder.append(" INTO ");
            stringBuilder.append(str);
            stringBuilder.append('(');
            Object[] objArr = null;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                Object[] objArr2 = new Object[size];
                int i3 = 0;
                for (String str3 : keySet(contentValues)) {
                    stringBuilder.append(i3 > 0 ? "," : "");
                    stringBuilder.append(str3);
                    int i4 = i3 + 1;
                    objArr2[i3] = contentValues.get(str3);
                    i3 = i4;
                }
                stringBuilder.append(')');
                stringBuilder.append(" VALUES (");
                while (i2 < size) {
                    stringBuilder.append(i2 > 0 ? ",?" : "?");
                    i2++;
                }
                objArr = objArr2;
            } else {
                stringBuilder.append(str2 + ") VALUES (NULL");
            }
            stringBuilder.append(')');
            sQLiteStatement = new SQLiteStatement(this, stringBuilder.toString(), objArr);
            long executeInsert = sQLiteStatement.executeInsert();
            sQLiteStatement.close();
            releaseReference();
            AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            return executeInsert;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_FAILED);
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        AppMethodBeat.i(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            sQLiteStatement = new SQLiteStatement(this, "DELETE FROM " + str + (!TextUtils.isEmpty(str2) ? " WHERE ".concat(String.valueOf(str2)) : ""), strArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CANCELLED);
        }
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.i(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
        int updateWithOnConflict = updateWithOnConflict(str, contentValues, str2, strArr, 0);
        AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
        return updateWithOnConflict;
    }

    public final int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        AppMethodBeat.i(12503);
        if (contentValues == null || contentValues.size() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Empty values");
            AppMethodBeat.o(12503);
            throw illegalArgumentException;
        }
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            StringBuilder stringBuilder = new StringBuilder(120);
            stringBuilder.append("UPDATE ");
            stringBuilder.append(CONFLICT_VALUES[i]);
            stringBuilder.append(str);
            stringBuilder.append(" SET ");
            int size = contentValues.size();
            int length = strArr == null ? size : strArr.length + size;
            Object[] objArr = new Object[length];
            int i2 = 0;
            for (String str3 : keySet(contentValues)) {
                stringBuilder.append(i2 > 0 ? "," : "");
                stringBuilder.append(str3);
                int i3 = i2 + 1;
                objArr[i2] = contentValues.get(str3);
                stringBuilder.append("=?");
                i2 = i3;
            }
            if (strArr != null) {
                for (int i4 = size; i4 < length; i4++) {
                    objArr[i4] = strArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append(" WHERE ");
                stringBuilder.append(str2);
            }
            sQLiteStatement = new SQLiteStatement(this, stringBuilder.toString(), objArr);
            size = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            AppMethodBeat.o(12503);
            return size;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12503);
        }
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(12504);
        executeSql(str, null, null);
        AppMethodBeat.o(12504);
    }

    public final void execSQL(String str, Object[] objArr) {
        AppMethodBeat.i(12505);
        executeSql(str, objArr, null);
        AppMethodBeat.o(12505);
    }

    public final void execSQL(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12506);
        executeSql(str, objArr, cancellationSignal);
        AppMethodBeat.o(12506);
    }

    private int executeSql(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        Object obj = 1;
        AppMethodBeat.i(12507);
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            if (DatabaseUtils.getSqlStatementType(str) == 3) {
                synchronized (this.mLock) {
                    if (this.mHasAttachedDbsLocked) {
                        obj = null;
                    } else {
                        this.mHasAttachedDbsLocked = true;
                    }
                }
                if (obj != null) {
                    disableWriteAheadLogging();
                }
            }
            sQLiteStatement = new SQLiteStatement(this, str, objArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete(cancellationSignal);
            sQLiteStatement.close();
            releaseReference();
            AppMethodBeat.o(12507);
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(12507);
        }
    }

    public final Pair<Integer, Integer> walCheckpoint(String str, boolean z) {
        AppMethodBeat.i(12508);
        acquireReference();
        try {
            Pair<Integer, Integer> walCheckpoint = getThreadSession().walCheckpoint(str, z ? 2 : 0);
            return walCheckpoint;
        } finally {
            releaseReference();
            AppMethodBeat.o(12508);
        }
    }

    public final boolean isReadOnly() {
        boolean isReadOnlyLocked;
        AppMethodBeat.i(12509);
        synchronized (this.mLock) {
            try {
                isReadOnlyLocked = isReadOnlyLocked();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12509);
            }
        }
        return isReadOnlyLocked;
    }

    private boolean isReadOnlyLocked() {
        return (this.mConfigurationLocked.openFlags & 1) == 1;
    }

    public final boolean isInMemoryDatabase() {
        boolean isInMemoryDb;
        AppMethodBeat.i(12510);
        synchronized (this.mLock) {
            try {
                isInMemoryDb = this.mConfigurationLocked.isInMemoryDb();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12510);
            }
        }
        return isInMemoryDb;
    }

    public final boolean isOpen() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnectionPoolLocked != null;
        }
        return z;
    }

    public final boolean needUpgrade(int i) {
        AppMethodBeat.i(12511);
        if (i > getVersion()) {
            AppMethodBeat.o(12511);
            return true;
        }
        AppMethodBeat.o(12511);
        return false;
    }

    public final String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
    }

    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setLocale(Locale locale) {
        int i;
        int i2 = 12512;
        AppMethodBeat.i(12512);
        if (locale == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("locale must not be null.");
            AppMethodBeat.o(12512);
            throw illegalArgumentException;
        }
        synchronized (this.mLock) {
            SQLiteConnectionPool e;
            try {
                throwIfNotOpenLocked();
                i = this.mConfigurationLocked.locale;
                this.mConfigurationLocked.locale = locale;
                e = this.mConnectionPoolLocked;
                e.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e2) {
                e = e2;
                this.mConfigurationLocked.locale = i;
                i = 12512;
                throw e;
            } finally {
                AppMethodBeat.o(
/*
Method generation error in method: com.tencent.wcdb.database.SQLiteDatabase.setLocale(java.util.Locale):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: INVOKE  (wrap: int
  ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_3 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.wcdb.database.SQLiteDatabase.setLocale(java.util.Locale):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_3 'i' int) in method: com.tencent.wcdb.database.SQLiteDatabase.setLocale(java.util.Locale):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 31 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 36 more

*/

    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setMaxSqlCacheSize(int i) {
        int i2;
        int i3 = 12513;
        AppMethodBeat.i(12513);
        if (i > 100 || i < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("expected value between 0 and 100");
            AppMethodBeat.o(12513);
            throw illegalStateException;
        }
        synchronized (this.mLock) {
            SQLiteConnectionPool e;
            try {
                throwIfNotOpenLocked();
                i2 = this.mConfigurationLocked.maxSqlCacheSize;
                this.mConfigurationLocked.maxSqlCacheSize = i;
                e = this.mConnectionPoolLocked;
                e.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e2) {
                e = e2;
                this.mConfigurationLocked.maxSqlCacheSize = i2;
                i2 = 12513;
                throw e;
            } finally {
                AppMethodBeat.o(
/*
Method generation error in method: com.tencent.wcdb.database.SQLiteDatabase.setMaxSqlCacheSize(int):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003e: INVOKE  (wrap: int
  ?: MERGE  (r4_1 int) = (r4_0 'i3' int), (r2_3 'i2' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.wcdb.database.SQLiteDatabase.setMaxSqlCacheSize(int):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_1 int) = (r4_0 'i3' int), (r2_3 'i2' int) in method: com.tencent.wcdb.database.SQLiteDatabase.setMaxSqlCacheSize(int):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 31 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 36 more

*/

    public final void setForeignKeyConstraintsEnabled(boolean z) {
        AppMethodBeat.i(12514);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == z) {
                    AppMethodBeat.o(12514);
                    return;
                }
                this.mConfigurationLocked.foreignKeyConstraintsEnabled = z;
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                AppMethodBeat.o(12514);
            } catch (RuntimeException e) {
                this.mConfigurationLocked.foreignKeyConstraintsEnabled = !z;
                AppMethodBeat.o(12514);
                throw e;
            } catch (Throwable th) {
                AppMethodBeat.o(12514);
                throw th;
            }
        }
    }

    public final SQLiteCheckpointListener getCheckpointCallback() {
        SQLiteCheckpointListener checkpointListener;
        AppMethodBeat.i(12515);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (this.mConfigurationLocked.customWALHookEnabled) {
                    checkpointListener = this.mConnectionPoolLocked.getCheckpointListener();
                    AppMethodBeat.o(12515);
                } else {
                    checkpointListener = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12515);
            }
        }
        return checkpointListener;
    }

    public final void setCheckpointCallback(SQLiteCheckpointListener sQLiteCheckpointListener) {
        boolean z = true;
        AppMethodBeat.i(12516);
        boolean z2 = sQLiteCheckpointListener != null;
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (this.mConfigurationLocked.customWALHookEnabled != z2) {
                    this.mConfigurationLocked.customWALHookEnabled = z2;
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                }
                this.mConnectionPoolLocked.setCheckpointListener(sQLiteCheckpointListener);
            } catch (RuntimeException e) {
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                if (z2) {
                    z = false;
                }
                sQLiteDatabaseConfiguration.customWALHookEnabled = z;
                AppMethodBeat.o(12516);
                throw e;
            } catch (Throwable th) {
                AppMethodBeat.o(12516);
                throw th;
            }
        }
        AppMethodBeat.o(12516);
    }

    public final boolean getAsyncCheckpointEnabled() {
        AppMethodBeat.i(12517);
        SQLiteCheckpointListener checkpointCallback = getCheckpointCallback();
        if (checkpointCallback == null || !(checkpointCallback instanceof SQLiteAsyncCheckpointer)) {
            AppMethodBeat.o(12517);
            return false;
        }
        AppMethodBeat.o(12517);
        return true;
    }

    public final void setAsyncCheckpointEnabled(boolean z) {
        AppMethodBeat.i(12518);
        setCheckpointCallback(z ? new SQLiteAsyncCheckpointer() : null);
        AppMethodBeat.o(12518);
    }

    public final boolean enableWriteAheadLogging() {
        boolean z = true;
        AppMethodBeat.i(12519);
        synchronized (this.mLock) {
            SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration;
            try {
                throwIfNotOpenLocked();
                if ((this.mConfigurationLocked.openFlags & 536870912) != 0) {
                } else if (isReadOnlyLocked()) {
                    AppMethodBeat.o(12519);
                    return false;
                } else if (this.mConfigurationLocked.isInMemoryDb()) {
                    Log.i(TAG, "can't enable WAL for memory databases.");
                    AppMethodBeat.o(12519);
                    return false;
                } else if (this.mHasAttachedDbsLocked) {
                    Log.i(TAG, "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
                    AppMethodBeat.o(12519);
                    return false;
                } else {
                    sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    sQLiteDatabaseConfiguration.openFlags |= 536870912;
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                }
                return z;
            } catch (RuntimeException e) {
                RuntimeException e2 = e;
                sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration.openFlags &= -536870913;
                throw e2;
            } finally {
                AppMethodBeat.o(12519);
            }
        }
    }

    public final void disableWriteAheadLogging() {
        AppMethodBeat.i(12520);
        synchronized (this.mLock) {
            RuntimeException e;
            try {
                throwIfNotOpenLocked();
                e = this.mConfigurationLocked.openFlags & 536870912;
                if (e == 0) {
                } else {
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    sQLiteDatabaseConfiguration.openFlags &= -536870913;
                    e = this.mConnectionPoolLocked;
                    e.reconfigure(this.mConfigurationLocked);
                }
            } catch (RuntimeException e2) {
                e = e2;
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration2.openFlags |= 536870912;
                throw e;
            } finally {
                AppMethodBeat.o(12520);
            }
        }
    }

    public final boolean isWriteAheadLoggingEnabled() {
        boolean z;
        AppMethodBeat.i(12521);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                z = (this.mConfigurationLocked.openFlags & 536870912) != 0;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12521);
            }
        }
        return z;
    }

    public final int getSynchronousMode() {
        int i;
        AppMethodBeat.i(12522);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                i = this.mConfigurationLocked.synchronousMode;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12522);
            }
        }
        return i;
    }

    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setSynchronousMode(int i) {
        int i2 = 12523;
        AppMethodBeat.i(12523);
        synchronized (this.mLock) {
            RuntimeException runtimeException;
            int i3;
            try {
                throwIfNotOpenLocked();
                runtimeException = this.mConfigurationLocked;
                i3 = runtimeException.synchronousMode;
                if (i3 != i) {
                    this.mConfigurationLocked.synchronousMode = i;
                    runtimeException = this.mConnectionPoolLocked;
                    runtimeException.reconfigure(this.mConfigurationLocked);
                }
            } catch (RuntimeException e) {
                runtimeException = e;
                this.mConfigurationLocked.synchronousMode = i3;
                i3 = 12523;
                throw runtimeException;
            } finally {
                AppMethodBeat.o(
/*
Method generation error in method: com.tencent.wcdb.database.SQLiteDatabase.setSynchronousMode(int):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: INVOKE  (wrap: int
  ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_3 'i3' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.wcdb.database.SQLiteDatabase.setSynchronousMode(int):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_3 'i3' int) in method: com.tencent.wcdb.database.SQLiteDatabase.setSynchronousMode(int):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    public final SQLiteChangeListener getChangeListener() {
        SQLiteChangeListener changeListener;
        AppMethodBeat.i(12524);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                changeListener = this.mConnectionPoolLocked.getChangeListener();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12524);
            }
        }
        return changeListener;
    }

    public final void setChangeListener(SQLiteChangeListener sQLiteChangeListener, boolean z) {
        AppMethodBeat.i(12525);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConnectionPoolLocked.setChangeListener(sQLiteChangeListener, z);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12525);
            }
        }
    }

    public final SQLiteTrace getTraceCallback() {
        SQLiteTrace traceCallback;
        AppMethodBeat.i(12526);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                traceCallback = this.mConnectionPoolLocked.getTraceCallback();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12526);
            }
        }
        return traceCallback;
    }

    public final void setTraceCallback(SQLiteTrace sQLiteTrace) {
        AppMethodBeat.i(12527);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConnectionPoolLocked.setTraceCallback(sQLiteTrace);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12527);
            }
        }
    }

    static ArrayList<DbStats> getDbStats() {
        AppMethodBeat.i(12528);
        ArrayList arrayList = new ArrayList();
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            ((SQLiteDatabase) it.next()).collectDbStats(arrayList);
        }
        AppMethodBeat.o(12528);
        return arrayList;
    }

    private void collectDbStats(ArrayList<DbStats> arrayList) {
        AppMethodBeat.i(12529);
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    this.mConnectionPoolLocked.collectDbStats(arrayList);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12529);
            }
        }
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        AppMethodBeat.i(12530);
        ArrayList<SQLiteDatabase> arrayList = new ArrayList();
        synchronized (sActiveDatabases) {
            try {
                arrayList.addAll(sActiveDatabases.keySet());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12530);
            }
        }
        return arrayList;
    }

    public static void dumpAll(Printer printer, boolean z) {
        AppMethodBeat.i(12531);
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            ((SQLiteDatabase) it.next()).dump(printer, z);
        }
        AppMethodBeat.o(12531);
    }

    public final void dump(Printer printer, boolean z) {
        AppMethodBeat.i(12532);
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    this.mConnectionPoolLocked.dump(printer, z);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12532);
            }
        }
    }

    /* JADX WARNING: Missing block: B:16:?, code skipped:
            r2 = rawQuery("pragma database_list;", null);
     */
    /* JADX WARNING: Missing block: B:19:0x0040, code skipped:
            if (r2.moveToNext() == false) goto L_0x0070;
     */
    /* JADX WARNING: Missing block: B:20:0x0042, code skipped:
            r1.add(new android.util.Pair(r2.getString(1), r2.getString(2)));
     */
    /* JADX WARNING: Missing block: B:22:0x0055, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0056, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:24:0x0057, code skipped:
            if (r2 != null) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:27:0x005c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12533);
     */
    /* JADX WARNING: Missing block: B:28:0x0061, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:30:0x0063, code skipped:
            releaseReference();
            com.tencent.matrix.trace.core.AppMethodBeat.o(12533);
     */
    /* JADX WARNING: Missing block: B:35:0x0070, code skipped:
            if (r2 == null) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:38:0x0075, code skipped:
            releaseReference();
            com.tencent.matrix.trace.core.AppMethodBeat.o(12533);
     */
    /* JADX WARNING: Missing block: B:39:0x007d, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:40:0x007e, code skipped:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<Pair<String, String>> getAttachedDbs() {
        AppMethodBeat.i(12533);
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked == null) {
                } else if (this.mHasAttachedDbsLocked) {
                    acquireReference();
                } else {
                    arrayList.add(new Pair("main", this.mConfigurationLocked.path));
                    AppMethodBeat.o(12533);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12533);
            }
        }
        return null;
    }

    public final boolean isDatabaseIntegrityOk() {
        Throwable th;
        AppMethodBeat.i(12534);
        acquireReference();
        List list;
        try {
            List attachedDbs = getAttachedDbs();
            if (attachedDbs == null) {
                IllegalStateException illegalStateException = new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");
                AppMethodBeat.o(12534);
                throw illegalStateException;
            }
            list = attachedDbs;
            int i = 0;
            while (i < list.size()) {
                Pair pair = (Pair) list.get(i);
                SQLiteStatement compileStatement;
                try {
                    compileStatement = compileStatement("PRAGMA " + ((String) pair.first) + ".integrity_check(1);");
                    try {
                        String simpleQueryForString = compileStatement.simpleQueryForString();
                        if (DatabaseUtils.objectEquals(simpleQueryForString, "ok")) {
                            if (compileStatement != null) {
                                compileStatement.close();
                            }
                            i++;
                        } else {
                            Log.e(TAG, "PRAGMA integrity_check on " + ((String) pair.second) + " returned: " + simpleQueryForString);
                            if (compileStatement != null) {
                                compileStatement.close();
                            }
                            releaseReference();
                            AppMethodBeat.o(12534);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (compileStatement != null) {
                            compileStatement.close();
                        }
                        AppMethodBeat.o(12534);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    compileStatement = null;
                }
            }
            releaseReference();
            AppMethodBeat.o(12534);
            return true;
        } catch (SQLiteException e) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("main", getPath()));
            list = arrayList;
        } catch (Throwable th4) {
            releaseReference();
            AppMethodBeat.o(12534);
        }
    }

    public final long acquireNativeConnectionHandle(String str, boolean z, boolean z2) {
        AppMethodBeat.i(12535);
        if (str == null) {
            str = "unnamedNative";
        }
        int i = z ? 1 : 2;
        if (z2) {
            i |= 4;
        }
        long nativeHandle = getThreadSession().acquireConnectionForNativeHandle(i).getNativeHandle(str);
        if (nativeHandle == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("SQLiteConnection native handle not initialized.");
            AppMethodBeat.o(12535);
            throw illegalStateException;
        }
        AppMethodBeat.o(12535);
        return nativeHandle;
    }

    public final void releaseNativeConnection(long j, Exception exception) {
        AppMethodBeat.i(12536);
        getThreadSession().releaseConnectionForNativeHandle(exception);
        AppMethodBeat.o(12536);
    }

    public final String toString() {
        AppMethodBeat.i(12537);
        String str = "SQLiteDatabase: " + getPath();
        AppMethodBeat.o(12537);
        return str;
    }

    private void throwIfNotOpenLocked() {
        AppMethodBeat.i(12538);
        if (this.mConnectionPoolLocked == null) {
            IllegalStateException illegalStateException = new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
            AppMethodBeat.o(12538);
            throw illegalStateException;
        }
        AppMethodBeat.o(12538);
    }
}
