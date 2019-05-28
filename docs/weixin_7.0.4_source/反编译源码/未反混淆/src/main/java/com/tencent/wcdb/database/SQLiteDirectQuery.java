package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectQuery extends SQLiteProgram {
    private static final int[] SQLITE_TYPE_MAPPING = new int[]{3, 1, 2, 3, 4, 0};
    private static final String TAG = "WCDB.SQLiteDirectQuery";
    private final CancellationSignal mCancellationSignal;

    private static native byte[] nativeGetBlob(long j, int i);

    private static native double nativeGetDouble(long j, int i);

    private static native long nativeGetLong(long j, int i);

    private static native String nativeGetString(long j, int i);

    private static native int nativeGetType(long j, int i);

    private static native int nativeStep(long j, int i);

    public SQLiteDirectQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    public long getLong(int i) {
        AppMethodBeat.i(12573);
        long nativeGetLong = nativeGetLong(this.mPreparedStatement.getPtr(), i);
        AppMethodBeat.o(12573);
        return nativeGetLong;
    }

    public double getDouble(int i) {
        AppMethodBeat.i(12574);
        double nativeGetDouble = nativeGetDouble(this.mPreparedStatement.getPtr(), i);
        AppMethodBeat.o(12574);
        return nativeGetDouble;
    }

    public String getString(int i) {
        AppMethodBeat.i(12575);
        String nativeGetString = nativeGetString(this.mPreparedStatement.getPtr(), i);
        AppMethodBeat.o(12575);
        return nativeGetString;
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.i(12576);
        byte[] nativeGetBlob = nativeGetBlob(this.mPreparedStatement.getPtr(), i);
        AppMethodBeat.o(12576);
        return nativeGetBlob;
    }

    public int getType(int i) {
        AppMethodBeat.i(12577);
        int i2 = SQLITE_TYPE_MAPPING[nativeGetType(this.mPreparedStatement.getPtr(), i)];
        AppMethodBeat.o(12577);
        return i2;
    }

    public int step(int i) {
        AppMethodBeat.i(12578);
        try {
            if (acquirePreparedStatement()) {
                this.mPreparedStatement.beginOperation("directQuery", getBindArgs());
                this.mPreparedStatement.attachCancellationSignal(this.mCancellationSignal);
            }
            int nativeStep = nativeStep(this.mPreparedStatement.getPtr(), i);
            AppMethodBeat.o(12578);
            return nativeStep;
        } catch (RuntimeException e) {
            if (e instanceof SQLiteException) {
                Log.e(TAG, "Got exception on stepping: " + e.getMessage() + ", SQL: " + getSql());
                checkCorruption((SQLiteException) e);
            }
            if (this.mPreparedStatement != null) {
                this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
                this.mPreparedStatement.failOperation(e);
            }
            releasePreparedStatement();
            AppMethodBeat.o(12578);
            throw e;
        }
    }

    public synchronized void reset(boolean z) {
        AppMethodBeat.i(12579);
        if (this.mPreparedStatement != null) {
            this.mPreparedStatement.reset(false);
            if (z) {
                this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
                this.mPreparedStatement.endOperation(null);
                releasePreparedStatement();
            }
        }
        AppMethodBeat.o(12579);
    }

    /* Access modifiers changed, original: protected */
    public void onAllReferencesReleased() {
        AppMethodBeat.i(12580);
        synchronized (this) {
            try {
                if (this.mPreparedStatement != null) {
                    this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
                    this.mPreparedStatement.endOperation(null);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12580);
            }
        }
        super.onAllReferencesReleased();
    }
}
