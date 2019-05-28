package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    private static final String TAG = "Cursor";
    protected boolean mClosed;
    private final ContentObservable mContentObservable = new ContentObservable();
    protected ContentResolver mContentResolver;
    @Deprecated
    protected Long mCurrentRowID = null;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    private Bundle mExtras = Bundle.EMPTY;
    private Uri mNotifyUri;
    public int mPos = -1;
    @Deprecated
    protected int mRowIdColumnIndex = -1;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;
    @Deprecated
    protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap();

    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super(null);
            AppMethodBeat.i(11958);
            this.mCursor = new WeakReference(abstractCursor);
            AppMethodBeat.o(11958);
        }

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean z) {
            AppMethodBeat.i(11959);
            AbstractCursor abstractCursor = (AbstractCursor) this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
            AppMethodBeat.o(11959);
        }
    }

    public abstract String[] getColumnNames();

    public abstract int getCount();

    public abstract double getDouble(int i);

    public abstract float getFloat(int i);

    public abstract int getInt(int i);

    public abstract long getLong(int i);

    public abstract short getShort(int i);

    public abstract String getString(int i);

    public abstract boolean isNull(int i);

    public int getType(int i) {
        return 3;
    }

    public byte[] getBlob(int i) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    public CursorWindow getWindow() {
        return null;
    }

    public int getColumnCount() {
        return getColumnNames().length;
    }

    public void deactivate() {
        onDeactivateOrClose();
    }

    /* Access modifiers changed, original: protected */
    public void onDeactivateOrClose() {
        if (this.mSelfObserver != null) {
            this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    public boolean requery() {
        if (!(this.mSelfObserver == null || this.mSelfObserverRegistered)) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        onDeactivateOrClose();
    }

    public boolean onMove(int i, int i2) {
        return true;
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        String string = getString(i);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr == null || cArr.length < string.length()) {
                charArrayBuffer.data = string.toCharArray();
            } else {
                string.getChars(0, string.length(), cArr, 0);
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    public final int getPosition() {
        return this.mPos;
    }

    public boolean moveToPosition(int i) {
        int count = getCount();
        if (i >= count) {
            this.mPos = count;
            return false;
        } else if (i < 0) {
            this.mPos = -1;
            return false;
        } else if (i == this.mPos) {
            return true;
        } else {
            boolean onMove = onMove(this.mPos, i);
            if (onMove) {
                this.mPos = i;
                if (this.mRowIdColumnIndex == -1) {
                    return onMove;
                }
                this.mCurrentRowID = Long.valueOf(getLong(this.mRowIdColumnIndex));
                return onMove;
            }
            this.mPos = -1;
            return onMove;
        }
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i, cursorWindow);
    }

    public final boolean move(int i) {
        return moveToPosition(this.mPos + i);
    }

    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    public final boolean isLast() {
        int count = getCount();
        return this.mPos == count + -1 && count != 0;
    }

    public final boolean isBeforeFirst() {
        if (getCount() == 0 || this.mPos == -1) {
            return true;
        }
        return false;
    }

    public final boolean isAfterLast() {
        if (getCount() == 0 || this.mPos == getCount()) {
            return true;
        }
        return false;
    }

    public int getColumnIndex(String str) {
        int i = 0;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exception = new Exception();
            Log.e(TAG, "requesting column name with table name -- ".concat(String.valueOf(str)), exception);
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        while (i < length) {
            if (columnNames[i].equalsIgnoreCase(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    public String getColumnName(int i) {
        return getColumnNames()[i];
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (!this.mClosed) {
            this.mContentObservable.unregisterObserver(contentObserver);
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    /* Access modifiers changed, original: protected */
    public void onChange(boolean z) {
        synchronized (this.mSelfObserverLock) {
            this.mContentObservable.dispatchChange(z);
            if (this.mNotifyUri != null && z) {
                this.mContentResolver.notifyChange(this.mNotifyUri, this.mSelfObserver);
            }
        }
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            this.mNotifyUri = uri;
            this.mContentResolver = contentResolver;
            if (this.mSelfObserver != null) {
                this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
            }
            this.mSelfObserver = new SelfContentObserver(this);
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
            this.mSelfObserverRegistered = true;
        }
    }

    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public boolean isFieldUpdated(int i) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public Object getUpdatedField(int i) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        if (this.mSelfObserver != null && this.mSelfObserverRegistered) {
            this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
        }
        try {
            if (!this.mClosed) {
                close();
            }
        } catch (Exception e) {
        }
    }
}
