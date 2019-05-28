package com.tencent.wcdb.database;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public class SQLiteAsyncCheckpointer implements Callback, SQLiteCheckpointListener {
    private static final int DEFAULT_BLOCKING_THRESHOLD = 300;
    private static final int DEFAULT_THRESHOLD = 100;
    private static HandlerThread gDefaultThread;
    private static final Object gDefaultThreadLock = new Object();
    private static int gDefaultThreadRefCount = 0;
    private int mBlockingThreshold;
    private Handler mHandler;
    private int mLastSyncMode;
    private Looper mLooper;
    private final HashSet<Pair<SQLiteDatabase, String>> mPendingCheckpoints;
    private int mThreshold;
    private boolean mUseDefaultLooper;

    public SQLiteAsyncCheckpointer() {
        this(null, 100, 300);
    }

    public SQLiteAsyncCheckpointer(Looper looper) {
        this(looper, 100, 300);
    }

    public SQLiteAsyncCheckpointer(Looper looper, int i, int i2) {
        AppMethodBeat.m2504i(12231);
        this.mLooper = looper;
        this.mThreshold = i;
        this.mBlockingThreshold = i2;
        this.mPendingCheckpoints = new HashSet();
        AppMethodBeat.m2505o(12231);
    }

    public void onAttach(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(12232);
        if (this.mLooper == null) {
            this.mLooper = acquireDefaultLooper();
            this.mUseDefaultLooper = true;
        }
        this.mHandler = new Handler(this.mLooper, this);
        this.mLastSyncMode = sQLiteDatabase.getSynchronousMode();
        sQLiteDatabase.setSynchronousMode(1);
        AppMethodBeat.m2505o(12232);
    }

    public void onWALCommit(SQLiteDatabase sQLiteDatabase, String str, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(12233);
        if (i < this.mThreshold) {
            AppMethodBeat.m2505o(12233);
            return;
        }
        boolean add;
        int i3 = i >= this.mBlockingThreshold ? 1 : 0;
        Pair pair = new Pair(sQLiteDatabase, str);
        synchronized (this.mPendingCheckpoints) {
            try {
                add = this.mPendingCheckpoints.add(pair);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12233);
            }
        }
        if (add) {
            sQLiteDatabase.acquireReference();
            Handler handler = this.mHandler;
            if (i3 == 0) {
                i2 = 0;
            }
            this.mHandler.sendMessage(handler.obtainMessage(0, i2, 0, pair));
            AppMethodBeat.m2505o(12233);
        }
    }

    public void onDetach(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(12234);
        sQLiteDatabase.setSynchronousMode(this.mLastSyncMode);
        this.mHandler = null;
        if (this.mUseDefaultLooper) {
            this.mLooper = null;
            releaseDefaultLooper();
            this.mUseDefaultLooper = false;
        }
        AppMethodBeat.m2505o(12234);
    }

    public boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(12235);
        Pair pair = (Pair) message.obj;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) pair.first;
        String str = (String) pair.second;
        boolean z = message.arg1 != 0;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            Pair walCheckpoint = sQLiteDatabase.walCheckpoint(str, z);
            onCheckpointResult(sQLiteDatabase, ((Integer) walCheckpoint.first).intValue(), ((Integer) walCheckpoint.second).intValue(), SystemClock.uptimeMillis() - uptimeMillis);
            sQLiteDatabase.releaseReference();
            synchronized (this.mPendingCheckpoints) {
                try {
                    if (this.mPendingCheckpoints.remove(pair)) {
                    } else {
                        Object assertionError = new AssertionError("mPendingCheckpoints.remove(p)");
                        throw assertionError;
                    }
                } finally {
                    AppMethodBeat.m2505o(12235);
                }
            }
            AppMethodBeat.m2505o(12235);
            return true;
        } catch (Throwable th) {
            sQLiteDatabase.releaseReference();
            AppMethodBeat.m2505o(12235);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCheckpointResult(SQLiteDatabase sQLiteDatabase, int i, int i2, long j) {
    }

    private static Looper acquireDefaultLooper() {
        Looper looper;
        AppMethodBeat.m2504i(12236);
        synchronized (gDefaultThreadLock) {
            try {
                int i = gDefaultThreadRefCount;
                gDefaultThreadRefCount = i + 1;
                if (i == 0) {
                    if (gDefaultThread != null) {
                        Object assertionError = new AssertionError("gDefaultThread == null");
                        throw assertionError;
                    }
                    HandlerThread handlerThread = new HandlerThread("WCDB.AsyncCheckpointer", 4);
                    gDefaultThread = handlerThread;
                    handlerThread.start();
                }
                looper = gDefaultThread.getLooper();
            } finally {
                AppMethodBeat.m2505o(12236);
            }
        }
        AppMethodBeat.m2505o(12236);
        return looper;
    }

    private static void releaseDefaultLooper() {
        AppMethodBeat.m2504i(12237);
        synchronized (gDefaultThreadLock) {
            try {
                int i = gDefaultThreadRefCount - 1;
                gDefaultThreadRefCount = i;
                if (i <= 0) {
                    if (gDefaultThreadRefCount < 0) {
                        Object assertionError = new AssertionError("gDefaultThreadRefCount == 0");
                        throw assertionError;
                    } else {
                        gDefaultThread.quit();
                        gDefaultThread = null;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(12237);
            }
        }
        AppMethodBeat.m2505o(12237);
    }

    static {
        AppMethodBeat.m2504i(12238);
        AppMethodBeat.m2505o(12238);
    }
}
