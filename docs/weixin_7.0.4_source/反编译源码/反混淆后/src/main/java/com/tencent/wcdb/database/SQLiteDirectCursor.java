package com.tencent.wcdb.database;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectCursor extends AbstractCursor {
    public static final CursorFactory FACTORY = new C73961();
    private static final String TAG = "WCDB.SQLiteDirectCursor";
    private final String[] mColumns;
    private int mCount;
    private boolean mCountFinished;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteDirectQuery mQuery;

    /* renamed from: com.tencent.wcdb.database.SQLiteDirectCursor$1 */
    static class C73961 implements CursorFactory {
        C73961() {
        }

        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.m2504i(12552);
            SQLiteDirectCursor sQLiteDirectCursor = new SQLiteDirectCursor(sQLiteCursorDriver, str, (SQLiteDirectQuery) sQLiteProgram);
            AppMethodBeat.m2505o(12552);
            return sQLiteDirectCursor;
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.m2504i(12553);
            SQLiteDirectQuery sQLiteDirectQuery = new SQLiteDirectQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.m2505o(12553);
            return sQLiteDirectQuery;
        }
    }

    public SQLiteDirectCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteDirectQuery sQLiteDirectQuery) {
        AppMethodBeat.m2504i(12554);
        if (sQLiteDirectQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.m2505o(12554);
            throw illegalArgumentException;
        }
        this.mQuery = sQLiteDirectQuery;
        this.mDriver = sQLiteCursorDriver;
        this.mColumns = sQLiteDirectQuery.getColumnNames();
        this.mCount = -1;
        this.mCountFinished = false;
        AppMethodBeat.m2505o(12554);
    }

    public void close() {
        AppMethodBeat.m2504i(12555);
        super.close();
        this.mQuery.close();
        this.mDriver.cursorClosed();
        AppMethodBeat.m2505o(12555);
    }

    public void deactivate() {
        AppMethodBeat.m2504i(12556);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.m2505o(12556);
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public String getString(int i) {
        AppMethodBeat.m2504i(12557);
        String string = this.mQuery.getString(i);
        AppMethodBeat.m2505o(12557);
        return string;
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.m2504i(12558);
        byte[] blob = this.mQuery.getBlob(i);
        AppMethodBeat.m2505o(12558);
        return blob;
    }

    public short getShort(int i) {
        AppMethodBeat.m2504i(12559);
        short s = (short) ((int) this.mQuery.getLong(i));
        AppMethodBeat.m2505o(12559);
        return s;
    }

    public int getInt(int i) {
        AppMethodBeat.m2504i(12560);
        int i2 = (int) this.mQuery.getLong(i);
        AppMethodBeat.m2505o(12560);
        return i2;
    }

    public long getLong(int i) {
        AppMethodBeat.m2504i(12561);
        long j = this.mQuery.getLong(i);
        AppMethodBeat.m2505o(12561);
        return j;
    }

    public float getFloat(int i) {
        AppMethodBeat.m2504i(12562);
        float f = (float) this.mQuery.getDouble(i);
        AppMethodBeat.m2505o(12562);
        return f;
    }

    public double getDouble(int i) {
        AppMethodBeat.m2504i(12563);
        double d = this.mQuery.getDouble(i);
        AppMethodBeat.m2505o(12563);
        return d;
    }

    public int getType(int i) {
        AppMethodBeat.m2504i(12564);
        int type = this.mQuery.getType(i);
        AppMethodBeat.m2505o(12564);
        return type;
    }

    public boolean isNull(int i) {
        AppMethodBeat.m2504i(12565);
        if (getType(i) == 0) {
            AppMethodBeat.m2505o(12565);
            return true;
        }
        AppMethodBeat.m2505o(12565);
        return false;
    }

    public boolean moveToPosition(int i) {
        AppMethodBeat.m2504i(12566);
        if (i < 0) {
            this.mQuery.reset(false);
            this.mPos = -1;
            AppMethodBeat.m2505o(12566);
            return false;
        } else if (!this.mCountFinished || i < this.mCount) {
            int step;
            if (i < this.mPos) {
                Log.m9452w(TAG, "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
                this.mQuery.reset(false);
                step = this.mQuery.step(i + 1) - 1;
            } else if (i == this.mPos) {
                AppMethodBeat.m2505o(12566);
                return true;
            } else {
                step = this.mPos + this.mQuery.step(i - this.mPos);
            }
            if (step < i) {
                this.mCount = step + 1;
                this.mCountFinished = true;
                this.mPos = this.mCount;
            } else {
                this.mPos = step;
                if (step >= this.mCount) {
                    this.mCount = step + 1;
                    this.mCountFinished = false;
                }
            }
            if (this.mPos < this.mCount) {
                AppMethodBeat.m2505o(12566);
                return true;
            }
            AppMethodBeat.m2505o(12566);
            return false;
        } else {
            this.mPos = this.mCount;
            AppMethodBeat.m2505o(12566);
            return false;
        }
    }

    public int getCount() {
        AppMethodBeat.m2504i(12567);
        if (!this.mCountFinished) {
            Log.m9452w(TAG, "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
            this.mCount = (this.mPos + this.mQuery.step(BaseClientBuilder.API_PRIORITY_OTHER)) + 1;
            this.mCountFinished = true;
            this.mQuery.reset(false);
            this.mPos = this.mQuery.step(this.mPos + 1) - 1;
        }
        int i = this.mCount;
        AppMethodBeat.m2505o(12567);
        return i;
    }

    public boolean requery() {
        boolean z = false;
        AppMethodBeat.m2504i(12568);
        if (isClosed()) {
            AppMethodBeat.m2505o(12568);
        } else {
            synchronized (this) {
                try {
                    if (this.mQuery.getDatabase().isOpen()) {
                        this.mPos = -1;
                        this.mCountFinished = false;
                        this.mCount = -1;
                        this.mDriver.cursorRequeried(this);
                        this.mQuery.reset(z);
                        try {
                            z = super.requery();
                            AppMethodBeat.m2505o(12568);
                        } catch (IllegalStateException e) {
                            Log.m9453w(TAG, "requery() failed " + e.getMessage(), e);
                            AppMethodBeat.m2505o(12568);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(12568);
                }
            }
        }
        return z;
    }

    static {
        AppMethodBeat.m2504i(12569);
        AppMethodBeat.m2505o(12569);
    }
}
