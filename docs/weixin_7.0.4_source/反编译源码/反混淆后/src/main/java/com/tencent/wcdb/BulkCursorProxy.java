package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras = null;
    private IBinder mRemote;

    public BulkCursorProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final CursorWindow getWindow(int i) {
        AppMethodBeat.m2504i(11967);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeInt(i);
            this.mRemote.transact(1, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            CursorWindow cursorWindow = null;
            if (obtain2.readInt() == 1) {
                cursorWindow = CursorWindow.newFromParcel(obtain2);
            }
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11967);
            return cursorWindow;
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11967);
        }
    }

    public final void onMove(int i) {
        AppMethodBeat.m2504i(11968);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeInt(i);
            this.mRemote.transact(4, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11968);
        }
    }

    public final void deactivate() {
        AppMethodBeat.m2504i(11969);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(2, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11969);
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(11970);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(7, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11970);
        }
    }

    public final int requery(IContentObserver iContentObserver) {
        AppMethodBeat.m2504i(11971);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            int readInt;
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeStrongInterface(iContentObserver);
            boolean transact = this.mRemote.transact(3, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            if (transact) {
                readInt = obtain2.readInt();
                this.mExtras = obtain2.readBundle(getClass().getClassLoader());
            } else {
                readInt = -1;
            }
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11971);
            return readInt;
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11971);
        }
    }

    public final Bundle getExtras() {
        AppMethodBeat.m2504i(11972);
        if (this.mExtras == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IBulkCursor.descriptor);
                this.mRemote.transact(5, obtain, obtain2, 0);
                DatabaseUtils.readExceptionFromParcel(obtain2);
                this.mExtras = obtain2.readBundle(getClass().getClassLoader());
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                AppMethodBeat.m2505o(11972);
            }
        }
        Bundle bundle = this.mExtras;
        AppMethodBeat.m2505o(11972);
        return bundle;
    }

    public final Bundle respond(Bundle bundle) {
        AppMethodBeat.m2504i(11973);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeBundle(bundle);
            this.mRemote.transact(6, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            Bundle readBundle = obtain2.readBundle(getClass().getClassLoader());
            return readBundle;
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.m2505o(11973);
        }
    }
}
