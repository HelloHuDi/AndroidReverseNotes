package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
    private boolean mWantsAllOnMoveCalls;

    public BulkCursorToCursorAdaptor() {
        AppMethodBeat.m2504i(11974);
        AppMethodBeat.m2505o(11974);
    }

    public final void initialize(BulkCursorDescriptor bulkCursorDescriptor) {
        AppMethodBeat.m2504i(11975);
        this.mBulkCursor = bulkCursorDescriptor.cursor;
        this.mColumns = bulkCursorDescriptor.columnNames;
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        this.mWantsAllOnMoveCalls = bulkCursorDescriptor.wantsAllOnMoveCalls;
        this.mCount = bulkCursorDescriptor.count;
        if (bulkCursorDescriptor.window != null) {
            setWindow(bulkCursorDescriptor.window);
        }
        AppMethodBeat.m2505o(11975);
    }

    public final IContentObserver getObserver() {
        AppMethodBeat.m2504i(11976);
        try {
            IContentObserver iContentObserver = (IContentObserver) this.mObserverBridge.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.mObserverBridge, new Object[0]);
            AppMethodBeat.m2505o(11976);
            return iContentObserver;
        } catch (Exception e) {
            AppMethodBeat.m2505o(11976);
            return null;
        }
    }

    private void throwIfCursorIsClosed() {
        AppMethodBeat.m2504i(11977);
        if (this.mBulkCursor == null) {
            StaleDataException staleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
            AppMethodBeat.m2505o(11977);
            throw staleDataException;
        }
        AppMethodBeat.m2505o(11977);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(11978);
        throwIfCursorIsClosed();
        int i = this.mCount;
        AppMethodBeat.m2505o(11978);
        return i;
    }

    public final boolean onMove(int i, int i2) {
        AppMethodBeat.m2504i(11979);
        throwIfCursorIsClosed();
        try {
            if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
                setWindow(this.mBulkCursor.getWindow(i2));
            } else if (this.mWantsAllOnMoveCalls) {
                this.mBulkCursor.onMove(i2);
            }
            if (this.mWindow == null) {
                AppMethodBeat.m2505o(11979);
                return false;
            }
            AppMethodBeat.m2505o(11979);
            return true;
        } catch (RemoteException e) {
            Log.m9444e(TAG, "Unable to get window because the remote process is dead");
            AppMethodBeat.m2505o(11979);
            return false;
        }
    }

    public final void deactivate() {
        AppMethodBeat.m2504i(11980);
        super.deactivate();
        if (this.mBulkCursor != null) {
            try {
                this.mBulkCursor.deactivate();
                AppMethodBeat.m2505o(11980);
                return;
            } catch (RemoteException e) {
                Log.m9452w(TAG, "Remote process exception when deactivating");
            }
        }
        AppMethodBeat.m2505o(11980);
    }

    public final void close() {
        AppMethodBeat.m2504i(11981);
        super.close();
        if (this.mBulkCursor != null) {
            try {
                this.mBulkCursor.close();
            } catch (RemoteException e) {
                Log.m9452w(TAG, "Remote process exception when closing");
            } finally {
                this.mBulkCursor = null;
                AppMethodBeat.m2505o(11981);
            }
            return;
        }
        AppMethodBeat.m2505o(11981);
    }

    public final boolean requery() {
        AppMethodBeat.m2504i(11982);
        throwIfCursorIsClosed();
        try {
            this.mCount = this.mBulkCursor.requery(getObserver());
            if (this.mCount != -1) {
                this.mPos = -1;
                closeWindow();
                super.requery();
                AppMethodBeat.m2505o(11982);
                return true;
            }
            deactivate();
            AppMethodBeat.m2505o(11982);
            return false;
        } catch (Exception e) {
            Log.m9444e(TAG, "Unable to requery because the remote process exception " + e.getMessage());
            deactivate();
            AppMethodBeat.m2505o(11982);
            return false;
        }
    }

    public final String[] getColumnNames() {
        AppMethodBeat.m2504i(11983);
        throwIfCursorIsClosed();
        String[] strArr = this.mColumns;
        AppMethodBeat.m2505o(11983);
        return strArr;
    }

    public final Bundle getExtras() {
        AppMethodBeat.m2504i(11984);
        throwIfCursorIsClosed();
        try {
            Bundle extras = this.mBulkCursor.getExtras();
            AppMethodBeat.m2505o(11984);
            return extras;
        } catch (RemoteException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(11984);
            throw runtimeException;
        }
    }

    public final Bundle respond(Bundle bundle) {
        AppMethodBeat.m2504i(11985);
        throwIfCursorIsClosed();
        Bundle respond;
        try {
            respond = this.mBulkCursor.respond(bundle);
            AppMethodBeat.m2505o(11985);
            return respond;
        } catch (RemoteException e) {
            Log.m9453w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            respond = Bundle.EMPTY;
            AppMethodBeat.m2505o(11985);
            return respond;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
