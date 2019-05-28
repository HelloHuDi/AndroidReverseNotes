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
    public static final CursorFactory FACTORY = new C73951();
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

    /* renamed from: com.tencent.wcdb.database.SQLiteCursor$1 */
    static class C73951 implements CursorFactory {
        C73951() {
        }

        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.m2504i(12405);
            SQLiteCursor sQLiteCursor = new SQLiteCursor(sQLiteCursorDriver, str, (SQLiteQuery) sQLiteProgram);
            AppMethodBeat.m2505o(12405);
            return sQLiteCursor;
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.m2504i(12406);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.m2505o(12406);
            return sQLiteQuery;
        }
    }

    @Deprecated
    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        AppMethodBeat.m2504i(12407);
        this.mCount = -1;
        if (sQLiteQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.m2505o(12407);
            throw illegalArgumentException;
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.mQuery = sQLiteQuery;
        this.mColumns = sQLiteQuery.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        AppMethodBeat.m2505o(12407);
    }

    public SQLiteDatabase getDatabase() {
        AppMethodBeat.m2504i(12408);
        SQLiteDatabase database = this.mQuery.getDatabase();
        AppMethodBeat.m2505o(12408);
        return database;
    }

    public boolean onMove(int i, int i2) {
        AppMethodBeat.m2504i(12409);
        if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i2);
        }
        AppMethodBeat.m2505o(12409);
        return true;
    }

    public int getCount() {
        AppMethodBeat.m2504i(12410);
        if (this.mCount == -1) {
            fillWindow(0);
        }
        int i = this.mCount;
        AppMethodBeat.m2505o(12410);
        return i;
    }

    private void fillWindow(int i) {
        AppMethodBeat.m2504i(12411);
        clearOrCreateWindow(getDatabase().getPath());
        try {
            if (this.mCount == -1) {
                this.mCount = this.mQuery.fillWindow(this.mWindow, DatabaseUtils.cursorPickFillWindowStartPosition(i, 0), i, true);
                this.mCursorWindowCapacity = this.mWindow.getNumRows();
                AppMethodBeat.m2505o(12411);
                return;
            }
            this.mQuery.fillWindow(this.mWindow, DatabaseUtils.cursorPickFillWindowStartPosition(i, this.mCursorWindowCapacity), i, false);
            AppMethodBeat.m2505o(12411);
        } catch (RuntimeException e) {
            closeWindow();
            AppMethodBeat.m2505o(12411);
            throw e;
        }
    }

    public int getColumnIndex(String str) {
        int i;
        Object str2;
        AppMethodBeat.m2504i(12412);
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
            Log.m9445e(TAG, "requesting column name with table name -- ".concat(String.valueOf(str2)), exception);
            str2 = str2.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        if (num != null) {
            i = num.intValue();
            AppMethodBeat.m2505o(12412);
            return i;
        }
        AppMethodBeat.m2505o(12412);
        return -1;
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public void deactivate() {
        AppMethodBeat.m2504i(12413);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.m2505o(12413);
    }

    public void close() {
        AppMethodBeat.m2504i(12414);
        super.close();
        synchronized (this) {
            try {
                this.mQuery.close();
                this.mDriver.cursorClosed();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12414);
            }
        }
    }

    public boolean requery() {
        boolean z = false;
        AppMethodBeat.m2504i(12415);
        if (isClosed()) {
            AppMethodBeat.m2505o(12415);
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
                            AppMethodBeat.m2505o(12415);
                        } catch (IllegalStateException e) {
                            Log.m9453w(TAG, "requery() failed " + e.getMessage(), e);
                            AppMethodBeat.m2505o(12415);
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(12415);
                }
            }
        }
        return z;
    }

    public void setWindow(CursorWindow cursorWindow) {
        AppMethodBeat.m2504i(12416);
        super.setWindow(cursorWindow);
        this.mCount = -1;
        AppMethodBeat.m2505o(12416);
    }

    public void setSelectionArguments(String[] strArr) {
        AppMethodBeat.m2504i(12417);
        this.mDriver.setBindArguments(strArr);
        AppMethodBeat.m2505o(12417);
    }

    public void finalize() {
        AppMethodBeat.m2504i(12418);
        try {
            if (this.mWindow != null) {
                close();
            }
            super.finalize();
            AppMethodBeat.m2505o(12418);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(12418);
        }
    }

    static {
        AppMethodBeat.m2504i(12419);
        AppMethodBeat.m2505o(12419);
    }
}
