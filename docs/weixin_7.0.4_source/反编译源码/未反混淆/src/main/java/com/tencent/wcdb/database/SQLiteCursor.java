package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractWindowedCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor extends AbstractWindowedCursor {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.i(12405);
            SQLiteCursor sQLiteCursor = new SQLiteCursor(sQLiteCursorDriver, str, (SQLiteQuery) sQLiteProgram);
            AppMethodBeat.o(12405);
            return sQLiteCursor;
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(12406);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.o(12406);
            return sQLiteQuery;
        }
    };
    static final int NO_COUNT = -1;
    static final String TAG = "WCDB.SQLiteCursor";
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final SQLiteQuery mQuery;
    private final Throwable mStackTrace;

    @Deprecated
    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        AppMethodBeat.i(12407);
        this.mCount = -1;
        if (sQLiteQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.o(12407);
            throw illegalArgumentException;
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.mQuery = sQLiteQuery;
        this.mColumns = sQLiteQuery.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        AppMethodBeat.o(12407);
    }

    public SQLiteDatabase getDatabase() {
        AppMethodBeat.i(12408);
        SQLiteDatabase database = this.mQuery.getDatabase();
        AppMethodBeat.o(12408);
        return database;
    }

    public boolean onMove(int i, int i2) {
        AppMethodBeat.i(12409);
        if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i2);
        }
        AppMethodBeat.o(12409);
        return true;
    }

    public int getCount() {
        AppMethodBeat.i(12410);
        if (this.mCount == -1) {
            fillWindow(0);
        }
        int i = this.mCount;
        AppMethodBeat.o(12410);
        return i;
    }

    private void fillWindow(int i) {
        AppMethodBeat.i(12411);
        clearOrCreateWindow(getDatabase().getPath());
        try {
            if (this.mCount == -1) {
                this.mCount = this.mQuery.fillWindow(this.mWindow, DatabaseUtils.cursorPickFillWindowStartPosition(i, 0), i, true);
                this.mCursorWindowCapacity = this.mWindow.getNumRows();
                AppMethodBeat.o(12411);
                return;
            }
            this.mQuery.fillWindow(this.mWindow, DatabaseUtils.cursorPickFillWindowStartPosition(i, this.mCursorWindowCapacity), i, false);
            AppMethodBeat.o(12411);
        } catch (RuntimeException e) {
            closeWindow();
            AppMethodBeat.o(12411);
            throw e;
        }
    }

    public int getColumnIndex(String str) {
        int i;
        Object str2;
        AppMethodBeat.i(12412);
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str2.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e(TAG, "requesting column name with table name -- ".concat(String.valueOf(str2)), exception);
            str2 = str2.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        if (num != null) {
            i = num.intValue();
            AppMethodBeat.o(12412);
            return i;
        }
        AppMethodBeat.o(12412);
        return -1;
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public void deactivate() {
        AppMethodBeat.i(12413);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.o(12413);
    }

    public void close() {
        AppMethodBeat.i(12414);
        super.close();
        synchronized (this) {
            try {
                this.mQuery.close();
                this.mDriver.cursorClosed();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12414);
            }
        }
    }

    public boolean requery() {
        boolean z = false;
        AppMethodBeat.i(12415);
        if (isClosed()) {
            AppMethodBeat.o(12415);
        } else {
            synchronized (this) {
                try {
                    if (this.mQuery.getDatabase().isOpen()) {
                        if (this.mWindow != null) {
                            this.mWindow.clear();
                        }
                        this.mPos = -1;
                        this.mCount = -1;
                        this.mDriver.cursorRequeried(this);
                        try {
                            z = super.requery();
                            AppMethodBeat.o(12415);
                        } catch (IllegalStateException e) {
                            Log.w(TAG, "requery() failed " + e.getMessage(), e);
                            AppMethodBeat.o(12415);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(12415);
                }
            }
        }
        return z;
    }

    public void setWindow(CursorWindow cursorWindow) {
        AppMethodBeat.i(12416);
        super.setWindow(cursorWindow);
        this.mCount = -1;
        AppMethodBeat.o(12416);
    }

    public void setSelectionArguments(String[] strArr) {
        AppMethodBeat.i(12417);
        this.mDriver.setBindArguments(strArr);
        AppMethodBeat.o(12417);
    }

    public void finalize() {
        AppMethodBeat.i(12418);
        try {
            if (this.mWindow != null) {
                close();
            }
            super.finalize();
            AppMethodBeat.o(12418);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(12418);
        }
    }

    static {
        AppMethodBeat.i(12419);
        AppMethodBeat.o(12419);
    }
}
