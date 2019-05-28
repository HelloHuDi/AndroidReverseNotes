package com.tencent.wcdb.database;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDebug.DbStats;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.tencent.wcdb.support.PrefixPrinter;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public final class SQLiteConnectionPool implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteConnectionPool.class.desiredAssertionStatus());
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 3000;
    private static final int OPEN_FLAG_REOPEN_MASK = 268435473;
    private static final String TAG = "WCDB.SQLiteConnectionPool";
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections = new WeakHashMap();
    private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections = new ArrayList();
    private SQLiteConnection mAvailablePrimaryConnection;
    private volatile SQLiteChangeListener mChangeListener;
    private volatile SQLiteCheckpointListener mCheckpointListener;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private final WeakReference<SQLiteDatabase> mDB;
    private boolean mIsOpen;
    private final Object mLock = new Object();
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;
    private byte[] mPassword;
    private volatile SQLiteTrace mTraceCallback;

    enum AcquiredConnectionStatus {
        NORMAL,
        RECONFIGURE,
        DISCARD;

        static {
            AppMethodBeat.o(12360);
        }
    }

    static class ConnectionPoolBusyInfo {
        int activeConnections;
        ArrayList<String> activeOperationDescriptions;
        ArrayList<TraceInfo<String>> activeSql;
        ArrayList<TraceInfo<StackTraceElement[]>> activeTransactions;
        int availableConnections;
        int idleConnections;
        String label;

        private ConnectionPoolBusyInfo() {
            AppMethodBeat.i(12361);
            this.activeOperationDescriptions = new ArrayList();
            this.activeSql = new ArrayList();
            this.activeTransactions = new ArrayList();
            AppMethodBeat.o(12361);
        }

        /* synthetic */ ConnectionPoolBusyInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static final class ConnectionWaiter {
        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }

        /* synthetic */ ConnectionWaiter(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        AppMethodBeat.i(12404);
        AppMethodBeat.o(12404);
    }

    static /* synthetic */ void access$100(SQLiteConnectionPool sQLiteConnectionPool, ConnectionWaiter connectionWaiter) {
        AppMethodBeat.i(12403);
        sQLiteConnectionPool.cancelConnectionWaiterLocked(connectionWaiter);
        AppMethodBeat.o(12403);
    }

    private SQLiteConnectionPool(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i) {
        AppMethodBeat.i(12362);
        this.mDB = new WeakReference(sQLiteDatabase);
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(i);
        AppMethodBeat.o(12362);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(12363);
        try {
            dispose(true);
        } finally {
            super.finalize();
            AppMethodBeat.o(12363);
        }
    }

    public static SQLiteConnectionPool open(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        AppMethodBeat.i(12364);
        SQLiteConnectionPool open = open(sQLiteDatabase, sQLiteDatabaseConfiguration, bArr, sQLiteCipherSpec, 1);
        AppMethodBeat.o(12364);
        return open;
    }

    public static SQLiteConnectionPool open(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i) {
        AppMethodBeat.i(12365);
        if (sQLiteDatabaseConfiguration == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("configuration must not be null.");
            AppMethodBeat.o(12365);
            throw illegalArgumentException;
        }
        SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabase, sQLiteDatabaseConfiguration, i);
        sQLiteConnectionPool.mPassword = bArr;
        sQLiteConnectionPool.mCipher = sQLiteCipherSpec == null ? null : new SQLiteCipherSpec(sQLiteCipherSpec);
        sQLiteConnectionPool.open();
        AppMethodBeat.o(12365);
        return sQLiteConnectionPool;
    }

    private void open() {
        AppMethodBeat.i(12366);
        this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
        this.mIsOpen = true;
        AppMethodBeat.o(12366);
    }

    public final void close() {
        AppMethodBeat.i(12367);
        dispose(false);
        AppMethodBeat.o(12367);
    }

    private void dispose(boolean z) {
        AppMethodBeat.i(12368);
        if (z) {
            AppMethodBeat.o(12368);
            return;
        }
        synchronized (this.mLock) {
            try {
                throwIfClosedLocked();
                this.mIsOpen = false;
                closeAvailableConnectionsAndLogExceptionsLocked();
                int size = this.mAcquiredConnections.size();
                if (size != 0) {
                    Log.i(TAG, "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                }
                wakeConnectionWaitersLocked();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12368);
            }
        }
    }

    public final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        Object obj = 1;
        AppMethodBeat.i(12369);
        if (sQLiteDatabaseConfiguration == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("configuration must not be null.");
            AppMethodBeat.o(12369);
            throw illegalArgumentException;
        }
        synchronized (this.mLock) {
            try {
                throwIfClosedLocked();
                Object obj2 = ((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 536870912) != 0 ? 1 : null;
                if (obj2 != null) {
                    if (this.mAcquiredConnections.isEmpty()) {
                        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
                    } else {
                        obj = new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                        throw obj;
                    }
                }
                if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) {
                    obj = null;
                }
                if (obj == null || this.mAcquiredConnections.isEmpty()) {
                    if (((this.mConfiguration.openFlags ^ sQLiteDatabaseConfiguration.openFlags) & OPEN_FLAG_REOPEN_MASK) == 0 && DatabaseUtils.objectEquals(this.mConfiguration.vfsName, sQLiteDatabaseConfiguration.vfsName) && sQLiteDatabaseConfiguration.extensions.containsAll(this.mConfiguration.extensions)) {
                        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                        setMaxConnectionPoolSizeLocked(0);
                        closeExcessConnectionsAndLogExceptionsLocked();
                        reconfigureAllConnectionsLocked();
                    } else {
                        if (obj2 != null) {
                            closeAvailableConnectionsAndLogExceptionsLocked();
                        }
                        SQLiteConnection openConnectionLocked = openConnectionLocked(sQLiteDatabaseConfiguration, true);
                        closeAvailableConnectionsAndLogExceptionsLocked();
                        discardAcquiredConnectionsLocked();
                        this.mAvailablePrimaryConnection = openConnectionLocked;
                        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                        setMaxConnectionPoolSizeLocked(0);
                    }
                    wakeConnectionWaitersLocked();
                } else {
                    IllegalStateException illegalStateException = new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                    AppMethodBeat.o(12369);
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.o(12369);
            }
        }
        AppMethodBeat.o(12369);
    }

    public final SQLiteConnection acquireConnection(String str, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(12370);
        long uptimeMillis = SystemClock.uptimeMillis();
        SQLiteConnection waitForConnection = waitForConnection(str, i, cancellationSignal);
        SQLiteTrace sQLiteTrace = this.mTraceCallback;
        if (sQLiteTrace != null) {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDB.get();
            if (sQLiteDatabase != null) {
                sQLiteTrace.onConnectionObtained(sQLiteDatabase, str, uptimeMillis2, (i & 2) != 0);
            }
        }
        AppMethodBeat.o(12370);
        return waitForConnection;
    }

    public final void releaseConnection(SQLiteConnection sQLiteConnection) {
        AppMethodBeat.i(12371);
        synchronized (this.mLock) {
            try {
                AcquiredConnectionStatus acquiredConnectionStatus = (AcquiredConnectionStatus) this.mAcquiredConnections.remove(sQLiteConnection);
                if (acquiredConnectionStatus == null) {
                    Object illegalStateException = new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                    throw illegalStateException;
                }
                if (!this.mIsOpen) {
                    closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                } else if (sQLiteConnection.isPrimaryConnection()) {
                    if (recycleConnectionLocked(sQLiteConnection, acquiredConnectionStatus)) {
                        if ($assertionsDisabled || this.mAvailablePrimaryConnection == null) {
                            this.mAvailablePrimaryConnection = sQLiteConnection;
                        } else {
                            AssertionError assertionError = new AssertionError();
                            AppMethodBeat.o(12371);
                            throw assertionError;
                        }
                    }
                    wakeConnectionWaitersLocked();
                } else if (this.mAvailableNonPrimaryConnections.size() >= this.mMaxConnectionPoolSize - 1) {
                    closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                } else {
                    if (recycleConnectionLocked(sQLiteConnection, acquiredConnectionStatus)) {
                        this.mAvailableNonPrimaryConnections.add(sQLiteConnection);
                    }
                    wakeConnectionWaitersLocked();
                }
            } finally {
                AppMethodBeat.o(12371);
            }
        }
        AppMethodBeat.o(12371);
    }

    private boolean recycleConnectionLocked(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        AppMethodBeat.i(12372);
        if (acquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE) {
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e) {
                Log.e(TAG, "Failed to reconfigure released connection, closing it: ".concat(String.valueOf(sQLiteConnection)), e);
                acquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
            }
        }
        if (acquiredConnectionStatus == AcquiredConnectionStatus.DISCARD) {
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            AppMethodBeat.o(12372);
            return false;
        }
        AppMethodBeat.o(12372);
        return true;
    }

    public final boolean shouldYieldConnection(SQLiteConnection sQLiteConnection, int i) {
        boolean isSessionBlockingImportantConnectionWaitersLocked;
        AppMethodBeat.i(12373);
        synchronized (this.mLock) {
            try {
                if (!this.mAcquiredConnections.containsKey(sQLiteConnection)) {
                    Object illegalStateException = new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                    throw illegalStateException;
                } else if (this.mIsOpen) {
                    isSessionBlockingImportantConnectionWaitersLocked = isSessionBlockingImportantConnectionWaitersLocked(sQLiteConnection.isPrimaryConnection(), i);
                    AppMethodBeat.o(12373);
                } else {
                    isSessionBlockingImportantConnectionWaitersLocked = false;
                    AppMethodBeat.o(12373);
                }
            } finally {
                AppMethodBeat.o(12373);
            }
        }
        return isSessionBlockingImportantConnectionWaitersLocked;
    }

    public final void collectDbStats(ArrayList<DbStats> arrayList) {
        AppMethodBeat.i(12374);
        synchronized (this.mLock) {
            try {
                if (this.mAvailablePrimaryConnection != null) {
                    this.mAvailablePrimaryConnection.collectDbStats(arrayList);
                }
                Iterator it = this.mAvailableNonPrimaryConnections.iterator();
                while (it.hasNext()) {
                    ((SQLiteConnection) it.next()).collectDbStats(arrayList);
                }
                for (SQLiteConnection collectDbStatsUnsafe : this.mAcquiredConnections.keySet()) {
                    collectDbStatsUnsafe.collectDbStatsUnsafe(arrayList);
                }
            } finally {
                AppMethodBeat.o(12374);
            }
        }
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, boolean z) {
        AppMethodBeat.i(12375);
        int i = this.mNextConnectionId;
        this.mNextConnectionId = i + 1;
        SQLiteConnection open = SQLiteConnection.open(this, sQLiteDatabaseConfiguration, i, z, this.mPassword, this.mCipher);
        AppMethodBeat.o(12375);
        return open;
    }

    /* Access modifiers changed, original: final */
    public final void onConnectionLeaked() {
        AppMethodBeat.i(12376);
        Log.w(TAG, "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.mConnectionLeaked.set(true);
        AppMethodBeat.o(12376);
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        AppMethodBeat.i(12377);
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        if (this.mAvailablePrimaryConnection != null) {
            closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
            this.mAvailablePrimaryConnection = null;
        }
        AppMethodBeat.o(12377);
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        AppMethodBeat.i(12378);
        int size = this.mAvailableNonPrimaryConnections.size();
        for (int i = 0; i < size; i++) {
            closeConnectionAndLogExceptionsLocked((SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i));
        }
        this.mAvailableNonPrimaryConnections.clear();
        AppMethodBeat.o(12378);
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        AppMethodBeat.i(12379);
        int size = this.mAvailableNonPrimaryConnections.size();
        while (true) {
            int i = size - 1;
            if (size > this.mMaxConnectionPoolSize - 1) {
                closeConnectionAndLogExceptionsLocked((SQLiteConnection) this.mAvailableNonPrimaryConnections.remove(i));
                size = i;
            } else {
                AppMethodBeat.o(12379);
                return;
            }
        }
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection sQLiteConnection) {
        AppMethodBeat.i(12380);
        try {
            sQLiteConnection.close();
            AppMethodBeat.o(12380);
        } catch (RuntimeException e) {
            Log.e(TAG, "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection + e.getMessage());
            AppMethodBeat.o(12380);
        }
    }

    private void discardAcquiredConnectionsLocked() {
        AppMethodBeat.i(12381);
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
        AppMethodBeat.o(12381);
    }

    private void reconfigureAllConnectionsLocked() {
        AppMethodBeat.i(12382);
        if (this.mAvailablePrimaryConnection != null) {
            try {
                this.mAvailablePrimaryConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e) {
                Log.e(TAG, "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, e);
                closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
                this.mAvailablePrimaryConnection = null;
            }
        }
        int size = this.mAvailableNonPrimaryConnections.size();
        int i = 0;
        while (i < size) {
            int i2;
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i);
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
                i2 = i;
            } catch (RuntimeException e2) {
                Log.e(TAG, "Failed to reconfigure available non-primary connection, closing it: ".concat(String.valueOf(sQLiteConnection)), e2);
                closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                i2 = i - 1;
                this.mAvailableNonPrimaryConnections.remove(i);
                size--;
            }
            i = i2 + 1;
        }
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
        AppMethodBeat.o(12382);
    }

    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus acquiredConnectionStatus) {
        AppMethodBeat.i(12383);
        if (!this.mAcquiredConnections.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.mAcquiredConnections.size());
            for (Entry entry : this.mAcquiredConnections.entrySet()) {
                AcquiredConnectionStatus acquiredConnectionStatus2 = (AcquiredConnectionStatus) entry.getValue();
                if (!(acquiredConnectionStatus == acquiredConnectionStatus2 || acquiredConnectionStatus2 == AcquiredConnectionStatus.DISCARD)) {
                    arrayList.add(entry.getKey());
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mAcquiredConnections.put(arrayList.get(i), acquiredConnectionStatus);
            }
        }
        AppMethodBeat.o(12383);
    }

    /* JADX WARNING: Missing block: B:89:0x00ff, code skipped:
            if (r4 == null) goto L_0x0127;
     */
    /* JADX WARNING: Missing block: B:91:?, code skipped:
            r5 = r16 - r14.mStartTime;
            logConnectionPoolBusy(r4, r5, r20);
            r3 = (com.tencent.wcdb.database.SQLiteDatabase) r18.mDB.get();
            r2 = r18.mTraceCallback;
     */
    /* JADX WARNING: Missing block: B:92:0x011a, code skipped:
            if (r3 == null) goto L_0x0127;
     */
    /* JADX WARNING: Missing block: B:93:0x011c, code skipped:
            if (r2 == null) goto L_0x0127;
     */
    /* JADX WARNING: Missing block: B:94:0x011e, code skipped:
            r2.onConnectionPoolBusy(r3, r19, r5, r7, r4.activeSql, r4.activeTransactions);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SQLiteConnection waitForConnection(String str, int i, CancellationSignal cancellationSignal) {
        SQLiteConnection sQLiteConnection;
        AppMethodBeat.i(12384);
        boolean z = (i & 2) != 0;
        synchronized (this.mLock) {
            try {
                throwIfClosedLocked();
                if (cancellationSignal != null) {
                    cancellationSignal.throwIfCanceled();
                }
                sQLiteConnection = null;
                if (!z) {
                    sQLiteConnection = tryAcquireNonPrimaryConnectionLocked(str, i);
                }
                if (sQLiteConnection == null) {
                    sQLiteConnection = tryAcquirePrimaryConnectionLocked(i);
                }
                if (sQLiteConnection != null) {
                    AppMethodBeat.o(12384);
                } else {
                    int priority = getPriority(i);
                    final ConnectionWaiter obtainConnectionWaiterLocked = obtainConnectionWaiterLocked(Thread.currentThread(), SystemClock.uptimeMillis(), priority, z, str, i);
                    ConnectionWaiter connectionWaiter = null;
                    for (ConnectionWaiter connectionWaiter2 = this.mConnectionWaiterQueue; connectionWaiter2 != null; connectionWaiter2 = connectionWaiter2.mNext) {
                        if (priority > connectionWaiter2.mPriority) {
                            obtainConnectionWaiterLocked.mNext = connectionWaiter2;
                            break;
                        }
                        connectionWaiter = connectionWaiter2;
                    }
                    if (connectionWaiter != null) {
                        connectionWaiter.mNext = obtainConnectionWaiterLocked;
                    } else {
                        this.mConnectionWaiterQueue = obtainConnectionWaiterLocked;
                    }
                    final int i2 = obtainConnectionWaiterLocked.mNonce;
                    if (cancellationSignal != null) {
                        cancellationSignal.setOnCancelListener(new OnCancelListener() {
                            public void onCancel() {
                                AppMethodBeat.i(12357);
                                synchronized (SQLiteConnectionPool.this.mLock) {
                                    try {
                                        if (obtainConnectionWaiterLocked.mNonce == i2) {
                                            SQLiteConnectionPool.access$100(SQLiteConnectionPool.this, obtainConnectionWaiterLocked);
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(12357);
                                    }
                                }
                            }
                        });
                    }
                    long j = CONNECTION_POOL_BUSY_MILLIS;
                    try {
                        RuntimeException runtimeException;
                        long j2 = obtainConnectionWaiterLocked.mStartTime + CONNECTION_POOL_BUSY_MILLIS;
                        while (true) {
                            long j3;
                            if (this.mConnectionLeaked.compareAndSet(true, false)) {
                                synchronized (this.mLock) {
                                    wakeConnectionWaitersLocked();
                                }
                            }
                            LockSupport.parkNanos(1000000 * j);
                            Thread.interrupted();
                            synchronized (this.mLock) {
                                throwIfClosedLocked();
                                sQLiteConnection = obtainConnectionWaiterLocked.mAssignedConnection;
                                runtimeException = obtainConnectionWaiterLocked.mException;
                                if (sQLiteConnection == null && runtimeException == null) {
                                    long uptimeMillis = SystemClock.uptimeMillis();
                                    ConnectionPoolBusyInfo connectionPoolBusyInfo;
                                    if (uptimeMillis < j2) {
                                        j = uptimeMillis - j2;
                                        connectionPoolBusyInfo = null;
                                        j3 = j2;
                                    } else {
                                        ConnectionPoolBusyInfo gatherConnectionPoolBusyInfoLocked = gatherConnectionPoolBusyInfoLocked();
                                        j = CONNECTION_POOL_BUSY_MILLIS;
                                        connectionPoolBusyInfo = gatherConnectionPoolBusyInfoLocked;
                                        j3 = CONNECTION_POOL_BUSY_MILLIS + uptimeMillis;
                                    }
                                } else {
                                    recycleConnectionWaiterLocked(obtainConnectionWaiterLocked);
                                }
                            }
                            j2 = j3;
                        }
                        recycleConnectionWaiterLocked(obtainConnectionWaiterLocked);
                        if (sQLiteConnection != null) {
                            if (cancellationSignal != null) {
                                cancellationSignal.setOnCancelListener(null);
                            }
                            AppMethodBeat.o(12384);
                        } else {
                            AppMethodBeat.o(12384);
                            throw runtimeException;
                        }
                    } catch (Throwable th) {
                        if (cancellationSignal != null) {
                            cancellationSignal.setOnCancelListener(null);
                        }
                        AppMethodBeat.o(12384);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(12384);
                throw th2;
            }
        }
        return sQLiteConnection;
    }

    private void cancelConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        AppMethodBeat.i(12385);
        if (connectionWaiter.mAssignedConnection == null && connectionWaiter.mException == null) {
            ConnectionWaiter connectionWaiter2 = this.mConnectionWaiterQueue;
            ConnectionWaiter connectionWaiter3 = null;
            while (connectionWaiter2 != connectionWaiter) {
                if ($assertionsDisabled || connectionWaiter2 != null) {
                    connectionWaiter3 = connectionWaiter2;
                    connectionWaiter2 = connectionWaiter2.mNext;
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(12385);
                    throw assertionError;
                }
            }
            if (connectionWaiter3 != null) {
                connectionWaiter3.mNext = connectionWaiter.mNext;
            } else {
                this.mConnectionWaiterQueue = connectionWaiter.mNext;
            }
            connectionWaiter.mException = new OperationCanceledException();
            LockSupport.unpark(connectionWaiter.mThread);
            wakeConnectionWaitersLocked();
            AppMethodBeat.o(12385);
            return;
        }
        AppMethodBeat.o(12385);
    }

    private void logConnectionPoolBusy(ConnectionPoolBusyInfo connectionPoolBusyInfo, long j, int i) {
        AppMethodBeat.i(12386);
        StringBuilder stringBuilder = new StringBuilder();
        if (j != 0) {
            Thread currentThread = Thread.currentThread();
            stringBuilder.append("The connection pool for database '").append(connectionPoolBusyInfo.label);
            stringBuilder.append("' has been unable to grant a connection to thread ");
            stringBuilder.append(currentThread.getId()).append(" (").append(currentThread.getName()).append(") ");
            stringBuilder.append("with flags 0x").append(Integer.toHexString(i));
            stringBuilder.append(" for ").append(((float) j) * 0.001f).append(" seconds.\n");
        }
        stringBuilder.append("Connections: ").append(connectionPoolBusyInfo.activeConnections).append(" active, ");
        stringBuilder.append(connectionPoolBusyInfo.idleConnections).append(" idle, ");
        stringBuilder.append(connectionPoolBusyInfo.availableConnections).append(" available.\n");
        if (!connectionPoolBusyInfo.activeOperationDescriptions.isEmpty()) {
            stringBuilder.append("\nRequests in progress:\n");
            Iterator it = connectionPoolBusyInfo.activeOperationDescriptions.iterator();
            while (it.hasNext()) {
                stringBuilder.append("  ").append((String) it.next()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        Log.w(TAG, stringBuilder.toString());
        AppMethodBeat.o(12386);
    }

    private ConnectionPoolBusyInfo gatherConnectionPoolBusyInfoLocked() {
        AppMethodBeat.i(12387);
        ConnectionPoolBusyInfo connectionPoolBusyInfo = new ConnectionPoolBusyInfo();
        connectionPoolBusyInfo.activeConnections = 0;
        connectionPoolBusyInfo.idleConnections = 0;
        if (!this.mAcquiredConnections.isEmpty()) {
            for (SQLiteConnection sQLiteConnection : this.mAcquiredConnections.keySet()) {
                TraceInfo tracePersistAcquisitionUnsafe = sQLiteConnection.tracePersistAcquisitionUnsafe();
                if (tracePersistAcquisitionUnsafe != null) {
                    connectionPoolBusyInfo.activeTransactions.add(tracePersistAcquisitionUnsafe);
                }
                tracePersistAcquisitionUnsafe = sQLiteConnection.traceCurrentOperationUnsafe();
                if (tracePersistAcquisitionUnsafe != null) {
                    connectionPoolBusyInfo.activeSql.add(tracePersistAcquisitionUnsafe);
                    String describeCurrentOperationUnsafe = sQLiteConnection.describeCurrentOperationUnsafe();
                    if (describeCurrentOperationUnsafe != null) {
                        connectionPoolBusyInfo.activeOperationDescriptions.add(describeCurrentOperationUnsafe);
                    }
                    connectionPoolBusyInfo.activeConnections++;
                } else {
                    connectionPoolBusyInfo.idleConnections++;
                }
            }
        }
        connectionPoolBusyInfo.availableConnections = this.mAvailableNonPrimaryConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            connectionPoolBusyInfo.availableConnections++;
        }
        AppMethodBeat.o(12387);
        return connectionPoolBusyInfo;
    }

    private void wakeConnectionWaitersLocked() {
        AppMethodBeat.i(12388);
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        Object obj = null;
        Object obj2 = null;
        ConnectionWaiter connectionWaiter2 = null;
        while (connectionWaiter != null) {
            Object obj3;
            if (this.mIsOpen) {
                int obj32;
                try {
                    SQLiteConnection sQLiteConnection;
                    if (connectionWaiter.mWantPrimaryConnection || obj != null) {
                        sQLiteConnection = null;
                    } else {
                        sQLiteConnection = tryAcquireNonPrimaryConnectionLocked(connectionWaiter.mSql, connectionWaiter.mConnectionFlags);
                        if (sQLiteConnection == null) {
                            obj = 1;
                        }
                    }
                    if (sQLiteConnection == null && obj2 == null) {
                        sQLiteConnection = tryAcquirePrimaryConnectionLocked(connectionWaiter.mConnectionFlags);
                        if (sQLiteConnection == null) {
                            obj2 = 1;
                        }
                    }
                    if (sQLiteConnection != null) {
                        connectionWaiter.mAssignedConnection = sQLiteConnection;
                        obj32 = 1;
                    } else if (obj == null || obj2 == null) {
                        obj32 = null;
                    } else {
                        AppMethodBeat.o(12388);
                        return;
                    }
                } catch (RuntimeException e) {
                    connectionWaiter.mException = e;
                    obj32 = 1;
                }
            } else {
                obj32 = 1;
            }
            ConnectionWaiter connectionWaiter3 = connectionWaiter.mNext;
            if (obj32 != null) {
                if (connectionWaiter2 != null) {
                    connectionWaiter2.mNext = connectionWaiter3;
                } else {
                    this.mConnectionWaiterQueue = connectionWaiter3;
                }
                connectionWaiter.mNext = null;
                LockSupport.unpark(connectionWaiter.mThread);
            } else {
                connectionWaiter2 = connectionWaiter;
            }
            connectionWaiter = connectionWaiter3;
        }
        AppMethodBeat.o(12388);
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int i) {
        AppMethodBeat.i(12389);
        SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
        if (sQLiteConnection != null) {
            this.mAvailablePrimaryConnection = null;
            finishAcquireConnectionLocked(sQLiteConnection, i);
            AppMethodBeat.o(12389);
            return sQLiteConnection;
        }
        for (SQLiteConnection sQLiteConnection2 : this.mAcquiredConnections.keySet()) {
            if (sQLiteConnection2.isPrimaryConnection()) {
                AppMethodBeat.o(12389);
                return null;
            }
        }
        sQLiteConnection2 = openConnectionLocked(this.mConfiguration, true);
        finishAcquireConnectionLocked(sQLiteConnection2, i);
        AppMethodBeat.o(12389);
        return sQLiteConnection2;
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String str, int i) {
        SQLiteConnection sQLiteConnection;
        AppMethodBeat.i(12390);
        int size = this.mAvailableNonPrimaryConnections.size();
        if (size > 1 && str != null) {
            for (int i2 = 0; i2 < size; i2++) {
                sQLiteConnection = (SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i2);
                if (sQLiteConnection.isPreparedStatementInCache(str)) {
                    this.mAvailableNonPrimaryConnections.remove(i2);
                    finishAcquireConnectionLocked(sQLiteConnection, i);
                    AppMethodBeat.o(12390);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            sQLiteConnection = (SQLiteConnection) this.mAvailableNonPrimaryConnections.remove(size - 1);
            finishAcquireConnectionLocked(sQLiteConnection, i);
            AppMethodBeat.o(12390);
            return sQLiteConnection;
        }
        int size2 = this.mAcquiredConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            size2++;
        }
        if (size2 >= this.mMaxConnectionPoolSize) {
            AppMethodBeat.o(12390);
            return null;
        }
        sQLiteConnection = openConnectionLocked(this.mConfiguration, false);
        finishAcquireConnectionLocked(sQLiteConnection, i);
        AppMethodBeat.o(12390);
        return sQLiteConnection;
    }

    private void finishAcquireConnectionLocked(SQLiteConnection sQLiteConnection, int i) {
        AppMethodBeat.i(12391);
        try {
            sQLiteConnection.setOnlyAllowReadOnlyOperations((i & 1) != 0);
            this.mAcquiredConnections.put(sQLiteConnection, AcquiredConnectionStatus.NORMAL);
            AppMethodBeat.o(12391);
        } catch (RuntimeException e) {
            Log.e(TAG, "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i);
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            AppMethodBeat.o(12391);
            throw e;
        }
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean z, int i) {
        AppMethodBeat.i(12392);
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        if (connectionWaiter != null) {
            int priority = getPriority(i);
            while (priority <= connectionWaiter.mPriority) {
                if (!z && connectionWaiter.mWantPrimaryConnection) {
                    connectionWaiter = connectionWaiter.mNext;
                    if (connectionWaiter == null) {
                        break;
                    }
                }
                AppMethodBeat.o(12392);
                return true;
            }
        }
        AppMethodBeat.o(12392);
        return false;
    }

    private static int getPriority(int i) {
        return (i & 4) != 0 ? 1 : 0;
    }

    private void setMaxConnectionPoolSizeLocked(int i) {
        AppMethodBeat.i(12393);
        if (i <= 0) {
            if ((this.mConfiguration.openFlags & 536870912) != 0) {
                i = 4;
            } else {
                i = 1;
            }
        }
        this.mMaxConnectionPoolSize = i;
        Log.i(TAG, "Max connection pool size is %d.", Integer.valueOf(this.mMaxConnectionPoolSize));
        AppMethodBeat.o(12393);
    }

    private void throwIfClosedLocked() {
        AppMethodBeat.i(12394);
        if (this.mIsOpen) {
            AppMethodBeat.o(12394);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        AppMethodBeat.o(12394);
        throw illegalStateException;
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread thread, long j, int i, boolean z, String str, int i2) {
        AppMethodBeat.i(12395);
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterPool;
        if (connectionWaiter != null) {
            this.mConnectionWaiterPool = connectionWaiter.mNext;
            connectionWaiter.mNext = null;
        } else {
            connectionWaiter = new ConnectionWaiter();
        }
        connectionWaiter.mThread = thread;
        connectionWaiter.mStartTime = j;
        connectionWaiter.mPriority = i;
        connectionWaiter.mWantPrimaryConnection = z;
        connectionWaiter.mSql = str;
        connectionWaiter.mConnectionFlags = i2;
        AppMethodBeat.o(12395);
        return connectionWaiter;
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        connectionWaiter.mNext = this.mConnectionWaiterPool;
        connectionWaiter.mThread = null;
        connectionWaiter.mSql = null;
        connectionWaiter.mAssignedConnection = null;
        connectionWaiter.mException = null;
        connectionWaiter.mNonce++;
        this.mConnectionWaiterPool = connectionWaiter;
    }

    /* Access modifiers changed, original: final */
    public final SQLiteChangeListener getChangeListener() {
        return this.mChangeListener;
    }

    /* Access modifiers changed, original: final */
    public final void setChangeListener(SQLiteChangeListener sQLiteChangeListener, boolean z) {
        AppMethodBeat.i(12396);
        boolean z2 = sQLiteChangeListener != null;
        if (!z2) {
            z = false;
        }
        synchronized (this.mLock) {
            try {
                if (!(this.mConfiguration.updateNotificationEnabled == z2 && this.mConfiguration.updateNotificationRowID == z)) {
                    this.mConfiguration.updateNotificationEnabled = z2;
                    this.mConfiguration.updateNotificationRowID = z;
                    closeExcessConnectionsAndLogExceptionsLocked();
                    reconfigureAllConnectionsLocked();
                }
                this.mChangeListener = sQLiteChangeListener;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12396);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void notifyChanges(String str, String str2, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.i(12397);
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDB.get();
        SQLiteChangeListener sQLiteChangeListener = this.mChangeListener;
        if (sQLiteChangeListener == null || sQLiteDatabase == null) {
            AppMethodBeat.o(12397);
            return;
        }
        sQLiteChangeListener.onChange(sQLiteDatabase, str, str2, jArr, jArr2, jArr3);
        AppMethodBeat.o(12397);
    }

    /* Access modifiers changed, original: final */
    public final SQLiteTrace getTraceCallback() {
        return this.mTraceCallback;
    }

    /* Access modifiers changed, original: final */
    public final void setTraceCallback(SQLiteTrace sQLiteTrace) {
        this.mTraceCallback = sQLiteTrace;
    }

    /* Access modifiers changed, original: final */
    public final void traceExecute(String str, int i, long j) {
        AppMethodBeat.i(12398);
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDB.get();
        SQLiteTrace sQLiteTrace = this.mTraceCallback;
        if (sQLiteTrace == null || sQLiteDatabase == null) {
            AppMethodBeat.o(12398);
            return;
        }
        sQLiteTrace.onSQLExecuted(sQLiteDatabase, str, i, j);
        AppMethodBeat.o(12398);
    }

    /* Access modifiers changed, original: final */
    public final SQLiteCheckpointListener getCheckpointListener() {
        return this.mCheckpointListener;
    }

    /* Access modifiers changed, original: final */
    public final void setCheckpointListener(SQLiteCheckpointListener sQLiteCheckpointListener) {
        AppMethodBeat.i(12399);
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDB.get();
        if (this.mCheckpointListener != null) {
            this.mCheckpointListener.onDetach(sQLiteDatabase);
        }
        this.mCheckpointListener = sQLiteCheckpointListener;
        if (this.mCheckpointListener != null) {
            this.mCheckpointListener.onAttach(sQLiteDatabase);
        }
        AppMethodBeat.o(12399);
    }

    /* Access modifiers changed, original: final */
    public final void notifyCheckpoint(String str, int i) {
        AppMethodBeat.i(12400);
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDB.get();
        SQLiteCheckpointListener sQLiteCheckpointListener = this.mCheckpointListener;
        if (sQLiteCheckpointListener == null || sQLiteDatabase == null) {
            AppMethodBeat.o(12400);
            return;
        }
        sQLiteCheckpointListener.onWALCommit(sQLiteDatabase, str, i);
        AppMethodBeat.o(12400);
    }

    public final void dump(Printer printer, boolean z) {
        AppMethodBeat.i(12401);
        Printer create = PrefixPrinter.create(printer, "    ");
        synchronized (this.mLock) {
            try {
                printer.println("Connection pool for " + this.mConfiguration.path + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                printer.println("  Open: " + this.mIsOpen);
                printer.println("  Max connections: " + this.mMaxConnectionPoolSize);
                printer.println("  Available primary connection:");
                if (this.mAvailablePrimaryConnection != null) {
                    this.mAvailablePrimaryConnection.dump(create, z);
                } else {
                    create.println("<none>");
                }
                printer.println("  Available non-primary connections:");
                if (this.mAvailableNonPrimaryConnections.isEmpty()) {
                    create.println("<none>");
                } else {
                    int size = this.mAvailableNonPrimaryConnections.size();
                    for (int i = 0; i < size; i++) {
                        ((SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i)).dump(create, z);
                    }
                }
                printer.println("  Acquired connections:");
                if (this.mAcquiredConnections.isEmpty()) {
                    create.println("<none>");
                } else {
                    for (Entry entry : this.mAcquiredConnections.entrySet()) {
                        ((SQLiteConnection) entry.getKey()).dumpUnsafe(create, z);
                        create.println("  Status: " + entry.getValue());
                    }
                }
                printer.println("  Connection waiters:");
                if (this.mConnectionWaiterQueue != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
                    int i2 = 0;
                    while (connectionWaiter != null) {
                        create.println(i2 + ": waited for " + (uptimeMillis - connectionWaiter.mStartTime) + " ms - thread=" + connectionWaiter.mThread + ", priority=" + connectionWaiter.mPriority + ", sql='" + connectionWaiter.mSql + "'");
                        connectionWaiter = connectionWaiter.mNext;
                        i2++;
                    }
                } else {
                    create.println("<none>");
                }
            } finally {
                AppMethodBeat.o(12401);
            }
        }
    }

    public final String toString() {
        AppMethodBeat.i(12402);
        String str = "SQLiteConnectionPool: " + this.mConfiguration.path;
        AppMethodBeat.o(12402);
        return str;
    }
}
