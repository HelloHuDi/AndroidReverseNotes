package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;

public class SQLiteAsyncCursor extends AbstractCursor {
    public static final CursorFactory FACTORY = new C73941();
    private static final int MAX_KEEP_CHUNKS = 32;
    private static final int MAX_PREFETCH = 256;
    private static final int MIN_FETCH_ROWS = 32;
    private static final String TAG = "WCDB.SQLiteAsyncCursor";
    private final String[] mColumns;
    private volatile int mCount;
    private long mCurrentRow;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteAsyncQuery mQuery;
    private QueryThread mQueryThread;
    private final Object mWaitLock;
    private ChunkedCursorWindow mWindow;

    class QueryThread extends Thread {
        private int mFetchPos = 0;
        private int mMinPos = 0;
        private volatile int mRequestPos = 0;

        QueryThread() {
            super("SQLiteAsyncCursor.QueryThread");
        }

        public void run() {
            AppMethodBeat.m2504i(12241);
            try {
                int count = SQLiteAsyncCursor.this.mQuery.getCount();
                synchronized (SQLiteAsyncCursor.this.mWaitLock) {
                    SQLiteAsyncCursor.this.mCount = count;
                    SQLiteAsyncCursor.this.mWaitLock.notifyAll();
                }
                while (!interrupted()) {
                    int i;
                    synchronized (this) {
                        while (this.mRequestPos + 256 <= this.mFetchPos && this.mRequestPos >= this.mMinPos) {
                            wait();
                        }
                        count = this.mRequestPos;
                        i = count + 256;
                    }
                    if (count < this.mMinPos) {
                        SQLiteAsyncCursor.this.mQuery.reset();
                        this.mFetchPos = 0;
                        SQLiteAsyncCursor.this.mWindow.clear();
                        this.mMinPos = 0;
                    }
                    if (this.mFetchPos < i) {
                        int fillRows;
                        if (SQLiteAsyncCursor.this.mWindow.getNumChunks() > 32) {
                            long removeChunk = SQLiteAsyncCursor.this.mWindow.removeChunk(this.mMinPos);
                            if (removeChunk != -1) {
                                this.mMinPos = (int) removeChunk;
                            }
                        }
                        synchronized (SQLiteAsyncCursor.this.mWaitLock) {
                            fillRows = SQLiteAsyncCursor.this.mQuery.fillRows(SQLiteAsyncCursor.this.mWindow, this.mFetchPos, 32);
                            if (this.mFetchPos <= count && this.mFetchPos + fillRows > count) {
                                SQLiteAsyncCursor.this.mWaitLock.notifyAll();
                            }
                        }
                        this.mFetchPos += fillRows;
                    }
                }
                SQLiteAsyncCursor.this.mQuery.release();
                AppMethodBeat.m2505o(12241);
            } catch (InterruptedException e) {
                SQLiteAsyncCursor.this.mQuery.release();
                AppMethodBeat.m2505o(12241);
            } catch (Throwable th) {
                SQLiteAsyncCursor.this.mQuery.release();
                AppMethodBeat.m2505o(12241);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void requestPos(int i) {
            AppMethodBeat.m2504i(12242);
            synchronized (this) {
                try {
                    this.mRequestPos = i;
                    notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(12242);
                }
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void quit() {
            AppMethodBeat.m2504i(12243);
            interrupt();
            AppMethodBeat.m2505o(12243);
        }
    }

    /* renamed from: com.tencent.wcdb.database.SQLiteAsyncCursor$1 */
    static class C73941 implements CursorFactory {
        C73941() {
        }

        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.m2504i(12239);
            SQLiteAsyncCursor sQLiteAsyncCursor = new SQLiteAsyncCursor(sQLiteCursorDriver, str, (SQLiteAsyncQuery) sQLiteProgram);
            AppMethodBeat.m2505o(12239);
            return sQLiteAsyncCursor;
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.m2504i(12240);
            SQLiteAsyncQuery sQLiteAsyncQuery = new SQLiteAsyncQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.m2505o(12240);
            return sQLiteAsyncQuery;
        }
    }

    public SQLiteAsyncCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteAsyncQuery sQLiteAsyncQuery) {
        AppMethodBeat.m2504i(12244);
        if (sQLiteAsyncQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.m2505o(12244);
            throw illegalArgumentException;
        }
        this.mQuery = sQLiteAsyncQuery;
        this.mDriver = sQLiteCursorDriver;
        this.mColumns = sQLiteAsyncQuery.getColumnNames();
        this.mCount = -1;
        this.mWaitLock = new Object();
        this.mWindow = new ChunkedCursorWindow(16777216);
        this.mQueryThread = new QueryThread();
        this.mQueryThread.start();
        AppMethodBeat.m2505o(12244);
    }

    public void close() {
        AppMethodBeat.m2504i(12245);
        super.close();
        this.mQuery.close();
        this.mDriver.cursorClosed();
        AppMethodBeat.m2505o(12245);
    }

    public void deactivate() {
        AppMethodBeat.m2504i(12246);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.m2505o(12246);
    }

    public void onDeactivateOrClose() {
        AppMethodBeat.m2504i(12247);
        if (this.mCurrentRow != 0) {
            this.mWindow.endRowUnsafe(this.mCurrentRow);
            this.mCurrentRow = 0;
        }
        if (this.mQueryThread != null) {
            this.mQueryThread.quit();
            try {
                this.mQueryThread.join();
            } catch (InterruptedException e) {
            }
            this.mQueryThread = null;
        }
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
        this.mCount = -1;
        this.mPos = -1;
        super.onDeactivateOrClose();
        AppMethodBeat.m2505o(12247);
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public int getCount() {
        AppMethodBeat.m2504i(12248);
        int i;
        if (this.mCount >= 0) {
            i = this.mCount;
            AppMethodBeat.m2505o(12248);
            return i;
        } else if (this.mWindow == null) {
            AppMethodBeat.m2505o(12248);
            return -1;
        } else {
            try {
                synchronized (this.mWaitLock) {
                    while (this.mCount < 0) {
                        this.mWaitLock.wait();
                    }
                }
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                AppMethodBeat.m2505o(12248);
            }
            i = this.mCount;
            AppMethodBeat.m2505o(12248);
            return i;
        }
    }

    private boolean isValidPosition(int i) {
        AppMethodBeat.m2504i(12249);
        if (i < 0 || i >= getCount()) {
            AppMethodBeat.m2505o(12249);
            return false;
        }
        AppMethodBeat.m2505o(12249);
        return true;
    }

    private long waitForRow(int i) {
        AppMethodBeat.m2504i(12250);
        try {
            long rowUnsafe;
            synchronized (this.mWaitLock) {
                while (true) {
                    rowUnsafe = this.mWindow.getRowUnsafe(i);
                    if (rowUnsafe != 0) {
                    } else if (isValidPosition(i)) {
                        this.mWaitLock.wait();
                    } else {
                        CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
                        AppMethodBeat.m2505o(12250);
                        throw cursorIndexOutOfBoundsException;
                    }
                }
            }
            AppMethodBeat.m2505o(12250);
            return rowUnsafe;
        } catch (InterruptedException e) {
            AppMethodBeat.m2505o(12250);
            return 0;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(12250);
        }
    }

    private boolean requestRow() {
        AppMethodBeat.m2504i(12251);
        if (this.mWindow == null) {
            AppMethodBeat.m2505o(12251);
            return false;
        } else if (isValidPosition(this.mPos)) {
            this.mQueryThread.requestPos(this.mPos);
            this.mCurrentRow = this.mWindow.getRowUnsafe(this.mPos);
            if (this.mCurrentRow == 0) {
                this.mCurrentRow = waitForRow(this.mPos);
            }
            if (this.mCurrentRow != 0) {
                AppMethodBeat.m2505o(12251);
                return true;
            }
            AppMethodBeat.m2505o(12251);
            return false;
        } else {
            AppMethodBeat.m2505o(12251);
            return false;
        }
    }

    private void checkValidRow() {
        AppMethodBeat.m2504i(12252);
        if (this.mCurrentRow != 0) {
            AppMethodBeat.m2505o(12252);
        } else if (isValidPosition(this.mPos)) {
            StaleDataException staleDataException = new StaleDataException("Cannot get valid Row object");
            AppMethodBeat.m2505o(12252);
            throw staleDataException;
        } else {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
            AppMethodBeat.m2505o(12252);
            throw cursorIndexOutOfBoundsException;
        }
    }

    public boolean moveToPosition(int i) {
        AppMethodBeat.m2504i(12253);
        if (i < -1) {
            i = -1;
        }
        if (i != this.mPos) {
            this.mWindow.endRowUnsafe(this.mCurrentRow);
            this.mCurrentRow = 0;
        }
        int count = getCount();
        if (i >= count) {
            this.mPos = count;
            AppMethodBeat.m2505o(12253);
            return false;
        }
        this.mPos = i;
        if (i < 0 || !requestRow()) {
            AppMethodBeat.m2505o(12253);
            return false;
        }
        AppMethodBeat.m2505o(12253);
        return true;
    }

    public int getType(int i) {
        AppMethodBeat.m2504i(12254);
        checkValidRow();
        int typeUnsafe = this.mWindow.getTypeUnsafe(this.mCurrentRow, i);
        AppMethodBeat.m2505o(12254);
        return typeUnsafe;
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.m2504i(12255);
        checkValidRow();
        byte[] blobUnsafe = this.mWindow.getBlobUnsafe(this.mCurrentRow, i);
        AppMethodBeat.m2505o(12255);
        return blobUnsafe;
    }

    public String getString(int i) {
        AppMethodBeat.m2504i(12256);
        checkValidRow();
        String stringUnsafe = this.mWindow.getStringUnsafe(this.mCurrentRow, i);
        AppMethodBeat.m2505o(12256);
        return stringUnsafe;
    }

    public short getShort(int i) {
        AppMethodBeat.m2504i(12257);
        short s = (short) ((int) getLong(i));
        AppMethodBeat.m2505o(12257);
        return s;
    }

    public int getInt(int i) {
        AppMethodBeat.m2504i(12258);
        int i2 = (int) getLong(i);
        AppMethodBeat.m2505o(12258);
        return i2;
    }

    public long getLong(int i) {
        AppMethodBeat.m2504i(12259);
        checkValidRow();
        long longUnsafe = this.mWindow.getLongUnsafe(this.mCurrentRow, i);
        AppMethodBeat.m2505o(12259);
        return longUnsafe;
    }

    public float getFloat(int i) {
        AppMethodBeat.m2504i(12260);
        float f = (float) getDouble(i);
        AppMethodBeat.m2505o(12260);
        return f;
    }

    public double getDouble(int i) {
        AppMethodBeat.m2504i(12261);
        checkValidRow();
        double doubleUnsafe = this.mWindow.getDoubleUnsafe(this.mCurrentRow, i);
        AppMethodBeat.m2505o(12261);
        return doubleUnsafe;
    }

    public boolean isNull(int i) {
        AppMethodBeat.m2504i(12262);
        if (getType(i) == 0) {
            AppMethodBeat.m2505o(12262);
            return true;
        }
        AppMethodBeat.m2505o(12262);
        return false;
    }

    static {
        AppMethodBeat.m2504i(12263);
        AppMethodBeat.m2505o(12263);
    }
}
