package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.os.Process;
import android.util.Pair;
import android.util.Printer;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDebug.DbStats;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class SQLiteConnection implements OnCancelListener {
    private static final boolean DEBUG = false;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String[] HMAC_ALGO_MAPPING = new String[]{"HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512"};
    private static final String[] PBKDF2_ALGO_MAPPING = new String[]{"PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512"};
    private static final String TAG = "WCDB.SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    private StackTraceElement[] mAcquiredStack;
    private Thread mAcquiredThread;
    private int mAcquiredTid;
    private long mAcquiredTimestamp;
    private int mCancellationSignalAttachCount;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private int mNativeHandleCount;
    private Operation mNativeOperation;
    private boolean mOnlyAllowReadOnlyOperations;
    private byte[] mPassword;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations = new OperationLog();

    @SuppressLint({"SimpleDateFormat"})
    static final class Operation {
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ArrayList<Object> mBindArgs;
        int mCookie;
        long mEndTime;
        Exception mException;
        boolean mFinished;
        String mKind;
        String mSql;
        long mStartTime;
        int mTid;
        int mType;

        private Operation() {
        }

        static /* synthetic */ String access$2000(Operation operation) {
            AppMethodBeat.i(12273);
            String formattedStartTime = operation.getFormattedStartTime();
            AppMethodBeat.o(12273);
            return formattedStartTime;
        }

        static {
            AppMethodBeat.i(12274);
            AppMethodBeat.o(12274);
        }

        public final void describe(StringBuilder stringBuilder, boolean z) {
            AppMethodBeat.i(12271);
            stringBuilder.append(this.mKind);
            if (this.mFinished) {
                stringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
            } else {
                stringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
            }
            stringBuilder.append(" - ").append(getStatus());
            if (this.mSql != null) {
                stringBuilder.append(", sql=\"").append(SQLiteConnection.access$1500(this.mSql)).append("\"");
            }
            if (this.mTid > 0) {
                stringBuilder.append(", tid=").append(this.mTid);
            }
            if (!(!z || this.mBindArgs == null || this.mBindArgs.size() == 0)) {
                stringBuilder.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i = 0; i < size; i++) {
                    Object obj = this.mBindArgs.get(i);
                    if (i != 0) {
                        stringBuilder.append(", ");
                    }
                    if (obj == null) {
                        stringBuilder.append(BuildConfig.COMMAND);
                    } else if (obj instanceof byte[]) {
                        stringBuilder.append("<byte[]>");
                    } else if (obj instanceof String) {
                        stringBuilder.append("\"").append((String) obj).append("\"");
                    } else {
                        stringBuilder.append(obj);
                    }
                }
                stringBuilder.append("]");
            }
            if (!(this.mException == null || this.mException.getMessage() == null)) {
                stringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
            }
            AppMethodBeat.o(12271);
        }

        private String getStatus() {
            if (this.mFinished) {
                return this.mException != null ? "failed" : AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
            } else {
                return "running";
            }
        }

        private String getFormattedStartTime() {
            AppMethodBeat.i(12272);
            String format = sDateFormat.format(new Date(this.mStartTime));
            AppMethodBeat.o(12272);
            return format;
        }
    }

    final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;

        private OperationLog() {
            AppMethodBeat.i(12275);
            this.mOperations = new Operation[20];
            AppMethodBeat.o(12275);
        }

        public final Operation beginOperation(String str, String str2, Object[] objArr) {
            Operation operation;
            int i = 0;
            AppMethodBeat.i(12276);
            synchronized (this.mOperations) {
                try {
                    int i2 = (this.mIndex + 1) % 20;
                    operation = this.mOperations[i2];
                    if (operation == null) {
                        operation = new Operation();
                        this.mOperations[i2] = operation;
                    } else {
                        operation.mFinished = false;
                        operation.mException = null;
                        if (operation.mBindArgs != null) {
                            operation.mBindArgs.clear();
                        }
                    }
                    operation.mStartTime = System.currentTimeMillis();
                    operation.mKind = str;
                    operation.mSql = str2;
                    if (objArr != null) {
                        if (operation.mBindArgs == null) {
                            operation.mBindArgs = new ArrayList();
                        } else {
                            operation.mBindArgs.clear();
                        }
                        while (i < objArr.length) {
                            Object obj = objArr[i];
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.mBindArgs.add(obj);
                            } else {
                                operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                            }
                            i++;
                        }
                    }
                    operation.mCookie = newOperationCookieLocked(i2);
                    operation.mTid = SQLiteConnection.this.mAcquiredTid;
                    this.mIndex = i2;
                } finally {
                    AppMethodBeat.o(12276);
                }
            }
            return operation;
        }

        public final void failOperation(int i, Exception exception) {
            AppMethodBeat.i(12277);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i);
                    if (operationLocked != null) {
                        operationLocked.mException = exception;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(12277);
                }
            }
        }

        public final void endOperation(int i) {
            String str;
            String str2;
            int i2;
            long j;
            AppMethodBeat.i(12278);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i);
                    if (endOperationDeferLogLocked(operationLocked)) {
                        logOperationLocked(operationLocked, null);
                    }
                    str = operationLocked.mSql;
                    str2 = operationLocked.mKind;
                    i2 = operationLocked.mType;
                    j = operationLocked.mEndTime - operationLocked.mStartTime;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(12278);
                    }
                }
            }
            if (!"prepare".equals(str2)) {
                SQLiteConnection.this.mPool.traceExecute(str, i2, j);
            }
            AppMethodBeat.o(12278);
        }

        public final boolean endOperationDeferLog(int i) {
            boolean z;
            AppMethodBeat.i(12279);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i);
                    if (operationLocked == null) {
                        z = false;
                    } else {
                        z = endOperationDeferLogLocked(operationLocked);
                        String str = operationLocked.mSql;
                        String str2 = operationLocked.mKind;
                        int i2 = operationLocked.mType;
                        long j = operationLocked.mEndTime - operationLocked.mStartTime;
                        if (!"prepare".equals(str2)) {
                            SQLiteConnection.this.mPool.traceExecute(str, i2, j);
                        }
                        AppMethodBeat.o(12279);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(12279);
                }
            }
            return z;
        }

        public final void logOperation(int i, String str) {
            AppMethodBeat.i(12280);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i);
                    if (operationLocked != null) {
                        logOperationLocked(operationLocked, str);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(12280);
                }
            }
        }

        private boolean endOperationDeferLogLocked(Operation operation) {
            AppMethodBeat.i(12281);
            if (operation != null) {
                operation.mEndTime = System.currentTimeMillis();
                operation.mFinished = true;
                if (operation.mException == null || operation.mException.getMessage() == null) {
                    boolean shouldLogSlowQuery = SQLiteDebug.shouldLogSlowQuery(operation.mEndTime - operation.mStartTime);
                    AppMethodBeat.o(12281);
                    return shouldLogSlowQuery;
                }
                AppMethodBeat.o(12281);
                return true;
            }
            AppMethodBeat.o(12281);
            return false;
        }

        private void logOperationLocked(Operation operation, String str) {
            AppMethodBeat.i(12282);
            StringBuilder stringBuilder = new StringBuilder();
            operation.describe(stringBuilder, false);
            if (str != null) {
                stringBuilder.append(", ").append(str);
            }
            Log.i(SQLiteConnection.TAG, stringBuilder.toString());
            AppMethodBeat.o(12282);
        }

        private int newOperationCookieLocked(int i) {
            int i2 = this.mGeneration;
            this.mGeneration = i2 + 1;
            return (i2 << 8) | i;
        }

        private Operation getOperationLocked(int i) {
            Operation operation = this.mOperations[i & 255];
            return operation.mCookie == i ? operation : null;
        }

        public final String describeCurrentOperation() {
            String str;
            AppMethodBeat.i(12283);
            synchronized (this.mOperations) {
                try {
                    Operation operation = this.mOperations[this.mIndex];
                    if (operation == null || operation.mFinished) {
                        str = null;
                        AppMethodBeat.o(12283);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        operation.describe(stringBuilder, false);
                        str = stringBuilder.toString();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(12283);
                }
            }
            return str;
        }

        /* Access modifiers changed, original: final */
        public final TraceInfo<String> traceCurrentOperation() {
            TraceInfo<String> traceInfo;
            AppMethodBeat.i(12284);
            synchronized (this.mOperations) {
                try {
                    Operation operation = this.mOperations[this.mIndex];
                    if (operation == null || operation.mFinished) {
                        traceInfo = null;
                        AppMethodBeat.o(12284);
                    } else {
                        traceInfo = new TraceInfo(operation.mSql, operation.mStartTime, operation.mTid);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(12284);
                }
            }
            return traceInfo;
        }

        public final void dump(Printer printer, boolean z) {
            AppMethodBeat.i(12285);
            synchronized (this.mOperations) {
                try {
                    printer.println("  Most recently executed operations:");
                    int i = this.mIndex;
                    Operation operation = this.mOperations[i];
                    if (operation != null) {
                        int i2 = 0;
                        while (true) {
                            int i3;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("    ").append(i2).append(": [");
                            stringBuilder.append(Operation.access$2000(operation));
                            stringBuilder.append("] ");
                            operation.describe(stringBuilder, z);
                            printer.println(stringBuilder.toString());
                            if (i > 0) {
                                i3 = i - 1;
                            } else {
                                i3 = 19;
                            }
                            i2++;
                            operation = this.mOperations[i3];
                            if (operation == null || i2 >= 20) {
                                break;
                            }
                            i = i3;
                        }
                    } else {
                        printer.println("    <none>");
                    }
                } finally {
                    AppMethodBeat.o(12285);
                }
            }
        }
    }

    static final class PreparedStatement {
        private WeakReference<SQLiteConnection> mConnection;
        private boolean mInCache;
        private boolean mInUse;
        private int mNumParameters;
        private Operation mOperation;
        private PreparedStatement mPoolNext;
        private boolean mReadOnly;
        private String mSql;
        private long mStatementPtr;
        private int mType;

        PreparedStatement(SQLiteConnection sQLiteConnection) {
            AppMethodBeat.i(12286);
            this.mConnection = new WeakReference(sQLiteConnection);
            AppMethodBeat.o(12286);
        }

        public final void bindArguments(Object[] objArr) {
            AppMethodBeat.i(12287);
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12287);
                return;
            }
            SQLiteConnection.access$900(sQLiteConnection, this, objArr);
            AppMethodBeat.o(12287);
        }

        public final void reset(boolean z) {
            AppMethodBeat.i(12288);
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12288);
                return;
            }
            SQLiteConnection.access$1000(sQLiteConnection, this, z);
            AppMethodBeat.o(12288);
        }

        public final long getPtr() {
            return this.mStatementPtr;
        }

        public final String getSQL() {
            return this.mSql;
        }

        public final boolean isReadOnly() {
            return this.mReadOnly;
        }

        public final int getType() {
            return this.mType;
        }

        public final void attachCancellationSignal(CancellationSignal cancellationSignal) {
            AppMethodBeat.i(12289);
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12289);
                return;
            }
            SQLiteConnection.access$1100(sQLiteConnection, cancellationSignal);
            AppMethodBeat.o(12289);
        }

        public final void detachCancellationSignal(CancellationSignal cancellationSignal) {
            AppMethodBeat.i(12290);
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12290);
                return;
            }
            SQLiteConnection.access$1200(sQLiteConnection, cancellationSignal);
            AppMethodBeat.o(12290);
        }

        public final void beginOperation(String str, Object[] objArr) {
            AppMethodBeat.i(12291);
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12291);
                return;
            }
            this.mOperation = sQLiteConnection.mRecentOperations.beginOperation(str, this.mSql, objArr);
            this.mOperation.mType = this.mType;
            AppMethodBeat.o(12291);
        }

        public final void failOperation(Exception exception) {
            AppMethodBeat.i(12292);
            if (this.mOperation == null) {
                AppMethodBeat.o(12292);
                return;
            }
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12292);
                return;
            }
            sQLiteConnection.mRecentOperations.failOperation(this.mOperation.mCookie, exception);
            AppMethodBeat.o(12292);
        }

        public final void endOperation(String str) {
            AppMethodBeat.i(12293);
            if (this.mOperation == null) {
                AppMethodBeat.o(12293);
                return;
            }
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(12293);
                return;
            }
            if (sQLiteConnection.mRecentOperations.endOperationDeferLog(this.mOperation.mCookie)) {
                sQLiteConnection.mRecentOperations.logOperation(this.mOperation.mCookie, str);
            }
            this.mOperation = null;
            AppMethodBeat.o(12293);
        }
    }

    final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i) {
            super(i);
        }

        /* Access modifiers changed, original: protected|final */
        public final void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            AppMethodBeat.i(12294);
            preparedStatement.mInCache = false;
            if (!preparedStatement.mInUse) {
                SQLiteConnection.access$1400(SQLiteConnection.this, preparedStatement);
            }
            AppMethodBeat.o(12294);
        }

        public final void dump(Printer printer) {
            AppMethodBeat.i(12295);
            printer.println("  Prepared statement cache:");
            Map snapshot = snapshot();
            if (snapshot.isEmpty()) {
                printer.println("    <none>");
                AppMethodBeat.o(12295);
                return;
            }
            int i = 0;
            Iterator it = snapshot.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    PreparedStatement preparedStatement = (PreparedStatement) entry.getValue();
                    if (preparedStatement.mInCache) {
                        printer.println("    " + i2 + ": statementPtr=0x" + Long.toHexString(preparedStatement.getPtr()) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.access$1500((String) entry.getKey()) + "\"");
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(12295);
                    return;
                }
            }
        }
    }

    private static native void nativeBindBlob(long j, long j2, int i, byte[] bArr);

    private static native void nativeBindDouble(long j, long j2, int i, double d);

    private static native void nativeBindLong(long j, long j2, int i, long j3);

    private static native void nativeBindNull(long j, long j2, int i);

    private static native void nativeBindString(long j, long j2, int i, String str);

    private static native void nativeCancel(long j);

    private static native void nativeClose(long j);

    private static native void nativeExecute(long j, long j2);

    private static native int nativeExecuteForChangedRowCount(long j, long j2);

    private static native long nativeExecuteForCursorWindow(long j, long j2, long j3, int i, int i2, boolean z);

    private static native long nativeExecuteForLastInsertedRowId(long j, long j2);

    private static native long nativeExecuteForLong(long j, long j2);

    private static native String nativeExecuteForString(long j, long j2);

    private static native void nativeFinalizeStatement(long j, long j2);

    private static native int nativeGetColumnCount(long j, long j2);

    private static native String nativeGetColumnName(long j, long j2, int i);

    private static native int nativeGetDbLookaside(long j);

    private static native int nativeGetParameterCount(long j, long j2);

    private static native boolean nativeIsReadOnly(long j, long j2);

    private native long nativeOpen(String str, int i, String str2);

    private static native long nativePrepareStatement(long j, String str);

    private static native void nativeRegisterCustomFunction(long j, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j, String str);

    private static native void nativeResetCancel(long j, boolean z);

    private static native void nativeResetStatement(long j, long j2, boolean z);

    private static native long nativeSQLiteHandle(long j, boolean z);

    private static native void nativeSetKey(long j, byte[] bArr);

    private static native void nativeSetUpdateNotification(long j, boolean z, boolean z2);

    private static native void nativeSetWalHook(long j);

    private static native long nativeWalCheckpoint(long j, String str);

    static /* synthetic */ void access$1000(SQLiteConnection sQLiteConnection, PreparedStatement preparedStatement, boolean z) {
        AppMethodBeat.i(12351);
        sQLiteConnection.resetStatement(preparedStatement, z);
        AppMethodBeat.o(12351);
    }

    static /* synthetic */ void access$1100(SQLiteConnection sQLiteConnection, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12352);
        sQLiteConnection.attachCancellationSignal(cancellationSignal);
        AppMethodBeat.o(12352);
    }

    static /* synthetic */ void access$1200(SQLiteConnection sQLiteConnection, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12353);
        sQLiteConnection.detachCancellationSignal(cancellationSignal);
        AppMethodBeat.o(12353);
    }

    static /* synthetic */ void access$1400(SQLiteConnection sQLiteConnection, PreparedStatement preparedStatement) {
        AppMethodBeat.i(12354);
        sQLiteConnection.finalizePreparedStatement(preparedStatement);
        AppMethodBeat.o(12354);
    }

    static /* synthetic */ String access$1500(String str) {
        AppMethodBeat.i(12355);
        String trimSqlForDisplay = trimSqlForDisplay(str);
        AppMethodBeat.o(12355);
        return trimSqlForDisplay;
    }

    static /* synthetic */ void access$900(SQLiteConnection sQLiteConnection, PreparedStatement preparedStatement, Object[] objArr) {
        AppMethodBeat.i(12350);
        sQLiteConnection.bindArguments(preparedStatement, objArr);
        AppMethodBeat.o(12350);
    }

    static {
        AppMethodBeat.i(12356);
        AppMethodBeat.o(12356);
    }

    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        SQLiteCipherSpec sQLiteCipherSpec2 = null;
        AppMethodBeat.i(12297);
        this.mPassword = bArr;
        if (sQLiteCipherSpec != null) {
            sQLiteCipherSpec2 = new SQLiteCipherSpec(sQLiteCipherSpec);
        }
        this.mCipher = sQLiteCipherSpec2;
        this.mPool = sQLiteConnectionPool;
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConnectionId = i;
        this.mIsPrimaryConnection = z;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) != 0;
        this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
        AppMethodBeat.o(12297);
    }

    /* Access modifiers changed, original: final */
    public final long getNativeHandle(String str) {
        AppMethodBeat.i(12298);
        if (this.mConnectionPtr == 0) {
            AppMethodBeat.o(12298);
            return 0;
        }
        if (str != null && this.mNativeOperation == null) {
            this.mNativeOperation = this.mRecentOperations.beginOperation(str, null, null);
            this.mNativeOperation.mType = 99;
        }
        this.mNativeHandleCount++;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.mConnectionPtr, true);
        AppMethodBeat.o(12298);
        return nativeSQLiteHandle;
    }

    /* Access modifiers changed, original: final */
    public final void endNativeHandle(Exception exception) {
        AppMethodBeat.i(12299);
        int i = this.mNativeHandleCount - 1;
        this.mNativeHandleCount = i;
        if (i == 0 && this.mNativeOperation != null) {
            nativeSQLiteHandle(this.mConnectionPtr, false);
            if (exception == null) {
                this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
            } else {
                this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, exception);
            }
            this.mNativeOperation = null;
        }
        AppMethodBeat.o(12299);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(12300);
        try {
            if (!(this.mPool == null || this.mConnectionPtr == 0)) {
                this.mPool.onConnectionLeaked();
            }
            dispose(true);
        } finally {
            super.finalize();
            AppMethodBeat.o(12300);
        }
    }

    static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        AppMethodBeat.i(12301);
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i, z, bArr, sQLiteCipherSpec);
        try {
            sQLiteConnection.open();
            AppMethodBeat.o(12301);
            return sQLiteConnection;
        } catch (SQLiteException e) {
            SQLiteDebug.collectLastIOTraceStats(sQLiteConnection);
            sQLiteConnection.dispose(false);
            AppMethodBeat.o(12301);
            throw e;
        }
    }

    /* Access modifiers changed, original: final */
    public final void close() {
        AppMethodBeat.i(12302);
        dispose(false);
        AppMethodBeat.o(12302);
    }

    private void open() {
        AppMethodBeat.i(12303);
        this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.vfsName);
        if (this.mPassword != null && this.mPassword.length == 0) {
            this.mPassword = null;
        }
        if (this.mPassword != null) {
            nativeSetKey(this.mConnectionPtr, this.mPassword);
            setCipherSpec();
        }
        setPageSize();
        setReadOnlyFromConfiguration();
        setForeignKeyModeFromConfiguration();
        setWalModeFromConfiguration();
        setSyncModeFromConfiguration();
        setJournalSizeLimit();
        setCheckpointStrategy();
        setLocaleFromConfiguration();
        long j = WCDBInitializationProbe.apiEnv;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.mConnectionPtr, true);
        try {
            Iterator it = this.mConfiguration.extensions.iterator();
            while (it.hasNext()) {
                ((SQLiteExtension) it.next()).initialize(nativeSQLiteHandle, j);
            }
            nativeSQLiteHandle(this.mConnectionPtr, false);
            setUpdateNotificationFromConfiguration();
            AppMethodBeat.o(12303);
        } catch (Throwable th) {
            nativeSQLiteHandle(this.mConnectionPtr, false);
            AppMethodBeat.o(12303);
        }
    }

    private void dispose(boolean z) {
        AppMethodBeat.i(12304);
        if (this.mConnectionPtr != 0) {
            int i = this.mRecentOperations.beginOperation("close", null, null).mCookie;
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0;
            } finally {
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12304);
            }
        } else {
            AppMethodBeat.o(12304);
        }
    }

    private void setPageSize() {
        AppMethodBeat.i(12305);
        if (!this.mConfiguration.isInMemoryDb()) {
            String str;
            long j;
            if (this.mPassword != null) {
                str = "PRAGMA cipher_page_size";
                j = (this.mCipher == null || this.mCipher.pageSize <= 0) ? (long) SQLiteGlobal.defaultPageSize : (long) this.mCipher.pageSize;
            } else {
                str = "PRAGMA page_size";
                j = (long) SQLiteGlobal.defaultPageSize;
            }
            if (executeForLong(str, null, null) != j) {
                execute(str + "=" + j, null, null);
            }
        }
        AppMethodBeat.o(12305);
    }

    private void setCipherSpec() {
        AppMethodBeat.i(12306);
        if (this.mCipher != null) {
            if (this.mCipher.kdfIteration != 0) {
                execute("PRAGMA kdf_iter=" + this.mCipher.kdfIteration, null, null);
            }
            execute("PRAGMA cipher_use_hmac=" + this.mCipher.hmacEnabled, null, null);
            if (this.mCipher.hmacAlgorithm != -1) {
                execute("PRAGMA cipher_hmac_algorithm=" + HMAC_ALGO_MAPPING[this.mCipher.hmacAlgorithm], null, null);
            }
            if (this.mCipher.kdfAlgorithm != -1) {
                execute("PRAGMA cipher_kdf_algorithm=" + PBKDF2_ALGO_MAPPING[this.mCipher.kdfAlgorithm], null, null);
            }
        }
        AppMethodBeat.o(12306);
    }

    private void notifyCheckpoint(String str, int i) {
        AppMethodBeat.i(12307);
        this.mPool.notifyCheckpoint(str, i);
        AppMethodBeat.o(12307);
    }

    private void setCheckpointStrategy() {
        AppMethodBeat.i(12308);
        if (!(this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection)) {
            if (this.mConfiguration.customWALHookEnabled) {
                nativeSetWalHook(this.mConnectionPtr);
                AppMethodBeat.o(12308);
                return;
            } else if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != 100) {
                executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
            }
        }
        AppMethodBeat.o(12308);
    }

    private void setJournalSizeLimit() {
        AppMethodBeat.i(12309);
        if (!(this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection || executeForLong("PRAGMA journal_size_limit", null, null) == i.ACTION_MINI_PROGRAM_LAUNCH)) {
            executeForLong("PRAGMA journal_size_limit=524288", null, null);
        }
        AppMethodBeat.o(12309);
    }

    private void setForeignKeyModeFromConfiguration() {
        AppMethodBeat.i(12310);
        if (!this.mIsReadOnlyConnection) {
            long j = this.mConfiguration.foreignKeyConstraintsEnabled ? 1 : 0;
            if (executeForLong("PRAGMA foreign_keys", null, null) != j) {
                execute("PRAGMA foreign_keys=".concat(String.valueOf(j)), null, null);
            }
        }
        AppMethodBeat.o(12310);
    }

    private void setWalModeFromConfiguration() {
        AppMethodBeat.i(12311);
        if (!(this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection)) {
            String str;
            if ((this.mConfiguration.openFlags & 536870912) != 0) {
                str = "WAL";
            } else {
                str = SQLiteGlobal.defaultJournalMode;
            }
            setJournalMode(str);
        }
        AppMethodBeat.o(12311);
    }

    private void setSyncModeFromConfiguration() {
        AppMethodBeat.i(12312);
        execute("PRAGMA synchronous=".concat(String.valueOf(this.mConfiguration.synchronousMode)), null, null);
        AppMethodBeat.o(12312);
    }

    private void setJournalMode(String str) {
        AppMethodBeat.i(12313);
        String executeForString = executeForString("PRAGMA journal_mode", null, null);
        if (!executeForString.equalsIgnoreCase(str)) {
            try {
                if (executeForString("PRAGMA journal_mode=".concat(String.valueOf(str)), null, null).equalsIgnoreCase(str)) {
                    AppMethodBeat.o(12313);
                    return;
                }
            } catch (SQLiteDatabaseLockedException e) {
            }
            Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + executeForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        }
        AppMethodBeat.o(12313);
    }

    private void setLocaleFromConfiguration() {
        AppMethodBeat.i(12314);
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        sQLiteDatabaseConfiguration.openFlags |= 16;
        if ((this.mConfiguration.openFlags & 16) != 0) {
            AppMethodBeat.o(12314);
            return;
        }
        String locale = this.mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(this.mConnectionPtr, locale);
        if (this.mIsReadOnlyConnection) {
            AppMethodBeat.o(12314);
            return;
        }
        try {
            execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
            String executeForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
            if (executeForString == null || !executeForString.equals(locale)) {
                execute("BEGIN", null, null);
                execute("DELETE FROM android_metadata", null, null);
                execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, null);
                execute("REINDEX LOCALIZED", null, null);
                execute("COMMIT", null, null);
                AppMethodBeat.o(12314);
                return;
            }
            AppMethodBeat.o(12314);
        } catch (RuntimeException e) {
            SQLiteException sQLiteException = new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.", e);
            AppMethodBeat.o(12314);
            throw sQLiteException;
        } catch (Throwable th) {
            execute("ROLLBACK", null, null);
            AppMethodBeat.o(12314);
        }
    }

    private void setReadOnlyFromConfiguration() {
        AppMethodBeat.i(12315);
        if (this.mIsReadOnlyConnection) {
            execute("PRAGMA query_only = 1", null, null);
        }
        AppMethodBeat.o(12315);
    }

    private void notifyChange(String str, String str2, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.i(12316);
        this.mPool.notifyChanges(str, str2, jArr, jArr2, jArr3);
        AppMethodBeat.o(12316);
    }

    private void setUpdateNotificationFromConfiguration() {
        AppMethodBeat.i(12317);
        nativeSetUpdateNotification(this.mConnectionPtr, this.mConfiguration.updateNotificationEnabled, this.mConfiguration.updateNotificationRowID);
        AppMethodBeat.o(12317);
    }

    /* Access modifiers changed, original: final */
    public final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z = false;
        AppMethodBeat.i(12318);
        this.mOnlyAllowReadOnlyOperations = false;
        long j = WCDBInitializationProbe.apiEnv;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.mConnectionPtr, true);
        try {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            Iterator it = sQLiteDatabaseConfiguration.extensions.iterator();
            while (it.hasNext()) {
                SQLiteExtension sQLiteExtension = (SQLiteExtension) it.next();
                if (!this.mConfiguration.extensions.contains(sQLiteExtension)) {
                    sQLiteExtension.initialize(nativeSQLiteHandle, j);
                }
            }
            nativeSQLiteHandle(this.mConnectionPtr, false);
            boolean z6 = ((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 536870912) != 0;
            if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (sQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (sQLiteDatabaseConfiguration.customWALHookEnabled != this.mConfiguration.customWALHookEnabled) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (sQLiteDatabaseConfiguration.synchronousMode != this.mConfiguration.synchronousMode) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!(sQLiteDatabaseConfiguration.updateNotificationEnabled == this.mConfiguration.updateNotificationEnabled && sQLiteDatabaseConfiguration.updateNotificationRowID == this.mConfiguration.updateNotificationRowID)) {
                z = true;
            }
            this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
            this.mPreparedStatementCache.resize(sQLiteDatabaseConfiguration.maxSqlCacheSize);
            if (z2) {
                setForeignKeyModeFromConfiguration();
            }
            if (z6) {
                setWalModeFromConfiguration();
            }
            if (z5) {
                setSyncModeFromConfiguration();
            }
            if (z4) {
                setCheckpointStrategy();
            }
            if (z3) {
                setLocaleFromConfiguration();
            }
            if (z) {
                setUpdateNotificationFromConfiguration();
            }
            AppMethodBeat.o(12318);
        } catch (Throwable th) {
            nativeSQLiteHandle(this.mConnectionPtr, false);
            AppMethodBeat.o(12318);
        }
    }

    /* Access modifiers changed, original: final */
    public final void setOnlyAllowReadOnlyOperations(boolean z) {
        this.mOnlyAllowReadOnlyOperations = z;
    }

    /* Access modifiers changed, original: final */
    public final void setAcquisitionState(boolean z, boolean z2) {
        AppMethodBeat.i(12319);
        if (z) {
            this.mAcquiredThread = Thread.currentThread();
            this.mAcquiredTid = Process.myTid();
            if (z2) {
                this.mAcquiredStack = this.mAcquiredThread.getStackTrace();
                this.mAcquiredTimestamp = System.currentTimeMillis();
                AppMethodBeat.o(12319);
                return;
            }
            this.mAcquiredStack = null;
            this.mAcquiredTimestamp = 0;
            AppMethodBeat.o(12319);
            return;
        }
        this.mAcquiredThread = null;
        this.mAcquiredTid = 0;
        this.mAcquiredStack = null;
        this.mAcquiredTimestamp = 0;
        AppMethodBeat.o(12319);
    }

    /* Access modifiers changed, original: final */
    public final boolean isPreparedStatementInCache(String str) {
        AppMethodBeat.i(12320);
        if (this.mPreparedStatementCache.get(str) != null) {
            AppMethodBeat.o(12320);
            return true;
        }
        AppMethodBeat.o(12320);
        return false;
    }

    public final int getConnectionId() {
        return this.mConnectionId;
    }

    public final boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public final void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        AppMethodBeat.i(12321);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12321);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("prepare", str, null);
        int i = beginOperation.mCookie;
        PreparedStatement acquirePreparedStatement;
        try {
            acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            if (sQLiteStatementInfo != null) {
                sQLiteStatementInfo.numParameters = acquirePreparedStatement.mNumParameters;
                sQLiteStatementInfo.readOnly = acquirePreparedStatement.mReadOnly;
                int nativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                if (nativeGetColumnCount == 0) {
                    sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                } else {
                    sQLiteStatementInfo.columnNames = new String[nativeGetColumnCount];
                    for (int i2 = 0; i2 < nativeGetColumnCount; i2++) {
                        sQLiteStatementInfo.columnNames[i2] = nativeGetColumnName(this.mConnectionPtr, acquirePreparedStatement.getPtr(), i2);
                    }
                }
            }
            releasePreparedStatement(acquirePreparedStatement);
            this.mRecentOperations.endOperation(i);
            AppMethodBeat.o(12321);
        } catch (RuntimeException e) {
            try {
                this.mRecentOperations.failOperation(i, e);
                AppMethodBeat.o(12321);
                throw e;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12321);
            }
        } catch (Throwable th2) {
            releasePreparedStatement(acquirePreparedStatement);
            AppMethodBeat.o(12321);
        }
    }

    public final void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12322);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12322);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                nativeExecute(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12322);
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(12322);
            }
        } catch (RuntimeException e) {
            try {
                this.mRecentOperations.failOperation(i, e);
                AppMethodBeat.o(12322);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12322);
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12323);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12323);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLong = nativeExecuteForLong(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12323);
                return nativeExecuteForLong;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(12323);
            }
        } catch (RuntimeException e) {
            try {
                this.mRecentOperations.failOperation(i, e);
                AppMethodBeat.o(12323);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12323);
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12324);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12324);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                String nativeExecuteForString = nativeExecuteForString(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12324);
                return nativeExecuteForString;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(12324);
            }
        } catch (RuntimeException e) {
            try {
                this.mRecentOperations.failOperation(i, e);
                AppMethodBeat.o(12324);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12324);
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12325);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12325);
            throw illegalArgumentException;
        }
        int i = 0;
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                i = nativeExecuteForChangedRowCount(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                if (this.mRecentOperations.endOperationDeferLog(i2)) {
                    this.mRecentOperations.logOperation(i2, "changedRows=".concat(String.valueOf(i)));
                }
                AppMethodBeat.o(12325);
                return i;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(12325);
            }
        } catch (RuntimeException e) {
            try {
                this.mRecentOperations.failOperation(i2, e);
                AppMethodBeat.o(12325);
                throw e;
            } catch (Throwable th2) {
                if (this.mRecentOperations.endOperationDeferLog(i2)) {
                    this.mRecentOperations.logOperation(i2, "changedRows=".concat(String.valueOf(i)));
                }
                AppMethodBeat.o(12325);
            }
        }
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12326);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12326);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLastInsertedRowId = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12326);
                return nativeExecuteForLastInsertedRowId;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(12326);
            }
        } catch (RuntimeException e) {
            try {
                this.mRecentOperations.failOperation(i, e);
                AppMethodBeat.o(12326);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
                AppMethodBeat.o(12326);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x011f A:{Catch:{ all -> 0x016c }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i2, boolean z, CancellationSignal cancellationSignal) {
        Throwable th;
        Exception e;
        AppMethodBeat.i(12327);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(12327);
            throw illegalArgumentException;
        } else if (cursorWindow == null) {
            illegalArgumentException = new IllegalArgumentException("window must not be null.");
            AppMethodBeat.o(12327);
            throw illegalArgumentException;
        } else {
            cursorWindow.acquireReference();
            try {
                Operation beginOperation = this.mRecentOperations.beginOperation("executeForCursorWindow", str, objArr);
                int i3 = beginOperation.mCookie;
                int i4;
                int i5;
                int numRows;
                try {
                    PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                    beginOperation.mType = acquirePreparedStatement.mType;
                    try {
                        throwIfStatementForbidden(acquirePreparedStatement);
                        bindArguments(acquirePreparedStatement, objArr);
                        applyBlockGuardPolicy(acquirePreparedStatement);
                        attachCancellationSignal(cancellationSignal);
                        try {
                            long nativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.mConnectionPtr, acquirePreparedStatement.getPtr(), cursorWindow.mWindowPtr, i, i2, z);
                            i4 = (int) (nativeExecuteForCursorWindow >> 32);
                            i5 = (int) nativeExecuteForCursorWindow;
                            try {
                                numRows = cursorWindow.getNumRows();
                                try {
                                    cursorWindow.setStartPosition(i4);
                                } catch (Throwable th2) {
                                    th = th2;
                                    detachCancellationSignal(cancellationSignal);
                                    AppMethodBeat.o(12327);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                numRows = -1;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            numRows = -1;
                            i5 = -1;
                            i4 = -1;
                            detachCancellationSignal(cancellationSignal);
                            AppMethodBeat.o(12327);
                            throw th;
                        }
                        try {
                            detachCancellationSignal(cancellationSignal);
                            try {
                                releasePreparedStatement(acquirePreparedStatement);
                                if (this.mRecentOperations.endOperationDeferLog(i3)) {
                                    this.mRecentOperations.logOperation(i3, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i4 + ", filledRows=" + numRows + ", countedRows=" + i5);
                                }
                                cursorWindow.releaseReference();
                                AppMethodBeat.o(12327);
                                return i5;
                            } catch (RuntimeException e2) {
                                e = e2;
                                try {
                                    this.mRecentOperations.failOperation(i3, e);
                                    AppMethodBeat.o(12327);
                                    throw e;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (this.mRecentOperations.endOperationDeferLog(i3)) {
                                    }
                                    AppMethodBeat.o(12327);
                                    throw th;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            releasePreparedStatement(acquirePreparedStatement);
                            AppMethodBeat.o(12327);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        numRows = -1;
                        i5 = -1;
                        i4 = -1;
                        releasePreparedStatement(acquirePreparedStatement);
                        AppMethodBeat.o(12327);
                        throw th;
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                    numRows = -1;
                    i5 = -1;
                    i4 = -1;
                    this.mRecentOperations.failOperation(i3, e);
                    AppMethodBeat.o(12327);
                    throw e;
                } catch (Throwable th8) {
                    th = th8;
                    numRows = -1;
                    i5 = -1;
                    i4 = -1;
                    if (this.mRecentOperations.endOperationDeferLog(i3)) {
                        this.mRecentOperations.logOperation(i3, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i4 + ", filledRows=" + numRows + ", countedRows=" + i5);
                    }
                    AppMethodBeat.o(12327);
                    throw th;
                }
            } catch (Throwable th9) {
                cursorWindow.releaseReference();
                AppMethodBeat.o(12327);
            }
        }
    }

    public final Pair<Integer, Integer> walCheckpoint(String str) {
        AppMethodBeat.i(12328);
        if (str == null || str.isEmpty()) {
            str = "main";
        }
        long nativeWalCheckpoint = nativeWalCheckpoint(this.mConnectionPtr, str);
        Pair pair = new Pair(Integer.valueOf((int) (nativeWalCheckpoint >> 32)), Integer.valueOf((int) (nativeWalCheckpoint & 4294967295L)));
        AppMethodBeat.o(12328);
        return pair;
    }

    /* Access modifiers changed, original: final */
    public final PreparedStatement acquirePreparedStatement(String str) {
        AppMethodBeat.i(12329);
        PreparedStatement preparedStatement = (PreparedStatement) this.mPreparedStatementCache.get(str);
        boolean z;
        long nativePrepareStatement;
        int nativeGetParameterCount;
        int sqlStatementType;
        if (preparedStatement == null) {
            z = false;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            sqlStatementType = DatabaseUtils.getSqlStatementType(str);
            preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
            this.mPreparedStatementCache.put(str, preparedStatement);
            preparedStatement.mInCache = true;
            preparedStatement.mInUse = true;
            AppMethodBeat.o(12329);
        } else if (preparedStatement.mInUse) {
            z = true;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            try {
                nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
                sqlStatementType = DatabaseUtils.getSqlStatementType(str);
                preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
                if (!z && isCacheable(sqlStatementType)) {
                    this.mPreparedStatementCache.put(str, preparedStatement);
                    preparedStatement.mInCache = true;
                }
                preparedStatement.mInUse = true;
                AppMethodBeat.o(12329);
            } catch (RuntimeException e) {
                if (preparedStatement == null || !preparedStatement.mInCache) {
                    nativeFinalizeStatement(this.mConnectionPtr, nativePrepareStatement);
                }
                AppMethodBeat.o(12329);
                throw e;
            }
        } else {
            preparedStatement.mInUse = true;
            AppMethodBeat.o(12329);
        }
        return preparedStatement;
    }

    /* Access modifiers changed, original: final */
    public final void releasePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.i(12330);
        preparedStatement.mInUse = false;
        if (preparedStatement.mInCache) {
            try {
                resetStatement(preparedStatement, true);
                AppMethodBeat.o(12330);
                return;
            } catch (SQLiteException e) {
                this.mPreparedStatementCache.remove(preparedStatement.mSql);
                AppMethodBeat.o(12330);
                return;
            }
        }
        finalizePreparedStatement(preparedStatement);
        AppMethodBeat.o(12330);
    }

    private void finalizePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.i(12331);
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.getPtr());
        recyclePreparedStatement(preparedStatement);
        AppMethodBeat.o(12331);
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12332);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            this.mCancellationSignalAttachCount++;
            if (this.mCancellationSignalAttachCount == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
        AppMethodBeat.o(12332);
    }

    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12333);
        if (cancellationSignal != null) {
            this.mCancellationSignalAttachCount--;
            if (this.mCancellationSignalAttachCount == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
        AppMethodBeat.o(12333);
    }

    public final void onCancel() {
        AppMethodBeat.i(12334);
        nativeCancel(this.mConnectionPtr);
        AppMethodBeat.o(12334);
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        int length;
        AppMethodBeat.i(12335);
        if (objArr != null) {
            length = objArr.length;
        } else {
            length = 0;
        }
        if (length != preparedStatement.mNumParameters) {
            SQLiteBindOrColumnIndexOutOfRangeException sQLiteBindOrColumnIndexOutOfRangeException = new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
            AppMethodBeat.o(12335);
            throw sQLiteBindOrColumnIndexOutOfRangeException;
        } else if (length == 0) {
            AppMethodBeat.o(12335);
        } else {
            long ptr = preparedStatement.getPtr();
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                switch (DatabaseUtils.getTypeOfObject(obj)) {
                    case 0:
                        nativeBindNull(this.mConnectionPtr, ptr, i + 1);
                        break;
                    case 1:
                        nativeBindLong(this.mConnectionPtr, ptr, i + 1, ((Number) obj).longValue());
                        break;
                    case 2:
                        nativeBindDouble(this.mConnectionPtr, ptr, i + 1, ((Number) obj).doubleValue());
                        break;
                    case 4:
                        nativeBindBlob(this.mConnectionPtr, ptr, i + 1, (byte[]) obj);
                        break;
                    default:
                        if (!(obj instanceof Boolean)) {
                            nativeBindString(this.mConnectionPtr, ptr, i + 1, obj.toString());
                            break;
                        } else {
                            nativeBindLong(this.mConnectionPtr, ptr, i + 1, ((Boolean) obj).booleanValue() ? 1 : 0);
                            break;
                        }
                }
            }
            AppMethodBeat.o(12335);
        }
    }

    private void resetStatement(PreparedStatement preparedStatement, boolean z) {
        AppMethodBeat.i(12336);
        nativeResetStatement(this.mConnectionPtr, preparedStatement.getPtr(), z);
        AppMethodBeat.o(12336);
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        AppMethodBeat.i(12337);
        if (!this.mOnlyAllowReadOnlyOperations || preparedStatement.mReadOnly) {
            AppMethodBeat.o(12337);
            return;
        }
        SQLiteException sQLiteException = new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        AppMethodBeat.o(12337);
        throw sQLiteException;
    }

    private static boolean isCacheable(int i) {
        if (i == 2 || i == 1) {
            return true;
        }
        return false;
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
    }

    public final void dump(Printer printer, boolean z) {
        AppMethodBeat.i(12338);
        dumpUnsafe(printer, z);
        AppMethodBeat.o(12338);
    }

    /* Access modifiers changed, original: final */
    public final void dumpUnsafe(Printer printer, boolean z) {
        AppMethodBeat.i(12339);
        printer.println("Connection #" + this.mConnectionId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (z) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        if (this.mAcquiredThread != null) {
            printer.println("  acquiredThread: " + this.mAcquiredThread + " (tid: " + this.mAcquiredTid + ")");
        }
        this.mRecentOperations.dump(printer, z);
        if (z) {
            this.mPreparedStatementCache.dump(printer);
        }
        AppMethodBeat.o(12339);
    }

    /* Access modifiers changed, original: final */
    public final String describeCurrentOperationUnsafe() {
        AppMethodBeat.i(12340);
        String describeCurrentOperation = this.mRecentOperations.describeCurrentOperation();
        AppMethodBeat.o(12340);
        return describeCurrentOperation;
    }

    /* Access modifiers changed, original: final */
    public final TraceInfo<String> traceCurrentOperationUnsafe() {
        AppMethodBeat.i(12341);
        TraceInfo traceCurrentOperation = this.mRecentOperations.traceCurrentOperation();
        AppMethodBeat.o(12341);
        return traceCurrentOperation;
    }

    /* Access modifiers changed, original: final */
    public final TraceInfo<StackTraceElement[]> tracePersistAcquisitionUnsafe() {
        AppMethodBeat.i(12342);
        StackTraceElement[] stackTraceElementArr = this.mAcquiredStack;
        if (stackTraceElementArr == null) {
            AppMethodBeat.o(12342);
            return null;
        }
        TraceInfo<StackTraceElement[]> traceInfo = new TraceInfo(stackTraceElementArr, this.mAcquiredTimestamp, this.mAcquiredTid);
        AppMethodBeat.o(12342);
        return traceInfo;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00de A:{Splitter:B:4:0x0031, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:20:0x00c9, code skipped:
            r6 = r0;
     */
    /* JADX WARNING: Missing block: B:25:0x00df, code skipped:
            r3.close();
            com.tencent.matrix.trace.core.AppMethodBeat.o(12343);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void collectDbStats(ArrayList<DbStats> arrayList) {
        AppMethodBeat.i(12343);
        int nativeGetDbLookaside = nativeGetDbLookaside(this.mConnectionPtr);
        long j = 0;
        long j2 = 0;
        try {
            j = executeForLong("PRAGMA page_count;", null, null);
            j2 = executeForLong("PRAGMA page_size;", null, null);
        } catch (SQLiteException e) {
        }
        arrayList.add(getMainDbStatsUnsafe(nativeGetDbLookaside, j, j2));
        CursorWindow cursorWindow = new CursorWindow("collectDbStats");
        try {
            executeForCursorWindow("PRAGMA database_list;", null, cursorWindow, 0, 0, false, null);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 < cursorWindow.getNumRows()) {
                    String string = cursorWindow.getString(i2, 1);
                    String string2 = cursorWindow.getString(i2, 2);
                    long j3 = 0;
                    long j4 = 0;
                    j3 = executeForLong("PRAGMA " + string + ".page_count;", null, null);
                    j4 = executeForLong("PRAGMA " + string + ".page_size;", null, null);
                    long j5 = j3;
                    String concat = "  (attached) ".concat(String.valueOf(string));
                    if (string2.length() != 0) {
                        concat = concat + ": " + string2;
                    }
                    arrayList.add(new DbStats(concat, j5, j4, 0, 0, 0, 0));
                    i = i2 + 1;
                } else {
                    cursorWindow.close();
                    AppMethodBeat.o(12343);
                    return;
                }
            }
        } catch (SQLiteException e2) {
            cursorWindow.close();
            AppMethodBeat.o(12343);
        } catch (Throwable th) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void collectDbStatsUnsafe(ArrayList<DbStats> arrayList) {
        AppMethodBeat.i(12344);
        arrayList.add(getMainDbStatsUnsafe(0, 0, 0));
        AppMethodBeat.o(12344);
    }

    private DbStats getMainDbStatsUnsafe(int i, long j, long j2) {
        AppMethodBeat.i(12345);
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        DbStats dbStats = new DbStats(str, j, j2, i, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
        AppMethodBeat.o(12345);
        return dbStats;
    }

    public final String toString() {
        AppMethodBeat.i(12346);
        String str = "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
        AppMethodBeat.o(12346);
        return str;
    }

    private PreparedStatement obtainPreparedStatement(String str, long j, int i, int i2, boolean z) {
        AppMethodBeat.i(12347);
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement(this);
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j;
        preparedStatement.mNumParameters = i;
        preparedStatement.mType = i2;
        preparedStatement.mReadOnly = z;
        AppMethodBeat.o(12347);
        return preparedStatement;
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.i(12348);
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
        AppMethodBeat.o(12348);
    }

    private static String trimSqlForDisplay(String str) {
        AppMethodBeat.i(12349);
        String replaceAll = TRIM_SQL_PATTERN.matcher(str).replaceAll(" ");
        AppMethodBeat.o(12349);
        return replaceAll;
    }
}
