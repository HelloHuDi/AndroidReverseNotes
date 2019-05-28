package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteSession.class.desiredAssertionStatus());
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }
    }

    static {
        AppMethodBeat.m2504i(12628);
        AppMethodBeat.m2505o(12628);
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        AppMethodBeat.m2504i(12601);
        if (sQLiteConnectionPool == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("connectionPool must not be null");
            AppMethodBeat.m2505o(12601);
            throw illegalArgumentException;
        }
        this.mConnectionPool = sQLiteConnectionPool;
        AppMethodBeat.m2505o(12601);
    }

    public final boolean hasTransaction() {
        return this.mTransactionStack != null;
    }

    public final boolean hasNestedTransaction() {
        return (this.mTransactionStack == null || this.mTransactionStack.mParent == null) ? false : true;
    }

    public final boolean hasConnection() {
        return this.mConnection != null;
    }

    public final void beginTransaction(int i, SQLiteTransactionListener sQLiteTransactionListener, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12602);
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i, sQLiteTransactionListener, i2, cancellationSignal);
        AppMethodBeat.m2505o(12602);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void beginTransactionUnchecked(int i, SQLiteTransactionListener sQLiteTransactionListener, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12603);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.mTransactionStack == null) {
            acquireConnection(null, i2, true, cancellationSignal);
        }
        try {
            if (this.mTransactionStack == null) {
                switch (i) {
                    case 1:
                        this.mConnection.execute("BEGIN IMMEDIATE;", null, cancellationSignal);
                    case 2:
                        this.mConnection.execute("BEGIN EXCLUSIVE;", null, cancellationSignal);
                    default:
                        this.mConnection.execute("BEGIN;", null, cancellationSignal);
                }
            }
            if (sQLiteTransactionListener != null) {
                sQLiteTransactionListener.onBegin();
            }
            Transaction obtainTransaction = obtainTransaction(i, sQLiteTransactionListener);
            obtainTransaction.mParent = this.mTransactionStack;
            this.mTransactionStack = obtainTransaction;
            if (this.mTransactionStack == null) {
                releaseConnection();
                AppMethodBeat.m2505o(12603);
                return;
            }
            AppMethodBeat.m2505o(12603);
        } catch (RuntimeException e) {
            if (this.mTransactionStack == null) {
                this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
            }
            AppMethodBeat.m2505o(12603);
            throw e;
        } catch (Throwable th) {
            if (this.mTransactionStack == null) {
                releaseConnection();
            }
            AppMethodBeat.m2505o(12603);
        }
    }

    public final void setTransactionSuccessful() {
        AppMethodBeat.m2504i(12604);
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
        AppMethodBeat.m2505o(12604);
    }

    public final void endTransaction(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12605);
        throwIfNoTransaction();
        if ($assertionsDisabled || this.mConnection != null) {
            endTransactionUnchecked(cancellationSignal, false);
            AppMethodBeat.m2505o(12605);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(12605);
        throw assertionError;
    }

    private void endTransactionUnchecked(CancellationSignal cancellationSignal, boolean z) {
        boolean z2 = false;
        RuntimeException runtimeException = null;
        AppMethodBeat.m2504i(12606);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.mTransactionStack;
        boolean z3 = (transaction.mMarkedSuccessful || z) && !transaction.mChildFailed;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        if (sQLiteTransactionListener == null) {
            z2 = z3;
        } else if (z3) {
            try {
                sQLiteTransactionListener.onCommit();
                z2 = z3;
            } catch (RuntimeException e) {
                runtimeException = e;
            }
        } else {
            sQLiteTransactionListener.onRollback();
            z2 = z3;
        }
        this.mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        if (this.mTransactionStack == null) {
            if (z2) {
                try {
                    this.mConnection.execute("COMMIT;", null, cancellationSignal);
                } catch (Throwable th) {
                    releaseConnection();
                    AppMethodBeat.m2505o(12606);
                }
            } else {
                this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
            }
            releaseConnection();
        } else if (!z2) {
            this.mTransactionStack.mChildFailed = true;
        }
        if (runtimeException != null) {
            AppMethodBeat.m2505o(12606);
            throw runtimeException;
        } else {
            AppMethodBeat.m2505o(12606);
        }
    }

    public final boolean yieldTransaction(long j, boolean z, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12607);
        if (z) {
            throwIfNoTransaction();
            throwIfTransactionMarkedSuccessful();
            throwIfNestedTransaction();
        } else if (this.mTransactionStack == null || this.mTransactionStack.mMarkedSuccessful || this.mTransactionStack.mParent != null) {
            AppMethodBeat.m2505o(12607);
            return false;
        }
        if (!$assertionsDisabled && this.mConnection == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(12607);
            throw assertionError;
        } else if (this.mTransactionStack.mChildFailed) {
            AppMethodBeat.m2505o(12607);
            return false;
        } else {
            boolean yieldTransactionUnchecked = yieldTransactionUnchecked(j, cancellationSignal);
            AppMethodBeat.m2505o(12607);
            return yieldTransactionUnchecked;
        }
    }

    private boolean yieldTransactionUnchecked(long j, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12608);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
            int i = this.mTransactionStack.mMode;
            SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionStack.mListener;
            int i2 = this.mConnectionFlags;
            endTransactionUnchecked(cancellationSignal, true);
            if (j > 0) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e) {
                }
            }
            beginTransactionUnchecked(i, sQLiteTransactionListener, i2, cancellationSignal);
            AppMethodBeat.m2505o(12608);
            return true;
        }
        AppMethodBeat.m2505o(12608);
        return false;
    }

    public final void prepare(String str, int i, CancellationSignal cancellationSignal, SQLiteStatementInfo sQLiteStatementInfo) {
        AppMethodBeat.m2504i(12609);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12609);
            throw illegalArgumentException;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        acquireConnection(str, i, false, cancellationSignal);
        try {
            this.mConnection.prepare(str, sQLiteStatementInfo);
        } finally {
            releaseConnection();
            AppMethodBeat.m2505o(12609);
        }
    }

    public final void execute(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12610);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12610);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            AppMethodBeat.m2505o(12610);
        } else {
            acquireConnection(str, i, false, cancellationSignal);
            try {
                this.mConnection.execute(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.m2505o(12610);
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12611);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12611);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            AppMethodBeat.m2505o(12611);
            return 0;
        } else {
            acquireConnection(str, i, false, cancellationSignal);
            try {
                long executeForLong = this.mConnection.executeForLong(str, objArr, cancellationSignal);
                return executeForLong;
            } finally {
                releaseConnection();
                AppMethodBeat.m2505o(12611);
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12612);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12612);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            AppMethodBeat.m2505o(12612);
            return null;
        } else {
            acquireConnection(str, i, false, cancellationSignal);
            try {
                String executeForString = this.mConnection.executeForString(str, objArr, cancellationSignal);
                return executeForString;
            } finally {
                releaseConnection();
                AppMethodBeat.m2505o(12612);
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        int i2 = 0;
        AppMethodBeat.m2504i(12613);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12613);
            throw illegalArgumentException;
        }
        if (executeSpecial(str, objArr, i, cancellationSignal)) {
            AppMethodBeat.m2505o(12613);
        } else {
            acquireConnection(str, i, false, cancellationSignal);
            try {
                i2 = this.mConnection.executeForChangedRowCount(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.m2505o(12613);
            }
        }
        return i2;
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12614);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12614);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            AppMethodBeat.m2505o(12614);
            return 0;
        } else {
            acquireConnection(str, i, false, cancellationSignal);
            try {
                long executeForLastInsertedRowId = this.mConnection.executeForLastInsertedRowId(str, objArr, cancellationSignal);
                return executeForLastInsertedRowId;
            } finally {
                releaseConnection();
                AppMethodBeat.m2505o(12614);
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i2, boolean z, int i3, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12615);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.m2505o(12615);
            throw illegalArgumentException;
        } else if (cursorWindow == null) {
            illegalArgumentException = new IllegalArgumentException("window must not be null.");
            AppMethodBeat.m2505o(12615);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i3, cancellationSignal)) {
            cursorWindow.clear();
            AppMethodBeat.m2505o(12615);
            return 0;
        } else {
            acquireConnection(str, i3, false, cancellationSignal);
            try {
                int executeForCursorWindow = this.mConnection.executeForCursorWindow(str, objArr, cursorWindow, i, i2, z, cancellationSignal);
                return executeForCursorWindow;
            } finally {
                releaseConnection();
                AppMethodBeat.m2505o(12615);
            }
        }
    }

    public final Pair<Integer, Integer> walCheckpoint(String str, int i) {
        AppMethodBeat.m2504i(12616);
        acquireConnection(null, i, false, null);
        try {
            Pair<Integer, Integer> walCheckpoint = this.mConnection.walCheckpoint(str);
            return walCheckpoint;
        } finally {
            releaseConnection();
            AppMethodBeat.m2505o(12616);
        }
    }

    private boolean executeSpecial(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12617);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        switch (DatabaseUtils.getSqlStatementType(str)) {
            case 4:
                beginTransaction(2, null, i, cancellationSignal);
                AppMethodBeat.m2505o(12617);
                return true;
            case 5:
                setTransactionSuccessful();
                endTransaction(cancellationSignal);
                AppMethodBeat.m2505o(12617);
                return true;
            case 6:
                endTransaction(cancellationSignal);
                AppMethodBeat.m2505o(12617);
                return true;
            default:
                AppMethodBeat.m2505o(12617);
                return false;
        }
    }

    private void acquireConnection(String str, int i, boolean z, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12618);
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(str, i, cancellationSignal);
            this.mConnectionFlags = i;
            this.mConnection.setAcquisitionState(true, z);
        }
        this.mConnectionUseCount++;
        AppMethodBeat.m2505o(12618);
    }

    private void releaseConnection() {
        AppMethodBeat.m2504i(12619);
        int i = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = i;
        if (i == 0) {
            try {
                this.mConnection.setAcquisitionState(false, false);
                this.mConnectionPool.releaseConnection(this.mConnection);
            } finally {
                this.mConnection = null;
                AppMethodBeat.m2505o(12619);
            }
        } else {
            AppMethodBeat.m2505o(12619);
        }
    }

    /* Access modifiers changed, original: final */
    public final SQLiteConnection acquireConnectionForNativeHandle(int i) {
        AppMethodBeat.m2504i(12620);
        acquireConnection(null, i, true, null);
        SQLiteConnection sQLiteConnection = this.mConnection;
        AppMethodBeat.m2505o(12620);
        return sQLiteConnection;
    }

    /* Access modifiers changed, original: final */
    public final void releaseConnectionForNativeHandle(Exception exception) {
        AppMethodBeat.m2504i(12621);
        if (this.mConnection != null) {
            this.mConnection.endNativeHandle(exception);
        }
        releaseConnection();
        AppMethodBeat.m2505o(12621);
    }

    /* Access modifiers changed, original: final */
    public final PreparedStatement acquirePreparedStatement(String str, int i) {
        AppMethodBeat.m2504i(12622);
        acquireConnection(str, i, true, null);
        PreparedStatement acquirePreparedStatement = this.mConnection.acquirePreparedStatement(str);
        AppMethodBeat.m2505o(12622);
        return acquirePreparedStatement;
    }

    /* Access modifiers changed, original: final */
    public final void releasePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.m2504i(12623);
        if (this.mConnection != null) {
            this.mConnection.releasePreparedStatement(preparedStatement);
            releaseConnection();
        }
        AppMethodBeat.m2505o(12623);
    }

    private void throwIfNoTransaction() {
        AppMethodBeat.m2504i(12624);
        if (this.mTransactionStack == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            AppMethodBeat.m2505o(12624);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(12624);
    }

    private void throwIfTransactionMarkedSuccessful() {
        AppMethodBeat.m2504i(12625);
        if (this.mTransactionStack == null || !this.mTransactionStack.mMarkedSuccessful) {
            AppMethodBeat.m2505o(12625);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        AppMethodBeat.m2505o(12625);
        throw illegalStateException;
    }

    private void throwIfNestedTransaction() {
        AppMethodBeat.m2504i(12626);
        if (hasNestedTransaction()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
            AppMethodBeat.m2505o(12626);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(12626);
    }

    private Transaction obtainTransaction(int i, SQLiteTransactionListener sQLiteTransactionListener) {
        AppMethodBeat.m2504i(12627);
        Transaction transaction = this.mTransactionPool;
        if (transaction != null) {
            this.mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i;
        transaction.mListener = sQLiteTransactionListener;
        AppMethodBeat.m2505o(12627);
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = this.mTransactionPool;
        transaction.mListener = null;
        this.mTransactionPool = transaction;
    }
}
