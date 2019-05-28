package com.tencent.wcdb.database;

import java.io.Closeable;

public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount = 1;

    public abstract void onAllReferencesReleased();

    /* Access modifiers changed, original: protected */
    @Deprecated
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void acquireReference() {
        synchronized (this) {
            if (this.mReferenceCount <= 0) {
                throw new IllegalStateException("attempt to re-open an already-closed object: ".concat(String.valueOf(this)));
            }
            this.mReferenceCount++;
        }
    }

    public void releaseReference() {
        Object obj;
        synchronized (this) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            obj = i == 0 ? 1 : null;
        }
        if (obj != null) {
            onAllReferencesReleased();
        }
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        Object obj;
        synchronized (this) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            obj = i == 0 ? 1 : null;
        }
        if (obj != null) {
            onAllReferencesReleased();
        }
    }

    public void close() {
        releaseReference();
    }
}
